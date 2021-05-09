
package quiz.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import quiz.constant.SecurityConstant;
import quiz.jwtutil.JwtTokenUtil;

@Component
public class JWTTockenGeneratorFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String username = request.getParameter("userName");

		String tocken = request.getHeader(SecurityConstant.JWT_HEADER_REQUEST);

		if (tocken == "undefined") {
			String jwt = jwtTokenUtil.generateToken(username);
			response.setHeader(SecurityConstant.JWT_HEADER_RESPONSE, jwt);
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					username, null, new ArrayList<>());
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}

		filterChain.doFilter(request, response);

	}

	// AuthServer

	// Client --->Service Provider(App1)==/assets(token)---->AuthServer(token)
	// AUthSerer --> IsvalidToken(token)===>details users return
	// App--> proceed with user details and return response
	// otherwise return login page(403)
	// serv1,server2

	@Override
	public boolean shouldNotFilter(HttpServletRequest request) {
		return request.getServletPath().equals("/login");
	}

}
