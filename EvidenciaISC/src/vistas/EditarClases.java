package vistas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.CClase;
import controladores.CRaza;
import modelos.OClase;
import modelos.ORaza;

public class EditarClases extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelRazas;
	private JTextField textDescripcionRaza;
	private JTextField textDescipcionClase;
	private JTextField textClase;
	private JTextField textRaza;
	private JTable tableClases;
	private JTable tableRazas;
	private JScrollPane scrollClase;
	private JScrollPane scrollRaza;
	private JButton btnGuardarClase;
	private JButton btnGuardarRaza;
	private JComboBox<String> comboBoxTipoClase;
	private JComboBox<String> comboBoxTamaño;
	private JSpinner spinnerVelocidad;
	private JSpinner spinnerDaño;

	private JSpinner spinnerFuerza;
	private JSpinner spinnerDestreza;
	private JSpinner spinnerConstitucion;
	private JSpinner spinnerInteligencia;
	private JSpinner spinnerSabiduria;
	private JSpinner spinnerCarisma;

	private JComboBox<String> comboClasesEditar;
	private JComboBox<String> comboRazasEditar;

	private List<OClase> listaClases;
	private List<ORaza> listaRazas;
	private JButton btnBorrarRaza;
	private JButton btnBorrarClase;
	private ResourceBundle et;
	
	public EditarClases(Frame parent, boolean modal, Locale Idioma) {
		super(parent, modal);
		et = ResourceBundle.getBundle("properties/dic", Idioma);

		
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
		tabbedPane.addTab(et.getString("VerClases"), null, scrollClase, null);

		scrollRaza = new JScrollPane();
		tabbedPane.addTab(et.getString("VerRazas"), null, scrollRaza, null);

		tableClases = new JTable();
		scrollClase.setViewportView(tableClases);

		tableRazas = new JTable();
		scrollRaza.setViewportView(tableRazas);

		JPanel panelClase = new JPanel();
		panelClase.setLayout(null);
		tabbedPane.addTab(et.getString("EditarClase"), null, panelClase, null);

		comboClasesEditar = new JComboBox<>();
		comboClasesEditar.setBounds(170, 10, 231, 21);
		panelClase.add(comboClasesEditar);

		textDescipcionClase = new JTextField();
		textDescipcionClase.setBounds(170, 50, 231, 35);
		panelClase.add(textDescipcionClase);
		textDescipcionClase.setColumns(10);

		comboBoxTipoClase = new JComboBox();
		comboBoxTipoClase.setBounds(170, 103, 231, 21);
		comboBoxTipoClase.addItem("Marcial");
		comboBoxTipoClase.addItem("Magica");
		comboBoxTipoClase.addItem("Mixta");
		panelClase.add(comboBoxTipoClase);

		spinnerDaño = new JSpinner();
		spinnerDaño.setBounds(170, 140, 63, 20);
		panelClase.add(spinnerDaño);

		btnGuardarClase = new JButton(et.getString("Guardar"));
		btnGuardarClase.setBounds(170, 180, 153, 21);
		panelClase.add(btnGuardarClase);

		panelClase.add(new JLabel(et.getString("Clase"))).setBounds(10, 10, 116, 16);
		panelClase.add(new JLabel(et.getString("Descripcion"))).setBounds(10, 50, 116, 16);
		panelClase.add(new JLabel(et.getString("Tipo"))).setBounds(10, 100, 116, 16);
		panelClase.add(new JLabel(et.getString("DadoDaño"))).setBounds(10, 140, 116, 16);

		JPanel panelRaza = new JPanel();
		panelRaza.setLayout(null);
		tabbedPane.addTab(et.getString("EditarRaza"), null, panelRaza, null);

		comboRazasEditar = new JComboBox<>();
		comboRazasEditar.setBounds(170, 10, 231, 21);
		panelRaza.add(comboRazasEditar);

		textDescripcionRaza = new JTextField();
		textDescripcionRaza.setBounds(170, 50, 231, 35);
		panelRaza.add(textDescripcionRaza);
		textDescripcionRaza.setColumns(10);

		comboBoxTamaño = new JComboBox();
		comboBoxTamaño.setBounds(170, 105, 231, 21);
		comboBoxTamaño.addItem("Pequeño");
		comboBoxTamaño.addItem("Mediano");
		comboBoxTamaño.addItem("Grande");
		comboBoxTamaño.addItem("Enorme");
		panelRaza.add(comboBoxTamaño);

		spinnerVelocidad = new JSpinner();
		spinnerVelocidad.setBounds(170, 140, 63, 20);
		panelRaza.add(spinnerVelocidad);

		btnGuardarRaza = new JButton(et.getString("GuardarRaza"));
		btnGuardarRaza.setBounds(197, 232, 153, 21);
		panelRaza.add(btnGuardarRaza);

		JLabel lblFuerza = new JLabel(et.getString("Fuerza"));
		lblFuerza.setBounds(10, 170, 80, 16);
		panelRaza.add(lblFuerza);

		spinnerFuerza = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerFuerza.setBounds(80, 170, 50, 20);
		panelRaza.add(spinnerFuerza);

		JLabel lblDestreza = new JLabel(et.getString("Destreza"));
		lblDestreza.setBounds(140, 170, 80, 16);
		panelRaza.add(lblDestreza);

		spinnerDestreza = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerDestreza.setBounds(210, 170, 50, 20);
		panelRaza.add(spinnerDestreza);

		JLabel lblConstitucion = new JLabel(et.getString("Constitucion"));
		lblConstitucion.setBounds(270, 170, 80, 16);
		panelRaza.add(lblConstitucion);

		spinnerConstitucion = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerConstitucion.setBounds(360, 170, 50, 20);
		panelRaza.add(spinnerConstitucion);

		JLabel lblInteligencia = new JLabel(et.getString("Inteligencia"));
		lblInteligencia.setBounds(10, 195, 80, 16);
		panelRaza.add(lblInteligencia);

		spinnerInteligencia = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerInteligencia.setBounds(80, 195, 50, 20);
		panelRaza.add(spinnerInteligencia);

		JLabel lblSabiduria = new JLabel(et.getString("Sabiduria"));
		lblSabiduria.setBounds(140, 195, 80, 16);
		panelRaza.add(lblSabiduria);

		spinnerSabiduria = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerSabiduria.setBounds(210, 195, 50, 20);
		panelRaza.add(spinnerSabiduria);

		JLabel lblCarisma = new JLabel(et.getString("Carisma"));
		lblCarisma.setBounds(270, 195, 80, 16);
		panelRaza.add(lblCarisma);

		spinnerCarisma = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerCarisma.setBounds(360, 195, 50, 20);
		panelRaza.add(spinnerCarisma);

		panelRaza.add(new JLabel(et.getString("Raza"))).setBounds(10, 10, 116, 16);
		panelRaza.add(new JLabel(et.getString("Descripcion"))).setBounds(10, 50, 116, 16);
		panelRaza.add(new JLabel(et.getString("Tamaño"))).setBounds(10, 100, 116, 16);
		panelRaza.add(new JLabel(et.getString("Velocidad"))).setBounds(10, 140, 116, 16);
		
		btnBorrarClase = new JButton(et.getString("BorrarClase"));
		btnBorrarClase.setBounds(173, 231, 150, 30);  // Ajusta la posición según necesites
		panelClase.add(btnBorrarClase);
		
		btnBorrarRaza = new JButton(et.getString("BorrarRaza"));
		btnBorrarRaza.setBounds(200, 263, 150, 30);  // Ajusta la posición según necesites
		panelRaza.add(btnBorrarRaza);

		// Cargar info
		cargarNombresClases();
		cargarNombresRazas();
		buscarClasesConTableModel();
		buscarRazasConTableModel();

		ManejadorBoton escuchador = new ManejadorBoton();
		btnGuardarClase.addActionListener(escuchador);
		btnGuardarRaza.addActionListener(escuchador);
		btnBorrarClase.addActionListener(escuchador);
		btnBorrarRaza.addActionListener(escuchador);
		
		comboClasesEditar.addActionListener(escuchador);
		comboRazasEditar.addActionListener(escuchador);
	}

	public class ManejadorBoton implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Si el origen del evento es comboClasesEditar, se ejecuta cargarClaseSeleccionada
	        if (e.getSource() == comboClasesEditar) {
	            cargarClaseSeleccionada();
	        }
	        // Si el origen del evento es comboRazasEditar, se ejecuta cargarRazaSeleccionada
	        if (e.getSource() == comboRazasEditar) {
	            cargarRazaSeleccionada();
	        }
	        
	        // Si el origen del evento es btnGuardarClase, se ejecuta actualizarClase
	        if (e.getSource() == btnGuardarClase) {
	            actualizarClase();
	        }
	        
	        // Si el origen del evento es btnGuardarRaza, se ejecuta actualizarRaza
	        if (e.getSource() == btnGuardarRaza) {
	            actualizarRaza();
	        }
	        
	        // Si el origen del evento es btnBorrarClase, se ejecuta borrarClase
	        if (e.getSource() == btnBorrarClase) {
	            borrarClase();
	        }
	        
	        // Si el origen del evento es btnBorrarRaza, se ejecuta borrarRaza
	        if (e.getSource() == btnBorrarRaza) {
	            borrarRaza();
	        }
	    }
	}
	
	// Llenar combo clases
	private void cargarNombresClases() {
		CClase controlador = new CClase();
		try (ResultSet rs = controlador.obtenerNombresClases()) { // Obtener el ResultSet de las clases
			comboClasesEditar.removeAllItems(); // Limpiar el JComboBox

			while (rs.next()) {
				String nombreClase = rs.getString("NombreClase");
				comboClasesEditar.addItem(nombreClase); // Agregar cada nombre de clase
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Error al cargar clases", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// Llenar combo razas
	private void cargarNombresRazas() {
		CRaza controlador = new CRaza();
		try (ResultSet rs = controlador.obtenerNombresRazas()) { // Obtener el ResultSet de las razas
			comboRazasEditar.removeAllItems(); // Limpiar el JComboBox

			while (rs.next()) {
				String nombreRaza = rs.getString("NombreRaza");
				comboRazasEditar.addItem(nombreRaza); // Agregar cada nombre de raza
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Error al cargar razas", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void cargarClaseSeleccionada() {
		String nombre = (String) comboClasesEditar.getSelectedItem();
		if (nombre != null) {
			OClase clase = new CClase().buscarClasePorNombre(nombre);
			if (clase != null) {
				textDescipcionClase.setText(clase.getDescripcionClase());
				comboBoxTipoClase.setSelectedItem(clase.getTipoClase());
				spinnerDaño.setValue(clase.getDadoDaño());
			}
		}
	}

	private void cargarRazaSeleccionada() {
	    String nombre = (String) comboRazasEditar.getSelectedItem();
	    if (nombre != null) {
	        ORaza raza = new CRaza().buscarRazaPorNombre(nombre);
	        if (raza != null) {
	            // Cargar los valores de la raza
	            textDescripcionRaza.setText(raza.getDescripcionRaza());
	            comboBoxTamaño.setSelectedItem(raza.getTamañoRaza());  // Selecciona el tamaño de la raza
	            spinnerVelocidad.setValue(raza.getVelocidadRaza());

	            // Cargar las estadísticas de la raza en los spinners
	            spinnerFuerza.setValue(raza.getFuerza());
	            spinnerDestreza.setValue(raza.getDestreza());
	            spinnerConstitucion.setValue(raza.getConstitucion());
	            spinnerInteligencia.setValue(raza.getInteligencia());
	            spinnerSabiduria.setValue(raza.getSabiduria());
	            spinnerCarisma.setValue(raza.getCarisma());
	        }
	    }
	}



	private void actualizarClase() {
	    try {
	        // Obtener el nombre de la clase seleccionada
	        String nombre = (String) comboClasesEditar.getSelectedItem();
	        if (nombre == null)
	            return;

	        // Buscar la clase por nombre
	        OClase clase = new CClase().buscarClasePorNombre(nombre);
	        if (clase != null) {
	            // Establecer los nuevos valores
	            clase.setDescripcionClase(textDescipcionClase.getText());
	            clase.setTipoClase((String) comboBoxTipoClase.getSelectedItem());
	            clase.setDadoDaño((int) spinnerDaño.getValue());

	            // Actualizar la clase en la base de datos
	            new CClase().actualizarClase(clase);
	            JOptionPane.showMessageDialog(this, "Clase actualizada correctamente.");

	            // Actualizar la tabla con la nueva información
	            buscarClasesConTableModel();
	        } else {
	            JOptionPane.showMessageDialog(this, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error al actualizar clase", "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}
	private void borrarClase() {
	    try {
	        String nombre = (String) comboClasesEditar.getSelectedItem();
	        if (nombre == null) {
	            JOptionPane.showMessageDialog(this, "Seleccione una clase para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        
	        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea borrar la clase " + nombre + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            new CClase().borrarClase(nombre);  // Llamamos al método del controlador
	            buscarClasesConTableModel();  // Actualizamos la tabla después de borrar
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error al borrar la clase", "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}
	private void borrarRaza() {
	    try {
	        String nombre = (String) comboRazasEditar.getSelectedItem();
	        if (nombre == null) {
	            JOptionPane.showMessageDialog(this, "Seleccione una raza para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea borrar la raza " + nombre + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            new CRaza().borrarRaza(nombre);  // Llamamos al método del controlador
	            buscarRazasConTableModel();  // Actualizamos la tabla después de borrar
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error al borrar la raza", "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}

	private void actualizarRaza() {
	    try {
	        // Obtener el nombre de la raza seleccionada
	        String nombre = (String) comboRazasEditar.getSelectedItem();
	        if (nombre == null)
	            return;

	        // Crear un objeto ORaza con los valores editados
	        ORaza raza = new CRaza().buscarRazaPorNombre(nombre);
	        if (raza != null) {
	            // Actualizar los valores de la raza
	            raza.setDescripcionRaza(textDescripcionRaza.getText());
	            raza.setTamañoRaza((String) comboBoxTamaño.getSelectedItem());
	            raza.setVelocidadRaza((int) spinnerVelocidad.getValue());

	            // Actualizar las estadísticas de la raza
	            raza.setFuerza((int) spinnerFuerza.getValue());
	            raza.setDestreza((int) spinnerDestreza.getValue());
	            raza.setConstitucion((int) spinnerConstitucion.getValue());
	            raza.setInteligencia((int) spinnerInteligencia.getValue());
	            raza.setSabiduria((int) spinnerSabiduria.getValue());
	            raza.setCarisma((int) spinnerCarisma.getValue());

	            // Llamar al método que ya tienes en CRaza para actualizar en la base de datos
	            new CRaza().actualizarRaza(raza);

	            // Mostrar un mensaje de éxito
	            JOptionPane.showMessageDialog(this, "Raza y estadísticas actualizadas correctamente.");
	            buscarRazasConTableModel(); // Actualizar la tabla de razas
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error al actualizar raza", "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}
	
	private void buscarClasesConTableModel() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id Clase");
		model.addColumn("Nombre Clase");
		model.addColumn("Descripción");
		model.addColumn("Tipo");
		model.addColumn("Dado Daño");

		CClase controlador = new CClase();
		controlador.buscarClasesConTableModel(model);

		tableClases.setModel(model);
		tableClases.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollClase.setViewportView(tableClases);
	}

	private void buscarRazasConTableModel() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id Raza");
		model.addColumn("Nombre Raza");
		model.addColumn("Descripción");
		model.addColumn("Tamaño");
		model.addColumn("Velocidad");

		CRaza controlador = new CRaza();
		controlador.buscarRazasConTableModel(model);

		tableRazas.setModel(model);
		tableRazas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollRaza.setViewportView(tableRazas);
	}
	
	
}
