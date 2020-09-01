package vaninside.eduplatform.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


// ���࿡ �㰡���� ���� ����ڰ� �����Ϸ��� ���� ��,���ܰ� throw �Ǹ� ȣ��Ǵ� �޼ҵ� �Դϴ�.
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	// ���⼭�� 401 ������ ��ȯ�ϵ��� �����Ǿ� ����.
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) throws IOException, ServletException {
		//logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
	}

}
