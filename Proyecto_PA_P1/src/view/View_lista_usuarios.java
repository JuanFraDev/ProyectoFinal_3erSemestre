package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import controller.Logica_View_lista_usuarios;

import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class View_lista_usuarios extends JFrame{
	public JComboBox <String> cmb_usuario;
	public JButton btn_cancelar;
	public JButton btn_aceptar;
	public DefaultListModel<String> model = new DefaultListModel<>();
	public JList<String> lst_usuarios = new JList<>(model);
	//public JList lst_usuarios;
	private Logica_View_lista_usuarios lvu;
	public JLabel lbl_usuario;
	

	public View_lista_usuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_lista_usuarios.class.getResource("/resources/logosolo.PNG")));
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1005, 506);
		setResizable(false);
		setTitle("User's list");
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 989, 474);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(View_lista_usuarios.class.getResource("/resources/Mobile note list (1).gif")));
		lblNewLabel_3.setBounds(45, 11, 355, 498);
		panel_1.add(lblNewLabel_3);
		
		lst_usuarios = new JList(model);
		lst_usuarios.setBorder(new LineBorder(new Color(190, 158, 233), 2));
		lst_usuarios.setBounds(410, 117, 513, 204);
		panel_1.add(lst_usuarios);
		lst_usuarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_aceptar.setForeground(Color.WHITE);
		btn_aceptar.setBackground(new Color(190, 158, 233));
		btn_aceptar.setBounds(410, 357, 206, 52);
		panel_1.add(btn_aceptar);
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setBackground(new Color(190, 158, 233));
		btn_cancelar.setBounds(720, 357, 206, 52);
		panel_1.add(btn_cancelar);
		btn_aceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el cursor a contraste bajo
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                // Cambiar el color del botón a contraste bajo
                btn_aceptar.setBackground(new Color(159,113,223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el cursor predeterminado
                setCursor(Cursor.getDefaultCursor());
                // Restaurar el color del botón
                btn_aceptar.setBackground(new Color(190, 158, 233));
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
		//panel_1.add(lst_usuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 117, 513, 204);
		panel_1.add(scrollPane);
		
		cmb_usuario = new JComboBox();
		cmb_usuario.setEditable(true);
		cmb_usuario.setBackground(Color.WHITE);
		cmb_usuario.setBounds(489, 63, 434, 22);
		cmb_usuario.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		panel_1.add(cmb_usuario);
		
		lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_usuario.setBounds(417, 64, 62, 18);
		panel_1.add(lbl_usuario);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_lista_usuarios.class.getResource("/resources/blancooo.png")));
		lblNewLabel_2.setBounds(333, 11, 646, 462);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_lista_usuarios.class.getResource("/resources/fondo1.jpg")));
		lblNewLabel.setBounds(0, 0, 989, 473);
		panel_1.add(lblNewLabel);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        View_principal_admin principal = new View_principal_admin();
		        principal.setVisible(true);
		        dispose();
		    }
		});
		lvu = new Logica_View_lista_usuarios(this);
	}
}