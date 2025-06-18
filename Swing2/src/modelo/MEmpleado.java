package modelo;

import java.util.Date;

public class MEmpleado {
	
	private Integer IdEmpleado;
	private String NomEmpleado;
	private String ApPaterno;
	private String ApMaterno;
	private String Telefono;
	private String Domicilio;
	private Date FechaNacim;
	private String Curp;
	private String RFC;
	
	//Generación de Get y Set de cada una de las Propiedades
	
	public Integer getIdEmpleado() {
		return IdEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		if (!idEmpleado.equals(0)) {
			IdEmpleado = idEmpleado;
		}else {
			IdEmpleado = 0;
		}
			
		
	}
	public String getNomEmpleado() {
		return NomEmpleado;
	}
	public void setNomEmpleado(String nomEmpleado) {
		NomEmpleado = nomEmpleado;
	}
	public String getApPaterno() {
		return ApPaterno;
	}
	public void setApPaterno(String apPaterno) {
		ApPaterno = apPaterno;
	}
	public String getApMaterno() {
		return ApMaterno;
	}
	public void setApMaterno(String apMaterno) {
		ApMaterno = apMaterno;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getDomicilio() {
		return Domicilio;
	}
	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}
	public Date getFechaNacim() {
		return FechaNacim;
	}
	public void setFechaNacim(Date fechaNacim) {
		FechaNacim = fechaNacim;
	}
	public String getCurp() {
		return Curp;
	}
	public void setCurp(String curp) {
		Curp = curp;
	}
	public String getRFC() {
		return RFC;
	}
	public void setRFC(String rFC) {
		RFC = rFC;
	}

}
