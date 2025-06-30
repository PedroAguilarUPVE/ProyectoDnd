package vistas;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modelos.OPersonaje;

public class CrearPartida extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ResourceBundle et;
	private JButton btnReporte;
	private JButton btnCargarPer;
	private int idPersonaje;
	private PanelPersonaje panelPersonaje1;
	public JTextArea textArea;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		try {
			CrearPartida dialog = new CrearPartida(Menu.this, true, Idioma);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 */
	/**
	 * Create the dialog.
	 */
	public CrearPartida(Frame parent, boolean modal, Locale Idioma) {
		super(parent, modal);// se inicializa el constructor super
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		PanelPersonaje.Idioma = Idioma;
		et = ResourceBundle.getBundle("properties/dic", Idioma);
		setBounds(100, 100, 1040, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(180, 10, 120, 20);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 460, 240);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panelPersonaje1 = new PanelPersonaje(CrearPartida.this,true,Idioma,5);
		panelPersonaje1.setBounds(0, 0, 460, 200);
		panel.add(panelPersonaje1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(150, 210, 90, 20);
		panel.add(btnNewButton);
		
		btnCargarPer = new JButton("Cargar Personaje");
		btnCargarPer.setBounds(330, 210, 120, 20);
		panel.add(btnCargarPer);
		panelPersonaje1.setVisible(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 40, 500, 680);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(510, 730, 85, 21);
		contentPanel.add(btnReporte);
		
		ManejadorBoton EscuchadorBoton = new ManejadorBoton();
		btnCargarPer.addActionListener(EscuchadorBoton);
		
		///
		//tablaPersonajes Ventana = new tablaPersonajes(CrearPartida.this, true);
		//Ventana.setVisible(true);
		//idPersonaje = Ventana.idSeleccionadoPersonaje;
		
		//System.out.println("valor de contador_________________________ "+idPersonaje);
		
		///
	}
	
	private class ManejadorBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnCargarPer)) {
				OPersonaje Personaje1 = new OPersonaje();
				tablaPersonajes AgregarPersonaje = new tablaPersonajes(CrearPartida.this,true);
				AgregarPersonaje.setVisible(true);
				int idSeleccionado = AgregarPersonaje.idSeleccionadoPersonaje;
				panelPersonaje1.cargarDatosPersonaje(idSeleccionado);
				textArea.setText(textArea.getText()+"Comentario \n");
			}
		}
	}
	
	public void AgregarMensaje(String Cadena) {
		textArea.setText(textArea.getText()+"\n"+Cadena);
	}
}
