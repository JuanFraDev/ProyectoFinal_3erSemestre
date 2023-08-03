package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;


import controller.Logica_View_register_client;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class View_register_client extends JFrame {

	private JPanel contentPane;
	public JTextField txt_apellidos;
	public JTextField txt_cedula;
	public JTextField txt_correo;
	public JTextField txt_telefono1;
	public JTextField txt_direccion;
	public JTextField txt_nombres;
	public JButton btn_cancelar;
	public JButton btn_registrar;
	private Logica_View_register_client lvrc;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_register_client frame = new View_register_client();
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
	public View_register_client() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_register_client.class.getResource("/resources/logosolo.PNG")));
		setTitle("Register Client");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBounds(0, 0, 1024, 596);
		contentPane.add(panel);
		
		txt_nombres = new JTextField();
		txt_nombres.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_nombres.setColumns(10);
		txt_nombres.setBounds(556, 168, 338, 26);
		txt_nombres.setForeground(Color.GRAY);
		txt_nombres.setText("Nombres");
		
		panel.add(txt_nombres);
		
		
		txt_apellidos = new JTextField();
		txt_apellidos.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(556, 205, 338, 26);
		txt_apellidos.setForeground(Color.GRAY);
		txt_apellidos.setText("Apellidos");
		
		panel.add(txt_apellidos);
		
		txt_cedula = new JTextField();
		txt_cedula.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_cedula.setColumns(10);
		txt_cedula.setBounds(556, 244, 338, 26);
		txt_cedula.setForeground(Color.GRAY);
		txt_cedula.setText("Cédula");
		
		panel.add(txt_cedula);
		
		txt_correo = new JTextField();
		txt_correo.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_correo.setColumns(10);
		txt_correo.setBounds(556, 281, 338, 26);
		txt_correo.setForeground(Color.GRAY);
		txt_correo.setText("Correo Electrónico");
		
		panel.add(txt_correo);
		
		txt_telefono1 = new JTextField();
		txt_telefono1.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_telefono1.setColumns(10);
		txt_telefono1.setBounds(556, 318, 338, 26);
		txt_telefono1.setForeground(Color.GRAY);
		txt_telefono1.setText("Teléfono Convencional");
		
		panel.add(txt_telefono1);
		
		txt_direccion = new JTextField();
		txt_direccion.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_direccion.setColumns(10);
		txt_direccion.setBounds(556, 355, 338, 26);
		txt_direccion.setForeground(Color.GRAY);
		txt_direccion.setText("Dirección");
		
		panel.add(txt_direccion);
		
		txt_nombres.setOpaque(false);
		txt_nombres.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
		txt_apellidos.setOpaque(false);
		txt_apellidos.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));

		txt_cedula.setOpaque(false);
		txt_cedula.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));

		txt_correo.setOpaque(false);
		txt_correo.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	    
		txt_telefono1.setOpaque(false);
		txt_telefono1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	    
		txt_direccion.setOpaque(false);
		txt_direccion.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setForeground(new Color(255, 255, 255));
		btn_cancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_cancelar.setBackground(new Color(84, 155, 225));
		btn_cancelar.setBounds(555, 440, 156, 33);
		panel.add(btn_cancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_register_client.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel.setBounds(0, 0, 35, 596);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_register_client.class.getResource("/resources/Sales consulting.gif")));
		lblNewLabel_2.setBounds(45, 46, 440, 471);
		panel.add(lblNewLabel_2);
		panel.requestFocusInWindow();
				
		btn_registrar = new JButton("Registrar");
		btn_registrar.setForeground(Color.WHITE);
		btn_registrar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_registrar.setBackground(new Color(84, 155, 225));
		btn_registrar.setBounds(738, 440, 156, 33);
		panel.add(btn_registrar);
		
		btn_registrar.requestFocus();
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
		
		lvrc = new Logica_View_register_client(this);

		
	}
}
