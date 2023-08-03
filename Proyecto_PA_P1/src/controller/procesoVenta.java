package controller;

import model.Producto;
import view.View_sell_product;
import javax.swing.JOptionPane;

public class procesoVenta extends Thread{
	private View_sell_product vsp;
	private Logica_View_sell_product lvsp;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public procesoVenta(View_sell_product vsp, Logica_View_sell_product lvsp)
	{
		this.vsp=vsp;
		this.lvsp=lvsp;

	}

	public void run()
	{
		String msg="", conf="", msg2="", finish="";
		if(idioma == "es_Es") 
		{
			msg="¿Desea continuar con la transacción?";
			conf="Confirmación";
			msg2="Procesando compra. . .";
			finish="La compra se ha realizado exitosamente!";
		}
		else if(idioma == "en_En") 
		{
			msg="Do you want to continue with the transaction?";
			conf="Confirmation";
			msg2="Processing transaction. . .";
			finish="The purchase has been completed!";

		}
		int opcion = JOptionPane.showConfirmDialog(vsp, msg, conf, JOptionPane.OK_CANCEL_OPTION);
		if(opcion==0)
		{
			vsp.btn_cancelar.setEnabled(false);
			try 
			{
				sleep(2000);
				JOptionPane.showMessageDialog(vsp, msg2);
				sleep(3000);
				for(Producto pro: Administrar_info.productos)
				{
					if(pro.getTipo().equals("Unidad"))
					{
						Administrar_info.prodao.updateProducto(pro);
					}
					else
					{
						Administrar_info.prodao.updateProductoPeso(pro);
					}
				}
				JOptionPane.showMessageDialog(vsp, finish);
				this.lvsp.vaciarCampos();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

}
