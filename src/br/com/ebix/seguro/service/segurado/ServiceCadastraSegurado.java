package br.com.ebix.seguro.service.segurado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.entity.DiasVisita;
import br.com.ebix.seguro.entity.Segurado;
import br.com.ebix.seguro.entity.Seguro;
import br.com.ebix.seguro.persistence.SeguradoPersistence;
import br.com.ebix.seguro.service.Action;

public class ServiceCadastraSegurado implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		Segurado segurado = new Segurado();
		SeguradoPersistence persist = new SeguradoPersistence();
		
		segurado.setNome(request.getParameter("nome"));
		segurado.setCpf(request.getParameter("cpf"));
		segurado.setRg(request.getParameter("rg"));
		segurado.setDataCadastro(Calendar.getInstance());
		segurado.setDataAlteracao(Calendar.getInstance());
		String[] days = request.getParameterValues("diasdevisita");
		segurado.setDiasVisita(segurado.stringVec(days));	
		
		String[] segurosString = request.getParameterValues("seguro");
		List<Seguro> seguros = new ArrayList<>();
		for (String idseguro : segurosString) {
			Seguro seguro = new Seguro();
			seguro.setIdSeguro(Integer.valueOf(idseguro));
			seguros.add(seguro);
		}
		segurado.setSeguros(seguros);
		
		String tipoSegurado = request.getParameter("correntista");
		segurado.checkTipoSegurado(tipoSegurado);
		String sexo = request.getParameter("sexo");
		segurado.checkSexo(sexo);
		persist.create(segurado);
		return "rd:segurados?action=ServiceListaSegurados";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// seg.setNomeSeguro(request.getParameter("nomeseguro"));

		return "rd:segurados?action=ServiceListaSegurados";
	}

}
