package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	public HojaPersonaje Personaje;
	public AñadirDatos Datos;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu");
		lblTituloMenu.setBounds(185, 10, 45, 13);
		contentPane.add(lblTituloMenu);
		
		btnPersonajes = new JButton("Hoja De Personaje");
		btnPersonajes.setBounds(165, 74, 85, 21);
		contentPane.add(btnPersonajes);
		
		btnCrearClases = new JButton("Crear Clases o Razas");
		btnCrearClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearClases.setBounds(165, 105, 85, 21);
		contentPane.add(btnCrearClases);
		
		ManejadorBoton EscuchadorBotones = new ManejadorBoton();
		
		btnPersonajes.addActionListener(EscuchadorBotones);
		btnCrearClases.addActionListener(EscuchadorBotones);
		
	}
	
	private class ManejadorBoton implements ActionListener {



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(btnPersonajes)) {
				Personaje=new HojaPersonaje();
				Personaje.setVisible(true);
			}
			if (e.getSource().equals(btnCrearClases)) {
				Datos=new AñadirDatos();
				Datos.setVisible(true);	
			}
		} // Manejador Botones
	}
}
