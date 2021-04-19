<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista de Compras</title>
<link rel="icon" href="imagens/buying_car.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar produto</h1>
	<form name="frmProduto" action="update">
		<table>
			<tr>
				<td><input type="text" name="idProduto" id="caixa3" readonly
					value="<%out.print(request.getAttribute("idProduto"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="quantidade" class="Caixa2"
					value="<%out.print(request.getAttribute("quantidade"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="valor" class="Caixa1"
					value="<%out.print(request.getAttribute("valor"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>