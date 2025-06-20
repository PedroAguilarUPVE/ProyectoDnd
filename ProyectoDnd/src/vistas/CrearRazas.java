package vistas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import controladores.CClase;
import controladores.CRaza;
import modelos.OClase;
import modelos.ORaza;

/**
 * Clase crear clases. Maneja la creacion de clases y razas y su insercion en la base de datos
 */
public class CrearRazas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelContenido;

	private JTextField campoDescripcionRaza;
	private JTextField campoDescripcionClase;
	private JTextField campoClase;
	private JTextField campoRaza;

	private JButton botonGuardarRaza;

	private JComboBox comboBoxTamano;
	private JComboBox comboBoxTipoClase;

	private JSpinner spinnerVelocidad;
	private JSpinner spinnerDaño;

	private JSpinner spinnerFuerza;
	private JSpinner spinnerDestreza;
	private JSpinner spinnerConstitucion;
	private JSpinner spinnerInteligencia;
	private JSpinner spinnerSabiduria;
	private JSpinner spinnerCarisma;

	private ResourceBundle et;

	/**
	 * Constructor de la ventana de creacion de clases y razas
	 * Se crea como hija de la ventana menu
	 * 
	 * @param parent Clase Frame Indica el componente padre de de la ventana CrearClases
	 * @param modal  Clase boolean Indica el modo de sobreposicion de la ventana hija
	 * @param Idioma Clase Locale Hereda el parametro tipo Locale de la clase padre, para la
	 *               seleccion de idioma
	 * @param i 
	 */
	public CrearRazas(Frame parent, boolean modal, Locale Idioma, int i) {
		super(parent, modal);
		et = ResourceBundle.getBundle("properties/dic", Idioma);
		setTitle(et.getString("crearClases"));

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		panelContenido = new JPanel();
		panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelContenido);
		panelContenido.setLayout(null);

		JTabbedPane panelPestanas = new JTabbedPane(JTabbedPane.TOP);
		panelPestanas.setBounds(10, 10, 416, 343);
		panelContenido.add(panelPestanas);


		// Panel RAZA
		JPanel panelRaza = new JPanel();
		panelRaza.setLayout(null);
		panelPestanas.addTab(et.getString("raza"), null, panelRaza, null);

		JLabel etiquetaNombreRaza = new JLabel(et.getString("etiqueta.nombreRaza"));
		etiquetaNombreRaza.setBounds(10, 19, 140, 16);
		panelRaza.add(etiquetaNombreRaza);

		campoRaza = new JTextField();
		campoRaza.setBounds(170, 10, 231, 30);
		panelRaza.add(campoRaza);

		JLabel etiquetaDescripcionRaza = new JLabel(et.getString("etiqueta.descripcionRaza"));
		etiquetaDescripcionRaza.setBounds(10, 76, 140, 16);
		panelRaza.add(etiquetaDescripcionRaza);

		campoDescripcionRaza = new JTextField();
		campoDescripcionRaza.setBounds(170, 76, 231, 35);
		panelRaza.add(campoDescripcionRaza);

		JLabel etiquetaTamaño = new JLabel(et.getString("etiqueta.tamano"));
		etiquetaTamaño.setBounds(10, 131, 140, 16);
		panelRaza.add(etiquetaTamaño);

		comboBoxTamano = new JComboBox();
		comboBoxTamano.setBounds(170, 129, 231, 21);
		comboBoxTamano.addItem("Pequeño");
		comboBoxTamano.addItem("Mediano");
		comboBoxTamano.addItem("Grande");
		comboBoxTamano.addItem("Enorme");
		panelRaza.add(comboBoxTamano);

		JLabel etiquetaVelocidad = new JLabel(et.getString("etiqueta.velocidad"));
		etiquetaVelocidad.setBounds(10, 167, 116, 16);
		panelRaza.add(etiquetaVelocidad);

		spinnerVelocidad = new JSpinner();
		spinnerVelocidad.setBounds(170, 166, 63, 20);
		panelRaza.add(spinnerVelocidad);

		// Estadísticas
		JLabel etiquetaFuerza = new JLabel(et.getString("etiqueta.fuerza"));
		etiquetaFuerza.setBounds(10, 200, 80, 16);
		panelRaza.add(etiquetaFuerza);
		spinnerFuerza = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerFuerza.setBounds(80, 200, 50, 20);
		panelRaza.add(spinnerFuerza);

		JLabel etiquetaDestreza = new JLabel(et.getString("etiqueta.destreza"));
		etiquetaDestreza.setBounds(140, 200, 80, 16);
		panelRaza.add(etiquetaDestreza);
		spinnerDestreza = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerDestreza.setBounds(210, 200, 50, 20);
		panelRaza.add(spinnerDestreza);

		JLabel etiquetaConstitucion = new JLabel(et.getString("etiqueta.constitucion"));
		etiquetaConstitucion.setBounds(270, 200, 80, 16);
		panelRaza.add(etiquetaConstitucion);
		spinnerConstitucion = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerConstitucion.setBounds(360, 200, 50, 20);
		panelRaza.add(spinnerConstitucion);

		JLabel etiquetaInteligencia = new JLabel(et.getString("etiqueta.inteligencia"));
		etiquetaInteligencia.setBounds(10, 225, 80, 16);
		panelRaza.add(etiquetaInteligencia);
		spinnerInteligencia = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerInteligencia.setBounds(80, 225, 50, 20);
		panelRaza.add(spinnerInteligencia);

		JLabel etiquetaSabiduria = new JLabel(et.getString("etiqueta.sabiduria"));
		etiquetaSabiduria.setBounds(140, 225, 80, 16);
		panelRaza.add(etiquetaSabiduria);
		spinnerSabiduria = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerSabiduria.setBounds(210, 225, 50, 20);
		panelRaza.add(spinnerSabiduria);

		JLabel etiquetaCarisma = new JLabel(et.getString("etiqueta.carisma"));
		etiquetaCarisma.setBounds(270, 225, 80, 16);
		panelRaza.add(etiquetaCarisma);
		spinnerCarisma = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerCarisma.setBounds(360, 225, 50, 20);
		panelRaza.add(spinnerCarisma);

		botonGuardarRaza = new JButton(et.getString("boton.guardarRaza"));
		botonGuardarRaza.setBounds(134, 272, 153, 21);
		panelRaza.add(botonGuardarRaza);

		ManejadorBoton manejador = new ManejadorBoton();
		botonGuardarRaza.addActionListener(manejador);
	}

	/**
	 * Crear la clase ManejadorBoton implementando ActionListener para llevar control de los botones
	 * Controla los eventos al precionar cada boton
	 */
	private class ManejadorBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(botonGuardarRaza)) {
				CrearRaza();
			}
		}
	}

	/**
	 * Metodo CrearClase() Obtiene los datos de clase ingresados por el usuario
	 * y los ingresa a la Clases de la base de datos 
	 * No requiere parametros ni retorna valores de salida
	 */
	public void CrearClase() {
		try {
			OClase nuevaClase = new OClase();
			nuevaClase.setNombreClase(campoClase.getText());
			nuevaClase.setDescripcionClase(campoDescripcionClase.getText());
			nuevaClase.setTipoClase((String) comboBoxTipoClase.getSelectedItem());
			nuevaClase.setDadoDano((Integer) spinnerDaño.getValue());

			new CClase().registrarClase(nuevaClase);
			JOptionPane.showMessageDialog(null, et.getString("mensaje.exito.clase"));
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, et.getString("mensaje.error.clase"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo CrearRaza() Obtiene los datos de clase ingresados por el usuario 
	 * y los ingresa a la Razas de la base de datos 
	 * No requiere parametros ni retorna valores de salida
	 */
	public void CrearRaza() {
		try {
			ORaza nuevaRaza = new ORaza();
			nuevaRaza.setNombreRaza(campoRaza.getText());
			nuevaRaza.setDescripcionRaza(campoDescripcionRaza.getText());
			nuevaRaza.setTamanoRaza((String) comboBoxTamano.getSelectedItem());
			nuevaRaza.setVelocidadRaza((Integer) spinnerVelocidad.getValue());

			nuevaRaza.setFuerza((Integer) spinnerFuerza.getValue());
			nuevaRaza.setDestreza((Integer) spinnerDestreza.getValue());
			nuevaRaza.setConstitucion((Integer) spinnerConstitucion.getValue());
			nuevaRaza.setInteligencia((Integer) spinnerInteligencia.getValue());
			nuevaRaza.setSabiduria((Integer) spinnerSabiduria.getValue());
			nuevaRaza.setCarisma((Integer) spinnerCarisma.getValue());

			new CRaza().registrarRaza(nuevaRaza);
			JOptionPane.showMessageDialog(null, et.getString("mensaje.exito.raza"));
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, et.getString("mensaje.error.raza"), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
