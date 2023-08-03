package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patron_generico.connection;

public class horariosDAO {
	private connection query = new connection("supertiendas");
	private String querySQL="";

	public boolean insertHorario(Horarios h) {
		querySQL=String.format("INSERT INTO horarios VALUES('%s', NOW(), '%s', '%s', '%s', '%s', '%s');" 
				,h.getEmpleado()
				,h.getHorario1()
				,h.getHorario2()
				,h.getHorario3()
				,h.getHorario4()
				,h.getHorario5());
		return query.setQuery(querySQL);
	}

	public List <Horarios> listHorarios()
	{
		List<Horarios>horarios=new ArrayList<Horarios>();
		querySQL="SELECT * FROM horarios;";
		ResultSet res=query.getQuery(querySQL);
		try {
			while(res.next()) {
				horarios.add(new Horarios(
						res.getString(1),  
						res.getString(3), 
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
		return horarios;
	}

	public void close() {
		query.closeConn();
	}
}
