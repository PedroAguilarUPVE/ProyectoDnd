package vistas;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controladores.CClase;
import controladores.CRaza;
import modelos.OClase;
import modelos.ORaza;

public class VerDatos1 extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tablaClases;
	private JScrollPane scrollClase;

	private JComboBox<String> comboClasesEditar, comboClasesEliminar;
	private JComboBox<String> comboRazasEditar, comboRazasEliminar;
	private List<OClase> listaClases;
	private List<ORaza> listaRazas;

	public VerDatos1(Frame parent, boolean modal, Locale Idioma) {
	    super(parent, modal);
	    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 714, 400);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	    tabbedPane.setBounds(10, 10, 680, 320);
	    contentPane.add(tabbedPane);

	    // Ver Clases (pestaña con tabla para ver clases)
	    JScrollPane scrollClase = new JScrollPane();
	    tabbedPane.addTab("Ver Clase", null, scrollClase, null);

	    tablaClases = new JTable();
	    scrollClase.setViewportView(tablaClases);
	    try {
			cargarTablaClases();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Crear Clase (pestaña con formulario para crear clase)
	    JPanel panelClase = new JPanel();
	    panelClase.setLayout(null);
	    panelClase.setBorder(new EmptyBorder(5, 5, 5, 5));
	    tabbedPane.addTab("Crear Clase", null, panelClase, null);

	    JLabel NLnombreClase = new JLabel("Nombre de Clase");
	    NLnombreClase.setBounds(10, 19, 116, 16);
	    panelClase.add(NLnombreClase);

	    textField = new JTextField();
	    textField.setBounds(170, 10, 231, 30);
	    panelClase.add(textField);
	    textField.setColumns(10);

	    JLabel NLdescripcionClase = new JLabel("Descripción");
	    NLdescripcionClase.setBounds(10, 76, 116, 16);
	    panelClase.add(NLdescripcionClase);

	    textField_1 = new JTextField();
	    textField_1.setBounds(170, 66, 231, 35);
	    panelClase.add(textField_1);
	    textField_1.setColumns(10);

	    JLabel NLtipoClase = new JLabel("Tipo");
	    NLtipoClase.setBounds(10, 131, 116, 16);
	    panelClase.add(NLtipoClase);

	    JComboBox<String> comboTipoClase = new JComboBox<>();
	    comboTipoClase.setBounds(170, 126, 231, 21);
	    panelClase.add(comboTipoClase);

	    JLabel NLdadoDaño = new JLabel("Dado de Daño");
	    NLdadoDaño.setBounds(10, 167, 116, 16);
	    panelClase.add(NLdadoDaño);

	    JTextField textField_2 = new JTextField();
	    textField_2.setBounds(170, 166, 231, 20);
	    panelClase.add(textField_2);
	    textField_2.setColumns(10);

	    JButton BTNGuardarClase = new JButton("Guardar Clase");
	    BTNGuardarClase.setBounds(135, 220, 153, 21);
	    panelClase.add(BTNGuardarClase);

	    // Ver Razas (pestaña con tabla para ver razas)
	    JScrollPane scrollRaza = new JScrollPane();
	    tabbedPane.addTab("Ver Razas", null, scrollRaza, null);

	    JTable tablaRazas = new JTable();
	    scrollRaza.setViewportView(tablaRazas);
	    try {
			cargarTablaRazas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Crear Raza
	    JPanel panelRaza = new JPanel();
	    panelRaza.setLayout(null);
	    panelRaza.setBorder(new EmptyBorder(5, 5, 5, 5));
	    tabbedPane.addTab("Crear Raza", null, panelRaza, null);

	    JLabel NLnombreRaza = new JLabel("Nombre de Raza");
	    NLnombreRaza.setBounds(10, 19, 116, 16);
	    panelRaza.add(NLnombreRaza);

	    textField_3 = new JTextField();
	    textField_3.setBounds(170, 10, 231, 30);
	    panelRaza.add(textField_3);
	    textField_3.setColumns(10);

	    JLabel NLdescripcionRaza = new JLabel("Descripción");
	    NLdescripcionRaza.setBounds(10, 76, 116, 16);
	    panelRaza.add(NLdescripcionRaza);

	    textField_2 = new JTextField();
	    textField_2.setBounds(170, 66, 231, 35);
	    panelRaza.add(textField_2);
	    textField_2.setColumns(10);

	    JLabel NLtamañoRaza = new JLabel("Tamaño");
	    NLtamañoRaza.setBounds(10, 131, 116, 16);
	    panelRaza.add(NLtamañoRaza);

	    JComboBox<String> comboTamañoRaza = new JComboBox<>();
	    comboTamañoRaza.setBounds(170, 126, 231, 21);
	    panelRaza.add(comboTamañoRaza);

	    JLabel NLvelocidad = new JLabel("Velocidad");
	    NLvelocidad.setBounds(10, 167, 116, 16);
	    panelRaza.add(NLvelocidad);

	    JSpinner spinnerVelocidad = new JSpinner();
	    spinnerVelocidad.setBounds(170, 166, 63, 20);
	    panelRaza.add(spinnerVelocidad);

	    JLabel NLFuerza = new JLabel("Fuerza");
	    NLFuerza.setBounds(10, 200, 116, 16);
	    panelRaza.add(NLFuerza);

	    JSpinner spinnerFuerza = new JSpinner();
	    spinnerFuerza.setBounds(170, 200, 63, 20);
	    panelRaza.add(spinnerFuerza);

	    JLabel NLDestreza = new JLabel("Destreza");
	    NLDestreza.setBounds(10, 230, 116, 16);
	    panelRaza.add(NLDestreza);

	    JSpinner spinnerDestreza = new JSpinner();
	    spinnerDestreza.setBounds(170, 230, 63, 20);
	    panelRaza.add(spinnerDestreza);

	    JLabel NLConstitucion = new JLabel("Constitución");
	    NLConstitucion.setBounds(10, 260, 116, 16);
	    panelRaza.add(NLConstitucion);

	    JSpinner spinnerConstitucion = new JSpinner();
	    spinnerConstitucion.setBounds(170, 260, 63, 20);
	    panelRaza.add(spinnerConstitucion);

	    JLabel NLInteligencia = new JLabel("Inteligencia");
	    NLInteligencia.setBounds(10, 290, 116, 16);
	    panelRaza.add(NLInteligencia);

	    JSpinner spinnerInteligencia = new JSpinner();
	    spinnerInteligencia.setBounds(170, 290, 63, 20);
	    panelRaza.add(spinnerInteligencia);

	    JLabel NLSabiduria = new JLabel("Sabiduría");
	    NLSabiduria.setBounds(250, 200, 116, 16);
	    panelRaza.add(NLSabiduria);

	    JSpinner spinnerSabiduria = new JSpinner();
	    spinnerSabiduria.setBounds(320, 200, 63, 20);
	    panelRaza.add(spinnerSabiduria);

	    JLabel NLCarisma = new JLabel("Carisma");
	    NLCarisma.setBounds(250, 230, 116, 16);
	    panelRaza.add(NLCarisma);

	    JSpinner spinnerCarisma = new JSpinner();
	    spinnerCarisma.setBounds(320, 230, 63, 20);
	    panelRaza.add(spinnerCarisma);

	    JButton BTNGuardarRaza = new JButton("Guardar Raza");
	    BTNGuardarRaza.setBounds(135, 320, 153, 21);
	    panelRaza.add(BTNGuardarRaza);

	    // Editar Raza
	    JPanel panelEditarRaza = new JPanel();
	    panelEditarRaza.setLayout(null);
	    tabbedPane.addTab("Editar Raza", null, panelEditarRaza, null);

	    comboRazasEditar = new JComboBox<>();
	    comboRazasEditar.setBounds(20, 20, 200, 25);
	    panelEditarRaza.add(comboRazasEditar);

	    JTextField txtNuevoNombreRaza = new JTextField();
	    txtNuevoNombreRaza.setBounds(20, 60, 200, 25);
	    panelEditarRaza.add(txtNuevoNombreRaza);

	    JButton btnActualizarRaza = new JButton("Actualizar");
	    btnActualizarRaza.setBounds(20, 100, 120, 25);
	    panelEditarRaza.add(btnActualizarRaza);

	    // Eliminar Raza
	    JPanel panelEliminarRaza = new JPanel();
	    panelEliminarRaza.setLayout(null);
	    tabbedPane.addTab("Eliminar Raza", null, panelEliminarRaza, null);

	    comboRazasEliminar = new JComboBox<>();
	    comboRazasEliminar.setBounds(20, 20, 200, 25);
	    panelEliminarRaza.add(comboRazasEliminar);

	    JButton btnEliminarRaza = new JButton("Eliminar");
	    btnEliminarRaza.setBounds(20, 60, 120, 25);
	    panelEliminarRaza.add(btnEliminarRaza);

	    // Cargar razas en los comboBox de editar y eliminar
	    cargarCombos();
	}

	private void cargarTablaClases() throws SQLException {
		// Cargar las clases en la tabla
		CClase cClase = new CClase();
		ResultSet rsClases = cClase.obtenerNombresClases(); 

		// Obtener nombres de las columnas (por ejemplo, "Nombre", "Descripción", "Tipo")
		String[] columnNames = { "Nombre", "Descripción", "Tipo" };
		// Definir el modelo de la tabla con los datos de las clases
		tablaClases.setModel(new javax.swing.table.DefaultTableModel(
			// Aquí pones los datos de las clases que recuperes desde la base de datos
			new Object[][] { }, columnNames
		));
	}

	private void cargarTablaRazas() throws SQLException {
		// Cargar las razas en la tabla
		CRaza cRaza = new CRaza();
		ResultSet rsRazas = cRaza.obtenerNombresRazas(); 

		// Obtener nombres de las columnas (por ejemplo, "Nombre", "Descripción", "Tamaño")
		String[] columnNames = { "Nombre", "Descripción", "Tamaño" };
		// Definir el modelo de la tabla con los datos de las razas
		// Aquí pones los datos de las razas que recuperes desde la base de datos
	}

	private void cargarCombos() {
		// Cargar razas en los comboBox de editar y eliminar
		CRaza cRaza = new CRaza();
		ResultSet rsRazas = cRaza.obtenerNombresRazas(); // Usamos el método obtenerNombresRazas (similar a lo de las clases)

		try {
			comboRazasEditar.removeAllItems();
			comboRazasEliminar.removeAllItems();

			while (rsRazas.next()) {
				String nombreRaza = rsRazas.getString("NombreRaza");
				comboRazasEditar.addItem(nombreRaza);
				comboRazasEliminar.addItem(nombreRaza);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar razas", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
