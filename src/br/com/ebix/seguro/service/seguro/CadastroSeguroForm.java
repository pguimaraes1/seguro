package br.com.ebix.seguro.service.seguro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.service.Action;

public class CadastroSeguroForm implements Action  {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "fw:cadastroSeguros.jsp";
		
	}

}
