package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		Date fecha_login = null;
		
        try {
			fecha_login = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fecha_login"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        

		request.setAttribute("id", Integer.parseInt(id));
		request.setAttribute("nombre", nombre);
		request.setAttribute("password", password);
        request.setAttribute("fecha_login", fecha_login);

        
        
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
		
		Date fecha_login = null;
		try {
			fecha_login = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_login"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		usuarioModificado.setFecha_login(fecha_login);
		
		ModeloUsuario modificarU = new ModeloUsuario();
		modificarU.modificarUsuario(Integer.parseInt(id), usuarioModificado);
		
		HttpSession rol = request.getSession();
		int rolUsuario = (Integer) rol.getAttribute("rol");
		
		HttpSession session = request.getSession();
		Usuario usuario = new Usuario();
		usuario = (Usuario) session.getAttribute("usuario");
		
		response.sendRedirect(request.getContextPath() + "/VerUsuarios?rol="+rolUsuario+"&nombre="+usuario.getNombre());
	}

}
