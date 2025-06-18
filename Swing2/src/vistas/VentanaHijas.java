package vistas;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class VentanaHijas extends JDialog {

	private JButton btnRegresar;
	public JLabel lblEtiqueta;
	public int ContadorHijo;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * El costructor se parametriza para que reciba quien es su ventana padre y si
	 * avilita el envio de datos
	 */
	public VentanaHijas(Frame parent, boolean modal, Locale Idioma) {
		super(parent, modal);// se inicializa el constructor super
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// se indica que se envien los parametros cuando se cierre la ventana
													// con Disponse
		setBounds(100, 100, 633, 300);
		getContentPane().setLayout(null);

		// Obtener los recursos desde el archivo <properties/dic> en funci�n del idioma
		// <locale>
		ResourceBundle et = ResourceBundle.getBundle("properties/dic", Idioma);

		btnRegresar = new JButton(et.getString("regresar"));
		btnRegresar.setBounds(250, 215, 131, 25);
		getContentPane().add(btnRegresar);

		lblEtiqueta = new JLabel("");
		lblEtiqueta.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		lblEtiqueta.setHorizontalAlignment(JLabel.CENTER);
		lblEtiqueta.setVerticalAlignment(JLabel.CENTER);
		lblEtiqueta.setBounds(12, 92, 591, 43);
		getContentPane().add(lblEtiqueta);

		ManejadorBoton ManejaBoton = new ManejadorBoton();
		btnRegresar.addActionListener(ManejaBoton);

	}

	private class ManejadorBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnRegresar)) {
				// Se incrementa el valor de la visita al cerrar
				ContadorHijo++;
				// se cierra la ventana para que envie los valores de regreso
				dispose();
			}

		}

	}

}
