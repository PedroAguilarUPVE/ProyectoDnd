package controladores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import conexion.ConexionBDSQLServer;
import modelo.OPersona;

/**
 * Clase que permite el acceso a la base de datos
 * 
 * @author chenao
 * 
 */
public class CPersona {
	public static Connection Conexion = null;
	public static String sql;

	/**
	 * Usa el objeto enviado para almacenar la persona
	 * 
	 * @param miPersona
	 */
	public void registrarPersona(OPersona miPersona) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexi�n ala base de Datos
		Conexion = ConexionBDSQLServer.GetConexion(); // sqlserver
		// data sql
		java.sql.Date sqlDate;

		
		sql = "INSERT INTO persona (Id, Nombre, Edad, Profesion, Telefono, Email, FechaNac, TerCon) VALUES(?,?,?,?,?,?,?,?)";

		try {

			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, miPersona.getIdPersona());
			sentencia.setString(2, miPersona.getNombrePersona());
			sentencia.setInt(3, miPersona.getEdadPersona());
			sentencia.setInt(4, miPersona.getProfesionPersona());
			sentencia.setString(5, miPersona.getTelefonoPersona());
			sentencia.setString(6, miPersona.getEmail());
			// Convertir fecha Java.Util a fecha de Java.sql
			sqlDate = new java.sql.Date(miPersona.getFechaNac().getTime());
			sentencia.setDate(7, sqlDate);
			sentencia.setBoolean(8, miPersona.isTerCom());

			// Indicamos que comience la actualizaci�n de la tabla en nuestra base de
			// datos

