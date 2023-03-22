<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Usuario</title>
</head>
<body>

	<%
	int id = (int) request.getAttribute("id");
	String nombre = (String) request.getAttribute("nombre");
	%>

	<form method="POST" action="ModUsuario">
	<h3></h3>
	<input type="hidden" name="id" value="<%out.print(id);%>">
	<input type="text" name="nombre" placeholder="nombre de usuario" value="<%out.print(nombre);%>"/>
		
	<input type="submit" value="Enviar"/>
	</form>

</body>
</html>