package vistas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controladores.CClase;
import controladores.CSubclase;
import modelos.OSubclase;

/**
 * Clase crear clases. Maneja la creacion de clases y razas y su insercion en la
 * base de datos
 */
public class CrearSubclases extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelContenido;
	private JTextField textDescripcion;
	private JTextField textNombre;
	private JButton btnRegistrar;
	private JComboBox comboBoxClase;
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
	public CrearSubclases(Frame parent, boolean modal, Locale Idioma, Integer IdSubclase) {
		super(parent, modal);
		et = ResourceBundle.getBundle("properties/dic", Idioma);
		setTitle(et.getString("crearClases"));

		System.out.println(IdSubclase);

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

		JLabel etiquetaNombre = new JLabel(et.getString("nombreSubclase"));
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

		JLabel etiquetaClase = new JLabel(et.getString("Clase"));
		etiquetaClase.setBounds(10, 105, 116, 16);
		panelClase.add(etiquetaClase);

		comboBoxClase = new JComboBox();
		comboBoxClase.setBounds(170, 103, 231, 21);
		panelClase.add(comboBoxClase);

		btnRegistrar = new JButton(et.getString("guardar"));
		btnRegistrar.setBounds(135, 180, 120, 20);
		panelClase.add(btnRegistrar);

		btnEditar = new JButton(et.getString("guardar"));
		btnEditar.setBounds(265, 180, 120, 20);
		panelClase.add(btnEditar);

		btnEliminar = new JButton(et.getString("Eliminar"));
		btnEliminar.setBounds(10, 180, 120, 20); // Ajusta la posición según necesites
		panelClase.add(btnEliminar);

		ManejadorBoton manejador = new ManejadorBoton();
		// botonGuardarRaza.addActionListener(manejador);

		btnRegistrar.addActionListener(manejador);
		btnEditar.addActionListener(manejador);
		btnEliminar.addActionListener(manejador);

		cargarClasesEnComboBox();

		seleccionarModo(IdSubclase);
	}

	/**
	 * Crear la clase ManejadorBoton implementando ActionListener para llevar
	 * control de los botones Controla los eventos al precionar cada boton
	 */
	private class ManejadorBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnRegistrar)) {
				RegistrarSubclase();
			}
			// Si el origen del evento es btnBorrarClase, se ejecuta borrarClase
			if (e.getSource() == btnEliminar) {
				eliminarSubclase();
			}
			if (e.getSource() == btnEditar) {
				editarSubclase();
			}
			/*
			 * if (e.getSource().equals(botonGuardarRaza)) { CrearRaza(); }
			 */
		}
	}

	/**
	 * Metodo CrearSubclase() Obtiene los datos de clase ingresados por el usuario y
	 * los ingresa a la Clases de la base de datos No requiere parametros ni retorna
	 * valores de salida
	 */
	public void RegistrarSubclase() {
		if (!validarCampos()) {
			return;
		}

		OSubclase nuevaSublase = new OSubclase();
		nuevaSublase.setNombre(textNombre.getText());
		nuevaSublase.setDescripcion(textDescripcion.getText());
		String nombreClase = comboBoxClase.getSelectedItem().toString();
		nuevaSublase.setId_Clase(CClase.obtenerIdClasePorNombre(nombreClase));

		new CSubclase().registrarSubclase(nuevaSublase);

	}

	/**
	 * Metodo eliminarClase Implemetado para eliminar de la base de datos la clase
	 * seleccionada Implementa el metodo del mismo nombre en el controlador CClase
	 */
	private void eliminarSubclase() {
		try {
			String nombre = textNombre.getText();
			if (nombre == null) {
				JOptionPane.showMessageDialog(this, "Seleccione una subclase para borrar.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(this,
					"¿Está seguro de que desea borrar la subclase " + nombre + "?", "Confirmar",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				new CSubclase().borrarSubclase(CSubclase.obtenerIdSubclasePorNombre(nombre)); // Llamamos al método del
																								// controlador

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
	private void editarSubclase() {
		try {
			// Obtener el nombre de la clase seleccionada
			String nombre = textNombre.getText();
			if (nombre == null)
				return;

			// Buscar la clase por nombre
			OSubclase subclase = CSubclase.buscarSubclasePorId(CSubclase.obtenerIdSubclasePorNombre(nombre));
			if (subclase != null) {
				// Establecer los nuevos valores
				subclase.setDescripcion(textDescripcion.getText());
				subclase.setId_Clase(CClase.obtenerIdClasePorNombre(comboBoxClase.getSelectedItem().toString()));

				// Actualizar la clase en la base de datos
				CSubclase.actualizarSubclase(subclase);
				JOptionPane.showMessageDialog(this, "Sublase actualizada correctamente.");

			} else {
				JOptionPane.showMessageDialog(this, "Sublase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al actualizar sublase", "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo validarCampos Comprueba que todos los campos requeridos esten llenos.
	 * Si algun campo esta vacio envia un mensaje e interrumpe la ejecucion
	 * 
	 * @return Si los campos estan llenos regresa true, en caso contrario regresa
	 *         false
	 */
	public boolean validarCampos() {
		boolean completo = true;
		// Validación de campos vacíos
		if (textNombre.getText().isEmpty() || textNombre.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "El nombre de subclase no puede estar vacío", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false; // No continuar con la ejecución si el campo está vacío
		}
		if (textNombre.getText().length() > 20) {
			JOptionPane.showMessageDialog(null, "El nombre de subclase es demasiado largo. Maximo 30 caracteres",
					"Error", JOptionPane.ERROR_MESSAGE);
			return false; // No continuar con la ejecución si el campo está vacío
		}

		if (textDescripcion.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "La descripcion de subclase no puede estar vacia", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false; // No continuar con la ejecución si el campo está vacío
		}
		if (comboBoxClase.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una clase", "Error", JOptionPane.ERROR_MESSAGE);
			return false; // No continuar con la ejecución si el campo está vacío
		}
		return true;

	}

	/**
	 * Metodo SeleccionarModo Habilita o desabilita los botones de registrar, editar
	 * y eliminar, dependiendo del id ingresado Si el idSeleccionado es 0, es modo
	 * registrar, y se desabilitan editar y eliminar En caso contrario se permitira
	 * editar y eliminar, pero no guardar registros nuevos
	 * 
	 * @param idSeleccionado
	 */
	private void seleccionarModo(int idSeleccionado) {
		// TODO Auto-generated method stub
		boolean nuevoSubclase = idSeleccionado == 0;
		textNombre.setEnabled(nuevoSubclase);
		btnEditar.setEnabled(!nuevoSubclase);
		btnEditar.setVisible(!nuevoSubclase);
		btnEliminar.setEnabled(!nuevoSubclase);
		btnEliminar.setVisible(!nuevoSubclase);
		btnRegistrar.setEnabled(nuevoSubclase);
		btnRegistrar.setVisible(nuevoSubclase);

		if (!nuevoSubclase) {
			cargarDatosSubclase(idSeleccionado);
		}
	}

	/**
	 * Metodo cargarClaseSeleccionada Carga los datos de la clase seleccionado Llena
	 * los campos de los componentes correspondientes, con los datos de clase
	 * obtenidos de la base de datos
	 */
	private void cargarDatosSubclase(int idClase) {
		OSubclase subclase = CSubclase.buscarSubclasePorId(idClase);
		if (subclase != null) {
			textNombre.setText(subclase.getNombre());
			textDescripcion.setText(subclase.getDescripcion());
			comboBoxClase.setSelectedItem(new CClase().obtenerNombreClasePorId(subclase.getId_Clase()));
		}
	}

	/**
	 * Metodo cargarClasesEnComboBox Carga los nombres de la tabla Clases de la base
	 * de datos, y los enlista en un comboBox
	 */
	private void cargarClasesEnComboBox() {
		CClase cClase = new CClase();
		ResultSet rs = cClase.obtenerNombresClases();

		try {
			comboBoxClase.removeAllItems();
			comboBoxClase.addItem("Clase");
			while (rs.next()) {
				comboBoxClase.addItem(rs.getString("Nombre"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar clases en el ComboBox", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
