<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<h5 class="card-title text-center">Cadastro</h5>
						<form  method="post" action="ServiceCadastraSeguro">
							<div class="form-group">
								<label for="nome">Nome</label> <input type="text"
									class="form-control" id="nome" name="nome"
									placeholder="Seu nome" value="${param.nome}">
							</div>
							<div class="form-group">
								<label for="cpf">Cpf</label> <input type="text"
									class="form-control" id="cpf" name="cpf" placeholder="Seu cpf" value="${param.cpf}">
							</div>
							<div class="form-group">
								<label for="rg">Rg</label> <input type="text"
									class="form-control" id="rg" name="rg" placeholder="Seu rg" value="${param.rg}">
							</div>
							<div class="form-group">
								<label>Sexo</label> <br> <input type="radio" name="sexo"
									value="masculino"${param.sexo == 'masculino' ? 'checked' : ''}> masculino<br> <input
									type="radio" name="sexo" value="feminino" ${param.sexo == 'feminino' ? 'checked' : ''}> feminino<br>
							</div>

							<div class="form-group">
								<label for="correntista">Correntista</label>
								<select class="form-control" id="correntista" name="correntista">
									<option value="sim" ${param.correntista == 'sim' ? 'selected' : ''}>Sim</option>
									<option value="nao" ${param.correntista == 'nao' ? 'selected' : ''}>Não</option>
								</select>
							</div>
							
							Seguros:<br>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="seguro" name="seguro" value="auto"  ${paramValues.seguro.stream().anyMatch(v->v == 'auto').get() ? 'checked' : ''}> 
									<label class="form-check-label" for="defaultCheck1" > Auto </label>
									<br>
								<input class="form-check-input" type="checkbox" id="seguro" name="seguro"  value="vida" ${paramValues.seguro.stream().anyMatch(v->v == 'vida').get() ? 'checked' : ''}> 
									<label class="form-check-label" for="defaultCheck1"> Vida </label>
									<br>
								<input class="form-check-input" type="checkbox" id="seguro" name="seguro"  value="residencia" ${paramValues.seguro.stream().anyMatch(v->v == 'residencia').get() ? 'checked' : ''}> 
									<label class="form-check-label" for="defaultCheck1"> Residência </label>
							</div>
							
							<br>Dias de visita: <br>
							  <div class="form-group">
							    <select multiple class="form-control" id="diasdevisita" name="diasdevisita">
							      <option value="segunda" ${paramValues.diasdevisita.stream().anyMatch(v->v == 'segunda').get() ? 'selected' : ''}>Segunda</option>
							      <option value="terca" ${paramValues.diasdevisita.stream().anyMatch(v->v == 'terca').get() ? 'selected' : ''}>Terca</option>
							      <option value="quarta" ${paramValues.diasdevisita.stream().anyMatch(v->v == 'quarta').get() ? 'selected' : ''}>Quarta</option>
							      <option value="quinta" ${paramValues.diasdevisita.stream().anyMatch(v->v == 'quinta').get() ? 'selected' : ''}>Quinta</option>
							      <option value="sexta" ${paramValues.diasdevisita.stream().anyMatch(v->v == 'sexta').get() ? 'selected' : ''}>Sexta</option>
							    </select>
							  </div>
							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Cadastrar</button>
						</form>
					</div>
					  <div class="card-footer">
						${error}
 					  </div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>