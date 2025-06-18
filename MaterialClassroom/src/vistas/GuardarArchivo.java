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

public class GuardarArchivo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton BtnGuardar;
	private JButton BtnEliminar;
	private JTextArea textArea;
	private JScrollPane JscrollPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuardarArchivo frame = new GuardarArchivo();
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
	public GuardarArchivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		BtnGuardar = new JButton("Guardar");
		BtnGuardar.setBounds(85, 227, 89, 23);
		contentPane.add(BtnGuardar);

		BtnEliminar = new JButton("Eliminar");
		BtnEliminar.setBounds(259, 227, 89, 23);
		contentPane.add(BtnEliminar);

		textArea = new JTextArea();

		JscrollPanel = new JScrollPane();
		JscrollPanel.setBounds(10, 39, 414, 177);
		contentPane.add(JscrollPanel);
		JscrollPanel.setViewportView(textArea);

		ManejadorBoton Escuchador = new ManejadorBoton();
		BtnGuardar.addActionListener(Escuchador);
		BtnEliminar.addActionListener(Escuchador);
	}

	private class ManejadorBoton implements ActionListener {

		private BufferedWriter Escribir;
		private File Archivo;
		private FileWriter ArchivoEscritura;
		

		@Override
		public void actionPerformed(ActionEvent EventoBoton) {
            FileNameExtensionFilter FiltroArchivos = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");

			// VALIDAMOS QUE EL BOTON GUARDAR ES PRESIONADO
			if (EventoBoton.getSource().equals(BtnGuardar)) {
				// valida que el componente contenga información para guardar
				if (!textArea.getText().isEmpty()) {
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

				} // if Validar contenido
				else {
					JOptionPane.showMessageDialog(null, "No es Posible Guardar Archivos Vacios", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} // if de evento de Boton

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
		}
	}
}