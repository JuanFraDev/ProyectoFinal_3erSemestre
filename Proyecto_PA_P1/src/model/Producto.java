package model;

import patron_generico.generica;

public class Producto {
	private generica<String, String, String>dt_producto;
	private generica<String, String, String>dt_producto2;
	private generica<String, ?, ?>dt_producto3;
	
	public Producto(String codigo, String nombre, String peso, String unidades, String precio, String proveedor, String tipo)
	{
		this.dt_producto = new generica<String, String, String> (codigo, nombre, peso);
		this.dt_producto2 = new generica<String, String, String> (unidades, precio, proveedor);
		this.dt_producto3 = new generica<String, String, String> (tipo, "", "");
	}
	
	public String getCodigo()
	{
		return dt_producto.getAtributoT1();
	}
	
	public String getName()
	{
		return dt_producto.getAtributoS1();
	}
	
	public String getPeso()
	{
		return dt_producto.getAtributoU1();
	}
	
	public String getUnidades()
	{
		return dt_producto2.getAtributoT1();
	}
	
	public String getPrecio()
	{
		return dt_producto2.getAtributoS1();
	}
	
	public String getProveedor()
	{
		return dt_producto2.getAtributoU1();
	}
	
	public String getTipo()
	{
		return dt_producto3.getAtributoT1();
	}
	
	public void setCodigo(String codigo)
	{
		 dt_producto.setAtributoT1(codigo);
	}
	
	public void setName(String nombre)
	{
		 dt_producto.setAtributoS1(nombre);
	}
	
	public void SetPeso(String PESO)
	{
		 dt_producto.setAtributoU1(PESO);
	}
	
	public void setUnidades(String un)
	{
		 dt_producto2.setAtributoT1(un);
	}
	
	public void setPrecio(String precio)
	{
		 dt_producto2.setAtributoS1(precio);
	}
	
	public void setProveedor(String proveedor)
	{
		 dt_producto2.setAtributoU1(proveedor);
	}
	
	public void setTipo(String tipo)
	{
		dt_producto3.setAtributoT1(tipo);
	}
	
}
