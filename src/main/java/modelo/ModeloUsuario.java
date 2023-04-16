package modelo;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ModeloUsuario {
	
	Conector conexion = new Conector();
	
	public ArrayList<Usuario> verUsuarios() {
		conexion.conectar();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ModeloRoles mr = new ModeloRoles();

			try {
				PreparedStatement verU = conexion.getCon().prepareStatement("SELECT * FROM usuarios");
				verU.execute();
				
				ResultSet resultado = verU.executeQuery();
				
				while(resultado.next()) {
					Usuario usuario = new Usuario();
					
					usuario.setId(resultado.getInt("id"));
					usuario.setNombre(resultado.getString("nombre"));
					usuario.setPassword(resultado.getString("password"));
					usuario.setFecha_login(resultado.getDate("fecha_login"));
					usuario.setRol(mr.cargarRol(resultado.getInt("id_rol")));
					
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
			PreparedStatement modificarU = conexion.getCon().prepareStatement("UPDATE usuarios SET nombre = ?, password = ?, fecha_login = ? WHERE id = ?");
			modificarU.setString(1, usuario.getNombre());
			modificarU.setString(2, usuario.getPassword());
			modificarU.setDate(3, new Date(usuario.getFecha_login().getTime()));
			modificarU.setInt(4, id);
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
			insertarU = conexion.getCon().prepareStatement("INSERT INTO usuarios (nombre, password, fecha_login, id_rol) VALUES (?,?,?,?)");
			insertarU.setString(1, usuario.getNombre());
			insertarU.setString(2, usuario.getPassword());
			insertarU.setDate(3, new Date(usuario.getFecha_login().getTime()));
			insertarU.setInt(4, usuario.getRol().getId());
			insertarU.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean comprobarUsuarioContra(Usuario usuario){
		conexion.conectar();
		
		boolean entra = false;
		PreparedStatement comprobar;
		
		try {
			comprobar = conexion.getCon().prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND password = ?");
			comprobar.setString(1, usuario.getNombre());
			comprobar.setString(2, usuario.getPassword());
			comprobar.execute();
			
			ResultSet resultado = comprobar.executeQuery();
			
			while(resultado.next()) {
				entra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entra;
	}
	
	public int obtenerRol(Usuario usuario){
		int rol = 0;
		
		PreparedStatement obtenerRol;
		try {
			obtenerRol = conexion.getCon().prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND password = ?");
			obtenerRol.setString(1, usuario.getNombre());
			obtenerRol.setString(2, usuario.getPassword());
			
			obtenerRol.execute();
			
			ResultSet resultado = obtenerRol.executeQuery();
			
			while(resultado.next()) {
				rol = resultado.getInt("id_rol");
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rol;
	}
}
