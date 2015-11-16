<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%> 
    <%@ page import="java.util.ArrayList"%> 
    <%@ page import="services.Volume"%> 
    <%@ page import="dao.BancoDados"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="estilo_admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca</title>
</head>
<body>
	
	<h1>Resultado da Consulta</h1>
	<% 	
		BancoDados bd = new BancoDados();
		ArrayList <Volume> volumes = new ArrayList<Volume>();
		Volume vol = new Volume();	
		String titulo = request.getParameter("titulo");
	//Consulta JDBC
			bd.abrirConexao();
			String sql = "SELECT * FROM volume WHERE titulo = '" + titulo + "'";
			ResultSet rs = bd.consultaBanco(sql);
			
			try {
				while (rs.next()){
					vol.setVolume(rs.getString("titulo"), rs.getString("tipo_volume"), rs.getString("descricao"), 
							rs.getString("editora"), rs.getString("autor"), 
							rs.getString("ano"), rs.getInt("paginas"));
					volumes.add(vol);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bd.fecharConexao();
			%>
			<table>
				<tr>
					<th>Volumes Encontrados</th>
				</tr>
					
				<%for(Volume v: volumes){%>
				<tr>
					<%	
						
					%>
					<td><%= v.getTitulo() %></td>
					<td><%= v.getDescricao() %></td>
					<td><%= v.getTipo() %></td>
					<td><%= v.getAutor() %></td>
					<td><%= v.getEditora() %></td>
					<td><%= v.getPag() %></td>
					<td><%= v.getAno() %></td>
				</tr>
					
				<%}%>
					
			</table>

	<form action="logoutServlet" method="get">
		<input id="logout" name="" type="button" class="btn btn-info"
			onclick="location.href='index.html' " value="Logout">
	</form>
	
</body>
</html>