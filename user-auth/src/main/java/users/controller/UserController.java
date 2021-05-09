package users.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import users.configure.JwtTokenUtil;
import users.constant.SecurityConstant;
import users.service.UserService;

@RestController
@RequestMapping("college-quiz")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PostMapping("/login")
	public ResponseEntity<LoginStatus> createAuthenticationToken(@Valid @RequestBody UserCredential userCredentail,
			HttpServletResponse response) throws Exception {

		String username = userService.findByUserNameAndPassword(userCredentail.getUserName(),
				userCredentail.getPassword());

		String jwtToken = jwtTokenUtil.generateToken(username);

		LoginStatus loginStatus = new LoginStatus();

		loginStatus.setStatus(true);
		loginStatus.setMessage("Successfull");
		loginStatus.setToken(jwtToken);

		response.setHeader(SecurityConstant.JWT_HEADER_RESPONSE, jwtToken);
		return new ResponseEntity<>(loginStatus, HttpStatus.OK);
	}
}