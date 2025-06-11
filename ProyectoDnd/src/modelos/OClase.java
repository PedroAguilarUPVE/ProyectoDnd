package modelos;

/**
 * Modelo OClase Guarda los datos de una clase, obtenidos del usuario o extraidos de la base de datos
 * Incluye los metodos set y get de cada variable, que corresponden a los campos de la tabla clases en la base de datos
 */
public class OClase {
	

	private Integer idClase;
	private String nombreClase;
	private String descripcionClase;
	private String tipoClase;
	private Integer DadoDano;
	/**
	 * @return the idClase
	 */
	public Integer getIdClase() {
		return idClase;
	}
	/**
	 * @param idClase the idClase to set
	 */
	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}
	/**
	 * @return the nombreClase
	 */
	public String getNombreClase() {
		return nombreClase;
	}
	/**
	 * @param nombreClase the nombreClase to set
	 */
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	/**
	 * @return the descripcionClase
	 */
	public String getDescripcionClase() {
		return descripcionClase;
	}
	/**
	 * @param descripcionClase the descripcionClase to set
	 */
	public void setDescripcionClase(String descripcionClase) {
		this.descripcionClase = descripcionClase;
	}
	/**
	 * @return the tipoClase
	 */
	public String getTipoClase() {
		return tipoClase;
	}
	/**
	 * @param tipoClase the tipoClase to set
	 */
	public void setTipoClase(String tipoClase) {
		this.tipoClase = tipoClase;
	}
	/**
	 * @return the dadoDano
	 */
	public Integer getDadoDano() {
		return DadoDano;
	}
	/**
	 * @param dadoDano the dadoDano to set
	 */
	public void setDadoDano(Integer dadoDano) {
		DadoDano = dadoDano;
	}
	
	
	

}
