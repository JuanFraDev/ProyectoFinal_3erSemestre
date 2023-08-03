package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.Empleado;
import view.View_change_password;
import view.View_login;

public class Logica_View_change_password implements ActionListener {
	private View_change_password vcp;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_change_password(View_change_password vcp) {
		super();
		this.vcp = vcp;
		this.vcp.btn_aceptar.addActionListener(this);
		this.vcp.btn_cancelar.addActionListener(this);
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}
	
	public void traduccion() {
		vcp.lbl_usuario.setText(Logica_View_login.bundle.getString("lbl_usuario"));
		vcp.lbl_ContrasenaNueva.setText(Logica_View_login.bundle.getString("lbl_ContrasenaNueva"));
		vcp.lbl_ConfirmarContrasena.setText(Logica_View_login.bundle.getString("lbl_ConfirmarContrasena"));
		vcp.lbl_ContrasenaActual.setText(Logica_View_login.bundle.getString("lbl_ContrasenaActual"));
		vcp.lblMostrarContrasenas.setText(Logica_View_login.bundle.getString("lblMostrarContrasenas"));
		vcp.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));
		vcp.btn_aceptar.setText(Logica_View_login.bundle.getString("btn_aceptar"));
	}
	/**
	 * Este método vacía los JTextField 
	 */
	public void vaciar() {
		vcp.txt_usuario.setText("");
		vcp.txt_actual.setText("");
		vcp.txt_nueva.setText("");
		vcp.txt_confirmar.setText("");
	}

	private String password(char [] pass) {
		String aux = "";
		for(char c : pass) {
			aux += c;
		}
		return aux;
	} 

	/**
	 * Este método permite cambiar la contraseña
	 */
	public void setContrasena() 
	{
		boolean exist=false;
		for(Empleado e:Administrar_info.empleados)
		{
			if(vcp.txt_usuario.getText().trim().equals(e.getUsuario()))
			{
				exist=true;
				String psw1 = new String (password(vcp.txt_actual.getPassword()));
				String psw_n = password(vcp.txt_nueva.getPassword());
				String psw_c = password(vcp.txt_confirmar.getPassword());
				if(psw1.trim().equals(e.getContrasena()))
				{
					if(psw_n.trim().equals(psw_c))
					{
						if(ValidateByER.password(psw_n))
						{
							e.setContrasena(psw_c);
							Administrar_info.edao.updatePassword(e);
							if(idioma == "es_Es") {
								JOptionPane.showMessageDialog(vcp, "La contraseña ha sido actualizada correctamente");
							}else if(idioma == "en_En") {
								JOptionPane.showMessageDialog(vcp, "Password saved correctry");
							}
							
							vaciar();
						}
						else
						{
							if(idioma == "es_Es") {
								JOptionPane.showMessageDialog(vcp, "La nueva contraseña no es válida");
							}else if(idioma == "en_En") {
								JOptionPane.showMessageDialog(vcp, "New password not valid");
							}
							
						}
					}
					else
					{
						if(idioma == "es_Es") {
							JOptionPane.showMessageDialog(vcp, "Las contraseñas ingresadas no coinciden");
						}else if(idioma == "en_En") {
							JOptionPane.showMessageDialog(vcp, "Passwords don't match");
						}
						
					}
				}
				else
				{
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vcp, "La contraseña de " +e.getUsuario()+" no es correcta");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vcp, "Password of " +e.getUsuario()+" incorrect");
					}
					

				}
				break;
			}
		}
		if(!exist)
		{
			if(idioma == "es_Es") {
				JOptionPane.showMessageDialog(vcp, "No existe el empleado ingresado");
			}else if(idioma == "en_En") {
				JOptionPane.showMessageDialog(vcp, "The employee doesn't exist");
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vcp.btn_aceptar) {
			setContrasena();
		} else if(e.getSource() == vcp.btn_cancelar) {
			View_login vl = new View_login();
			vl.setVisible(true);
			vcp.dispose();
		}
	}
	/**
	 * Este método se encarga de validar los distintos espacios a completar
	 */
	public boolean validacion() {
		if(!ValidateByER.emailCorp(vcp.txt_usuario.getText())) {
			vcp.txt_usuario.setText("");
			return false;
		}
		if(!ValidateByER.password(vcp.txt_nueva.getText())) {
			vcp.txt_nueva.setText("");
			return false;
		}
		if(!ValidateByER.password(vcp.txt_confirmar.getText())) {
			vcp.txt_confirmar.setText("");
			return false;
		}	
		return true;
	}
}
