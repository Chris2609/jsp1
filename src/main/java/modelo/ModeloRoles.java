package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloRoles {

	Conector conexion = new Conector();
	
	public ArrayList<Rol> getRoles() {
		conexion.conectar();
		ArrayList<Rol> roles = new ArrayList<Rol>();

			try {
				PreparedStatement getR = conexion.getCon().prepareStatement("SELECT * FROM roles");
				getR.execute();
				
				ResultSet resultado = getR.executeQuery();
				
				while(resultado.next()) {
					Rol rol = new Rol();
					
					rol.setId(resultado.getInt("id"));
					rol.setNombre(resultado.getString("nombre"));
					
					roles.add(rol);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conexion.cerrar();
			return roles;
	}

	public Rol cargarRol(int id_rol) {
		conexion.conectar();
		Rol rol = new Rol();

			try {
				PreparedStatement getR = conexion.getCon().prepareStatement("SELECT * FROM roles where id=?");
				getR.setInt(1, id_rol);
				
				ResultSet resultado = getR.executeQuery();
				
				while(resultado.next()) {
					
					rol.setId(resultado.getInt("id"));
					rol.setNombre(resultado.getString("nombre"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conexion.cerrar();
			return rol;
	}
	
}
