package br.com.ebix.seguro.service.seguros;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.entity.Seguro;
import br.com.ebix.seguro.persistence.SeguroPersistence;
import br.com.ebix.seguro.service.Action;

public class AlteraSeguro implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nomeseguro");
		String valor = request.getParameter("valor");
		String idparam = request.getParameter("id");

		SeguroPersistence dao = new SeguroPersistence();
		Integer id = Integer.valueOf(idparam);
		Seguro seguro = dao.findById(id);

		seguro.setNomeSeguro(nome);
		seguro.setValorSeguro(new BigDecimal(valor));
		
		dao.update(seguro);

		return "rd:seguros?action=ServiceListaSeguros";
	}

}
