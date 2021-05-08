package users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("college-quiz")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	@PreFilter("userCredentail==authentication.getUsername()")
	public void createAuthenticationToken(@Valid @RequestBody UserCredential userCredentail, HttpServletRequest request)
			throws Exception {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userCredentail.getUserName(), userCredentail.getPassword()));

	}
}