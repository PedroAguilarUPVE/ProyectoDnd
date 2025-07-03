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
	private int idPersonaje;
	public JTextArea textArea;
	private PanelPersonaje panelPersonaje1;
	private PanelPersonaje panelPersonaje2;
	private PanelPersonaje panelPersonaje3;

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
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 40, 500, 680);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText("");
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(510, 730, 85, 21);
		contentPanel.add(btnReporte);
		
		panelPersonaje1 = new PanelPersonaje(CrearPartida.this,true,Idioma,0);
		panelPersonaje1.setBounds(10, 40, 460, 200);
		contentPanel.add(panelPersonaje1);
		panelPersonaje1.setVisible(true);
		
		panelPersonaje2 = new PanelPersonaje(CrearPartida.this,true,Idioma,0);
		panelPersonaje2.setBounds(10, 260, 460, 200);
		contentPanel.add(panelPersonaje2);
		panelPersonaje2.setVisible(true);
		
		panelPersonaje3 = new PanelPersonaje(CrearPartida.this,true,Idioma,0);
		panelPersonaje3.setBounds(10, 480, 460, 200);
		contentPanel.add(panelPersonaje3);
		panelPersonaje3.setVisible(true);
		


		///
		//tablaPersonajes Ventana = new tablaPersonajes(CrearPartida.this, true);
		//Ventana.setVisible(true);
		//idPersonaje = Ventana.idSeleccionadoPersonaje;
		
		//System.out.println("valor de contador_________________________ "+idPersonaje);
		
		///
	}
	
	public void AgregarMensaje(String Cadena) {
		textArea.setText(textArea.getText()+Cadena+"\n");
	}
}
