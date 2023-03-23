package modelo;

import java.util.Date;

public class Usuario {

	int id;
	String nombre;
	String password;
	Date fecha_login;
	
	
	
	public Date getFecha_login() {
		return fecha_login;
	}
	public void setFecha_login(Date fecha_login) {
		this.fecha_login = fecha_login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
