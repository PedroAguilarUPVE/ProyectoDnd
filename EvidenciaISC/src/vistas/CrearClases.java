package vistas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controladores.CClase;
import controladores.CRaza;
import modelos.OClase;
import modelos.ORaza;

public class CrearClases extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelContenido;

	private JTextField campoDescripcionRaza;
	private JTextField campoDescripcionClase;
	private JTextField campoClase;
	private JTextField campoRaza;

	private JButton botonGuardarRaza;
	private JButton botonGuardarClase;

	private JComboBox comboBoxTamaño;
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

	public CrearClases(Frame parent, boolean modal, Locale Idioma) {
		super(parent, modal);
		et = ResourceBundle.getBundle("properties/dic", Idioma);
		setTitle(et.getString("titulo.crearClases"));

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		panelContenido = new JPanel();
		panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelContenido);
		panelContenido.setLayout(null);

		JTabbedPane panelPestanas = new JTabbedPane(JTabbedPane.TOP);
		panelPestanas.setBounds(10, 10, 416, 343);
		panelContenido.add(panelPestanas);

		// Panel CLASE
		JPanel panelClase = new JPanel();
		panelClase.setLayout(null);
		panelPestanas.addTab(et.getString("pestana.clase"), null, panelClase, null);

		JLabel etiquetaNombreClase = new JLabel(et.getString("etiqueta.nombreClase"));
		etiquetaNombreClase.setBounds(10, 19, 140, 16);
		panelClase.add(etiquetaNombreClase);

		campoClase = new JTextField();
		campoClase.setBounds(170, 10, 231, 30);
		panelClase.add(campoClase);

		JLabel etiquetaDescripcionClase = new JLabel(et.getString("etiqueta.descripcionClase"));
		etiquetaDescripcionClase.setBounds(10, 50, 150, 16);
		panelClase.add(etiquetaDescripcionClase);

		campoDescripcionClase = new JTextField();
		campoDescripcionClase.setBounds(170, 50, 231, 35);
		panelClase.add(campoDescripcionClase);

		JLabel etiquetaTipoClase = new JLabel(et.getString("etiqueta.tipoClase"));
		etiquetaTipoClase.setBounds(10, 105, 116, 16);
		panelClase.add(etiquetaTipoClase);

		comboBoxTipoClase = new JComboBox();
		comboBoxTipoClase.setBounds(170, 103, 231, 21);
		comboBoxTipoClase.addItem("Marcial");
		comboBoxTipoClase.addItem("Magica");
		comboBoxTipoClase.addItem("Mixta");
		panelClase.add(comboBoxTipoClase);

		JLabel etiquetaDadoDanio = new JLabel(et.getString("etiqueta.dadoDanio"));
		etiquetaDadoDanio.setBounds(10, 141, 116, 16);
		panelClase.add(etiquetaDadoDanio);

		spinnerDaño = new JSpinner();
		spinnerDaño.setBounds(170, 140, 63, 20);
		panelClase.add(spinnerDaño);

		botonGuardarClase = new JButton(et.getString("boton.guardarClase"));
		botonGuardarClase.setBounds(135, 195, 153, 21);
		panelClase.add(botonGuardarClase);

		// Panel RAZA
		JPanel panelRaza = new JPanel();
		panelRaza.setLayout(null);
		panelPestanas.addTab(et.getString("pestana.raza"), null, panelRaza, null);

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

		comboBoxTamaño = new JComboBox();
		comboBoxTamaño.setBounds(170, 129, 231, 21);
		comboBoxTamaño.addItem("Pequeño");
		comboBoxTamaño.addItem("Mediano");
		comboBoxTamaño.addItem("Grande");
		comboBoxTamaño.addItem("Enorme");
		panelRaza.add(comboBoxTamaño);

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
		botonGuardarClase.addActionListener(manejador);
		botonGuardarRaza.addActionListener(manejador);
	}

	private class ManejadorBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(botonGuardarClase)) {
				CrearClase();
			}
			if (e.getSource().equals(botonGuardarRaza)) {
				CrearRaza();
			}
		}
	}

	public void CrearClase() {
		try {
			OClase nuevaClase = new OClase();
			nuevaClase.setNombreClase(campoClase.getText());
			nuevaClase.setDescripcionClase(campoDescripcionClase.getText());
			nuevaClase.setTipoClase((String) comboBoxTipoClase.getSelectedItem());
			nuevaClase.setDadoDaño((Integer) spinnerDaño.getValue());

			new CClase().registrarClase(nuevaClase);
			JOptionPane.showMessageDialog(null, et.getString("mensaje.exito.clase"));
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, et.getString("mensaje.error.clase"), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void CrearRaza() {
		try {
			ORaza nuevaRaza = new ORaza();
			nuevaRaza.setNombreRaza(campoRaza.getText());
			nuevaRaza.setDescripcionRaza(campoDescripcionRaza.getText());
			nuevaRaza.setTamañoRaza((String) comboBoxTamaño.getSelectedItem());
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
