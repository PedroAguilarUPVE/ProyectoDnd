
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.math4.core.jdkmath.JdkMath;

import com.PlaceHolder;

import controladores.CClase;
import controladores.CPersonaje;
import controladores.CRaza;
import controladores.CSubclase;
import modelos.OEstadisticas;
import modelos.OPersonaje;
import javax.swing.ListSelectionModel;

/**
 * Clase de la ventana crear personaje
 */
public class CrearPersonaje extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JLabel lblRaza;
	private JLabel lblTransfondo;
	private JTextField textTransfondo;
	private JLabel lblTiradaDes;
	private JLabel lblTiradaCon;
	private JLabel lblTiradaCar;
	private JLabel lblTiradaSab;
	private JLabel lblTiradaInt;

	private JLabel lblTiradaFue;

	public static int RanNum = 0;
	public static int ModFue = 0;
	public static int ModDes = 0;
	public static int ModCon = 0;
	public static int ModInt = 0;
	public static int ModSab = 0;
	public static int ModCar = 0;

	public static int TiradasSeleccionadas = 0;
	public static int HabilidadesSeleccionadas = 0;

	private JButton btnRandom;
	// public static Random random = JdkMath.random();
	private JButton btnCalcular;
	private JRadioButton rdbtnFue;
	private JRadioButton rdbtnDes;
	private JRadioButton rdbtnCon;
	private JRadioButton rdbtnInt;
	private JRadioButton rdbtnSab;
	private JRadioButton rdbtnCar;

	private JComboBox<String> comboBoxRaza;
	private JComboBox<String> comboBoxClase;
	private PlaceHolder Etiquetas;
	private JTextField textJugador;
	private JLabel lblTirada;
	private JSpinner spinnerLados;
	private JButton btnTirar;
	private JLabel lblImagen;
	private JComboBox comboBoxSubclase;
	private JPanel contentPane;
	private PanelHabilidades Habilidades;
	private PanelEstadisticas Estadisticas;

	private static ResourceBundle et;
	private static Locale Idioma;
	private JScrollPane scrollPersonajes;
	private JTable tablePersonajes;

	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JSpinner spinnerNivel;

	/**
	 * Constructor de la ventana de creacion de personajes Se crea como ventana hija
	 * de la ventana menu
	 * 
	 * @param parent         Clase Frame Indica el componente padre de de la ventana
	 *                       CrearPersonaje
	 * @param modal          Clase boolean Indica el modo de sobreposicion de la
	 *                       ventana hija
	 * @param Idioma         Clase Locale Hereda el parametro tipo Locale de la
	 *                       clase padre, para la seleccion de idioma
	 * @param idSeleccionado
	 */
	public CrearPersonaje(Frame parent, boolean modal, Locale Idioma, int idSeleccionado) { // Hoja De Personaje
		super(parent, modal);// se inicializa el constructor super
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		CrearPersonaje.Idioma = Idioma;
		System.out.println(idSeleccionado);

		// Obtener el idioma por defecto del sistema
		// Idioma = Locale.getDefault(); // Idioma de sistema

		// Idioma = new Locale("en","US"); //Ahora en ingles americano

		// System.out.println(Idioma.getDisplayName()); // Mostrar el nombre del idioma
		// obtenido
		// System.out.println("====================");

		// Obtener los recursos desde el archivo <properties/dic>
		// en funci�n del idioma <locale>
		et = ResourceBundle.getBundle("properties/dic", Idioma);

		setBounds(100, 100, 510, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 10, 480, 520);
		contentPane.add(tabbedPane);

		JPanel panelCreacion = new JPanel();
		panelCreacion.setLayout(null);
		tabbedPane.addTab(et.getString("crearJugador"), null, panelCreacion, et.getString("tooltipCrearJugador"));

		JLabel lblTitulo = new JLabel(et.getString("Hoja"));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblTitulo.setBounds(150, 5, 130, 20);
		panelCreacion.add(lblTitulo);

		JLabel lblNombre = new JLabel(et.getString("Nombre"));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 56, 125, 14);
		panelCreacion.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(10, 37, 120, 20);

		Etiquetas = new PlaceHolder(textNombre, et.getString("Nombre"));
		panelCreacion.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblJugador = new JLabel(et.getString("Jugador"));
		lblJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador.setBounds(312, 56, 112, 14);
		panelCreacion.add(lblJugador);

		textJugador = new JTextField();
		
		Etiquetas = new PlaceHolder(textJugador, et.getString("Jugador"));
		textJugador.setColumns(10);
		textJugador.setBounds(312, 37, 120, 20);
		panelCreacion.add(textJugador);

		JLabel lblClase = new JLabel(et.getString("Clase"));
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setBounds(170, 56, 112, 14);
		panelCreacion.add(lblClase);

		lblRaza = new JLabel(et.getString("Raza"));
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setBounds(170, 103, 112, 14);
		panelCreacion.add(lblRaza);

		lblTransfondo = new JLabel(et.getString("Transfondo"));
		lblTransfondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfondo.setBounds(10, 103, 125, 14);
		panelCreacion.add(lblTransfondo);

		comboBoxClase = new JComboBox();
		comboBoxClase.setBounds(160, 37, 120, 20);
		panelCreacion.add(comboBoxClase);

		comboBoxRaza = new JComboBox();
		comboBoxRaza.setBounds(159, 84, 120, 20);
		panelCreacion.add(comboBoxRaza);

		comboBoxSubclase = new JComboBox();
		comboBoxSubclase.setBounds(10, 84, 120, 20); // Ajuste de la ubicación y tamano
		panelCreacion.add(comboBoxSubclase);
		comboBoxSubclase.addItem("Subclase");
		comboBoxSubclase.setEnabled(false); // Desactivar inicialmente

		Estadisticas = new PanelEstadisticas(Idioma);
		Estadisticas.setBounds(10, 155, 410, 75);
		panelCreacion.add(Estadisticas);

		JPanel panelTiradas = new JPanel();
		panelTiradas.setBackground(new Color(192, 192, 192));
		panelTiradas.setBounds(10, 240, 130, 120);
		panelCreacion.add(panelTiradas);
		panelTiradas.setLayout(null);

		lblTiradaInt = new JLabel("0");
		lblTiradaInt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiradaInt.setBounds(97, 70, 25, 13);
		panelTiradas.add(lblTiradaInt);

		lblTiradaCon = new JLabel("0");
		lblTiradaCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiradaCon.setBounds(97, 54, 25, 13);
		panelTiradas.add(lblTiradaCon);

		lblTiradaSab = new JLabel("0");
		lblTiradaSab.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiradaSab.setBounds(97, 84, 25, 13);
		panelTiradas.add(lblTiradaSab);

		lblTiradaCar = new JLabel("0");
		lblTiradaCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiradaCar.setBounds(97, 99, 25, 13);
		panelTiradas.add(lblTiradaCar);

		lblTiradaDes = new JLabel("0");
		lblTiradaDes.setBounds(97, 39, 25, 13);
		panelTiradas.add(lblTiradaDes);
		lblTiradaDes.setHorizontalAlignment(SwingConstants.CENTER);

		lblTiradaFue = new JLabel("0");
		lblTiradaFue.setBounds(97, 25, 25, 13);
		panelTiradas.add(lblTiradaFue);
		lblTiradaFue.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTiradas = new JLabel(et.getString("Salvacion"));
		lblTiradas.setBounds(0, 5, 126, 13);
		lblTiradas.setVerticalAlignment(SwingConstants.TOP);
		lblTiradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiradas.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		panelTiradas.add(lblTiradas);

		rdbtnDes = new JRadioButton(et.getString("Destreza"));
		rdbtnDes.setBounds(6, 39, 85, 13);
		panelTiradas.add(rdbtnDes);

		rdbtnCon = new JRadioButton(et.getString("Constitucion"));
		rdbtnCon.setBounds(6, 54, 85, 13);
		panelTiradas.add(rdbtnCon);

		rdbtnCar = new JRadioButton(et.getString("Carisma"));
		rdbtnCar.setBounds(6, 99, 85, 13);
		panelTiradas.add(rdbtnCar);

		rdbtnSab = new JRadioButton(et.getString("Sabiduria"));
		rdbtnSab.setBounds(6, 84, 85, 13);
		panelTiradas.add(rdbtnSab);

		rdbtnInt = new JRadioButton(et.getString("Inteligencia"));
		rdbtnInt.setBounds(6, 69, 85, 13);
		panelTiradas.add(rdbtnInt);

		rdbtnFue = new JRadioButton(et.getString("Fuerza"));
		rdbtnFue.setBounds(6, 24, 85, 13);
		panelTiradas.add(rdbtnFue);

		Habilidades = new PanelHabilidades(Idioma);
		Habilidades.setBackground(Color.LIGHT_GRAY);
		Habilidades.setBounds(150, 240, 300, 120);
		panelCreacion.add(Habilidades);

		btnRandom = new JButton(et.getString("Random"));
		btnRandom.setBounds(100, 125, 85, 20);
		panelCreacion.add(btnRandom);

		btnEliminar = new JButton(et.getString("Eliminar"));
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(190, 125, 85, 21);
		panelCreacion.add(btnEliminar);

		btnEditar = new JButton(et.getString("Editar"));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(280, 125, 85, 21);
		panelCreacion.add(btnEditar);

		btnCalcular = new JButton(et.getString("CalcularModificadores"));
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnCalcular.setBounds(10, 125, 85, 20);
		panelCreacion.add(btnCalcular);

		JLabel lblNivel = new JLabel(et.getString("Nivel"));
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setBounds(377, 104, 55, 14);
		panelCreacion.add(lblNivel);

		JPanel panelTirarDados = new JPanel();
		panelTirarDados.setBackground(Color.LIGHT_GRAY);
		panelTirarDados.setBounds(10, 370, 130, 120);
		panelCreacion.add(panelTirarDados);
		panelTirarDados.setLayout(null);

		JLabel lblTirarDados = new JLabel(et.getString("TirarDados"));
		lblTirarDados.setVerticalAlignment(SwingConstants.TOP);
		lblTirarDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblTirarDados.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblTirarDados.setBounds(0, 0, 130, 20);
		panelTirarDados.add(lblTirarDados);

		JLabel lblLados = new JLabel(et.getString("Lados"));
		lblLados.setVerticalAlignment(SwingConstants.TOP);
		lblLados.setHorizontalAlignment(SwingConstants.CENTER);
		lblLados.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblLados.setBounds(0, 20, 60, 20);
		panelTirarDados.add(lblLados);

		spinnerLados = new JSpinner();
		spinnerLados
				.setModel(new SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerLados.setBounds(70, 20, 60, 20);
		panelTirarDados.add(spinnerLados);

		btnTirar = new JButton(et.getString("Tirar"));
		btnTirar.setBounds(20, 90, 80, 20);
		panelTirarDados.add(btnTirar);

		scrollPersonajes = new JScrollPane();
		tabbedPane.addTab(et.getString("ver_personajes"), null, scrollPersonajes, null);
		tablePersonajes = new JTable();
		tablePersonajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPersonajes.setViewportView(tablePersonajes);

		lblTirada = new JLabel("0");
		lblTirada.setHorizontalAlignment(SwingConstants.CENTER);
		lblTirada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTirada.setBounds(40, 50, 45, 13);
		panelTirarDados.add(lblTirada);

		ImageIcon IconoImagen = new ImageIcon("src/imagenes/DndIcon.png");
		lblImagen = new JLabel("Logo");
		lblImagen.setBounds(150, 370, 300, 120);
		lblImagen.setIcon(IconoImagen);
		panelCreacion.add(lblImagen);

		btnRegistrar = new JButton(et.getString("Guardar"));
		btnRegistrar.setBounds(370, 125, 85, 21);
		panelCreacion.add(btnRegistrar);
		
		spinnerNivel = new JSpinner();
		spinnerNivel.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinnerNivel.setBounds(360, 84, 80, 20);
		panelCreacion.add(spinnerNivel);

		ManejadorBoton EscuchadorBoton = new ManejadorBoton();
		ManejadorKey EscuchadorKey = new ManejadorKey();
		//ManejadorFocus EscuchadorFocus = new ManejadorFocus();
		buscarPersonajesConTableModel();

		btnRandom.addActionListener(EscuchadorBoton);
		btnCalcular.addActionListener(EscuchadorBoton);
		btnTirar.addActionListener(EscuchadorBoton);
		rdbtnFue.addActionListener(EscuchadorBoton);
		rdbtnDes.addActionListener(EscuchadorBoton);
		rdbtnCon.addActionListener(EscuchadorBoton);
		rdbtnInt.addActionListener(EscuchadorBoton);
		rdbtnSab.addActionListener(EscuchadorBoton);
		rdbtnCar.addActionListener(EscuchadorBoton);

		btnRegistrar.addActionListener(EscuchadorBoton);
		btnEliminar.addActionListener(EscuchadorBoton);
		btnEditar.addActionListener(EscuchadorBoton);

		textNombre.addKeyListener(EscuchadorKey);
		// textTransfondo.addKeyListener(EscuchadorKey);
		textJugador.addKeyListener(EscuchadorKey);

		cargarClasesEnComboBox();
		cargarRazasEnComboBox();

		comboBoxClase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxClase.getSelectedIndex() != -1) {
					// Si hay clase seleccionada, cargar las subclases correspondientes
					cargarSubclasesEnComboBox(comboBoxClase.getSelectedItem().toString());
				} else {
					// Si no hay clase seleccionada, desactivar el JComboBox de subclase
					comboBoxSubclase.setEnabled(false);
				}
			}
		});

		tablePersonajes.getSelectionModel().addListSelectionListener(new ManejadorTabla());

		seleccionarModo(idSeleccionado);

	}

	/**
	 * Metodo SeleccionarModo Habilita o desabilita los botones de registrar, editar y eliminar, dependiendo del id ingresado
	 * Si el idSeleccionado es 0, es modo registrar, y se desabilitan editar y eliminar
	 * En caso contrario se permitira editar y eliminar, pero no guardar registros nuevos
	 * @param idSeleccionado 
	 */
	private void seleccionarModo(int idSeleccionado) {
		// TODO Auto-generated method stub
		boolean nuevoPersonaje = idSeleccionado == 0;
		comboBoxClase.setEnabled(true);
		comboBoxRaza.setEnabled(true);
		comboBoxSubclase.setEnabled(true);
		textNombre.setEnabled(nuevoPersonaje);
		btnEditar.setEnabled(!nuevoPersonaje);
		btnEditar.setVisible(!nuevoPersonaje);
		btnEliminar.setEnabled(!nuevoPersonaje);
		btnEliminar.setVisible(!nuevoPersonaje);
		btnRegistrar.setEnabled(nuevoPersonaje);
		btnRegistrar.setVisible(nuevoPersonaje);

		if (!nuevoPersonaje)
			cargarDatosPersonaje(idSeleccionado);
	}

	// Fin Hoja de Personaje

	/**
	 * Crear la clase ManejadorBoton implementando ActionListener para llevar
	 * control de los botones Controla los eventos al precionar cada boton
	 */
	private class ManejadorBoton implements ActionListener { // Manejador Botones

		// identificar que boton genera un evento

		public void actionPerformed(ActionEvent EventoBotones) {
			if (EventoBotones.getSource().equals(btnRegistrar)) {
				RegistarPersonaje();
			} // fin btnGuardar
			if (EventoBotones.getSource().equals(btnEditar)) {
				EditarPersonaje();
			} // fin btnGuardar
			if (EventoBotones.getSource() == btnEliminar) {
				eliminarPersonaje();
			}

			if (EventoBotones.getSource() == btnCalcular) {
				CalcularModificadores();
			}
			if (EventoBotones.getSource() == btnTirar) {
				System.out.println("Tirar d" + (int) spinnerLados.getValue());
				lblTirada.setText(String.valueOf(Dados((int) spinnerLados.getValue())));
			}
			if (EventoBotones.getSource() == btnRandom) {
				Estadisticas.spinnerFue.setValue(Stats());
				Estadisticas.spinnerDes.setValue(Stats());
				Estadisticas.spinnerCon.setValue(Stats());
				Estadisticas.spinnerInt.setValue(Stats());
				Estadisticas.spinnerSab.setValue(Stats());
				Estadisticas.spinnerCar.setValue(Stats());
				CalcularModificadores();
			}
			if (EventoBotones.getSource() == rdbtnFue || EventoBotones.getSource() == rdbtnDes // Seleccionar tiradas de salvacion
					|| EventoBotones.getSource() == rdbtnCon || EventoBotones.getSource() == rdbtnInt
					|| EventoBotones.getSource() == rdbtnSab || EventoBotones.getSource() == rdbtnCar) {
				if (!((AbstractButton) EventoBotones.getSource()).isSelected()) {
					TiradasSeleccionadas -= 1;
				} else if (TiradasSeleccionadas >= 2) {
					/*
					 * JOptionPane.showMessageDialog((Component) EventoBotones.getSource(),
					 * "Solo se pueden escoger 2 tiradas de salvacion", "Error",
					 * JOptionPane.ERROR_MESSAGE);
					 */
					((AbstractButton) EventoBotones.getSource()).setSelected(false);
				} else {
					TiradasSeleccionadas += 1;
				}
				System.out.println("Tiradas: " + TiradasSeleccionadas);
				CalcularModificadores();
			}

			CalcularModificadores();
		}
	} // Fin Manejador Botones

	/**
	 * Crear la clase ManejadorKey implementando KeyListener para llevar control de
	 * los teclas precionadas Controla los eventos al precionar cada tecla, y segun
	 * el componente sobre el cual se esta escribiendo
	 */
	private class ManejadorKey implements KeyListener { // Manejador Key

		public void keyTyped(KeyEvent EventKey) {

			if (EventKey.getSource() == textNombre && textNombre.getText().length() >= 30) {
				EventKey.consume();
			}
			
			if (EventKey.getSource() == textJugador || EventKey.getSource() == textTransfondo) {
				if (!Character.isLetter(EventKey.getKeyChar()) && EventKey.getKeyChar() != KeyEvent.VK_SPACE
						&& EventKey.getKeyChar() != KeyEvent.VK_BACK_SPACE
						&& EventKey.getKeyChar() != KeyEvent.VK_DELETE) {
					EventKey.consume();
				}
			}
			if (EventKey.getSource() == spinnerNivel) {
				if (!Character.isDigit(EventKey.getKeyChar()) && EventKey.getKeyChar() != KeyEvent.VK_SPACE
						&& EventKey.getKeyChar() != KeyEvent.VK_BACK_SPACE
						&& EventKey.getKeyChar() != KeyEvent.VK_DELETE) {
					EventKey.consume();
				}
				// System.out.println(EventKey.getKeyChar());
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	} // Fin Manejador Key

	
	/*
	private class ManejadorFocus implements FocusListener {

		@Override
		public void focusGained(FocusEvent EventoFocus) {
		}


	}*/

	public class ManejadorTabla implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (!e.getValueIsAdjusting() && tablePersonajes.getSelectedRow() != -1) {
				int fila = tablePersonajes.getSelectedRow(); // Obtiene la fila selecionada
				// Guardar el id seleciona del registro
				String nombreSeleccionado = tablePersonajes.getValueAt(fila, 0).toString();
				int idSeleccionado = CPersonaje.obtenerIdPersonaje(nombreSeleccionado);
				System.out.println(nombreSeleccionado + idSeleccionado);
				// EditarPersonaje VerPersonaje = new EditarPersonaje(null, true, Idioma);
				// VerPersonaje.setVisible(true);
				// VerPersonaje.cargarDatosPersonaje(nombreSeleccionado);

			}
		}

	}

	/**
	 * Metodo para registrar el personaje dentro de la tabla Personaje en la base de
	 * datos Antes de realizar el registro verifica los campos necesarios
	 */
	public void RegistarPersonaje() {

		new CPersonaje();
		if (!validarCampos()) {
			JOptionPane.showMessageDialog(null, "No se pudo crear el personaje", "Error", JOptionPane.ERROR_MESSAGE);			
			return;
		}
		try {
			OPersonaje miPersonaje = crearPersonaje();
			// Registrar el personaje
			CPersonaje.registrarPersonaje(miPersonaje);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en el Ingreso de Datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		buscarPersonajesConTableModel();

	}

	/**
	 * Metodo eliminarPersonaje Implemetado para eliminar de la base de datos al
	 * personaje seleccionado Implementa el metodo del mismo nombre en el
	 * controlador CPersonaje
	 */
	private void eliminarPersonaje() {
		try {
//	        String nombre = (String) comboBoxPersonaje.getSelectedItem();
			String nombre = textNombre.getText();
			if (nombre == null)
				return;

			// Confirmación antes de eliminar
			int confirmacion = JOptionPane.showConfirmDialog(this,
					"¿Estás seguro de que deseas eliminar este personaje?", "Confirmar eliminación",
					JOptionPane.YES_NO_OPTION);

			if (confirmacion == JOptionPane.YES_OPTION) {

				// Eliminar personaje de la base de datos
				new CPersonaje().eliminarPersonajePorNombre(nombre);
				JOptionPane.showMessageDialog(this, "Personaje eliminado correctamente.");
				buscarPersonajesConTableModel(); // Actualizar la tabla de personajes
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al eliminar personaje", "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo EditarPersonaje Actualiza los datos del personaje seleccionado, dentro
	 * de la base de datos
	 */
	public void EditarPersonaje() {
		String nombrePersonajeSeleccionado = textNombre.getText();// comboBoxPersonaje.getSelectedItem().toString();

		int idPersonaje = new CPersonaje().obtenerIdPersonaje(nombrePersonajeSeleccionado);
		if (idPersonaje == -1) {
			JOptionPane.showMessageDialog(null, "Personaje no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!validarCampos()){
			JOptionPane.showMessageDialog(null, "No se pudo editar el personaje", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		
		try {
			OPersonaje miPersonaje = crearPersonaje();
			new CPersonaje().actualizarPersonaje(miPersonaje); // Este método debe hacer UPDATE en la base

			//JOptionPane.showMessageDialog(null, "Personaje actualizado correctamente", "Éxito",
			//		JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar personaje", "Error", JOptionPane.ERROR_MESSAGE);
		}
		buscarPersonajesConTableModel();
	}

	/**
	 * Metodo Stats Calcula estadisticas aleatorias segun las reglas de Dnd 5ta
	 * edicio Genera la tirada de 4 dados d6, y suma los 3 valores mas altos
	 * 
	 * @return Regresa la suma de las 3 tiradas mas altas como Numero Entero
	 */
	public static int Stats() {
		int Suma = 0;
		int Lados = 6;
		int Tirar = 4;
		int min = Lados;
		int dados[] = new int[Tirar];
		for (int x = 0; x < Tirar; x++) {
			dados[x] = Dados(6);
			if (dados[x] < min) {
				min = dados[x];
			}
			Suma += dados[x];
		}
		Suma -= min;
		return Suma;
	}

	/**
	 * Metodo Dados Realiza una tirada aleatoria de dados, del numero de lados
	 * indicados
	 * 
	 * @param Lados Indica el numero de lados que tendra el dado simulado, es decir
	 *              el resultado maximo de la tirada
	 * @return Regresa la tirada de dado
	 */
	public static int Dados(int Lados) {
		int Tirada = 0;
		Tirada = (int) ((JdkMath.random() * Lados)) + 1;
		System.out.println(Tirada);
		return Tirada;
	}

	/**
	 * Metodo CalcularModificadores Calcula los modificacadores para cada
	 * estadistica segun las reglas de Dnd 5ta Edicion Los modificadores son el
	 * bonus que se agrega a cada tirada, dependiendo de a que estadistica
	 * corresponda se calculan como una formula de (Estadistica - 10 ) / 2 Cuando la
	 * estadistica esta a 10, es modificador esta a 0, por cada dos puntos que
	 * aumenta o disminuye, el modificado aumenta o disminuye 1 Asigna tambien el
	 * modificador de competencia de +2 a las tiradas y habilidades seleccionadas
	 */
	public void CalcularModificadores() {
		Estadisticas.CalcularModificadores();
		OEstadisticas estadisticas = Estadisticas.getEstadisticas();
		Habilidades.setEstadisticas(estadisticas);
		Habilidades.CalcularModificadores();

		/*
		 * ModFue = ((int) spinnerFue.getValue() / 2) - 5;
		 * lblModFue.setText(String.valueOf(ModFue)); ModDes = ((int)
		 * spinnerDes.getValue() - 10) / 2; lblModDes.setText(String.valueOf(ModDes));
		 * ModCon = ((int) spinnerCon.getValue() - 10) / 2;
		 * lblModCon.setText(String.valueOf(ModCon)); ModInt = ((int)
		 * spinnerInt.getValue() - 10) / 2; lblModInt.setText(String.valueOf(ModInt));
		 * ModSab = ((int) spinnerSab.getValue() - 10) / 2;
		 * lblModSab.setText(String.valueOf(ModSab)); ModCar = ((int)
		 * spinnerCar.getValue() - 10) / 2; lblModCar.setText(String.valueOf(ModCar));
		 */
		if (rdbtnFue.isSelected()) {
			lblTiradaFue.setText(String.valueOf(ModFue + 2));
		} else {
			lblTiradaFue.setText(String.valueOf(ModFue));
		}
		if (rdbtnDes.isSelected()) {
			lblTiradaDes.setText(String.valueOf(ModDes + 2));
		} else {
			lblTiradaDes.setText(String.valueOf(ModDes));
		}
		if (rdbtnCon.isSelected()) {
			lblTiradaCon.setText(String.valueOf(ModCon + 2));
		} else {
			lblTiradaCon.setText(String.valueOf(ModCon));
		}
		if (rdbtnInt.isSelected()) {
			lblTiradaInt.setText(String.valueOf(ModInt + 2));
		} else {
			lblTiradaInt.setText(String.valueOf(ModInt));
		}
		if (rdbtnSab.isSelected()) {
			lblTiradaSab.setText(String.valueOf(ModSab + 2));
		} else {
			lblTiradaSab.setText(String.valueOf(ModSab));
		}
		if (rdbtnCar.isSelected()) {
			lblTiradaCar.setText(String.valueOf(ModCar + 2));
		} else {
			lblTiradaCar.setText(String.valueOf(ModCar));
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

	/**
	 * Metodo cargarRazasEnComboBox Carga los nombres de la tabla Raza de la base de
	 * datos, y los enlista en un comboBox
	 */
	public void cargarRazasEnComboBox() {
		CRaza controladorRaza = new CRaza();
		ResultSet rs = controladorRaza.obtenerNombresRazas(); // Obtener los nombres de las razas desde la base de datos

		try {
			// Limpiar el combo box antes de agregar los elementos
			comboBoxRaza.removeAllItems();
			comboBoxRaza.addItem("Raza"); 

			// Agregar los nombres de las razas al combo box
			while (rs.next()) {
				comboBoxRaza.addItem(rs.getString("NombreRaza"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener nombres de razas", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo cargarSubclasesEnComboBox Carga los nombres de la tabla Subclase de la
	 * base de datos, cuyo idClase sea el seleccionado por el usuario, y los enlista
	 * en un comboBox
	 * 
	 * @param nombreClaseSeleccionada Ingresa el nombre de la clase seleccionada,
	 *                                cuyas subclases se buscaran
	 */
	private void cargarSubclasesEnComboBox(String nombreClaseSeleccionada) {
		int idClaseSeleccionada = new CClase().obtenerIdClasePorNombre(nombreClaseSeleccionada);

		if (idClaseSeleccionada == -1) {
			comboBoxSubclase.setEnabled(false);
			return;
		}
		try {
			comboBoxSubclase.removeAllItems();
			comboBoxSubclase.addItem("Subclase"); // Placeholder
			ResultSet rs = new CSubclase().obtenerNombresSubclases(idClaseSeleccionada);
			while (rs.next()) {
				comboBoxSubclase.addItem(rs.getString("Nombre"));
			}
			comboBoxSubclase.setEnabled(comboBoxSubclase.getItemCount() > 1); // Habilitar si hay subclases
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar las subclases", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo para mostrar la tabla de personajes mediante una consulta a la base de
	 * datos Implementa el metodo del mismo nombre dentro de CPersonaje, y crea un
	 * TableModel
	 */
	private void buscarPersonajesConTableModel() {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablePersonajes.setModel(model);

		// Definir columnas según la consulta SQL
		model.addColumn("Id");
		model.addColumn("Nombre");
		model.addColumn("Nivel");
		model.addColumn("Clase");
		model.addColumn("Subclase");
		model.addColumn("Raza");

		tablePersonajes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablePersonajes.getTableHeader().setReorderingAllowed(false);

		CPersonaje miPersonaje = new CPersonaje();
		miPersonaje.buscarPersonajesConTableModel(model); // Llenar la tabla con los datos de la BD

		scrollPersonajes.setViewportView(tablePersonajes);
	}

	/**
	 * Metodo crearPersonaje crea un objeto OPersonaje con los datos ingresados por
	 * el usuario
	 * 
	 * @return El objeto OPersonaje creado
	 */
	private OPersonaje crearPersonaje() {
		OPersonaje miPersonaje = new OPersonaje();
		OEstadisticas estadisticas = Estadisticas.getEstadisticas();
		
		miPersonaje.setFuerza(estadisticas.getFuerza());
		miPersonaje.setDestreza(estadisticas.getDestreza());
		miPersonaje.setConstitucion(estadisticas.getConstitucion());
		miPersonaje.setInteligencia(estadisticas.getInteligencia());
		miPersonaje.setSabiduria(estadisticas.getSabiduria());
		miPersonaje.setCarisma(estadisticas.getSabiduria());
		
		//miPersonaje.setId_Personaje(idPersonaje);
		miPersonaje.setNombrePersonaje(textNombre.getText());

		// Obtener el ID de la clase seleccionada
		String claseSeleccionada = comboBoxClase.getSelectedItem().toString();
		if (!claseSeleccionada.equals("Clase")) {
			miPersonaje.setId_Clase(new CClase().obtenerIdClasePorNombre(claseSeleccionada));
		} else {
			miPersonaje.setId_Clase(-1); // No tiene subclase
		}
		
		// Obtener el ID de la raza seleccionada
		String razaSeleccionada = comboBoxRaza.getSelectedItem().toString();
		if (!razaSeleccionada.equals("Raza")) {
			miPersonaje.setId_Raza(new CRaza().obtenerIdRazaPorNombre(razaSeleccionada));
		} else {
			miPersonaje.setId_Raza(-1); // No tiene subclase
		}

		// Obtener el ID de la subclase seleccionada (si hay)
		String subclaseSeleccionada =comboBoxSubclase.getSelectedItem().toString();
		if (!subclaseSeleccionada.equals("Subclase")) {
			miPersonaje.setId_Subclase(new CSubclase().obtenerIdSubclasePorNombre(subclaseSeleccionada));
		} else {
			miPersonaje.setId_Subclase(-1); // No tiene subclase
		}

		miPersonaje.setNivel((int) spinnerNivel.getValue());
		miPersonaje.setBonusCompetencia(2); // Se puede ajustar según nivel
		miPersonaje.setId_EstadisticasPersonaje(1); // Definir correctamente

		return miPersonaje;

	}
	
	public boolean validarCampos() {
		boolean completo = true;
		// Validación de campos vacíos
		if (textNombre.getText().isEmpty() || textNombre.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "El nombre del personaje no puede estar vacío", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false; // No continuar con la ejecución si el campo está vacío
		}
		if (textNombre.getText().length() > 30) {
			JOptionPane.showMessageDialog(null, "El nombre del personaje es demasiado largo. Maximo 30 caracteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false; // No continuar con la ejecución si el campo está vacío
		}

		if (textJugador.getText().isEmpty() || textJugador.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "El nombre del jugador no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
			return false; // No continuar con la ejecución si el campo está vacío
		}

		
		return true;

	}

	/**
	 * Metodo cargarDatosPersonaje Metodo para cargar los datos del personaje
	 * seleccionado Llena los campos de los componentes correspondientes, con los
	 * datos de personaje obtenido de la base de datos
	 */
	public void cargarDatosPersonaje(int idPersonajeSeleccionado) {
		// Obtener el ID del personaje basado en su nombre
		// int idPersonajeSeleccionado = new
		// CPersonaje().obtenerIdPersonaje(nombrePersonajeSeleccionado);
		try {
			OPersonaje personaje = CPersonaje.obtenerPersonajePorId(idPersonajeSeleccionado);

			// Rellenar los campos con los datos del personaje
			textNombre.setText(personaje.getNombrePersonaje());
			spinnerNivel.setValue(personaje.getNivel());

			// Rellenar los JComboBox con los nombres correspondientes
			comboBoxClase.setSelectedItem(new CClase().obtenerNombreClasePorId(personaje.getId_Clase()));
			comboBoxRaza.setSelectedItem(new CRaza().obtenerNombreRazaPorId(personaje.getId_Raza()));

			// Cargar las subclases y seleccionar la correspondiente
			cargarSubclasesEnComboBox(comboBoxClase.getSelectedItem().toString());
			comboBoxSubclase.setSelectedItem(new CSubclase().obtenerNombreSubclasePorId(personaje.getId_Subclase()));

			// Rellenar los valores de las estadísticas
			Estadisticas.spinnerFue.setValue(personaje.getFuerza());
			Estadisticas.spinnerDes.setValue(personaje.getDestreza());
			Estadisticas.spinnerCon.setValue(personaje.getConstitucion());
			Estadisticas.spinnerInt.setValue(personaje.getInteligencia());
			Estadisticas.spinnerSab.setValue(personaje.getSabiduria());
			Estadisticas.spinnerCar.setValue(personaje.getCarisma());

			// Habilitar los ComboBoxes de Raza, Clase y Subclase
			comboBoxClase.setEnabled(true);
			comboBoxRaza.setEnabled(true);
			comboBoxSubclase.setEnabled(true);
			btnEditar.setEnabled(true);
			btnEliminar.setEnabled(true);

			CalcularModificadores();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los datos del personaje", "Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
