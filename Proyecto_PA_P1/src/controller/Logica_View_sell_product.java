package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;
import java.awt.event.ItemEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Cliente;
import model.Producto;
import serialConn.SerialConn;
import view.View_principal_salesman;
import view.View_sell_product;

public class Logica_View_sell_product implements ActionListener, ItemListener, ListSelectionListener{

	public View_sell_product vsp;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private DefaultListModel<String> listModel2 = new DefaultListModel<>();
	private int tiempo = 0;
	public static float peso;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();
	/*
	 * En el constructor se ha incluido la referencia a la ui
	 * Además tambien los correspondientes ActionListener, ItemListener y demás
	 * dependiendo del tipo de elemento al que se esté referenciando
	 * Además se han setteado valores predeterminados para ciertos elementos
	 */
	public Logica_View_sell_product(View_sell_product vsp) {
		this.vsp = vsp;
		Administrar_info.productos_vendidos.clear();
		this.vsp.btn_aceptar.addActionListener(this);
		this.vsp.btn_cancelar.addActionListener(this);
		this.vsp.btn_agregar.addActionListener(this);
		this.vsp.btn_eliminar.addActionListener(this);
		this.vsp.btn_pesar.addActionListener(this);
		this.vsp.btn_buscar.addActionListener(this);
		this.vsp.cmb_codigo.addItemListener(this);
		this.vsp.cmb_meses.addItemListener(this);
		this.vsp.lst_carrito.addListSelectionListener(this);
		this.vsp.txt_iva.setText("0");
		this.vsp.txt_subTotal.setText("0");
		this.vsp.txt_total.setText("0");
		this.vsp.txt_valorDiferido.setText("0");
		this.vsp.rbtn_efectivo.setSelected(true);
		this.vsp.btn_pesar.setEnabled(false);
		this.vsp.btn_cancelar.setEnabled(true);
		Logica_View_sell_product.peso=0;
		cargarCodigos();
		Logica_View_login.bundle=ResourceBundle.getBundle("idiomas/"+Logica_View_login.sharedValue.getValue());
		traduccion();
	}

	public void traduccion() {
		vsp.btn_pesar.setText(Logica_View_login.bundle.getString("btn_pesar"));
		vsp.btn_aceptar.setText(Logica_View_login.bundle.getString("btn_aceptar"));
		vsp.btn_cancelar.setText(Logica_View_login.bundle.getString("btn_cancelar"));
		vsp.btn_agregar.setText(Logica_View_login.bundle.getString("btn_agregar"));
		vsp.btn_eliminar.setText(Logica_View_login.bundle.getString("btn_eliminar"));
		vsp.btn_buscar.setText(Logica_View_login.bundle.getString("btn_buscar"));
		vsp.lbl_cantidad.setText(Logica_View_login.bundle.getString("lbl_cantidad"));
		vsp.lbl_carrito.setText(Logica_View_login.bundle.getString("lbl_carrito"));
		vsp.lbl_cedula.setText(Logica_View_login.bundle.getString("lbl_cedula"));
		vsp.lbl_cliente.setText(Logica_View_login.bundle.getString("lbl_cliente"));
		vsp.lbl_codigo_producto.setText(Logica_View_login.bundle.getString("lbl_codigo_producto"));
		vsp.lbl_detalles_producto.setText(Logica_View_login.bundle.getString("lbl_detalles_producto"));
		vsp.lbl_diferido.setText(Logica_View_login.bundle.getString("lbl_diferido"));
		vsp.lbl_formas_de_pago.setText(Logica_View_login.bundle.getString("lbl_formas_de_pago"));
		vsp.lbl_iva.setText(Logica_View_login.bundle.getString("lbl_iva"));
		vsp.lbl_mes.setText(Logica_View_login.bundle.getString("lbl_mes"));
		vsp.lbl_subtotal.setText(Logica_View_login.bundle.getString("lbl_subtotal"));
		vsp.lbl_valor.setText(Logica_View_login.bundle.getString("lbl_valor"));
		vsp.lbl_total.setText(Logica_View_login.bundle.getString("lbl_total"));
		vsp.lbl_peso.setText(Logica_View_login.bundle.getString("lbl_peso"));
		vsp.rbtn_corriente.setText(Logica_View_login.bundle.getString("rbtn_corriente"));
		vsp.rbtn_diferido.setText(Logica_View_login.bundle.getString("rbtn_diferido"));
		vsp.rbtn_efectivo.setText(Logica_View_login.bundle.getString("rbtn_efectivo"));

	}

