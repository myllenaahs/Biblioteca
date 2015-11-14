<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ATIVIDADE</title>
</head>
<body>
	<h1>
		Olá, seja bem vindo
		<%=session.getAttribute("user")%></h1>

	<h2>Retirada</h2>
	<form action="retiradaServlet" method="get">
		<label>Titulo:<input type="text" name="titulo"></label> </label> <input
			type="submit" value="Pesquisar">
			
	<!-- Retirada do volume do bd -->
	
	</form>
	
	


</body>
</html>