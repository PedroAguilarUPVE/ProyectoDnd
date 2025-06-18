package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DeepSeekSwingApp extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField JtfEnvio;
    private JTextArea AreaSalida;
    private JButton BtnEnvio;
	private JPanel PanelPrincipal;
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DeepSeekSwingApp().setVisible(true);
            }
        });
    }

    public DeepSeekSwingApp() {
    
        setTitle("DeepSeek API en Java Swing");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JtfEnvio = new JTextField(20);
        AreaSalida = new JTextArea(10, 30);
        AreaSalida.setEditable(false);
        BtnEnvio = new JButton("Enviar");

        BtnEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JtfEnvio.getText();
                String response = DeepSeekAPI.sendRequest(input);
                AreaSalida.setText(response);
            }
        });

        PanelPrincipal = new JPanel();
        PanelPrincipal.add(new JLabel("Entrada:"));
        PanelPrincipal.add(JtfEnvio);
        PanelPrincipal.add(BtnEnvio);
        PanelPrincipal.add(new JScrollPane(AreaSalida));
        getContentPane().add(PanelPrincipal);
    }

    
}