	protected void vaciarCampos(){
		this.vsp.dispose();
		this.vsp = new View_sell_product();
		this.vsp.setVisible(true);

	}

	/*
	 * Este es el método que nos permite controlar los botones de nuestra interfaz, como es el hecho de buscar al cliente 
	 * segun su cédula, agregar o quitar un producto, etc
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(e.getSource() == vsp.btn_buscar) {
			for(Cliente c: Administrar_info.clientes) {
				if(c.getCedula().equals(vsp.txt_cedula.getText())) {
					vsp.txt_nombreCliente.setText(c.getName());
					flag = true;
					break;
				}
			}
			if(!flag) {
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vsp, "Cliente no registrado");
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vsp, "Client no registered");
				}

			}
		}
		if(e.getSource() == vsp.btn_agregar) {
			for(Producto p : Administrar_info.productos) 
			{
				if(p.getCodigo().equals(vsp.cmb_codigo.getSelectedItem().toString()))
				{
					if(p.getTipo().equals("Unidad") || p.getTipo().equals("Unit"))
					{
						if(Integer.parseInt(p.getUnidades()) >= Integer.parseInt(vsp.spn_cantidad.getValue().toString())) 
						{
							if(idioma == "es_Es") {
								this.listModel2.addElement("Unidades: " + vsp.spn_cantidad.getValue().toString() + "    Nombre: " + p.getName() + "    Precio por unidad: $" + p.getPrecio());
							}else if(idioma == "en_En") {
								this.listModel2.addElement("Units: " + vsp.spn_cantidad.getValue().toString() + "    Name: " + p.getName() + "    Price per unit: $" + p.getPrecio());
							}

							addProduct(Integer.parseInt(vsp.spn_cantidad.getValue().toString()), Double.parseDouble(p.getPrecio()));
							int newUnidades = Integer.parseInt(p.getUnidades()) - Integer.parseInt(vsp.spn_cantidad.getValue().toString());
							Administrar_info.productos_vendidos.add(new Producto(p.getCodigo(), p.getName(), " ", vsp.spn_cantidad.getValue().toString(),
									p.getPrecio(), p.getProveedor(), p.getTipo()));
							p.setUnidades(Integer.toString(newUnidades));
							setListaDetalle(vsp.cmb_codigo.getSelectedItem().toString());
						}
						else if(Integer.parseInt(p.getUnidades()) < Integer.parseInt(vsp.spn_cantidad.getValue().toString()))
						{
							if(idioma == "es_Es") {
								JOptionPane.showMessageDialog(vsp, "ERROR: No hay suficientes productos");
							}else if(idioma == "en_En") {
								JOptionPane.showMessageDialog(vsp, "ERROR: There's not enough products");
							}
						}
						break;
					}
					else
					{
						if(Float.parseFloat(p.getPeso()) >= peso)
						{
							if(idioma == "es_Es") {
								this.listModel2.addElement("Peso: " + peso + " g" + "    Nombre: " + p.getName() + "    Precio por gramo: $" + p.getPrecio());
							}else if(idioma == "en_En") {
								this.listModel2.addElement("Weight: " + peso + " g" + "    Name: " + p.getName() + "    Price per gram: $" + p.getPrecio());
							}

							addProductPeso(peso, Double.parseDouble(p.getPrecio()));
							float newPeso = Float.parseFloat(p.getPeso()) - peso;
							Administrar_info.productos_vendidos.add(new Producto(p.getCodigo(), p.getName(), String.valueOf(peso), " ",
									p.getPrecio(), p.getProveedor(), p.getTipo()));
							p.SetPeso(Float.toString(newPeso));
							setListaDetalle(vsp.cmb_codigo.getSelectedItem().toString());
						}
					}
				}
			}
			vsp.lst_carrito.setModel(listModel2);
		}
		if(e.getSource() == vsp.btn_eliminar) {
			int selectedIndex = vsp.lst_carrito.getSelectedIndex();
			String selected = vsp.lst_carrito.getSelectedValue();	
			if (selectedIndex != -1) 
			{
				if(idioma == "es_Es") {
					String aux[] = new String[2];
					aux = selected.split("Precio ");
					String aux2[] = aux[1].split(":");
					if(aux2[0].equals("por unidad"))
					{
						resProduct(obtUnidad(vsp.lst_carrito.getSelectedValue().toString()), obtValor(vsp.lst_carrito.getSelectedValue().toString()));
						yisus(obtNombre(vsp.lst_carrito.getSelectedValue().toString()), obtUnidad(vsp.lst_carrito.getSelectedValue().toString()));
					}
					else if(aux2[0].equals("por gramo"))
					{
						resProductPeso(peso, obtValorPeso(vsp.lst_carrito.getSelectedValue().toString()));
						yisus2(obtNombre(vsp.lst_carrito.getSelectedValue().toString()), peso);
					}
					String aux3[]=selected.split("Nombre: ");
					String aux4[] = aux3[1].trim().split("Precio");
					for(Producto pr:Administrar_info.productos_vendidos)
					{
						if(pr.getName().equals(aux4[0]))
						{
							Administrar_info.productos_vendidos.remove(pr);
						}
					}

				}else if(idioma == "en_En") {
					String aux[] = new String[2];
					aux = selected.split("Price ");
					String aux2[] = aux[1].split(":");
					if(aux2[0].equals("per unit"))
					{
						resProduct(obtUnidad(vsp.lst_carrito.getSelectedValue().toString()), obtValor(vsp.lst_carrito.getSelectedValue().toString()));
						yisus(obtNombre(vsp.lst_carrito.getSelectedValue().toString()), obtUnidad(vsp.lst_carrito.getSelectedValue().toString()));
					}
					else if(aux2[0].equals("per gram"))
					{
						resProductPeso(peso, obtValorPeso(vsp.lst_carrito.getSelectedValue().toString()));
						yisus2(obtNombre(vsp.lst_carrito.getSelectedValue().toString()), peso);
					}
					String aux3[]=selected.split("Name: ");
					String aux4[] = aux3[1].trim().split("Price");
					for(Producto pr:Administrar_info.productos_vendidos)
					{
						if(pr.getName().equals(aux4[0]))
						{
							Administrar_info.productos_vendidos.remove(pr);
						}
					}
				}

				listModel2.remove(selectedIndex);
			}
			else
			{
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vsp, "Seleccione el producto que se va a eliminar");
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vsp, "Select a product to delete");
				}

			}
		}
		if(e.getSource()== vsp.btn_cancelar)
		{
			View_principal_salesman vps = new View_principal_salesman();
			vps.setVisible(true);
			vsp.dispose();
		}
		if(e.getSource()==vsp.btn_aceptar)
		{
			if(!this.listModel2.isEmpty())
			{
				procesoVenta pv = new procesoVenta(this.vsp, this);
				procesoFacturacion pf = new procesoFacturacion(this);
				pv.start();
				pf.start();
			}
			else
			{
				if(idioma == "es_Es") {
					JOptionPane.showMessageDialog(vsp, "Hubo un error en la compra");
				}else if(idioma == "en_En") {
					JOptionPane.showMessageDialog(vsp, "There was a mistake in the purchase");
				}
			}
		}
		if(e.getSource()==vsp.btn_pesar)
		{
			SerialConn sconn = new SerialConn(this);
			sconn.start();
			sconn.setDato('1');
			sconn.interrupt();
		}
	}

	/*
	 * Este método nos ayuda a controlar ambos ComboBox el uno para que apenas se seleccione un código nos indique el detalle del producto 
	 * y el otro para que apenas nos indique un tiempo para diferir nos indique el valor a total a pagar al mes
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED){
			setListaDetalle(vsp.cmb_codigo.getSelectedItem().toString());
		}
		if(e.getSource() == vsp.cmb_meses) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(vsp.cmb_meses.getSelectedItem().toString().equals("3 meses") ||
						vsp.cmb_meses.getSelectedItem().toString().equals("3 months")) {
					tiempo = 3;
					setValorDiferido();
				} else if (vsp.cmb_meses.getSelectedItem().toString().equals("6 meses") ||
						vsp.cmb_meses.getSelectedItem().toString().equals("6 months")) {
					tiempo = 6;
					setValorDiferido();
				} else {
					tiempo = 0;
					setValorDiferido();
				}
			}
		}
	}

	/*
	 * Este método nos permite indicar el valor a pagar en caso de que se seleccione la opcion de 
	 * pagar con el metodo de diferido mediante el analisis de la variable tiempo 
	 */
	private void setValorDiferido() {
		double aux;
		String escr;
		if(tiempo == 3) {
			aux = Double.parseDouble(comaAPunto(vsp.txt_total.getText()))/3;
		} else if(tiempo == 6) {
			aux = Double.parseDouble(comaAPunto(vsp.txt_total.getText()))/6;
		} else {
			aux = 0;
		}
		escr = String.format("%.2f", aux);
		vsp.txt_valorDiferido.setText(escr);
	}

