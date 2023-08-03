package view;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;

import controller.Logica_View_login;
import controller.Logica_View_sell_product;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class View_sell_product extends JFrame {

	private JPanel contentPane;
	public JTextField txt_cedula;
	public JTextField txt_nombreCliente;
	public JTextField txt_subTotal;
	public JTextField txt_iva;
	public JTextField txt_total;
	public JTextField txt_valorDiferido;
	public JButton btn_aceptar;
	public JButton btn_cancelar;
	public JComboBox <String> cmb_meses;
	public JList <String> lst_detalles;
	public JSpinner spn_cantidad;
	public JRadioButton rbtn_efectivo;
	public JRadioButton rbtn_corriente;
	public JRadioButton rbtn_diferido;
	public JComboBox <String> cmb_codigo;
	public JButton btn_eliminar;
	public JButton btn_agregar;
	public JButton btn_buscar;
	public JList <String> lst_carrito;
	private Logica_View_sell_product lvsp;
	private JPanel panel_1;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	public JLabel lbl_cedula;
	public JLabel lbl_cliente;
	public JLabel lbl_codigo_producto;
	public JLabel lbl_detalles_producto;
	public JLabel lbl_cantidad;
	public JLabel lbl_carrito;
	public JLabel lbl_subtotal;
	public JLabel lbl_iva;
	public JLabel lbl_mes;
	public JLabel lbl_valor;
	public JPanel pnl_diferir;
	public JLabel lbl_formas_de_pago;
	public JLabel lbl_diferido;
	public JPanel pnl_formas_pago;
	public JLabel lbl_peso;
	public JTextField txt_peso;
	public JButton btn_pesar;
	public JLabel lbl_total;
	private String idioma = Logica_View_login.sharedValue.getValue().toString();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_sell_product frame = new View_sell_product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public View_sell_product() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_sell_product.class.getResource("/resources/logosolo.PNG")));
		setTitle("Sell Product");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1183, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_pesar = new JButton("Pesar");
		btn_pesar.setForeground(Color.WHITE);
		btn_pesar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_pesar.setBackground(new Color(131, 166, 218));
		btn_pesar.setBounds(557, 229, 98, 23);
		contentPane.add(btn_pesar);
		
		txt_peso = new JTextField();
		txt_peso.setEditable(false);
		txt_peso.setBounds(177, 230, 86, 20);
		contentPane.add(txt_peso);
		txt_peso.setColumns(10);
		
		lbl_peso = new JLabel("Peso:");
		lbl_peso.setForeground(Color.WHITE);
		lbl_peso.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_peso.setBounds(10, 231, 158, 19);
		contentPane.add(lbl_peso);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(View_sell_product.class.getResource("/resources/search1.gif")));
		lblNewLabel_12.setBounds(544, 35, 50, 50);
		contentPane.add(lblNewLabel_12);
		
		lbl_cedula = new JLabel("Cédula:");
		lbl_cedula.setForeground(Color.WHITE);
		lbl_cedula.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_cedula.setBounds(10, 36, 158, 25);
		contentPane.add(lbl_cedula);
		
		txt_cedula = new JTextField();
		txt_cedula.setBounds(177, 36, 229, 20);
		contentPane.add(txt_cedula);
		txt_cedula.setColumns(10);
		
		lbl_cliente = new JLabel("Cliente:");
		lbl_cliente.setForeground(Color.WHITE);
		lbl_cliente.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_cliente.setBounds(10, 72, 158, 14);
		contentPane.add(lbl_cliente);
		
		txt_nombreCliente = new JTextField();
		txt_nombreCliente.setBounds(178, 67, 228, 20);
		txt_nombreCliente.setEditable(false);
		contentPane.add(txt_nombreCliente);
		txt_nombreCliente.setColumns(10);
		
		lbl_codigo_producto = new JLabel("Código de producto:");
		lbl_codigo_producto.setForeground(Color.WHITE);
		lbl_codigo_producto.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_codigo_producto.setBounds(10, 97, 158, 23);
		contentPane.add(lbl_codigo_producto);
		
		cmb_codigo = new JComboBox<String>();
		cmb_codigo.setBounds(179, 98, 166, 22);
		contentPane.add(cmb_codigo);
		
		lbl_cantidad = new JLabel("Cantidad:");
		lbl_cantidad.setForeground(Color.WHITE);
		lbl_cantidad.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_cantidad.setBounds(10, 202, 158, 19);
		contentPane.add(lbl_cantidad);
		
		spn_cantidad = new JSpinner();
		spn_cantidad.setBounds(177, 201, 68, 20);
		spn_cantidad.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
		contentPane.add(spn_cantidad);
		
		lbl_subtotal = new JLabel("Subtotal");
		lbl_subtotal.setForeground(Color.WHITE);
		lbl_subtotal.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_subtotal.setBounds(10, 381, 158, 19);
		contentPane.add(lbl_subtotal);
		
		txt_subTotal = new JTextField();
		txt_subTotal.setBounds(177, 380, 131, 20);
		txt_subTotal.setEditable(false);
		contentPane.add(txt_subTotal);
		txt_subTotal.setColumns(10);
		
		lbl_iva = new JLabel("IVA:");
		lbl_iva.setForeground(Color.WHITE);
		lbl_iva.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_iva.setBounds(10, 411, 158, 14);
		contentPane.add(lbl_iva);
		
		txt_iva = new JTextField();
		txt_iva.setBounds(177, 408, 131, 20);
		txt_iva.setEditable(false);
		txt_iva.setColumns(10);
		contentPane.add(txt_iva);
		
		lbl_total = new JLabel("Total a pagar:");
		lbl_total.setForeground(Color.WHITE);
		lbl_total.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_total.setBounds(10, 432, 158, 22);
		contentPane.add(lbl_total);
		
		txt_total = new JTextField();
		txt_total.setBounds(177, 435, 131, 20);
		txt_total.setEditable(false);
		txt_total.setColumns(10);
		contentPane.add(txt_total);
		
		pnl_formas_pago = new JPanel();
		pnl_formas_pago.setBackground(new Color(255, 255, 255));
		pnl_formas_pago.setBounds(49, 475, 298, 99);
		pnl_formas_pago.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pnl_formas_pago);
		pnl_formas_pago.setLayout(null);
		
		rbtn_efectivo = new JRadioButton("Efectivo");
		rbtn_efectivo.setBackground(new Color(255, 255, 255));
		rbtn_efectivo.setBounds(6, 41, 86, 23);
		pnl_formas_pago.add(rbtn_efectivo);
		
		rbtn_corriente = new JRadioButton("Corriente");
		rbtn_corriente.setBackground(new Color(255, 255, 255));
		rbtn_corriente.setBounds(107, 41, 104, 23);
		pnl_formas_pago.add(rbtn_corriente);
		
		rbtn_diferido = new JRadioButton("Diferido");
		rbtn_diferido.setBackground(new Color(255, 255, 255));
		rbtn_diferido.setBounds(213, 41, 79, 23);
		pnl_formas_pago.add(rbtn_diferido);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rbtn_corriente);
		buttonGroup.add(rbtn_efectivo);
		buttonGroup.add(rbtn_diferido);
		
		lbl_formas_de_pago = new JLabel("Formas de pago");
		lbl_formas_de_pago.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_formas_de_pago.setBounds(6, 11, 286, 20);
		pnl_formas_pago.add(lbl_formas_de_pago);
		
		pnl_diferir = new JPanel();
		pnl_diferir.setBackground(Color.WHITE);
		pnl_diferir.setBounds(357, 475, 298, 99);
		pnl_diferir.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pnl_diferir);
		pnl_diferir.setLayout(null);
		pnl_diferir.setVisible(false);
		
		rbtn_diferido.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (rbtn_diferido.isSelected()) {
                	pnl_diferir.setVisible(true);
                } else {
                	pnl_diferir.setVisible(false);
                }
            }
        });
		
		cmb_meses = new JComboBox();
		if(idioma == "es_Es") {
			cmb_meses.setModel(new DefaultComboBoxModel(new String[] {"(Seleccione)", "3 meses", "6 meses"}));
		}else if(idioma == "en_En") {
			cmb_meses.setModel(new DefaultComboBoxModel(new String[] {"(Select)", "3 months", "6 months"}));
		}
		
		cmb_meses.setBackground(new Color(255, 255, 255));
		cmb_meses.setBounds(10, 25, 135, 22);
		pnl_diferir.add(cmb_meses);
		
		txt_valorDiferido = new JTextField();
		txt_valorDiferido.setEditable(false);
		txt_valorDiferido.setBounds(150, 58, 80, 20);
		pnl_diferir.add(txt_valorDiferido);
		txt_valorDiferido.setColumns(10);
		
		lbl_valor = new JLabel("Valor a pagar:");
		lbl_valor.setBounds(10, 58, 135, 20);
		pnl_diferir.add(lbl_valor);
		
		lbl_mes = new JLabel("/ mes");
		lbl_mes.setBounds(240, 61, 48, 14);
		pnl_diferir.add(lbl_mes);
		
		lbl_diferido = new JLabel("Diferido");
		lbl_diferido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_diferido.setBounds(10, 0, 286, 31);
		pnl_diferir.add(lbl_diferido);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBackground(new Color(131, 166, 218));
		btn_aceptar.setForeground(Color.BLACK);
		btn_aceptar.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btn_aceptar.setBounds(497, 585, 158, 23);
		contentPane.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBackground(new Color(131, 166, 218));
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_cancelar.setForeground(Color.BLACK);
		btn_cancelar.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btn_cancelar.setBounds(309, 585, 158, 23);
		contentPane.add(btn_cancelar);
		
		lbl_detalles_producto = new JLabel("Detalles del producto:");
		lbl_detalles_producto.setForeground(Color.WHITE);
		lbl_detalles_producto.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lbl_detalles_producto.setBounds(10, 133, 158, 23);
		contentPane.add(lbl_detalles_producto);
		
		btn_agregar = new JButton("Agregar");
		btn_agregar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_agregar.setForeground(new Color(255, 255, 255));
		btn_agregar.setBackground(new Color(131, 166, 218));
		btn_agregar.setBounds(452, 229, 98, 23);
		contentPane.add(btn_agregar);
		
		lbl_carrito = new JLabel("Carrito:");
		lbl_carrito.setForeground(Color.WHITE);
		lbl_carrito.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_carrito.setBounds(10, 261, 158, 23);
		contentPane.add(lbl_carrito);
		
		lst_carrito = new JList();
		JScrollPane scrollPane = new JScrollPane(lst_carrito);
		scrollPane.setBounds(177, 261, 373, 95);
		lst_carrito.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(scrollPane);
		
		btn_eliminar = new JButton("Eliminar");
		btn_eliminar.setBackground(new Color(131, 166, 218));
		btn_eliminar.setForeground(new Color(255, 255, 255));
		btn_eliminar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_eliminar.setBounds(557, 333, 98, 23);
		contentPane.add(btn_eliminar);
		
		btn_buscar = new JButton("Buscar");
		btn_buscar.setBackground(new Color(131, 166, 218));
		btn_buscar.setForeground(Color.WHITE);
		btn_buscar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_buscar.setBounds(452, 35, 89, 23);
		contentPane.add(btn_buscar);
			
		lst_detalles = new JList();
		lst_detalles.setBounds(179, 134, 373, 56);
		contentPane.add(lst_detalles);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(682, 0, 485, 619);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(View_sell_product.class.getResource("/resources/Self checkout (1).gif")));
		lblNewLabel_11.setBackground(Color.WHITE);
		lblNewLabel_11.setBounds(0, 0, 485, 619);
		panel_1.add(lblNewLabel_11);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBackground(Color.WHITE);
		lblNewLabel_10.setIcon(new ImageIcon(View_sell_product.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel_10.setBounds(0, 0, 1048, 619);
		contentPane.add(lblNewLabel_10);
		
		lvsp = new Logica_View_sell_product(this);
	}
}
