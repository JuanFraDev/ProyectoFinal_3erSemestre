package model;

public class Administrador extends Empleado{

	public Administrador(String codigo, String nombre, int cedula, String correo, String telefono1, String telefono2,
			String direccion, String fecha, String usuario, String password, int rol) {
		super(codigo, nombre, cedula, correo, telefono1, telefono2, direccion, fecha, usuario, password, rol);
		// TODO Auto-generated constructor stub
		setRol(1);
	}
	
	
}
