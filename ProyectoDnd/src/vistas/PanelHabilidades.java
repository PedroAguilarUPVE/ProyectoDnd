package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import modelos.OEstadisticas;

/**
 * Clase PanelHabilidades (Vacio) Componente encargado de contener los
 * controladores de habilidades de un personaje o clase y poder acceder a sus
 * valores
 */
public class PanelHabilidades extends JPanel {

	private static final long serialVersionUID = 1L;
	public static int HabilidadesSeleccionadas = 0;
	public static int MaxHabilidades = 4;
	private Container panelCreacion;
	private JLabel lblEngano;
	private JLabel lblArcano;
	private JLabel lblHistoria;
	private JLabel lblInterpretacion;
	private JLabel lblAtletismo;
	private JLabel lblAcrobacias;
	private JLabel lblHabilidades;
	private ResourceBundle et;
	private JRadioButton rdbtnAtletismo;
	private JRadioButton rdbtnArcano;
	private JRadioButton rdbtnInterpretacion;
	private JRadioButton rdbtnHistoria;
	private JRadioButton rdbtnEngano;
	private JRadioButton rdbtnAcrobacias;
	private JLabel lblPercepcion;
	private JLabel lblNaturaleza;
	private JLabel lblMedicina;
	private JLabel lblManos;
	private JLabel lblInvestigacion;
	private JLabel lblIntimidacion;
	private JRadioButton rdbtnPercepcion;
	private JRadioButton rdbtnNaturaleza;
	private JRadioButton rdbtnMedicina;
	private JRadioButton rdbtnManos;
	private JRadioButton rdbtnInvestigacion;
	private JRadioButton rdbtnIntimidacion;
	private JRadioButton rdbtnPerspicacia;
	private JRadioButton rdbtnPersuacion;
	private JRadioButton rdbtnReligion;
	private JRadioButton rdbtnSigilo;
	private JRadioButton rdbtnSupervivencia;
	private JRadioButton rdbtnTratoAnimal;
	private JLabel lblTratoAnimal;
	private JLabel lblSupervivencia;
	private JLabel lblSigilo;
	private JLabel lblReligion;
	private JLabel lblPersuacion;
	private JLabel lblPerspicacia;
	private int ModFue;
	private int ModDes;
	private int ModCon;
	private int ModInt;
	private int ModSab;
	private int ModCar;
	private int ModCompetencia = 2;
	private OEstadisticas Estadisticas;
	
