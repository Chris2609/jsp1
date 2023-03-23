<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	%>

	<form method="POST" action="ModUsuario">
	
	<input type="hidden" name="id" value="<%out.print(id);%>">
	<input type="text" name="nombre" placeholder="Nombre de usuario" value="<%out.print(nombre);%>"/>
	<input type="text" name="password" placeholder="Contraseña" value="<%out.print(password);%>">
	
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