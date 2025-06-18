package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
public class VentanaPadre extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPanePrincipal;
	private static JTextField textNombre;
	private static JTextField textCorreo;
	private static JButton btnAbrir;
	private static JButton btnCerrar;
	private static JLabel lbtCorreo;
	private static JLabel lblNombre;
	private static JButton btnLimpiar;

	private static JLabel lblMsj1;
	private static JLabel lblMsj2;
	private static JLabel lblTelefono;
	private static JFormattedTextField FtFTelefono;
	private static JLabel lblMsj3;
	private static MaskFormatter formato;// se declara para el masl de JFormattedTextField
	private static JLabel lblVisitas;
	private static JLabel lblContadorVisitas;
	private static int Contador;
	private VentanaHijas Ventana;// se inicializa una variable del tipo de ventana Jdialog para poder enviar la
									// informaci�n

	private static String[] Carreras = { // este tendria que ser llamado desde una base de datos
			"Ing. Sistemas Computacionales", "Ing. Agrotecnología", "Ing. Manejo de Recursos Naturales",
			"Lic. Administracion y Gestion Empresarial" };

	private static JComboBox<String> JcBCarreras;
	private static JPanel Jpane1;
	private static JPanel Jpane2;
	private static JLabel lblNewLabel;
	private static JLabel lblNewLabel_1;
	private static JButton btnSiguiente;
	private static JButton btnAnterior;
	private static JTabbedPane tabbedPanePrincipal;
	
	// Variable que almacenar� el idioma seleccionado
	private static Locale Idioma;
	private static ResourceBundle et;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPadre frame = new VentanaPadre();
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
	public VentanaPadre() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// se desavilita que se pueda cerrar por los botones del

		// Obtener el idioma por defecto del sistema
		//(de la maquina virtual Java)
		Idioma = Locale.getDefault();

		//Ahora en ingles americano
        Idioma = new Locale("en","US");
		
		// Mostrar el nombre del idioma obtenido
		System.out.println(Idioma.getDisplayName());
		System.out.println("====================");
		
		

		// Obtener los recursos desde el archivo <properties/dic>
		//en funci�n del idioma <locale>
		 et = ResourceBundle.getBundle("properties/dic", Idioma);

		// menu superior
		setBounds(100, 100, 510, 532);
		contentPanePrincipal = new JPanel();
		contentPanePrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanePrincipal);
		contentPanePrincipal.setLayout(null);
		// Inicializa Jpanel1
		Jpane1 = new JPanel();
		Jpane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Inicializa Jpanel1
		Jpane2 = new JPanel();
		Jpane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		// Variable contador la cual llevara la informaci�n
		// sobre el numero de veces que se visita la ventana hija
		Contador = 0;

		// inicializa para Mask para JFormattedTextField
		try {
			formato = new MaskFormatter("?");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnAbrir = new JButton(et.getString("abrir"));
		btnAbrir.setBounds(97, 425, 97, 25);
		contentPanePrincipal.add(btnAbrir);

		btnCerrar = new JButton(et.getString("cerrar"));
		btnCerrar.setBounds(313, 425, 97, 25);
		contentPanePrincipal.add(btnCerrar);

		btnLimpiar = new JButton(et.getString("limpiar"));
		btnLimpiar.setBounds(204, 425, 97, 25);
		contentPanePrincipal.add(btnLimpiar);

		lblNombre = new JLabel(et.getString("nombre"));
		lblNombre.setBounds(8, 35, 56, 16);
		contentPanePrincipal.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(99, 32, 123, 22);
		// Aqui se asigna el PlaseHolder al componente
//		textNombre.setPlaceholder("Nombre Empleado");
		contentPanePrincipal.add(textNombre);

		lbtCorreo = new JLabel(et.getString("correo"));
		lbtCorreo.setBounds(8, 93, 56, 16);
		contentPanePrincipal.add(lbtCorreo);

		textCorreo = new JTextField();
		// Aqui se asigna el PlaseHolder al componente
		//textCorreo.setPlaceholder("Correo@Dominio.com");
		textCorreo.setBounds(97, 90, 123, 22);
		contentPanePrincipal.add(textCorreo);
		
	
		lblMsj1 = new JLabel("Valida mediante keyTyped");
		lblMsj1.setBounds(234, 32, 176, 16);
		contentPanePrincipal.add(lblMsj1);

		lblMsj2 = new JLabel("Valida Mediante Expresiones Regulares");
		lblMsj2.setBounds(233, 90, 251, 16);
		contentPanePrincipal.add(lblMsj2);

		lblTelefono = new JLabel(et.getString("telefono"));
		lblTelefono.setBounds(8, 143, 56, 16);
		contentPanePrincipal.add(lblTelefono);

		FtFTelefono = new JFormattedTextField(formato);
		FtFTelefono.setBounds(97, 140, 123, 22);
		contentPanePrincipal.add(FtFTelefono);

		lblMsj3 = new JLabel("Valida con JFormattedTextField");
		lblMsj3.setBounds(234, 140, 229, 16);
		contentPanePrincipal.add(lblMsj3);

		lblVisitas = new JLabel("Visitas a Ventana hija");
		lblVisitas.setBounds(105, 394, 141, 16);
		contentPanePrincipal.add(lblVisitas);

		lblContadorVisitas = new JLabel("0");
		lblContadorVisitas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		lblContadorVisitas.setBounds(258, 396, 29, 16);
		contentPanePrincipal.add(lblContadorVisitas);

		JcBCarreras = new JComboBox<String>();
		JcBCarreras.setModel(new DefaultComboBoxModel<String>(Carreras));
		JcBCarreras.setMaximumRowCount(3);
		JcBCarreras.setBounds(98, 197, 176, 22);
		contentPanePrincipal.add(JcBCarreras);

		JLabel lblPeducativo = new JLabel("P. Educativo");
		lblPeducativo.setBounds(8, 197, 78, 16);
		contentPanePrincipal.add(lblPeducativo);

		tabbedPanePrincipal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.setBounds(0, 297, 496, 89);
		contentPanePrincipal.add(tabbedPanePrincipal);

		
		tabbedPanePrincipal.addTab(et.getString("tabletPanel")+1, Jpane1);
		Jpane1.setLayout(null);

		lblNewLabel_1 = new JLabel(et.getString("tabletPanel")+1);
		lblNewLabel_1.setBounds(0, 13, 116, 16);
		Jpane1.add(lblNewLabel_1);

		btnSiguiente = new JButton(et.getString("siguiente"));
		btnSiguiente.setBounds(256, 34, 189, 25);
		Jpane1.add(btnSiguiente);

	
		tabbedPanePrincipal.addTab(et.getString("tabletPanel")+2, Jpane2);
		Jpane2.setLayout(null);

		lblNewLabel = new JLabel(et.getString("tabletPanel")+2);
		lblNewLabel.setBounds(0, 13, 106, 16);
		Jpane2.add(lblNewLabel);

		btnAnterior = new JButton(et.getString("anterior"));
		btnAnterior.setBounds(300, 34, 160, 25);
		Jpane2.add(btnAnterior);

		// crea nuevo ManejadorBoton para manejar los eventos de bot�n
		ManejadorBoton manejadorB = new ManejadorBoton();
		btnAbrir.addActionListener(manejadorB);
		btnCerrar.addActionListener(manejadorB);
		btnLimpiar.addActionListener(manejadorB);
		btnSiguiente.addActionListener(manejadorB);
		btnAnterior.addActionListener(manejadorB);

		// Crea manejador del focus
		ManejadorFocus manejadorF = new ManejadorFocus();
		textCorreo.addFocusListener(manejadorF);

		// Crea manejador del Key
		ManejadorKey manejadorK = new ManejadorKey();
		textNombre.addKeyListener(manejadorK);

	}

	/*
	 * este m�todo valida una cadena que recibe como entrada y devielve si es un
	 * coreo valido o no
	 */
	public boolean isEmail(String correo) {
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
		mat = pat.matcher(correo);
		if (mat.find()) {
			return true;
		} else {
			return false;
		}
	}

	// M�todo de KeyListener valida el txtFile donde se valida en tiempos de
	// escritura
	private class ManejadorKey implements KeyListener {

		@Override
		public void keyTyped(KeyEvent eventK) {
			// TODO Auto-generated method stub
			if (eventK.getSource().equals(textNombre)) {

				// Valida solo valores numericos espacio punto y retroceso para borrar
				/*
				 * if (!Character.isDigit(eventK.getKeyChar()) && !(eventK.getKeyChar() == '.')
				 * && !(eventK.getKeyChar() == KeyEvent.VK_BACK_SPACE)) { eventK.consume(); }
				 */

				// Valida solo valores Alfabeticos espacio en blanco y retroceso para borrar

				if (!Character.isLetter(eventK.getKeyChar()) && !(eventK.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(eventK.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					eventK.consume();
					JOptionPane.showMessageDialog(VentanaPadre.this, "Debes validar el Nombre", "ATENCI�N ADMINISTRADOR",
							JOptionPane.WARNING_MESSAGE);
				}

			} else if (eventK.getSource().equals(textCorreo)) {

			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}

	}

	// m�todo FocusListener
	private class ManejadorFocus implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if (!isEmail(textCorreo.getText())) {
				JOptionPane.showMessageDialog(VentanaPadre.this, "Debes validar el email!", "ATENCIÓN ADMINISTRADOR",
						JOptionPane.WARNING_MESSAGE);
				textCorreo.requestFocus();
			}

		}

	}

	/// M�todo de Action Listener
	private class ManejadorBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if (event.getSource().equals(btnLimpiar)) {
				textCorreo.setText("");
				textNombre.setText("");
				FtFTelefono.setText("");

				JOptionPane.showMessageDialog(VentanaPadre.this, "Se limpiaron los datos de los campos  ");
			} else if (event.getSource().equals(btnCerrar)) {
				System.exit(0);//Cierra una ventana 
			} else if (event.getSource().equals(btnAbrir)) {

				Ventana = new VentanaHijas(VentanaPadre.this, true,Idioma);
				Ventana.lblEtiqueta.setText((String) JcBCarreras.getSelectedItem());
				Ventana.ContadorHijo = Contador;
				Ventana.setVisible(true);

				// el proceso continua despues de cerrada la ventana desde el boton
				// si se cierra desde la X de la ventana no realizara las actividades
				Contador = Ventana.ContadorHijo;
				lblContadorVisitas.setText(Integer.toString(Contador));
				
				JcBCarreras.addItem(Ventana.DatosUniversida);
				
			} else if (event.getSource().equals(btnSiguiente)) {
				// permite que se mueva a la siguente pesta�a
				tabbedPanePrincipal.setSelectedIndex(1);
			} else if (event.getSource().equals(btnAnterior)) {// importante mencionar que los indices de las pesta�as
																// se manejan desde 0 a N (numero de pesta�as)
				// permite que regrese a la pesta�a anterior
				tabbedPanePrincipal.setSelectedIndex(0);
			}
		}

	}
	
}
