package br.com.ebix.seguro.service.segurado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.entity.Segurado;
import br.com.ebix.seguro.persistence.SeguradoPersistence;
import br.com.ebix.seguro.persistence.SeguroPersistence;
import br.com.ebix.seguro.service.Action;

public class ServiceListaSegurados implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SeguradoPersistence dao = new SeguradoPersistence();
		List<Segurado> segurados = new ArrayList<>();
		segurados = dao.findAll();
		request.setAttribute("segurados", segurados);

		return "fw:listaSegurados.jsp";
	}

}
