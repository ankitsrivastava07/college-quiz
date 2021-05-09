package quiz.controller.home;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import quiz.response.LoginStatus;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

	private AuthenticationManager authentication;

	@GetMapping("/home")
	public ModelAndView home() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");

		return mv;
	}

	@GetMapping("/register")
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");

		return mv;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserCredential userCredential, HttpServletRequest request)
			throws JsonProcessingException {

		String url = "http://localhost:8081/college-quiz/login";

		ObjectMapper objectMapper = new ObjectMapper();

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<LoginStatus> entity = null;

		try {
			entity = restTemplate.postForEntity(url, userCredential, LoginStatus.class);

		} catch (HttpServerErrorException e) {
			System.out.println(restTemplate.getClientHttpRequestInitializers().toString());
			System.out.println(e.getResponseBodyAsString());
		}

		LoginStatus loginStatus = new LoginStatus();

		loginStatus.setMessage(entity.getBody().getMessage());

		loginStatus.setToken(entity.getBody().getToken());

		loginStatus.setStatus(entity.getBody().isStatus());

		// loginStatus.setStatus(status);

		// Car car = objectMapper.readValue(json, Car.class);

		return new ResponseEntity<>(loginStatus, HttpStatus.OK);
	}

}