	/**
	 * Create the panel.
	 */
	public PanelHabilidades(Locale Idioma) {
//		super(parent, modal);// se inicializa el constructor super
//		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

//		 Obtener el idioma por defecto del sistema
//		Idioma = Locale.getDefault(); // Idioma de sistema

//		 Idioma = new Locale("en","US"); 
//		System.out.println(Idioma.getDisplayName()); 
//		System.out.println("====================");

		et = ResourceBundle.getBundle("properties/dic", Idioma);
		setLayout(null);

		lblEngano = new JLabel("0");
		lblEngano.setBounds(86, 73, 16, 13);
		add(lblEngano);
		lblEngano.setHorizontalAlignment(SwingConstants.CENTER);

		lblArcano = new JLabel("0");
		lblArcano.setBounds(86, 57, 16, 13);
		add(lblArcano);
		lblArcano.setHorizontalAlignment(SwingConstants.CENTER);

		lblHistoria = new JLabel("0");
		lblHistoria.setBounds(86, 87, 16, 13);
		add(lblHistoria);
		lblHistoria.setHorizontalAlignment(SwingConstants.CENTER);

		lblInterpretacion = new JLabel("0");
		lblInterpretacion.setBounds(86, 102, 16, 13);
		add(lblInterpretacion);
		lblInterpretacion.setHorizontalAlignment(SwingConstants.CENTER);

		lblAtletismo = new JLabel("0");
		lblAtletismo.setBounds(86, 42, 16, 13);
		add(lblAtletismo);
		lblAtletismo.setHorizontalAlignment(SwingConstants.CENTER);

		lblAcrobacias = new JLabel("0");
		lblAcrobacias.setBounds(86, 28, 16, 13);
		add(lblAcrobacias);
		lblAcrobacias.setHorizontalAlignment(SwingConstants.CENTER);

		lblHabilidades = new JLabel(et.getString("Habilidades"));
		lblHabilidades.setBounds(1, 5, 126, 13);
		add(lblHabilidades);
		lblHabilidades.setVerticalAlignment(SwingConstants.TOP);
		lblHabilidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidades.setFont(new Font("Sylfaen", Font.PLAIN, 14));

		rdbtnAtletismo = new JRadioButton(et.getString("Atletismo"));
		rdbtnAtletismo.setBounds(7, 39, 79, 13);
		add(rdbtnAtletismo);
		rdbtnAtletismo.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnArcano = new JRadioButton(et.getString("Arcano"));
		rdbtnArcano.setBounds(7, 54, 79, 13);
		add(rdbtnArcano);
		rdbtnArcano.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnInterpretacion = new JRadioButton(et.getString("Interpretacion"));
		rdbtnInterpretacion.setBounds(7, 99, 79, 13);
		add(rdbtnInterpretacion);
		rdbtnInterpretacion.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnHistoria = new JRadioButton(et.getString("Historia"));
		rdbtnHistoria.setBounds(7, 84, 79, 13);
		add(rdbtnHistoria);
		rdbtnHistoria.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnEngano = new JRadioButton(et.getString("Engano"));
		rdbtnEngano.setBounds(7, 69, 79, 13);
		add(rdbtnEngano);
		rdbtnEngano.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnAcrobacias = new JRadioButton(et.getString("Acrobacias"));
		rdbtnAcrobacias.setBounds(7, 24, 79, 13);
		add(rdbtnAcrobacias);
		rdbtnAcrobacias.setFont(new Font("Tahoma", Font.PLAIN, 8));

		lblPercepcion = new JLabel("0");
		lblPercepcion.setBounds(181, 102, 16, 13);
		add(lblPercepcion);
		lblPercepcion.setHorizontalAlignment(SwingConstants.CENTER);

		lblNaturaleza = new JLabel("0");
		lblNaturaleza.setBounds(181, 87, 16, 13);
		add(lblNaturaleza);
		lblNaturaleza.setHorizontalAlignment(SwingConstants.CENTER);

		lblMedicina = new JLabel("0");
		lblMedicina.setBounds(181, 73, 16, 13);
		add(lblMedicina);
		lblMedicina.setHorizontalAlignment(SwingConstants.CENTER);

		lblManos = new JLabel("0");
		lblManos.setBounds(181, 57, 16, 13);
		add(lblManos);
		lblManos.setHorizontalAlignment(SwingConstants.CENTER);

		lblInvestigacion = new JLabel("0");
		lblInvestigacion.setBounds(181, 42, 16, 13);
		add(lblInvestigacion);
		lblInvestigacion.setHorizontalAlignment(SwingConstants.CENTER);

		lblIntimidacion = new JLabel("0");
		lblIntimidacion.setBounds(181, 28, 16, 13);
		add(lblIntimidacion);
		lblIntimidacion.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnPercepcion = new JRadioButton(et.getString("Percepcion"));
		rdbtnPercepcion.setBounds(102, 99, 79, 13);
		add(rdbtnPercepcion);
		rdbtnPercepcion.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnNaturaleza = new JRadioButton(et.getString("Naturaleza"));
		rdbtnNaturaleza.setBounds(102, 84, 79, 13);
		add(rdbtnNaturaleza);
		rdbtnNaturaleza.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnMedicina = new JRadioButton(et.getString("Medicina"));
		rdbtnMedicina.setBounds(102, 69, 79, 13);
		add(rdbtnMedicina);
		rdbtnMedicina.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnManos = new JRadioButton(et.getString("JuegoManos"));
		rdbtnManos.setBounds(102, 54, 79, 13);
		add(rdbtnManos);
		rdbtnManos.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnInvestigacion = new JRadioButton(et.getString("Investigacion"));
		rdbtnInvestigacion.setBounds(102, 39, 79, 13);
		add(rdbtnInvestigacion);
		rdbtnInvestigacion.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnIntimidacion = new JRadioButton(et.getString("Intimidacion"));
		rdbtnIntimidacion.setBounds(102, 24, 79, 13);
		add(rdbtnIntimidacion);
		rdbtnIntimidacion.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnPerspicacia = new JRadioButton(et.getString("Perspicacia"));
		rdbtnPerspicacia.setBounds(197, 24, 79, 13);
		add(rdbtnPerspicacia);
		rdbtnPerspicacia.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnPersuacion = new JRadioButton(et.getString("Persuasion"));
		rdbtnPersuacion.setBounds(197, 39, 79, 13);
		add(rdbtnPersuacion);
		rdbtnPersuacion.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnReligion = new JRadioButton(et.getString("Religion"));
		rdbtnReligion.setBounds(197, 54, 79, 13);
		add(rdbtnReligion);
		rdbtnReligion.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnSigilo = new JRadioButton(et.getString("Sigilo"));
		rdbtnSigilo.setBounds(197, 69, 79, 13);
		add(rdbtnSigilo);
		rdbtnSigilo.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnSupervivencia = new JRadioButton(et.getString("Supervivencia"));
		rdbtnSupervivencia.setBounds(197, 84, 79, 13);
		add(rdbtnSupervivencia);
		rdbtnSupervivencia.setFont(new Font("Tahoma", Font.PLAIN, 8));

		rdbtnTratoAnimal = new JRadioButton(et.getString("TratoAnimal"));
		rdbtnTratoAnimal.setBounds(197, 99, 79, 13);
		add(rdbtnTratoAnimal);
		rdbtnTratoAnimal.setFont(new Font("Tahoma", Font.PLAIN, 8));

		lblTratoAnimal = new JLabel("0");
		lblTratoAnimal.setBounds(276, 102, 16, 13);
		add(lblTratoAnimal);
		lblTratoAnimal.setHorizontalAlignment(SwingConstants.CENTER);

		lblSupervivencia = new JLabel("0");
		lblSupervivencia.setBounds(276, 87, 16, 13);
		add(lblSupervivencia);
		lblSupervivencia.setHorizontalAlignment(SwingConstants.CENTER);

		lblSigilo = new JLabel("0");
		lblSigilo.setBounds(276, 73, 16, 13);
		add(lblSigilo);
		lblSigilo.setHorizontalAlignment(SwingConstants.CENTER);

		lblReligion = new JLabel("0");
		lblReligion.setBounds(276, 57, 16, 13);
		add(lblReligion);
		lblReligion.setHorizontalAlignment(SwingConstants.CENTER);

		lblPersuacion = new JLabel("0");
		lblPersuacion.setBounds(276, 42, 16, 13);
		add(lblPersuacion);
		lblPersuacion.setHorizontalAlignment(SwingConstants.CENTER);

		lblPerspicacia = new JLabel("0");
		lblPerspicacia.setBounds(276, 28, 16, 13);
		add(lblPerspicacia);
		lblPerspicacia.setHorizontalAlignment(SwingConstants.CENTER);

		ManejadorBoton EscuchadorBoton = new ManejadorBoton();

		rdbtnAcrobacias.addActionListener(EscuchadorBoton);
		rdbtnAtletismo.addActionListener(EscuchadorBoton);
		rdbtnArcano.addActionListener(EscuchadorBoton);
		rdbtnEngano.addActionListener(EscuchadorBoton);
		rdbtnHistoria.addActionListener(EscuchadorBoton);
		rdbtnInterpretacion.addActionListener(EscuchadorBoton);

		rdbtnIntimidacion.addActionListener(EscuchadorBoton);
		rdbtnInvestigacion.addActionListener(EscuchadorBoton);
		rdbtnManos.addActionListener(EscuchadorBoton);
		rdbtnMedicina.addActionListener(EscuchadorBoton);
		rdbtnNaturaleza.addActionListener(EscuchadorBoton);
		rdbtnPercepcion.addActionListener(EscuchadorBoton);

		rdbtnPerspicacia.addActionListener(EscuchadorBoton);
		rdbtnPersuacion.addActionListener(EscuchadorBoton);
		rdbtnReligion.addActionListener(EscuchadorBoton);
		rdbtnSigilo.addActionListener(EscuchadorBoton);
		rdbtnSupervivencia.addActionListener(EscuchadorBoton);
		rdbtnTratoAnimal.addActionListener(EscuchadorBoton);

	}

