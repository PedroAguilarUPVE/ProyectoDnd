package vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.bolivia.swing.JCTextField;
import controladores.CLogin;
import controladores.MD5;
import jpass.JRPasswordField;
import modelo.MUsuario;

public class LoginUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanelPrincipal;
	private static ResourceBundle et;
	private Locale Idioma;
	private JButton btnEntrar;
	private JCTextField jTextUser;
	private JRPasswordField jTextPass;
	private JLabel jLOlvidaste;
	private JLabel jLUsuario;
	private JLabel jLUserMini;
	private JLabel jLlave;
	private JSeparator jSeparator2;
	private JLabel jLImagenUsuario;
	private JLabel jLAcceso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser frame = new LoginUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginUser() {

		/// Inicializar Variables para Internacionalizacion
		// Obtener el idioma por defecto del sistema
		// (de la maquina virtual Java)
		Idioma = Locale.getDefault();

		// Ahora en ingles americano
		// Idioma = new Locale("en","US");

		// Obtener los recursos desde el archivo <properties/dic>
		// en función del idioma <locale>
		et = ResourceBundle.getBundle("properties/dic", Idioma);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginUser.class.getResource("/imagenes/key.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 644);
		setLocationRelativeTo(null);// permite sentrar el frame en medio de de la pantalla
		jPanelPrincipal = new JPanel();
		jPanelPrincipal.setBackground(new Color(128, 0, 255));
		jPanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jPanelPrincipal);
		jPanelPrincipal.setLayout(null);

		jLUsuario = new JLabel();
		jLUsuario.setText(et.getString("usuario") + ":");
		jLUsuario.setForeground(Color.WHITE);
		jLUsuario.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		jLUsuario.setBounds(145, 199, 59, 17);
		jPanelPrincipal.add(jLUsuario);

		jTextUser = new JCTextField();
		jTextUser.setPlaceholder(et.getString("nomusuario"));
		jTextUser.setHorizontalAlignment(SwingConstants.CENTER);
		jTextUser.setForeground(Color.WHITE);
		jTextUser.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		jTextUser.setBorder(null);
		jTextUser.setBackground(new Color(128, 128, 255));
		jTextUser.setBounds(77, 231, 195, 32);
		jPanelPrincipal.add(jTextUser);

		jLUserMini = new JLabel();
		jLUserMini.setIcon(new ImageIcon(LoginUser.class.getResource("/imagenes/userLabel.png")));
		jLUserMini.setBounds(55, 240, 16, 16);
		jPanelPrincipal.add(jLUserMini);

		jTextPass = new JRPasswordField();
		jTextPass.setPlaceholder("Contraseña");
		jTextPass.setHorizontalAlignment(SwingConstants.CENTER);
		jTextPass.setForeground(Color.WHITE);
		jTextPass.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		jTextPass.setBorder(null);
		jTextPass.setBackground(new Color(128, 128, 255));
		jTextPass.setBounds(79, 360, 190, 32);
		jPanelPrincipal.add(jTextPass);

		JLabel lblPass = new JLabel();
		lblPass.setText(et.getString("contra") + ":");
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblPass.setBounds(130, 328, 88, 17);
		jPanelPrincipal.add(lblPass);

		jLlave = new JLabel();
		jLlave.setIcon(new ImageIcon(LoginUser.class.getResource("/imagenes/key.png")));
		jLlave.setBounds(55, 368, 16, 16);
		jPanelPrincipal.add(jLlave);

		jSeparator2 = new JSeparator();
		jSeparator2.setForeground(Color.WHITE);
		jSeparator2.setBackground(Color.WHITE);
		jSeparator2.setBounds(57, 407, 235, 41);
		jPanelPrincipal.add(jSeparator2);

		JSeparator jSeparator1 = new JSeparator();
		jSeparator1.setForeground(Color.WHITE);
		jSeparator1.setBackground(Color.WHITE);
		jSeparator1.setBounds(57, 278, 235, 35);
		jPanelPrincipal.add(jSeparator1);

		btnEntrar = new JButton();
		btnEntrar.setText("Iniciar sesión");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		btnEntrar.setBorder(null);
		btnEntrar.setBackground(new Color(128, 128, 255));
		btnEntrar.setBounds(98, 463, 152, 42);
		jPanelPrincipal.add(btnEntrar);

		jLOlvidaste = new JLabel();
		jLOlvidaste.setText("¿Olvidaste tu contraseña?");
		jLOlvidaste.setForeground(Color.WHITE);
		jLOlvidaste.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		jLOlvidaste.setBounds(79, 520, 191, 17);
		jPanelPrincipal.add(jLOlvidaste);

		jLImagenUsuario = new JLabel();
		jLImagenUsuario.setIcon(new ImageIcon(LoginUser.class.getResource("/imagenes/userInicio.png")));
		jLImagenUsuario.setBounds(110, 56, 128, 128);
		jPanelPrincipal.add(jLImagenUsuario);

		jLAcceso = new JLabel();
		jLAcceso.setText(et.getString("acceso"));
		jLAcceso.setForeground(Color.WHITE);
		jLAcceso.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		jLAcceso.setBackground(Color.WHITE);
		jLAcceso.setBounds(131, 11, 86, 30);
		jPanelPrincipal.add(jLAcceso);

		ControladorAction Escuchador = new ControladorAction();
		jTextUser.addActionListener(Escuchador);
		jTextPass.addActionListener(Escuchador);
		btnEntrar.addActionListener(Escuchador);

		ControlEnterBoton EscuchadorEnter = new ControlEnterBoton();

		btnEntrar.addKeyListener(EscuchadorEnter);

		ControlMouse EscuchadorMouse = new ControlMouse();
		jLOlvidaste.addMouseListener(EscuchadorMouse);

	}

	public void Valida() {
		//Método Valida si el usuario y la contraseña son correctas  
		MUsuario User = new MUsuario();// se crea un objeto usuario  para interactuar con la información de la base de datos
		User.setUsuario(jTextUser.getText());// envia lo que este en el campo usuario al objeto usuario

		CLogin Login = new CLogin();//crea  un  objeto del controlador   login 

		User = Login.BuscarUsuario(User);  //Verifica que exista el susuario 

		char[] Datos = jTextPass.getPassword();  //construye una cadena a apartir de  los  caracteres  del  componente Jpasswaord

		String inf = "";
		for (int x = 0; x < Datos.length; x++) {
			inf += Datos[x];
		}//en if queda la cadena de la contraseña 
		
		
		if (MD5.Encripta(inf).equalsIgnoreCase(User.getPassword())) {//valida que la contraseña introducida se la misma que  la de BD
			//En caso de ser correcta  se ejecuta la venta  Vpersona
			JOptionPane.showMessageDialog(null, "Password Correcto", "Información", 1);
			Vpersona VentanaPersona = new Vpersona();
			VentanaPersona.setVisible(true); //se visualiza la ventana VentanaPersona  
			dispose();///se  cierra ela ventana login 

		} else if (User.getPassword() == null) {//en caso de que el usuario no exista en la BD
			JOptionPane.showMessageDialog(null, "Usuario Incorrecto", "Información", 2);
			jTextUser.requestFocus();
		} else {//en caso de que la contraseña no sea la misma  de la BD
			JOptionPane.showMessageDialog(null, "Password Incorrecto", "Informaci�n", 2);
			jTextPass.requestFocus();
		}

	}

	public class ControlMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent EventClickMosuse) {

			if (EventClickMosuse.getSource().equals(jLOlvidaste)) {
				JOptionPane.showMessageDialog(null, "Ventana Para Cambiar Password", "Cambia", 1);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class ControlEnterBoton implements KeyListener {
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			char c = (char) e.getKeyCode();
			if (c == KeyEvent.VK_ENTER) {

				Valida();

			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class ControladorAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			((Component) e.getSource()).transferFocus();

			if (e.getSource() == btnEntrar) {
				Valida();
			}

		}

	}
}