	/*
	 * Este metodo nos permite actualizar los campos del subtotal, iva y total a pagar al instante 
	 * a medida que se agregan los productos de la lista del carrito 
	 */
	private void addProduct(int cantidad, double precio) {
		double aux, auxIva;
		String valor;
		aux = Double.parseDouble(comaAPunto(vsp.txt_subTotal.getText()));
		aux += cantidad*precio;
		valor = String.format("%.2f", aux);
		vsp.txt_subTotal.setText(valor);
		auxIva = aux * 0.12;
		valor = String.format("%.2f", auxIva);
		vsp.txt_iva.setText(valor);
		aux += auxIva;
		valor = String.format("%.2f", aux);
		vsp.txt_total.setText(valor);
	}

	/*
	 * Este metodo nos permite actualizar los campos del subtotal, iva y total a pagar al instante 
	 * a medida que se agregan los productos de la lista del carrito 
	 */
	private void addProductPeso(float peso, double precio) {
		double aux, auxIva;
		String valor;
		aux = Double.parseDouble(comaAPunto(vsp.txt_subTotal.getText()));
		aux += peso*precio;
		valor = String.format("%.2f", aux);
		vsp.txt_subTotal.setText(valor);
		auxIva = aux * 0.12;
		valor = String.format("%.2f", auxIva);
		vsp.txt_iva.setText(valor);
		aux += auxIva;
		valor = String.format("%.2f", aux);
		vsp.txt_total.setText(valor);
	}

