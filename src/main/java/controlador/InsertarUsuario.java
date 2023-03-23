package controlador;

import java.io.IOException;
import java.util.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Conector;
import modelo.ModeloUsuario;
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
	    SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");  


		
		ModeloUsuario insertarU = new ModeloUsuario();
		insertarU.insertarUsuario(nuevoUsuario);
		response.sendRedirect(request.getContextPath() + "/VerUsuarios");

	}

}
