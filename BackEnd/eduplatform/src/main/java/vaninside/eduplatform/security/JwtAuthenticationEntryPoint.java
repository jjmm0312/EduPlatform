package vaninside.eduplatform.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


// 만약에 허가되지 않은 사용자가 접근하려고 했을 떄,예외가 throw 되면 호출되는 메소드 입니다.
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	// 여기서는 401 에러를 반환하도록 구성되어 있음.
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) throws IOException, ServletException {
		//logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
	}

}
