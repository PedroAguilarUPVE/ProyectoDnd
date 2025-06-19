package vistas;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controladores.CClase;
import controladores.CPersonaje;
import controladores.CRaza;
import controladores.CSubclase;
import modelos.OClase;
import modelos.ORaza;
import vistas.EditarClases;





public class panelesJtable extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelContenido;
	private ResourceBundle et;

	private JTable tablePersonajes;
	private JTable tableClases;
	private JTable tableRazas;
	private JScrollPane scrollClases;
	private JScrollPane scrollRaza;
	private JScrollPane miBarra;

	private JPanel panelRazas;
	private JPanel panelPersonajes;

	private JButton btnPriPerson, btnAntPerson, btnSigPerson, btnUltPerson;
	private JButton btnUltRazas, btnSigRazas, btnAntRazas, btnPriRazas;
	private JButton btnPriClases, btnAntClases, btnSigClases, btnUltClases;

	private int paginaActualClases = 1;
	private int paginaActualSubclases = 1;
	private int paginaActualRazas = 1;
	private int paginaActualPersonajes = 1;

	private final int registrosPorPagina = 10;
	private JPanel panelSubclases;
	private JScrollPane scrollSubclases;
	private JButton btnPriSubclases;
	private JButton btnAntSubclases;
	private JButton btnSigSubclases;
	private JButton btnUltSubclases;
	private JTable tableSubclases;
	private Locale Idioma;
	private JButton btnEdiPerson;
	private JButton btnEdiClases;
	private JButton btnEdiSubClases;
	private JButton btnEdiRazas;
	public panelesJtable tablas;
	
	private OClase claseSeleccionada;
	private ORaza razaSeleccionada;

	

	public panelesJtable(Frame parent, boolean modal, Locale idioma) {
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
		panelTabs.setBounds(10, 11, 811, 392);
		panelContenido.add(panelTabs);

		// --- Panel Clases ---
		tableClases = new JTable();
		scrollClases = new JScrollPane(tableClases);
		JPanel panelClases = new JPanel(null);
		scrollClases.setBounds(10, 11, 786, 185);
		panelClases.add(scrollClases);
		panelTabs.addTab("Clases", panelClases);

		btnPriClases = new JButton("Primero");
		btnPriClases.setBounds(101, 255, 89, 23);
		panelClases.add(btnPriClases);

		btnAntClases = new JButton("Anterior");
		btnAntClases.setBounds(228, 255, 89, 23);
		panelClases.add(btnAntClases);

		btnSigClases = new JButton("Siguiente");
		btnSigClases.setBounds(360, 255, 89, 23);
		panelClases.add(btnSigClases);

		btnUltClases = new JButton("Ultimo");
		btnUltClases.setBounds(487, 255, 89, 23);
		panelClases.add(btnUltClases);
		
		btnEdiClases = new JButton("Editar");
		btnEdiClases.setBounds(609, 255, 89, 23);
		panelClases.add(btnEdiClases);

		buscarClasesConTableModel();

		tableSubclases = new JTable();
		scrollSubclases = new JScrollPane(tableSubclases);
		panelSubclases = new JPanel(null);
		scrollSubclases.setBounds(10, 11, 786, 185);
		panelSubclases.add(scrollSubclases);
		panelTabs.addTab("Subclases", panelSubclases);

		btnPriSubclases = new JButton("Primero");
		btnPriSubclases.setBounds(109, 252, 89, 23);
		panelSubclases.add(btnPriSubclases);

		btnAntSubclases = new JButton("Anterior");
		btnAntSubclases.setBounds(236, 252, 89, 23);
		panelSubclases.add(btnAntSubclases);

		btnSigSubclases = new JButton("Siguiente");
		btnSigSubclases.setBounds(368, 252, 89, 23);
		panelSubclases.add(btnSigSubclases);

		btnUltSubclases = new JButton("Ultimo");
		btnUltSubclases.setBounds(495, 252, 89, 23);
		panelSubclases.add(btnUltSubclases);
		
		btnEdiSubClases = new JButton("Editar");
		btnEdiSubClases.setBounds(623, 252, 89, 23);
		panelSubclases.add(btnEdiSubClases);

		buscarSubclasesConTableModel();

		// --- Panel Razas ---
		tableRazas = new JTable();
		scrollRaza = new JScrollPane(tableRazas);
		panelRazas = new JPanel(null);
		scrollRaza.setBounds(10, 11, 786, 185);
		panelRazas.add(scrollRaza);
		panelTabs.addTab("Razas", panelRazas);

		btnPriRazas = new JButton("Primero");
		btnPriRazas.setBounds(108, 251, 89, 23);
		panelRazas.add(btnPriRazas);

		btnAntRazas = new JButton("Anterior");
		btnAntRazas.setBounds(235, 251, 89, 23);
		panelRazas.add(btnAntRazas);

		btnSigRazas = new JButton("Siguiente");
		btnSigRazas.setBounds(367, 251, 89, 23);
		panelRazas.add(btnSigRazas);

		btnUltRazas = new JButton("Ultimo");
		btnUltRazas.setBounds(494, 251, 89, 23);
		panelRazas.add(btnUltRazas);
		
		btnEdiRazas = new JButton("Editar");
		btnEdiRazas.setBounds(620, 251, 89, 23);
		panelRazas.add(btnEdiRazas);

		buscarRazasConTableModel();

		// --- Panel Personajes ---
		panelPersonajes = new JPanel(null);
		panelTabs.addTab("Personajes", panelPersonajes);
		tablePersonajes = new JTable();
		//panelPersonajes.add(tablePersonajes);
		
		miBarra = new JScrollPane();
		miBarra.setBounds(10, 11, 786, 185);
		panelPersonajes.add(miBarra);

		btnPriPerson = new JButton("Primero");
		btnPriPerson.setBounds(77, 249, 89, 23);
		panelPersonajes.add(btnPriPerson);

		btnAntPerson = new JButton("Anterior");
		btnAntPerson.setBounds(204, 249, 89, 23);
		panelPersonajes.add(btnAntPerson);

		btnSigPerson = new JButton("Siguiente");
		btnSigPerson.setBounds(336, 249, 89, 23);
		panelPersonajes.add(btnSigPerson);

		btnUltPerson = new JButton("Ultimo");
		btnUltPerson.setBounds(463, 249, 89, 23);
		panelPersonajes.add(btnUltPerson);
		
		btnEdiPerson = new JButton("Editar");
		btnEdiPerson.setBounds(589, 249, 89, 23);
		panelPersonajes.add(btnEdiPerson);

		buscarPersonajesConTableModel();

		// --- Escuchadores ---
		manejadorbotones Escuchador = new manejadorbotones();
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
		btnEdiSubClases.addActionListener(Escuchador);

		ManejadorTabla ControladorTabla = new ManejadorTabla();
		tablePersonajes.getSelectionModel().addListSelectionListener(ControladorTabla);
		tableClases.getSelectionModel().addListSelectionListener(ControladorTabla);
		tableRazas.getSelectionModel().addListSelectionListener(ControladorTabla);
		tableSubclases.getSelectionModel().addListSelectionListener(ControladorTabla);

	}

	public class manejadorbotones implements ActionListener {
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
			if (e.getSource() == btnEdiRazas) {
			    editarRazaSeleccionada();
			}


		}
	}
	private void editarPersonajeSeleccionado() {
	    if (idSeleccionadoPersonaje != -1) {
	        CrearPersonaje VerPersonaje = new CrearPersonaje(null, true, Idioma, idSeleccionadoPersonaje);
	        VerPersonaje.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(this, "Selecciona un personaje antes de editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    }
	}
	private void editarClaseSeleccionada() {
	    if (claseSeleccionada != null) {
	        CrearClases editar = new CrearClases(null, true, Idioma, claseSeleccionada);
	        editar.setVisible(true);
	        buscarClasesConTableModel();
	    } else {
	        JOptionPane.showMessageDialog(this, "Selecciona una clase para editar.", "Aviso",
	                JOptionPane.WARNING_MESSAGE);
	    }
	}
	private void editarRazaSeleccionada() {
	    if (razaSeleccionada != null) {
	    	CrearRazas editar = new CrearRazas(null, true, Idioma, razaSeleccionada);
	        editar.setVisible(true);
	        buscarRazasConTableModel();
	    } else {
	        JOptionPane.showMessageDialog(this, "Selecciona una raza para editar.", "Aviso",
	                JOptionPane.WARNING_MESSAGE);
	    }
	}


	
	private int idSeleccionadoPersonaje = -1; // Decláralo en tu clase principal (panelesJtable)

	public class ManejadorTabla implements ListSelectionListener {
	    @Override
	    public void valueChanged(ListSelectionEvent e) {
	        if (!e.getValueIsAdjusting()) {
	            if (e.getSource().equals(tablePersonajes.getSelectionModel())) {
	                int fila = tablePersonajes.getSelectedRow();
	                if (fila != -1) {
	                    idSeleccionadoPersonaje = Integer.parseInt(tablePersonajes.getValueAt(fila, 0).toString());
	                    System.out.println("Personaje seleccionado ID: " + idSeleccionadoPersonaje);
	                }
	            }

	            if (e.getSource().equals(tableClases.getSelectionModel())) {
	                int fila = tableClases.getSelectedRow();
	                if (fila != -1) {
	                    String nombreClase = tableClases.getValueAt(fila, 1).toString(); // columna 1 = nombre clase
	                    claseSeleccionada = new CClase().buscarClasePorNombre(nombreClase);
	                    System.out.println("Clase seleccionada: " + claseSeleccionada.getNombreClase());
	                }
	            }

	            if (e.getSource().equals(tableRazas.getSelectionModel())) {
	                int fila = tableRazas.getSelectedRow();
	                if (fila != -1) {
	                    String nombreRaza = tableRazas.getValueAt(fila, 1).toString(); // columna 1 = nombre raza
	                    razaSeleccionada = new CRaza().buscarRazaPorNombre(nombreRaza);
	                    System.out.println("Raza seleccionada: " + razaSeleccionada.getNombreRaza());
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
		model.addColumn("Id");
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
