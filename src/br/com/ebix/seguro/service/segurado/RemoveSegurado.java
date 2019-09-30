package br.com.ebix.seguro.service.segurado;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.persistence.SeguradoPersistence;
import br.com.ebix.seguro.service.Action;

public class RemoveSegurado implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
			String paramId = request.getParameter("id");
			Integer id = Integer.valueOf(paramId);
			SeguradoPersistence dao = new SeguradoPersistence();
			dao.delete(id);
		return "rd:segurados?action=ServiceListaSegurados";
	}
	
	
	
}
