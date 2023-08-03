package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.Administrador;
import model.Bodeguero;
import model.Vendedor;
import model.Empleado;
import view.View_principal_admin;
import view.View_register_client;
import view.View_register_employee;

public class Logica_View_register_employee implements ActionListener, FocusListener{

	private View_register_employee vre;
	private Date fecha = new Date();
	private Empleado emp;
	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	private String fechaString = "", credencial;
	private String perfil, profile,errors= "", errores = "";
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_register_employee(View_register_employee vre) {
		this.vre = vre;
		this.vre.btn_cancelar.addActionListener(this);
		this.vre.btn_registrar.addActionListener(this);
		this.vre.rdbtn_vendedor.setSelected(true);
		this.vre.rdbtn_admin.addActionListener(this);
		this.vre.rdbtn_bodeguero.addActionListener(this);
		this.vre.rdbtn_vendedor.addActionListener(this);
		this.vre.txt_codigo.setText(Administrar_info.codigo+Administrar_info.contador);		
		fechaString = formato.format(fecha);
		this.vre.txt_nombres.addFocusListener(this);
		this.vre.txt_apellidos.addFocusListener(this);
		this.vre.txt_cedula.addFocusListener(this);
		this.vre.txt_correo.addFocusListener(this);
		this.vre.txt_direccion.addFocusListener(this);
		this.vre.txt_telefono1.addFocusListener(this);
		this.vre.txt_telefono2.addFocusListener(this);
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}

