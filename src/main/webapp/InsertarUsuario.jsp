<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="modelo.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Usuario</title>
   <link rel="stylesheet" href=
"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
    <link rel="stylesheet" href=
"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity=
"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

<%	
	ArrayList<Rol> roles = (ArrayList<Rol>) request.getAttribute("roles"); 
	%>
	
  <style>
  *{
  margin: 10px}
        form i {
            margin-left: -30px;
            cursor: pointer;
        }
    </style>	
	<form method="post" action="InsertarUsuario">
	<p>
	<input type="text" name="nuevoUsuario" placeholder="Nuevo usuario">
	</p>  
    
    <p>
    <input type="password" name="password" id="password" placeholder="Contraseña" />
     	<i class="bi bi-eye-slash" id="togglePassword"></i>
       </p>
       
      <p>   
     <input type="date" name="fecha_login" pattern="yyyy-MM-dd">
       </p>
      
     <select class="select"  name="id_rol" >
  		<option value="0"></option>
  		
  	<%for(Rol rol : roles){ %>
  		<option value="<%out.print(rol.getId());%>"><%out.print(rol.getNombre());%></option>
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
</html>