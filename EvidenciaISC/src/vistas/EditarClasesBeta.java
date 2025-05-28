package vistas;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.CClase;
import controladores.CPersonaje;
import controladores.CRaza;
import controladores.CSubclase;
import modelos.OClase;
import modelos.OPersonaje;
import modelos.ORaza;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EditarClasesBeta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelRazas;
	private JTextField textDescripcionRaza;
	private JTextField textDescipcionClase;
	private JTextField textClase;
	private JTextField textRaza;
	private JTable tableClases;
	private JScrollPane scrollClase;

	private JComboBox<String> comboClasesEditar, comboClasesEliminar;
	private JComboBox<String> comboRazasEditar, comboRazasEliminar;
	private List<OClase> listaClases;
	private List<ORaza> listaRazas;
	private JTable tableRazas;
	private JScrollPane scrollRaza;
	private JButton btnGuardarClase;
	private JButton btnGuardarRaza;
	private JComboBox comboBoxTipoClase;
	/**
	 * Launch the application.

	 */
	private JOptionPane spinnerDaño;
	private JComboBox comboBoxTamaño;
	private JSpinner spinnerVelocidad;

	/**
	 * Create the frame.
	 */
	
	//Crear Dialog para ver editar y eliminar los datos de razas y clases
	public EditarClasesBeta(Frame parent, boolean modal, Locale Idioma) {
		super(parent, modal);// se inicializa el constructor super
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 600, 400);
		panelRazas = new JPanel();
		panelRazas.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelRazas);
		panelRazas.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 570, 320);
		panelRazas.add(tabbedPane);
		
		scrollClase = new JScrollPane();
		tabbedPane.addTab("Ayuda", null, scrollClase, null);
		
		scrollRaza = new JScrollPane();
		tabbedPane.addTab("Ver Razas", null, scrollRaza, null);
		
		tableRazas = new JTable();
		scrollRaza.setColumnHeaderView(tableRazas);
		
		
		JPanel panelClase = new JPanel();
		panelClase.setLayout(null);
		panelClase.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Crear Clase", null, panelClase, null);
		
		btnGuardarClase = new JButton("Guardar clase");
		btnGuardarClase.setBounds(135, 195, 153, 21);
		panelClase.add(btnGuardarClase);
		
		JSpinner spinnerDaño = new JSpinner();
		spinnerDaño.setBounds(170, 140, 63, 20);
		panelClase.add(spinnerDaño);
		
		comboBoxTipoClase = new JComboBox();
		comboBoxTipoClase.setBounds(182, 109, 231, 21);
		panelClase.add(comboBoxTipoClase);
		
		textDescipcionClase = new JTextField();
		textDescipcionClase.setColumns(10);
		textDescipcionClase.setBounds(170, 50, 231, 35);
		panelClase.add(textDescipcionClase);
		
		JLabel labelClase = new JLabel("nombre_Clase");
		labelClase.setBounds(10, 19, 116, 16);
		panelClase.add(labelClase);
		
		JLabel labelDescripcionClase = new JLabel("descripcion_clase");
		labelDescripcionClase.setBounds(10, 50, 116, 16);
		panelClase.add(labelDescripcionClase);
		
		JLabel labelTipoClase = new JLabel("tipo_Clase");
		labelTipoClase.setBounds(10, 105, 116, 16);
		panelClase.add(labelTipoClase);
		
		JLabel labelDaño = new JLabel("tipo_Daño");
		labelDaño.setBounds(10, 141, 116, 16);
		panelClase.add(labelDaño);
		
		textClase = new JTextField();
		textClase.setColumns(10);
		textClase.setBounds(170, 10, 231, 30);
		panelClase.add(textClase);
		
		JPanel panelRaza = new JPanel();
		panelRaza.setLayout(null);
		panelRaza.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Crear Raza", null, panelRaza, null);
		
		JLabel NLnombreRaza = new JLabel("nombre_Raza");
		NLnombreRaza.setBounds(10, 19, 116, 16);
		panelRaza.add(NLnombreRaza);
		
		JLabel labelDescripcionRaza = new JLabel("descripcion_raza");
		labelDescripcionRaza.setBounds(10, 76, 116, 16);
		panelRaza.add(labelDescripcionRaza);
		
		JLabel labelTamañoRaza = new JLabel("tamaño_raza");
		labelTamañoRaza.setBounds(10, 131, 116, 16);
		panelRaza.add(labelTamañoRaza);
		
		JLabel NLvelocidad = new JLabel("velocidad");
		NLvelocidad.setBounds(10, 167, 116, 16);
		panelRaza.add(NLvelocidad);
		
		textDescripcionRaza = new JTextField();
		textDescripcionRaza.setBounds(170, 76, 231, 35);
		panelRaza.add(textDescripcionRaza);
		textDescripcionRaza.setColumns(10);
		
		spinnerVelocidad = new JSpinner();
		spinnerVelocidad.setBounds(170, 166, 63, 20);
		panelRaza.add(spinnerVelocidad);
		
		comboBoxTamaño = new JComboBox();
		comboBoxTamaño.setBounds(170, 129, 231, 21);
		panelRaza.add(comboBoxTamaño);
		
		btnGuardarRaza = new JButton("Guardar Raza");
		btnGuardarRaza.setBounds(135, 195, 153, 21);
		panelRaza.add(btnGuardarRaza);
		
		textRaza = new JTextField();
		textRaza.setColumns(10);
		textRaza.setBounds(170, 10, 231, 30);
		panelRaza.add(textRaza);

		buscarClasesConTableModel();
		buscarRazasConTableModel(); 
		
		ManejadorBoton EscuchadorBoton = new ManejadorBoton();
		btnGuardarClase.addActionListener(EscuchadorBoton);
		btnGuardarRaza.addActionListener(EscuchadorBoton);
		
	}
	
	private class ManejadorBoton implements ActionListener {



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(btnGuardarClase)) {
				CrearClase();
			}
			if (e.getSource().equals(btnGuardarRaza)) {
				
			}
		} // Manejador Botones
	}
	
	public void CrearClase() {
	    try {
	        OClase nuevaClase = new OClase();

	        // Obtener el nombre y descripción desde los campos de texto
	        nuevaClase.setNombreClase(textClase.getText());
	        nuevaClase.setDescripcionClase(textDescipcionClase.getText());

	        // Obtener el tipo de clase desde el combo box
	        String tipoClaseSeleccionado = (String) comboBoxTipoClase.getSelectedItem();
	        nuevaClase.setTipoClase(tipoClaseSeleccionado);

	        // Obtener el dado de daño desde el spinner
	        int dadoDaño = (Integer) spinnerDaño.getValue();
	        nuevaClase.setDadoDaño(dadoDaño);

	        // Guardar la clase usando el controlador
	        new CClase().registrarClase(nuevaClase);

	        JOptionPane.showMessageDialog(null, "Clase registrada correctamente");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al registrar la clase", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void buscarClasesConTableModel() {
		DefaultTableModel model;
		model = new DefaultTableModel();// definimos el objeto tableModel
		tableClases = new JTable();// creamos la instancia de la tabla
		tableClases.setModel(model);
		model.addColumn("Id Clase");
		model.addColumn("Nombre Clase");
		model.addColumn("Descripcion Clase");
		model.addColumn("Tipo Clase");
		model.addColumn("Dado Daño");

		tableClases.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableClases.getTableHeader().setReorderingAllowed(false);

		CClase miClase = new CClase();
		/*
		 * enviamos el objeto TableModel, como mandamos el objeto podemos manipularlo
		 * desde el metodo
		 */
		miClase.buscarClasesConTableModel(model);

		scrollClase.setViewportView(tableClases);

	}
	
	
	private void buscarRazasConTableModel() {
	    DefaultTableModel model;
	    model = new DefaultTableModel(); // Definimos el objeto tableModel
	    tableRazas = new JTable(); // Creamos la instancia de la tabla
	    tableRazas.setModel(model);
	    model.addColumn("Id Raza");
	    model.addColumn("Nombre Raza");
	    model.addColumn("Descripcion Raza");
	    model.addColumn("Tamaño");
	    model.addColumn("Velocidad");

	    tableRazas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    tableRazas.getTableHeader().setReorderingAllowed(false);

	    // Crear objeto de controlador para razas y buscar las razas
	    CRaza miRaza = new CRaza();
	    miRaza.buscarRazasConTableModel(model);

	    scrollRaza.setViewportView(tableRazas);
	}
}
