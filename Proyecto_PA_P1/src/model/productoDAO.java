package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patron_generico.connection;

public class productoDAO {
	private connection query = new connection("supertiendas");
	private String querySQL="";
	
	public boolean insertProducto(Producto p) {
		querySQL=String.format("INSERT INTO productos VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s');" 
			,p.getCodigo()
			,p.getName()
			,p.getPeso()
			,p.getUnidades()
			,p.getPrecio()
			,p.getProveedor()
			,p.getTipo());
		return query.setQuery(querySQL);
	}
	
	public boolean updateProducto(Producto p)
	{
		querySQL=String.format("UPDATE productos SET unidades='%s' WHERE codigo='%s'; ",
				p.getUnidades(),
				p.getCodigo());
		return query.setQuery(querySQL);
	}
	
	public boolean updateProductoPeso(Producto p)
	{
		querySQL=String.format("UPDATE productos SET peso='%s' WHERE codigo='%s'; ",
				p.getPeso(),
				p.getCodigo());
		return query.setQuery(querySQL);
	}
	
	public List <Producto> listProductos()
	{
		List<Producto>productos=new ArrayList<Producto>();
		querySQL="SELECT * FROM productos;";
		ResultSet res=query.getQuery(querySQL);
		try {
			while(res.next()) {
				productos.add(new Producto(
						res.getString(1),  //id
						res.getString(2), //cuenta
						res.getString(3),	//cedula
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7)
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return productos;
	}
	
	public void close() {
		query.closeConn();
	}
}
