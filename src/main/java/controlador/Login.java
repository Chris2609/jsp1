package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("usuario"));
		usuario.setPassword(request.getParameter("contrasena"));
		request.getSession().invalidate();
		ModeloUsuario comprobar = new ModeloUsuario();
		
		boolean compro = comprobar.comprobarUsuarioContra(usuario);
		
		if(compro == true) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			response.sendRedirect(request.getContextPath() + "/VerUsuarios");
		}else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
