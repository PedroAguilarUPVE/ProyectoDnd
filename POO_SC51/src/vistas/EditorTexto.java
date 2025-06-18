package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditorTexto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JButton btnGuardar;
    private JButton BtnEliminar;
    private JButton btnRenombrar; // Nuevo botón para renombrar
    private JTextArea textArea;
	private JButton btnInformacion;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditorTexto frame = new EditorTexto();
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
    public EditorTexto() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 23, 414, 191);
        scrollPane.setViewportView(textArea);
        contentPane.add(scrollPane);

        BtnEliminar = new JButton("Eliminar");
        BtnEliminar.setBounds(15, 227, 89, 23);
        contentPane.add(BtnEliminar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(223, 227, 89, 23);
        contentPane.add(btnGuardar);

        btnRenombrar = new JButton("Renombrar"); // Inicializar el botón Renombrar
        btnRenombrar.setBounds(119, 227, 89, 23); // Posicionar el botón
        contentPane.add(btnRenombrar);
        
        btnInformacion = new JButton("Información");
        btnInformacion.setBounds(327, 225, 89, 23);
        contentPane.add(btnInformacion);

        ManejadorBoton Escuchador = new ManejadorBoton();
        btnGuardar.addActionListener(Escuchador);
        BtnEliminar.addActionListener(Escuchador);
        btnRenombrar.addActionListener(Escuchador); // Agregar el escuchador al botón Renombrar
        btnInformacion.addActionListener(Escuchador);
    }

    private class ManejadorBoton implements ActionListener {

        // Variables que permiten el manejo de Archivos Fisicos
        private BufferedWriter Escribir;
        private File Archivo;
        private FileWriter ArchivoEscritura;
		private String NuevoNombre;
		private File NuevoArchivo;

        @Override
        public void actionPerformed(ActionEvent EventoBoton) {
            // Inicializamos variable par filtro de tipo de Archivo
            FileNameExtensionFilter FiltroArchivos;
            FiltroArchivos = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");

            // identificar que boton genera un evento
            if (EventoBoton.getSource().equals(btnGuardar)) {
                if (textArea.getText().isEmpty() || textArea.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "El Archivo No debe Estar Vacio", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } // if validación textArea
                else {
                    // Crear un JFileChooser para seleccionar la ruta de Guardado
                    JFileChooser RutaArchivo = new JFileChooser();
                    RutaArchivo.setDialogTitle("Guardar Texto en Un Archivo");
                    RutaArchivo.setFileFilter(FiltroArchivos);

                    // Se declara una variable tipo entero para identificar el Estatus de selección
                    int TipoSeleccion = RutaArchivo.showSaveDialog(RutaArchivo);

                    // identificar la accion realizada en el JFileChooser (cerrar, guarda, cancelar,
                    // etc.)
                    if (TipoSeleccion == JFileChooser.APPROVE_OPTION) {
                        // se Declara una variable de tipo Archivo
                        Archivo = RutaArchivo.getSelectedFile();

                        try {
                            ArchivoEscritura = new FileWriter(Archivo);

                            Escribir = new BufferedWriter(ArchivoEscritura);

                            Escribir.write(textArea.getText());
                            Escribir.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                    } // if de identificación acción JFileChooser

                }
            } // fin btnGuardar

            // VALIDAMOS QUE EL BOTON ELIMINAR ES PRESIONADO
            if (EventoBoton.getSource().equals(BtnEliminar)) {
                // Filtrar solo archivos .txt
                // Crear un JFileChooser para seleccionar el archivo a eliminar
                JFileChooser RutaArchivo = new JFileChooser();
                RutaArchivo.setDialogTitle("Seleccionar Archivo a Eliminar");
                RutaArchivo.setFileFilter(FiltroArchivos);
                int TipoSeleccion = RutaArchivo.showOpenDialog(RutaArchivo);

                // identificar la accion realizada en el JFileChooser (cerrar, abrir, cancelar,
                // etc.)
                if (TipoSeleccion == JFileChooser.APPROVE_OPTION) {
                    Archivo = RutaArchivo.getSelectedFile();

                    // Verificar si el archivo existe y eliminarlo
                    if (Archivo.exists()) {
                        boolean eliminado = Archivo.delete();
                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Archivo eliminado correctamente", "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

            // VALIDAMOS QUE EL BOTON RENOMBRAR ES PRESIONADO
            if (EventoBoton.getSource().equals(btnRenombrar)) {
                // Crear un JFileChooser para seleccionar el archivo a renombrar
                JFileChooser RutaArchivo = new JFileChooser();
                RutaArchivo.setDialogTitle("Seleccionar Archivo a Renombrar");
                RutaArchivo.setFileFilter(FiltroArchivos);
                int TipoSeleccion = RutaArchivo.showOpenDialog(RutaArchivo);

                // identificar la accion realizada en el JFileChooser (cerrar, abrir, cancelar,
                // etc.)
                if (TipoSeleccion == JFileChooser.APPROVE_OPTION) {
                    Archivo = RutaArchivo.getSelectedFile();

                    // Verificar si el archivo existe
                    if (Archivo.exists()) {
                        // Solicitar el nuevo nombre del archivo
                         NuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del archivo (sin extensión):");

                        if (NuevoNombre != null && !NuevoNombre.isEmpty()) {
                            // Crear el nuevo archivo con el nombre ingresado
                             NuevoArchivo = new File(Archivo.getParent(), NuevoNombre + ".txt");

                            // Renombrar el archivo
                            boolean renombrado = Archivo.renameTo(NuevoArchivo);

                            if (renombrado) {
                                JOptionPane.showMessageDialog(null, "Archivo renombrado correctamente", "Éxito",
                                        JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo renombrar el archivo", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            
            if (EventoBoton.getSource().equals(btnInformacion)) {
            	 // Crear un JFileChooser para seleccionar el archivo a renombrar
                JFileChooser RutaArchivo = new JFileChooser();
                RutaArchivo.setDialogTitle("Seleccionar Archivo a Renombrar");
                RutaArchivo.setFileFilter(FiltroArchivos);
                int TipoSeleccion = RutaArchivo.showOpenDialog(RutaArchivo);

                // identificar la accion realizada en el JFileChooser (cerrar, abrir, cancelar,
                // etc.)
                if (TipoSeleccion == JFileChooser.APPROVE_OPTION) {
                	Archivo = RutaArchivo.getSelectedFile();
                	
                    JOptionPane.showMessageDialog(null,Archivo.getAbsolutePath(), "Información El archivo Existente", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Archivo.getName(), "Información El archivo Existente", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Archivo.getTotalSpace(), "Información El archivo Existente", JOptionPane.INFORMATION_MESSAGE);

                	
                }//fin elemento aprovado para la selección
            	
            }//finBotonInformación
            
        }
    }
}