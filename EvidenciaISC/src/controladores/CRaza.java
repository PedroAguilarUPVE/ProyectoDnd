package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import conexion.ConexionBDSQLServer;
import modelos.ORaza;

public class CRaza {
	private static Connection conexion = null;
	private static String sql;

	/**
	 * Registra una nueva raza en la base de datos.
	 * 
	 * @param miRaza Objeto ORaza con los datos a registrar.
	 */
	public void registrarRaza(ORaza raza) {
		String sqlRaza = "INSERT INTO Razas (NombreRaza, DescripcionRaza, TamañoRaza, VelocidadRaza) "
				+ "VALUES (?, ?, ?, ?)";
		String sqlEstadisticas = "INSERT INTO EstadisticasRaza (Id_Raza, Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexionBDSQLServer.GetConexion()) {
			// Insertar la raza en la tabla Razas
			try (PreparedStatement psRaza = conn.prepareStatement(sqlRaza, Statement.RETURN_GENERATED_KEYS)) {
				psRaza.setString(1, raza.getNombreRaza());
				psRaza.setString(2, raza.getDescripcionRaza());
				psRaza.setString(3, raza.getTamañoRaza());
				psRaza.setInt(4, raza.getVelocidadRaza());

				psRaza.executeUpdate();

				// Obtener el ID generado para la raza
				ResultSet rs = psRaza.getGeneratedKeys();
				int idRaza = -1;
				if (rs.next()) {
					idRaza = rs.getInt(1);
				}

				// Insertar las estadísticas de la raza en la tabla EstadisticasRaza
				try (PreparedStatement psEstadisticas = conn.prepareStatement(sqlEstadisticas)) {
					psEstadisticas.setInt(1, idRaza);
					psEstadisticas.setInt(2, raza.getFuerza());
					psEstadisticas.setInt(3, raza.getDestreza());
					psEstadisticas.setInt(4, raza.getConstitucion());
					psEstadisticas.setInt(5, raza.getInteligencia());
					psEstadisticas.setInt(6, raza.getSabiduria());
					psEstadisticas.setInt(7, raza.getCarisma());

					psEstadisticas.executeUpdate();
				}
			}
			JOptionPane.showMessageDialog(null, "Raza registrada correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al insertar raza", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Elimina una raza de la base de datos.
	 * 
	 * @param idRaza ID de la raza a eliminar.
	 */
	public ORaza obtenerRazaConEstadisticas(String nombreRaza) {
	    ORaza raza = null;
	    String sql = "SELECT * FROM Raza WHERE NombreRaza = ?";
	    
	    try (Connection conn = ConexionBDSQLServer.GetConexion();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setString(1, nombreRaza);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            raza = new ORaza();
	            raza.setId_Raza(rs.getInt("id_Raza"));
	            raza.setNombreRaza(rs.getString("NombreRaza"));
	            raza.setDescripcionRaza(rs.getString("DescripcionRaza"));
	            raza.setTamañoRaza(rs.getString("TamañoRaza"));
	            raza.setVelocidadRaza(rs.getInt("VelocidadRaza"));
	            raza.setFuerza(rs.getInt("Fuerza"));
	            raza.setDestreza(rs.getInt("Destreza"));
	            raza.setConstitucion(rs.getInt("Constitucion"));
	            raza.setInteligencia(rs.getInt("Inteligencia"));
	            raza.setSabiduria(rs.getInt("Sabiduria"));
	            raza.setCarisma(rs.getInt("Carisma"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al obtener la raza", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    
	    return raza;
	}
	
	public void borrarRaza(String nombreRaza) {
	    String sqlRaza = "DELETE FROM Razas WHERE NombreRaza = ?";
	    String sqlEstadisticas = "DELETE FROM EstadisticasRaza WHERE Id_Raza = (SELECT Id_Raza FROM Razas WHERE NombreRaza = ?)";
	    try (Connection conn = ConexionBDSQLServer.GetConexion()) {
	        // Eliminar las estadísticas de la raza
	        try (PreparedStatement psEstadisticas = conn.prepareStatement(sqlEstadisticas)) {
	            psEstadisticas.setString(1, nombreRaza);
	            psEstadisticas.executeUpdate();
	        }
	        
	        // Eliminar la raza de la tabla Razas
	        try (PreparedStatement psRaza = conn.prepareStatement(sqlRaza)) {
	            psRaza.setString(1, nombreRaza);
	            int rowsAffected = psRaza.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Raza borrada correctamente.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No se encontró la raza.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al borrar la raza", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	/**
	 * Obtiene todas las razas de la base de datos y las almacena en un TableModel.
	 * 
	 * @param model Modelo de tabla a llenar con los datos.
	 */
	public void buscarRazasConTableModel(DefaultTableModel model) {
		String sql = "SELECT r.Id_Raza, r.NombreRaza, r.DescripcionRaza, r.TamañoRaza, r.VelocidadRaza, "
				+ "e.Fuerza, e.Destreza, e.Constitucion, e.Inteligencia, e.Sabiduria, e.Carisma " + "FROM Razas r "
				+ "JOIN EstadisticasRaza e ON r.Id_Raza = e.Id_Raza";
		try (Connection conn = ConexionBDSQLServer.GetConexion();
				Statement estatuto = conn.createStatement();
				ResultSet rs = estatuto.executeQuery(sql)) {

			while (rs.next()) {
				Object[] fila = new Object[11]; // Ajustado a 11 columnas
				fila[0] = rs.getInt("Id_Raza");
				fila[1] = rs.getString("NombreRaza");
				fila[2] = rs.getString("DescripcionRaza");
				fila[3] = rs.getString("TamañoRaza");
				fila[4] = rs.getInt("VelocidadRaza");
				fila[5] = rs.getInt("Fuerza");
				fila[6] = rs.getInt("Destreza");
				fila[7] = rs.getInt("Constitucion");
				fila[8] = rs.getInt("Inteligencia");
				fila[9] = rs.getInt("Sabiduria");
				fila[10] = rs.getInt("Carisma");

				model.addRow(fila);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar razas", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public int obtenerIdRazaPorNombre(String nombreRaza) {
		int idRaza = -1; // Valor por defecto si no se encuentra la raza
		String sql = "SELECT Id_Raza FROM Razas WHERE NombreRaza = ?"; // Consulta SQL

		try (Connection conexion = ConexionBDSQLServer.GetConexion();
				PreparedStatement sentencia = conexion.prepareStatement(sql)) {

			sentencia.setString(1, nombreRaza); // Establecer el nombre de la raza en la consulta
			ResultSet rs = sentencia.executeQuery(); // Ejecutar la consulta

			if (rs.next()) {
				idRaza = rs.getInt("Id_Raza"); // Obtener el ID de la raza
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener ID de la raza", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return idRaza; // Retornar el ID de la raza, o -1 si no se encuentra
	}

	public ORaza buscarRazaPorNombre(String nombreRaza) {
		ORaza raza = null;
		String sqlRaza = "SELECT * FROM Razas WHERE NombreRaza = ?";
		String sqlEstadisticas = "SELECT * FROM EstadisticasRaza WHERE Id_Raza = (SELECT Id_Raza FROM Razas WHERE NombreRaza = ?)";

		try (Connection conn = ConexionBDSQLServer.GetConexion()) {
			// Buscar la raza
			try (PreparedStatement psRaza = conn.prepareStatement(sqlRaza)) {
				psRaza.setString(1, nombreRaza);
				ResultSet rsRaza = psRaza.executeQuery();

				if (rsRaza.next()) {
					raza = new ORaza();
					raza.setNombreRaza(rsRaza.getString("NombreRaza"));
					raza.setDescripcionRaza(rsRaza.getString("DescripcionRaza"));
					raza.setTamañoRaza(rsRaza.getString("TamañoRaza"));
					raza.setVelocidadRaza(rsRaza.getInt("VelocidadRaza"));

					// Buscar las estadísticas de la raza
					try (PreparedStatement psEstadisticas = conn.prepareStatement(sqlEstadisticas)) {
						psEstadisticas.setString(1, nombreRaza);
						ResultSet rsEstadisticas = psEstadisticas.executeQuery();

						if (rsEstadisticas.next()) {
							raza.setFuerza(rsEstadisticas.getInt("Fuerza"));
							raza.setDestreza(rsEstadisticas.getInt("Destreza"));
							raza.setConstitucion(rsEstadisticas.getInt("Constitucion"));
							raza.setInteligencia(rsEstadisticas.getInt("Inteligencia"));
							raza.setSabiduria(rsEstadisticas.getInt("Sabiduria"));
							raza.setCarisma(rsEstadisticas.getInt("Carisma"));
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al buscar raza por nombre", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return raza;
	}
	
	public void actualizarRaza(ORaza raza) {
	    String sqlRaza = "UPDATE Razas SET DescripcionRaza = ?, TamañoRaza = ?, VelocidadRaza = ? WHERE NombreRaza = ?";
	    String sqlEstadisticas = "UPDATE EstadisticasRaza SET Fuerza = ?, Destreza = ?, Constitucion = ?, Inteligencia = ?, Sabiduria = ?, Carisma = ? WHERE Id_Raza = ?";
	    
	    // Asegúrate de que 'conexion' es la conexión abierta previamente en tu clase
	    try {
	        // Actualizar la raza en la tabla Razas
	        try (PreparedStatement psRaza = conexion.prepareStatement(sqlRaza)) {
	            psRaza.setString(1, raza.getDescripcionRaza());
	            psRaza.setString(2, raza.getTamañoRaza());
	            psRaza.setInt(3, raza.getVelocidadRaza());
	            psRaza.setString(4, raza.getNombreRaza());
	            psRaza.executeUpdate();  // Ejecuta la actualización de la tabla Razas
	        }

	        // Actualizar las estadísticas de la raza en la tabla EstadisticasRaza
	        try (PreparedStatement psEstadisticas = conexion.prepareStatement(sqlEstadisticas)) {
	            psEstadisticas.setInt(1, raza.getFuerza());
	            psEstadisticas.setInt(2, raza.getDestreza());
	            psEstadisticas.setInt(3, raza.getConstitucion());
	            psEstadisticas.setInt(4, raza.getInteligencia());
	            psEstadisticas.setInt(5, raza.getSabiduria());
	            psEstadisticas.setInt(6, raza.getCarisma());
	            psEstadisticas.setInt(7, raza.getId_Raza());  // Usar el id de la raza para actualizar sus estadísticas
	            psEstadisticas.executeUpdate();  // Ejecuta la actualización de la tabla EstadisticasRaza
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al actualizar raza", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	public ResultSet obtenerNombresRazas() {
		ResultSet rs = null;
		try {
			conexion = ConexionBDSQLServer.GetConexion();
			Statement stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT NombreRaza FROM Razas"); // Query para obtener los nombres de las razas
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener nombres de razas", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}

	public String obtenerNombreRazaPorId(int idRaza) {
		String nombreRaza = "";

		String sql = "SELECT NombreRaza FROM Razas WHERE Id_Raza = ?";

		try (Connection conn = ConexionBDSQLServer.GetConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, idRaza);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				nombreRaza = rs.getString("NombreRaza");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener nombre de la raza", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return nombreRaza;
	}

	/**
	 * Actualiza una raza y sus estadísticas en la base de datos.
	 * 
	 * @param raza Objeto ORaza con los datos a actualizar.
	 */
	
}
