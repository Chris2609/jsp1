<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Usuario</title>
   <link rel="stylesheet" href=
"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
    <link rel="stylesheet" href=
"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity=
"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>
  <style>
        form i {
            margin-left: -30px;
            cursor: pointer;
        }
    </style>	
	<%
	int id = (int) request.getAttribute("id");
	String nombre = (String) request.getAttribute("nombre");
	String password = (String) request.getAttribute("password");
	Date fecha_login = (Date) request.getAttribute("fecha_login");
	int rolMod = (int) request.getAttribute("rolMod");
	ArrayList<Rol> roles = (ArrayList<Rol>) request.getAttribute("roles"); 

	%>

	<form method="POST" action="ModUsuario">
	
	<input type="hidden" name="id" value="<%out.print(id);%>">
	<input type="text" name="nombre" placeholder="Nombre de usuario" value="<%out.print(nombre);%>"/>
	<input type="text" name="password" placeholder="Contraseña" value="<%out.print(password);%>"/>
	<input type="date" name="fecha_login" value="<%out.print(fecha_login);%>"/>
	
	<select class="select"  name="id_rol" >

	<%if(0 == rolMod){%>
  		<option value="0" selected="selected">Selecciona un rol</option>
  	<%} %>	
	
	<%for(Rol rol : roles){ %>
	
  		<option value="<%out.print(rol.getId());%>" <%if(rol.getId() == rolMod){%>selected="selected"<%} %>><%out.print(rol.getNombre());%></option>
  		
	<%} %>

	</select>
	
	<input type="submit" value="Enviar"/>
	</form>
	
 <script>
        const togglePassword = document
            .querySelector('#togglePassword');
  
        const password = document.querySelector('#password');
  
        togglePassword.addEventListener('click', () => {
  
            const type = password
                .getAttribute('type') === 'password' ?
                'text' : 'password';
                  
            password.setAttribute('type', type);
              this.classList.toggle('bi-eye');
        });
    </script>
</body>
</body>
</html>