package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ResourceBundle;

import view.View_login;
import view.View_principal_admin;

public class Logica_View_principal_admin implements ActionListener{

	private View_principal_admin vpa;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_principal_admin(View_principal_admin vpa)
	{
		this.vpa=vpa;
		this.vpa.btn_salir.addActionListener(this);
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		if(idioma == "es_Es") {
			this.vpa.setTitle("Principal Admin");
		}else if(idioma == "en_En") {
			this.vpa.setTitle("Main Admin");
		}
		traduccion();
	}
	
	private void traduccion() {
		vpa.btn_gestionar.setText(Logica_View_login.bundle.getString("btn_gestionar"));
		vpa.btn_horario.setText(Logica_View_login.bundle.getString("btn_horario"));
		vpa.btn_registrar1.setText(Logica_View_login.bundle.getString("btn_registrar1"));
		vpa.btn_salir.setText(Logica_View_login.bundle.getString("btn_salir"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vpa.btn_salir)
		{
			View_login lv = new View_login();
			lv.setVisible(true);
			vpa.dispose();
		}

	}

}
