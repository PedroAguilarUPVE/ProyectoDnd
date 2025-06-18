package vistas;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controladores.CEmpleado;
import controladores.Mensajes;
import modelo.MEmpleado;

public class Principal extends JFrame {

	private static final long serialVersionUID = -7060485707599273286L;
	private JPanel contentPane;
	private JTextField textFNombre;
	private JLabel lblNombre;
	private JTextField textFAP;
	private JTextField textFAM;
	private JTextField textFTelef;
	private JTextField textFDomicilio;
	private JLabel lblApellidoPater;
	private JLabel lblApellidoMaterno;
	private JLabel lblTelefono;
	private JLabel lblDomicilio;
	private JLabel lblFechaNac;
	private JDateChooser Calendario;
	private JButton btnGuardar;
	private JLabel lblIdCurp;
	private JTextField textFId;
	private JTextField textFCurp;
	private JTextField textFRFC;
	private JButton btnModificar;
	private JButton btnVentana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Ejercicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(21, 32, 81, 13);
		contentPane.add(lblNombre);

		textFNombre = new JTextField();
		textFNombre.setBounds(142, 29, 96, 19);
		contentPane.add(textFNombre);
		textFNombre.setColumns(10);

		lblApellidoPater = new JLabel("Apellido Paterno");
		lblApellidoPater.setBounds(21, 71, 96, 13);
		contentPane.add(lblApellidoPater);

		lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(21, 109, 96, 13);
		contentPane.add(lblApellidoMaterno);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 159, 81, 13);
		contentPane.add(lblTelefono);

		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(345, 71, 45, 13);
		contentPane.add(lblDomicilio);

		lblFechaNac = new JLabel("Fecha Nacimiento");
		lblFechaNac.setBounds(345, 109, 87, 13);
		contentPane.add(lblFechaNac);

		textFAP = new JTextField();
		textFAP.setBounds(142, 68, 96, 19);
		contentPane.add(textFAP);
		textFAP.setColumns(10);

		textFAM = new JTextField();
		textFAM.setBounds(142, 106, 96, 19);
		contentPane.add(textFAM);
		textFAM.setColumns(10);

		textFTelef = new JTextField();
		textFTelef.setBounds(142, 156, 96, 19);
		contentPane.add(textFTelef);
		textFTelef.setColumns(10);

		textFDomicilio = new JTextField();
		textFDomicilio.setBounds(467, 68, 96, 19);
		contentPane.add(textFDomicilio);
		textFDomicilio.setColumns(10);

		Date hoy = new Date();

		Calendario = new JDateChooser();
		Calendario.setMaxSelectableDate(hoy);
		Calendario.setBounds(467, 109, 96, 19);
		contentPane.add(Calendario);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(142, 232, 85, 21);
		contentPane.add(btnGuardar);

		lblIdCurp = new JLabel("ID:");
		lblIdCurp.setBounds(345, 32, 45, 13);
		contentPane.add(lblIdCurp);

		textFId = new JTextField();
		textFId.setBounds(467, 29, 96, 19);
		contentPane.add(textFId);
		textFId.setColumns(10);

		textFCurp = new JTextField();
		textFCurp.setBounds(467, 138, 96, 19);
		contentPane.add(textFCurp);
		textFCurp.setColumns(10);

		textFRFC = new JTextField();
		textFRFC.setBounds(467, 178, 96, 19);
		contentPane.add(textFRFC);
		textFRFC.setColumns(10);

		JLabel lblNewLabel = new JLabel("Curp");
		lblNewLabel.setBounds(345, 141, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Rfc");
		lblNewLabel_1.setBounds(345, 181, 45, 13);
		contentPane.add(lblNewLabel_1);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(328, 232, 85, 21);
		contentPane.add(btnModificar);

		btnVentana = new JButton("Abrir Ventana");
		btnVentana.setBounds(530, 232, 85, 21);
		contentPane.add(btnVentana);
		

		// Se realiza el Instanciado ala clase escuchadora de las acciones del boton

		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		btnGuardar.addActionListener(EscuchadorBotones);
		btnModificar.addActionListener(EscuchadorBotones);
		btnVentana.addActionListener(EscuchadorBotones);

	}


	// Creamosel metodo que permite controlar la accion del Boton
	private class ManejadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent EventoB) {

			if (EventoB.getSource() == btnGuardar) {
				MEmpleado Empleado = new MEmpleado();

				Empleado.setIdEmpleado(Integer.parseInt(textFId.getText()));
				Empleado.setNomEmpleado(textFNombre.getText());
				Empleado.setApPaterno(textFAP.getText());
				Empleado.setApMaterno(textFAM.getText());
				Empleado.setDomicilio(textFDomicilio.getText());
				Empleado.setTelefono(textFTelef.getText());
				Empleado.setCurp(textFCurp.getText());
				Empleado.setRFC(textFRFC.getText());
				Empleado.setFechaNacim(Calendario.getDate());

				CEmpleado Controlador = new CEmpleado();
				Mensajes Mensaje = new Mensajes();

				Mensaje = Controlador.RegistrarEmpleado(Empleado);

				JOptionPane.showMessageDialog(null, Mensaje.getMensaje(), "Informaci�n", 1);

			}
			if (EventoB.getSource() == btnModificar) {

				MEmpleado Empleado = new MEmpleado();

				Empleado.setIdEmpleado(Integer.parseInt(textFId.getText()));
				Empleado.setNomEmpleado(textFNombre.getText());

				Mensajes Mensaje = new Mensajes();
				CEmpleado Controlador = new CEmpleado();
				Mensaje = Controlador.UpdateRegistro(Empleado);

				JOptionPane.showMessageDialog(null, Mensaje.getMensaje(), "Informaci�n", 1);

			}
			if (EventoB.getSource() == btnVentana) {

			}

		}

	}
}
