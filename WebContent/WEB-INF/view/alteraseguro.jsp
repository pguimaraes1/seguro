<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page import="java.util.List, br.com.ebix.seguro.entity.Seguro"%>
<c:url value="/seguros" var="linkServletSeguros" />
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
				<div class="card my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Cadastro Seguro</h5>
						<form  method="post" action="${linkServletSeguros}">
							<div class="form-group">
								<label for="nomeseguro">Identificacao</label> <input type="text"
									class="form-control" id="nomeseguro" name="nomeseguro"
									placeholder="Seu nome" value="${seguro.nomeSeguro}">
							</div>
							<div class="form-group">
								<label for="valor">valor</label> <input type="text"
									class="form-control" id="valor" name="valor" placeholder="Valor" value="${seguro.valorSeguro}">
							</div>
							<input type="hidden" name="id" value="${seguro.id }"> 
							<input type="hidden" name="action" value="AlteraSeguro">
							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Alterar</button>
						</form>
					</div>
					  <div class="card-footer">
						
 					  </div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>