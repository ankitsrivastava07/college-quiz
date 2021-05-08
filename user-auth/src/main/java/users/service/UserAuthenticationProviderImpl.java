package users.service;

import java.util.ArrayList;
import java.util.Objects;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import users.exceptionHandle.InvalidCredentialException;

@Component
@AllArgsConstructor
public class UserAuthenticationProviderImpl implements AuthenticationProvider {

	private UserService userService;

	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		String userName = userService.findByUserNameAndPassword(username, password);

		if (Objects.isNull(userName)) {
			throw new InvalidCredentialException("Invalid username/email and password which you have provided");
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
