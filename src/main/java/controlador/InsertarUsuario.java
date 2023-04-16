package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Conector;
import modelo.ModeloRoles;
import modelo.ModeloUsuario;
import modelo.Rol;
import modelo.Usuario;

/**
 * Servlet implementation class InsertarUsuario
 */
@WebServlet("/InsertarUsuario")
public class InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModeloRoles verRoles = new ModeloRoles();
		ArrayList<Rol> roles = verRoles.getRoles();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("InsertarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre(request.getParameter("nuevoUsuario"));
		nuevoUsuario.setPassword(request.getParameter("password"));
		Rol rol = new Rol();
		rol.setId(Integer.parseInt(request.getParameter("id_rol")));
		nuevoUsuario.setRol(rol);
		
		Date fecha_login = null;
        try {
            fecha_login = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_login"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		nuevoUsuario.setFecha_login(fecha_login);
		
		ModeloUsuario insertarU = new ModeloUsuario();
		insertarU.insertarUsuario(nuevoUsuario);
		
		HttpSession rol2 = request.getSession();
		int rolUsuario = (Integer) rol2.getAttribute("rol");
				
		response.sendRedirect(request.getContextPath() + "/VerUsuarios?rol="+rolUsuario);

	}

}
