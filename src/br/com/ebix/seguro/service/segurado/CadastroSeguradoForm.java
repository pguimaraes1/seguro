package br.com.ebix.seguro.service.segurado;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.service.Action;

public class CadastroSeguradoForm implements Action  {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "fw:cadastroSegurados.jsp";
		
	}

}
