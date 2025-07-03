package modelos;

/**
 * Modelo OClase Guarda los datos de una clase, obtenidos del usuario o extraidos de la base de datos
 * Incluye los metodos set y get de cada variable, que corresponden a los campos de la tabla clases en la base de datos
 */
public class OClase {
	

	private Integer idClase;
	private String nombre;
	private String descripcion;
	private String tipo;
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
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombreClase the nombreClase to set
	 */
	public void setNombre(String nombreClase) {
		this.nombre = nombreClase;
	}
	/**
	 * @return the descripcionClase
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcionClase the descripcionClase to set
	 */
	public void setDescripcion(String descripcionClase) {
		this.descripcion = descripcionClase;
	}
	/**
	 * @return the tipoClase
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipoClase the tipoClase to set
	 */
	public void setTipo(String tipoClase) {
		this.tipo = tipoClase;
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
