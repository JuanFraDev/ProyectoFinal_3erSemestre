package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Logica_View_horarios;

import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;


public class View_horarios extends JFrame{
	public JComboBox <String> cmb_empleado;
	public JButton btn_aceptar;
	public JButton btn_cancelar;
	private Logica_View_horarios lvh;
	public JRadioButton rbtn_lunes_matutino;
	public JRadioButton rbtn_martes_matutino;
	public JRadioButton rbtn_miercoles_matutino;
	public JRadioButton rbtn_jueves_matutino;
	public JRadioButton rbtn_viernes_matutino;
	public JRadioButton rbtn_martes_vespertino;
	public JRadioButton rbtn_lunes_vespertino;
	public JRadioButton rbtn_viernes_vespertino;
	public JRadioButton rbtn_jueves_vespertino;
	public JRadioButton rbtn_miercoles_vespertino;
	public JRadioButton rbtn_lunes_nocturno;
	public JRadioButton rbtn_lunes_madrugada;
	public JRadioButton rbtn_martes_nocturno;
	public JRadioButton rbtn_miercoles_nocturno;
	public JRadioButton rbtn_jueves_nocturno;
	public JRadioButton rbtn_viernes_nocturno;
	public JRadioButton rbtn_viernes_madrugada;
	public JRadioButton rbtn_jueves_madrugada;
	public JRadioButton rbtn_miercoles_madrugada;
	public JRadioButton rbtn_martes_madrugada;
	public JLabel lbl_empleado;
	public JLabel lbl_asignacion;
	public JLabel lbl_nocturno;
	public JLabel lbl_vespertino;
	public JLabel lbl_matutino;
	public JLabel lbl_turno;
	public JLabel lbl_dia;
	public JLabel lbl_madrugada;
	public JLabel lbl_lunes;
	public JLabel lbl_martes;
	public JLabel lbl_miercoles;
	public JLabel lbl_jueves;
	public JLabel lbl_viernes;
	
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

