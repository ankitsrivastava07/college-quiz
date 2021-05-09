/*
 * package users.service;
 * 
 * import java.util.ArrayList;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.AuthenticationProvider; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class AuthenticationProviderImpl implements
 * AuthenticationProvider {
 * 
 * @Autowired private UserService userService;
 * 
 * @Override public Authentication authenticate(Authentication authentication)
 * throws AuthenticationException {
 * 
 * String username = authentication.getName(); String password =
 * authentication.getCredentials().toString();
 * 
 * userService.findByUserNameAndPassword(username, password);
 * 
 * return new UsernamePasswordAuthenticationToken(username, password, new
 * ArrayList<>());
 * 
 * }
 * 
 * @Override public boolean supports(Class<?> authentication) { return
 * authentication.equals(UsernamePasswordAuthenticationToken.class); }
 * 
 * }
 */