	/*
	 * Este metodo nos permite actualizar los campos del subtotal, iva y total a pagar al instante 
	 * a medida que se quitan los productos de la lista del carrito 
	 */
	private void resProduct(int cantidad, double precio) {
		double aux, auxIva;
		String valor;
		aux = Double.parseDouble(comaAPunto(vsp.txt_subTotal.getText()));
		aux -= cantidad*precio;
		valor = String.format("%.2f", aux);
		vsp.txt_subTotal.setText(valor);
		auxIva = aux * 0.12;
		valor = String.format("%.2f", auxIva);
		vsp.txt_iva.setText(valor);
		aux += auxIva;
		valor = String.format("%.2f", aux);
		vsp.txt_total.setText(valor);
	}

	private void resProductPeso(float cantidad, double precio) {
		double aux, auxIva;
		String valor;
		aux = Double.parseDouble(comaAPunto(vsp.txt_subTotal.getText()));
		aux -= cantidad*precio;
		valor = String.format("%.2f", aux);
		vsp.txt_subTotal.setText(valor);
		auxIva = aux * 0.12;
		valor = String.format("%.2f", auxIva);
		vsp.txt_iva.setText(valor);
		aux += auxIva;
		valor = String.format("%.2f", aux);
		vsp.txt_total.setText(valor);
	}


