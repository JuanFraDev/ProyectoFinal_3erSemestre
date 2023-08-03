package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logica_View_register_employee;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class View_register_employee extends JFrame {

	private JPanel contentPane;
	public JTextField txt_codigo;
	public JTextField txt_nombres;
	public JTextField txt_apellidos;
	public JTextField txt_cedula;
	public JTextField txt_correo;
	public JTextField txt_telefono1;
	public JTextField txt_telefono2;
	public JTextField txt_direccion;
	public JButton btn_registrar;
	public JButton btn_cancelar;
	public ButtonGroup grupo = new ButtonGroup();
	public JRadioButton rdbtn_vendedor;
	public JRadioButton rdbtn_bodeguero;
	public JRadioButton rdbtn_admin;
	public ButtonModel selectedButton ;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private Logica_View_register_employee lvre;
	public JLabel lbl_codigo;
	public JLabel lbl_perfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_register_employee frame = new View_register_employee();
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
	public View_register_employee() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_register_employee.class.getResource("/resources/logosolo.PNG")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1036, 631);
		setResizable(false);
		setTitle("Register Employee");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(498, 28, 519, 547);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_codigo = new JTextField();
		txt_codigo.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_codigo.setForeground(new Color(0, 0, 0));
		txt_codigo.setBackground(new Color(255, 255, 255));
		txt_codigo.setEditable(false);
		txt_codigo.setBounds(85, 100, 178, 26);
		panel.add(txt_codigo);
		txt_codigo.setColumns(10);
		
		txt_nombres = new JTextField();
		txt_nombres.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_nombres.setColumns(10);
		txt_nombres.setBounds(33, 137, 228, 26);
		txt_nombres.setForeground(Color.GRAY);
		txt_nombres.setText("Nombres");
		/*txt_nombres.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_nombres.getText().equals("Nombres")) {
		            txt_nombres.setText("");
		            txt_nombres.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_nombres.getText().isEmpty()) {
		            txt_nombres.setForeground(Color.GRAY);
		            txt_nombres.setText("Nombres");
		        }
		    }
		});*/

		panel.add(txt_nombres);
		
		txt_apellidos = new JTextField();
		txt_apellidos.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(280, 137, 228, 26);
		txt_apellidos.setForeground(Color.GRAY);
		txt_apellidos.setText("Apellidos");
		/*txt_apellidos.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_apellidos.getText().equals("Apellidos")) {
		        	txt_apellidos.setText("");
		        	txt_apellidos.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_apellidos.getText().isEmpty()) {
		        	txt_apellidos.setForeground(Color.GRAY);
		        	txt_apellidos.setText("Apellidos");
		        }
		    }
		});*/
		panel.add(txt_apellidos);
		
		lbl_codigo = new JLabel("Código");
		lbl_codigo.setBackground(new Color(0, 0, 0));
		lbl_codigo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lbl_codigo.setForeground(new Color(0, 0, 0));
		lbl_codigo.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_codigo.setBounds(33, 101, 67, 20);
		panel.add(lbl_codigo);
		
		txt_cedula = new JTextField();
		txt_cedula.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_cedula.setColumns(10);
		txt_cedula.setBounds(33, 177, 228, 26);
		txt_cedula.setForeground(Color.GRAY);
		txt_cedula.setText("Cédula");
		/*txt_cedula.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_cedula.getText().equals("Cédula")) {
		        	txt_cedula.setText("");
		        	txt_cedula.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_cedula.getText().isEmpty()) {
		        	txt_cedula.setForeground(Color.GRAY);
		        	txt_cedula.setText("Cédula");
		        }
		    }
		});*/
		panel.add(txt_cedula);
		
		txt_correo = new JTextField();
		txt_correo.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_correo.setColumns(10);
		txt_correo.setBounds(33, 214, 228, 26);
		txt_correo.setForeground(Color.GRAY);
		txt_correo.setText("Correo Electrónico");
		/*txt_correo.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_correo.getText().equals("Correo Electrónico")) {
		        	txt_correo.setText("");
		        	txt_correo.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_correo.getText().isEmpty()) {
		        	txt_correo.setForeground(Color.GRAY);
		        	txt_correo.setText("Correo Electrónico");
		        }
		    }
		});*/
		panel.add(txt_correo);
		
		txt_telefono1 = new JTextField();
		txt_telefono1.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_telefono1.setColumns(10);
		txt_telefono1.setBounds(33, 251, 228, 26);
		txt_telefono1.setForeground(Color.GRAY);
		txt_telefono1.setText("Teléfono Convencional");
		/*txt_telefono1.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_telefono1.getText().equals("Teléfono Convencional")) {
		        	txt_telefono1.setText("");
		        	txt_telefono1.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_telefono1.getText().isEmpty()) {
		        	txt_telefono1.setForeground(Color.GRAY);
		        	txt_telefono1.setText("Teléfono Convencional");
		        }
		    }
		});*/
		panel.add(txt_telefono1);
		
		txt_telefono2 = new JTextField();
		txt_telefono2.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_telefono2.setColumns(10);
		txt_telefono2.setBounds(280, 251, 228, 26);
		txt_telefono2.setForeground(Color.GRAY);
		txt_telefono2.setText("Teléfono Celular");
		/*txt_telefono2.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_telefono2.getText().equals("Teléfono Celular")) {
		        	txt_telefono2.setText("");
		        	txt_telefono2.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_telefono2.getText().isEmpty()) {
		        	txt_telefono2.setForeground(Color.GRAY);
		        	txt_telefono2.setText("Teléfono Celular");
		        }
		    }
		});*/
		panel.add(txt_telefono2);
		
		txt_direccion = new JTextField();
		txt_direccion.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txt_direccion.setColumns(10);
		txt_direccion.setBounds(33, 288, 228, 26);
		txt_direccion.setForeground(Color.GRAY);
		txt_direccion.setText("Dirección");
		/*txt_direccion.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        if (txt_direccion.getText().equals("Dirección")) {
		        	txt_direccion.setText("");
		        	txt_direccion.setForeground(Color.BLACK);
		        }
		    }
		    public void focusLost(java.awt.event.FocusEvent evt) {
		        if (txt_direccion.getText().isEmpty()) {
		        	txt_direccion.setForeground(Color.GRAY);
		        	txt_direccion.setText("Dirección");
		        }
		    }
		});*/
		panel.add(txt_direccion);
		
		txt_codigo.setOpaque(false);
		txt_codigo.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
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
	    
	    txt_telefono2.setOpaque(false);
	    txt_telefono2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	    
	    txt_direccion.setOpaque(false);
	    txt_direccion.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
         
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(131, 327, 177, 106);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		rdbtn_vendedor = new JRadioButton("Vendedor");
		rdbtn_vendedor.setForeground(new Color(0, 0, 0));
		rdbtn_vendedor.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		rdbtn_vendedor.setBackground(new Color(0, 0, 0));
		rdbtn_vendedor.setBounds(6, 0, 94, 30);
		grupo.add(rdbtn_vendedor);
		panel_1.add(rdbtn_vendedor);
		
		rdbtn_bodeguero = new JRadioButton("Bodeguero");
		rdbtn_bodeguero.setForeground(new Color(0, 0, 0));
		rdbtn_bodeguero.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		rdbtn_bodeguero.setBackground(Color.WHITE);
		rdbtn_bodeguero.setBounds(6, 33, 94, 30);
		grupo.add(rdbtn_bodeguero);
		panel_1.add(rdbtn_bodeguero);
		
		rdbtn_admin = new JRadioButton("Administrador");
		rdbtn_admin.setForeground(new Color(0, 0, 0));
		rdbtn_admin.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		rdbtn_admin.setBackground(Color.WHITE);
		rdbtn_admin.setBounds(6, 65, 109, 30);
		grupo.add(rdbtn_admin);
		panel_1.add(rdbtn_admin);
		selectedButton = grupo.getSelection();
		
		rdbtn_vendedor.setOpaque(false);
		rdbtn_bodeguero.setOpaque(false);
		rdbtn_admin.setOpaque(false);
		panel_1.setOpaque(false);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
		lbl_perfil = new JLabel("Perfil");
		lbl_perfil.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lbl_perfil.setForeground(new Color(0, 0, 0));
		lbl_perfil.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_perfil.setBounds(33, 325, 67, 33);
		panel.add(lbl_perfil);
		
		btn_registrar = new JButton("Registrar");
		btn_registrar.setForeground(new Color(255, 255, 255));
		btn_registrar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_registrar.setBackground(new Color(190, 158, 233));
		btn_registrar.setBounds(33, 473, 228, 33);
		panel.add(btn_registrar);
		
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBackground(new Color(190, 158, 233));
		btn_cancelar.setForeground(new Color(255, 255, 255));
		btn_cancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_cancelar.setBounds(279, 473, 229, 33);
		panel.add(btn_cancelar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(64, 0, 128));
		lblNewLabel.setBackground(new Color(64, 0, 64));
		lblNewLabel.setBounds(10, 11, 507, 536);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(42, 55, 460, 457);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(View_register_employee.class.getResource("/resources/Annotation.gif")));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(View_register_employee.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 38, 607);
		contentPane.add(lblNewLabel_1);
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        View_principal_admin principal = new View_principal_admin();
		        principal.setVisible(true);
		        dispose();
		    }
		});
		btn_registrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el cursor a contraste bajo
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                // Cambiar el color del botón a contraste bajo
                btn_registrar.setBackground(new Color(159,113,223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el cursor predeterminado
                setCursor(Cursor.getDefaultCursor());
                // Restaurar el color del botón
                btn_registrar.setBackground(new Color(190, 158, 233));
            }
        });
		btn_cancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el cursor a contraste bajo
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                // Cambiar el color del botón a contraste bajo
                btn_cancelar.setBackground(new Color(159,113,223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el cursor predeterminado
                setCursor(Cursor.getDefaultCursor());
                // Restaurar el color del botón
                btn_cancelar.setBackground(new Color(190, 158, 233));
            }
        });
		lvre = new Logica_View_register_employee(this);
	}
}