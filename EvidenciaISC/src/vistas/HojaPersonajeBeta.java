
package vistas;

import java.awt.Color;
import java.awt.EventQueue;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.math4.core.jdkmath.JdkMath;

import com.PlaceHolder;

import controladores.CClase;
import controladores.CPersonaje;
import controladores.CRaza;
import controladores.CSubclase;
import modelos.OPersonaje;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class HojaPersonajeBeta extends JDialog {

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
	private JSpinner spinnerDes;
	private JSpinner spinnerCon;
	private JSpinner spinnerInt;
	private JSpinner spinnerSab;
	private JSpinner spinnerCar;

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
	private JRadioButton rdbtnEngaño;
	private JRadioButton rdbtnHistoria;
	private JRadioButton rdbtnInterpretacion;
	private JRadioButton rdbtnIntimidacion;
	private JLabel lblEngaño;
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

	private static Locale Idioma;
	private static ResourceBundle et;
	private JScrollPane scrollPersonajes;
	private JTable tablePersonajes;

	/**
	 * Launch the application. public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * HojaPersonaje frame = new HojaPersonaje(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 * 
	 * @param idioma2
	 * @param b
	 * @param menu
	 */
	public HojaPersonajeBeta(Frame parent, boolean modal, Locale Idioma) { // Hoja De Personaje
		super(parent, modal);// se inicializa el constructor super
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Obtener el idioma por defecto del sistema
		Idioma = Locale.getDefault(); // Idioma de sistema

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
		tabbedPane.addTab("Crear Jugador", null, panelCreacion, "Información del personaje");

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
		comboBoxSubclase.setBounds(10, 84, 120, 20); // Ajuste de la ubicación y tamaño
		panelCreacion.add(comboBoxSubclase);
		comboBoxSubclase.addItem("Subclase");
		comboBoxSubclase.setEnabled(false); // Desactivar inicialmente

		JLabel lblEstadisticas = new JLabel(et.getString("Estadisticas"));
		lblEstadisticas.setVerticalAlignment(SwingConstants.TOP);
		lblEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticas.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblEstadisticas.setBounds(170, 128, 96, 14);
		panelCreacion.add(lblEstadisticas);

		panelFuerza = new JPanel();
		panelFuerza.setBackground(new Color(192, 192, 192));
		panelFuerza.setBounds(10, 155, 60, 75);
		panelCreacion.add(panelFuerza);
		panelFuerza.setLayout(null);

		lblModFue = new JLabel("0");
		lblModFue.setBounds(10, 11, 45, 20);
		lblModFue.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModFue.setHorizontalAlignment(SwingConstants.CENTER);
		panelFuerza.add(lblModFue);

		lblFue = new JLabel(et.getString("Fuerza"));
		lblFue.setVerticalAlignment(SwingConstants.TOP);
		lblFue.setHorizontalAlignment(SwingConstants.CENTER);
		lblFue.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblFue.setBounds(0, 59, 57, 14);
		panelFuerza.add(lblFue);

		spinnerFue = new JSpinner();
		spinnerFue.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerFue.setBounds(10, 30, 47, 20);
		panelFuerza.add(spinnerFue);

		panelDestreza = new JPanel();
		panelDestreza.setLayout(null);
		panelDestreza.setBackground(Color.LIGHT_GRAY);
		panelDestreza.setBounds(80, 155, 60, 75);
		panelCreacion.add(panelDestreza);

		lblModDes = new JLabel("0");
		lblModDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblModDes.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModDes.setBounds(10, 11, 43, 20);
		panelDestreza.add(lblModDes);

		lblDes = new JLabel(et.getString("Destreza"));
		lblDes.setVerticalAlignment(SwingConstants.TOP);
		lblDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDes.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblDes.setBounds(0, 59, 57, 14);
		panelDestreza.add(lblDes);

		spinnerDes = new JSpinner();
		spinnerDes.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerDes.setBounds(10, 30, 47, 20);
		panelDestreza.add(spinnerDes);

		panelInteligencia = new JPanel();
		panelInteligencia.setLayout(null);
		panelInteligencia.setBackground(Color.LIGHT_GRAY);
		panelInteligencia.setBounds(220, 155, 60, 75);
		panelCreacion.add(panelInteligencia);

		lblModInt = new JLabel("0");
		lblModInt.setHorizontalAlignment(SwingConstants.CENTER);
		lblModInt.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModInt.setBounds(10, 11, 47, 20);
		panelInteligencia.add(lblModInt);

		lblInt = new JLabel(et.getString("Inteligencia"));
		lblInt.setVerticalAlignment(SwingConstants.TOP);
		lblInt.setHorizontalAlignment(SwingConstants.CENTER);
		lblInt.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblInt.setBounds(0, 59, 63, 14);
		panelInteligencia.add(lblInt);

		spinnerInt = new JSpinner();
		spinnerInt.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerInt.setBounds(10, 30, 47, 20);
		panelInteligencia.add(spinnerInt);

		panelConstitucion = new JPanel();
		panelConstitucion.setLayout(null);
		panelConstitucion.setBackground(Color.LIGHT_GRAY);
		panelConstitucion.setBounds(150, 155, 60, 75);
		panelCreacion.add(panelConstitucion);

		lblModCon = new JLabel("0");
		lblModCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblModCon.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModCon.setBounds(10, 11, 43, 20);
		panelConstitucion.add(lblModCon);

		lblCon = new JLabel(et.getString("Constitucion"));
		lblCon.setVerticalAlignment(SwingConstants.TOP);
		lblCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblCon.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		lblCon.setBounds(0, 59, 63, 14);
		panelConstitucion.add(lblCon);

		spinnerCon = new JSpinner();
		spinnerCon.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerCon.setBounds(10, 30, 47, 20);
		panelConstitucion.add(spinnerCon);

		panelCarisma = new JPanel();
		panelCarisma.setLayout(null);
		panelCarisma.setBackground(Color.LIGHT_GRAY);
		panelCarisma.setBounds(360, 155, 60, 75);
		panelCreacion.add(panelCarisma);

		lblModCar = new JLabel("0");
		lblModCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModCar.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModCar.setBounds(10, 11, 47, 20);
		panelCarisma.add(lblModCar);

		lblCar = new JLabel(et.getString("Carisma"));
		lblCar.setVerticalAlignment(SwingConstants.TOP);
		lblCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCar.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblCar.setBounds(0, 59, 57, 14);
		panelCarisma.add(lblCar);

		spinnerCar = new JSpinner();
		spinnerCar.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerCar.setBounds(10, 30, 47, 20);
		panelCarisma.add(spinnerCar);

		panelSabiduria = new JPanel();
		panelSabiduria.setLayout(null);
		panelSabiduria.setBackground(Color.LIGHT_GRAY);
		panelSabiduria.setBounds(290, 155, 60, 75);
		panelCreacion.add(panelSabiduria);

		lblModSab = new JLabel("0");
		lblModSab.setHorizontalAlignment(SwingConstants.CENTER);
		lblModSab.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModSab.setBounds(10, 11, 47, 20);
		panelSabiduria.add(lblModSab);

		lblSab = new JLabel(et.getString("Sabiduria"));
		lblSab.setVerticalAlignment(SwingConstants.TOP);
		lblSab.setHorizontalAlignment(SwingConstants.CENTER);
		lblSab.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblSab.setBounds(0, 59, 57, 14);
		panelSabiduria.add(lblSab);

		spinnerSab = new JSpinner();
		spinnerSab.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerSab.setBounds(10, 30, 47, 20);
		panelSabiduria.add(spinnerSab);

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

		JPanel panelHabilidades = new JPanel();
		panelHabilidades.setLayout(null);
		panelHabilidades.setBackground(Color.LIGHT_GRAY);
		panelHabilidades.setBounds(150, 240, 300, 120);
		panelCreacion.add(panelHabilidades);

		lblEngaño = new JLabel("0");
		lblEngaño.setHorizontalAlignment(SwingConstants.CENTER);
		lblEngaño.setBounds(85, 73, 16, 13);
		panelHabilidades.add(lblEngaño);

		lblArcano = new JLabel("0");
		lblArcano.setHorizontalAlignment(SwingConstants.CENTER);
		lblArcano.setBounds(85, 57, 16, 13);
		panelHabilidades.add(lblArcano);

		lblHistoria = new JLabel("0");
		lblHistoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoria.setBounds(85, 87, 16, 13);
		panelHabilidades.add(lblHistoria);

		lblInterpretacion = new JLabel("0");
		lblInterpretacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterpretacion.setBounds(85, 102, 16, 13);
		panelHabilidades.add(lblInterpretacion);

		lblAtletismo = new JLabel("0");
		lblAtletismo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtletismo.setBounds(85, 42, 16, 13);
		panelHabilidades.add(lblAtletismo);

		lblAcrobacias = new JLabel("0");
		lblAcrobacias.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcrobacias.setBounds(85, 28, 16, 13);
		panelHabilidades.add(lblAcrobacias);

		lblHabilidades = new JLabel("Habilidades");
		lblHabilidades.setVerticalAlignment(SwingConstants.TOP);
		lblHabilidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidades.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblHabilidades.setBounds(0, 5, 126, 13);
		panelHabilidades.add(lblHabilidades);

		rdbtnAtletismo = new JRadioButton("Atletismo");
		rdbtnAtletismo.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnAtletismo.setBounds(6, 39, 79, 13);
		panelHabilidades.add(rdbtnAtletismo);

		rdbtnArcano = new JRadioButton("Arcano");
		rdbtnArcano.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnArcano.setBounds(6, 54, 79, 13);
		panelHabilidades.add(rdbtnArcano);

		rdbtnInterpretacion = new JRadioButton("Interpretación");
		rdbtnInterpretacion.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnInterpretacion.setBounds(6, 99, 79, 13);
		panelHabilidades.add(rdbtnInterpretacion);

		rdbtnHistoria = new JRadioButton("Historia");
		rdbtnHistoria.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnHistoria.setBounds(6, 84, 79, 13);
		panelHabilidades.add(rdbtnHistoria);

		rdbtnEngaño = new JRadioButton("Engaño");
		rdbtnEngaño.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnEngaño.setBounds(6, 69, 79, 13);
		panelHabilidades.add(rdbtnEngaño);

		rdbtnAcrobacias = new JRadioButton("Acrobacias");
		rdbtnAcrobacias.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnAcrobacias.setBounds(6, 24, 79, 13);
		panelHabilidades.add(rdbtnAcrobacias);

		lblPercepcion = new JLabel("0");
		lblPercepcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercepcion.setBounds(180, 102, 16, 13);
		panelHabilidades.add(lblPercepcion);

		lblNaturaleza = new JLabel("0");
		lblNaturaleza.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaturaleza.setBounds(180, 87, 16, 13);
		panelHabilidades.add(lblNaturaleza);

		lblMedicina = new JLabel("0");
		lblMedicina.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicina.setBounds(180, 73, 16, 13);
		panelHabilidades.add(lblMedicina);

		lblManos = new JLabel("0");
		lblManos.setHorizontalAlignment(SwingConstants.CENTER);
		lblManos.setBounds(180, 57, 16, 13);
		panelHabilidades.add(lblManos);

		lblInvestigacion = new JLabel("0");
		lblInvestigacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvestigacion.setBounds(180, 42, 16, 13);
		panelHabilidades.add(lblInvestigacion);

		lblIntimidacion = new JLabel("0");
		lblIntimidacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntimidacion.setBounds(180, 28, 16, 13);
		panelHabilidades.add(lblIntimidacion);

		rdbtnPercepcion = new JRadioButton(et.getString("Percepcion"));
		rdbtnPercepcion.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnPercepcion.setBounds(101, 99, 79, 13);
		panelHabilidades.add(rdbtnPercepcion);

		rdbtnNaturaleza = new JRadioButton(et.getString("Naturaleza"));
		rdbtnNaturaleza.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnNaturaleza.setBounds(101, 84, 79, 13);
		panelHabilidades.add(rdbtnNaturaleza);

		rdbtnMedicina = new JRadioButton(et.getString("Medicina"));
		rdbtnMedicina.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnMedicina.setBounds(101, 69, 79, 13);
		panelHabilidades.add(rdbtnMedicina);

		rdbtnManos = new JRadioButton(et.getString("JuegoManos"));
		rdbtnManos.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnManos.setBounds(101, 54, 79, 13);
		panelHabilidades.add(rdbtnManos);

		rdbtnInvestigacion = new JRadioButton(et.getString("Investigacion"));
		rdbtnInvestigacion.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnInvestigacion.setBounds(101, 39, 79, 13);
		panelHabilidades.add(rdbtnInvestigacion);

		rdbtnIntimidacion = new JRadioButton(et.getString("Intimidacion"));
		rdbtnIntimidacion.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnIntimidacion.setBounds(101, 24, 79, 13);
		panelHabilidades.add(rdbtnIntimidacion);

		rdbtnPerspicacia = new JRadioButton(et.getString("Perspicacia"));
		rdbtnPerspicacia.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnPerspicacia.setBounds(196, 24, 79, 13);
		panelHabilidades.add(rdbtnPerspicacia);

		rdbtnPersuacion = new JRadioButton(et.getString("Persuasion"));
		rdbtnPersuacion.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnPersuacion.setBounds(196, 39, 79, 13);
		panelHabilidades.add(rdbtnPersuacion);

		rdbtnReligion = new JRadioButton(et.getString("Religion"));
		rdbtnReligion.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnReligion.setBounds(196, 54, 79, 13);
		panelHabilidades.add(rdbtnReligion);

		rdbtnSigilo = new JRadioButton(et.getString("Sigilo"));
		rdbtnSigilo.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnSigilo.setBounds(196, 69, 79, 13);
		panelHabilidades.add(rdbtnSigilo);

		rdbtnSupervivencia = new JRadioButton(et.getString("Supervivencia"));
		rdbtnSupervivencia.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnSupervivencia.setBounds(196, 84, 79, 13);
		panelHabilidades.add(rdbtnSupervivencia);

		rdbtnTratoAnimal = new JRadioButton(et.getString("TratoAnimal"));
		rdbtnTratoAnimal.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rdbtnTratoAnimal.setBounds(196, 99, 79, 13);
		panelHabilidades.add(rdbtnTratoAnimal);

		lblTratoAnimal = new JLabel("0");
		lblTratoAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratoAnimal.setBounds(275, 102, 16, 13);
		panelHabilidades.add(lblTratoAnimal);

		lblSupervivencia = new JLabel("0");
		lblSupervivencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervivencia.setBounds(275, 87, 16, 13);
		panelHabilidades.add(lblSupervivencia);

		lblSigilo = new JLabel("0");
		lblSigilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSigilo.setBounds(275, 73, 16, 13);
		panelHabilidades.add(lblSigilo);

		lblReligion = new JLabel("0");
		lblReligion.setHorizontalAlignment(SwingConstants.CENTER);
		lblReligion.setBounds(275, 57, 16, 13);
		panelHabilidades.add(lblReligion);

		lblPersuacion = new JLabel("0");
		lblPersuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersuacion.setBounds(275, 42, 16, 13);
		panelHabilidades.add(lblPersuacion);

		lblPerspicacia = new JLabel("0");
		lblPerspicacia.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerspicacia.setBounds(275, 28, 16, 13);
		panelHabilidades.add(lblPerspicacia);

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
		tabbedPane.addTab("Ver Personajes", null, scrollPersonajes, null);

		tablePersonajes = new JTable();
		scrollPersonajes.setViewportView(tablePersonajes);
		buscarPersonajesConTableModel();

		ManejadorBoton EscuchadorBotones = new ManejadorBoton();

		btnRandom.addActionListener(EscuchadorBotones);
		btnCalcular.addActionListener(EscuchadorBotones);
		btnTirar.addActionListener(EscuchadorBotones);
		rdbtnFue.addActionListener(EscuchadorBotones);
		rdbtnDes.addActionListener(EscuchadorBotones);
		rdbtnCon.addActionListener(EscuchadorBotones);
		rdbtnInt.addActionListener(EscuchadorBotones);
		rdbtnSab.addActionListener(EscuchadorBotones);
		rdbtnCar.addActionListener(EscuchadorBotones);
		btnGuardar.addActionListener(EscuchadorBotones);

		rdbtnAcrobacias.addActionListener(EscuchadorBotones);
		rdbtnAtletismo.addActionListener(EscuchadorBotones);
		rdbtnArcano.addActionListener(EscuchadorBotones);
		rdbtnEngaño.addActionListener(EscuchadorBotones);
		rdbtnHistoria.addActionListener(EscuchadorBotones);
		rdbtnInterpretacion.addActionListener(EscuchadorBotones);

		rdbtnIntimidacion.addActionListener(EscuchadorBotones);
		rdbtnInvestigacion.addActionListener(EscuchadorBotones);
		rdbtnManos.addActionListener(EscuchadorBotones);
		rdbtnMedicina.addActionListener(EscuchadorBotones);
		rdbtnNaturaleza.addActionListener(EscuchadorBotones);
		rdbtnPercepcion.addActionListener(EscuchadorBotones);

		rdbtnPerspicacia.addActionListener(EscuchadorBotones);
		rdbtnPersuacion.addActionListener(EscuchadorBotones);
		rdbtnReligion.addActionListener(EscuchadorBotones);
		rdbtnSigilo.addActionListener(EscuchadorBotones);
		rdbtnSupervivencia.addActionListener(EscuchadorBotones);
		rdbtnTratoAnimal.addActionListener(EscuchadorBotones);

		ManejadorKey EscuchadorKey = new ManejadorKey();

		spinnerFue.addKeyListener(EscuchadorKey);
		spinnerDes.addKeyListener(EscuchadorKey);
		spinnerCon.addKeyListener(EscuchadorKey);
		spinnerInt.addKeyListener(EscuchadorKey);
		spinnerSab.addKeyListener(EscuchadorKey);
		spinnerCar.addKeyListener(EscuchadorKey);
		textNombre.addKeyListener(EscuchadorKey);
		// textTransfondo.addKeyListener(EscuchadorKey);
		textJugador.addKeyListener(EscuchadorKey);
		textExperiencia.addKeyListener(EscuchadorKey);

		ManejadorFocus EscuchadorFocus = new ManejadorFocus();

		textExperiencia.addFocusListener(EscuchadorFocus);
		spinnerFue.addFocusListener(EscuchadorFocus);
		spinnerDes.addFocusListener(EscuchadorFocus);
		spinnerCon.addFocusListener(EscuchadorFocus);
		spinnerInt.addFocusListener(EscuchadorFocus);
		spinnerSab.addFocusListener(EscuchadorFocus);
		spinnerCar.addFocusListener(EscuchadorFocus);

		
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
				spinnerFue.setValue(Stats());
				spinnerDes.setValue(Stats());
				spinnerCon.setValue(Stats());
				spinnerInt.setValue(Stats());
				spinnerSab.setValue(Stats());
				spinnerCar.setValue(Stats());
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
					|| EventoBotones.getSource() == rdbtnInterpretacion || EventoBotones.getSource() == rdbtnEngaño
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
			if (EventKey.getSource() == spinnerFue || EventKey.getSource() == spinnerDes
					|| EventKey.getSource() == spinnerCon || EventKey.getSource() == spinnerInt
					|| EventKey.getSource() == spinnerSab || EventKey.getSource() == spinnerCar) {
				System.out.println(EventKey.getKeyChar());
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
			// TODO Auto-generated method stub
			System.out.println("Cambio Focus");
			if (EventoFocus.getSource() == spinnerFue || EventoFocus.getSource() == spinnerDes
					|| EventoFocus.getSource() == spinnerCon || EventoFocus.getSource() == spinnerInt
					|| EventoFocus.getSource() == spinnerSab || EventoFocus.getSource() == spinnerCar) {
				CalcularModificadores();
			}
		}

		@Override
		public void focusLost(FocusEvent EventoFocus) {
			// TODO Auto-generated method stub
			System.out.println("Cambio Focus");
			if (EventoFocus.getSource() == spinnerFue || EventoFocus.getSource() == spinnerDes
					|| EventoFocus.getSource() == spinnerCon || EventoFocus.getSource() == spinnerInt
					|| EventoFocus.getSource() == spinnerSab || EventoFocus.getSource() == spinnerCar) {
				CalcularModificadores();
			}
			if (EventoFocus.getSource() == textExperiencia) {
				textNivel.setText(String.valueOf((Integer.parseInt(textExperiencia.getText())) / 1000));
			}
		}

	}

	public void GuardarPersonaje() {
		BufferedWriter Escribir;
		File Archivo;
		FileWriter ArchivoEscritura;
		String TextoArchivo;

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
			OPersonaje miPersonaje = new OPersonaje();

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

			// Asignar estadísticas desde los JSpinners
			miPersonaje.setFuerza((Integer) spinnerFue.getValue());
			miPersonaje.setDestreza((Integer) spinnerDes.getValue());
			miPersonaje.setConstitucion((Integer) spinnerCon.getValue());
			miPersonaje.setInteligencia((Integer) spinnerInt.getValue());
			miPersonaje.setSabiduria((Integer) spinnerSab.getValue());
			miPersonaje.setCarisma((Integer) spinnerCar.getValue());

			// Registrar el personaje
			new CPersonaje().registrarPersonaje(miPersonaje);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en el Ingreso de Datos", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

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

	public static int Dados(int Lados) {
		int Tirada = 0;
		Tirada = (int) ((JdkMath.random() * Lados)) + 1;
		System.out.println(Tirada);
		return Tirada;
	}

	public void CalcularModificadores() {
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

		if (rdbtnAtletismo.isSelected()) {
			lblAtletismo.setText(String.valueOf(ModFue + 2));
		} else {
			lblAtletismo.setText(String.valueOf(ModFue));
		}

		if (rdbtnAcrobacias.isSelected()) {
			lblAcrobacias.setText(String.valueOf(ModDes + 2));
		} else {
			lblAcrobacias.setText(String.valueOf(ModDes));
		}
		if (rdbtnManos.isSelected()) {
			lblManos.setText(String.valueOf(ModDes + 2));
		} else {
			lblManos.setText(String.valueOf(ModDes));
		}
		if (rdbtnSigilo.isSelected()) {
			lblSigilo.setText(String.valueOf(ModDes + 2));
		} else {
			lblSigilo.setText(String.valueOf(ModDes));
		}

		if (rdbtnArcano.isSelected()) {
			lblArcano.setText(String.valueOf(ModInt + 2));
		} else {
			lblArcano.setText(String.valueOf(ModInt));
		}
		if (rdbtnHistoria.isSelected()) {
			lblHistoria.setText(String.valueOf(ModInt + 2));
		} else {
			lblHistoria.setText(String.valueOf(ModInt));
		}
		if (rdbtnInvestigacion.isSelected()) {
			lblInvestigacion.setText(String.valueOf(ModInt + 2));
		} else {
			lblInvestigacion.setText(String.valueOf(ModInt));
		}
		if (rdbtnNaturaleza.isSelected()) {
			lblNaturaleza.setText(String.valueOf(ModInt + 2));
		} else {
			lblNaturaleza.setText(String.valueOf(ModInt));
		}
		if (rdbtnReligion.isSelected()) {
			lblReligion.setText(String.valueOf(ModInt + 2));
		} else {
			lblReligion.setText(String.valueOf(ModInt));
		}

		if (rdbtnMedicina.isSelected()) {
			lblMedicina.setText(String.valueOf(ModSab + 2));
		} else {
			lblMedicina.setText(String.valueOf(ModSab));
		}
		if (rdbtnPercepcion.isSelected()) {
			lblPercepcion.setText(String.valueOf(ModSab + 2));
		} else {
			lblPercepcion.setText(String.valueOf(ModSab));
		}
		if (rdbtnPerspicacia.isSelected()) {
			lblPerspicacia.setText(String.valueOf(ModSab + 2));
		} else {
			lblPerspicacia.setText(String.valueOf(ModSab));
		}
		if (rdbtnSupervivencia.isSelected()) {
			lblSupervivencia.setText(String.valueOf(ModSab + 2));
		} else {
			lblSupervivencia.setText(String.valueOf(ModSab));
		}
		if (rdbtnTratoAnimal.isSelected()) {
			lblTratoAnimal.setText(String.valueOf(ModSab + 2));
		} else {
			lblTratoAnimal.setText(String.valueOf(ModSab));
		}

		if (rdbtnEngaño.isSelected()) {
			lblEngaño.setText(String.valueOf(ModCar + 2));
		} else {
			lblEngaño.setText(String.valueOf(ModCar));
		}
		if (rdbtnIntimidacion.isSelected()) {
			lblIntimidacion.setText(String.valueOf(ModCar + 2));
		} else {
			lblIntimidacion.setText(String.valueOf(ModCar));
		}
		if (rdbtnPersuacion.isSelected()) {
			lblPersuacion.setText(String.valueOf(ModCar + 2));
		} else {
			lblPersuacion.setText(String.valueOf(ModCar));
		}
		if (rdbtnInterpretacion.isSelected()) {
			lblInterpretacion.setText(String.valueOf(ModCar + 2));
		} else {
			lblInterpretacion.setText(String.valueOf(ModCar));
		}
	}

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
	        JOptionPane.showMessageDialog(null, "Error al obtener nombres de razas", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
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
}
