<%@ page import="java.util.ArrayList"%>
<%@ page import= "modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>


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
	Integer rolUsuario = (Integer) request.getAttribute("rolUsuario");
	String nombreUsuario = (String) request.getAttribute("nombreUsuario");
	%>
	
<%if(rolUsuario == 1){ %>	
<a href="/JSPusuarios/InsertarUsuario" class= "btn btn-success">Insertar</a>
<%}else if (rolUsuario == 2){ %>
<a style="pointer-events: none; cursor: default; text-decoration: line-through;" href="/JSPusuarios/InsertarUsuario" class= "btn btn-success" style="pointer-events: none; cursor: default;">Insertar</a>

<%} %>

<a href="/JSPusuarios/Login" class= "btn btn-dark">Cerrar sesion</a>

<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Usuario</th>
      <th scope="col">Contraseņa</th>
      <th scope="col">Fecha_login</th>
      <th scope="col">Rol</th>
      <th scope="col">Modificar</th>
      <th scope="col">Eliminar</th>
    </tr>
  </thead>
  <tbody>
  	
    	
 			
 			  
       	<c:forEach items="${usuarios}" var="usuario">
   
    <tr>
      <td><c:out value="${usuario.id}"></c:out></td>
      <td><c:out value="${usuario.nombre}"></c:out></td>
      <td><c:out value="${usuario.password}"></c:out></td>
      <td><c:out value="${usuario.fecha_login}"></c:out></td>
      
      <td><c:out value="${usuario.rol.nombre}"></c:out>
      
      <td>
      <%if(rolUsuario == 1){ %>	
      <a href="/JSPusuarios/ModUsuario?id=<c:out value ="${usuario.id}"></c:out>&nombre=<c:out value = "${usuario.nombre}"></c:out>&password=<c:out value = "${usuario.password}"></c:out>&fecha_login=<c:out value = "${usuario.fecha_login}"></c:out>">Modificar</a>
      <%}else if(rolUsuario == 2){%>
      
 		<c:if test = "${usuario.nombre == nombreUsuario}">
          <a href="/JSPusuarios/ModUsuario?id=<c:out value ="${usuario.id}"></c:out>&nombre=<c:out value = "${usuario.nombre}"></c:out>&password=<c:out value = "${usuario.password}"></c:out>&fecha_login=<c:out value = "${usuario.fecha_login}"></c:out>">Modificar</a>
        </c:if>
    	
    	<c:if test = "${usuario.nombre != nombreUsuario}">
    	  <a style="pointer-events: none; cursor: default; text-decoration:line-through;" href="/JSPusuarios/ModUsuario?id=<c:out value ="${usuario.id}"></c:out>&nombre=<c:out value = "${usuario.nombre}"></c:out>&password=<c:out value = "${usuario.password}"></c:out>&fecha_login=<c:out value = "${usuario.fecha_login}"></c:out>">Modificar</a>
        </c:if>
    <%} %>
      </td>

      <td>
      <%if(rolUsuario == 1){ %>	
      <a style="color:red;" href="/JSPusuarios/Eliminar?id=<c:out value ="${usuario.id}"></c:out>">Eliminar</a>
      <%}else if(rolUsuario == 2){%>
      <c:if test = "${usuario.nombre == nombreUsuario}">
      <a style="color:red;" href="/JSPusuarios/Eliminar?id=<c:out value ="${usuario.id}"></c:out>">Eliminar</a>
        </c:if>
    	
    	<c:if test = "${usuario.nombre != nombreUsuario}">
      <a style="color:red; pointer-events: none; cursor: default; text-decoration:line-through;" href="/JSPusuarios/Eliminar?id=<c:out value ="${usuario.id}"></c:out>">Eliminar</a>
        </c:if>
      <%} %>
      </td>
  
    </tr>
       	</c:forEach>
   
  </tbody>
</table>
</body>
</html>