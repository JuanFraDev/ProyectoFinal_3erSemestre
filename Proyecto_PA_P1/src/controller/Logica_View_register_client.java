package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.Cliente;
import view.View_principal_salesman;
import view.View_register_client;

public class Logica_View_register_client implements ActionListener, FocusListener{

	private View_register_client vrc;
	private String errores, clientes, errors;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_register_client(View_register_client vrc)
	{
		this.vrc=vrc;
		this.vrc.btn_registrar.addActionListener(this);
		this.vrc.btn_cancelar.addActionListener(this);
		this.vrc.txt_apellidos.addFocusListener(this);
		this.vrc.txt_cedula.addFocusListener(this);
		this.vrc.txt_correo.addFocusListener(this);
		this.vrc.txt_direccion.addFocusListener(this);
		this.vrc.txt_nombres.addFocusListener(this);
		this.vrc.txt_telefono1.addFocusListener(this);
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}

	private void traduccion() {
		vrc.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));
		vrc.btn_registrar.setText(Logica_View_login.bundle.getString("btn_registrar"));
		vrc.txt_apellidos.setText(Logica_View_login.bundle.getString("txt_apellidos"));
		vrc.txt_cedula.setText(Logica_View_login.bundle.getString("txt_cedula"));
		vrc.txt_correo.setText(Logica_View_login.bundle.getString("txt_correo"));
		vrc.txt_direccion.setText(Logica_View_login.bundle.getString("txt_direccion"));
		vrc.txt_nombres.setText(Logica_View_login.bundle.getString("txt_nombres"));
		vrc.txt_telefono1.setText(Logica_View_login.bundle.getString("txt_telefono1"));
	}

	private void reiniciar()
	{
		this.vrc.dispose();
		this.vrc = new View_register_client();
		this.vrc.setVisible(true);
	}

	private String validateClient()
	{
		String existe="";
		for(Cliente e:Administrar_info.clientes)
		{
			if(e.getName().equals(this.vrc.txt_nombres.getText()+" "+this.vrc.txt_apellidos.getText()))
			{
				existe = "nombre";
				break;
			}
			if(e.getCedula().equals(this.vrc.txt_cedula.getText()))
			{
				existe = "número de cédula";
				break;
			}
		}
		return existe;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if(e.getSource()==this.vrc.btn_registrar)
		{
			errores = "";
			errors = "";
			if(!ValidateByER.validateNames(vrc.txt_nombres.getText())) {
				errores += "\nNombres"; 
				errors += "\nNames"; 
				flag = false;
			}
			if(!ValidateByER.validateNames(vrc.txt_apellidos.getText())) {
				errores += "\nApellidos"; 
				errors += "\nLastNames"; 
				flag = false;
			}
			if(!ValidateByER.validateCi(vrc.txt_cedula.getText())) {
				errores += "\nCedula";
				errors += "\nID"; 
				flag = false;
			}
			if(!ValidateByER.validateEmail(vrc.txt_correo.getText())) {
				errores += "\nEmail";
				errors += "\nEmail"; 
				flag = false;
			}
			if(!ValidateByER.validateConvencional(vrc.txt_telefono1.getText())) {
				errores += "\nNúmero convencional";
				errors += "\nPhone"; 
				flag = false;
			}
			if(!ValidateByER.validateDireccion(vrc.txt_direccion.getText())) {
				errores += "\nDirección";
				errors += "\nAddress"; 
				flag = false;
			}
			if(!flag) {
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vrc, "Los campos incorrectos son: " + errores);
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vrc, "The incorrect fields are: " + errors);
				}
				
			}
			else
			{
				flag=false;
				if(validateClient().isEmpty())
				{
					flag = true;
				}
				else
				{
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vrc, "Ya existe un cliente con el "+validateClient()+" ingresado");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vrc, "There is already a client with "+validateClient()+" registered");
					}
					
					
				}
				if(flag)
				{
					Cliente cl = new Cliente(vrc.txt_nombres.getText()+" "+vrc.txt_apellidos.getText(),vrc.txt_cedula.getText(),
							vrc.txt_correo.getText(),vrc.txt_telefono1.getText(), vrc.txt_direccion.getText());
					Administrar_info.clientes.add(cl);
					Administrar_info.cdao.insertCliente(cl);
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vrc,"Cliente registrado exitosamente!");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vrc,"Client registered correctly!");
					}
					
					
					reiniciar();
				}
			}
		}
		else
		{
			View_principal_salesman vps =new View_principal_salesman();
			vps.setVisible(true);
			vrc.dispose();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == vrc.txt_nombres) {
			if (vrc.txt_nombres.getText().equals("Nombres") || 
					vrc.txt_nombres.getText().equals("Names") ) {
				vrc.txt_nombres.setText("");
				vrc.txt_nombres.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrc.txt_apellidos) {
			if (vrc.txt_apellidos.getText().equals("Apellidos") || 
					vrc.txt_apellidos.getText().equals("Last Names")) {
				vrc.txt_apellidos.setText("");
				vrc.txt_apellidos.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrc.txt_cedula) {
			if (vrc.txt_cedula.getText().equals("Cédula") || 
					vrc.txt_cedula.getText().equals("ID")) {
				vrc.txt_cedula.setText("");
				vrc.txt_cedula.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrc.txt_correo) {
			if (vrc.txt_correo.getText().equals("Correo Electrónico") || 
					vrc.txt_correo.getText().equals("E-mail")) {
				vrc.txt_correo.setText("");
				vrc.txt_correo.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrc.txt_direccion) {
			if (vrc.txt_direccion.getText().equals("Dirección") || 
					vrc.txt_direccion.getText().equals("Address")) {
				vrc.txt_direccion.setText("");
				vrc.txt_direccion.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrc.txt_telefono1) {
			if (vrc.txt_telefono1.getText().equals("Teléfono Convencional") || 
					vrc.txt_telefono1.getText().equals("Phone")) {
				vrc.txt_telefono1.setText("");
				vrc.txt_telefono1.setForeground(Color.BLACK);
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == vrc.txt_nombres) {
			if (vrc.txt_nombres.getText().isEmpty() && 
					idioma == "es_Es") {
				vrc.txt_nombres.setForeground(Color.GRAY);
				vrc.txt_nombres.setText("Nombres");
			}else if (vrc.txt_nombres.getText().isEmpty() && 
					idioma == "en_En"){
				vrc.txt_nombres.setForeground(Color.GRAY);
				vrc.txt_nombres.setText("Names");
			}
		}else if(e.getComponent() == vrc.txt_apellidos) {
			if (vrc.txt_apellidos.getText().isEmpty() && 
					idioma == "es_Es") {
				vrc.txt_apellidos.setForeground(Color.GRAY);
				vrc.txt_apellidos.setText("Apellidos");
			}else if (vrc.txt_apellidos.getText().isEmpty() && 
					idioma == "en_En") {
				vrc.txt_apellidos.setForeground(Color.GRAY);
				vrc.txt_apellidos.setText("Last Names");
			}
		}else if(e.getComponent() == vrc.txt_cedula) {
			if (vrc.txt_cedula.getText().isEmpty() && 
					idioma == "es_Es") {
				vrc.txt_cedula.setForeground(Color.GRAY);
				vrc.txt_cedula.setText("Cédula");
			}else if (vrc.txt_cedula.getText().isEmpty() && 
					idioma == "en_En") {
				vrc.txt_cedula.setForeground(Color.GRAY);
				vrc.txt_cedula.setText("ID");
			}
		}else if(e.getComponent() == vrc.txt_correo) {
			if (vrc.txt_correo.getText().isEmpty() && 
					idioma == "es_Es") {
				vrc.txt_correo.setForeground(Color.GRAY);
				vrc.txt_correo.setText("Correo Electrónico");
			}else if (vrc.txt_correo.getText().isEmpty() && 
					idioma == "en_En") {
				vrc.txt_correo.setForeground(Color.GRAY);
				vrc.txt_correo.setText("E-mail");
			}
		}else if(e.getComponent() == vrc.txt_direccion) {
			if (vrc.txt_direccion.getText().isEmpty() && 
					idioma == "es_Es") {
				vrc.txt_direccion.setForeground(Color.GRAY);
				vrc.txt_direccion.setText("Dirección");
			}else if (vrc.txt_direccion.getText().isEmpty() && 
					idioma == "en_En") {
				vrc.txt_direccion.setForeground(Color.GRAY);
				vrc.txt_direccion.setText("Address");
			}
		}else if(e.getComponent() == vrc.txt_telefono1) {
			if (vrc.txt_telefono1.getText().isEmpty() && 
					idioma == "es_Es") {
				vrc.txt_telefono1.setForeground(Color.GRAY);
				vrc.txt_telefono1.setText("Teléfono Convencional");
			}else if (vrc.txt_telefono1.getText().isEmpty() && 
					idioma == "en_En") {
				vrc.txt_telefono1.setForeground(Color.GRAY);
				vrc.txt_telefono1.setText("Phone");
			}
		}
	}

}
