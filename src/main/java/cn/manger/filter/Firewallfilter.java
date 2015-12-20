package cn.manger.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Firewallfilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// StringBuffer requestURL = httpServletRequest.getRequestURL();
		// if(requestURL.toString().contains("index")==true){
		// filterChain.doFilter(request, response);
		// System.out.println("filter1");
		// }
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
