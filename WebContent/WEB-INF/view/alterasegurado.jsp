<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, br.com.ebix.seguro.entity.Seguro"%>
<c:url value="/segurados" var="linkServletSegurados" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<c:import url="logout-type.jsp"></c:import>
				<div class="card my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Cadastro</h5>
						<form method="post" action="${linkServletSegurados}">
							<div class="form-group">
								<label for="nome">Nome</label> <input type="text"
									class="form-control" id="nome" name="nome"
									placeholder="Seu nome" value="${segurado.nome}">
							</div>
							<div class="form-group">
								<label for="cpf">Cpf</label> <input type="text"
									class="form-control" id="cpf" name="cpf" placeholder="Seu cpf"
									value="${segurado.cpf}">
							</div>
							<div class="form-group">
								<label for="rg">Rg</label> <input type="text"
									class="form-control" id="rg" name="rg" placeholder="Seu rg"
									value="${segurado.rg}">
							</div>
							<div class="form-group">
								<label>Sexo</label> <br>
								<c:forEach items="${generos}" var="genero">
									<input type="radio" name="sexo" value="${genero.value}"
										${segurado.sexo == '${genero.value}' ? 'checked' : ''}>
								${genero.value}<br>
								</c:forEach>
							</div>

							<div class="form-group">
								<label for="correntista">Correntista</label> <select
									class="form-control" id="correntista" name="correntista">
									<c:forEach items="${tipos}" var="tipo">
										<option value="${tipo.value}"
											${segurado.correntista == '${tipo.value}' ? 'selected' : ''}>${tipo.value}</option>
									</c:forEach>
								</select>
							</div>

							Seguros:<br>

							<div class="form-check">

								<c:forEach items="${seguros}" var="seguro">
									<input class="form-check-input" type="checkbox" id="seguro"
										name="seguro" value="${seguro.id}"
										${segurado.seguro.stream().anyMatch(v->v == '${seguro.id}').get() ? 'checked' : ''}>
									<label class="form-check-label" for="defaultCheck1">
										${seguro.nomeSeguro} </label>
									<br>
								</c:forEach>
							</div>
							<br>Dias de visita: <br>
							<div class="form-group">
								<select multiple class="form-control" id="diasdevisita"
									name="diasdevisita">
									<c:forEach items="${dias}" var="dia">
										<option value="${dia.value }"
											${segurado.diasdevisita.stream().anyMatch(v->v == '${dia.value}').get() ? 'selected' : ''}>${dia.value }</option>
									</c:forEach>
								</select>
							</div>
							<input type="hidden" name="id" value="${segurado.id }"> 
							<input type="hidden" name="action" value="ServiceCadastraSegurado">
							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Alterar</button>
						</form>
					</div>
					<div class="card-footer">${error}</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>