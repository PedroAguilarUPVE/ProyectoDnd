package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTituloMenu;
	private JButton btnPersonajes;
	private JButton btnCrearClases;
	public CrearPersonaje Personaje;
	public CrearClases Datos;
	
	private static Locale Idioma;
	private static ResourceBundle et;
	private JButton btnEditarPersonajes;
	private JButton btnEditarClases;
	public EditarPersonaje VerPersonaje;
	public vistas.EditarClases VerDatos;

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

	public Menu() {
		Idioma = Locale.getDefault();
		//Idioma = new Locale("en", "US");
		
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
		btnPersonajes.setBounds(115, 74, 185, 21);
		contentPane.add(btnPersonajes);
		
		btnCrearClases = new JButton(et.getString("crearClases"));
		btnCrearClases.setBounds(115, 105, 185, 21);
		contentPane.add(btnCrearClases);
		
		btnEditarPersonajes = new JButton(et.getString("editarPersonajes"));
		btnEditarPersonajes.setBounds(115, 136, 185, 21);
		contentPane.add(btnEditarPersonajes);
		
		btnEditarClases = new JButton(et.getString("editarClases"));
		btnEditarClases.setBounds(115, 167, 185, 21);
		contentPane.add(btnEditarClases);

		ManejadorBoton EscuchadorBotones = new ManejadorBoton();
		
		btnPersonajes.addActionListener(EscuchadorBotones);
		btnCrearClases.addActionListener(EscuchadorBotones);
		btnEditarPersonajes.addActionListener(EscuchadorBotones);
		btnEditarClases.addActionListener(EscuchadorBotones);
	}

	private class ManejadorBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnPersonajes)) {
				Personaje = new CrearPersonaje(Menu.this, true, Idioma);
				Personaje.setVisible(true);
			}
			if (e.getSource().equals(btnCrearClases)) {
				Datos = new CrearClases(Menu.this, true, Idioma);
				Datos.setVisible(true);	
			}
			if (e.getSource().equals(btnEditarPersonajes)) {
				VerPersonaje = new EditarPersonaje(Menu.this, true, Idioma);
				VerPersonaje.setVisible(true);
			}
			if (e.getSource().equals(btnEditarClases)) {
				VerDatos = new EditarClases(Menu.this, true, Idioma);
				VerDatos.setVisible(true);	
			}
		}
	}
}
