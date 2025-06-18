package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class AñadirDatos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirDatos frame = new AñadirDatos();
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
	public AñadirDatos() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 416, 243);
		contentPane.add(tabbedPane);
		
		JPanel Jpane2 = new JPanel();
		Jpane2.setLayout(null);
		Jpane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Clase", null, Jpane2, null);
		
		JButton BTNGuardarClase_1 = new JButton("Guardar clase");
		BTNGuardarClase_1.setBounds(135, 195, 153, 21);
		Jpane2.add(BTNGuardarClase_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(170, 140, 63, 20);
		Jpane2.add(spinner_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(170, 103, 231, 21);
		Jpane2.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(170, 50, 231, 35);
		Jpane2.add(textField_1);
		
		JLabel NLnombreClase_1 = new JLabel("nombre_Clase");
		NLnombreClase_1.setBounds(10, 19, 116, 16);
		Jpane2.add(NLnombreClase_1);
		
		JLabel NLdescripcionClase_1 = new JLabel("descripcion_clase");
		NLdescripcionClase_1.setBounds(10, 50, 116, 16);
		Jpane2.add(NLdescripcionClase_1);
		
		JLabel NLtipoClase_1 = new JLabel("tipo_Clase");
		NLtipoClase_1.setBounds(10, 105, 116, 16);
		Jpane2.add(NLtipoClase_1);
		
		JLabel NLdadoDaño_1 = new JLabel("tipo_Daño");
		NLdadoDaño_1.setBounds(10, 141, 116, 16);
		Jpane2.add(NLdadoDaño_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(170, 10, 231, 30);
		Jpane2.add(textField_2);
		
		JPanel Jpane1 = new JPanel();
		Jpane1.setLayout(null);
		Jpane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Razas", null, Jpane1, null);
		
		JLabel NLnombreRaza = new JLabel("nombre_Raza");
		NLnombreRaza.setBounds(10, 19, 116, 16);
		Jpane1.add(NLnombreRaza);
		
		JLabel NLdescripcionRaza = new JLabel("descripcion_raza");
		NLdescripcionRaza.setBounds(10, 76, 116, 16);
		Jpane1.add(NLdescripcionRaza);
		
		JLabel NLtamañoRaza = new JLabel("tamaño_raza");
		NLtamañoRaza.setBounds(10, 131, 116, 16);
		Jpane1.add(NLtamañoRaza);
		
		JLabel NLvelocidad = new JLabel("velocidad");
		NLvelocidad.setBounds(10, 167, 116, 16);
		Jpane1.add(NLvelocidad);
		
		textField = new JTextField();
		textField.setBounds(170, 76, 231, 35);
		Jpane1.add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(170, 166, 63, 20);
		Jpane1.add(spinner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 129, 231, 21);
		Jpane1.add(comboBox);
		
		JButton BTNGuardarRaza = new JButton("Guardar Raza");
		BTNGuardarRaza.setBounds(135, 195, 153, 21);
		Jpane1.add(BTNGuardarRaza);
		
		JLabel NLvariante = new JLabel("variante");
		NLvariante.setBounds(10, 47, 116, 16);
		Jpane1.add(NLvariante);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(170, 45, 231, 21);
		Jpane1.add(comboBox_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 10, 231, 30);
		Jpane1.add(textField_3);
	}
}
