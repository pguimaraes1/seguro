package br.com.ebix.seguro.service.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import br.com.ebix.seguro.persistence.LoginPersistence;
import br.com.ebix.seguro.service.Action;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 br.com.ebix.seguro.entity.User user = new br.com.ebix.seguro.entity.User();
		LoginPersistence persistence = new LoginPersistence();
		 user.setLogin(request.getParameter("username")); 
		 user.setSenha(request.getParameter("password"));
		 System.out.println(user.getLogin());
		 System.out.println(user.getSenha());
		 user = persistence.userExist(user);
		if (user != null) {
			System.out.println("Existe");
			HttpSession session = request.getSession(); //cookiehbom
			session.setAttribute("usuarioLogado", user.getLogin());
			System.out.println("Logado");
			return "fw:painel.jsp";
		} else {
			return "rd:login?action=LoginForm";
		}
		
	}

}