	public void traduccion() {
		vre.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));
		vre.btn_registrar.setText(Logica_View_login.bundle.getString("btn_registrar"));
		vre.lbl_codigo.setText(Logica_View_login.bundle.getString("lbl_codigo"));
		vre.lbl_perfil.setText(Logica_View_login.bundle.getString("lbl_perfil"));
		vre.rdbtn_admin.setText(Logica_View_login.bundle.getString("rdbtn_admin"));
		vre.rdbtn_bodeguero.setText(Logica_View_login.bundle.getString("rdbtn_bodeguero"));
		vre.rdbtn_vendedor.setText(Logica_View_login.bundle.getString("rdbtn_vendedor"));
		vre.txt_apellidos.setText(Logica_View_login.bundle.getString("txt_apellidos"));
		vre.txt_cedula.setText(Logica_View_login.bundle.getString("txt_cedula"));
		vre.txt_correo.setText(Logica_View_login.bundle.getString("txt_correo"));
		vre.txt_direccion.setText(Logica_View_login.bundle.getString("txt_direccion"));
		vre.txt_nombres.setText(Logica_View_login.bundle.getString("txt_nombres"));
		vre.txt_telefono1.setText(Logica_View_login.bundle.getString("txt_telefono1"));
		vre.txt_telefono2.setText(Logica_View_login.bundle.getString("txt_telefono2"));

	}

	private void vaciarCampos()
	{

		this.vre.dispose();
		this.vre = new View_register_employee();
		this.vre.setVisible(true);
	}

	private String validateEmployee()
	{
		String existe="";
		for(Empleado e:Administrar_info.empleados)
		{
			if(e.getName().equals(this.vre.txt_nombres.getText()+" "+this.vre.txt_apellidos.getText()))
			{
				existe = "nombre";
				break;
			}
			if(String.valueOf(e.getCedula()).equals(this.vre.txt_cedula.getText()))
			{
				existe = "número de cédula";
				break;
			}
		}
		return existe;
	}

	public String generateCredentials(String perfil)
	{
		int i = 2;
		String usuario, rol="", identificador="";
		credencial="";
		String [] nombre = new String[2];
		String [] apellido = new String[2];
		switch(perfil)
		{
		case "Administrador":
			rol = "@adm";
			identificador="1";
			break;
		case "Vendedor":
			rol = "@sel";
			identificador="2";

			break;
		case "Bodeguero":
			rol = "@sto";
			identificador="3";
			break;
		}
		nombre = this.vre.txt_nombres.getText().split(" ");
		apellido = this.vre.txt_apellidos.getText().split(" ");
		usuario = nombre[0].charAt(0)+apellido[0]+apellido[1].charAt(0);
		usuario = usuario.toLowerCase();
		String correo, usuario_aux=usuario;
		for(String s:Administrar_info.credenciales)
		{
			String aux2[] = s.split("@");
			while(aux2[0].trim().equals(usuario))
			{
				usuario=usuario_aux+i;
				i++;
			}
		}	
		correo = usuario+rol+".st.com";
		credencial = correo;
		Administrar_info.credenciales.add(credencial);
		return correo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if(e.getSource() == vre.btn_registrar) {
			errors = "";
			if(!ValidateByER.validateNames(vre.txt_nombres.getText())) {
				errors += "\nNames"; 
				errores += "\nNombres";
				flag = false;
			}
			if(!ValidateByER.validateNames(vre.txt_apellidos.getText())) {
				errors += "\nLastNames"; 
				errores += "\nApellidos"; 
				flag = false;
			}
			if(!ValidateByER.validateCi(vre.txt_cedula.getText())) {
				errors += "\nCedula";
				errores += "\nID";
				flag = false;
			}
			if(!ValidateByER.validateEmail(vre.txt_correo.getText())) {
				errors += "\nEmail";
				errores += "\nEmail";
				flag = false;
			}
			if(!ValidateByER.validateConvencional(vre.txt_telefono1.getText())) {
				errors += "\nPhone";
				errores += "\nNúmero convencional";
				flag = false;
			}
			if(!ValidateByER.validateCelular(vre.txt_telefono2.getText())) {
				errors += "\nCellphone";
				errores += "\nNúmero celular";
				flag = false;
			}
			if(!ValidateByER.validateDireccion(vre.txt_direccion.getText())) {
				errors += "\nDirección";
				errores += "\nAddress";
				flag = false;
			}
			if(vre.rdbtn_admin.isSelected()) {
				perfil = "Administrador";
				profile = "Adminitrator";
			}else if(vre.rdbtn_bodeguero.isSelected()) {
				perfil = "Bodeguero";
				profile = "Storekeeper";
			}else if(vre.rdbtn_vendedor.isSelected()){
				perfil = "Vendedor";
				profile = "Salesman";
			}
				

			if(!flag) {
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vre, "Los campos incorrectos son: " + errores);
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vre, "The incorrect fields are: " + errors);
				}
			}
			else
			{
				flag=false;
				switch(perfil)
				{
				case "Administrador":
					if(validateEmployee().isEmpty())
					{
						emp = new Administrador(Administrar_info.codigo+Administrar_info.contador,vre.txt_nombres.getText()+" "+vre.txt_apellidos.getText(),
								Integer.parseInt(vre.txt_cedula.getText()), vre.txt_correo.getText(), vre.txt_telefono1.getText(), vre.txt_telefono2.getText(), 
								vre.txt_direccion.getText(), fechaString, generateCredentials(perfil), vre.txt_cedula.getText(), 1);
						flag=true;
						break;
					}
					else
					{
						if(idioma == "es_Es") {
							JOptionPane.showMessageDialog(vre, "Ya existe un empleado con el "+validateEmployee()+" ingresado");
						}else if(idioma == "en_En") {
							JOptionPane.showMessageDialog(vre, "There is already an employee with "+validateEmployee()+" in the system");
						}
						
						break;
					}
				case "Bodeguero":
					if(validateEmployee().isEmpty())
					{
						emp = new Bodeguero(vre.txt_codigo.getText(),vre.txt_nombres.getText()+" "+vre.txt_apellidos.getText(),
								Integer.parseInt(vre.txt_cedula.getText()), vre.txt_correo.getText(), vre.txt_telefono1.getText(), vre.txt_telefono2.getText(), 
								vre.txt_direccion.getText(), fechaString, generateCredentials(perfil), vre.txt_cedula.getText(), 3);
						flag=true;
						break;
					}
					else
					{
						if(idioma == "es_Es") {
							JOptionPane.showMessageDialog(vre, "Ya existe un empleado con el "+validateEmployee()+" ingresado");
						}else if(idioma == "en_En") {
							JOptionPane.showMessageDialog(vre, "There is already an employee with "+validateEmployee()+" in the system");
						}
						break;
					}
				case "Vendedor":
					if(validateEmployee().isEmpty())
					{
						emp = new Vendedor(vre.txt_codigo.getText(),vre.txt_nombres.getText()+" "+vre.txt_apellidos.getText(),
								Integer.parseInt(vre.txt_cedula.getText()), vre.txt_correo.getText(), vre.txt_telefono1.getText(), vre.txt_telefono2.getText(), 
								vre.txt_direccion.getText(), fechaString, generateCredentials(perfil), vre.txt_cedula.getText(), 2);
						flag=true;
						break;
					}
					else
					{
						if(idioma == "es_Es") {
							JOptionPane.showMessageDialog(vre, "Ya existe un empleado con el "+validateEmployee()+" ingresado");
						}else if(idioma == "en_En") {
							JOptionPane.showMessageDialog(vre, "There is already an employee with "+validateEmployee()+" in the system");
						}
						break;
					}
				}
				if(flag)
				{
					Administrar_info.empleados.add(emp);
					Administrar_info.edao.insertEmpleado(emp);
					Administrar_info.contador++;
					
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vre, perfil+" registrado exitosamente!");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vre, profile+" register correctly!");
					}
					this.vre.txt_codigo.setText(Administrar_info.codigo+Administrar_info.contador);
					vaciarCampos();
				}
			}
		}
		else if(e.getSource()==vre.rdbtn_admin)
		{
			vre.rdbtn_bodeguero.setSelected(false);
			vre.rdbtn_vendedor.setSelected(false);
		}
		else if(e.getSource()==vre.rdbtn_bodeguero)
		{
			vre.rdbtn_admin.setSelected(false);
			vre.rdbtn_vendedor.setSelected(false);
		}
		else if(e.getSource()==vre.rdbtn_vendedor)
		{
			vre.rdbtn_admin.setSelected(false);
			vre.rdbtn_bodeguero.setSelected(false);
		}
		else
		{
			View_principal_admin vpa = new View_principal_admin();
			vpa.setVisible(true);
			this.vre.dispose();
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == vre.txt_nombres) {
			if (vre.txt_nombres.getText().equals("Nombres") || 
					vre.txt_nombres.getText().equals("Names") ) {
				vre.txt_nombres.setText("");
				vre.txt_nombres.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vre.txt_apellidos) {
			if (vre.txt_apellidos.getText().equals("Apellidos") || 
					vre.txt_apellidos.getText().equals("Last Names")) {
				vre.txt_apellidos.setText("");
				vre.txt_apellidos.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vre.txt_cedula) {
			if (vre.txt_cedula.getText().equals("Cédula") || 
					vre.txt_cedula.getText().equals("ID")) {
				vre.txt_cedula.setText("");
				vre.txt_cedula.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vre.txt_correo) {
			if (vre.txt_correo.getText().equals("Correo Electrónico") || 
					vre.txt_correo.getText().equals("E-mail")) {
				vre.txt_correo.setText("");
				vre.txt_correo.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vre.txt_direccion) {
			if (vre.txt_direccion.getText().equals("Dirección") || 
					vre.txt_direccion.getText().equals("Address")) {
				vre.txt_direccion.setText("");
				vre.txt_direccion.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vre.txt_telefono1) {
			if (vre.txt_telefono1.getText().equals("Teléfono Convencional") || 
					vre.txt_telefono1.getText().equals("Phone")) {
				vre.txt_telefono1.setText("");
				vre.txt_telefono1.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vre.txt_telefono2) {
			if (vre.txt_telefono2.getText().equals("Teléfono Celular") || 
					vre.txt_telefono2.getText().equals("Cellphone")) {
				vre.txt_telefono2.setText("");
				vre.txt_telefono2.setForeground(Color.BLACK);
			}
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == vre.txt_nombres) {
			if (vre.txt_nombres.getText().isEmpty() && 
					idioma == "es_Es") {
				vre.txt_nombres.setForeground(Color.GRAY);
				vre.txt_nombres.setText("Nombres");
			}else if (vre.txt_nombres.getText().isEmpty() && 
					idioma == "en_En"){
				vre.txt_nombres.setForeground(Color.GRAY);
				vre.txt_nombres.setText("Names");
			}
		}else if(e.getComponent() == vre.txt_apellidos) {
			if (vre.txt_apellidos.getText().isEmpty() && 
					idioma == "es_Es") {
				vre.txt_apellidos.setForeground(Color.GRAY);
				vre.txt_apellidos.setText("Apellidos");
			}else if (vre.txt_apellidos.getText().isEmpty() && 
					idioma == "en_En") {
				vre.txt_apellidos.setForeground(Color.GRAY);
				vre.txt_apellidos.setText("Last Names");
			}
		}else if(e.getComponent() == vre.txt_cedula) {
			if (vre.txt_cedula.getText().isEmpty() && 
					idioma == "es_Es") {
				vre.txt_cedula.setForeground(Color.GRAY);
				vre.txt_cedula.setText("Cédula");
			}else if (vre.txt_cedula.getText().isEmpty() && 
					idioma == "en_En") {
				vre.txt_cedula.setForeground(Color.GRAY);
				vre.txt_cedula.setText("ID");
			}
		}else if(e.getComponent() == vre.txt_correo) {
			if (vre.txt_correo.getText().isEmpty() && 
					idioma == "es_Es") {
				vre.txt_correo.setForeground(Color.GRAY);
				vre.txt_correo.setText("Correo Electrónico");
			}else if (vre.txt_correo.getText().isEmpty() && 
					idioma == "en_En") {
				vre.txt_correo.setForeground(Color.GRAY);
				vre.txt_correo.setText("E-mail");
			}
		}else if(e.getComponent() == vre.txt_direccion) {
			if (vre.txt_direccion.getText().isEmpty() && 
					idioma == "es_Es") {
				vre.txt_direccion.setForeground(Color.GRAY);
				vre.txt_direccion.setText("Dirección");
			}else if (vre.txt_direccion.getText().isEmpty() && 
					idioma == "en_En") {
				vre.txt_direccion.setForeground(Color.GRAY);
				vre.txt_direccion.setText("Address");
			}
		}else if(e.getComponent() == vre.txt_telefono1) {
			if (vre.txt_telefono1.getText().isEmpty() && 
					idioma == "es_Es") {
				vre.txt_telefono1.setForeground(Color.GRAY);
				vre.txt_telefono1.setText("Teléfono Convencional");
			}else if (vre.txt_telefono1.getText().isEmpty() && 
					idioma == "en_En") {
				vre.txt_telefono1.setForeground(Color.GRAY);
				vre.txt_telefono1.setText("Phone");
			}
		}else if(e.getComponent() == vre.txt_telefono2) {
			if (vre.txt_telefono2.getText().isEmpty() && 
					idioma == "es_Es") {
				vre.txt_telefono2.setForeground(Color.GRAY);
				vre.txt_telefono2.setText("Teléfono Celular");
			}else if (vre.txt_telefono2.getText().isEmpty() && 
					idioma == "en_En") {
				vre.txt_telefono2.setForeground(Color.GRAY);
				vre.txt_telefono2.setText("Cellphone");
			}
		}
	}
}
