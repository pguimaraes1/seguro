<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, br.com.ebix.seguro.entity.Seguro"%>
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
	<div id="main" class="container-fluid" style="margin-top: 50px">

		<div id="top" class="row">
			<div class="col-sm-3">
				<h2>Itens</h2>
			</div>
			<div class="col-sm-3">
				<a href="${pageContext.request.contextPath}/seguros?action=CadastroSeguroForm" class="btn btn-primary pull-right h2">Novo
					Seguro</a>
			</div>
			<div class="col-sm-3">
				<a href="${pageContext.request.contextPath}/painel.jsp" class="btn btn-primary pull-right h2">Início</a>
			</div>
			
		</div>
		<!-- /#top -->
		<hr />
		<div id="list" class="row">

			<div class="table-responsive col-md-12">
				<table class="table table-striped" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Descrição</th>
							<th>Valor</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${seguros}" var="seguro" >
							<tr>
								<td>${seguro.id}</td>
								<td>${seguro.nomeSeguro}</td>
								<td>${seguro.valorSeguro}</td>
								<td>
									<a class="btn btn-warning btn-xs" href="${pageContext.request.contextPath}/seguros?action=MostraSeguro&id=${seguro.id}">Editar</a> <a
									class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/seguros?action=RemoveSeguro&id=${seguro.id}">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
		<!-- /#list -->

		<!-- Modal -->
		<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="modalLabel">Excluir Item</h4>
					</div>
					<div class="modal-body">Deseja realmente excluir este item?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</div>
				</div>
			</div>
		</div>
</body>
</html>