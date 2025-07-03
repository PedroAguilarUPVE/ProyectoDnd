package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controladores.CPersonaje;
import modelos.OPersonaje;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class tablaPersonajes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablePersonajes;
	private JButton okButton;
	private JButton cancelButton;
	public int idPersonaje = -1;
	private Object Padre;
	private JScrollPane miBarra;
	private int paginaActualPersonajes = 1;
	private int registrosPorPagina = 10;
	private JButton btnPriPerson;
	private JButton btnAntPerson;
	private JButton btnSigPerson;
	private JButton btnUltPerson;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			tablaPersonajes dialog = new tablaPersonajes(null);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * 
	 * 
	 * @param parent 
	 * @paran modal
	 */
	public tablaPersonajes(JDialog parent, boolean modal) {
		super(parent, true);// se inicializa el constructor super
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		// super(null, true);
		this.Padre = parent;
		setBounds(100, 100, 460, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		miBarra = new JScrollPane();
		miBarra.setBounds(10, 10, 420, 190);
		contentPanel.add(miBarra);

		tablePersonajes = new JTable();
		miBarra.setViewportView(tablePersonajes);

		btnPriPerson = new JButton("Primero");
		btnPriPerson.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnPriPerson.setBounds(10, 210, 69, 21);
		contentPanel.add(btnPriPerson);

		btnAntPerson = new JButton("Anterior");
		btnAntPerson.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAntPerson.setBounds(84, 210, 69, 21);
		contentPanel.add(btnAntPerson);

		btnSigPerson = new JButton("Siguiente");
		btnSigPerson.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSigPerson.setBounds(158, 210, 75, 21);
		contentPanel.add(btnSigPerson);

		btnUltPerson = new JButton("Ultimo");
		btnUltPerson.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnUltPerson.setBounds(238, 210, 61, 21);
		contentPanel.add(btnUltPerson);

		okButton = new JButton("OK");
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		okButton.setBounds(304, 210, 45, 21);
		contentPanel.add(okButton);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		cancelButton.setBounds(354, 210, 63, 21);
		contentPanel.add(cancelButton);
		cancelButton.setActionCommand("Cancel");
		
		buscarPersonajesConTableModel();
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		
		cancelButton.addActionListener(EscuchadorBotones);
		okButton.addActionListener(EscuchadorBotones);
		btnUltPerson.addActionListener(EscuchadorBotones);
		btnSigPerson.addActionListener(EscuchadorBotones);
		btnAntPerson.addActionListener(EscuchadorBotones);
		btnPriPerson.addActionListener(EscuchadorBotones);

	}

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

	public class ManejadorTabla implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				if (e.getSource().equals(tablePersonajes.getSelectionModel())) {
					int fila = tablePersonajes.getSelectedRow();
					if (fila != -1) {

						idPersonaje = CPersonaje
								.obtenerIdPersonaje(tablePersonajes.getValueAt(fila, 0).toString());

						System.out.println("Personaje seleccionado ID: " + idPersonaje);
					}
				}
			}
		}
	}

	public class ManejadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(okButton)) {
				idPersonaje = CPersonaje
						.obtenerIdPersonaje(tablePersonajes.getValueAt(tablePersonajes.getSelectedRow(), 0).toString());
				editarPersonajeSeleccionado();
				dispose();
			}
			if (e.getSource().equals(cancelButton)) {
				idPersonaje = -1;
				editarPersonajeSeleccionado();
				dispose();
			}
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
		}
	}

	private void editarPersonajeSeleccionado() {
		if (idPersonaje != -1) {
			System.out.println("Personaje seleccionado ID: " + idPersonaje);
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona un personaje antes de editar.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private int UltimaPagina() {
		int paginas;
		paginas = CPersonaje.contarPaginas(registrosPorPagina);
		return paginas;
	}
}
