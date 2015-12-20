package cn.manger.shiro;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import cn.manger.model.Tadmin;
import cn.manger.service.Service;

public class AuthenticationFilter extends FormAuthenticationFilter {

	@Resource
	private Service service;

	public AuthenticationFilter() {
	}

	// 判断请求是否被拒绝
	@Override
	protected boolean onAccessDenied(ServletRequest servletRequest,
			ServletResponse response) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		/*
		 * if(StringUtils.isNoneBlank(username)&&StringUtils.isNoneBlank(password
		 * )){
		 * 
		 * } return false;
		 */
		return super.onAccessDenied(request, response);
	}// 462050246

	// 提交表单的时候如果没有被拒绝创建调用
	@Override
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String username = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");
		return new TokenAuthentication(username, password, true);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest servletRequest,
			ServletResponse servletResponse) throws Exception {
		Session session = subject.getSession();
		TokenAuthentication authenticationToken = (TokenAuthentication) token;
		String username = authenticationToken.getUsername();
		Tadmin sessionUser = (Tadmin) service.find(Tadmin.class,
				Tadmin.USER_NAME, username);
		session.setAttribute("sessionUser", sessionUser);
		return super.onLoginSuccess(token, subject, servletRequest,
				servletResponse);
	}
}
