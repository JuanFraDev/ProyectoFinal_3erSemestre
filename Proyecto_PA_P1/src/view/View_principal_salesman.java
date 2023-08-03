package view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import controller.Logica_View_principal_salesman;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class View_principal_salesman extends JFrame {

	private JPanel contentPane;
	public JButton btn_registro;
	public JButton btn_venta;
	public JButton btn_salir;
	private Logica_View_principal_salesman lvps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_principal_salesman frame = new View_principal_salesman();
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
	public View_principal_salesman() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_principal_salesman.class.getResource("/resources/logosolo.PNG")));
		setTitle("Main Salesman");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1008, 621);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_registro = new JButton("REGISTRAR CLIENTE");
		btn_registro.setForeground(new Color(255, 255, 255));
		btn_registro.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_registro.setBackground(new Color(162, 194, 239));
		btn_registro.setBounds(140, 442, 311, 57);
		panel.add(btn_registro);
		
		btn_venta = new JButton("VENDER PRODUCTO");
		btn_venta.setBackground(new Color(156, 166, 233));
		btn_venta.setForeground(new Color(255, 255, 255));
		btn_venta.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_venta.setBounds(545, 442, 311, 57);
		panel.add(btn_venta);
		
		btn_salir = new JButton("CERRAR SESIÓN");
		btn_salir.setBackground(new Color(99, 109, 235));
		btn_salir.setForeground(new Color(255, 255, 255));
		btn_salir.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_salir.setBounds(690, 550, 166, 39);
		panel.add(btn_salir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_principal_salesman.class.getResource("/resources/fondo1.2.png")));
		lblNewLabel.setBounds(0, 0, 1008, 617);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(150, 79, 290, 352);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(View_principal_salesman.class.getResource("/resources/Queue.gif")));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(555, 79, 290, 352);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(View_principal_salesman.class.getResource("/resources/Self checkout.gif")));
		panel_1_1.add(lblNewLabel_1_1);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        View_login principal = new View_login();
		        principal.setVisible(true);
		        dispose();
		    }
		});
		
		lvps = new Logica_View_principal_salesman(this);
	}
}
