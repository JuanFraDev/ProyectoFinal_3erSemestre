package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.Empleado;
import model.Proveedor;
import view.View_principal_storekeeper;
import view.View_register_supplier;

public class Logica_View_register_supplier implements ActionListener, FocusListener{
	private View_register_supplier vrs;
	private String errores, errors;
	private Proveedor p;
	private boolean flag = true;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_register_supplier(View_register_supplier vrs) {
		super();
		this.vrs = vrs;
		this.vrs.btn_cancelar.addActionListener(this);
		this.vrs.btn_registrar.addActionListener(this);
		this.vrs.txt_apellidos.addFocusListener(this);
		this.vrs.txt_codigo.addFocusListener(this);
		this.vrs.txt_email.addFocusListener(this);
		this.vrs.txt_nombres.addFocusListener(this);
		this.vrs.txt_razon.addFocusListener(this);
		this.vrs.txt_telefono1.addFocusListener(this);
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}
	
	public void traduccion() {
		vrs.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));
		vrs.btn_registrar.setText(Logica_View_login.bundle.getString("btn_registrar"));
		vrs.txt_apellidos.setText(Logica_View_login.bundle.getString("txt_apellidos"));
		vrs.txt_nombres.setText(Logica_View_login.bundle.getString("txt_nombres"));
		vrs.txt_email.setText(Logica_View_login.bundle.getString("txt_email"));
		vrs.txt_codigo.setText(Logica_View_login.bundle.getString("txt_codigo"));
		vrs.txt_razon.setText(Logica_View_login.bundle.getString("txt_Razon"));
		vrs.txt_telefono1.setText(Logica_View_login.bundle.getString("txt_telefono1"));
	}

	private void vaciarCampos(){
		this.vrs.dispose();
		this.vrs = new View_register_supplier();
		this.vrs.setVisible(true);
	}

	private String validateSupplier(){
		String existe="";
		for(Proveedor p:Administrar_info.proveedores){
			if(p.getContacto().equals(this.vrs.txt_nombres.getText()+" "+this.vrs.txt_apellidos.getText())){
				existe = "Contacto";
				break;
			}
			if(p.getRazon().equals(this.vrs.txt_razon.getText())){
				existe = "Razón Social";
				break;
			}
			if(p.getCodigo().equals(this.vrs.txt_codigo.getText())){
				existe = "Código";
				break;
			}
		}
		return existe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		flag = true;
		if(e.getSource() == vrs.btn_registrar) {
			errores = "";
			errors = "";
			if(!ValidateByER.validateConvencional(vrs.txt_telefono1.getText())) {
				vrs.txt_telefono1.setText("");
				errores+="\nTelefono";
				errors+="\nPhone";
				flag = false;
			}
			if(!ValidateByER.validateEmail(vrs.txt_email.getText())) {
				vrs.txt_telefono1.setText("");
				errores+="\nE-mail";
				errors+="\nE-mail";
				flag = false;
			}
			if(!ValidateByER.validateCodigo(vrs.txt_codigo.getText())) {
				vrs.txt_codigo.setText("");
				errores+="\nCódigo";
				errors+="\nCode";
				flag = false;
			}
			if(!ValidateByER.validateNombre(vrs.txt_nombres.getText())) {
				vrs.txt_nombres.setText("");
				errores+="\nNombres";
				errors+="\nNames";
				flag = false;
			}
			if(!ValidateByER.validateNombre(vrs.txt_apellidos.getText())) {
				vrs.txt_apellidos.setText("");
				errores+="\nApellidos";
				errors+="\nLastNames";
				flag = false;
			}

			if(!flag) {
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vrs, "Los campos incorrectos son: " + errores);
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vrs, "The incorrect fields are: " + errors);
				}
				
			}else {
				flag = false;
				if(validateSupplier().isEmpty()) {
					p = new Proveedor(vrs.txt_codigo.getText(),vrs.txt_razon.getText(),
							vrs.txt_nombres.getText()+" "+vrs.txt_apellidos.getText(), vrs.txt_telefono1.getText(),
							vrs.txt_email.getText());
					flag = true;
				}else {
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vrs, "Ya existe un proveedor con el "+validateSupplier()+" ingresado");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vrs, "There is already a supplier with "+validateSupplier()+" registered");
					}
					
				}
				if(flag) {
					Administrar_info.proveedores.add(p);
					Administrar_info.pdao.insertProveedor(p);
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vrs,"Proveedor registrado exitosamente!");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vrs,"Supplier registered correctly!");
					}
					vaciarCampos();
				}
			}

		}else if (e.getSource() == vrs.btn_cancelar) {
			View_principal_storekeeper vps = new View_principal_storekeeper();
			vps.setVisible(true);
			this.vrs.dispose();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == vrs.txt_nombres) {
			if (vrs.txt_nombres.getText().equals("Nombres") || 
					vrs.txt_nombres.getText().equals("Names") ) {
				vrs.txt_nombres.setText("");
				vrs.txt_nombres.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrs.txt_codigo) {
			if (vrs.txt_codigo.getText().equals("Código") || 
					vrs.txt_codigo.getText().equals("Code") ) {
				vrs.txt_codigo.setText("");
				vrs.txt_codigo.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrs.txt_apellidos) {
			if (vrs.txt_apellidos.getText().equals("Apellidos") || 
					vrs.txt_apellidos.getText().equals("Last Names")) {
				vrs.txt_apellidos.setText("");
				vrs.txt_apellidos.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrs.txt_email) {
			if (vrs.txt_email.getText().equals("Email") || 
					vrs.txt_email.getText().equals("Email")) {
				vrs.txt_email.setText("");
				vrs.txt_email.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrs.txt_telefono1) {
			if (vrs.txt_telefono1.getText().equals("Teléfono Convencional") || 
					vrs.txt_telefono1.getText().equals("Phone")) {
				vrs.txt_telefono1.setText("");
				vrs.txt_telefono1.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrs.txt_razon) {
			if (vrs.txt_razon.getText().equals("Razon") || 
					vrs.txt_razon.getText().equals("Business name")) {
				vrs.txt_razon.setText("");
				vrs.txt_razon.setForeground(Color.BLACK);
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == vrs.txt_nombres) {
			if (vrs.txt_nombres.getText().isEmpty() && 
					idioma == "es_Es") {
				vrs.txt_nombres.setForeground(Color.GRAY);
				vrs.txt_nombres.setText("Nombres");
			}else if (vrs.txt_nombres.getText().isEmpty() && 
					idioma == "en_En"){
				vrs.txt_nombres.setForeground(Color.GRAY);
				vrs.txt_nombres.setText("Names");
			}
		}else if(e.getComponent() == vrs.txt_codigo) {
			if (vrs.txt_codigo.getText().isEmpty() && 
					idioma == "es_Es") {
				vrs.txt_codigo.setForeground(Color.GRAY);
				vrs.txt_codigo.setText("Código");
			}else if (vrs.txt_codigo.getText().isEmpty() && 
					idioma == "en_En"){
				vrs.txt_codigo.setForeground(Color.GRAY);
				vrs.txt_codigo.setText("Code");
			}
		}else if(e.getComponent() == vrs.txt_apellidos) {
			if (vrs.txt_apellidos.getText().isEmpty() && 
					idioma == "es_Es") {
				vrs.txt_apellidos.setForeground(Color.GRAY);
				vrs.txt_apellidos.setText("Apellidos");
			}else if (vrs.txt_apellidos.getText().isEmpty() && 
					idioma == "en_En") {
				vrs.txt_apellidos.setForeground(Color.GRAY);
				vrs.txt_apellidos.setText("Last Names");
			}
		}else if(e.getComponent() == vrs.txt_email) {
			if (vrs.txt_email.getText().isEmpty() && 
					idioma == "es_Es") {
				vrs.txt_email.setForeground(Color.GRAY);
				vrs.txt_email.setText("Email");
			}else if (vrs.txt_email.getText().isEmpty() && 
					idioma == "en_En") {
				vrs.txt_email.setForeground(Color.GRAY);
				vrs.txt_email.setText("Email");
			}
		}else if(e.getComponent() == vrs.txt_telefono1) {
			if (vrs.txt_telefono1.getText().isEmpty() && 
					idioma == "es_Es") {
				vrs.txt_telefono1.setForeground(Color.GRAY);
				vrs.txt_telefono1.setText("Teléfono Convencional");
			}else if (vrs.txt_telefono1.getText().isEmpty() && 
					idioma == "en_En") {
				vrs.txt_telefono1.setForeground(Color.GRAY);
				vrs.txt_telefono1.setText("Phone");
			}
		}else if(e.getComponent() == vrs.txt_razon) {
			if (vrs.txt_razon.getText().isEmpty() && 
					idioma == "es_Es") {
				vrs.txt_razon.setForeground(Color.GRAY);
				vrs.txt_razon.setText("Razon");
			}else if (vrs.txt_razon.getText().isEmpty() && 
					idioma == "en_En") {
				vrs.txt_razon.setForeground(Color.GRAY);
				vrs.txt_razon.setText("Business name");
			}
		}
	}

}
