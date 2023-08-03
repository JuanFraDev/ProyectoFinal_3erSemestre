package controller;

import view.View_horarios;
import view.View_principal_admin;
import model.Empleado;
import model.Horarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class Logica_View_horarios implements ActionListener{
	private View_horarios vh;	
	private String idioma = Logica_View_login.sharedValue.getValue().toString();
	public Logica_View_horarios(View_horarios vh) {
		super();
		this.vh = vh;		
		this.vh.btn_cancelar.addActionListener(this);
		this.vh.btn_aceptar.addActionListener(this);

		this.vh.rbtn_lunes_madrugada.addActionListener(this);
		this.vh.rbtn_lunes_matutino.addActionListener(this);
		this.vh.rbtn_lunes_nocturno.addActionListener(this);
		this.vh.rbtn_lunes_vespertino.addActionListener(this);
		this.vh.rbtn_martes_madrugada.addActionListener(this);
		this.vh.rbtn_martes_matutino.addActionListener(this);
		this.vh.rbtn_martes_nocturno.addActionListener(this);
		this.vh.rbtn_martes_vespertino.addActionListener(this);
		this.vh.rbtn_miercoles_madrugada.addActionListener(this);
		this.vh.rbtn_miercoles_matutino.addActionListener(this);
		this.vh.rbtn_miercoles_nocturno.addActionListener(this);
		this.vh.rbtn_miercoles_vespertino.addActionListener(this);
		this.vh.rbtn_jueves_madrugada.addActionListener(this);
		this.vh.rbtn_jueves_matutino.addActionListener(this);
		this.vh.rbtn_jueves_nocturno.addActionListener(this);
		this.vh.rbtn_jueves_vespertino.addActionListener(this);
		this.vh.rbtn_viernes_madrugada.addActionListener(this);
		this.vh.rbtn_viernes_matutino.addActionListener(this);
		this.vh.rbtn_viernes_nocturno.addActionListener(this);
		this.vh.rbtn_viernes_vespertino.addActionListener(this);
		
		String id1 = "";
		String id2 = "";
		
		if(idioma == "es_Es") {
			id1 = "(Vendedor)";
			id2 = "(Bodeguero)";
			this.vh.setTitle("Asignar horario");
		}else if(idioma == "en_En") {
			id1 = "(Salesman)";
			id2 = "(Storekeeper)";
			this.vh.setTitle("Assign Schedules");
		}
		
		for(Empleado s:Administrar_info.empleados){
			if(s.getRol()!=1){
				if(s.getRol()==2)
					this.vh.cmb_empleado.addItem(s.getName()+" "+id1);
				else
					this.vh.cmb_empleado.addItem(s.getName()+" "+id2);
			}
		}
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}
	
	public void traduccion() {
		vh.lbl_asignacion.setText(Logica_View_login.bundle.getString("lbl_asignacion"));
		vh.lbl_dia.setText(Logica_View_login.bundle.getString("lbl_dia"));
		vh.lbl_empleado.setText(Logica_View_login.bundle.getString("lbl_empleado"));
		vh.lbl_jueves.setText(Logica_View_login.bundle.getString("lbl_jueves"));
		vh.lbl_lunes.setText(Logica_View_login.bundle.getString("lbl_lunes"));
		vh.lbl_madrugada.setText(Logica_View_login.bundle.getString("lbl_madrugada"));
		vh.lbl_martes.setText(Logica_View_login.bundle.getString("lbl_martes"));
		vh.lbl_matutino.setText(Logica_View_login.bundle.getString("lbl_matutino"));
		vh.lbl_miercoles.setText(Logica_View_login.bundle.getString("lbl_miercoles"));
		vh.lbl_nocturno.setText(Logica_View_login.bundle.getString("lbl_nocturno"));
		vh.lbl_turno.setText(Logica_View_login.bundle.getString("lbl_turno"));
		vh.lbl_vespertino.setText(Logica_View_login.bundle.getString("lbl_vespertino"));
		vh.lbl_viernes.setText(Logica_View_login.bundle.getString("lbl_viernes"));
		vh.btn_aceptar.setText(Logica_View_login.bundle.getString("btn_aceptar"));
		vh.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));

		
	}
	/**
	 * Este método permite quitar la selección de cada radio button 
	 */
	public void vaciar() {
		this.vh.rbtn_lunes_madrugada.setSelected(false);
		this.vh.rbtn_lunes_matutino.setSelected(false);
		this.vh.rbtn_lunes_nocturno.setSelected(false);
		this.vh.rbtn_lunes_vespertino.setSelected(false);
		
		this.vh.rbtn_martes_madrugada.setSelected(false);
		this.vh.rbtn_martes_matutino.setSelected(false);
		this.vh.rbtn_martes_nocturno.setSelected(false);
		this.vh.rbtn_martes_vespertino.setSelected(false);

		this.vh.rbtn_miercoles_madrugada.setSelected(false);
		this.vh.rbtn_miercoles_matutino.setSelected(false);
		this.vh.rbtn_miercoles_nocturno.setSelected(false);
		this.vh.rbtn_miercoles_vespertino.setSelected(false);
		
		this.vh.rbtn_jueves_madrugada.setSelected(false);
		this.vh.rbtn_jueves_matutino.setSelected(false);
		this.vh.rbtn_jueves_nocturno.setSelected(false);
		this.vh.rbtn_jueves_vespertino.setSelected(false);
		
		this.vh.rbtn_viernes_madrugada.setSelected(false);
		this.vh.rbtn_viernes_matutino.setSelected(false);
		this.vh.rbtn_viernes_nocturno.setSelected(false);
		this.vh.rbtn_viernes_vespertino.setSelected(false);
	}
	
	/**
	 * Este método retorna el formato de cada turno con las fechas
	 * seleccionadas.
	 */
	public void getHorario() {
		String turnoL="";
		String turnoMa="";
		String turnoMi="";
		String turnoJ="";
		String turnoV="";
		
		if(vh.rbtn_lunes_matutino.isSelected())
			turnoL = "7:00-15:00";
		else if(vh.rbtn_lunes_vespertino.isSelected())
			turnoL = "13:00-21:00";
		else if(vh.rbtn_lunes_nocturno.isSelected())
			turnoL = "18:00-00:00";
		else if (vh.rbtn_lunes_madrugada.isSelected())
			turnoL = "23:00-7:00";
		
		if(vh.rbtn_martes_matutino.isSelected())
			turnoMa = "7:00-15:00";
		else if(vh.rbtn_martes_vespertino.isSelected())
			turnoMa = "13:00-21:00";
		else if(vh.rbtn_lunes_nocturno.isSelected())
			turnoMa = "18:00-00:00";
		else if (vh.rbtn_lunes_madrugada.isSelected())
			turnoMa = "23:00-7:00";
		
		if(vh.rbtn_miercoles_matutino.isSelected())
			turnoMi = "7:00-15:00";
		else if(vh.rbtn_miercoles_vespertino.isSelected())
			turnoMi = "13:00-21:00";
		else if(vh.rbtn_miercoles_nocturno.isSelected())
			turnoMi = "18:00-00:00";
		else if (vh.rbtn_miercoles_madrugada.isSelected())
			turnoMi = "23:00-7:00";
		
		if(vh.rbtn_jueves_matutino.isSelected())
			turnoJ = "7:00-15:00";
		else if(vh.rbtn_jueves_vespertino.isSelected())
			turnoJ = "13:00-21:00";
		else if(vh.rbtn_jueves_nocturno.isSelected())
			turnoJ = "18:00-00:00";
		else if (vh.rbtn_jueves_madrugada.isSelected())
			turnoJ = "23:00-7:00";
		
		if(vh.rbtn_viernes_matutino.isSelected())
			turnoV = "7:00-15:00";
		else if(vh.rbtn_viernes_vespertino.isSelected())
			turnoV = "13:00-21:00";
		else if(vh.rbtn_viernes_nocturno.isSelected())
			turnoV = "18:00-00:00";
		else if (vh.rbtn_viernes_madrugada.isSelected())
			turnoV = "23:00-7:00";
		
		Horarios h = new Horarios(vh.cmb_empleado.getSelectedItem().toString(), turnoL, turnoMa, turnoMi, turnoJ, turnoV);
		Administrar_info.hdao.insertHorario(h);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==vh.rbtn_lunes_madrugada){
			vh.rbtn_lunes_matutino.setSelected(false);
			vh.rbtn_lunes_nocturno.setSelected(false);
			vh.rbtn_lunes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_lunes_matutino){
			vh.rbtn_lunes_madrugada.setSelected(false);
			vh.rbtn_lunes_nocturno.setSelected(false);
			vh.rbtn_lunes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_lunes_nocturno){
			vh.rbtn_lunes_madrugada.setSelected(false);
			vh.rbtn_lunes_matutino.setSelected(false);
			vh.rbtn_lunes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_lunes_vespertino){
			vh.rbtn_lunes_madrugada.setSelected(false);
			vh.rbtn_lunes_matutino.setSelected(false);
			vh.rbtn_lunes_nocturno.setSelected(false);
		}
		else if(e.getSource()==vh.rbtn_martes_madrugada){
			vh.rbtn_martes_matutino.setSelected(false);
			vh.rbtn_martes_nocturno.setSelected(false);
			vh.rbtn_martes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_martes_matutino){
			vh.rbtn_martes_madrugada.setSelected(false);
			vh.rbtn_martes_nocturno.setSelected(false);
			vh.rbtn_martes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_martes_nocturno){
			vh.rbtn_martes_madrugada.setSelected(false);
			vh.rbtn_martes_matutino.setSelected(false);
			vh.rbtn_martes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_martes_vespertino){
			vh.rbtn_martes_madrugada.setSelected(false);
			vh.rbtn_martes_matutino.setSelected(false);
			vh.rbtn_martes_nocturno.setSelected(false);
		}
		else if(e.getSource()==vh.rbtn_miercoles_madrugada){
			vh.rbtn_miercoles_matutino.setSelected(false);
			vh.rbtn_miercoles_nocturno.setSelected(false);
			vh.rbtn_miercoles_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_miercoles_matutino){
			vh.rbtn_miercoles_madrugada.setSelected(false);
			vh.rbtn_miercoles_nocturno.setSelected(false);
			vh.rbtn_miercoles_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_miercoles_nocturno){
			vh.rbtn_miercoles_madrugada.setSelected(false);
			vh.rbtn_miercoles_matutino.setSelected(false);
			vh.rbtn_miercoles_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_miercoles_vespertino){
			vh.rbtn_miercoles_madrugada.setSelected(false);
			vh.rbtn_miercoles_matutino.setSelected(false);
			vh.rbtn_miercoles_nocturno.setSelected(false);
		}
		else if(e.getSource()==vh.rbtn_jueves_madrugada){
			vh.rbtn_jueves_matutino.setSelected(false);
			vh.rbtn_jueves_nocturno.setSelected(false);
			vh.rbtn_jueves_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_jueves_matutino){
			vh.rbtn_jueves_madrugada.setSelected(false);
			vh.rbtn_jueves_nocturno.setSelected(false);
			vh.rbtn_jueves_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_jueves_nocturno){
			vh.rbtn_jueves_madrugada.setSelected(false);
			vh.rbtn_jueves_matutino.setSelected(false);
			vh.rbtn_jueves_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_jueves_vespertino){
			vh.rbtn_jueves_madrugada.setSelected(false);
			vh.rbtn_jueves_matutino.setSelected(false);
			vh.rbtn_jueves_nocturno.setSelected(false);
		}
		else if(e.getSource()==vh.rbtn_viernes_madrugada){
			vh.rbtn_viernes_matutino.setSelected(false);
			vh.rbtn_viernes_nocturno.setSelected(false);
			vh.rbtn_viernes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_viernes_matutino){
			vh.rbtn_viernes_madrugada.setSelected(false);
			vh.rbtn_viernes_nocturno.setSelected(false);
			vh.rbtn_viernes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_viernes_nocturno){
			vh.rbtn_viernes_madrugada.setSelected(false);
			vh.rbtn_viernes_matutino.setSelected(false);
			vh.rbtn_viernes_vespertino.setSelected(false);
		}else if(e.getSource()==vh.rbtn_viernes_vespertino){
			vh.rbtn_viernes_madrugada.setSelected(false);
			vh.rbtn_viernes_matutino.setSelected(false);
			vh.rbtn_viernes_nocturno.setSelected(false);
		}else if(e.getSource() == vh.btn_aceptar) {
			getHorario();
			if(idioma == "es_Es") {
				JOptionPane.showMessageDialog(vh, "Información guardada");
			}else if(idioma == "en_En") {
				JOptionPane.showMessageDialog(vh, "Information saved");
			}
			
			vaciar();
		}
		else if (e.getSource() == vh.btn_cancelar){
			View_principal_admin vpa = new View_principal_admin();
			vpa.setVisible(true);
			vh.dispose();
		}
	}
	
}
