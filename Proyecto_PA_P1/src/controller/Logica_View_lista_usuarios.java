package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Empleado;
import view.View_lista_usuarios;
import view.View_principal_admin;

public class Logica_View_lista_usuarios implements ActionListener{
	private View_lista_usuarios vlu;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_lista_usuarios(View_lista_usuarios vlu) {
		super();
		this.vlu = vlu;
		this.vlu.btn_cancelar.addActionListener(this);
		this.vlu.btn_aceptar.addActionListener(this);
		String id1 = "";
		String id2 = "";

		if(idioma == "es_Es") {
			id1 = "(Vendedor)";
			id2 = "(Bodeguero)";
			this.vlu.setTitle("Administrar Empleados");
		}else if(idioma == "en_En") {
			id1 = "(Salesman)";
			id2 = "(Storekeeper)";
			this.vlu.setTitle("Manage Employees");
		}
		for(Empleado s:Administrar_info.empleados)
		{
			if(s.getRol()==2)
			{
				this.vlu.cmb_usuario.addItem(s.getName()+" "+id1);
				this.vlu.model.addElement(s.getName());
			}
			else if (s.getRol()==3)
			{
				this.vlu.cmb_usuario.addItem(s.getName()+" "+id2);
				this.vlu.model.addElement(s.getName());
			}
		}
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}

	public void traduccion() {
		vlu.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));
		vlu.btn_aceptar.setText(Logica_View_login.bundle.getString("btn_aceptar"));
		vlu.lbl_usuario.setText(Logica_View_login.bundle.getString("lbl_usuario"));
	}

	private boolean resetearContraseña()
	{
		boolean flag=false;
		String seleccionado = this.vlu.lst_usuarios.getSelectedValue(), password="";
		if(seleccionado != null)
		{
			for(Empleado s:Administrar_info.empleados)
			{
				if(s.getName().equals(seleccionado))
				{
					password=String.valueOf(s.getCedula());
					s.setContrasena(password);
					flag=false;
					Administrar_info.edao.updatePassword(s);
					break;
				}
				else
				{
					flag = true;
				}
			}
			if(!flag)
			{
				return true;
			}
			else
			{
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vlu, "Error al resetear la contraseña");
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vlu, "Error with password reset");
				}

				return false;
			}
		}
		else
		{
			if(idioma == "es_Es") {
				JOptionPane.showMessageDialog(vlu, "No ha seleccionado ningún usuario");
			}else if(idioma == "en_En") {
				JOptionPane.showMessageDialog(vlu, "There's no user selected");
			}

			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vlu.btn_aceptar) {
			if(resetearContraseña())
			{
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vlu, "Se ha reseteado la contraseña correctamente");
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vlu, "New password avaliable");
				}

			}
		}
		else
		{
			View_principal_admin vpa = new View_principal_admin();
			vpa.setVisible(true);
			vlu.dispose();
		}
	}

}

