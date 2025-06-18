package vistas;

import java.awt.EventQueue;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class Empleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblId;
	private JScrollPane ScrPaneTabla;
	private JComboBox cBPuestos;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JDateChooser dateChooser;
	private JLabel LblFechaIng;
	private JLabel LblNombre;
	// declaramos las Variables para la Internacionalización
	private static Locale Idioma;
	private static ResourceBundle et;

	private DefaultTableModel ModelDatosTabla;
	private JTable TablaDatos;
	private JLabel lblPuestos;
	private JLabel lblMunicipio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleados frame = new Empleados();
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
	public Empleados() {

		// inicializamos las variables de internacionalización
		Idioma = Locale.getDefault();// se selecciona el Idioma de el sistema operativo para seleccionar
		 Idioma = new Locale("en", "US");
		// Idioma = new Locale("es", "MX");

		
		et = ResourceBundle.getBundle("properties/dic", Idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		LblNombre = new JLabel("Nombre Empleado   ");
		LblNombre.setBounds(10, 49, 149, 14);
		contentPane.add(LblNombre);

		textField = new JTextField();
		textField.setBounds(121, 46, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblId = new JLabel(et.getString("idempleado"));
		lblId.setBounds(10, 11, 102, 14);
		contentPane.add(lblId);

		textField_1 = new JTextField();
		textField_1.setBounds(121, 8, 149, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		cBPuestos = new JComboBox();
		cBPuestos.setBounds(121, 84, 149, 22);
		contentPane.add(cBPuestos);

		lblPuestos = new JLabel(et.getString("telefono"));
		lblPuestos.setBounds(10, 87, 89, 14);
		contentPane.add(lblPuestos);

		btnGuardar = new JButton(et.getString("guardar"));
		btnGuardar.setBounds(41, 227, 89, 23);
		contentPane.add(btnGuardar);

		btnBorrar = new JButton(et.getString("borrar"));
		btnBorrar.setBounds(171, 227, 89, 23);
		contentPane.add(btnBorrar);

		ScrPaneTabla = new JScrollPane();
		ScrPaneTabla.setBounds(10, 143, 414, 73);
		contentPane.add(ScrPaneTabla);

		dateChooser = new JDateChooser();
		dateChooser.setLocale(Idioma);
		dateChooser.setBounds(328, 49, 70, 20);
		contentPane.add(dateChooser);

		LblFechaIng = new JLabel("Fecha de Ingreso:");
		LblFechaIng.setBounds(322, 11, 102, 14);
		contentPane.add(LblFechaIng);

		// inicializamos las variables para la tabla y su contenedor

		ModelDatosTabla = new DefaultTableModel();// definimos el objeto tableModel
		TablaDatos = new JTable();// creamos la instancia de la tabla
		TablaDatos.setModel(ModelDatosTabla);
		ModelDatosTabla.addColumn(et.getString("idempleado"));
		ModelDatosTabla.addColumn(et.getString("nombre"));
		ModelDatosTabla.addColumn(et.getString("puesto"));
		ModelDatosTabla.addColumn(et.getString("fechaIn"));

		TablaDatos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TablaDatos.getTableHeader().setReorderingAllowed(false);

		ScrPaneTabla.setViewportView(TablaDatos);

		lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setBounds(10, 120, 89, 14);
		contentPane.add(lblMunicipio);

		cBPuestos = new JComboBox();
		cBPuestos.setBounds(121, 117, 149, 22);
		contentPane.add(cBPuestos);

		btnBorrar = new JButton(et.getString("cerrar"));
		btnBorrar.setBounds(301, 227, 89, 23);
		contentPane.add(btnBorrar);

	}
}
