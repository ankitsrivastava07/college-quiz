package users.controller;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import users.configure.JwtTokenUtil;

@RestController
@RequestMapping("college-quiz")
@CrossOrigin("http://localhost:8080")
public class UserController {

	@Autowired
	private AuthenticationProvider authenticationProvider;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	// private UserDetailsService userDetailsService;

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody UserCredential userCredentail,
			HttpServletRequest request) throws Exception {

		authenticationProvider.authenticate(
				new UsernamePasswordAuthenticationToken(userCredentail.getUserName(), userCredentail.getPassword()));
		final String token = jwtTokenUtil.generateToken("ankit");
		String jwtSession = "college-quiz_sessionId";
		Cookie cookies[] = request.getCookies();

		if (Objects.nonNull(cookies))
			for (Cookie cookie : cookies) {

				if (cookie.getName().equalsIgnoreCase(jwtSession)) {

				}
			}

		return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
	}
}