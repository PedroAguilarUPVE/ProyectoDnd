package vistas;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import conexion.ConexionBDSQLServer;
import controladores.CClase;
import controladores.CPersonaje;
import controladores.CRaza;
import controladores.CSubclase;
import modelos.OClase;
import modelos.ORaza;
import modelos.OSubclase;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class panelesJtables extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelContenido;
	private ResourceBundle et;

	private JTable tablePersonajes;
	private JTable tableClases;
	private JTable tableRazas;
	private JTable tableSubclases;
	private JScrollPane scrollClases;
	private JScrollPane scrollRaza;
	private JScrollPane scrollSubclases;
	private JScrollPane miBarra;

	private JPanel panelRazas;
	private JPanel panelPersonajes;
	private JPanel panelSubclases;

	private JButton btnPriPerson, btnAntPerson, btnSigPerson, btnUltPerson, btnEdiPerson, btnCrearPerson;
	private JButton btnPriRazas, btnAntRazas, btnSigRazas, btnUltRazas, btnEdiRazas, btnCrearRaza;
	private JButton btnPriClases, btnAntClases, btnSigClases, btnUltClases, btnEdiClases, btnCrearClase;
	private JButton btnPriSubclases, btnAntSubclases, btnSigSubclases, btnUltSubclases, btnEdiSubclases, btnCrearSubclase;

	private int paginaActualClases = 1;
	private int paginaActualSubclases = 1;
	private int paginaActualRazas = 1;
	private int paginaActualPersonajes = 1;

	private final int registrosPorPagina = 10;
	private Locale Idioma;
	private int idPersonaje = -1, idClase = -1, idRaza = -1, idSubclase = -1;

	private OClase claseSeleccionada;
	private OSubclase subclaseSeleccionada;
	private ORaza razaSeleccionada;
	private JButton btnReportePerson;

	public panelesJtables(Frame parent, boolean modal, Locale idioma) {
		super(parent, modal);
		Idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);
		setTitle(et.getString("crearClases"));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 874, 407);

		panelContenido = new JPanel();
		panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelContenido.setLayout(null);
		setContentPane(panelContenido);

		JTabbedPane panelTabs = new JTabbedPane(JTabbedPane.TOP);
		panelTabs.setBackground(new Color(128, 128, 128));
		panelTabs.setBounds(10, 11, 840, 360);
		panelContenido.add(panelTabs);

		// Panel Clases
		tableClases = new JTable();
		scrollClases = new JScrollPane(tableClases);
		JPanel panelClases = new JPanel(null);
		scrollClases.setBounds(10, 11, 800, 185);
		panelClases.add(scrollClases);
		panelTabs.addTab(et.getString("Clases"), panelClases);

		btnPriClases = new JButton(et.getString("Primero"));
		btnPriClases.setBounds(20, 255, 120, 20);
		panelClases.add(btnPriClases);

		btnAntClases = new JButton(et.getString("Anterior"));
		btnAntClases.setBounds(150, 255, 120, 20);
		panelClases.add(btnAntClases);

		btnSigClases = new JButton(et.getString("Siguiente"));
		btnSigClases.setBounds(280, 255, 120, 20);
		panelClases.add(btnSigClases);

		btnUltClases = new JButton(et.getString("Ultimo"));
		btnUltClases.setBounds(410, 255, 120, 20);
		panelClases.add(btnUltClases);

		btnEdiClases = new JButton(et.getString("Editar"));
		btnEdiClases.setBounds(540, 255, 120, 20);
		panelClases.add(btnEdiClases);

		btnCrearClase = new JButton(et.getString("Crear"));
		btnCrearClase.setBounds(670, 255, 120, 20);
		panelClases.add(btnCrearClase);

		// Panel Subclases
		tableSubclases = new JTable();
		scrollSubclases = new JScrollPane(tableSubclases);
		panelSubclases = new JPanel(null);
		scrollSubclases.setBounds(10, 11, 800, 185);
		panelSubclases.add(scrollSubclases);
		panelTabs.addTab(et.getString("Subclases"), panelSubclases);

		btnPriSubclases = new JButton(et.getString("Primero"));
		btnPriSubclases.setBounds(20, 255, 120, 20);
		panelSubclases.add(btnPriSubclases);

		btnAntSubclases = new JButton(et.getString("Anterior"));
		btnAntSubclases.setBounds(150, 255, 120, 20);
		panelSubclases.add(btnAntSubclases);

		btnSigSubclases = new JButton(et.getString("Siguiente"));
		btnSigSubclases.setBounds(280, 255, 120, 20);
		panelSubclases.add(btnSigSubclases);

		btnUltSubclases = new JButton(et.getString("Ultimo"));
		btnUltSubclases.setBounds(410, 255, 120, 20);
		panelSubclases.add(btnUltSubclases);

		btnEdiSubclases = new JButton(et.getString("Editar"));
		btnEdiSubclases.setBounds(540, 255, 120, 20);
		panelSubclases.add(btnEdiSubclases);

		btnCrearSubclase = new JButton(et.getString("Crear"));
		btnCrearSubclase.setBounds(670, 255, 120, 20);
		panelSubclases.add(btnCrearSubclase);

		// Panel Razas
		tableRazas = new JTable();
		scrollRaza = new JScrollPane(tableRazas);
		panelRazas = new JPanel(null);
		scrollRaza.setBounds(10, 11, 800, 185);
		panelRazas.add(scrollRaza);
		panelTabs.addTab(et.getString("Razas"), panelRazas);

		btnPriRazas = new JButton(et.getString("Primero"));
		btnPriRazas.setBounds(20, 255, 120, 20);
		panelRazas.add(btnPriRazas);

		btnAntRazas = new JButton(et.getString("Anterior"));
		btnAntRazas.setBounds(150, 255, 120, 20);
		panelRazas.add(btnAntRazas);

		btnSigRazas = new JButton(et.getString("Siguiente"));
		btnSigRazas.setBounds(280, 255, 120, 20);
		panelRazas.add(btnSigRazas);

		btnUltRazas = new JButton(et.getString("Ultimo"));
		btnUltRazas.setBounds(410, 255, 120, 20);
		panelRazas.add(btnUltRazas);

		btnEdiRazas = new JButton(et.getString("Editar"));
		btnEdiRazas.setBounds(540, 255, 120, 20);
		panelRazas.add(btnEdiRazas);

		btnCrearRaza = new JButton(et.getString("Crear"));
		btnCrearRaza.setBounds(670, 255, 120, 20);
		panelRazas.add(btnCrearRaza);

		// Panel Personajes
		panelPersonajes = new JPanel(null);
		panelTabs.addTab(et.getString("Personajes"), panelPersonajes);
		tablePersonajes = new JTable();
		miBarra = new JScrollPane();
		miBarra.setBounds(10, 11, 800, 185);
		panelPersonajes.add(miBarra);

		btnPriPerson = new JButton(et.getString("Primero"));
		btnPriPerson.setBounds(20, 255, 120, 20);
		panelPersonajes.add(btnPriPerson);

		btnAntPerson = new JButton(et.getString("Anterior"));
		btnAntPerson.setBounds(150, 255, 120, 20);
		panelPersonajes.add(btnAntPerson);

		btnSigPerson = new JButton(et.getString("Siguiente"));
		btnSigPerson.setBounds(280, 255, 120, 20);
		panelPersonajes.add(btnSigPerson);

		btnUltPerson = new JButton(et.getString("Ultimo"));
		btnUltPerson.setBounds(410, 255, 120, 20);
		panelPersonajes.add(btnUltPerson);

		btnEdiPerson = new JButton(et.getString("Editar"));
		btnEdiPerson.setBounds(540, 255, 120, 20);
		panelPersonajes.add(btnEdiPerson);

		btnCrearPerson = new JButton(et.getString("Crear"));
		btnCrearPerson.setBounds(670, 255, 120, 20);
		panelPersonajes.add(btnCrearPerson);
		
		btnReportePerson = new JButton("Reporte");
		btnReportePerson.setBounds(20, 285, 120, 20);
		panelPersonajes.add(btnReportePerson);
		
		
		buscarClasesConTableModel();
		buscarRazasConTableModel();
		buscarSubclasesConTableModel();
		buscarPersonajesConTableModel();

		// --- Escuchadores ---
		ManejadorBotones Escuchador = new ManejadorBotones();
		btnAntPerson.addActionListener(Escuchador);
		btnSigPerson.addActionListener(Escuchador);
		btnPriPerson.addActionListener(Escuchador);
		btnUltPerson.addActionListener(Escuchador);
		btnAntRazas.addActionListener(Escuchador);
		btnSigRazas.addActionListener(Escuchador);
		btnPriRazas.addActionListener(Escuchador);
		btnUltRazas.addActionListener(Escuchador);
		btnAntClases.addActionListener(Escuchador);
		btnSigClases.addActionListener(Escuchador);
		btnPriClases.addActionListener(Escuchador);
		btnUltClases.addActionListener(Escuchador);
		btnAntSubclases.addActionListener(Escuchador);
		btnSigSubclases.addActionListener(Escuchador);
		btnPriSubclases.addActionListener(Escuchador);
		btnUltSubclases.addActionListener(Escuchador);
		btnEdiPerson.addActionListener(Escuchador);
		btnEdiRazas.addActionListener(Escuchador);
		btnEdiClases.addActionListener(Escuchador);
		btnEdiSubclases.addActionListener(Escuchador);
		btnReportePerson.addActionListener(Escuchador);

		ManejadorTabla ControladorTabla = new ManejadorTabla();
		tablePersonajes.getSelectionModel().addListSelectionListener(ControladorTabla);
		tableClases.getSelectionModel().addListSelectionListener(ControladorTabla);
		tableRazas.getSelectionModel().addListSelectionListener(ControladorTabla);
		tableSubclases.getSelectionModel().addListSelectionListener(ControladorTabla);

	}

	public class ManejadorBotones implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAntPerson) {
				if (paginaActualPersonajes > 1) {
					paginaActualPersonajes--;
					buscarPersonajesConTableModel();
				}
			}
			if (e.getSource() == btnSigPerson) {
				if (paginaActualPersonajes < UltimaPagina())
					paginaActualPersonajes++;
				buscarPersonajesConTableModel();
			}
			if (e.getSource() == btnPriPerson) {
				paginaActualPersonajes = 1;
				buscarPersonajesConTableModel();
			}
			if (e.getSource() == btnUltPerson) {
				paginaActualPersonajes = UltimaPagina();
				buscarPersonajesConTableModel();
			}
			if (e.getSource() == btnAntRazas) {
				if (paginaActualRazas > 1) {
					paginaActualRazas--;
					buscarRazasConTableModel();
				}
			}
			if (e.getSource() == btnSigRazas) {
				if (paginaActualRazas < UltimaPaginaRaza())
					paginaActualRazas++;
				buscarRazasConTableModel();
			}
			if (e.getSource() == btnPriRazas) {
				paginaActualRazas = 1;
				buscarRazasConTableModel();

			}
			if (e.getSource() == btnUltRazas) {
				paginaActualRazas = UltimaPaginaRaza();
				buscarRazasConTableModel();
			}
			if (e.getSource() == btnAntClases) {
				if (paginaActualClases > 1) {
					paginaActualClases--;
					buscarClasesConTableModel();
				}
			}
			if (e.getSource() == btnSigClases) {
				if (paginaActualClases < UltimaPaginaClase())
					paginaActualClases++;
				buscarClasesConTableModel();
			}
			if (e.getSource() == btnPriClases) {
				paginaActualClases = 1;
				buscarClasesConTableModel();
			}
			if (e.getSource() == btnUltClases) {
				paginaActualClases = UltimaPaginaClase();
				buscarClasesConTableModel();
			}
			if (e.getSource() == btnAntSubclases) {
				if (paginaActualSubclases > 1) {
					paginaActualSubclases--;
					buscarSubclasesConTableModel();
				}
			}
			if (e.getSource() == btnSigSubclases) {
				if (paginaActualSubclases < UltimaPaginaSubclase())
					paginaActualSubclases++;
				buscarSubclasesConTableModel();
			}
			if (e.getSource() == btnPriSubclases) {
				paginaActualSubclases = 1;
				buscarSubclasesConTableModel();
			}
			if (e.getSource() == btnUltSubclases) {
				paginaActualSubclases = UltimaPaginaSubclase();
				buscarSubclasesConTableModel();
			}
			if (e.getSource().equals(btnEdiPerson)) {
				editarPersonajeSeleccionado();
			}
			if (e.getSource() == btnEdiClases) {
				editarClaseSeleccionada();
			}
			if (e.getSource() == btnEdiSubclases) {
				editarSubclaseSeleccionada();
			}
			if (e.getSource() == btnEdiRazas) {
				editarRazaSeleccionada();
			}
			if (e.getSource() == btnReportePerson ) {
				JasperReport Reporte;
				
				Connection ConexionBd = null;
				// Conecta con la base de datos
				ConexionBd = ConexionBDSQLServer.GetConexion();

				try {
					//Reporte = JasperCompileManager.compileReport("src/reportes/ReporteVentast.jrxml");
					Reporte = JasperCompileManager.compileReport("src/reportes/ReportePErsonajes.jrxml");
					JasperPrint JP = JasperFillManager.fillReport(Reporte, null, ConexionBd);
					JasperViewer.viewReport(JP,true);

				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}

	private void editarPersonajeSeleccionado() {
		if (idPersonaje != -1) {
			CrearPersonaje VerPersonaje = new CrearPersonaje(null, true, Idioma, idPersonaje);
			VerPersonaje.setVisible(true);
			buscarPersonajesConTableModel();
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona un personaje antes de editar.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		buscarPersonajesConTableModel();
	}

	private void editarClaseSeleccionada() {
		if (idClase != -1) {
			CrearClases VerClase = new CrearClases(null, true, Idioma, idClase);
			VerClase.setVisible(true);
			buscarClasesConTableModel();
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona una clase para editar.", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}
		buscarClasesConTableModel();
	}

	private void editarSubclaseSeleccionada() {
		if (idSubclase != -1) {
			System.out.println(idSubclase);
			CrearSubclases VerSubclase = new CrearSubclases(null, true, Idioma, idSubclase);
			VerSubclase.setVisible(true);
			buscarSubclasesConTableModel();
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona una subclase para editar.", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}
		buscarSubclasesConTableModel();
	}

	
	private void editarRazaSeleccionada() {
		if (idRaza!= -1) {
			CrearRazas VerRaza = new CrearRazas(null, true, Idioma, idRaza);
			VerRaza.setVisible(true);
			buscarRazasConTableModel();
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona una raza para editar.", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}
		buscarRazasConTableModel();
	}
	

	
	public class ManejadorTabla implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				if (e.getSource().equals(tablePersonajes.getSelectionModel())) {
					int fila = tablePersonajes.getSelectedRow();
					if (fila != -1) {
						idPersonaje = CPersonaje.obtenerIdPersonaje(tablePersonajes.getValueAt(fila, 0).toString());
						System.out.println("Personaje seleccionado ID: " + idPersonaje);
					}
				}

				if (e.getSource().equals(tableClases.getSelectionModel())) {
					int fila = tableClases.getSelectedRow();
					if (fila != -1) {
						String nombreClase = tableClases.getValueAt(fila, 1).toString(); // columna 1 = nombre clase
						idClase = CClase.obtenerIdClasePorNombre(nombreClase);
						claseSeleccionada = CClase.obtenerClasePorId(idClase);
						System.out.println("Clase seleccionada: " + claseSeleccionada.getNombre());
						System.out.println("Clase seleccionada: " + claseSeleccionada.getDescripcion());
					}
				}
				
				if (e.getSource().equals(tableSubclases.getSelectionModel())) {
					int fila = tableSubclases.getSelectedRow();
					if (fila != -1) {
						String nombreSubclase = tableSubclases.getValueAt(fila, 0).toString(); // columna 1 = nombre clase
//						System.out.println("Clase seleccionada: " + claseSeleccionada.getNombre());
						idSubclase =  (int) tableSubclases.getValueAt(fila, 0);
						subclaseSeleccionada = CSubclase.buscarSubclasePorId(idSubclase);
//						System.out.println("Clase seleccionada: " + claseSeleccionada.getDescripcion());
					}
				}
				

				if (e.getSource().equals(tableRazas.getSelectionModel())) {
					int fila = tableRazas.getSelectedRow();
					if (fila != -1) {
						String nombreRaza = tableRazas.getValueAt(fila, 1).toString(); // columna 1 = nombre Raza
						idRaza = CRaza.obtenerIdRazaPorNombre(nombreRaza);
						idRaza = (int) tableRazas.getValueAt(fila,0); 
						razaSeleccionada = CRaza.obtenerRazaPorId(idRaza);
						System.out.println("Raza seleccionada: "+ idRaza +" "+ razaSeleccionada.getNombre() );
					}
				}
			}
		}
	}

	// --- Métodos para cargar datos en tablas ---
	private void buscarPersonajesConTableModel() {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// model.addColumn("Id");
		model.addColumn("Nombre");
		model.addColumn("Nivel");
		model.addColumn("Clase");
		model.addColumn("Subclase");
		model.addColumn("Raza");

		CPersonaje miPersonaje = new CPersonaje();
		miPersonaje.buscarPersonajesConTableModel(model, paginaActualPersonajes, registrosPorPagina);

		tablePersonajes.setModel(model);
		tablePersonajes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablePersonajes.getTableHeader().setReorderingAllowed(false);
		miBarra.setViewportView(tablePersonajes);
	}

	private void buscarRazasConTableModel() {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Id Raza");
		model.addColumn("Nombre Raza");
		model.addColumn("Descripción");
		model.addColumn("Tamaño");
		model.addColumn("Velocidad");

		CRaza miRaza = new CRaza();
		miRaza.buscarRazasConTableModel(model, paginaActualRazas, registrosPorPagina);

		tableRazas.setModel(model);
		tableRazas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollRaza.setViewportView(tableRazas);
	}

	private void buscarClasesConTableModel() {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Id Clase");
		model.addColumn("Nombre Clase");
		model.addColumn("Descripción");
		model.addColumn("Tipo");
		model.addColumn("Dado Daño");

		CClase miClase = new CClase();
		miClase.buscarClasesConTableModel(model, paginaActualClases, registrosPorPagina);

		tableClases.setModel(model);
		tableClases.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollClases.setViewportView(tableClases);
	}

	private void buscarSubclasesConTableModel() {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Id Subclase");
		model.addColumn("Id Clase");
		model.addColumn("Nombre Subclase");
		model.addColumn("Descripción Subclase");

		CSubclase miSubclase = new CSubclase();
		miSubclase.buscarSubclasesConTableModel(model, paginaActualSubclases, registrosPorPagina);

		tableSubclases.setModel(model);
		tableSubclases.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollSubclases.setViewportView(tableSubclases);
	}

	private int UltimaPagina() {
		int paginas;
		paginas = CPersonaje.contarPaginas(registrosPorPagina);
		return paginas;
	}

	private int UltimaPaginaClase() {
		int paginas;
		paginas = CClase.contarPaginas(registrosPorPagina);
		return paginas;
	}

	private int UltimaPaginaRaza() {
		int paginas;
		paginas = CRaza.contarPaginas(registrosPorPagina);
		return paginas;
	}

	private int UltimaPaginaSubclase() {
		int paginas;
		paginas = CSubclase.contarPaginas(registrosPorPagina);
		return paginas;
	}
}
