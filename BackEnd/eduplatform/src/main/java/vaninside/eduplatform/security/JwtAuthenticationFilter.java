package vaninside.eduplatform.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
// jwt�� ��ȿ�� ��ū���� �����ϱ� ���� Filter
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private MyUserDetailService customUserDetailsService;

	 private String getJwtFromRequest(HttpServletRequest request) {
	     String bearerToken = request.getHeader("Authorization");
	     if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
	         return bearerToken.substring(7, bearerToken.length());
	     }
	     return null;
	 }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
	        String jwt = getJwtFromRequest(request);
	
	        if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
	            int userId = tokenProvider.getUserIdFromJWT(jwt);
	
	            UserDetails userDetails = customUserDetailsService.loadUserById(userId);
	            System.out.println(userDetails.getAuthorities());
	            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        }
	    } catch (Exception ex) {
	        System.out.println("Could not set user authentication in security context");
	    }
	
	    filterChain.doFilter(request, response);
		
	}
}