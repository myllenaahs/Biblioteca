<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="estilo_boasVindas.css" />
<title>ATIVIDADE</title>
</head>
<body>
	<h1>
		Olá, seja bem vindo
		<%=session.getAttribute("nome")%></h1>



	<h2>Retirada</h2>
	<form action="retiradaServlet" method="get">
		<label>Titulo:<input type="text" name="titulo"></label> </label> <input
			type="submit" class="btn btn-success" value="Pesquisar">

		<!-- Retirada do volume do bd -->
	</form>
		

	<h2>Inserção</h2>	
	<form action="adminResources.html" method="post">	
		<input type="submit" value="Inserir">

		<!-- Inserção do volume do bd -->
	</form>
	
	<h2>Busca de Volume</h2>	
	<form action="exibeVolumes.jsp" method="post">	
		Titulo: <input type="text" name="titulo">
		<input type="submit" value="Buscar">
	</form>
	
	<input id='botao' name="" type="button" class="btn btn-success"
			onclick="location.href='index.html' "
			value="Logout">


</body>
</html>