
package users.configure;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTTockenGeneratorFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String tocken = request.getHeader(SecurityConstant.JWT_HEADER);

		if (tocken == null) {

			String jwt = jwtTokenUtil.generateToken("ankit07");

			response.setHeader(SecurityConstant.JWT_HEADER, jwt);

		}

		filterChain.doFilter(request, response);

	}

	@Override
	public boolean shouldNotFilter(HttpServletRequest request) {
		return request.getServletPath().equals("/login");
	}

}
