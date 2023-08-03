package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Logica_View_login;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class View_login extends JFrame {

    private JPanel contentPane;
    public JTextField txt_user;
    public JPasswordField txt_psw;
    public JButton btn_login;
    public JLabel lbl_psw;
    public JLabel lblGif; // Nuevo JLabel para mostrar el gif
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lbl_ver; // Nuevo JLabel para el icono "ver.png"
    private JLabel lbl_esconder; // Nuevo JLabel para el icono "esconder.png"
    private boolean mostrarContrasena; // Variable para controlar si se muestra la contraseña o no

    private Logica_View_login lvl;
    public JLabel lbl_bienvenido;
    private JLabel lblNewLabel_8;
    public JLabel lbl_idioma;
    public JComboBox <String>cmb_idioma;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View_login frame = new View_login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public View_login() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(View_login.class.getResource("/resources/Logo_Principal.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 949, 668);
        setResizable(false);
        setTitle("Login");

        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 236, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(36, 36, 852, 542);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(View_login.class.getResource("/resources/usuario (2).png")));
        lblNewLabel.setBounds(484, 285, 47, 30);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(lblNewLabel);

        txt_user = new JTextField();
        txt_user.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        txt_user.setBounds(541, 285, 223, 30);
        txt_user.setForeground(Color.GRAY);
        txt_user.setText("Usuario");
        /*txt_user.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_user.getText().equals("Usuario")) {
                    txt_user.setText("");
                    txt_user.setForeground(Color.BLACK);
                }else if (txt_user.getText().equals("User")) {
                    txt_user.setText("");
                    txt_user.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txt_user.getText().isEmpty()) {
                    txt_user.setForeground(Color.GRAY);
                    //txt_user.setText("Usuario");
                }
            }
        });*/
        panel.add(txt_user);
        txt_user.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(View_login.class.getResource("/resources/bloquear (1).png")));
        lblNewLabel_1.setBounds(489, 334, 37, 30);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(lblNewLabel_1);

        txt_psw = new JPasswordField();
        txt_psw.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        txt_psw.setBounds(541, 334, 223, 30);
        txt_psw.setForeground(Color.GRAY);
        txt_psw.setText("Contraseña");
        txt_psw.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String password = String.valueOf(txt_psw.getPassword());
                if (password.equals("Contraseña")) {
                    txt_psw.setText("");
                    txt_psw.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String password = String.valueOf(txt_psw.getPassword());
                if (password.isEmpty()) {
                    txt_psw.setForeground(Color.GRAY);
                    txt_psw.setText("Contraseña");
                }
            }
        });
        panel.add(txt_psw);

        btn_login = new JButton("INICIAR SESIÓN");
        btn_login.setBackground(new Color(62, 93, 210));
        btn_login.setForeground(Color.WHITE);
        btn_login.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        btn_login.setBounds(541, 425, 223, 40);
        panel.add(btn_login);

        lbl_psw = new JLabel("Olvidó su contraseña?");
        lbl_psw.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
        lbl_psw.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		View_change_password s = new View_change_password();
				s.setVisible(true);
				setVisible(false);
        	}
        });
        lbl_psw.setBounds(614, 379, 150, 14);
        lbl_psw.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(lbl_psw);

        lblGif = new JLabel("");
        lblGif.setIcon(new ImageIcon(View_login.class.getResource("/resources/users.gif")));
        lblGif.setBounds(544, 100, 200, 184);
        panel.add(lblGif);

        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(View_login.class.getResource("/resources/Mobile login.gif")));
        lblNewLabel_2.setBounds(10, 119, 443, 412);
        panel.add(lblNewLabel_2);

        lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setBounds(0, 0, 933, 629);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(View_login.class.getResource("/resources/fondo1.jpg")));
        lblNewLabel_5.setBounds(0, 0, 933, 629);
        contentPane.add(lblNewLabel_5);

        lbl_ver = new JLabel("");
        lbl_ver.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        lbl_ver.setIcon(new ImageIcon(View_login.class.getResource("/resources/ver.png")));
        lbl_ver.setBounds(774, 334, 54, 30);
        panel.add(lbl_ver);

        lbl_esconder = new JLabel("");
        lbl_esconder.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        lbl_esconder.setIcon(new ImageIcon(View_login.class.getResource("/resources/esconder.png")));
        lbl_esconder.setBounds(774, 334, 54, 30);
        panel.add(lbl_esconder);
        
        lbl_bienvenido = new JLabel("¡Bienvenido a Super Tiendas!");
        lbl_bienvenido.setForeground(new Color(131, 166, 218));
        lbl_bienvenido.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        lbl_bienvenido.setBounds(20, 11, 598, 72);
        panel.add(lbl_bienvenido);
        
        lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon(View_login.class.getResource("/resources/fondo1.jpg")));
        lblNewLabel_8.setBounds(0, 77, 852, 14);
        panel.add(lblNewLabel_8);
        
        lbl_idioma = new JLabel("Idioma:");
        lbl_idioma.setForeground(new Color(131, 166, 218));
        lbl_idioma.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lbl_idioma.setBounds(525, 479, 93, 40);
        panel.add(lbl_idioma);
        
        cmb_idioma = new JComboBox();
        cmb_idioma.setBounds(614, 490, 103, 22);
        panel.add(cmb_idioma);

        // Agregar el evento del mouse para mostrar u ocultar la contraseña
        lbl_ver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarContrasena = true;
                actualizarContrasena();
            }
        });

        lbl_esconder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarContrasena = false;
                actualizarContrasena();
            }
        });
        
        lvl = new Logica_View_login(this);
        btn_login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el cursor 
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                // Cambiar el color del botón a contraste bajo
                btn_login.setBackground(new Color(96, 96, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el cursor predeterminado
                setCursor(Cursor.getDefaultCursor());
                // Restaurar el color del botón
                btn_login.setBackground(new Color(62, 92, 210));
            }
        });
    }

    // Método para mostrar u ocultar la contraseña
    private void actualizarContrasena() {
        if (mostrarContrasena) {
            txt_psw.setEchoChar((char) 0); // Mostrar contraseña
            lbl_ver.setVisible(false);
            lbl_esconder.setVisible(true);
        } else {
            txt_psw.setEchoChar('*'); // Ocultar contraseña
            lbl_ver.setVisible(true);
            lbl_esconder.setVisible(false);
        }
    }
}