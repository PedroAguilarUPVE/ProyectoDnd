package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CrearPartida extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ResourceBundle et;

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
		
		PanelPersonaje Personaje1 = new PanelPersonaje(null,true,Idioma,5);
		Personaje1.setBounds(0, 0, 460, 200);
		panel.add(Personaje1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(350, 210, 90, 20);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(250, 210, 90, 20);
		panel.add(btnNewButton_1);
		Personaje1.setVisible(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 40, 500, 680);
		contentPanel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
