package br.com.ebix.seguro.service.segurado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.seguro.entity.DiasVisita;
import br.com.ebix.seguro.entity.Seguro;
import br.com.ebix.seguro.entity.TipoSegurado;
import br.com.ebix.seguro.entity.TipoSexo;
import br.com.ebix.seguro.persistence.SeguroPersistence;
import br.com.ebix.seguro.service.Action;

public class CadastroSeguradoForm implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SeguroPersistence segpers = new SeguroPersistence();
		List<Seguro> seguros = new ArrayList<Seguro>();
		seguros = segpers.findAll();
		request.setAttribute("seguros", seguros);

		List<DiasVisita> diasVisita = Arrays.asList(DiasVisita.values());
		request.setAttribute("dias", diasVisita);

		List<TipoSexo> generos = Arrays.asList(TipoSexo.values());
		request.setAttribute("generos", generos);

		List<TipoSegurado> tipoSegurado = Arrays.asList(TipoSegurado.values());
		request.setAttribute("tipos", tipoSegurado);

		return "fw:cadastroSegurados.jsp";

	}

}
