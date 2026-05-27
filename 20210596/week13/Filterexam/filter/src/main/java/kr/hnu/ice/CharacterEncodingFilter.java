package kr.hnu.ice;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * /myf와 /newf 경로에 대한 한글 처리 Filter
 * Annotation 방식으로 구현
 */
@WebFilter(urlPatterns = {"/myf", "/newf"})
public class CharacterEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CharacterEncodingFilter 초기화");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 응답에 대한 한글 처리
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("Filter - 한글 처리 적용");
		
		// 다음 Filter 또는 Servlet으로 요청 전달
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("CharacterEncodingFilter 소멸");
	}
}
