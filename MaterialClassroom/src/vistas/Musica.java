package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Musica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1407073013334398117L;
	private JPanel contentPane;
	private JButton btnInicio;
	private JButton btnDetener;
	public Clip Audio;
	//determina la ruta de donde se optiene el sonido
	public String ruta = "/sonido/alarma.wav";
	private JSlider slider;
	private JLabel lbSlider;
	private FloatControl ControlVolumen;
	//se determina el volumen de sonido inicial en decibeles
	private float Volumen = -37.0f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Musica frame = new Musica();
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
	public Musica() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnInicio = new JButton("Play");
		btnInicio.setBounds(123, 227, 89, 23);
		contentPane.add(btnInicio);

		btnDetener = new JButton("Detener");
		btnDetener.setBounds(303, 227, 89, 23);
		contentPane.add(btnDetener);

		slider = new JSlider(-80,6,-37);
		slider.setMinimum(-80);
		slider.setMaximum(6);
		slider.setBounds(140, 107, 200, 26);
		contentPane.add(slider);

		lbSlider = new JLabel();
		lbSlider.setText(Integer.toString(slider.getValue())+"dB");
		lbSlider.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lbSlider.setBounds(167, 144, 150, 37);
		contentPane.add(lbSlider);

		ControladorBoton EscuchadorBoton = new ControladorBoton();
		btnInicio.addActionListener(EscuchadorBoton);
		btnDetener.addActionListener(EscuchadorBoton);

		ControlChange EscuchadorChange = new ControlChange();
		slider.addChangeListener(EscuchadorChange);
	}

	public class ControlChange implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() == slider) {
			
					lbSlider.setText(Volumen+"dB");
					Volumen= slider.getValue();									
					ControlVolumen = (FloatControl) Audio.getControl(FloatControl.Type.MASTER_GAIN);
					ControlVolumen.setValue(Volumen); // Reduce volume by 10 decibels.

			}

		}

	}

	public class ControladorBoton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnInicio) {
				try {
					
					Audio = AudioSystem.getClip();
					Audio.open(AudioSystem.getAudioInputStream(getClass().getResource(ruta)));
					ControlVolumen = (FloatControl) Audio.getControl(FloatControl.Type.MASTER_GAIN);
					ControlVolumen.setValue(Volumen); // Reduce volume by 10 decibels.		
					System.out.println("Datos0 "+		Audio.isActive());
					Audio.loop(10);
				
					System.out.println("Datos1 "+		Audio.available());
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
					JOptionPane.showMessageDialog(null, "Error en audio:\n" + ex.getMessage());
				}
			}
			if (e.getSource() == btnDetener) {
				
			if (Audio.isActive()) {
				Audio.stop();
			}else {
				
			}
				

			}

		}
	}
}
