package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logica_View_principal_admin;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class View_principal_admin extends JFrame {

	private JPanel contentPane;
	public JButton btn_registrar1;
	public JButton btn_horario;
	public JButton btn_gestionar;
	public JButton btn_salir;
	private Logica_View_principal_admin lvpa;
	private JPanel panel_2;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_principal_admin frame = new View_principal_admin();
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
	public View_principal_admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_principal_admin.class.getResource("/resources/logosolo.PNG")));
		setTitle("Main Administrator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1024, 596);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_registrar1 = new JButton("REGISTRAR EMPLEADO");
		btn_registrar1.setBackground(new Color(140, 158, 232));
		btn_registrar1.setForeground(new Color(255, 255, 255));
		btn_registrar1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_registrar1.setBounds(680, 429, 294, 60);
		panel.add(btn_registrar1);
		btn_registrar1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				View_register_employee u = new View_register_employee();
				u.setVisible(true);
				setVisible(false);
			}
		});
		
		btn_gestionar = new JButton("GESTIONAR EMPLEADOS");
		btn_gestionar.setBackground(new Color(146, 174, 236));
		btn_gestionar.setForeground(new Color(255, 255, 255));
		btn_gestionar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_gestionar.setBounds(362, 430, 294, 59);
		panel.add(btn_gestionar);
		btn_gestionar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				View_lista_usuarios l = new View_lista_usuarios();
				l.setVisible(true);
				setVisible(false);
			}
		});
		
		btn_horario = new JButton("ASIGNAR HORARIOS");
		btn_horario.setBackground(new Color(156, 193, 238));
		btn_horario.setForeground(new Color(255, 255, 255));
		btn_horario.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_horario.setBounds(42, 430, 294, 59);
		panel.add(btn_horario);
		btn_horario.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				View_horarios h = new View_horarios();
				h.setVisible(true);
				setVisible(false);
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(370, 66, 273, 353);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_principal_admin.class.getResource("/resources/Office management.gif")));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(-20, 11, 293, 332);
		panel_1.add(lblNewLabel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(687, 66, 278, 353);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(View_principal_admin.class.getResource("/resources/New.gif")));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(0, 0, 288, 332);
		panel_3.add(lblNewLabel_3);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(50, 66, 273, 353);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setIcon(new ImageIcon(View_principal_admin.class.getResource("/resources/Time management (1).gif")));
		lblNewLabel_1.setBounds(0, 0, 289, 332);
		panel_2.add(lblNewLabel_1);
		
		btn_salir = new JButton("CERRAR SESIÓN");
		btn_salir.setForeground(new Color(255, 255, 255));
		btn_salir.setBackground(new Color(99, 109, 235));
		btn_salir.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_salir.setBounds(808, 533, 166, 39);
		panel.add(btn_salir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_principal_admin.class.getResource("/resources/fondotrasparente2.jpg")));
		lblNewLabel.setBounds(0, 0, 1014, 596);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(View_principal_admin.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel_4.setBounds(263, 0, 761, 596);
		panel.add(lblNewLabel_4);
		
		
		lvpa = new Logica_View_principal_admin(this);
	}
}