<%@page import="com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
    @ SuppressWarnings ("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de Compra</title>
<link rel="icon" href="imagens/buying_car.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista de compra</h1>
	<a href="novo.html" class="Botao1">Novo produto</a>
	<a href="report" class="Botao2"> Relatório </a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Código do Produto</th>
				<th>Nome do Produto</th>
				<th>Quantidade do Produto</th>
				<th>Preço do Produto</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdProduto()%></td>
				<td><%=lista.get(i).getNomeProduto()%></td>
				<td><%=lista.get(i).getQuantProduto()%></td>
				<td><%=lista.get(i).getPrecoProduto()%></td>
				<td>
				    <a href="select?idProduto=<%=lista.get(i).getIdProduto() %>" class="Botao1">Editar</a>
				    <a href="javascript: confirmar(<%=lista.get(i).getIdProduto() %>)" class="Botao2">Excluir</a>
				</td>
			</tr>
			<%
				}
			%>
			
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>
