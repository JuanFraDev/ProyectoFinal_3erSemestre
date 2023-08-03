package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Logica_View_register_supplier;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

public class View_register_supplier extends JFrame {

	private JPanel contentPane;
	public JTextField txt_nombres;
	public JTextField txt_apellidos;
	public JTextField txt_codigo;
	public JTextField txt_razon;
	public JTextField txt_telefono1;
	public JTextField txt_email;
	public JButton btn_registrar;
	public JButton btn_cancelar;
	private Logica_View_register_supplier lvrs;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_register_supplier frame = new View_register_supplier();
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
	public View_register_supplier() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_register_supplier.class.getResource("/resources/logosolo.PNG")));
		setTitle("Register Supplier");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 565);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1010, 528);
		contentPane.add(panel);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(View_register_supplier.class.getResource("/resources/Logistics.gif")));
		lblNewLabel_3.setBounds(57, 30, 463, 493);
		panel.add(lblNewLabel_3);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setForeground(new Color(255, 255, 255));
		btn_cancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_cancelar.setBackground(new Color(84, 155, 225));
		btn_cancelar.setBounds(765, 415, 146, 49);
		panel.add(btn_cancelar);
		
		btn_registrar = new JButton("Registrar");
		btn_registrar.setForeground(new Color(255, 255, 255));
		btn_registrar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_registrar.setBackground(new Color(84, 155, 225));
		btn_registrar.setBounds(580, 415, 146, 49);
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
		
		
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_email.setColumns(10);
		txt_email.setBounds(573, 315, 338, 49);
		txt_email.setForeground(Color.GRAY);
		txt_email.setText("Email");
		panel.add(txt_email);
		txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_email.getText().equals("Email")) {
		        	txt_email.setText("");
		        	txt_email.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_email.getText().isEmpty()) {
		        	txt_email.setForeground(Color.GRAY);
		        	txt_email.setText("Email");
		        }
		    }
		});
		panel.add(txt_email);

		
		txt_telefono1 = new JTextField();
		txt_telefono1.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_telefono1.setColumns(10);
		txt_telefono1.setBounds(573, 251, 338, 39);
		txt_telefono1.setForeground(Color.GRAY);
		txt_telefono1.setText("Teléfono Celular");


		panel.add(txt_telefono1);
		txt_telefono1.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_telefono1.getText().equals("Teléfono")) {
		        	txt_telefono1.setText("");
		        	txt_telefono1.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_telefono1.getText().isEmpty()) {
		        	txt_telefono1.setForeground(Color.GRAY);
		        	txt_telefono1.setText("Teléfono");
		        }
		    }
		});
		panel.add(txt_telefono1);

		
		txt_razon = new JTextField();
		txt_razon.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_razon.setColumns(10);
		txt_razon.setBounds(573, 135, 338, 39);
		txt_razon.setForeground(Color.GRAY);
		txt_razon.setText("Razon");
		panel.add(txt_razon);
		txt_razon.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_razon.getText().equals("Razon")) {
		        	txt_razon.setText("");
		        	txt_razon.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_razon.getText().isEmpty()) {
		        	txt_razon.setForeground(Color.GRAY);
		        	txt_razon.setText("Razon");
		        }
		    }
		});
		panel.add(txt_razon);

		
		txt_codigo = new JTextField();
		txt_codigo.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_codigo.setColumns(10);
		txt_codigo.setBounds(573, 85, 338, 39);
		txt_codigo.setForeground(Color.GRAY);
		txt_codigo.setText("Código");
		panel.add(txt_codigo);
		
		txt_apellidos = new JTextField();
		txt_apellidos.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(758, 185, 153, 39);
		txt_apellidos.setForeground(Color.GRAY);
		txt_apellidos.setText("Apellidos");
		panel.add(txt_apellidos);

		txt_nombres = new JTextField();
		txt_nombres.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_nombres.setColumns(10);
		txt_nombres.setBounds(573, 185, 153, 39);
		txt_nombres.setForeground(Color.GRAY);
		txt_nombres.setText("Nombres");
		panel.add(txt_nombres);
		
		txt_nombres.setOpaque(false);
		txt_nombres.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
		txt_apellidos.setOpaque(false);
		txt_apellidos.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));

		txt_email.setOpaque(false);
		txt_email.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));

		txt_razon.setOpaque(false);
		txt_razon.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	    
		txt_codigo.setOpaque(false);
		txt_codigo.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	    
		txt_telefono1.setOpaque(false);
		txt_telefono1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_register_supplier.class.getResource("/resources/blancooo.png")));
		lblNewLabel_2.setBounds(57, 0, 953, 528);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_register_supplier.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel.setBounds(0, 0, 978, 538);
		panel.add(lblNewLabel);
	
		lvrs = new Logica_View_register_supplier(this);
	}
}
