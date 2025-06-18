package vistas;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DatosEntrada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textFieldNombre;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosEntrada frame = new DatosEntrada();
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
	public DatosEntrada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre Usuario:");
		lblNewLabel.setBounds(10, 33, 108, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(162, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(113, 30, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		 ManejadorKey EscuchadorKey = new ManejadorKey();
		 textFieldNombre.addKeyListener(EscuchadorKey);
		 
	}
	
	private class ManejadorKey implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		    char c = e.getKeyChar();

		    // Permitir letras, espacios, backspace y delete
		    if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != ' ') {
		        e.consume(); // Ignorar el evento si no cumple con las condiciones

		        // Mostrar mensaje de error
		        JOptionPane.showMessageDialog(null, 
		            "Solo se permiten letras y espacios.", 
		            "Error de entrada", 
		            javax.swing.JOptionPane.ERROR_MESSAGE);
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
		
	}
}
