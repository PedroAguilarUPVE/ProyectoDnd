package modelos;

public class OEstadisticas {
	int Fuerza;
	int Destreza;
	int Constitucion;
	int Inteligencia;
	int Sabiduria;
	int Carisma;
	
	
	
	/**
	 * @param fuerza
	 * @param destreza
	 * @param constitucion
	 * @param inteligencia
	 * @param sabiduria
	 * @param carisma
	 */
	public OEstadisticas(int fuerza, int destreza, int constitucion, int inteligencia, int sabiduria, int carisma) {
		super();
		Fuerza = fuerza;
		Destreza = destreza;
		Constitucion = constitucion;
		Inteligencia = inteligencia;
		Sabiduria = sabiduria;
		Carisma = carisma;
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