	public View_horarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_horarios.class.getResource("/resources/logosolo.PNG")));
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1031, 636);
		setResizable(false);
		setTitle("Assign Schedules");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(77, 104, 211));
		panel.setBounds(0, 0, 585, 85);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lbl_asignacion = new JLabel("Asignación de horarios");
		lbl_asignacion.setForeground(new Color(255, 255, 255));
		lbl_asignacion.setFont(new Font("Trebuchet MS", Font.ITALIC, 19));
		lbl_asignacion.setBounds(21, 11, 199, 43);
		panel.add(lbl_asignacion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_horarios.class.getResource("/resources/icons8-calendario-50.png")));
		lblNewLabel.setBounds(230, 11, 63, 46);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 84, 585, 517);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lbl_empleado = new JLabel("Empleado: ");
		lbl_empleado.setForeground(new Color(255, 255, 255));
		lbl_empleado.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lbl_empleado.setBounds(39, 15, 90, 14);
		panel_1.add(lbl_empleado);
		
		cmb_empleado = new JComboBox<>();
		cmb_empleado.setBackground(new Color(255, 255, 255));
		cmb_empleado.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		cmb_empleado.setBounds(162, 11, 300, 22);
		panel_1.add(cmb_empleado);
		
		lbl_dia = new JLabel("Día: ");
		lbl_dia.setForeground(new Color(255, 255, 255));
		lbl_dia.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lbl_dia.setBounds(31, 128, 90, 14);
		panel_1.add(lbl_dia);
		
		lbl_turno = new JLabel("Turno: ");
		lbl_turno.setForeground(new Color(255, 255, 255));
		lbl_turno.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lbl_turno.setBounds(31, 151, 49, 14);
		panel_1.add(lbl_turno);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(141, 440, 89, 23);
		panel_1.add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(442, 440, 89, 23);
		panel_1.add(btn_cancelar);
		
		lbl_lunes = new JLabel("Lunes");
		lbl_lunes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_lunes.setForeground(new Color(255, 255, 255));
		lbl_lunes.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lbl_lunes.setBounds(141, 98, 71, 55);
		panel_1.add(lbl_lunes);
		
		lbl_martes = new JLabel("Martes");
		lbl_martes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_martes.setForeground(new Color(255, 255, 255));
		lbl_martes.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lbl_martes.setBounds(222, 98, 78, 55);
		panel_1.add(lbl_martes);
		
		lbl_miercoles = new JLabel("Miércoles");
		lbl_miercoles.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_miercoles.setForeground(new Color(255, 255, 255));
		lbl_miercoles.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lbl_miercoles.setBounds(310, 98, 71, 55);
		panel_1.add(lbl_miercoles);
		
		lbl_jueves = new JLabel("Jueves");
		lbl_jueves.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jueves.setForeground(new Color(255, 255, 255));
		lbl_jueves.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lbl_jueves.setBounds(391, 98, 71, 55);
		panel_1.add(lbl_jueves);
		
		lbl_viernes = new JLabel("Viernes");
		lbl_viernes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_viernes.setForeground(new Color(255, 255, 255));
		lbl_viernes.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lbl_viernes.setBounds(472, 98, 71, 55);
		panel_1.add(lbl_viernes);
		
		lbl_matutino = new JLabel("Matutino");
		lbl_matutino.setForeground(new Color(255, 255, 255));
		lbl_matutino.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lbl_matutino.setBounds(31, 190, 125, 14);
		panel_1.add(lbl_matutino);
		
		lbl_vespertino = new JLabel("Vespertino");
		lbl_vespertino.setForeground(new Color(255, 255, 255));
		lbl_vespertino.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lbl_vespertino.setBounds(29, 240, 106, 14);
		panel_1.add(lbl_vespertino);
		
		JLabel lblNewLabel_11 = new JLabel("(07:00 – 15:00)");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_11.setBounds(31, 202, 104, 14);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("(13:00 – 21:00)");
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_12.setBounds(29, 253, 104, 14);
		panel_1.add(lblNewLabel_12);
		
		lbl_nocturno = new JLabel("Nocturno");
		lbl_nocturno.setForeground(new Color(255, 255, 255));
		lbl_nocturno.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lbl_nocturno.setBounds(31, 288, 106, 14);
		panel_1.add(lbl_nocturno);
		
		JLabel lblNewLabel_14 = new JLabel("(18:00 – 00:00)");
		lblNewLabel_14.setForeground(new Color(255, 255, 255));
		lblNewLabel_14.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_14.setBounds(31, 301, 104, 14);
		panel_1.add(lblNewLabel_14);
		
		lbl_madrugada = new JLabel("Madrugada");
		lbl_madrugada.setForeground(new Color(255, 255, 255));
		lbl_madrugada.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lbl_madrugada.setBounds(31, 339, 106, 14);
		panel_1.add(lbl_madrugada);
		
		JLabel lblNewLabel_16 = new JLabel("(23:00 – 07:00)");
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_16.setBounds(31, 352, 97, 14);
		panel_1.add(lblNewLabel_16);
		
		rbtn_lunes_matutino = new JRadioButton("");
		rbtn_lunes_matutino.setForeground(new Color(255, 255, 255));
		rbtn_lunes_matutino.setBackground(new Color(255, 255, 255));
		rbtn_lunes_matutino.setOpaque(false);
		rbtn_lunes_matutino.setBounds(162, 195, 21, 22);
		panel_1.add(rbtn_lunes_matutino);
		
		rbtn_lunes_vespertino = new JRadioButton("");
		rbtn_lunes_vespertino.setForeground(new Color(255, 255, 255));
		rbtn_lunes_vespertino.setBackground(new Color(255, 255, 255));
		rbtn_lunes_vespertino.setOpaque(false);
		rbtn_lunes_vespertino.setBounds(162, 245, 21, 23);
		panel_1.add(rbtn_lunes_vespertino);
		
		rbtn_lunes_nocturno = new JRadioButton("");
		rbtn_lunes_nocturno.setForeground(new Color(255, 255, 255));
		rbtn_lunes_nocturno.setBackground(new Color(255, 255, 255));
		rbtn_lunes_nocturno.setOpaque(false);
		rbtn_lunes_nocturno.setBounds(162, 293, 21, 23);
		panel_1.add(rbtn_lunes_nocturno);
		
		rbtn_lunes_madrugada = new JRadioButton("");
		rbtn_lunes_madrugada.setForeground(new Color(255, 255, 255));
		rbtn_lunes_madrugada.setBackground(new Color(255, 255, 255));
		rbtn_lunes_madrugada.setOpaque(false);
		rbtn_lunes_madrugada.setBounds(162, 344, 21, 23);
		panel_1.add(rbtn_lunes_madrugada);
		
		rbtn_martes_matutino = new JRadioButton("");
		rbtn_martes_matutino.setForeground(new Color(255, 255, 255));
		rbtn_martes_matutino.setBackground(new Color(255, 255, 255));
		rbtn_martes_matutino.setOpaque(false);
		rbtn_martes_matutino.setBounds(243, 195, 21, 22);
		panel_1.add(rbtn_martes_matutino);
		
		rbtn_martes_vespertino = new JRadioButton("");
		rbtn_martes_vespertino.setForeground(new Color(255, 255, 255));
		rbtn_martes_vespertino.setBackground(new Color(255, 255, 255));
		rbtn_martes_vespertino.setOpaque(false);
		rbtn_martes_vespertino.setBounds(243, 245, 21, 23);
		panel_1.add(rbtn_martes_vespertino);
		
		rbtn_martes_nocturno = new JRadioButton("");
		rbtn_martes_nocturno.setForeground(new Color(255, 255, 255));
		rbtn_martes_nocturno.setBackground(new Color(255, 255, 255));
		rbtn_martes_nocturno.setOpaque(false);
		rbtn_martes_nocturno.setBounds(243, 293, 21, 23);
		panel_1.add(rbtn_martes_nocturno);
		
		rbtn_martes_madrugada = new JRadioButton("");
		rbtn_martes_madrugada.setForeground(new Color(255, 255, 255));
		rbtn_martes_madrugada.setBackground(new Color(255, 255, 255));
		rbtn_martes_madrugada.setOpaque(false);
		rbtn_martes_madrugada.setBounds(243, 344, 21, 23);
		panel_1.add(rbtn_martes_madrugada);
		
		rbtn_miercoles_matutino = new JRadioButton("");
		rbtn_miercoles_matutino.setForeground(new Color(255, 255, 255));
		rbtn_miercoles_matutino.setBackground(new Color(255, 255, 255));
		rbtn_miercoles_matutino.setOpaque(false);
		rbtn_miercoles_matutino.setBounds(321, 195, 21, 22);
		panel_1.add(rbtn_miercoles_matutino);
		
		rbtn_jueves_matutino = new JRadioButton("");
		rbtn_jueves_matutino.setForeground(new Color(255, 255, 255));
		rbtn_jueves_matutino.setBackground(new Color(255, 255, 255));
		rbtn_jueves_matutino.setOpaque(false);
		rbtn_jueves_matutino.setBounds(409, 195, 21, 22);
		panel_1.add(rbtn_jueves_matutino);
		
		rbtn_viernes_matutino = new JRadioButton("");
		rbtn_viernes_matutino.setForeground(new Color(255, 255, 255));
		rbtn_viernes_matutino.setBackground(new Color(255, 255, 255));
		rbtn_viernes_matutino.setOpaque(false);
		rbtn_viernes_matutino.setBounds(485, 195, 21, 22);
		panel_1.add(rbtn_viernes_matutino);
		
		rbtn_miercoles_vespertino = new JRadioButton("");
		rbtn_miercoles_vespertino.setForeground(new Color(255, 255, 255));
		rbtn_miercoles_vespertino.setBackground(new Color(255, 255, 255));
		rbtn_miercoles_vespertino.setOpaque(false);
		rbtn_miercoles_vespertino.setBounds(321, 245, 21, 23);
		panel_1.add(rbtn_miercoles_vespertino);
		
		rbtn_jueves_vespertino = new JRadioButton("");
		rbtn_jueves_vespertino.setForeground(new Color(255, 255, 255));
		rbtn_jueves_vespertino.setBackground(new Color(255, 255, 255));
		rbtn_jueves_vespertino.setOpaque(false);
		rbtn_jueves_vespertino.setBounds(409, 245, 21, 23);
		panel_1.add(rbtn_jueves_vespertino);
		
		rbtn_viernes_vespertino = new JRadioButton("");
		rbtn_viernes_vespertino.setForeground(new Color(255, 255, 255));
		rbtn_viernes_vespertino.setBackground(new Color(255, 255, 255));
		rbtn_viernes_vespertino.setOpaque(false);
		rbtn_viernes_vespertino.setBounds(485, 245, 21, 23);
		panel_1.add(rbtn_viernes_vespertino);
		
		rbtn_miercoles_nocturno = new JRadioButton("");
		rbtn_miercoles_nocturno.setForeground(new Color(255, 255, 255));
		rbtn_miercoles_nocturno.setBackground(new Color(255, 255, 255));
		rbtn_miercoles_nocturno.setOpaque(false);
		rbtn_miercoles_nocturno.setBounds(321, 293, 21, 23);
		panel_1.add(rbtn_miercoles_nocturno);
		
		rbtn_jueves_nocturno = new JRadioButton("");
		rbtn_jueves_nocturno.setForeground(new Color(255, 255, 255));
		rbtn_jueves_nocturno.setBackground(new Color(255, 255, 255));
		rbtn_jueves_nocturno.setOpaque(false);
		rbtn_jueves_nocturno.setBounds(409, 293, 21, 23);
		panel_1.add(rbtn_jueves_nocturno);
		
		rbtn_viernes_nocturno = new JRadioButton("");
		rbtn_viernes_nocturno.setForeground(new Color(255, 255, 255));
		rbtn_viernes_nocturno.setBackground(new Color(255, 255, 255));
		rbtn_viernes_nocturno.setOpaque(false);
		rbtn_viernes_nocturno.setBounds(485, 293, 21, 23);
		panel_1.add(rbtn_viernes_nocturno);
		
		rbtn_miercoles_madrugada = new JRadioButton("");
		rbtn_miercoles_madrugada.setForeground(new Color(255, 255, 255));
		rbtn_miercoles_madrugada.setBackground(new Color(255, 255, 255));
		rbtn_miercoles_madrugada.setOpaque(false);
		rbtn_miercoles_madrugada.setBounds(321, 344, 21, 23);
		panel_1.add(rbtn_miercoles_madrugada);
		
		rbtn_jueves_madrugada = new JRadioButton("");
		rbtn_jueves_madrugada.setForeground(new Color(255, 255, 255));
		rbtn_jueves_madrugada.setBackground(new Color(255, 255, 255));
		rbtn_jueves_madrugada.setOpaque(false);
		rbtn_jueves_madrugada.setBounds(409, 344, 21, 23);
		panel_1.add(rbtn_jueves_madrugada);
		
		rbtn_viernes_madrugada = new JRadioButton("");
		rbtn_viernes_madrugada.setForeground(new Color(255, 255, 255));
		rbtn_viernes_madrugada.setBackground(new Color(255, 255, 255));
		rbtn_viernes_madrugada.setOpaque(false);
		rbtn_viernes_madrugada.setBounds(485, 344, 21, 23);
		panel_1.add(rbtn_viernes_madrugada);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(View_horarios.class.getResource("/resources/schedulerours.jpg")));
		lblNewLabel_1.setBounds(0, 0, 585, 517);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(View_horarios.class.getResource("/resources/Schedule.gif")));
		lblNewLabel_17.setBounds(578, 40, 427, 505);
		getContentPane().add(lblNewLabel_17);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        View_principal_admin principal = new View_principal_admin();
		        principal.setVisible(true);
		        dispose();
		    }
		});
		lvh = new Logica_View_horarios(this);
	}
}