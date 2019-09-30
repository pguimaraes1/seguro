package br.com.ebix.seguro.service.seguros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.entity.Seguro;
import br.com.ebix.seguro.persistence.SeguroPersistence;
import br.com.ebix.seguro.service.Action;

public class ServiceListaSeguros implements Action  {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			SeguroPersistence segpers = new SeguroPersistence();
			List<Seguro> seguros = new ArrayList<Seguro>();
			seguros = segpers.findAll();
			request.setAttribute("seguros", seguros);
		return "fw:listaSeguros.jsp";
		
	}

}
