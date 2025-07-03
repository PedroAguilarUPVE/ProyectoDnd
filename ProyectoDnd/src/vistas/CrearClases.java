package vistas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractButton;
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
 * Clase crear clases. Maneja la creacion de clases y razas y su insercion en la
 * base de datos
 */
public class CrearClases extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelContenido;
	private JTextField textDescripcion;
	private JTextField textNombre;
	private JButton btnRegistrar;
	private JComboBox comboBoxTipo;
	private JSpinner spinnerDano;

	private ResourceBundle et;
	private JButton btnEditar;
	private JButton btnEliminar;

	/**
	 * Constructor de la ventana de creacion de clases y razas Se crea como hija de
	 * la ventana menu
	 * 
	 * @param parent  Clase Frame Indica el componente padre de de la ventana
	 *                CrearClases
	 * @param modal   Clase boolean Indica el modo de sobreposicion de la ventana
	 *                hija
	 * @param Idioma  Clase Locale Hereda el parametro tipo Locale de la clase
	 *                padre, para la seleccion de idioma
	 * @param integer
	 */
	public CrearClases(Frame parent, boolean modal, Locale Idioma, Integer IdClase) {
		super(parent, modal);
		et = ResourceBundle.getBundle("properties/dic", Idioma);
		setTitle(et.getString("crearClases"));

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		panelContenido = new JPanel();
		panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelContenido);
		panelContenido.setLayout(null);

		// Panel CLASE
		JPanel panelClase = new JPanel();
		panelClase.setBounds(10, 10, 410, 250);
		panelContenido.add(panelClase);
		panelClase.setLayout(null);

		JLabel etiquetaNombre = new JLabel(et.getString("nombreClase"));
		etiquetaNombre.setBounds(10, 19, 140, 16);
		panelClase.add(etiquetaNombre);

		textNombre = new JTextField();
		textNombre.setBounds(170, 10, 231, 30);
		panelClase.add(textNombre);

		JLabel etiquetaDescripcionClase = new JLabel(et.getString("descripcionClase"));
		etiquetaDescripcionClase.setBounds(10, 50, 150, 16);
		panelClase.add(etiquetaDescripcionClase);

		textDescripcion = new JTextField();
		textDescripcion.setBounds(170, 50, 231, 35);
		panelClase.add(textDescripcion);

		JLabel etiquetaTipoClase = new JLabel(et.getString("tipoClase"));
		etiquetaTipoClase.setBounds(10, 105, 116, 16);
		panelClase.add(etiquetaTipoClase);


		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(170, 103, 231, 21);
		comboBoxTipo.addItem("Marcial");
		comboBoxTipo.addItem("Magica");
		comboBoxTipo.addItem("Mixta");
		panelClase.add(comboBoxTipo);

		JLabel etiquetaDadoDanio = new JLabel(et.getString("dadoDano"));
		etiquetaDadoDanio.setBounds(10, 141, 116, 16);
		panelClase.add(etiquetaDadoDanio);

		spinnerDano = new JSpinner();
		spinnerDano.setBounds(170, 140, 63, 20);
		panelClase.add(spinnerDano);


		btnRegistrar = new JButton(et.getString("guardarClase"));
		btnRegistrar.setBounds(135, 180, 120, 20);
		panelClase.add(btnRegistrar);

		btnEditar = new JButton(et.getString("guardarClase"));
		btnEditar.setBounds(265, 180, 120, 20);
		panelClase.add(btnEditar);

		btnEliminar = new JButton(et.getString("BorrarClase"));
		btnEliminar.setBounds(10, 180, 120, 20); // Ajusta la posición según necesites
		panelClase.add(btnEliminar);
		
		ManejadorBoton manejador = new ManejadorBoton();
		// botonGuardarRaza.addActionListener(manejador);		

		btnRegistrar.addActionListener(manejador);
		btnEditar.addActionListener(manejador);
		btnEliminar.addActionListener(manejador);
		
		seleccionarModo(IdClase);
	}

	/**
	 * Crear la clase ManejadorBoton implementando ActionListener para llevar
	 * control de los botones Controla los eventos al precionar cada boton
	 */
	private class ManejadorBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnRegistrar)) {
				CrearClase();
			}
			// Si el origen del evento es btnBorrarClase, se ejecuta borrarClase
			if (e.getSource() == btnEliminar) {
				eliminarClase();
			}
			if (e.getSource() == btnEditar) {
				editarClase();
			}
			/*
			 * if (e.getSource().equals(botonGuardarRaza)) { CrearRaza(); }
			 */
		}
	}

	/**
	 * Metodo CrearClase() Obtiene los datos de clase ingresados por el usuario y
	 * los ingresa a la Clases de la base de datos No requiere parametros ni retorna
	 * valores de salida
	 */
	public void CrearClase() {
		try {
			OClase nuevaClase = new OClase();
			nuevaClase.setNombre(textNombre.getText());
			nuevaClase.setDescripcion(textDescripcion.getText());
			nuevaClase.setTipo((String) comboBoxTipo.getSelectedItem());
			nuevaClase.setDadoDano((Integer) spinnerDano.getValue());

			new CClase().registrarClase(nuevaClase);
			JOptionPane.showMessageDialog(null, et.getString("mensaje.exito.clase"));
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, et.getString("mensaje.error.clase"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo eliminarClase Implemetado para eliminar de la base de datos la clase
	 * seleccionada Implementa el metodo del mismo nombre en el controlador CClase
	 */
	private void eliminarClase() {
		try {
			String nombre = textNombre.getText();
			if (nombre == null) {
				JOptionPane.showMessageDialog(this, "Seleccione una clase para borrar.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(this,
					"¿Está seguro de que desea borrar la clase " + nombre + "?", "Confirmar",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				new CClase().borrarClase(nombre); // Llamamos al método del controlador

			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al borrar la clase", "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo actualizarClase actualiza los datos de la clase seleccionada, dentro
	 * de la base de datos
	 */
	private void editarClase() {
		try {
			// Obtener el nombre de la clase seleccionada
			String nombre = textNombre.getText();
			if (nombre == null)
				return;

			// Buscar la clase por nombre
			OClase clase = new CClase().buscarClasePorNombre(nombre);
			if (clase != null) {
				// Establecer los nuevos valores
				clase.setDescripcion(textDescripcion.getText());
				clase.setTipo((String) comboBoxTipo.getSelectedItem());
				clase.setDadoDano((int) spinnerDano.getValue());

				// Actualizar la clase en la base de datos
				CClase.actualizarClase(clase);
				JOptionPane.showMessageDialog(this, "Clase actualizada correctamente.");

			} else {
				JOptionPane.showMessageDialog(this, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al actualizar clase", "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}


	/**
	 * Metodo SeleccionarModo Habilita o desabilita los botones de registrar, editar y eliminar, dependiendo del id ingresado
	 * Si el idSeleccionado es 0, es modo registrar, y se desabilitan editar y eliminar
	 * En caso contrario se permitira editar y eliminar, pero no guardar registros nuevos
	 * @param idSeleccionado 
	 */
	private void seleccionarModo(int idSeleccionado) {
		// TODO Auto-generated method stub
		boolean nuevoClase = idSeleccionado == 0;
		textNombre.setEnabled(nuevoClase);
		btnEditar.setEnabled(!nuevoClase);
		btnEditar.setVisible(!nuevoClase);
		btnEliminar.setEnabled(!nuevoClase);
		btnEliminar.setVisible(!nuevoClase);
		btnRegistrar.setEnabled(nuevoClase);
		btnRegistrar.setVisible(nuevoClase);

		if (!nuevoClase) {
			cargarDatosClase(idSeleccionado);
		}
	}

	/**
	 * Metodo cargarClaseSeleccionada Carga los datos de la clase seleccionado Llena
	 * los campos de los componentes correspondientes, con los datos de clase
	 * obtenidos de la base de datos
	 */
	private void cargarDatosClase(int idClase) {
		OClase clase = CClase.obtenerClasePorId(idClase);
		if (clase != null) {
			textNombre.setText(clase.getNombre());
			textDescripcion.setText(clase.getDescripcion());
			comboBoxTipo.setSelectedItem(clase.getTipo());
			spinnerDano.setValue(clase.getDadoDano());

		}
	}

}
