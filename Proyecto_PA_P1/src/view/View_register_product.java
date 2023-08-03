package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

import controller.Logica_View_register_product;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

public class View_register_product extends JFrame {

	private JPanel contentPane;
	public JTextField txt_nombres;
	public JTextField txt_codigo;
	public JSpinner spn_unidades;
	public JSpinner spn_precio;
	public JComboBox <String>cbx_proveedor;
	public JButton btn_registrar;
	public JButton btn_cancelar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	public JLabel lbl_proveedor;
	
	private Logica_View_register_product lvrp;
	public JLabel lbl_unidades;
	public JLabel lbl_precio;
	public JButton btn_listar;
	public JRadioButton rdbtn_peso;
	public JRadioButton rdbtn_unidad;
	public JSpinner spn_peso;
	public JLabel lbl_peso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_register_product frame = new View_register_product();
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
	public View_register_product() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_register_product.class.getResource("/resources/logosolo.PNG")));
		setTitle("Register Product");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(0, 0, 904, 440);
		contentPane.add(panel);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_cancelar.setBackground(new Color(84, 155, 225));
		
		spn_peso = new JSpinner();
		spn_peso.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		spn_peso.setForeground(Color.BLACK);
		spn_peso.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		spn_peso.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		spn_peso.setBackground(Color.WHITE);
		spn_peso.setBounds(650, 149, 171, 33);
		panel.add(spn_peso);
		
		lbl_peso = new JLabel("Peso");
		lbl_peso.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_peso.setForeground(Color.GRAY);
		lbl_peso.setBackground(Color.LIGHT_GRAY);
		lbl_peso.setBounds(689, 181, 132, 20);
		panel.add(lbl_peso);
		
		rdbtn_peso = new JRadioButton("Peso");
		rdbtn_peso.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
		rdbtn_peso.setBackground(Color.WHITE);
		rdbtn_peso.setBounds(544, 109, 109, 33);
		panel.add(rdbtn_peso);
		
		rdbtn_unidad = new JRadioButton("Unidad");
		rdbtn_unidad.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
		rdbtn_unidad.setBackground(new Color(255, 255, 255));
		rdbtn_unidad.setBounds(439, 109, 75, 33);
		panel.add(rdbtn_unidad);
		
		btn_listar = new JButton("Registrar");
		btn_listar.setForeground(Color.WHITE);
		btn_listar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_listar.setBackground(new Color(84, 155, 225));
		btn_listar.setBounds(716, 338, 120, 33);
		panel.add(btn_listar);
		
		lbl_proveedor = new JLabel("Proveedor");
		lbl_proveedor.setForeground(Color.GRAY);
		lbl_proveedor.setBounds(753, 297, 68, 14);
		panel.add(lbl_proveedor);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon(View_register_product.class.getResource("/resources/Product quality.gif")));
		lblNewLabel_3.setBounds(22, 0, 421, 415);
		panel.add(lblNewLabel_3);
		
		spn_precio = new JSpinner();
		spn_precio.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		spn_precio.setForeground(new Color(0, 0, 0));
		spn_precio.setBackground(new Color(255, 255, 255));
		spn_precio.setToolTipText("");
		spn_precio.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(1000), Float.valueOf(1)));
		spn_precio.setBounds(439, 203, 171, 33);
		panel.add(spn_precio);
		
		cbx_proveedor = new JComboBox<String>();
		cbx_proveedor.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		cbx_proveedor.setForeground(new Color(0, 0, 0));
		cbx_proveedor.setBackground(new Color(255, 255, 255));
		cbx_proveedor.setBounds(438, 265, 383, 33);
		panel.add(cbx_proveedor);
		
		spn_unidades = new JSpinner();
		spn_unidades.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		spn_unidades.setForeground(new Color(0, 0, 0));
		spn_unidades.setBackground(new Color(255, 255, 255));
		spn_unidades.setModel(new SpinnerNumberModel(1, 1, 999, 1));
		spn_unidades.setBounds(439, 149, 171, 33);
		panel.add(spn_unidades);
		btn_cancelar.setBounds(553, 338, 120, 33);
		panel.add(btn_cancelar);
		
		btn_registrar = new JButton("Registrar");
		btn_registrar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_registrar.setForeground(Color.WHITE);
		btn_registrar.setBackground(new Color(84, 155, 225));
		btn_registrar.setBounds(388, 338, 120, 33);
		panel.add(btn_registrar);
		
		btn_cancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el cursor a contraste bajo
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                // Cambiar el color del botón a contraste bajo
                btn_cancelar.setBackground(new Color(37,125,214));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el cursor predeterminado
                setCursor(Cursor.getDefaultCursor());
                // Restaurar el color del botón
                btn_cancelar.setBackground(new Color(84, 155, 225));
            }
        });
		btn_registrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el cursor a contraste bajo
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                // Cambiar el color del botón a contraste bajo
                btn_registrar.setBackground(new Color(37,125,214));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el cursor predeterminado
                setCursor(Cursor.getDefaultCursor());
                // Restaurar el color del botón
                btn_registrar.setBackground(new Color(84, 155, 225));
            }
        });
		
		lbl_precio = new JLabel("Precio");
		lbl_precio.setForeground(new Color(128, 128, 128));
		lbl_precio.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_precio.setBounds(478, 234, 132, 20);
		panel.add(lbl_precio);
		
		lbl_unidades = new JLabel("Unidades");
		lbl_unidades.setForeground(new Color(128, 128, 128));
		lbl_unidades.setBackground(Color.LIGHT_GRAY);
		lbl_unidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_unidades.setBounds(478, 181, 132, 20);
		panel.add(lbl_unidades);
		
		txt_codigo = new JTextField();
		txt_codigo.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_codigo.setForeground(new Color(0, 0, 0));
		txt_codigo.setBackground(new Color(255, 255, 255));
		txt_codigo.setText("Código");
		txt_codigo.setBounds(438, 27, 383, 33);
		txt_codigo.setColumns(10);
		panel.add(txt_codigo);

		txt_nombres = new JTextField();
		txt_nombres.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_nombres.setForeground(new Color(0, 0, 0));
		txt_nombres.setBackground(new Color(255, 255, 255));
    	txt_nombres.setText("Nombres");
    	txt_nombres.setForeground(Color.GRAY);
		txt_nombres.setBounds(438, 71, 383, 33);
		txt_nombres.setColumns(10);
		panel.add(txt_nombres);
		
		
		txt_nombres.setOpaque(false);
		txt_nombres.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
		txt_codigo.setOpaque(false);
		txt_codigo.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
		spn_unidades.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		spn_precio.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		cbx_proveedor.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));

		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_register_product.class.getResource("/resources/blancooo.png")));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(371, -12, 483, 441);
		panel.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_register_product.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel.setBounds(0, -40, 884, 469);
		panel.add(lblNewLabel);
		
		lvrp = new Logica_View_register_product(this);
	}
}