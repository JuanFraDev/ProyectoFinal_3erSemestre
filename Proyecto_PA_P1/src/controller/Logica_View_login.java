package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.Empleado;
import view.View_login;
import view.View_principal_admin;
import view.View_principal_salesman;
import view.View_principal_storekeeper;

public class Logica_View_login implements ActionListener, FocusListener {

	private View_login vl;
	private int type;
	public static ResourceBundle bundle=ResourceBundle.getBundle("idiomas/es_Es");
	public static SharedComboBoxValue sharedValue = new SharedComboBoxValue();

	public Logica_View_login(View_login vl) {
		this.vl = vl;
		this.vl.btn_login.addActionListener(this);
		Administrar_info.contador = 1;
		Administrar_info.resetArrayList();
		Administrar_info.getInfo();
		this.vl.cmb_idioma.addItem("es_Es");
		this.vl.cmb_idioma.addItem("en_En");
		this.vl.txt_user.addFocusListener(this);
		this.vl.cmb_idioma.addActionListener(this);
		this.vl.cmb_idioma.setSelectedIndex(0);
		traduccion();
	}

	private void traduccion() {
		vl.lbl_bienvenido.setText(bundle.getString("lbl_bienvenido"));
		vl.btn_login.setText(bundle.getString("btn_login"));
		vl.lbl_idioma.setText(bundle.getString("lbl_idioma"));
		vl.lbl_psw.setText(bundle.getString("lbl_psw"));
		vl.txt_user.setText(bundle.getString("txt_user"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vl.btn_login) {
			String psw = password(vl.txt_psw.getPassword());
			if(verificacion(vl.txt_user.getText().trim(), psw.trim())){
				if(type == 1) {
					View_principal_admin vpa = new View_principal_admin();
					vpa.setVisible(true);
					this.vl.dispose();
				} else if (type == 2) {
					View_principal_salesman vps = new View_principal_salesman();
					vps.setVisible(true);
					this.vl.dispose();
				}else {
					View_principal_storekeeper vpsk = new View_principal_storekeeper();
					vpsk.setVisible(true);
					this.vl.dispose();
				}

			} 
		}else if(e.getSource()==vl.cmb_idioma) {
			sharedValue.setValue(vl.cmb_idioma.getSelectedItem());
			bundle=ResourceBundle.getBundle("idiomas/"+vl.cmb_idioma.getSelectedItem());
			traduccion();
		}
	}

	private boolean verificacion(String user, String pass) {
		boolean flag = true;
		type = 0;
		for (Empleado e:Administrar_info.empleados)
		{
			if(user.equals(e.getUsuario()) && pass.equals(e.getContrasena()))
			{
				flag = true;
				type = e.getRol();
				break;
			}
			else
			{
				flag = false;
			}
		}
		if(!flag) 
		{
			if(vl.cmb_idioma.getSelectedItem().toString() == "es_Es") {
				JOptionPane.showMessageDialog(vl, "Usuario y/o contraseña incorrecta");
			}else {
				JOptionPane.showMessageDialog(vl, "User or password not found");
			}
		}
		return flag;
	}

	private String password(char [] pass) {
		String aux = "";
		for(char c : pass) {
			aux += c;
		}
		return aux;
	} 

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if (vl.txt_user.getText().equals("Usuario")) {
			vl.txt_user.setText("");
			vl.txt_user.setForeground(Color.BLACK);
		}else if (vl.txt_user.getText().equals("User")) {
			vl.txt_user.setText("");
			vl.txt_user.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (vl.txt_user.getText().isEmpty() && vl.cmb_idioma.getSelectedItem().toString() == "es_Es") {
			vl.txt_user.setForeground(Color.GRAY);
			vl.txt_user.setText("Usuario");
		}else if (vl.txt_user.getText().isEmpty() && vl.cmb_idioma.getSelectedItem().toString() == "en_En"){
			vl.txt_user.setForeground(Color.GRAY);
			vl.txt_user.setText("User");
		}
	}

}

