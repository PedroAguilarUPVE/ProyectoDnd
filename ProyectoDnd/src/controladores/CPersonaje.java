package controladores;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import conexion.ConexionBDSQLServer;
import modelos.OPersonaje;

/**
 * Controlador de la entidad Personaje. Gestiona operaciones CRUD y consultas
 * relacionadas con personajes y sus estadísticas.
 */
public class CPersonaje {
	private static Connection conexion = null;
	private static String sql;

	/**
	 * Registra un nuevo personaje en la base de datos junto con sus estadísticas.
	 * 
	 * @param personaje Objeto OPersonaje con los datos a registrar.
	 */
	public static void registrarPersonaje(OPersonaje personaje) {
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		int idGenerado = -1;
		conexion = ConexionBDSQLServer.GetConexion(); // Obtener conexión a SQL Server

		sql = "INSERT INTO Personajes (NombrePersonaje, Nivel, Id_Clase, Id_Subclase, Id_Raza, BonusCompetencia) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";

		try {
			sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, personaje.getNombrePersonaje());
			sentencia.setInt(2, personaje.getNivel());
			sentencia.setInt(3, personaje.getId_Clase());
			sentencia.setInt(4, personaje.getId_Subclase());
			sentencia.setInt(5, personaje.getId_Raza());
			sentencia.setInt(6, personaje.getBonusCompetencia());

			if (sentencia.executeUpdate() > 0) {
				rs = sentencia.getGeneratedKeys();
				if (rs.next()) {
					idGenerado = rs.getInt(1);
				}

				// Insertar estadísticas del personaje
				sql = "INSERT INTO EstadisticasPersonaje (Id_Personaje, Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
				sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, idGenerado);
				sentencia.setInt(2, personaje.getFuerza());
				sentencia.setInt(3, personaje.getDestreza());
				sentencia.setInt(4, personaje.getConstitucion());
				sentencia.setInt(5, personaje.getInteligencia());
				sentencia.setInt(6, personaje.getSabiduria());
				sentencia.setInt(7, personaje.getCarisma());

				if (sentencia.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Personaje registrado exitosamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (sentencia != null)
					sentencia.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Consulta un personaje específico por su ID, incluyendo sus estadísticas.
	 * 
	 * @param idPersonaje ID del personaje a consultar.
	 * @return Objeto OPersonaje con los datos encontrados o null si no existe.
	 */
	public static OPersonaje obtenerPersonajePorId(int idPersonaje) {
		OPersonaje personaje = new OPersonaje();

		String sql = "SELECT p.Id_Personaje, p.NombrePersonaje, p.Nivel, p.Id_Clase, p.Id_Subclase, p.Id_Raza, p.BonusCompetencia, "
				+ "e.Fuerza, e.Destreza, e.Constitucion, e.Inteligencia, e.Sabiduria, e.Carisma " + "FROM Personajes p "
				+ "JOIN EstadisticasPersonaje e ON p.Id_Personaje = e.Id_Personaje " + "WHERE p.Id_Personaje = ?";

		try (Connection conn = ConexionBDSQLServer.GetConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, idPersonaje);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				personaje = new OPersonaje();
				personaje.setId_Personaje(rs.getInt("Id_Personaje"));
				personaje.setNombrePersonaje(rs.getString("NombrePersonaje"));
				personaje.setNivel(rs.getInt("Nivel"));
				personaje.setId_Clase(rs.getInt("Id_Clase"));
				personaje.setId_Subclase(rs.getInt("Id_Subclase"));
				personaje.setId_Raza(rs.getInt("Id_Raza"));
				personaje.setBonusCompetencia(rs.getInt("BonusCompetencia"));
				personaje.setFuerza(rs.getInt("Fuerza"));
				personaje.setDestreza(rs.getInt("Destreza"));
				personaje.setConstitucion(rs.getInt("Constitucion"));
				personaje.setInteligencia(rs.getInt("Inteligencia"));
				personaje.setSabiduria(rs.getInt("Sabiduria"));
				personaje.setCarisma(rs.getInt("Carisma"));
				
				System.out.println(personaje.getNombrePersonaje());
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener datos del personaje", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return personaje;
	}

	/**
	 * Elimina un personaje y sus estadísticas por ID.
	 * 
	 * @param idPersonaje ID del personaje a eliminar.
	 */
	public void borrarPersonaje(int idPersonaje) {
		try {
			Statement estatuto = ConexionBDSQLServer.GetConexion().createStatement();
			estatuto.executeUpdate("DELETE FROM EstadisticasPersonaje WHERE Id_Personaje=" + idPersonaje);
			estatuto.executeUpdate("DELETE FROM Personajes WHERE Id_Personaje=" + idPersonaje);
			JOptionPane.showMessageDialog(null, "Personaje eliminado exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al eliminar personaje", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Llena un modelo de tabla con todos los personajes y sus estadísticas.
	 * 
	 * @param model Modelo de tabla a llenar.
	 */
	public void buscarPersonajes(DefaultTableModel model) {
		try {
			Statement estatuto = ConexionBDSQLServer.GetConexion().createStatement();
			sql = "Select P.NombrePersonaje, P.Nivel, C.Nombre, SC.Nombre, R.NombreRaza "
					+ "From Personajes P "
					+ "INNER JOIN Clases C On C.Id_Clase=P.Id_Clase "
					+ "Inner Join Subclases SC On SC.Id_Subclase = P.Id_Subclase "
					+ "Inner Join Razas R On R.Id_Raza=P.Id_Raza ";
			ResultSet rs = estatuto.executeQuery(sql);

			while (rs.next()) {
				Object[] fila = new Object[13];
				fila[0] = rs.getInt("Id_Personaje");
				fila[1] = rs.getString("NombrePersonaje");
				fila[2] = rs.getInt("Nivel");
				fila[3] = rs.getInt("Id_Clase");
				fila[4] = rs.getInt("Id_Subclase");
				fila[5] = rs.getInt("Id_Raza");
				fila[6] = rs.getInt("BonusCompetencia");
				fila[7] = rs.getInt("Fuerza");
				fila[8] = rs.getInt("Destreza");
				fila[9] = rs.getInt("Constitucion");
				fila[10] = rs.getInt("Inteligencia");
				fila[11] = rs.getInt("Sabiduria");
				fila[12] = rs.getInt("Carisma");

				model.addRow(fila);
			}
			rs.close();
			estatuto.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar personajes", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Llena un modelo de tabla con información combinada de personajes, clases,
	 * subclases y razas.
	 * 
	 * @param model Modelo de tabla a llenar.
	 */
	public void buscarPersonajesConTableModel(DefaultTableModel model) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conexion = ConexionBDSQLServer.GetConexion();
			sql = """
					    SELECT P.NombrePersonaje, P.Nivel, C.Nombre, SC.Nombre, R.NombreRaza
					    FROM Personajes P
					    INNER JOIN Clases C ON C.Id_Clase = P.Id_Clase
					    INNER JOIN Subclases SC ON SC.Id_Subclase = P.Id_Subclase
					    INNER JOIN Razas R ON R.Id_Raza = P.Id_Raza
					    ORDER BY Id_Personaje
					""";

			pst = conexion.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Object[] fila = { rs.getString("NombrePersonaje"), rs.getInt("Nivel"), rs.getString("Nombre"),
						rs.getString("Nombre"), rs.getString("NombreRaza") };
				model.addRow(fila);
			}
		} catch (SQLException e) {
			System.err.println("Error al buscar personajes: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al buscar personajes", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Elimina un personaje de la base de datos por su nombre.
	 * 
	 * @param nombre Nombre del personaje a eliminar.
	 */
	public void eliminarPersonajePorNombre(String nombre) {
		String sqlEstadisticas = "DELETE FROM EstadisticasPersonaje WHERE Id_Personaje = (SELECT Id_Personaje FROM Personajes WHERE NombrePersonaje = ?)";

		try {
			conexion = ConexionBDSQLServer.GetConexion();

			try (PreparedStatement psEstadisticas = conexion.prepareStatement(sqlEstadisticas)) {
				psEstadisticas.setString(1, nombre);
				psEstadisticas.executeUpdate();
			}

			String sqlPersonaje = "DELETE FROM Personajes WHERE NombrePersonaje = ?";
			try (PreparedStatement psPersonaje = conexion.prepareStatement(sqlPersonaje)) {
				psPersonaje.setString(1, nombre);
				psPersonaje.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar personaje y sus estadísticas", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Obtiene los nombres de todos los personajes registrados.
	 * 
	 * @return ResultSet con los nombres de los personajes.
	 */
	public ResultSet obtenerNombresPersonajes() {
		ResultSet rs = null;
		try {
			conexion = ConexionBDSQLServer.GetConexion();
			Statement stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT NombrePersonaje FROM Personajes ORDER BY Id_Personaje");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener nombres de personajes", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}

	/**
	 * Actualiza un personaje existente y sus estadísticas.
	 * 
	 * @param personaje Objeto OPersonaje con los datos modificados.
	 */
	public void actualizarPersonaje(OPersonaje personaje) {
		PreparedStatement pst = null;
		try {
			conexion = ConexionBDSQLServer.GetConexion();

			String sql = """
					    UPDATE Personajes SET
					        NombrePersonaje = ?, Nivel = ?, Id_Clase = ?, Id_Subclase = ?, Id_Raza = ?, BonusCompetencia = ?
					    WHERE Id_Personaje = ?
					""";
			pst = conexion.prepareStatement(sql);
			pst.setString(1, personaje.getNombrePersonaje());
			pst.setInt(2, personaje.getNivel());
			pst.setInt(3, personaje.getId_Clase());
			pst.setInt(4, personaje.getId_Subclase());
			pst.setInt(5, personaje.getId_Raza());
			pst.setInt(6, personaje.getBonusCompetencia());
			pst.setInt(7, personaje.getId_Personaje());
			pst.executeUpdate();

			// Actualizar estadísticas
			sql = """
					    UPDATE EstadisticasPersonaje SET
					        Fuerza = ?, Destreza = ?, Constitucion = ?, Inteligencia = ?, Sabiduria = ?, Carisma = ?
					    WHERE Id_Personaje = ?
					""";
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, personaje.getFuerza());
			pst.setInt(2, personaje.getDestreza());
			pst.setInt(3, personaje.getConstitucion());
			pst.setInt(4, personaje.getInteligencia());
			pst.setInt(5, personaje.getSabiduria());
			pst.setInt(6, personaje.getCarisma());
			pst.setInt(7, personaje.getId_Personaje());
			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Personaje actualizado exitosamente");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Obtiene el ID de un personaje por su nombre.
	 * 
	 * @param nombrePersonaje Nombre del personaje.
	 * @return ID del personaje o -1 si no se encuentra.
	 */
	public static int obtenerIdPersonaje(String nombrePersonaje) {
		int idPersonaje = 1;
		String sql = "SELECT Id_Personaje FROM Personajes WHERE NombrePersonaje = ? ";

		try (Connection conexion = ConexionBDSQLServer.GetConexion();
				PreparedStatement sentencia = conexion.prepareStatement(sql)) {

			sentencia.setString(1, nombrePersonaje);
			
			ResultSet rs = sentencia.executeQuery();
			
			if (rs.next()) {
                idPersonaje = rs.getInt("Id_Personaje");
            }
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener ID del personaje", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return idPersonaje;
	}

	public void buscarPersonajesConTableModel(DefaultTableModel model, int pagina, int registrosPorPagina) {

		PreparedStatement pst = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexi�n ala base de Datos
		conexion = ConexionBDSQLServer.GetConexion(); // sqlserver
		sql = "Select P.NombrePersonaje, P.Nivel, C.Nombre, SC.Nombre, R.NombreRaza "
				+ "From Personajes P "
				+ "INNER JOIN Clases C On C.Id_Clase=P.Id_Clase "
				+ "Inner Join Subclases SC On SC.Id_Subclase = P.Id_Subclase "
				+ "Inner Join Razas R On R.Id_Raza=P.Id_Raza "
				+ " ORDER BY Id_Personaje OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

		try {

			pst = conexion.prepareStatement(sql);
			pst.setInt(1, (pagina - 1) * registrosPorPagina);
			pst.setInt(2, registrosPorPagina);

			ResultSet rs = pst.executeQuery();
 
			int C = 5;
			
			model.setRowCount(0); // Limpiar tabla
			while (rs.next()) {
				Object[] fila = new Object[C];
				for (int i = 0; i < C; i++)
					fila[i] = rs.getObject(i + 1);
				model.addRow(fila);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int contarPaginas(int registrosPorPagina) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexi�n ala base de Datos
		conexion = ConexionBDSQLServer.GetConexion(); // sqlserver
		sql = "SELECT count(id_Personaje) as 'Conteo' FROM Personajes";

		int Conteo = 1;

		try (Connection conexion = ConexionBDSQLServer.GetConexion();
				PreparedStatement sentencia = conexion.prepareStatement(sql)) {

			ResultSet rs = sentencia.executeQuery();

			if (rs.next()) {
				Conteo = rs.getInt("Conteo");
				System.out.println(Conteo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al contar paginas", "Error", JOptionPane.ERROR_MESSAGE);
		}

		int paginas = (int) Math.ceil(1f * Conteo / registrosPorPagina);
		System.out.println(paginas);
		return paginas;
	}
}