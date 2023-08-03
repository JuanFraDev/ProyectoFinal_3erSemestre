package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import view.View_login;
import view.View_principal_storekeeper;
import view.View_register_product;
import view.View_register_supplier;

public class Logica_View_principal_storekeeper implements ActionListener{
	private View_principal_storekeeper vps;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_principal_storekeeper(View_principal_storekeeper vps) {
		this.vps = vps;
		this.vps.btn_regis_producto.addActionListener(this);
		this.vps.btn_regis_proveedor.addActionListener(this);
		this.vps.btn_salir.addActionListener(this);
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}
	
	private void traduccion() {
		vps.btn_regis_producto.setText(Logica_View_login.bundle.getString("btn_regis_producto"));
		vps.btn_salir.setText(Logica_View_login.bundle.getString("btn_salir"));
		vps.btn_regis_proveedor.setText(Logica_View_login.bundle.getString("btn_regis_proveedor"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vps.btn_salir)
		{
			View_login lv = new View_login();
			lv.setVisible(true);
			vps.dispose();
		}
		else if(e.getSource()==vps.btn_regis_producto)
		{
			if(!Administrar_info.proveedores.isEmpty())
			{
				View_register_product vr = new View_register_product();
				vr.setVisible(true);
				vps.dispose();
			}
			else
			{
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vps, "No hay proveedores ingresados");
				}else if (idioma == "en_En") {
					JOptionPane.showMessageDialog(vps, "No record of suppliers");
				}
				
			}	
		}
		else
		{
			View_register_supplier vrs = new View_register_supplier();
			vrs.setVisible(true);
			vps.dispose();
		}
		
	}
	
}
