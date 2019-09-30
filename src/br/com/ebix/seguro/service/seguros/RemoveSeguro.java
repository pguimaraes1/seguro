package br.com.ebix.seguro.service.seguros;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.GroupLayout.SequentialGroup;

import br.com.ebix.seguro.persistence.SeguradoPersistence;
import br.com.ebix.seguro.persistence.SeguroPersistence;
import br.com.ebix.seguro.service.Action;

public class RemoveSeguro implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
			String paramId = request.getParameter("id");
			Integer id = Integer.valueOf(paramId);
			SeguroPersistence dao = new SeguroPersistence();
			dao.delete(id);
		return "rd:seguros?action=ServiceListaSeguros";
	}
	
	
	
}
