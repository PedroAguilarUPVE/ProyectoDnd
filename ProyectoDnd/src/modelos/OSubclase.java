package modelos;


/**
 * Modelo OSubclase Guarda los datos de una subclase, obtenidos del usuario o extraidos de la base de datos
 * Incluye los metodos set y get de cada variable, que corresponden a los campos de la tabla subclases en la base de datos
 */
public class OSubclase {
    private int id_Subclase;
    private int id_Clase;
    private String nombreSubclase;
    private String descripcionSubclase;
	/**
	 * @return the id_Subclase
	 */
	public int getId_Subclase() {
		return id_Subclase;
	}
	/**
	 * @param id_Subclase the id_Subclase to set
	 */
	public void setId_Subclase(int id_Subclase) {
		this.id_Subclase = id_Subclase;
	}
	/**
	 * @return the id_Clase
	 */
	public int getId_Clase() {
		return id_Clase;
	}
	/**
	 * @param id_Clase the id_Clase to set
	 */
	public void setId_Clase(int id_Clase) {
		this.id_Clase = id_Clase;
	}
	/**
	 * @return the nombreSubclase
	 */
	public String getNombreSubclase() {
		return nombreSubclase;
	}
	/**
	 * @param nombreSubclase the nombreSubclase to set
	 */
	public void setNombreSubclase(String nombreSubclase) {
		this.nombreSubclase = nombreSubclase;
	}
	/**
	 * @return the descripcionSubclase
	 */
	public String getDescripcionSubclase() {
		return descripcionSubclase;
	}
	/**
	 * @param descripcionSubclase the descripcionSubclase to set
	 */
	public void setDescripcionSubclase(String descripcionSubclase) {
		this.descripcionSubclase = descripcionSubclase;
	}

    
    
}