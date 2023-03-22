<%@ page import="java.util.ArrayList"%>
<%@ page import= "modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Usuarios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

	<%	
	ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios"); 
	%>
<a href="/JSPusuarios/InsertarUsuario" style="text-decoration: none; color: green">Insertar</a>
<table class="table table-striped table-dark">
  <thead>
    
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Usuario</th>
      <th scope="col">Modificar</th>
      <th scope="col">Eliminar</th>
    </tr>
  </thead>
  <tbody>
  	<%for(Usuario usuario : usuarios){
    	%>
    <tr>
      <td><%out.println(usuario.getId()); %></td>
      <td><%out.println(usuario.getNombre()); %></td>
      <td><a href="/JSPusuarios/ModUsuario?id=<%out.print(usuario.getId());%>&nombre=<%out.print(usuario.getNombre());%>">Modificar</a></td>
      <td><a style="color:red;" href="/JSPusuarios/Eliminar?id=<%out.print(usuario.getId());%>">Eliminar</td>
    </tr>
    <%
	}
	%>
  </tbody>
</table>
</body>
</html>