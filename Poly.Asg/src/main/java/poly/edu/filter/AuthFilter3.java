package poly.edu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import poly.edu.common.SessionUtils;

/**
 * Servlet Filter implementation class AuthFilter3
 */
@WebFilter(urlPatterns = "/*")
public class AuthFilter3 extends HttpFilter implements Filter {
       
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setAttribute("isLogin", SessionUtils.islogin((HttpServletRequest) request));
		chain.doFilter(request, response);
	}

	
}


