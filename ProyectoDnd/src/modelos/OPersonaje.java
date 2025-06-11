package modelos;


/**
 * Modelo OPersonaje Guarda los datos de un personaje, obtenidos del usuario o extraidos de la base de datos
 * Incluye los metodos set y get de cada variable, que corresponden a los campos de las tablas personajes y estadisticasPersonaje en la base de datos
 */
public class OPersonaje {

	int id_Personaje;
	String NombrePersonaje;
	int Nivel;
	int id_Clase;
	int id_Subclase;
	int id_Raza;
	int BonusCompetencia;
	int id_EstadisticasPersonaje;
	int Fuerza;
	int Destreza;
	int Constitucion;
	int Inteligencia;
	int Sabiduria;
	int Carisma;
	/**
	 * @return the id_Personaje
	 */
	public int getId_Personaje() {
		return id_Personaje;
	}
	/**
	 * @param id_Personaje the id_Personaje to set
	 */
	public void setId_Personaje(int id_Personaje) {
		this.id_Personaje = id_Personaje;
	}
	/**
	 * @return the nombrePersonaje
	 */
	public String getNombrePersonaje() {
		return NombrePersonaje;
	}
	/**
	 * @param nombrePersonaje the nombrePersonaje to set
	 */
	public void setNombrePersonaje(String nombrePersonaje) {
		NombrePersonaje = nombrePersonaje;
	}
	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return Nivel;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
		Nivel = nivel;
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
	 * @return the bonusCompetencia
	 */
	public int getBonusCompetencia() {
		return BonusCompetencia;
	}
	/**
	 * @param bonusCompetencia the bonusCompetencia to set
	 */
	public void setBonusCompetencia(int bonusCompetencia) {
		BonusCompetencia = bonusCompetencia;
	}
	/**
	 * @return the id_EstadisticasPersonaje
	 */
	public int getId_EstadisticasPersonaje() {
		return id_EstadisticasPersonaje;
	}
	/**
	 * @param id_EstadisticasPersonaje the id_EstadisticasPersonaje to set
	 */
	public void setId_EstadisticasPersonaje(int id_EstadisticasPersonaje) {
		this.id_EstadisticasPersonaje = id_EstadisticasPersonaje;
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