			// Valida que la informaci�n enviada sea validada como falsa o verdedaera su
			// inserci�n
			if (sentencia.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (SQLException eExecuteUpdate) {
			// TODO Auto-generated catch block
			System.err.println("Error de SQL " + eExecuteUpdate.getMessage());
			JOptionPane.showMessageDialog(null, eExecuteUpdate.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}// Clase Principal

	/**
	 * Usa el objeto enviado para almacenar la persona
	 * 
	 * @param miPersona
	 */
	public void borrarPersona(OPersona miPersona) {

		try {
			Statement estatuto = ConexionBDSQLServer.GetConexion().createStatement();

			estatuto.executeUpdate("DELETE FROM persona WHERE id='" + miPersona.getIdPersona() + "'");

			JOptionPane.showMessageDialog(null, "Se ha Borrado Exitosamente", "Informaci�n",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro, verifique la consola para ver el error", "Error",
					JOptionPane.ERROR_MESSAGE);
		} // trycath de insercion base datos

	}// Borrar

	/**
	 * Usa el objeto model para almacenar directamente la informaci�n obtenida de la
	 * BD, y se muestra en la tabla, el tama�o es 5 por defecto ya que conocemos el
	 * numero de columnas
	 * 
	 * @param model
	 */
	public void buscarUsuariosConTableModel(DefaultTableModel model) {

		try {
			Statement estatuto = ConexionBDSQLServer.GetConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM persona");

			while (rs.next()) {
				// es para obtener los datos y almacenar las filas
				Object[] fila = new Object[5];
				// para llenar cada columna con lo datos almacenados
				for (int i = 0; i < 5; i++)
					fila[i] = rs.getObject(i + 1);
				// es para cargar los datos en filas a la tabla modelo
				model.addRow(fila);

			}
			rs.close();
			estatuto.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	/*Buscar  datso para la tabla  en ves del Indice de profecion
	 * 
	 */
	public static String LeerProfeciones(int Indice) {
		
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexi�n ala base de Datos
		Conexion = ConexionBDSQLServer.GetConexion(); // sqlserver
		
		String Profesion="";
		String sql="SELECT IdProfesion, profesion FROM poo.dbo.profesiones WHERE IdProfesion=?";
		
		
		
		return Profesion;

	}

	
	public void buscarUsuariosConTableModelProcedimiento(DefaultTableModel model) {
		try {
			// Se crea una variable de tipo conexión para prepara los elemntos utilizar el
			// el procedimiento
			Connection ConexionBd = null;

			// Conecta con la base de datos
			ConexionBd = ConexionBDSQLServer.GetConexion();
			// se prepara una variable result Set para cachar la información del
			// Procedimientoalmacenado
			ResultSet rs = null;
			// se prepara al procedimiento almacenado
			CallableStatement cst = ConexionBd.prepareCall("{call sp_ObtenerDatos}");

			// Ejecuta el procedimiento almacenado asignando el resultado a la variable
			// resul set
			rs = cst.executeQuery();

			while (rs.next()) {
				// es para obtener los datos y almacenar las filas
				Object[] fila = new Object[5];
				// para llenar cada columna con lo datos almacenados
				for (int i = 0; i < 5; i++)
					fila[i] = rs.getObject(i + 1);
				// es para cargar los datos en filas a la tabla modelo
				model.addRow(fila);

			}
			rs.close();
			ConexionBd.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void buscarUsuariosConTableModelProcedimientoP(DefaultTableModel model, int Filtro) {
		try {
			// Se crea una variable de tipo conexión para prepara los elemntos utilizar el
			// el procedimiento
			Connection ConexionBd = null;

			// Conecta con la base de datos
			ConexionBd = ConexionBDSQLServer.GetConexion();
			// se prepara al procedimiento almacenado
			CallableStatement cst = ConexionBd.prepareCall("{call sp_ObtenerDatosP (?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setInt(1, Filtro);

			// Definimos los tipos de los parametros de salida del procedimiento almacenado
			cst.registerOutParameter(2, java.sql.Types.NUMERIC);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			cst.registerOutParameter(4, java.sql.Types.VARCHAR);
			cst.registerOutParameter(5, java.sql.Types.VARCHAR);
			cst.registerOutParameter(6, java.sql.Types.VARCHAR);

			// Ejecuta el procedimiento almacenado asignando el resultado a la variable
			// resul set
			cst.execute();

			// es para obtener los datos y almacenar las filas
			Object[] fila = new Object[5];
			// para llenar cada columna con lo datos almacenados

			fila[0] = cst.getString(2);
			fila[1] = cst.getString(3);
			fila[2] = cst.getString(4);
			fila[3] = cst.getString(5);
			fila[4] = cst.getString(6);

			// es para cargar los datos en filas a la tabla modelo
			model.addRow(fila);

			ConexionBd.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public static DefaultComboBoxModel<String> LlenarComboBox() {
		// Se inicializa un objeto de tipo DefaultComboBoxModel
		DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

		try {
			Statement Consulta = ConexionBDSQLServer.GetConexion().createStatement();
			ResultSet rs = Consulta.executeQuery("SELECT * FROM profesiones");

			// Se ingresa un dato blanco en el primer campo del Combox
			DatosJcombox.addElement("Seleccione...");
			while (rs.next()) {
				// se llena con todos los elementos devueltos de la tabal de Combox
				DatosJcombox.addElement(rs.getString("profesion"));
			}
			rs.close();
			Consulta.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar Profesiones", "Error", JOptionPane.ERROR_MESSAGE);
			DatosJcombox = null;
		}

		return DatosJcombox;

	}

	public static DefaultComboBoxModel<String> LlenarComboBoxMun() {
		// Se inicializa un objeto de tipo DefaultComboBoxModel
				DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

				try {
					Statement Consulta = ConexionBDSQLServer.GetConexion().createStatement();
					ResultSet rs = Consulta.executeQuery("SELECT DISTINCT D_mnpio FROM dbo.Sinaloa ORDER BY D_mnpio");

					// Se ingresa un dato blanco en el primer campo del Combox
					DatosJcombox.addElement("Seleccione...");
					while (rs.next()) {
						// se llena con todos los elementos devueltos de la tabal de Combox
						DatosJcombox.addElement(rs.getString("D_mnpio"));
					}
					rs.close();
					Consulta.close();

				} catch (SQLException e) {
					System.err.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar Municipios", "Error", JOptionPane.ERROR_MESSAGE);
					DatosJcombox = null;
				}

				return DatosJcombox;
	}

	public static DefaultComboBoxModel<String> LlenarComboBoxPob(String poblacion) {
		
		System.out.println("llega  con "+poblacion);
		// Se inicializa un objeto de tipo DefaultComboBoxModel
				DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

				try {
					Statement Consulta = ConexionBDSQLServer.GetConexion().createStatement();
					ResultSet rs = Consulta.executeQuery("SELECT DISTINCT d_asenta FROM dbo.Sinaloa WHERE D_mnpio='"+poblacion+"' ORDER BY d_asenta");
								// Se ingresa un dato blanco en el primer campo del Combox
					DatosJcombox.addElement("Seleccione...");
					while (rs.next()) {
						// se llena con todos los elementos devueltos de la tabal de Combox
						DatosJcombox.addElement(rs.getString("d_asenta"));
					}
					rs.close();
					Consulta.close();

				} catch (SQLException e) {
					System.err.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar Municipios", "Error", JOptionPane.ERROR_MESSAGE);
					DatosJcombox = null;
				}

				return DatosJcombox;
	}

}// main
