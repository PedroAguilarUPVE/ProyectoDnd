package vistas;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Splash extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread Tiempo = null;
	private JLabel JLabelSplash;
	private Cursor CursorImg;
	private URL Ruta;
	private GroupLayout layout;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
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
	public Splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		InicalizarComponentes();
		

		this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/userLabel.png")).getImage());
		this.setLocationRelativeTo(null);
		Tiempo = new Thread(this);
		Tiempo.start();
	}

	
	private void InicalizarComponentes() {

		JLabelSplash = new JLabel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		Ruta = getClass().getResource("/imagenes/splashgif.gif");
		Icon Imagen = new ImageIcon(Ruta);
		JLabelSplash.setIcon(Imagen);
		CursorImg = new Cursor(Cursor.WAIT_CURSOR);
		JLabelSplash.setCursor(CursorImg);

		layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(JLabelSplash));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(JLabelSplash));
	pack();
	}
	

	public void run() {
		try {//5000 son los milisegundos que durara la  imagen se splash
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		LoginUser LoginUser=new LoginUser();
		LoginUser.setVisible(true);
		this.dispose();

	}
}
