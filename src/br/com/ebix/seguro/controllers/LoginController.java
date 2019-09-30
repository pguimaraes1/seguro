package br.com.ebix.seguro.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.service.Action;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAction = request.getParameter("action");
		String name = null;
		String nomeDaClasse = "br.com.ebix.seguro.service.login." + paramAction;

		try {
			Class classe = Class.forName(nomeDaClasse);
			Action actionimpl = (Action) classe.newInstance(); // reflect
			name = actionimpl.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] requestType = name.split(":");
		if (requestType[0].equals("fw")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + requestType[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(requestType[1]);
		}

	}

}
