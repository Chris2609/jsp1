package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario {
	
	Conector conexion = new Conector();
	
	public ArrayList<Usuario> verUsuarios() {
		conexion.conectar();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			try {
				PreparedStatement verU = conexion.getCon().prepareStatement("SELECT * FROM usuarios");
				verU.execute();
				
				ResultSet resultado = verU.executeQuery();
				
				while(resultado.next()) {
					Usuario usuario = new Usuario();
					
					usuario.setId(resultado.getInt("id"));
					usuario.setNombre(resultado.getString("nombre"));
					
					usuarios.add(usuario);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conexion.cerrar();
			return usuarios;
	}
	
	public void eliminarUsuario(int id) {
		conexion.conectar();
		
		try {
			PreparedStatement eliminarU = conexion.getCon().prepareStatement("DELETE FROM USUARIOS WHERE id=?");
			eliminarU.setInt(1, id);
			eliminarU.execute();
			conexion.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modificarUsuario(int id, Usuario usuario) {
		conexion.conectar();
		
		try {
			PreparedStatement modificarU = conexion.getCon().prepareStatement("UPDATE usuarios SET nombre = ? WHERE id = ?");
			modificarU.setString(1, usuario.getNombre());
			modificarU.setInt(2, id);
			modificarU.execute();
			
			conexion.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarUsuario(Usuario usuario) {
		conexion.conectar();
		
		PreparedStatement insertarU;
		try {
			insertarU = conexion.getCon().prepareStatement("INSERT INTO usuarios (nombre) VALUES (?)");
			insertarU.setString(1, usuario.getNombre());
			insertarU.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
