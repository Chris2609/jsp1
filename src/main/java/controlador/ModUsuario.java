package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class ModUsuario
 */
@WebServlet("/ModUsuario")
public class ModUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		request.setAttribute("id", Integer.parseInt(id));
		request.setAttribute("nombre", nombre);
		request.setAttribute("password", password);
		
		request.getRequestDispatcher("ModUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Usuario usuarioModificado = new Usuario();
		usuarioModificado.setNombre(request.getParameter("nombre"));
		usuarioModificado.setPassword(request.getParameter("password"));
		ModeloUsuario modificarU = new ModeloUsuario();
		modificarU.modificarUsuario(Integer.parseInt(id), usuarioModificado);
		response.sendRedirect(request.getContextPath() + "/VerUsuarios");
	}

}
