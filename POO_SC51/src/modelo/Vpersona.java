package modelo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.PlaceHolder;
import com.toedter.calendar.JDateChooser;

//import controladores.CPersona;

public class Vpersona extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCod;
	private JTextField textNombre;
	private JSpinner JSpinnerEdad;
	private JComboBox<String> JCBProfesion;
	private JFormattedTextField JFTextTelefono;
	private JTable miTabla;
	private JScrollPane miBarra;
	private JLabel labelTabla;
	private JButton botonGuardar;
	private JLabel telefono;
	private JLabel profesion;
	private JLabel edad;
	private JLabel nombre;
	private JLabel cod;
	private JLabel labelTitulo;
	private JButton botonCancelar;
	private JButton BotonBorrar;
	private JButton btnFiltrar;
	private Date Hoy;
	private JDateChooser Calendario;
	private static Vpersona frame;
	private JTextField textEmail;
	private JLabel lblEmail;
	private JCheckBox chckbxTerCon;
	private JLabel lblFechaNac;
	private MaskFormatter PatronTelefono;
	private final ButtonGroup AgrupadorBooton = new ButtonGroup();
	private JRadioButton rdbtnFemenino;
	private JRadioButton rdbtnNO;
	private JRadioButton rdbtnMasculino;
	private PlaceHolder Etiquetas;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Vpersona();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param botonCancelar
	 */
	public Vpersona() {
		setTitle("Formulario");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		labelTitulo = new JLabel();
		labelTitulo.setBounds(102, 11, 271, 30);
		labelTitulo.setText("REGISTRO DE PERSONAS");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(labelTitulo);

		cod = new JLabel();
		cod.setBounds(12, 47, 61, 25);
		cod.setText("Codigo");
		contentPane.add(cod);

		textCod = new JTextField();
		Etiquetas= new PlaceHolder(textCod,"Código Empleado");
		textCod.setToolTipText("Codigo empledo");
		textCod.setBounds(72, 47, 80, 25);
		textCod.setText("");
		contentPane.add(textCod);
		
		nombre = new JLabel();
		nombre.setBounds(12, 87, 80, 25);
		nombre.setText("Nombre");
		contentPane.add(nombre);

		textNombre = new JTextField();
		textNombre.setBounds(72, 87, 190, 25);
		textNombre.setText("");
		contentPane.add(textNombre);

		JSpinnerEdad = new JSpinner();
		JSpinnerEdad.setModel(new SpinnerNumberModel(0, 0, 120, 1));
		JSpinnerEdad.setBounds(348, 87, 100, 25);
		((JSpinner.DefaultEditor) JSpinnerEdad.getEditor()).getTextField().setEditable(false);// evita edita el Spiner a
																								// mano
		contentPane.add(JSpinnerEdad);

		edad = new JLabel();
		edad.setBounds(282, 87, 80, 25);
		edad.setText("Edad");
		contentPane.add(edad);

		profesion = new JLabel();
		profesion.setBounds(12, 127, 80, 25);
		profesion.setText("Profesion");
		contentPane.add(profesion);

		// Se inicializa una Variable tipo DefaultComboBoxModel que contendra los datos
		// de la tabla profesiones
		DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

		// Se Manda a llamar a la consulta de Datos de la Tabla Profesiones y nos la
		// devuelve en el Objeto Profesiones
		// DatosJcombox = CPersona.LlenarComboBox();

		JCBProfesion = new JComboBox<String>(
				new DefaultComboBoxModel(new String[] { "", "Docente", "Alumno", "Administrativo" }));
		JCBProfesion.setBounds(72, 127, 190, 25);
		contentPane.add(JCBProfesion);

		telefono = new JLabel();
		telefono.setBounds(282, 127, 80, 25);
		telefono.setText("Telefono");
		contentPane.add(telefono);

		// Mascara de Validación

		try {
			PatronTelefono = new MaskFormatter("(###) ###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JFTextTelefono = new JFormattedTextField(PatronTelefono);
		JFTextTelefono.setBounds(348, 127, 100, 25);
		JFTextTelefono.setText("");
		contentPane.add(JFTextTelefono);

		botonGuardar = new JButton();
		botonGuardar.setBounds(102, 235, 120, 25);
		botonGuardar.setText("Registrar");
		contentPane.add(botonGuardar);

		botonCancelar = new JButton();
		botonCancelar.setBounds(242, 235, 120, 25);
		botonCancelar.setText("Cancelar");
		contentPane.add(botonCancelar);

		labelTabla = new JLabel();
		labelTabla.setBounds(12, 253, 195, 50);
		labelTabla.setText("Tabla Usando Table Model");
		contentPane.add(labelTabla);

		miBarra = new JScrollPane();
		miBarra.setBounds(12, 302, 442, 130);
		contentPane.add(miBarra);

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setBounds(178, 443, 97, 25);
		contentPane.add(BotonBorrar);

		// Inicalizamos la Variablecon la fecha actual
		Hoy = new Date();

		// Instanciar Componente
		Calendario = new JDateChooser();

		Calendario.setDateFormatString("dd/MM/yyyy");
		Calendario.setDate(Hoy);
		// com.toedter.calendar.JTextFieldDateEditor Calendario
		Calendario.setMaxSelectableDate(Hoy);
		Calendario.setBounds(348, 47, 106, 25);
		contentPane.add(Calendario);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(186, 48, 89, 23);
		contentPane.add(btnFiltrar);

		lblEmail = new JLabel("Correo Electronico:");
		lblEmail.setBounds(12, 163, 120, 14);
		contentPane.add(lblEmail);

		
		textEmail = new JTextField();
		textEmail.setBounds(72, 180, 190, 25);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		chckbxTerCon = new JCheckBox("Acepto Terminos y Condiciones");
		chckbxTerCon.setBounds(213, 267, 226, 23);
		contentPane.add(chckbxTerCon);

		lblFechaNac = new JLabel("Fecha Nac:");
		lblFechaNac.setBounds(282, 54, 80, 14);
		contentPane.add(lblFechaNac);

		rdbtnMasculino = new JRadioButton("Masculino");
		AgrupadorBooton.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(323, 159, 109, 23);
		contentPane.add(rdbtnMasculino);

		rdbtnFemenino = new JRadioButton("Femenino");
		AgrupadorBooton.add(rdbtnFemenino);
		rdbtnFemenino.setBounds(323, 185, 109, 23);
		contentPane.add(rdbtnFemenino);

		rdbtnNO = new JRadioButton("Prefiero No Decir");
		AgrupadorBooton.add(rdbtnNO);
		rdbtnNO.setBounds(323, 211, 125, 23);
		contentPane.add(rdbtnNO);
		
		
		// Consulta los datos de la tabla de BD y los pone en la tablas de de la vista

		// mostrarDatosConTableModel();// mostramos la tabla
		// Escuchador para acciones del Boton
		ManejadorBoton Escuchador = new ManejadorBoton();
		// botonGuardar.addActionListener(Escuchador);
		botonCancelar.addActionListener(Escuchador);
		BotonBorrar.addActionListener(Escuchador);
		// btnFiltrar.addActionListener(Escuchador);
		// Escuchadres para acciones del teclado
		
		ManejadorKey EscucahadorKey = new ManejadorKey();
		textCod.addKeyListener(EscucahadorKey);
		textNombre.addKeyListener(EscucahadorKey);
		textEmail.addKeyListener(EscucahadorKey);
		JFTextTelefono.addKeyListener(EscucahadorKey);

		// Escuchador para acciones de perdida de Focus
		ManejadorFocus EscuchadorFocus = new ManejadorFocus();
		textCod.addFocusListener(EscuchadorFocus);
		JFTextTelefono.addFocusListener(EscuchadorFocus);

	}

	/*
	 * Manejador Focus
	 */
	private class ManejadorFocus implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void focusLost(FocusEvent EvtFocus) {
			if (EvtFocus.getSource().equals(textCod)) {
				btnFiltrar.requestFocus();
			}

			if (EvtFocus.getSource().equals(JFTextTelefono)) {
				System.out.print("Salio  del focus");

				Pattern PatronTelefono = Pattern.compile("^\\([0-9]{3}\\)\\s*[0-9]{3}-[0-9]{4}$");
				Matcher MatchTelefono = PatronTelefono.matcher(JFTextTelefono.getText());

				if (!MatchTelefono.matches()) {
					JOptionPane.showMessageDialog(frame, "Telefono no Valido", "Error", JOptionPane.ERROR_MESSAGE);
					JFTextTelefono.requestFocus();
				}

			}

		}

	}

	/*
	 * Manejador Type
	 */
	private class ManejadorKey implements KeyListener {

		public void keyTyped(KeyEvent EvetKey) {
			// la primera condición valida que sea un numero la segunda que sea menor de
			// tres
			// y la ultima que si es un BACK_SPACE se active y no marque error

			if (EvetKey.getSource() == textCod) {// Verfica que las validación sea sobre el componente de textCod
				if ((!Character.isDigit(EvetKey.getKeyChar()) || textCod.getText().trim().length() >= 3)
						&& EvetKey.getKeyChar() != KeyEvent.VK_BACK_SPACE
						&& EvetKey.getKeyChar() != KeyEvent.VK_DELETE) {

					// Valida que sea nuemro que que los digitos no ean mas de tres y si preiona
					// enter se vaya a las iguiente casilla
					if (!Character.isDigit(EvetKey.getKeyChar())
							&& (textCod.getText().trim().length() <= 3 && textCod.getText().trim().length() >= 1)
							&& EvetKey.getKeyChar() == KeyEvent.VK_ENTER) {
						btnFiltrar.requestFocus();
					} else {

						JOptionPane.showMessageDialog(frame, "Solo se periten campos numéricos\n "
								+ " No puede tener campos Vacios  \n " + " o valores mayores a 3 digitos", "Error",
								JOptionPane.ERROR_MESSAGE);

						EvetKey.consume();// el evento consume evita que se aplique la tecla presionada
						textCod.requestFocus();
					}

				}
			}

			if (EvetKey.getSource() == textNombre) {// Valida que sean solo caracteres, VK_SPACE, VK_BACK_SPACE

				if (!Character.isLetter(EvetKey.getKeyChar()) && EvetKey.getKeyChar() != KeyEvent.VK_SPACE
						&& EvetKey.getKeyChar() != KeyEvent.VK_BACK_SPACE
						&& EvetKey.getKeyChar() != KeyEvent.VK_DELETE) {

					JOptionPane.showMessageDialog(frame, "Debe solo caracteres", "Error", JOptionPane.ERROR_MESSAGE);
					EvetKey.consume();// el evento consume evita que se aplique la tecla presionada

				}

			}
			if (EvetKey.getSource() == textEmail) {

				if (!Character.isLetterOrDigit(EvetKey.getKeyChar()) && EvetKey.getKeyChar() != KeyEvent.VK_SPACE
						&& EvetKey.getKeyChar() != KeyEvent.VK_BACK_SPACE && EvetKey.getKeyChar() != '@'
						&& EvetKey.getKeyChar() != '_' && EvetKey.getKeyChar() != '.'
						&& EvetKey.getKeyChar() != KeyEvent.VK_ENTER && EvetKey.getKeyChar() != KeyEvent.VK_DELETE) {
					JOptionPane.showMessageDialog(frame, "Caracter No Valido Para Correo Electronico", "Error",
							JOptionPane.ERROR_MESSAGE);
					EvetKey.consume();// el evento consume evita que se aplique la tecla presionada

				} else if (EvetKey.getKeyChar() == KeyEvent.VK_ENTER) {
					System.out.println("Entra al precionar Enter");
					System.out.println("Validación de Mail " + ValidaEmail(textEmail.getText()));
					if (!ValidaEmail(textEmail.getText())) {
						// &&
						JOptionPane.showMessageDialog(frame, "Correo Electronico no Valido\n Escribalo Correctamente",
								"Error", JOptionPane.ERROR_MESSAGE);
						textEmail.requestFocus();
					} else {
						botonGuardar.requestFocus();
					}

				}

			}

			if (EvetKey.getSource().equals(JFTextTelefono)) {

				if (!Character.isDigit(EvetKey.getKeyChar()) && EvetKey.getKeyChar() != KeyEvent.VK_DELETE
						&& EvetKey.getKeyChar() != KeyEvent.VK_BACK_SPACE) {

					if (EvetKey.getKeyChar() == KeyEvent.VK_ENTER) {
						textEmail.requestFocus();
					} else {
						JOptionPane.showMessageDialog(frame, "Debe solo Valores Númericos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		}

		public boolean ValidaEmail(String Email) {

			// Patrón para validar el email
			Pattern PatronEmail = Pattern.compile(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

			Matcher mather = PatronEmail.matcher(Email);

			if (Email == null || Email.equalsIgnoreCase("")) {
				return false;
			}

			return mather.find();

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Metodo que permite hacer el llenado de la tabla usando Table Model
	 */
	private void mostrarDatosConTableModel() {
		DefaultTableModel model;
		model = new DefaultTableModel();// definimos el objeto tableModel
		miTabla = new JTable();// creamos la instancia de la tabla
		miTabla.setModel(model);
		model.addColumn("No Documento");
		model.addColumn("Nombre");
		model.addColumn("Edad");
		model.addColumn("Profesión");
		model.addColumn("Telefono");

		miTabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		miTabla.getTableHeader().setReorderingAllowed(false);

		// CPersona miPersonaDao = new CPersona();
		/*
		 * enviamos el objeto TableModel, como mandamos el objeto podemos manipularlo
		 * desde el metodo
		 */
		// miPersonaDao.buscarUsuariosConTableModel(model);

		miBarra.setViewportView(miTabla);

	}

	/**
	 * Limpia el formulario de Registro
	 */
	private void limpiar() {
		textCod.setText("");
		textNombre.setText("");
		JSpinnerEdad.setValue(0);
		JFTextTelefono.setText("");
		JCBProfesion.setSelectedIndex(0);
		
	}

	private class ManejadorBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent EventoBotones) {
			/*if (EventoBotones.getSource() == botonGuardar && chckbxTerCon.isSelected() == true) {
				CPersona miPersonaDao = new CPersona();

				try {
					OPersona miPersona = new OPersona();

					miPersona.setIdPersona(Integer.parseInt(textCod.getText()));
					miPersona.setNombrePersona(textNombre.getText());
					miPersona.setTelefonoPersona(JFTextTelefono.getText());
					miPersona.setEdadPersona((Integer) JSpinnerEdad.getValue());
					miPersona.setProfesionPersona(JCBProfesion.getSelectedIndex());
					miPersona.setFechaNac(Calendario.getDate());
					miPersona.setEmail(textEmail.getText());
					miPersona.setTerCom(chckbxTerCon.isSelected());

					miPersonaDao.registrarPersona(miPersona);

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frame, "Error en el Ingreso de Datos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					// Actualizamos siempre las tablas despues del registro 
					mostrarDatosConTableModel();
					limpiar();
				}
			} else if (chckbxTerCon.isSelected() == false) {
				JOptionPane.showMessageDialog(frame, "Error debe Aceptar terminos y condiciones", "Error",
						JOptionPane.ERROR_MESSAGE);
			} */

			if (EventoBotones.getSource() == BotonBorrar) {

				if (miTabla.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Error debe seleccionar por lo menos un rengl�n", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (miTabla.getSelectedRow() >= 0) {
					//CPersona miPersonaDao = new CPersona();
					try {
						OPersona miPersona = new OPersona();

						miPersona.setIdPersona(
								Integer.parseInt(miTabla.getValueAt(miTabla.getSelectedRow(), 0).toString()));
						miPersona.setNombrePersona((String) miTabla.getValueAt(miTabla.getSelectedRow(), 1));
						miPersona.setEdadPersona(
								Integer.parseInt(miTabla.getValueAt(miTabla.getSelectedRow(), 2).toString()));
						miPersona.setProfesionPersona(
								Integer.parseInt(miTabla.getValueAt(miTabla.getSelectedRow(), 3).toString()));
						miPersona.setTelefonoPersona(miTabla.getValueAt(miTabla.getSelectedRow(), 4).toString());

						//miPersonaDao.borrarPersona(miPersona);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error en el Ingreso de Datos", "Error",
								JOptionPane.ERROR_MESSAGE);
					} finally {
						/* Actualizamos siempre las tablas despues del registro */
						mostrarDatosConTableModel();
						limpiar();
					}
				}
			}

			if (EventoBotones.getSource() == botonCancelar) {
				limpiar();
			}

			if (EventoBotones.getSource() == btnFiltrar) {

				if (!textCod.getText().equals("0") && textCod.getText() != null && !textCod.getText().equals("")) {

					OPersona miPersona = new OPersona();

					miPersona.setIdPersona(Integer.parseInt(textCod.getText()));

					////
					DefaultTableModel model;
					model = new DefaultTableModel();// definimos el objeto tableModel
					miTabla = new JTable();// creamos la instancia de la tabla
					miTabla.setModel(model);
					model.addColumn("No Documento");
					model.addColumn("Nombre");
					model.addColumn("Edad");
					model.addColumn("Profesión");
					model.addColumn("Telefono");

					miTabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					miTabla.getTableHeader().setReorderingAllowed(false);
					//

					//CPersona miPersonaDao = new CPersona();
					//miPersonaDao.buscarUsuariosConTableModelProcedimientoP(model, miPersona.getIdPersona());
					miBarra.setViewportView(miTabla);
					/* Actualizamos siempre las tablas despues del registro */
					// mostrarDatosConTableModel();
				} else {
					/* Actualizamos siempre las tablas despues del registro */
					mostrarDatosConTableModel();
				}
				limpiar();
			}
		}

	}
}