	/*
	 * Con este método obtenemos el precio del producto desde una linea seleccionada del jlist
	 */
	private double obtValor(String linea) {
		String [] aux = new String [2];
		String aux2 = "";
		if(idioma == "es_Es") {
			aux = linea.split("Precio por unidad");
		}else if(idioma == "en_En") {
			aux = linea.split("Price per unit");
		}

		for (char c : aux[1].trim().toCharArray()) {
			if(!(c == ':' || c == '$')) {
				if(!(c == ',')) {
					aux2 += c;
				} else {
					aux2 += '.';
				}
			}
		}
		return Double.parseDouble(aux2);
	}

	private double obtValorPeso(String linea) {
		String [] aux = new String [2];
		String aux2 = "";
		if(idioma == "es_Es") {
			aux = linea.split("Precio por gramo");
		}else if(idioma == "en_En") {
			aux = linea.split("Price per gram");
		}

		for (char c : aux[1].trim().toCharArray()) {
			if(!(c == ':' || c == '$')) {
				if(!(c == ',')) {
					aux2 += c;
				} else {
					aux2 += '.';
				}
			}
		}
		return Double.parseDouble(aux2);
	}

	/*
	 * Con este método obtenemos las unidades del producto desde una linea seleccionada del jlist
	 */
	private int obtUnidad(String linea) {
		String [] aux = new String [2];
		String [] aux2 = new String [2];
		if(idioma == "es_Es") {
			aux = linea.trim().split("Nombre");
		}else if(idioma == "en_En") {
			aux = linea.trim().split("Name");
		}

		aux2 = aux[0].trim().split(":");
		return Integer.parseInt(aux2[1].trim());
	}

	/*
	 * Con este método obtenemos el nombre del producto desde una linea seleccionada del jlist
	 */
	private String obtNombre(String linea) {
		String [] aux = new String [2];
		String [] aux2 = new String [2];
		String [] aux3 = new String [2];
		if(idioma == "es_Es") {
			aux = linea.trim().split("Nombre");
			aux2 = aux[1].trim().split("Precio");
		}else if(idioma == "en_En") {
			aux = linea.trim().split("Name");
			aux2 = aux[1].trim().split("Price");
		}

		aux3 = aux2[0].trim().split(":");
		return aux3[1].trim();
	}

	/*
	 * Con este metodo se actualizan los codigos de productos disponibles al momento de abrir la interfaz
	 * ya que se utiliza en el constructor de la clase
	 */
	private void cargarCodigos() {
		if(idioma == "es_Es") {
			vsp.cmb_codigo.addItem("(Seleccione)");
		}else if(idioma == "en_En") {
			vsp.cmb_codigo.addItem("(Select)");
		}

		for(Producto p : Administrar_info.productos) {
			vsp.cmb_codigo.addItem(p.getCodigo());
		}
	}

