package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import view.View_login;
import view.View_principal_salesman;
import view.View_register_client;
import view.View_sell_product;
public class Logica_View_principal_salesman implements ActionListener{
	
	private View_principal_salesman vps;
	public Logica_View_principal_salesman(View_principal_salesman vps)
	{
		this.vps= vps;
		vps.btn_registro.addActionListener(this);
		vps.btn_salir.addActionListener(this);
		vps.btn_venta.addActionListener(this);
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}
	
	private void traduccion() {
		vps.btn_registro.setText(Logica_View_login.bundle.getString("btn_registro"));
		vps.btn_salir.setText(Logica_View_login.bundle.getString("btn_salir"));
		vps.btn_venta.setText(Logica_View_login.bundle.getString("btn_venta"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vps.btn_registro)
		{
			View_register_client vrc = new View_register_client();
			vrc.setVisible(true);
			vps.dispose();
		}
		else if(e.getSource()==vps.btn_venta)
		{
			View_sell_product vsp = new View_sell_product();
			vsp.setVisible(true);
			vps.dispose();
		}
		else
		{
			View_login lv = new View_login();
			lv.setVisible(true);
			vps.dispose();
		}

	}

}
