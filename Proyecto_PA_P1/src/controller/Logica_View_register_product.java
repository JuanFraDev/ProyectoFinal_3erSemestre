package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.Producto;
import model.Proveedor;
import view.View_list_product;
import view.View_principal_storekeeper;
import view.View_register_product;

public class Logica_View_register_product implements ActionListener, FocusListener{
	private View_register_product vrp;
	private Producto p;
	private String errores, errors, tipo="";
	private boolean flag;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_register_product(View_register_product vrp) {
		this.vrp = vrp;
		this.vrp.btn_cancelar.addActionListener(this);
		this.vrp.btn_registrar.addActionListener(this);	
		this.vrp.btn_listar.addActionListener(this);
		this.vrp.txt_codigo.addFocusListener(this);
		this.vrp.txt_nombres.addFocusListener(this);
		this.vrp.rdbtn_peso.addActionListener(this);
		this.vrp.rdbtn_unidad.addActionListener(this);
		this.vrp.rdbtn_unidad.setSelected(true);
		this.vrp.spn_peso.setEnabled(false);
		tipo="Unidad";
		setProveedores();
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}
	
	public void traduccion() {
		vrp.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));
		vrp.btn_registrar.setText(Logica_View_login.bundle.getString("btn_registrar"));
		vrp.btn_listar.setText(Logica_View_login.bundle.getString("btn_listar"));
		vrp.lbl_precio.setText(Logica_View_login.bundle.getString("lbl_precio"));
		vrp.lbl_unidades.setText(Logica_View_login.bundle.getString("lbl_unidades"));
		vrp.lbl_proveedor.setText(Logica_View_login.bundle.getString("lbl_proveedor"));
		vrp.txt_nombres.setText(Logica_View_login.bundle.getString("txt_nombres"));
		vrp.txt_codigo.setText(Logica_View_login.bundle.getString("txt_codigo"));
		vrp.lbl_peso.setText(Logica_View_login.bundle.getString("lbl_peso"));
		vrp.rdbtn_peso.setText(Logica_View_login.bundle.getString("rdbtn_peso"));
		vrp.rdbtn_unidad.setText(Logica_View_login.bundle.getString("rdbtn_unidad"));
	}

	private void setProveedores()
	{
		for(Proveedor p:Administrar_info.proveedores) 
		{
			this.vrp.cbx_proveedor.addItem(p.getRazon());
		}
	}

	private void vaciarCampos()
	{
		this.vrp.dispose();
		this.vrp = new View_register_product();
		this.vrp.setVisible(true);
		
	}

	private String validateProduct()
	{
		String existe="";
		for(Producto p:Administrar_info.productos){
			if(p.getName().equals(this.vrp.txt_nombres.getText())){
				existe = "Nombre";
				break;
			}

			if(p.getCodigo().equals(this.vrp.txt_codigo.getText())){
				existe = "Código";
				break;
			}
		}
		return existe;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == vrp.btn_registrar) {
			flag = true;
			errores = "";
			errors="";
			if(!ValidateByER.validateCodigo(vrp.txt_codigo.getText())) {
				vrp.txt_codigo.setText("");
				errores+="\nCódigo";
				errors+="\nCode";
				flag = false;
			}
			if(!ValidateByER.validateNombre(vrp.txt_nombres.getText())) {
				vrp.txt_nombres.setText("");
				errores+="\nNombre";
				errors+="\nName";
				flag = false;
			}

			if(!flag) {
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vrp, "Los campos incorrectos son: " + errores);
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vrp, "The incorrect fields are: " + errors);
				}
				
			}else {
				flag = false;
				if(validateProduct().isEmpty()) 
				{
					System.out.println(vrp.spn_precio.getValue().toString());
					if(!vrp.spn_precio.getValue().toString().equals("0.0"))
					{
						if(tipo.equals("Peso"))
						{
							System.out.println("a");
							p = new Producto(vrp.txt_codigo.getText(), vrp.txt_nombres.getText(), 
									vrp.spn_peso.getValue().toString(), null, vrp.spn_precio.getValue().toString(), 
									vrp.cbx_proveedor.getSelectedItem().toString(), tipo);
							flag = true;
						}
						else if(tipo.equals("Unidad"))
						{
							System.out.println("b");
							p = new Producto(vrp.txt_codigo.getText(), vrp.txt_nombres.getText(), 
									null, vrp.spn_unidades.getValue().toString(), vrp.spn_precio.getValue().toString(), 
									vrp.cbx_proveedor.getSelectedItem().toString(), tipo);
							flag = true;
						}
					}
					else
					{
						if(idioma == "es_Es") {
							JOptionPane.showMessageDialog(vrp, "El precio debe ser mayor que $0");
						}else if(idioma == "en_En") {
							JOptionPane.showMessageDialog(vrp, "The price must be higher than $0");
						}
					}
				}else {
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vrp, "Ya existe un producto con el "+validateProduct()+" ingresado");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vrp, "There is already a product with "+validateProduct()+" in the system");
					}
					
				}

				if(flag) {
					Administrar_info.productos.add(p);
					Administrar_info.prodao.insertProducto(p);
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vrp, "Producto ingresado correctamente");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vrp, "Product registered correctly");
					}
					
					vaciarCampos();
				}
			}
		}else if (e.getSource() == vrp.btn_cancelar) {
			View_principal_storekeeper vps = new View_principal_storekeeper();
			vps.setVisible(true);
			vrp.dispose();
		}
		else if (e.getSource() == vrp.btn_listar)
		{
			View_list_product lvp = new View_list_product();
			lvp.setVisible(true);
			vrp.dispose();
		}
		else if(e.getSource() == vrp.rdbtn_peso)
		{
			vrp.rdbtn_unidad.setSelected(false);
			vrp.spn_unidades.setEnabled(false);
			vrp.spn_peso.setEnabled(true);
			tipo = "Peso";
		}
		else
		{
			vrp.rdbtn_peso.setSelected(false);
			vrp.spn_peso.setEnabled(false);
			vrp.spn_unidades.setEnabled(true);
			tipo = "Unidad";
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == vrp.txt_nombres) {
			if (vrp.txt_nombres.getText().equals("Nombres")  ) {
				vrp.txt_nombres.setText("");
				vrp.txt_nombres.setForeground(Color.BLACK);
			}else if (vrp.txt_nombres.getText().equals("Names")) {
				vrp.txt_nombres.setText("");
				vrp.txt_nombres.setForeground(Color.BLACK);
			}
		}else if(e.getComponent() == vrp.txt_codigo) {
			if (vrp.txt_codigo.getText().equals("Código") ) {
				vrp.txt_codigo.setText("");
				vrp.txt_codigo.setForeground(Color.BLACK);
			}else if (vrp.txt_codigo.getText().equals("Code") ) {
				vrp.txt_codigo.setText("");
				vrp.txt_codigo.setForeground(Color.BLACK);
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == vrp.txt_nombres) {
			if (vrp.txt_nombres.getText().isEmpty() && 
					idioma == "es_Es") {
				vrp.txt_nombres.setForeground(Color.GRAY);
				vrp.txt_nombres.setText("Nombres");
			}else if (vrp.txt_nombres.getText().isEmpty() && 
					idioma == "en_En"){
				vrp.txt_nombres.setForeground(Color.GRAY);
				vrp.txt_nombres.setText("Names");
			}
		}else if(e.getComponent() == vrp.txt_codigo) {
			if (vrp.txt_codigo.getText().isEmpty() && 
					idioma == "es_Es") {
				vrp.txt_codigo.setForeground(Color.GRAY);
				vrp.txt_codigo.setText("Código");
			}else if (vrp.txt_codigo.getText().isEmpty() && 
					idioma == "en_En"){
				vrp.txt_codigo.setForeground(Color.GRAY);
				vrp.txt_codigo.setText("Code");
			}
		}
	}


}
