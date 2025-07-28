package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

/**
 * Clase Menu es la ventana principal a ejecutarse al iniciar el proyecto
 */
public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTituloMenu;
	private JButton btnPersonajes;
	private JButton btnCrearClases;
	public CrearPersonaje Personaje;
	public CrearClases Clases;

	private Locale Idioma;
	private ResourceBundle et;
	private JButton btnTablas;
	public panelesJtables tablas;
	private JButton btnCrearPartida;
	public CrearPartida Partidas;
	private JButton btnCrearRazas;
	private JButton btnCrearSubclases;
	private JRadioButton rdbtnIngles;
	private JRadioButton rdbtnEspanol;
	private ButtonGroup grupoIdioma = new ButtonGroup();
	private JLabel lblIdioma;

	/**
	 * Metodo main Se ejecuta al iniciar la clase. Invoca al contructor de la
	 * ventana Menu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la ventana Menu desde la cual se invocan al resto de ventanas
	 */
	public Menu() {
		Idioma = Locale.getDefault();
		// Idioma = new Locale("en", "US");

		et = ResourceBundle.getBundle("properties/dic", Idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTituloMenu = new JLabel(et.getString("tituloMenu"));
		lblTituloMenu.setBounds(185, 10, 200, 13);
		contentPane.add(lblTituloMenu);

		btnPersonajes = new JButton(et.getString("hojaPersonaje"));
		btnPersonajes.setBounds(115, 74, 185, 20);
		contentPane.add(btnPersonajes);

		btnCrearRazas = new JButton(et.getString("crearRazas"));
		btnCrearRazas.setBounds(10, 105, 185, 20);
		contentPane.add(btnCrearRazas);

		btnCrearClases = new JButton(et.getString("crearClases"));
		btnCrearClases.setBounds(220, 105, 185, 20);
		contentPane.add(btnCrearClases);

		btnCrearSubclases = new JButton(et.getString("crearSubclases"));
		btnCrearSubclases.setBounds(115, 136, 185, 20);
		contentPane.add(btnCrearSubclases);

		btnTablas = new JButton(et.getString("VerTablas"));
		btnTablas.setBounds(115, 198, 185, 20);
		contentPane.add(btnTablas);

		btnCrearPartida = new JButton(et.getString("CrearPartida"));
		btnCrearPartida.setBounds(115, 167, 185, 20);
		contentPane.add(btnCrearPartida);

		rdbtnEspanol = new JRadioButton(et.getString("Espanol"));
		rdbtnEspanol.setBounds(120, 240, 120, 20);
		contentPane.add(rdbtnEspanol);
		grupoIdioma.add(rdbtnEspanol);

		rdbtnIngles = new JRadioButton(et.getString("Ingles"));
		rdbtnIngles.setBounds(260, 240, 120, 20);
		contentPane.add(rdbtnIngles);
		grupoIdioma.add(rdbtnIngles);

		lblIdioma = new JLabel(et.getString("Idioma"));
		lblIdioma.setBounds(20, 240, 80, 20);
		contentPane.add(lblIdioma);

		ManejadorBoton EscuchadorBotones = new ManejadorBoton();

		btnTablas.addActionListener(EscuchadorBotones);
		btnPersonajes.addActionListener(EscuchadorBotones);
		btnCrearClases.addActionListener(EscuchadorBotones);
		btnCrearRazas.addActionListener(EscuchadorBotones);
		btnCrearSubclases.addActionListener(EscuchadorBotones);
		btnCrearPartida.addActionListener(EscuchadorBotones);
		rdbtnEspanol.addActionListener(EscuchadorBotones);
		rdbtnIngles.addActionListener(EscuchadorBotones);

	}

	/**
	 * Crear la clase ManejadorBoton implementando ActionListener para llevar
	 * control de los botones Controla los eventos al precionar cada boton
	 */
	private class ManejadorBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnPersonajes)) {
				CrearPersonaje Personaje = new CrearPersonaje(Menu.this, true, Idioma, 0);
				Personaje.setVisible(true);
			}
			if (e.getSource().equals(btnCrearClases)) {
				CrearClases Clases = new CrearClases(Menu.this, true, Idioma, 0);
				Clases.setVisible(true);
			}
			if (e.getSource().equals(btnCrearRazas)) {
				CrearRazas Razas = new CrearRazas(Menu.this, true, Idioma, 0);
				Razas.setVisible(true);
			}
			if (e.getSource().equals(btnCrearSubclases)) {
				CrearSubclases Subclases = new CrearSubclases(Menu.this, true, Idioma, 0);
				Subclases.setVisible(true);
			}

			if (e.getSource().equals(btnTablas)) {
				tablas = new panelesJtables(Menu.this, true, Idioma);
				tablas.setVisible(true);
			}
			if (e.getSource().equals(btnCrearPartida)) {
				Partidas = new CrearPartida(Menu.this, true, Idioma);
				Partidas.setVisible(true);
			}

			if (e.getSource().equals(rdbtnIngles)) {
				Idioma = new Locale("en", "US");
				ActualizarMenu(Idioma);
			}
			if (e.getSource().equals(rdbtnEspanol)) {
				Idioma = new Locale("es", "MX");
				ActualizarMenu(Idioma);
			}
		}
	}

	public void ActualizarMenu(Locale idioma) {

		et = ResourceBundle.getBundle("properties/dic", idioma);
		// TODO Auto-generated method stub
		lblTituloMenu.setText(et.getString("tituloMenu"));
		btnPersonajes.setText(et.getString("hojaPersonaje"));
		btnCrearRazas.setText(et.getString("crearRazas"));
		btnCrearClases.setText(et.getString("crearClases"));
		btnCrearSubclases.setText(et.getString("crearSubclases"));
		btnTablas.setText(et.getString("VerTablas"));
		btnCrearPartida.setText(et.getString("CrearPartida"));
		rdbtnEspanol.setText(et.getString("Espanol"));
		rdbtnIngles.setText(et.getString("Ingles"));
		lblIdioma.setText(et.getString("Idioma") );

	}
}
