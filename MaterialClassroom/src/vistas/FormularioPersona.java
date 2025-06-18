package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPersona extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField campoNombre;
    private JTextField campoEdad;
    private JTextField campoDireccion;
    private JButton botonAceptar;
    private JButton botonCancelar;

    public FormularioPersona() {
        // Configuración de la ventana
        setTitle("Formulario de Persona");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Crear etiquetas y campos de texto
        JLabel etiquetaNombre = new JLabel("Nombre:");
        campoNombre = new JTextField();

        JLabel etiquetaEdad = new JLabel("Edad:");
        campoEdad = new JTextField();

        JLabel etiquetaDireccion = new JLabel("Dirección:");
        campoDireccion = new JTextField();

        // Crear botones
        botonAceptar = new JButton("Aceptar");
        botonCancelar = new JButton("Cancelar");

        // Agregar componentes al panel
        panel.add(etiquetaNombre);
        panel.add(campoNombre);
        panel.add(etiquetaEdad);
        panel.add(campoEdad);
        panel.add(etiquetaDireccion);
        panel.add(campoDireccion);
        panel.add(botonAceptar);
        panel.add(botonCancelar);

        // Agregar el panel a la ventana
        add(panel);

        // Configurar acciones para los botones
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String edad = campoEdad.getText();
                String direccion = campoDireccion.getText();

                // Mostrar los datos en un cuadro de diálogo
                JOptionPane.showMessageDialog(FormularioPersona.this,
                        "Nombre: " + nombre + "\nEdad: " + edad + "\nDirección: " + direccion,
                        "Datos de la Persona",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos
                campoNombre.setText("");
                campoEdad.setText("");
                campoDireccion.setText("");
            }
        });
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormularioPersona formulario = new FormularioPersona();
                formulario.setVisible(true);
            }
        });
    }
}