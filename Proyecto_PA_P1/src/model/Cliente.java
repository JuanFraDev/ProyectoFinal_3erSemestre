package model;
import patron_generico.generica;

public class Cliente {
	private generica<String, String, String> dt_cliente;
	private generica<String, String, ?> dt_cliente2;
	
	public Cliente(String nombres, String cedula, String email, String telefono, String direccion)
	{
		this.dt_cliente = new generica<String, String, String> (nombres, cedula, email); 
		this.dt_cliente2 = new generica<String, String, String> (telefono, direccion, ""); 
	}

	public String getName()
	{
		return dt_cliente.getAtributoT1();
	}
	
	public String getCedula()
	{
		return dt_cliente.getAtributoS1();
	}
	
	public String getCorreo()
	{
		return dt_cliente.getAtributoU1();
	}
	
	public String getTelefono()
	{
		return dt_cliente2.getAtributoT1();
	}
	
	public String getDireccion()
	{
		return dt_cliente2.getAtributoS1();
	}
	
	public void setName(String nombres)
	{
		 dt_cliente.setAtributoT1(nombres);
	}
	
	public void setCedula(String cedula)
	{
		 dt_cliente.setAtributoS1(cedula);
	}
	
	public void setCorreo(String correo)
	{
		 dt_cliente.setAtributoU1(correo);
	}
	
	public void setTelefono(String telefono)
	{
		 dt_cliente2.setAtributoT1(telefono);
	}
	
	public void setDireccion(String direccion)
	{
		 dt_cliente2.setAtributoS1(direccion);
	}
	
	public String getInfo() {
		return getName() + ";"+ getCedula()+ ";" + getCorreo()+ ";"+
				getTelefono()+ ";"+getDireccion()+ ";";
	}
}
