package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBDSQLServer;
import modelo.MEmpleado;

public class CEmpleado {
	public static Connection Conexion=null;
	public static String Sql;

	public Mensajes RegistrarEmpleado(MEmpleado InfEmpledao) {
		
		PreparedStatement Sentencia=null;
		Conexion=ConexionBDSQLServer.GetConexion();
		Mensajes Mensaje=new Mensajes();
		
		Sql="INSERT INTO Proyectos.dbo.Empleado "
				+ "(IdEmpleado, NomEmpleado, ApPaterno,"
				+ "ApMaterno, Telefono, Domicilio, FechaNacim,"
				+ " Curp, Rfc) "
				+ "VALUES(?,?,?,?,?,?,?,?,?);";
	
		try {
			Sentencia=Conexion.prepareStatement(Sql);
			
			Sentencia.setInt(1, InfEmpledao.getIdEmpleado());
			Sentencia.setString(2, InfEmpledao.getNomEmpleado());
			Sentencia.setString(3, InfEmpledao.getApPaterno());
			Sentencia.setString(4, InfEmpledao.getApMaterno());
			Sentencia.setString(5, InfEmpledao.getTelefono());
			Sentencia.setString(6, InfEmpledao.getDomicilio());
			//se convierte la fecha Uil.Date a Fecha sql.date
			long FechaDate= InfEmpledao.getFechaNacim().getTime();	
			java.sql.Date FechaN = new java.sql.Date(FechaDate);
			Sentencia.setDate(7,FechaN);
			Sentencia.setString(8, InfEmpledao.getCurp());
			Sentencia.setString(9, InfEmpledao.getRFC());
			
			if(Sentencia.executeUpdate()>0) {
				Mensaje.setMensaje("Se Inserto Correctamente");
				Mensaje.setValidacion(true);
				//JOptionPane.showMessageDialog(null,"Se a inserto un valor a la BD ","Información", 1);
			}else {
				Mensaje.setMensaje("No Datos a la BD");
				Mensaje.setValidacion(false);
			}
			
		} catch (SQLException e) {
			Mensaje.setMensaje(e.getMessage());
			Mensaje.setValidacion(false);
			System.err.println(e.getMessage());
		}
		
		
		return Mensaje;
		
		
		
	}

	public Mensajes UpdateRegistro(MEmpleado InfEmpleado) {
		Mensajes Mensaje=new Mensajes();
		try {
			Statement ConexionUpdate= ConexionBDSQLServer.GetConexion().createStatement();

			ConexionUpdate.executeUpdate("UPDATE Sistemas.dbo.Empleado"
					+ " SET NomEmpleado='"+  InfEmpleado.getNomEmpleado()
					+"' WHERE IdEmpleado="+InfEmpleado.getIdEmpleado()+";");
						
			Mensaje.setMensaje("Se modifico Correctamente");
			Mensaje.setValidacion(true);
				
		}catch(SQLException e){
			Mensaje.setMensaje(e.getMessage());
			Mensaje.setValidacion(false);
			System.err.println(e.getMessage());
		}
		
		
		
		
		return Mensaje;
	}
	

}
