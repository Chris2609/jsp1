package controlador;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class VerUsuarios
 */
@WebServlet("/VerUsuarios")
public class VerUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ModeloUsuario verUsuarios = new ModeloUsuario();
		ArrayList<Usuario> usuarios = verUsuarios.verUsuarios();
		
		request.setAttribute("usuarios", usuarios);


		HttpSession session = request.getSession();
		Usuario usuario = new Usuario();
		usuario = (Usuario) session.getAttribute("usuario");
		
		int rolUsuario = 0;
		rolUsuario = Integer.parseInt(request.getParameter("rol"));
		request.setAttribute("rolUsuario", rolUsuario);
		
		String nombreUsuario = request.getParameter("nombre");
		request.setAttribute("nombreUsuario", nombreUsuario);
		
		HttpSession rol = request.getSession();
		rol.setAttribute("rol", rolUsuario);
		if (usuario == null) {
			response.sendRedirect("Login");
		} else {
			request.getRequestDispatcher("VerUsuarios.jsp").forward(request, response);
	
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
