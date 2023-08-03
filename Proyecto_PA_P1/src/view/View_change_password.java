package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import controller.Logica_View_change_password;
import java.awt.Toolkit;

public class View_change_password extends JFrame {

	private JPanel contentPane;
	public JButton btn_aceptar;
	public JButton btn_cancelar;
	private JLabel lblNewLabel_4;
	public JTextField txt_usuario;
	public JPasswordField txt_actual;
	public JPasswordField txt_nueva;
	public JPasswordField txt_confirmar;
	private Logica_View_change_password lvcp;
	public JLabel lbl_usuario;
	public JLabel lbl_ContrasenaActual;
	public JLabel lbl_ContrasenaNueva;
	public JLabel lbl_ConfirmarContrasena;
	private JLabel lbl_ver;
    private boolean mostrarContrasena; // Variable para controlar si se muestra la contraseña o no
    private JLabel lbl_esconder;
    public JLabel lblMostrarContrasenas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_change_password frame = new View_change_password();
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
	public View_change_password() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_change_password.class.getResource("/resources/logosolo.PNG")));
		setTitle("Change password");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMostrarContrasenas = new JLabel("Mostrar Contraseñas");
		lblMostrarContrasenas.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		lblMostrarContrasenas.setBounds(788, 358, 107, 14);
		contentPane.add(lblMostrarContrasenas);
		
		lbl_esconder = new JLabel("");
		lbl_esconder.setIcon(new ImageIcon(View_change_password.class.getResource("/resources/esconder.png")));
		lbl_esconder.setBounds(866, 326, 39, 31);
		contentPane.add(lbl_esconder);
		
		        lbl_esconder.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                mostrarContrasena = false;
		                actualizarContrasena();
		            }
		        });
		
		lbl_ver = new JLabel("");
		lbl_ver.setIcon(new ImageIcon(View_change_password.class.getResource("/resources/ver.png")));
		lbl_ver.setBounds(866, 326, 39, 31);
		contentPane.add(lbl_ver);
		
		lbl_ConfirmarContrasena = new JLabel("Confirmar Contraseña:");
		lbl_ConfirmarContrasena.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
		lbl_ConfirmarContrasena.setBounds(423, 291, 157, 14);
		contentPane.add(lbl_ConfirmarContrasena);
		
		lbl_ContrasenaNueva = new JLabel("Contraseña Nueva:");
		lbl_ContrasenaNueva.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
		lbl_ContrasenaNueva.setBounds(423, 223, 140, 14);
		contentPane.add(lbl_ContrasenaNueva);
		
		lbl_ContrasenaActual = new JLabel("Contraseña Actual:");
		lbl_ContrasenaActual.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
		lbl_ContrasenaActual.setBounds(423, 159, 140, 14);
		contentPane.add(lbl_ContrasenaActual);
		
		lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
		lbl_usuario.setBounds(423, 99, 136, 14);
		contentPane.add(lbl_usuario);

		txt_confirmar = new JPasswordField();
		txt_confirmar.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txt_confirmar.setBounds(582, 285, 312, 30);
		contentPane.add(txt_confirmar);

		txt_nueva = new JPasswordField();
		txt_nueva.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txt_nueva.setBounds(582, 217, 312, 30);
		contentPane.add(txt_nueva);

		txt_actual = new JPasswordField();
		txt_actual.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txt_actual.setBounds(582, 153, 312, 30);
		contentPane.add(txt_actual);

		txt_usuario = new JTextField();
		txt_usuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txt_usuario.setBounds(582, 93, 312, 30);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(View_change_password.class.getResource("/resources/Reset password (1).gif")));
		lblNewLabel_4.setBounds(49, 24, 373, 475);
		contentPane.add(lblNewLabel_4);

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_cancelar.setBackground(new Color(84, 155, 225));
		btn_cancelar.setBounds(750, 416, 188, 56);
		contentPane.add(btn_cancelar);

		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setForeground(Color.WHITE);
		btn_aceptar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_aceptar.setBackground(new Color(84, 155, 225));
		btn_aceptar.setBounds(535, 416, 188, 56);
		contentPane.add(btn_aceptar);

		JLabel lbl_fondo = new JLabel("");
		lbl_fondo.setIcon(new ImageIcon(View_change_password.class.getResource("/resources/blancooo.png")));
		lbl_fondo.setBounds(342, 24, 623, 475);
		contentPane.add(lbl_fondo);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_change_password.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1014, 550);
		contentPane.add(lblNewLabel_2);

		// Establecer el color de borde para los campos de texto y contraseñas
		Color graceDarkColor = new Color(84, 84, 84); // Grace Dark
		LineBorder graceDarkBorder = new LineBorder(graceDarkColor, 2);

		txt_usuario.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txt_actual.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txt_nueva.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txt_confirmar.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		
		lbl_ver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarContrasena = true;
                actualizarContrasena();
            }
        });
        
		btn_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// Cambiar el cursor a contraste bajo
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// Cambiar el color del botón a contraste bajo
				btn_aceptar.setBackground(new Color(37,125,214));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restaurar el cursor predeterminado
				setCursor(Cursor.getDefaultCursor());
				// Restaurar el color del botón
				btn_aceptar.setBackground(new Color(84, 155, 225));
			}
		});

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
		lvcp = new Logica_View_change_password(this);
	}
	private void actualizarContrasena() {
        if (mostrarContrasena) {
            // Mostrar la contraseña actual
            txt_actual.setEchoChar((char) 0);
            // Mostrar la contraseña nueva
            txt_nueva.setEchoChar((char) 0);
            // Mostrar la confirmación de contraseña
            txt_confirmar.setEchoChar((char) 0);
            // Cambiar el icono a ocultar
            lbl_ver.setVisible(false);
            lbl_esconder.setVisible(true);
        } else {
            // Ocultar la contraseña actual
            txt_actual.setEchoChar('•');
            // Ocultar la contraseña nueva
            txt_nueva.setEchoChar('•');
            // Ocultar la confirmación de contraseña
            txt_confirmar.setEchoChar('•');
            // Cambiar el icono a mostrar
            lbl_ver.setVisible(true);
            lbl_esconder.setVisible(false);
        }
    }

}