	/*
	 * Este metodo nos ayuda para actualizar el jlist del detalle del producto cada vez que se
	 * añade o se quita un producto del carrito
	 */
	private void setListaDetalle(String codigo) {
		this.listModel.clear();
		vsp.lst_detalles.setModel(listModel);
		for(Producto p : Administrar_info.productos) {
			if(p.getCodigo().equals(codigo)) 
			{
				if(p.getTipo().equals("Unidad"))
				{
					this.vsp.spn_cantidad.setEnabled(true);
					this.vsp.txt_peso.setText("");
					this.vsp.btn_agregar.setEnabled(true);
					this.vsp.btn_pesar.setEnabled(false);
					if(idioma == "es_Es") {
						this.listModel.addElement("Nombre: " + p.getName());
						this.listModel.addElement("Stock: " + p.getUnidades());
						this.listModel.addElement("Precio x unidad: $" + p.getPrecio());
					}else if(idioma == "en_En") {
						this.listModel.addElement("Name: " + p.getName());
						this.listModel.addElement("Stock: " + p.getUnidades());
						this.listModel.addElement("Price x unit: $" + p.getPrecio());
					}

				}
				else
				{
					this.vsp.spn_cantidad.setEnabled(false);
					this.vsp.txt_peso.setText("0.0");
					this.vsp.btn_agregar.setEnabled(false);
					this.vsp.btn_pesar.setEnabled(true);
					if(idioma == "es_Es") {
						this.listModel.addElement("Nombre: " + p.getName());
						this.listModel.addElement("Peso: " + p.getPeso()+" g");
						this.listModel.addElement("Precio x gramo: $" + p.getPrecio());
					}else if(idioma == "en_En") {
						this.listModel.addElement("Name: " + p.getName());
						this.listModel.addElement("Weight: " + p.getPeso()+" g");
						this.listModel.addElement("Price x gram: $" + p.getPrecio());
					}

				}

			}
		}
		vsp.lst_detalles.setModel(this.listModel);
	}

	/*
	 * Al tener un problema de compatibilidad entre la sintaxis de la interfaz con la que se maneja
	 * para poder hacer operaciones entre doubles fue necesario crear este metodo para cambiar las
	 * comas que hubiese por puntos
	 */
	private String comaAPunto(String linea) {
		String aux = "";
		for (char c : linea.toCharArray()) {
			if(!(c == ',')) {
				aux += c;
			} else {
				aux += '.';
			}
		}
		return aux;
	}

	/*
	 * Este método recoge el nombre del producto para buscarlo en el arraylist correspondiente
	 * Y de esa forma poder acceder al resto de sus atributos, además también recibe el valor
	 * de las unidades que estan en el jlist para poder hacer la suma nuevamente tanto en el 
	 * arraylist como en el archivo
	 */
	private void yisus(String nombre, int uniUi) {
		int uniArchivo, newUni;
		for(Producto p : Administrar_info.productos) 
		{
			if(p.getName().equals(nombre)) 
			{
				if(p.getTipo().equals("Unidad") || p.getTipo().equals("Unit"))
				{
					uniArchivo = Integer.parseInt(p.getUnidades());
					newUni = uniArchivo + uniUi;
					p.setUnidades(Integer.toString(newUni));
					setListaDetalle(vsp.cmb_codigo.getSelectedItem().toString());	
				}
				break;
			}
		}

	}

	private void yisus2(String nombre, float uniUi) {
		float uniBBDD, newUniBBDD;
		for(Producto p : Administrar_info.productos) 
		{
			if(p.getName().equals(nombre)) 
			{
				if(p.getTipo().equals("Peso") || p.getTipo().equals("Weight"))
				{
					uniBBDD = Float.parseFloat(p.getPeso());
					newUniBBDD = uniBBDD + uniUi;
					p.SetPeso(Float.toString(newUniBBDD));
					setListaDetalle(vsp.cmb_codigo.getSelectedItem().toString());
				}
				break;
			}
		}
	}

	/*
	 * Aquí es donde se define si es que algún elemento de la lista se encuentra
	 * seleccionado para que de esa forma se active el botón de elminar
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(!e.getValueIsAdjusting()) {
			int selectedIndex = vsp.lst_carrito.getSelectedIndex();
			vsp.btn_eliminar.setEnabled(selectedIndex != -1);
		}
	}
}
