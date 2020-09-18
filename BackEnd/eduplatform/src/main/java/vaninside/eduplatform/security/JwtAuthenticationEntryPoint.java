package vaninside.eduplatform.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import vaninside.eduplatform.payload.ApiResponse;


// ���࿡ �㰡���� ���� ����ڰ� �����Ϸ��� ���� ��,���ܰ� throw �Ǹ� ȣ��Ǵ� �޼ҵ� �Դϴ�.
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	// ���⼭�� 401 ������ ��ȯ�ϵ��� �����Ǿ� ����.
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) throws IOException, ServletException {
		response.setStatus(200);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new ApiResponse(false, "authentication fail", 0).toStr());
	}

}
