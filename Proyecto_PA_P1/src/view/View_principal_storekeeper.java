package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logica_View_principal_storekeeper;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class View_principal_storekeeper extends JFrame {

	private JPanel contentPane;
	public JButton btn_regis_producto;
	public JButton btn_salir;
	public JButton btn_regis_proveedor;
	private Logica_View_principal_storekeeper lvps;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_principal_storekeeper frame = new View_principal_storekeeper();
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
	public View_principal_storekeeper() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_principal_storekeeper.class.getResource("/resources/logosolo.PNG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 649);
		setTitle("Main Storekeeper");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 993, 610);
		contentPane.add(panel);
		panel.setLayout(null);

		btn_regis_producto = new JButton("REGISTRO DE PRODUCTOS");
		btn_regis_producto.setBackground(new Color(162, 194, 239));
		btn_regis_producto.setForeground(new Color(255, 255, 255));
		btn_regis_producto.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_regis_producto.setBounds(139, 444, 311, 57);
		panel.add(btn_regis_producto);

		btn_regis_proveedor = new JButton("REGISTRO DE PROVEEDORES");
		btn_regis_proveedor.setBackground(new Color(156, 166, 233));
		btn_regis_proveedor.setForeground(new Color(255, 255, 255));
		btn_regis_proveedor.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_regis_proveedor.setBounds(546, 444, 311, 57);
		panel.add(btn_regis_proveedor);

		btn_salir = new JButton("CERRAR SESIÒN");
		btn_salir.setBackground(new Color(99, 109, 235));
		btn_salir.setForeground(new Color(255, 255, 255));
		btn_salir.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_salir.setBounds(691, 543, 166, 39);
		panel.add(btn_salir);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_principal_storekeeper.class.getResource("/resources/fondo1.2.png")));
		lblNewLabel.setBounds(0, 0, 993, 610);
		panel.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBounds(151, 81, 290, 352);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(View_principal_storekeeper.class.getResource("/resources/Product quality.gif")));
		lblNewLabel_1.setBounds(0, 0, 290, 352);
		panel_2.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(554, 81, 290, 352);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_principal_storekeeper.class.getResource("/resources/Barcode.gif")));
		lblNewLabel_2.setBounds(0, 0, 290, 352);
		panel_1.add(lblNewLabel_2);
		
		lvps = new Logica_View_principal_storekeeper(this);
	}
}
