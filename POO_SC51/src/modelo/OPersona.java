package modelo;

import java.util.Date;

public class OPersona {
	
	private Integer idPersona;
	private String nombrePersona;
	private Integer edadPersona;
	private int profesionPersona;
	private String telefonoPersona;
	private Date FechaNac;
	private String Email;
	private boolean TerCom;

	
	
	/**
	 * @return the fechaNac
	 */
	public Date getFechaNac() {
		return FechaNac;
	}
	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFechaNac(Date fechaNac) {
		FechaNac = fechaNac;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * @return the terCom
	 */
	public boolean isTerCom() {
		return TerCom;
	}
	/**
	 * @param terCom the terCom to set
	 */
	public void setTerCom(boolean terCom) {
		TerCom = terCom;
	}
	/**
	 * @return the idPersona
	 */
	public Integer getIdPersona() {
		return idPersona;
	}
	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	/**
	 * @return the nombrePersona
	 */
	public String getNombrePersona() {
		return nombrePersona;
	}
	/**
	 * @param nombrePersona the nombrePersona to set
	 */
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	/**
	 * @return the edadPersona
	 */
	public Integer getEdadPersona() {
		return edadPersona;
	}
	/**
	 * @param edadPersona the edadPersona to set
	 */
	public void setEdadPersona(Integer edadPersona) {
		this.edadPersona = edadPersona;
	}

	/**
	 * @return the profesionPersona
	 */
	public int getProfesionPersona() {
		return profesionPersona;
	}
	/**
	 * @param profesionPersona the profesionPersona to set
	 */
	public void setProfesionPersona(int profesionPersona) {
		this.profesionPersona = profesionPersona;
	}
	/**
	 * @return the telefonoPersona
	 */
	public String getTelefonoPersona() {
		return telefonoPersona;
	}
	/**
	 * @param telefonoPersona the telefonoPersona to set
	 */
	public void setTelefonoPersona(String telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}
	

}
