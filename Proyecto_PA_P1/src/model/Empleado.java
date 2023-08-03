package model;
import patron_generico.generica;

public class Empleado {
	private generica <String, String, Integer> dt_empleado;
	private generica <String, String, String> dt_empleado2;
	private generica <String, String, String> dt_empleado3;
	private generica <String, Integer, String> dt_empleado4;

	public Empleado(String codigo, String nombre, int cedula, String correo, 
			String telefono1, String telefono2, String direccion, String fecha, String usuario,
			String password, int rol) 
	{
		this.dt_empleado = new generica <String, String, Integer> (codigo, nombre, cedula);
		this.dt_empleado2 = new generica <String, String, String> (correo, telefono1, telefono2);
		this.dt_empleado3 = new generica <String, String, String> (direccion, fecha, usuario);
		this.dt_empleado4 = new generica <String, Integer, String> (password, rol, "");
	}

	public String getCodigo()
	{
		return dt_empleado.getAtributoT1();
	}

	public String getName()
	{
		return dt_empleado.getAtributoS1();
	}

	public Integer getCedula()
	{
		return dt_empleado.getAtributoU1();
	}

	public String getCorreo()
	{
		return dt_empleado2.getAtributoT1();
	}

	public String getTelefono1()
	{
		return dt_empleado2.getAtributoS1();
	}

	public String getTelefono2()
	{
		return dt_empleado2.getAtributoU1();
	}

	public String getDireccion()
	{
		return dt_empleado3.getAtributoT1();
	}

	public String getFecha()
	{
		return dt_empleado3.getAtributoS1();
	}

	public void setCodigo(String codigo)
	{
		dt_empleado.setAtributoT1(codigo);
	}

	public void setName(String nombre)
	{
		dt_empleado.setAtributoS1(nombre);
	}

	public void setCedula(int cedula)
	{
		dt_empleado.setAtributoU1(cedula);
	}

	public void setCorreo(String correo)
	{
		dt_empleado2.setAtributoT1(correo);
	}

	public void setTelefono1(String telefono)
	{
		dt_empleado2.setAtributoS1(telefono);
	}

	public void setTelefono2(String telefono2)
	{
		dt_empleado2.setAtributoU1(telefono2);
	}

	public void setDireccion(String direccion)
	{
		dt_empleado3.setAtributoT1(direccion);
	}

	public void setFecha(String fecha)
	{
		dt_empleado3.setAtributoS1(fecha);
	}

	public String getUsuario() 
	{
		return dt_empleado3.getAtributoU1();
	}
	public String getContrasena() 
	{
		return dt_empleado4.getAtributoT1();
	}
	public int getRol() 
	{
		return dt_empleado4.getAtributoS1();
	}
	public void setUsuario(String user) 
	{
		 dt_empleado3.setAtributoU1(user);
	}
	public void setContrasena(String psw) 
	{
		 dt_empleado4.setAtributoT1(psw);
	}
	public void setRol(int rol) 
	{
		 dt_empleado4.setAtributoS1(rol);
	}

	public String getInfo()
	{
		return getCodigo()+";"+getName()+";"+getCedula()+";"+getCorreo()+";"+
				getTelefono1()+";"+getTelefono2()+";"+getDireccion()+";"+getFecha()+";"+getRol()+";";
	}
}
