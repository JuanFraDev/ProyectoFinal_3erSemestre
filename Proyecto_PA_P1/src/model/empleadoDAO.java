package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Administrar_info;
import patron_generico.connection;

public class empleadoDAO {
	private connection query = new connection("supertiendas");
	private String querySQL="";

	public boolean insertEmpleado(Empleado e) {
		querySQL=String.format("INSERT INTO empleados VALUES('%s', '%s', %d, '%s', '%s','%s', '%s', '%s', '%s', '%s', %d);" 
				,e.getCodigo()
				,e.getName()
				,e.getCedula()
				,e.getCorreo()
				,e.getTelefono1()
				,e.getTelefono2()
				,e.getDireccion()
				,e.getFecha()
				,e.getUsuario()
				,e.getContrasena()
				,e.getRol());
		return query.setQuery(querySQL);
	}

	public boolean updatePassword(Empleado e)
	{
		querySQL=String.format("UPDATE empleados SET contraseña='%s' WHERE cedula=%d;",
				e.getContrasena(),
				e.getCedula());
		return query.setQuery(querySQL);
	}
	
	public List <Empleado> listEmpleados()
	{
		List<Empleado>empleado=new ArrayList();
		querySQL="SELECT * FROM empleados;";
		ResultSet res=query.getQuery(querySQL);
		try {
			while(res.next()) {
				empleado.add(new Empleado(
						res.getString(1),  //id
						res.getString(2), //cuenta
						res.getInt(3), //tipo
						res.getString(4),	//cedula
						res.getString(5),
						res.getString(6),
						res.getString(7),
						res.getString(8),
						res.getString(9),
						res.getString(10),
						res.getInt(11)		
						));
				Administrar_info.contador++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empleado;
	}
	
	public List <String> listCredenciales()
	{
		List<String>credenciales=new ArrayList();
		querySQL="SELECT usuario FROM empleados;";
		ResultSet res=query.getQuery(querySQL);
		try {
			while(res.next()) {
				credenciales.add(res.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credenciales;
	}
	
	public void close() {
		query.closeConn();
	}
}
