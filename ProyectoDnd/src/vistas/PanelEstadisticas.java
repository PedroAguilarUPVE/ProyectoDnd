package vistas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.SwingConstants;

import modelos.OEstadisticas;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Clase PanelEstadisticas (Vacio) Componente encargado de contener los
 * controladores de estadisticas de un personaje o raza y poder acceder a sus
 * valores
 */
public class PanelEstadisticas extends JPanel {

	private static final long serialVersionUID = 1L;
	public JSpinner spinnerFue;
	public JSpinner spinnerDes;
	public JSpinner spinnerCon;
	public JSpinner spinnerInt;
	public JSpinner spinnerCar;
	public JSpinner spinnerSab;
	private JLabel lblModFue;
	private JLabel lblModDes;
	private JLabel lblModCon;
	private JLabel lblModInt;
	private JLabel lblModSab;
	private JLabel lblModCar;
	private ResourceBundle et;
	private int ModFue;
	private int ModDes;
	private int ModCon;
	private int ModInt;
	private int ModSab;
	private int ModCar;

	/**
	 * Create the panel.
	 */
	public PanelEstadisticas(Locale Idioma) {

		et = ResourceBundle.getBundle("properties/dic", Idioma);

		setBorder(null);
		setLayout(null);

		JPanel panelFuerza = new JPanel();
		panelFuerza.setLayout(null);
		panelFuerza.setBackground(Color.LIGHT_GRAY);
		panelFuerza.setBounds(0, 0, 60, 75);
		add(panelFuerza);

		lblModFue = new JLabel("0");
		lblModFue.setHorizontalAlignment(SwingConstants.CENTER);
		lblModFue.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModFue.setBounds(10, 10, 45, 20);
		panelFuerza.add(lblModFue);

		JLabel lblFue = new JLabel(et.getString("Fuerza"));
		lblFue.setVerticalAlignment(SwingConstants.TOP);
		lblFue.setHorizontalAlignment(SwingConstants.CENTER);
		lblFue.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblFue.setBounds(0, 60, 60, 14);
		panelFuerza.add(lblFue);

		spinnerFue = new JSpinner();
		spinnerFue.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerFue.setBounds(10, 30, 40, 20);
		panelFuerza.add(spinnerFue);

		JPanel panelDestreza = new JPanel();
		panelDestreza.setLayout(null);
		panelDestreza.setBackground(Color.LIGHT_GRAY);
		panelDestreza.setBounds(65, 0, 60, 75);
		add(panelDestreza);

		lblModDes = new JLabel("0");
		lblModDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblModDes.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModDes.setBounds(10, 10, 45, 20);
		panelDestreza.add(lblModDes);

		JLabel lblDes = new JLabel(et.getString("Destreza"));
		lblDes.setVerticalAlignment(SwingConstants.TOP);
		lblDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDes.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblDes.setBounds(0, 60, 60, 14);
		panelDestreza.add(lblDes);

		spinnerDes = new JSpinner();
		spinnerDes.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerDes.setBounds(10, 30, 47, 20);
		panelDestreza.add(spinnerDes);

		JPanel panelConstitucion = new JPanel();
		panelConstitucion.setLayout(null);
		panelConstitucion.setBackground(Color.LIGHT_GRAY);
		panelConstitucion.setBounds(130, 0, 60, 75);
		add(panelConstitucion);

		lblModCon = new JLabel("0");
		lblModCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblModCon.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModCon.setBounds(10, 10, 45, 20);
		panelConstitucion.add(lblModCon);

		JLabel lblCon = new JLabel(et.getString("Constitucion"));
		lblCon.setVerticalAlignment(SwingConstants.TOP);
		lblCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblCon.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		lblCon.setBounds(0, 60, 60, 14);
		panelConstitucion.add(lblCon);

		spinnerCon = new JSpinner();
		spinnerCon.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerCon.setBounds(10, 30, 47, 20);
		panelConstitucion.add(spinnerCon);

		JPanel panelInteligencia = new JPanel();
		panelInteligencia.setLayout(null);
		panelInteligencia.setBackground(Color.LIGHT_GRAY);
		panelInteligencia.setBounds(195, 0, 60, 75);
		add(panelInteligencia);

		lblModInt = new JLabel("0");
		lblModInt.setHorizontalAlignment(SwingConstants.CENTER);
		lblModInt.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModInt.setBounds(10, 10, 45, 20);
		panelInteligencia.add(lblModInt);

		JLabel lblInt = new JLabel(et.getString("Inteligencia"));
		lblInt.setVerticalAlignment(SwingConstants.TOP);
		lblInt.setHorizontalAlignment(SwingConstants.CENTER);
		lblInt.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblInt.setBounds(0, 60, 60, 14);
		panelInteligencia.add(lblInt);

		spinnerInt = new JSpinner();
		spinnerInt.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerInt.setBounds(10, 30, 47, 20);
		panelInteligencia.add(spinnerInt);

		JPanel panelSabiduria = new JPanel();
		panelSabiduria.setLayout(null);
		panelSabiduria.setBackground(Color.LIGHT_GRAY);
		panelSabiduria.setBounds(260, 0, 60, 75);
		add(panelSabiduria);

		lblModSab = new JLabel("0");
		lblModSab.setHorizontalAlignment(SwingConstants.CENTER);
		lblModSab.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModSab.setBounds(10, 10, 45, 20);
		panelSabiduria.add(lblModSab);

		JLabel lblSab = new JLabel(et.getString("Sabiduria"));
		lblSab.setVerticalAlignment(SwingConstants.TOP);
		lblSab.setHorizontalAlignment(SwingConstants.CENTER);
		lblSab.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblSab.setBounds(0, 60, 60, 14);
		panelSabiduria.add(lblSab);

		spinnerSab = new JSpinner();
		spinnerSab.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerSab.setBounds(10, 30, 47, 20);
		panelSabiduria.add(spinnerSab);

		JPanel panelCarisma = new JPanel();
		panelCarisma.setLayout(null);
		panelCarisma.setBackground(Color.LIGHT_GRAY);
		panelCarisma.setBounds(325, 0, 60, 75);
		add(panelCarisma);

		lblModCar = new JLabel("0");
		lblModCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModCar.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblModCar.setBounds(10, 10, 45, 20);
		panelCarisma.add(lblModCar);

		JLabel lblCar = new JLabel(et.getString("Carisma"));
		lblCar.setVerticalAlignment(SwingConstants.TOP);
		lblCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCar.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblCar.setBounds(0, 60, 60, 14);
		panelCarisma.add(lblCar);

		spinnerCar = new JSpinner();
		spinnerCar.setModel(new SpinnerNumberModel(10, 0, 20, 1));
		spinnerCar.setBounds(10, 30, 47, 20);
		panelCarisma.add(spinnerCar);

		
		ManejadorFocus EscuchadorFocus = new ManejadorFocus();
		spinnerFue.addFocusListener(EscuchadorFocus);
		spinnerDes.addFocusListener(EscuchadorFocus);
		spinnerCon.addFocusListener(EscuchadorFocus);
		spinnerInt.addFocusListener(EscuchadorFocus);
		spinnerSab.addFocusListener(EscuchadorFocus);
		spinnerCar.addFocusListener(EscuchadorFocus);
		
		ManejadorKey EscuchadorKey = new ManejadorKey();
		spinnerFue.addKeyListener(EscuchadorKey);
		spinnerDes.addKeyListener(EscuchadorKey);
		spinnerCon.addKeyListener(EscuchadorKey);
		spinnerInt.addKeyListener(EscuchadorKey);
		spinnerSab.addKeyListener(EscuchadorKey);
		spinnerCar.addKeyListener(EscuchadorKey);
	}
	
	/**
	 * Crear la clase ManejadorFocus implementando FocusListener para llevar control que componente esta seleccionado
	 * Controla los eventos al cambiar focus
	 */

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
		}
	}

	/**
	 * Crear la clase ManejadorKey implementando KeyListener para llevar control de los teclas precionadas
	 * Controla los eventos al precionar cada tecla, y segun el componente sobre el cual se esta escribiendo
	 */
	private class ManejadorKey implements KeyListener { // Manejador Key

		public void keyTyped(KeyEvent EventKey) {

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

	}

	public OEstadisticas getEstadisticas() {
		int fue = Integer.parseInt(spinnerFue.getValue().toString());
		int des = Integer.parseInt(spinnerDes.getValue().toString());
		int con = Integer.parseInt(spinnerCon.getValue().toString());
		int inte = Integer.parseInt(spinnerInt.getValue().toString());
		int sab = Integer.parseInt(spinnerSab.getValue().toString());
		int car = Integer.parseInt(spinnerCar.getValue().toString());
		OEstadisticas estadisticas = new OEstadisticas(fue, des, con, inte, sab, car);
		return estadisticas;

	}

	public void setEstadisticas(OEstadisticas estadisticas) {
	
	
	}

}
