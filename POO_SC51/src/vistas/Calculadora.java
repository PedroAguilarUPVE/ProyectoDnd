
package vistas;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
					//Quitar

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {
																//Variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pantalla;

	public static String Valor = "0";
	public static double Memoria1 = 0;
	public static double Memoria2 = 0;
	public static double Resultado = 0;
	public static int Numero =0;
	public static int Random =0;
	public static int Operacion=0;
	public static boolean Flag=true;
	public static boolean Flag2=true;
	
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnMas;
	private JButton btnMenos;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnPor;
	private JButton btnPunto;
	private JButton btn0;
	private JButton btnIgual;
	private JButton btnEntre;
	private JButton btnBorrar;
	private JLabel lblMemoria1;
	private JLabel lblMemoria2;
	private JLabel lblPantalla;
	private JLabel lblOperacion;
	private JButton btnAtras;
	private JButton btnSeno;
	private JButton btnCoseno;
	private JButton btnPorcentaje;
	private JButton btnPotencia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {											//Diseño
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pantalla = new JTextField();
		pantalla.setForeground(new Color(0, 0, 0));
		pantalla.setEditable(false);
		pantalla.setBounds(3, 5, 176, 40);
		contentPane.add(pantalla);
		pantalla.setColumns(10);
		
		btn7 = new JButton("7");
		btn7.setBackground(SystemColor.controlShadow);
		btn7.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn7.setBounds(3, 50, 86, 80);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBackground(SystemColor.controlShadow);
		btn8.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn8.setBounds(94, 50, 86, 80);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBackground(SystemColor.controlShadow);
		btn9.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn9.setBounds(183, 50, 86, 80);
		contentPane.add(btn9);
		
		btnMas = new JButton("+");
		btnMas.setBackground(new Color(144, 238, 144));
		btnMas.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnMas.setBounds(274, 50, 86, 80);
		contentPane.add(btnMas);
		
		btn4 = new JButton("4");
		btn4.setBackground(SystemColor.controlShadow);
		btn4.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn4.setBounds(3, 135, 86, 80);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBackground(SystemColor.controlShadow);
		btn5.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn5.setBounds(94, 135, 86, 80);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBackground(SystemColor.controlShadow);
		btn6.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn6.setBounds(183, 135, 86, 80);
		contentPane.add(btn6);
		
		btnMenos = new JButton("-");
		btnMenos.setBackground(new Color(144, 238, 144));
		btnMenos.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnMenos.setBounds(274, 135, 86, 80);
		contentPane.add(btnMenos);
		
		btn1 = new JButton("1");
		btn1.setBackground(SystemColor.controlShadow);
		btn1.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn1.setBounds(3, 220, 86, 80);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBackground(SystemColor.controlShadow);
		btn2.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn2.setBounds(94, 220, 86, 80);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBackground(SystemColor.controlShadow);
		btn3.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn3.setBounds(183, 220, 86, 80);
		contentPane.add(btn3);
		
		btnPor = new JButton("*");
		btnPor.setBackground(new Color(144, 238, 144));
		btnPor.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnPor.setBounds(274, 220, 86, 80);
		contentPane.add(btnPor);
		
		btnPunto = new JButton(".");
		btnPunto.setBackground(Color.ORANGE);
		btnPunto.setForeground(Color.BLACK);
		btnPunto.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnPunto.setBounds(3, 305, 86, 80);
		contentPane.add(btnPunto);
		
		btn0 = new JButton("0");
		btn0.setBackground(SystemColor.controlShadow);
		btn0.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btn0.setBounds(94, 305, 86, 80);
		contentPane.add(btn0);
		
		btnIgual = new JButton("=");
		btnIgual.setBackground(Color.ORANGE);
		btnIgual.setForeground(Color.BLACK);
		btnIgual.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnIgual.setBounds(183, 305, 86, 80);
		contentPane.add(btnIgual);
		
		btnEntre = new JButton("/");
		btnEntre.setBackground(new Color(144, 238, 144));
		btnEntre.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnEntre.setBounds(274, 305, 86, 80);
		contentPane.add(btnEntre);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(Color.ORANGE);
		btnBorrar.setForeground(Color.BLACK);
		btnBorrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btnBorrar.setBounds(274, 5, 86, 40);
		contentPane.add(btnBorrar);
		
		lblMemoria1 = new JLabel("Memoria");
		lblMemoria1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMemoria1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblMemoria1.setBounds(44, 468, 45, 13);
		contentPane.add(lblMemoria1);
		
		lblMemoria2 = new JLabel("Memoria2");
		lblMemoria2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMemoria2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblMemoria2.setBounds(134, 468, 45, 13);
		contentPane.add(lblMemoria2);
		
		lblPantalla = new JLabel("Pantalla");
		lblPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPantalla.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblPantalla.setBounds(224, 468, 45, 13);
		contentPane.add(lblPantalla);
		
		lblOperacion = new JLabel("Operacion");
		lblOperacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOperacion.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblOperacion.setBounds(315, 468, 45, 13);
		contentPane.add(lblOperacion);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBackground(Color.ORANGE);
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btnAtras.setBounds(183, 5, 86, 40);
		contentPane.add(btnAtras);
		
		btnSeno = new JButton("Seno");
		btnSeno.setBackground(new Color(144, 238, 144));
		btnSeno.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnSeno.setBounds(3, 389, 86, 80);
		contentPane.add(btnSeno);
		
		btnCoseno = new JButton("Cos");
		btnCoseno.setBackground(new Color(144, 238, 144));
		btnCoseno.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnCoseno.setBounds(94, 389, 86, 80);
		contentPane.add(btnCoseno);
		
		btnPorcentaje = new JButton("%");
		btnPorcentaje.setBackground(new Color(144, 238, 144));
		btnPorcentaje.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnPorcentaje.setBounds(183, 389, 86, 80);
		contentPane.add(btnPorcentaje);
		
		btnPotencia = new JButton("^");
		btnPotencia.setBackground(new Color(144, 238, 144));
		btnPotencia.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnPotencia.setBounds(274, 389, 86, 80);
		contentPane.add(btnPotencia);
		
		JLabel lblOperacion_1 = new JLabel("Operacion");
		lblOperacion_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblOperacion_1.setBounds(274, 468, 54, 13);
		contentPane.add(lblOperacion_1);
		
		JLabel lblPantalla_1 = new JLabel("Pantalla");
		lblPantalla_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblPantalla_1.setBounds(183, 468, 45, 13);
		contentPane.add(lblPantalla_1);
		
		JLabel lblMemoria2_1 = new JLabel("Memoria2");
		lblMemoria2_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblMemoria2_1.setBounds(94, 468, 54, 13);
		contentPane.add(lblMemoria2_1);
		
		JLabel lblMemoria1_1 = new JLabel("Memoria");
		lblMemoria1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblMemoria1_1.setBounds(3, 468, 45, 13);
		contentPane.add(lblMemoria1_1);
		

		ManejadorBotones EscuchadorBotones = new ManejadorBotones();	//Manejador de botones
		btn1.addActionListener(EscuchadorBotones);
		btn2.addActionListener(EscuchadorBotones);
		btn3.addActionListener(EscuchadorBotones);
		btn4.addActionListener(EscuchadorBotones);
		btn5.addActionListener(EscuchadorBotones);
		btn6.addActionListener(EscuchadorBotones);
		btn7.addActionListener(EscuchadorBotones);
		btn8.addActionListener(EscuchadorBotones);
		btn9.addActionListener(EscuchadorBotones);
		btn0.addActionListener(EscuchadorBotones);
		btnMas.addActionListener(EscuchadorBotones);
		btnMenos.addActionListener(EscuchadorBotones);
		btnPor.addActionListener(EscuchadorBotones);
		btnEntre.addActionListener(EscuchadorBotones);
		btnSeno.addActionListener(EscuchadorBotones);
		btnCoseno.addActionListener(EscuchadorBotones);
		btnPorcentaje.addActionListener(EscuchadorBotones);
		btnPotencia.addActionListener(EscuchadorBotones);
		btnIgual.addActionListener(EscuchadorBotones);
		btnPunto.addActionListener(EscuchadorBotones);
		btnBorrar.addActionListener(EscuchadorBotones);
		btnAtras.addActionListener(EscuchadorBotones);
		
		
	} // Fin Calculadora
	
	private class ManejadorBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent Evento) {
			// TODO Auto-generated method stub	
			//Botones Numeros

			if (Evento.getSource().equals(btn1)) {
				if (Flag2) { Limpiar(); }
				Valor+="1";				
			}
			if (Evento.getSource().equals(btn2)) {
				if (Flag2) { Limpiar(); }
				Valor+="2";
			}
			if (Evento.getSource().equals(btn3)) {
				if (Flag2) { Limpiar(); }
				Valor+="3";
			}
			if (Evento.getSource().equals(btn4)) {
				if (Flag2) { Limpiar(); }
				Valor+="4";
			}
			if (Evento.getSource().equals(btn5)) {
				if (Flag2) { Limpiar(); }
				Valor+="5";
			}
			if (Evento.getSource().equals(btn6)) {
				if (Flag2) { Limpiar(); }
				Valor+="6";
			}
			if (Evento.getSource().equals(btn7)) {
				if (Flag2) { Limpiar(); }
				Valor+="7";
			}
			if (Evento.getSource().equals(btn8)) {
				if (Flag2) { Limpiar(); }
				Valor+="8";
			}
			if (Evento.getSource().equals(btn9)) {
				if (Flag2) { Limpiar(); }
				Valor+="9";
			}
			if (Evento.getSource().equals(btn0)) {
				if (Flag2) { Limpiar(); }
				Valor+="0";
			}
			
			//Botones Operacion
			if (Evento.getSource().equals(btnMas)) {		//Boton Mas
				if (Flag) {
					Memoria2 = Double.parseDouble(Valor);
					Memoria1 = Resultado(Operacion,Memoria1,Memoria2);
				}else { Memoria1 = Double.parseDouble(Valor);}
				Operacion = 1;
				Flag = true;
				Flag2 = false;
				Valor="0";
			}

			if (Evento.getSource().equals(btnMenos)) {		//Boton Menos
				if (Flag) {
					Memoria2 = Double.parseDouble(Valor);
					Memoria1 = Resultado(Operacion,Memoria1,Memoria2);
				}else { Memoria1 = Double.parseDouble(Valor);}
				Operacion = 2;
				Flag = true;
				Flag2 = false;
				Valor="0";
			}
			if (Evento.getSource().equals(btnPor)) {		//Boton Por
				if (Flag) {
					Memoria2 = Double.parseDouble(Valor);
					Memoria1 = Resultado(Operacion,Memoria1,Memoria2);
				}else { Memoria1 = Double.parseDouble(Valor);}
				Operacion = 3;
				Flag = true; 
				Flag2 = false;
				Valor="0";
			}
			if (Evento.getSource().equals(btnEntre)) {		//Boton Entre
				if (Flag) {
					Memoria2 = Double.parseDouble(Valor);
					Memoria1 = Resultado(Operacion,Memoria1,Memoria2);
				}else { Memoria1 = Double.parseDouble(Valor);}
				Operacion = 4;
				Flag = true;
				Flag2 = false;
				Valor="0";
			}
			if (Evento.getSource().equals(btnIgual)) {		//Boton Igual
				
				if (Flag) {
					Memoria2 = Double.parseDouble(Valor);
					Flag=false;
				}
				Memoria1 = Resultado(Operacion,Memoria1,Memoria2);
				Valor=Double.toString(Memoria1);
				Flag2 = true;
			}
			if (Evento.getSource().equals(btnPunto)) {		//Boton Punto
				if (!Valor.contains(".")) {
					Valor+=".";
				}	
			}
			if (Evento.getSource().equals(btnBorrar)) {
					Valor="0";
					Memoria1=0;
					Memoria2=0;
					Operacion=0;
					Flag = false;
			}

			if (Evento.getSource().equals(btnAtras)) {
				if (Valor.length()>1) {	Valor = Valor.substring(0, Valor.length()-1);	} else {Valor="0";}
			}
			if (Evento.getSource().equals(btnSeno)) {  // Seno
	            double radianes = Math.toRadians(Double.parseDouble(Valor));
	            Valor = String.valueOf(Math.sin(radianes));
	        }

	        if (Evento.getSource().equals(btnCoseno)) {  // Coseno
	            double radianes = Math.toRadians(Double.parseDouble(Valor));
	            Valor = String.valueOf(Math.cos(radianes));
	        }

	        if (Evento.getSource().equals(btnPorcentaje)) { // Boton Porcentaje
	            if (Flag) {
	                Memoria2 = Double.parseDouble(Valor);
	                Memoria1 = Resultado(Operacion, Memoria1, Memoria2);
	            } else { 
	                Memoria1 = Double.parseDouble(Valor);
	            }
	            Operacion = 5; // Boton porcentaje
	            Flag = true;
	            Flag2 = false;
	            Valor = "0";
	        }

	        if (Evento.getSource().equals(btnPotencia)) { // Boton Potencia
	            if (Flag) {
	                Memoria2 = Double.parseDouble(Valor);
	                Memoria1 = Resultado(Operacion, Memoria1, Memoria2);
	            } else { 
	                Memoria1 = Double.parseDouble(Valor);
	            }
	            Operacion = 6; // Potencia
	            Flag = true;
	            Flag2 = false;
	            Valor = "0";
	        }

			pantalla.setText(Valor);
			lblMemoria1.setText(Double.toString(Memoria1));
			lblMemoria2.setText(Double.toString(Memoria2));
			lblPantalla.setText(Valor);
			lblOperacion.setText(Operacion+"");

		}	
	} //Fin ManejadorBotones
	
	public static double Resultado (int operacion, double num1, double num2) {
	    double resultado = 0;
	    switch (operacion) {
	        case 0: 
	            resultado = num2;
	            break;
	        case 1: // Suma
	            resultado = num1 + num2;
	            break;
	        case 2: // Resta
	            resultado = num1 - num2;
	            break;
	        case 3: // Multiplicación
	            resultado = num1 * num2;
	            break;
	        case 4: // División
	            resultado = num1 / num2;
	            break;
	        case 5: // Porcentaje
	            resultado = (num1 * num2) / 100;
	            break;
	        case 6: // Potencia (num1 elevado a num2)
	            resultado = Math.pow(num1, num2);
	            break;
	    }
	    return resultado;
	}

	
	public static void Limpiar () {
		
		Valor="";
		Operacion=0;
		Memoria2=0;
		Memoria1=0;
		Flag = true;
		Flag2 = false;
	}
}
