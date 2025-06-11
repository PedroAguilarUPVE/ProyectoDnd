
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.table.DefaultTableModel;

import org.apache.commons.math4.core.jdkmath.JdkMath;

import com.PlaceHolder;

import controladores.CClase;
import controladores.CPersonaje;
import controladores.CRaza;
import controladores.CSubclase;
import modelos.OEstadisticas;
import modelos.OPersonaje;

/**
 * Clase de la ventana crear personaje
 */
public class CrearPersonaje extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelGeneral;
	private JTextField textNombre;
	private JLabel lblRaza;
	private JLabel lblTransfondo;
	private JTextField textTransfondo;
	private JLabel lblExperiencia;
	private JTextField textExperiencia;
	private JLabel lblModFue;
	private JPanel panelDestreza;
	private JLabel lblModDes;
	private JLabel lblFue;
	private JLabel lblDes;
	private JPanel panelInteligencia;
	private JLabel lblModInt;
	private JLabel lblInt;
	private JLabel lblModCon;
	private JLabel lblCon;
	private JPanel panelCarisma;
	private JLabel lblModCar;
	private JLabel lblCar;
	private JPanel panelSabiduria;
	private JLabel lblModSab;
	private JLabel lblSab;
	private JLabel lblTiradaDes;
	private JLabel lblTiradaCon;
	private JLabel lblTiradaCar;
	private JLabel lblTiradaSab;
	private JLabel lblTiradaInt;
	private JLabel lblPercepcion;
	private JLabel lblNaturaleza;
	private JLabel lblMedicina;
	private JLabel lblManos;
	private JLabel lblInvestigacion;
	private JLabel lblIntimidacion;
	private JRadioButton rdbtnPercepcion;
	private JRadioButton rdbtnNaturaleza;
	private JRadioButton rdbtnMedicina;
	private JRadioButton rdbtnManos;
	private JRadioButton rdbtnInvestigacion;
	private JRadioButton rdbtnPerspicacia;
	private JRadioButton rdbtnPersuacion;
	private JRadioButton rdbtnReligion;
	private JRadioButton rdbtnSigilo;
	private JRadioButton rdbtnSupervivencia;
	private JRadioButton rdbtnTratoAnimal;
	private JLabel lblTratoAnimal;
	private JLabel lblSupervivencia;
	private JLabel lblSigilo;
	private JLabel lblReligion;
	private JLabel lblPersuacion;
	private JLabel lblPerspicacia;
	private JSpinner spinnerFue;
	private JLabel lblTiradaFue;
	//private JSpinner spinnerDes;
	//private JSpinner spinnerCon;
	//private JSpinner spinnerInt;
	//private JSpinner spinnerSab;
	//private JSpinner spinnerCar;

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
	private JRadioButton rdbtnAcrobacias;
	private JRadioButton rdbtnAtletismo;
	private JRadioButton rdbtnArcano;
	private JRadioButton rdbtnEngano;
	private JRadioButton rdbtnHistoria;
	private JRadioButton rdbtnInterpretacion;
	private JRadioButton rdbtnIntimidacion;
	private JLabel lblEngano;
	private JLabel lblArcano;
	private JLabel lblHistoria;
	private JLabel lblInterpretacion;
	private JLabel lblAtletismo;
	private JLabel lblAcrobacias;
	private JLabel lblHabilidades;
	private JTextField textNivel;
	private JComboBox<String> comboBoxRaza;
	private JComboBox<String> comboBoxClase;
	private PlaceHolder Etiquetas;
	private JTextField textJugador;
	private JLabel lblTirada;
	private JSpinner spinnerLados;
	private JButton btnTirar;
	private JLabel lblImagen;
	private JPanel panelFuerza;
	private JPanel panelConstitucion;
	private JButton btnGuardar;
	private JComboBox comboBoxSubclase;
	private JPanel contentPane;
	private PanelHabilidades Habilidades;
	private PanelEstadisticas Estadisticas;

	private static Locale Idioma;
	private static ResourceBundle et;
	private JScrollPane scrollPersonajes;
	private JTable tablePersonajes;

	/**
	 * Constructor de la ventana de creacion de personajes
	 * Se crea como ventana hija de la ventana menu
	 * 
	 * @param parent Clase Frame Indica el componente padre de de la ventana CrearPersonaje
	 * @param modal  Clase boolean Indica el modo de sobreposicion de la ventana hija
	 * @param Idioma Clase Locale Hereda el parametro tipo Locale de la clase padre, para la
	 *               seleccion de idioma
	 */
	public CrearPersonaje(Frame parent, boolean modal, Locale Idioma) { // Hoja De Personaje
		super(parent, modal);// se inicializa el constructor super
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Obtener el idioma por defecto del sistema
		// Idioma = Locale.getDefault(); // Idioma de sistema

		// Idioma = new Locale("en","US"); //Ahora en ingles americano

		System.out.println(Idioma.getDisplayName()); // Mostrar el nombre del idioma obtenido
		System.out.println("====================");

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

		/*
		 * textTransfondo = new JTextField(); textTransfondo.setColumns(10);
		 * textTransfondo.setBounds(10, 84, 120, 20); contentPane.add(textTransfondo);
		 */

		lblExperiencia = new JLabel(et.getString("Experiencia"));
		lblExperiencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblExperiencia.setBounds(312, 103, 55, 14);
		panelCreacion.add(lblExperiencia);

		textExperiencia = new JTextField();
		textExperiencia.setColumns(10);
		textExperiencia.setBounds(312, 84, 55, 20);
		panelCreacion.add(textExperiencia);

		comboBoxClase = new JComboBox();
		comboBoxClase.setBounds(160, 37, 120, 20);
		panelCreacion.add(comboBoxClase);
		cargarClasesEnComboBox();

		comboBoxRaza = new JComboBox();
		comboBoxRaza.setBounds(159, 84, 120, 20);
		panelCreacion.add(comboBoxRaza);
		cargarRazasEnComboBox();

		comboBoxSubclase = new JComboBox();
		comboBoxSubclase.setBounds(10, 84, 120, 20); // Ajuste de la ubicación y tamano
		panelCreacion.add(comboBoxSubclase);
		comboBoxSubclase.addItem("Subclase");
		comboBoxSubclase.setEnabled(false); // Desactivar inicialmente
		
		Estadisticas = new PanelEstadisticas(Idioma);
		Estadisticas.setBounds(10,155 , 410,75);
		panelCreacion.add(Estadisticas);

		JLabel lblEstadisticas = new JLabel(et.getString("Estadisticas"));
		lblEstadisticas.setVerticalAlignment(SwingConstants.TOP);
		lblEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticas.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblEstadisticas.setBounds(170, 128, 96, 14);
		panelCreacion.add(lblEstadisticas);

		
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
		Habilidades.setBackground(Color.LIGHT_GRAY); Habilidades.setBounds(150, 240,
		300, 120); panelCreacion.add(Habilidades);
		

		btnRandom = new JButton(et.getString("Random"));
		btnRandom.setBounds(259, 126, 85, 21);
		panelCreacion.add(btnRandom);

		btnCalcular = new JButton(et.getString("CalcularModificadores"));
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnCalcular.setBounds(10, 126, 130, 21);
		panelCreacion.add(btnCalcular);

		textNivel = new JTextField();
		textNivel.setEditable(false);
		textNivel.setColumns(10);
		textNivel.setBounds(377, 84, 55, 20);
		panelCreacion.add(textNivel);

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

		lblTirada = new JLabel("0");
		lblTirada.setHorizontalAlignment(SwingConstants.CENTER);
		lblTirada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTirada.setBounds(40, 50, 45, 13);
		panelTirarDados.add(lblTirada);

		lblImagen = new JLabel("Logo");
		lblImagen.setBounds(150, 370, 300, 120);
		ImageIcon IconoImagen = new ImageIcon("src/imagenes/DndIcon.png");
		lblImagen.setIcon(IconoImagen);
		panelCreacion.add(lblImagen);

		btnGuardar = new JButton(et.getString("Guardar"));
		btnGuardar.setBounds(360, 125, 85, 21);
		panelCreacion.add(btnGuardar);

		scrollPersonajes = new JScrollPane();
		tabbedPane.addTab(et.getString("ver_personajes"), null, scrollPersonajes, null);
		tablePersonajes = new JTable();
		scrollPersonajes.setViewportView(tablePersonajes);
		buscarPersonajesConTableModel();

		ManejadorBoton EscuchadorBoton = new ManejadorBoton();

		btnRandom.addActionListener(EscuchadorBoton);
		btnCalcular.addActionListener(EscuchadorBoton);
		btnTirar.addActionListener(EscuchadorBoton);
		rdbtnFue.addActionListener(EscuchadorBoton);
		rdbtnDes.addActionListener(EscuchadorBoton);
		rdbtnCon.addActionListener(EscuchadorBoton);
		rdbtnInt.addActionListener(EscuchadorBoton);
		rdbtnSab.addActionListener(EscuchadorBoton);
		rdbtnCar.addActionListener(EscuchadorBoton);
		btnGuardar.addActionListener(EscuchadorBoton);

		rdbtnAcrobacias.addActionListener(EscuchadorBoton);
		rdbtnAtletismo.addActionListener(EscuchadorBoton);
		rdbtnArcano.addActionListener(EscuchadorBoton);
		rdbtnEngano.addActionListener(EscuchadorBoton);
		rdbtnHistoria.addActionListener(EscuchadorBoton);
		rdbtnInterpretacion.addActionListener(EscuchadorBoton);

		rdbtnIntimidacion.addActionListener(EscuchadorBoton);
		rdbtnInvestigacion.addActionListener(EscuchadorBoton);
		rdbtnManos.addActionListener(EscuchadorBoton);
		rdbtnMedicina.addActionListener(EscuchadorBoton);
		rdbtnNaturaleza.addActionListener(EscuchadorBoton);
		rdbtnPercepcion.addActionListener(EscuchadorBoton);

		rdbtnPerspicacia.addActionListener(EscuchadorBoton);
		rdbtnPersuacion.addActionListener(EscuchadorBoton);
		rdbtnReligion.addActionListener(EscuchadorBoton);
		rdbtnSigilo.addActionListener(EscuchadorBoton);
		rdbtnSupervivencia.addActionListener(EscuchadorBoton);
		rdbtnTratoAnimal.addActionListener(EscuchadorBoton);

		ManejadorKey EscuchadorKey = new ManejadorKey();

		textNombre.addKeyListener(EscuchadorKey);
		// textTransfondo.addKeyListener(EscuchadorKey);
		textJugador.addKeyListener(EscuchadorKey);
		textExperiencia.addKeyListener(EscuchadorKey);

		ManejadorFocus EscuchadorFocus = new ManejadorFocus();
		textExperiencia.addFocusListener(EscuchadorFocus);

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

	}

	// Fin Hoja de Personaje
	
	/**
	 * Crear la clase ManejadorBoton implementando ActionListener para llevar control de los botones
	 * Controla los eventos al precionar cada boton
	 */
	private class ManejadorBoton implements ActionListener { // Manejador Botones

		// identificar que boton genera un evento

		public void actionPerformed(ActionEvent EventoBotones) {
			if (EventoBotones.getSource().equals(btnGuardar)) {
				GuardarPersonaje();
			} // fin btnGuardar

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
			if (EventoBotones.getSource() == rdbtnFue || EventoBotones.getSource() == rdbtnDes // Seleccionar tiradas de
																								// salvacion
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
			if (EventoBotones.getSource() == rdbtnAcrobacias || EventoBotones.getSource() == rdbtnAtletismo // Selecionar
																											// habilidades
					|| EventoBotones.getSource() == rdbtnHistoria || EventoBotones.getSource() == rdbtnArcano
					|| EventoBotones.getSource() == rdbtnInterpretacion || EventoBotones.getSource() == rdbtnEngano
					|| EventoBotones.getSource() == rdbtnIntimidacion || EventoBotones.getSource() == rdbtnPercepcion
					|| EventoBotones.getSource() == rdbtnNaturaleza || EventoBotones.getSource() == rdbtnMedicina
					|| EventoBotones.getSource() == rdbtnManos || EventoBotones.getSource() == rdbtnInvestigacion
					|| EventoBotones.getSource() == rdbtnPerspicacia || EventoBotones.getSource() == rdbtnPersuacion
					|| EventoBotones.getSource() == rdbtnReligion || EventoBotones.getSource() == rdbtnSigilo
					|| EventoBotones.getSource() == rdbtnSupervivencia
					|| EventoBotones.getSource() == rdbtnTratoAnimal) {
				if (!((AbstractButton) EventoBotones.getSource()).isSelected()) {
					HabilidadesSeleccionadas -= 1;
				} else if (HabilidadesSeleccionadas >= 4) {
					/*
					 * JOptionPane.showMessageDialog((Component) EventoBotones.getSource(),
					 * "Solo se pueden escoger 4 habilidades", "Error", JOptionPane.ERROR_MESSAGE);
					 */
					((AbstractButton) EventoBotones.getSource()).setSelected(false);
				} else {
					HabilidadesSeleccionadas += 1;
				}
				System.out.println("Habilidades: " + HabilidadesSeleccionadas);
			}
			CalcularModificadores();
		}
	} // Fin Manejador Botones

	/**
	 * Crear la clase ManejadorKey implementando KeyListener para llevar control de los teclas precionadas
	 * Controla los eventos al precionar cada tecla, y segun el componente sobre el cual se esta escribiendo
	 */
	private class ManejadorKey implements KeyListener { // Manejador Key

		public void keyTyped(KeyEvent EventKey) {

			if (EventKey.getSource() == textJugador || EventKey.getSource() == textTransfondo) {
				if (!Character.isLetter(EventKey.getKeyChar()) && EventKey.getKeyChar() != KeyEvent.VK_SPACE
						&& EventKey.getKeyChar() != KeyEvent.VK_BACK_SPACE
						&& EventKey.getKeyChar() != KeyEvent.VK_DELETE) {
					EventKey.consume();
				}
			}
			if (EventKey.getSource() == textExperiencia) {
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

	private class ManejadorFocus implements FocusListener {

		@Override
		public void focusGained(FocusEvent EventoFocus) {
		}
		@Override
		public void focusLost(FocusEvent EventoFocus) {
			if (EventoFocus.getSource() == textExperiencia) {
				textNivel.setText(String.valueOf((Integer.parseInt(textExperiencia.getText())) / 1000));
			}
		}

	}



	/**
	 * Metodo para registrar el personaje dentro de la tabla Personaje en la base de
	 * datos Antes de realizar el registro verifica los campos necesarios
	 */
	public void GuardarPersonaje() {

		// Validación de campos vacíos
		if (textNombre.getText().isEmpty() || textNombre.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "El nombre del personaje no puede estar vacío", "Error",
					JOptionPane.ERROR_MESSAGE);
			return; // No continuar con la ejecución si el campo está vacío
		}

		if (textJugador.getText().isEmpty() || textJugador.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "El nombre del jugador no puede estar vacío", "Error",
					JOptionPane.ERROR_MESSAGE);
			return; // No continuar con la ejecución si el campo está vacío
		}

		if (textExperiencia.getText().isEmpty() || textExperiencia.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "La experiencia no puede estar vacía", "Error",
					JOptionPane.ERROR_MESSAGE);
			return; // No continuar con la ejecución si el campo está vacío
		}

		if (textNivel.getText().isEmpty() || textNivel.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "El nivel no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
			return; // No continuar con la ejecución si el campo está vacío
		}

		// Identificar la acción realizada en el JFileChooser (cerrar, guardar,
		// cancelar, etc.)
		// Crear y registrar el objeto Personaje
		CPersonaje miPersonajeDao = new CPersonaje();
		try {
			OPersonaje miPersonaje = crearPersonaje();

			miPersonaje.setNombrePersonaje(textNombre.getText());

			// Obtener el ID de la clase seleccionada
			String claseSeleccionada = (String) comboBoxClase.getSelectedItem();
			miPersonaje.setId_Clase(new CClase().obtenerIdClase(claseSeleccionada));

			// Obtener el ID de la raza seleccionada
			String razaSeleccionada = (String) comboBoxRaza.getSelectedItem();
			miPersonaje.setId_Raza(new CRaza().obtenerIdRazaPorNombre(razaSeleccionada));

			// Obtener el ID de la subclase seleccionada (si hay)
			String subclaseSeleccionada = (String) comboBoxSubclase.getSelectedItem();
			if (!subclaseSeleccionada.equals("Subclase")) {
				miPersonaje.setId_Subclase(new CSubclase().obtenerIdSubclasePorNombre(subclaseSeleccionada));
			} else {
				miPersonaje.setId_Subclase(-1); // No tiene subclase
			}

			miPersonaje.setNivel(Integer.parseInt(textNivel.getText()));
			miPersonaje.setBonusCompetencia(2); // Se puede ajustar según nivel
			miPersonaje.setId_EstadisticasPersonaje(1); // Definir correctamente

			// Asignar estadísticas desde los panelEstadisticas
			OEstadisticas estadisticas = Estadisticas.getEstadisticas();
			
			miPersonaje.setFuerza(estadisticas.getFuerza());
			miPersonaje.setDestreza(estadisticas.getDestreza());
			miPersonaje.setConstitucion(estadisticas.getConstitucion());
			miPersonaje.setInteligencia(estadisticas.getInteligencia());
			miPersonaje.setSabiduria(estadisticas.getSabiduria());
			miPersonaje.setCarisma(estadisticas.getCarisma());

			// Registrar el personaje
			CPersonaje.registrarPersonaje(miPersonaje);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en el Ingreso de Datos", "Error", JOptionPane.ERROR_MESSAGE);
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
			dados[x] = ((int) (JdkMath.random() * 6)) + 1;
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
	 * Metodo CalcularModificadores Calcula los modificacadores para cada estadistica segun las reglas de Dnd 5ta
	 * Edicion Los modificadores son el bonus que se agrega a cada tirada,
	 * dependiendo de a que estadistica corresponda se calculan como una formula de
	 * (Estadistica - 10 ) / 2 Cuando la estadistica esta a 10, es modificador esta
	 * a 0, por cada dos puntos que aumenta o disminuye, el modificado aumenta o
	 * disminuye 1 Asigna tambien el modificador de competencia de +2 a las tiradas
	 * y habilidades seleccionadas
	 */
	public void CalcularModificadores() {
		Estadisticas.CalcularModificadores();
		OEstadisticas estadisticas = Estadisticas.getEstadisticas(); 
		Habilidades.setEstadisticas(estadisticas);
		Habilidades.CalcularModificadores();
		
		/*
		ModFue = ((int) spinnerFue.getValue() / 2) - 5;
		lblModFue.setText(String.valueOf(ModFue));
		ModDes = ((int) spinnerDes.getValue() - 10) / 2;
		lblModDes.setText(String.valueOf(ModDes));
		ModCon = ((int) spinnerCon.getValue() - 10) / 2;
		lblModCon.setText(String.valueOf(ModCon));
		ModInt = ((int) spinnerInt.getValue() - 10) / 2;
		lblModInt.setText(String.valueOf(ModInt));
		ModSab = ((int) spinnerSab.getValue() - 10) / 2;
		lblModSab.setText(String.valueOf(ModSab));
		ModCar = ((int) spinnerCar.getValue() - 10) / 2;
		lblModCar.setText(String.valueOf(ModCar));
		*/	/*
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
		 */
	}
		
	/**
	 * Metodo cargarClasesEnComboBox Carga los nombres de la tabla Clases de la
	 * base de datos, y los enlista en un comboBox
	 */
	private void cargarClasesEnComboBox() {
		CClase cClase = new CClase();
		ResultSet rs = cClase.obtenerNombresClases();

		try {
			while (rs.next()) {
				comboBoxClase.addItem(rs.getString("NombreClase"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar clases en el ComboBox", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo cargarRazasEnComboBox Carga los nombres de la tabla Raza de la base
	 * de datos, y los enlista en un comboBox
	 */
	public void cargarRazasEnComboBox() {
		CRaza controladorRaza = new CRaza();
		ResultSet rs = controladorRaza.obtenerNombresRazas(); // Obtener los nombres de las razas desde la base de datos

		try {
			// Limpiar el combo box antes de agregar los elementos
			comboBoxRaza.removeAllItems();

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
		int idClaseSeleccionada = new CClase().obtenerIdClase(nombreClaseSeleccionada);

		if (idClaseSeleccionada == -1) {
			comboBoxSubclase.setEnabled(false);
			return;
		}

		try {
			comboBoxSubclase.removeAllItems();
			comboBoxSubclase.addItem("Subclase"); // Placeholder

			ResultSet rs = new CSubclase().obtenerNombresSubclases(idClaseSeleccionada);
			while (rs.next()) {
				comboBoxSubclase.addItem(rs.getString("NombreSubclase"));
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
		DefaultTableModel model = new DefaultTableModel();
		tablePersonajes = new JTable();
		tablePersonajes.setModel(model);

		// Definir columnas según la consulta SQL
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
	 * Metodo crearPersonaje crea un objeto OPersonaje con los datos ingresados por el usuario 
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
		miPersonaje.setNombrePersonaje(textNombre.getText());

		// Obtener el ID de la clase seleccionada
		String claseSeleccionada = (String) comboBoxClase.getSelectedItem();
		miPersonaje.setId_Clase(new CClase().obtenerIdClase(claseSeleccionada));

		// Obtener el ID de la raza seleccionada
		String razaSeleccionada = (String) comboBoxRaza.getSelectedItem();
		miPersonaje.setId_Raza(new CRaza().obtenerIdRazaPorNombre(razaSeleccionada));

		// Obtener el ID de la subclase seleccionada (si hay)
		String subclaseSeleccionada = (String) comboBoxSubclase.getSelectedItem();
		if (!subclaseSeleccionada.equals("Subclase")) {
			miPersonaje.setId_Subclase(new CSubclase().obtenerIdSubclasePorNombre(subclaseSeleccionada));
		} else {
			miPersonaje.setId_Subclase(-1); // No tiene subclase
		}

		miPersonaje.setNivel(Integer.parseInt(textNivel.getText()));
		miPersonaje.setBonusCompetencia(2); // Se puede ajustar según nivel
		miPersonaje.setId_EstadisticasPersonaje(1); // Definir correctamente

		
		return miPersonaje;
		
	}
}
