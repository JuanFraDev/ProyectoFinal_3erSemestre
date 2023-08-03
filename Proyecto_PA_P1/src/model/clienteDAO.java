package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patron_generico.connection;

public class clienteDAO {
	private connection query = new connection("supertiendas");
	private String querySQL="";

	public boolean insertCliente(Cliente c)
	{
		querySQL=String.format("INSERT INTO clientes VALUES('%s', '%s', '%s', '%s','%s');", 
				c.getName(),
				c.getCedula(),
				c.getCorreo(),
				c.getTelefono(), 
				c.getDireccion());
		return query.setQuery(querySQL);
	}

	public List <Cliente> listClientes()
	{
		List<Cliente>clientes=new ArrayList<Cliente>();
		querySQL="SELECT * FROM clientes;";
		ResultSet res=query.getQuery(querySQL);
		try
		{
			while(res.next())
			{
				clientes.add(new Cliente(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5)
						));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return clientes;
	}
	
	public void close() {
		query.closeConn();
	}

}
