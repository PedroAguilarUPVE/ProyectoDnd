
package modelos;


/**
 * Modelo ORaza Guarda los datos de una raza, obtenidos del usuario o extraidos de la base de datos
 * Incluye los metodos set y get de cada variable, que corresponden a los campos de las tablas razas y estadisticasRaza en la base de datos
 */
public class ORaza {

	int id_Raza;
	String Nombre;
	String Descripcion;
	String Tamano;
	int VelocidadRaza;
	int id_EstadisticasRaza;
	int Fuerza;
	int Destreza;
	int Constitucion;
	int Inteligencia;
	int Sabiduria;
	int Carisma;
	/**
	 * @return the id_Raza
	 */
	public int getId_Raza() {
		return id_Raza;
	}
	/**
	 * @param id_Raza the id_Raza to set
	 */
	public void setId_Raza(int id_Raza) {
		this.id_Raza = id_Raza;
	}
	/**
	 * @return the nombreRaza
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * @param nombreRaza the nombreRaza to set
	 */
	public void setNombre(String nombreRaza) {
		Nombre = nombreRaza;
	}
	/**
	 * @return the descripcionRaza
	 */
	public String getDescripcion() {
		return Descripcion;
	}
	/**
	 * @param descripcionRaza the descripcionRaza to set
	 */
	public void setDescripcion(String descripcionRaza) {
		Descripcion = descripcionRaza;
	}
	/**
	 * @return the tamanoRaza
	 */
	public String getTamano() {
		return Tamano;
	}
	/**
	 * @param tamano the tamanoRaza to set
	 */
	public void setTamano(String tamano) {
		Tamano = tamano;
	}
	/**
	 * @return the velocidadRaza
	 */
	public int getVelocidad() {
		return VelocidadRaza;
	}
	/**
	 * @param velocidadRaza the velocidadRaza to set
	 */
	public void setVelocidad(int velocidadRaza) {
		VelocidadRaza = velocidadRaza;
	}
	/**
	 * @return the id_EstadisticasRaza
	 */
	public int getId_EstadisticasRaza() {
		return id_EstadisticasRaza;
	}
	/**
	 * @param id_EstadisticasRaza the id_EstadisticasRaza to set
	 */
	public void setId_EstadisticasRaza(int id_EstadisticasRaza) {
		this.id_EstadisticasRaza = id_EstadisticasRaza;
	}
	/**
	 * @return the fuerza
	 */
	public int getFuerza() {
		return Fuerza;
	}
	/**
	 * @param fuerza the fuerza to set
	 */
	public void setFuerza(int fuerza) {
		Fuerza = fuerza;
	}
	/**
	 * @return the destreza
	 */
	public int getDestreza() {
		return Destreza;
	}
	/**
	 * @param destreza the destreza to set
	 */
	public void setDestreza(int destreza) {
		Destreza = destreza;
	}
	/**
	 * @return the constitucion
	 */
	public int getConstitucion() {
		return Constitucion;
	}
	/**
	 * @param constitucion the constitucion to set
	 */
	public void setConstitucion(int constitucion) {
		Constitucion = constitucion;
	}
	/**
	 * @return the inteligencia
	 */
	public int getInteligencia() {
		return Inteligencia;
	}
	/**
	 * @param inteligencia the inteligencia to set
	 */
	public void setInteligencia(int inteligencia) {
		Inteligencia = inteligencia;
	}
	/**
	 * @return the sabiduria
	 */
	public int getSabiduria() {
		return Sabiduria;
	}
	/**
	 * @param sabiduria the sabiduria to set
	 */
	public void setSabiduria(int sabiduria) {
		Sabiduria = sabiduria;
	}
	/**
	 * @return the carisma
	 */
	public int getCarisma() {
		return Carisma;
	}
	/**
	 * @param carisma the carisma to set
	 */
	public void setCarisma(int carisma) {
		Carisma = carisma;
	}
	
	
	
}