package br.com.ebix.seguro.service.seguros;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.entity.Seguro;
import br.com.ebix.seguro.persistence.SeguroPersistence;
import br.com.ebix.seguro.service.Action;

public class ServiceCadastraSeguro implements Action {

	@SuppressWarnings("unused")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Seguro seguro = new Seguro();
			seguro.setNomeSeguro(request.getParameter("nomeseguro"));
			seguro.setValorSeguro(new BigDecimal(request.getParameter("valor")));
			if (seguro != null) {
				SeguroPersistence segpers = new SeguroPersistence();
				segpers.create(seguro);
				request.setAttribute("seguro", seguro);
				return "rd:seguros?action=ServiceListaSeguros";
			}
		} catch (Exception e) {
			request.setAttribute("msg", "Erro ao gravar!");
			return "fw:cadastroSeguros.jsp";
		}
		return "fw:cadastroSeguros.jsp";
	}

}
