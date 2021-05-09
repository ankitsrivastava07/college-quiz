/*
 * package users.configure;
 * 
 * import java.io.IOException; import java.util.ArrayList;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import users.constant.SecurityConstant; import users.service.UserService;
 * 
 * @Component public class JWTTockenValidatorFilter extends OncePerRequestFilter
 * {
 * 
 * @Autowired private JwtTokenUtil jwtTokenUtil;
 * 
 * @Autowired private UserService userService;
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException { String token =
 * request.getHeader(SecurityConstant.JWT_HEADER_REQUEST);
 * 
 * if (token != "undefined" && token != null && token.endsWith("Bearer ")) {
 * String userName = jwtTokenUtil.getUsernameFromToken(token); userName =
 * userService.findByUserName(userName);
 * 
 * UsernamePasswordAuthenticationToken user = new
 * UsernamePasswordAuthenticationToken(userName, null, new ArrayList<>());
 * 
 * SecurityContextHolder.getContext().setAuthentication(user);
 * 
 * } filterChain.doFilter(request, response); }
 * 
 * @Override public boolean shouldNotFilter(HttpServletRequest request) {
 * 
 * String url = request.getServletPath(); return
 * request.getServletPath().equals("/login"); }
 * 
 * }
 */