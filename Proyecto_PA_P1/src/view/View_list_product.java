package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.Logica_View_list_products;

import java.awt.Color;
import javax.swing.SpinnerNumberModel;

public class View_list_product extends JFrame {

	private JPanel contentPane;
	public JTextField txt_producto;
	public Logica_View_list_products lvlp;
	public JLabel lbl_producto;
	public JLabel lbl_unidades;
	public JLabel lbl_peso;
	public JButton btn_reabastecer;
	public JButton btn_cancelar;
	public JSpinner spn_stock;
	public DefaultListModel<String> model = new DefaultListModel<>();
	public JList<String> list_productos = new JList<>(model);

	public JSpinner spn_peso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_list_product frame = new View_list_product();
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
	public View_list_product() {
		setTitle("List Products");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 499);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_cancelar.setBackground(new Color(190, 158, 233));
		btn_cancelar.setBounds(584, 438, 177, 38);
		panel.add(btn_cancelar);
		
		lbl_peso = new JLabel("Peso:");
		lbl_peso.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_peso.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_peso.setBounds(385, 115, 92, 31);
		panel.add(lbl_peso);
		
		spn_peso = new JSpinner();
		spn_peso.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		spn_peso.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		spn_peso.setBounds(498, 121, 92, 20);
		panel.add(spn_peso);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(32, 27, 253, 472);
		panel.add(lblNewLabel_3);
		
		list_productos = new JList<String>(model);
		list_productos.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		list_productos.setBorder(new LineBorder(new Color(190, 158, 233), 2));
		list_productos.setBounds(328, 150, 499, 262);
		panel.add(list_productos);
		
		lbl_unidades = new JLabel("Unidades:");
		lbl_unidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_unidades.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_unidades.setBounds(385, 85, 92, 31);
		panel.add(lbl_unidades);
		
		lbl_producto = new JLabel("Producto Seleccionado:");
		lbl_producto.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_producto.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_producto.setBounds(313, 43, 175, 31);
		panel.add(lbl_producto);
		
		spn_stock = new JSpinner();
		spn_stock.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spn_stock.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		spn_stock.setBounds(498, 92, 92, 20);
		panel.add(spn_stock);
		
		txt_producto = new JTextField();
		txt_producto.setEditable(false);
		txt_producto.setColumns(10);
		txt_producto.setBounds(498, 45, 244, 31);
		panel.add(txt_producto);
		
		btn_reabastecer = new JButton("Reabastecer");
		btn_reabastecer.setForeground(new Color(255, 255, 255));
		btn_reabastecer.setBackground(new Color(190, 158, 233));
		btn_reabastecer.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_reabastecer.setBounds(364, 438, 177, 38);
		panel.add(btn_reabastecer);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(View_list_product.class.getResource("/resources/blancooo.png")));
		lblNewLabel_1.setBounds(290, 0, 575, 488);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_list_product.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel.setBounds(10, 0, 878, 488);
		panel.add(lblNewLabel);
		
		lvlp = new Logica_View_list_products(this);

		
	}
}
