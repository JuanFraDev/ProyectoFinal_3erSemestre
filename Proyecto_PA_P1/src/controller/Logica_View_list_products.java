package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.View_list_product; 
import view.View_register_product;
import model.Producto;

public class Logica_View_list_products implements ActionListener{
	private View_list_product vlp;
	private String selectedValue="";
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	public Logica_View_list_products(View_list_product vlp)
	{
		this.vlp = vlp;
		this.vlp.btn_reabastecer.addActionListener(this);
		this.vlp.btn_cancelar.addActionListener(this);
		setProductos();
		blockResources();
		selected();
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}
	
	public void traduccion() {
		vlp.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));
		vlp.btn_reabastecer.setText(Logica_View_login.bundle.getString("btn_reabastecer"));
		vlp.lbl_producto.setText(Logica_View_login.bundle.getString("lbl_producto"));
		vlp.lbl_unidades.setText(Logica_View_login.bundle.getString("lbl_unidades"));
		vlp.lbl_peso.setText(Logica_View_login.bundle.getString("lbl_peso"));
	}

	public void blockResources()
	{

		vlp.btn_reabastecer.setEnabled(false);
		vlp.spn_stock.setEnabled(false);
		vlp.spn_peso.setEnabled(false);
		vlp.txt_producto.setText("");
		vlp.spn_stock.setValue(1);
	}

	private void selected()
	{
		vlp.list_productos.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting())
				{
					selectedValue = vlp.list_productos.getSelectedValue();
					if (selectedValue != null) 
					{
						for(Producto p:Administrar_info.productos)
						{
							if(p.getName().equals(selectedValue))
							{
								if(p.getTipo().equals("Unidad"))
								{
									vlp.btn_reabastecer.setEnabled(true);
									vlp.spn_stock.setEnabled(true);
									vlp.spn_peso.setEnabled(false);
									vlp.txt_producto.setText(selectedValue);
									vlp.spn_stock.setValue(1);
								}
								else
								{
									vlp.btn_reabastecer.setEnabled(true);
									vlp.spn_peso.setEnabled(true);
									vlp.spn_stock.setEnabled(false);
									vlp.txt_producto.setText(selectedValue);
									vlp.spn_stock.setValue(1);
								}
							}
						}
						
					}
				}
			}
		});
	}

	public void resetInterfaz()
	{
		this.vlp.dispose();
		this.vlp = new View_list_product();
		this.vlp.setVisible(true);
		
	}
	
	public void setProductos()
	{
		for(Producto p: Administrar_info.productos )
		{
			vlp.model.addElement(p.getName());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vlp.btn_reabastecer)
		{
			if(!selectedValue.equals(null))
			{
				boolean exist=false;
				for(Producto p: Administrar_info.productos)
				{
					if(p.getName().equals(selectedValue))
					{
						if(p.getTipo().equals("Unidad"))
						{
							p.setUnidades(Integer.toString(Integer.parseInt(p.getUnidades())+Integer.parseInt(vlp.spn_stock.getValue().toString())));
							Administrar_info.prodao.updateProducto(p);
							exist=true;
						}
						else
						{
							p.SetPeso(Float.toString(Float.parseFloat(p.getPeso())+Float.parseFloat(vlp.spn_peso.getValue().toString())));
							Administrar_info.prodao.updateProductoPeso(p);
							System.out.println(p.getPeso());
							exist=true;
						}
						break;
					}
				}
				if(!exist)
				{
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vlp, "Error al reabastecer el producto");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vlp, "Error with restock");
					}
				}
				else
				{
					if(idioma == "es_Es") {
						JOptionPane.showMessageDialog(vlp, "Producto reabastecido con éxito");
					}else if(idioma == "en_En") {
						JOptionPane.showMessageDialog(vlp, "Restock has been successful");
					}
				}
				resetInterfaz();
			}
		}
		else
		{
			View_register_product vrp = new View_register_product();
			vlp.dispose();
			vrp.setVisible(true);
		}
	}

}