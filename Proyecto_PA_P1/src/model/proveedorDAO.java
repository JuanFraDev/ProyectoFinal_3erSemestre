package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patron_generico.connection;

public class proveedorDAO {
	private connection query = new connection("supertiendas");
	private String querySQL="";
	
	public boolean insertProveedor(Proveedor p) {
		querySQL=String.format("INSERT INTO proveedores VALUES('%s', '%s', '%s', '%s', '%s');" 
			,p.getCodigo()
			,p.getRazon()
			,p.getContacto()
			,p.getTelefono()
			,p.getEmail());
		return query.setQuery(querySQL);
	}
	
	public List <Proveedor> listProveedores()
	{
		List<Proveedor>proveedores=new ArrayList<Proveedor>();
		querySQL="SELECT * FROM proveedores;";
		ResultSet res=query.getQuery(querySQL);
		try {
			while(res.next()) {
				proveedores.add(new Proveedor(
						res.getString(1), 
						res.getString(2), 
						res.getString(3),
						res.getString(4),
						res.getString(5)
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return proveedores;
	}
	
	public void close() {
		query.closeConn();
	}
}
