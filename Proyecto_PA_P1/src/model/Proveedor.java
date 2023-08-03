package model;
import patron_generico.generica;

public class Proveedor {
	private generica<String, String, String>dt_proveedor;
	private generica<String, String, ?>dt_proveedor2;
	
	public Proveedor(String codigo, String razon, String contacto, String telefono, String email)
	{
		this.dt_proveedor = new generica<String, String, String> (codigo, razon, contacto);
		this.dt_proveedor2 = new generica<String, String, String> (telefono, email, "");
	}
	
	public String getCodigo()
	{
		return dt_proveedor.getAtributoT1();
	}
	
	public String getRazon()
	{
		return dt_proveedor.getAtributoS1();
	}
	
	public String getContacto()
	{
		return dt_proveedor.getAtributoU1();
	}
	
	public String getTelefono()
	{
		return dt_proveedor2.getAtributoT1();
	}
	
	public String getEmail()
	{
		return dt_proveedor2.getAtributoS1();
	}
	
	public void setCodigo(String codigo)
	{
		dt_proveedor.setAtributoT1(codigo);
	}
	
	public void setRazon(String razon)
	{
		dt_proveedor.setAtributoS1(razon);
	}
	
	public void setContacto(String contacto)
	{
		dt_proveedor.setAtributoU1(contacto);
	}
	
	public void setTelefono(String telefono)
	{
		dt_proveedor2.setAtributoT1(telefono);
	}
	
	public void setEmail(String email)
	{
		dt_proveedor.setAtributoS1(email);
	}
	
	public String getInfo() {
		return getCodigo() + ";"+ getRazon()+ ";" + getContacto()+ ";"+
				getTelefono()+ ";"+getEmail()+ ";";
	}
}
