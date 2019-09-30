package br.com.ebix.seguro.controllers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AutenticationFilter implements Filter {

	public AutenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;

		String paramAction = request.getParameter("action");

		HttpSession session = request.getSession();
		boolean usuarioNaoLogado = (session.getAttribute("usuarioLogado") == null);
		boolean isProtectedAction = !(paramAction != null && (paramAction.equals("Login") || paramAction.equals("LoginForm")));
		if (isProtectedAction && usuarioNaoLogado) {
			response.sendRedirect("login?action=LoginForm");
			return;
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