	/**
	 * Crear la clase ManejadorBoton implementando ActionListener para llevar
	 * control de los botones Controla los eventos al precionar cada boton
	 */
	private class ManejadorBoton implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == rdbtnAcrobacias || e.getSource() == rdbtnAtletismo // Selecionar
			// habilidades
					|| e.getSource() == rdbtnHistoria || e.getSource() == rdbtnArcano
					|| e.getSource() == rdbtnInterpretacion || e.getSource() == rdbtnEngano
					|| e.getSource() == rdbtnIntimidacion || e.getSource() == rdbtnPercepcion
					|| e.getSource() == rdbtnNaturaleza || e.getSource() == rdbtnMedicina
					|| e.getSource() == rdbtnManos || e.getSource() == rdbtnInvestigacion
					|| e.getSource() == rdbtnPerspicacia || e.getSource() == rdbtnPersuacion
					|| e.getSource() == rdbtnReligion || e.getSource() == rdbtnSigilo
					|| e.getSource() == rdbtnSupervivencia
					|| e.getSource() == rdbtnTratoAnimal) {
				if (!((AbstractButton) e.getSource()).isSelected()) {
					HabilidadesSeleccionadas -= 1;
				} else if (HabilidadesSeleccionadas >= MaxHabilidades) {
					/*
					 * JOptionPane.showMessageDialog((Component) EventoBotones.getSource(),
					 * "Solo se pueden escoger 4 habilidades", "Error", JOptionPane.ERROR_MESSAGE);
					 */
					((AbstractButton) e.getSource()).setSelected(false);
				} else {
					HabilidadesSeleccionadas += 1;
				}
				System.out.println("Habilidades: " + HabilidadesSeleccionadas);
			}
		} // Manejador Botones}

	}

	
	public void CalcularModificadores() {	
		//setEstadisticas(Estadisticas);
	
		
		ModFue = (Estadisticas.getFuerza() - 10) / 2;
		ModDes = (Estadisticas.getDestreza() - 10) / 2; 
		ModCon = (Estadisticas.getConstitucion()- 10)  / 2;
		ModInt = (Estadisticas.getInteligencia() - 10) / 2; 
		ModSab = (Estadisticas.getSabiduria() - 10) / 2;
		ModCar = (Estadisticas.getCarisma() - 10) / 2; 
		
		/*
		 * if (rdbtnFue.isSelected()) { lblTiradaFue.setText(String.valueOf(ModFue +
		 * 2)); } else { lblTiradaFue.setText(String.valueOf(ModFue)); } if
		 * (rdbtnDes.isSelected()) { lblTiradaDes.setText(String.valueOf(ModDes + ModCompetencia)); }
		 * else { lblTiradaDes.setText(String.valueOf(ModDes)); } if
		 * (rdbtnCon.isSelected()) { lblTiradaCon.setText(String.valueOf(ModCon + ModCompetencia)); }
		 * else { lblTiradaCon.setText(String.valueOf(ModCon)); } if
		 * (rdbtnInt.isSelected()) { lblTiradaInt.setText(String.valueOf(ModInt + ModCompetencia)); }
		 * else { lblTiradaInt.setText(String.valueOf(ModInt)); } if
		 * (rdbtnSab.isSelected()) { lblTiradaSab.setText(String.valueOf(ModSab + ModCompetencia)); }
		 * else { lblTiradaSab.setText(String.valueOf(ModSab)); } if
		 * (rdbtnCar.isSelected()) { lblTiradaCar.setText(String.valueOf(ModCar + ModCompetencia)); }
		 * else { lblTiradaCar.setText(String.valueOf(ModCar)); }
		 */

		if (rdbtnAtletismo.isSelected()) {
			lblAtletismo.setText(String.valueOf(ModFue + ModCompetencia));
		} else {
			lblAtletismo.setText(String.valueOf(ModFue));
		}

		if (rdbtnAcrobacias.isSelected()) {
			lblAcrobacias.setText(String.valueOf(ModDes + ModCompetencia));
		} else {
			lblAcrobacias.setText(String.valueOf(ModDes));
		}
		if (rdbtnManos.isSelected()) {
			lblManos.setText(String.valueOf(ModDes + ModCompetencia));
		} else {
			lblManos.setText(String.valueOf(ModDes));
		}
		if (rdbtnSigilo.isSelected()) {
			lblSigilo.setText(String.valueOf(ModDes + ModCompetencia));
		} else {
			lblSigilo.setText(String.valueOf(ModDes));
		}

		if (rdbtnArcano.isSelected()) {
			lblArcano.setText(String.valueOf(ModInt + ModCompetencia));
		} else {
			lblArcano.setText(String.valueOf(ModInt));
		}
		if (rdbtnHistoria.isSelected()) {
			lblHistoria.setText(String.valueOf(ModInt + ModCompetencia));
		} else {
			lblHistoria.setText(String.valueOf(ModInt));
		}
		if (rdbtnInvestigacion.isSelected()) {
			lblInvestigacion.setText(String.valueOf(ModInt + ModCompetencia));
		} else {
			lblInvestigacion.setText(String.valueOf(ModInt));
		}
		if (rdbtnNaturaleza.isSelected()) {
			lblNaturaleza.setText(String.valueOf(ModInt + ModCompetencia));
		} else {
			lblNaturaleza.setText(String.valueOf(ModInt));
		}
		if (rdbtnReligion.isSelected()) {
			lblReligion.setText(String.valueOf(ModInt + ModCompetencia));
		} else {
			lblReligion.setText(String.valueOf(ModInt));
		}

		if (rdbtnMedicina.isSelected()) {
			lblMedicina.setText(String.valueOf(ModSab + ModCompetencia));
		} else {
			lblMedicina.setText(String.valueOf(ModSab));
		}
		if (rdbtnPercepcion.isSelected()) {
			lblPercepcion.setText(String.valueOf(ModSab + ModCompetencia));
		} else {
			lblPercepcion.setText(String.valueOf(ModSab));
		}
		if (rdbtnPerspicacia.isSelected()) {
			lblPerspicacia.setText(String.valueOf(ModSab + ModCompetencia));
		} else {
			lblPerspicacia.setText(String.valueOf(ModSab));
		}
		if (rdbtnSupervivencia.isSelected()) {
			lblSupervivencia.setText(String.valueOf(ModSab + ModCompetencia));
		} else {
			lblSupervivencia.setText(String.valueOf(ModSab));
		}
		if (rdbtnTratoAnimal.isSelected()) {
			lblTratoAnimal.setText(String.valueOf(ModSab + ModCompetencia));
		} else {
			lblTratoAnimal.setText(String.valueOf(ModSab));
		}

		if (rdbtnEngano.isSelected()) {
			lblEngano.setText(String.valueOf(ModCar + ModCompetencia));
		} else {
			lblEngano.setText(String.valueOf(ModCar));
		}
		if (rdbtnIntimidacion.isSelected()) {
			lblIntimidacion.setText(String.valueOf(ModCar + ModCompetencia));
		} else {
			lblIntimidacion.setText(String.valueOf(ModCar));
		}
		if (rdbtnPersuacion.isSelected()) {
			lblPersuacion.setText(String.valueOf(ModCar + ModCompetencia));
		} else {
			lblPersuacion.setText(String.valueOf(ModCar));
		}
		if (rdbtnInterpretacion.isSelected()) {
			lblInterpretacion.setText(String.valueOf(ModCar + ModCompetencia));
		} else {
			lblInterpretacion.setText(String.valueOf(ModCar));
		}
	}
	
	public void setEstadisticas(OEstadisticas estadisticas) {
		Estadisticas = estadisticas;
	}
	
	public void CargarMods() {
	
	}

	public void CalcularHabilidades() {
		// TODO Auto-generated method stub
		
	}
	

}
