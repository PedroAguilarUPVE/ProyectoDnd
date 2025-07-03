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

/**
 * Clase controladora que gestiona las operaciones CRUD relacionadas con las
 * razas en la base de datos. Utiliza la clase ORaza como modelo de datos y se
 * conecta mediante ConexionBDSQLServer.
 */
public class CRaza {
	private static Connection conexion = null;
	private static String sql;

	/**
	 * Registra una nueva raza y sus estadísticas asociadas en la base de datos.
	 * 
	 * @param raza Objeto ORaza con los datos a registrar.
	 */
	public void registrarRaza(ORaza raza) {
		String sqlRaza = "INSERT INTO Razas (NombreRaza, DescripcionRaza, TamanoRaza, VelocidadRaza) VALUES (?, ?, ?, ?)";
		String sqlEstadisticas = "INSERT INTO EstadisticasRaza (Id_Raza, Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConexionBDSQLServer.GetConexion()) {
			try (PreparedStatement psRaza = conn.prepareStatement(sqlRaza, Statement.RETURN_GENERATED_KEYS)) {
				psRaza.setString(1, raza.getNombre());
				psRaza.setString(2, raza.getDescripcion());
				psRaza.setString(3, raza.getTamano());
				psRaza.setInt(4, raza.getVelocidad());
				psRaza.executeUpdate();

				ResultSet rs = psRaza.getGeneratedKeys();
				int idRaza = -1;
				if (rs.next()) {
					idRaza = rs.getInt(1);
				}

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
	 * Busca y devuelve una raza junto con sus estadísticas a partir del nombre.
	 * 
	 * @param nombreRaza Nombre de la raza a buscar.
	 * @return Objeto ORaza con los datos encontrados o null si no se encontró.
	 */
	public ORaza obtenerRazaConEstadisticas(String nombreRaza) {
		ORaza raza = null;
		String sql = "SELECT * FROM Raza WHERE NombreRaza = ?";

		try (Connection conn = ConexionBDSQLServer.GetConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, nombreRaza);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				raza = new ORaza();
				raza.setId_Raza(rs.getInt("id_Raza"));
				raza.setNombre(rs.getString("NombreRaza"));
				raza.setDescripcion(rs.getString("DescripcionRaza"));
				raza.setTamano(rs.getString("TamanoRaza"));
				raza.setVelocidad(rs.getInt("VelocidadRaza"));
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
	/**
	 * Elimina una raza y sus estadísticas asociadas de la base de datos.
	 * 
	 * @param nombreRaza Nombre de la raza a eliminar.
	 */
	public void borrarRaza(String nombreRaza) {
		String sqlRaza = "DELETE FROM Razas WHERE NombreRaza = ?";
		String sqlEstadisticas = "DELETE FROM EstadisticasRaza WHERE Id_Raza = (SELECT Id_Raza FROM Razas WHERE NombreRaza = ?)";
		try (Connection conn = ConexionBDSQLServer.GetConexion()) {
			try (PreparedStatement psEstadisticas = conn.prepareStatement(sqlEstadisticas)) {
				psEstadisticas.setString(1, nombreRaza);
				psEstadisticas.executeUpdate();
			}

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
	 * Recupera todas las razas y sus estadísticas y las agrega a un TableModel.
	 * 
	 * @param model Modelo de tabla para visualizar las razas.
	 */
	public void buscarRazasConTableModel(DefaultTableModel model) {
		String sql = "SELECT r.Id_Raza, r.NombreRaza, r.DescripcionRaza, r.TamanoRaza, r.VelocidadRaza, "
				+ "e.Fuerza, e.Destreza, e.Constitucion, e.Inteligencia, e.Sabiduria, e.Carisma "
				+ "FROM Razas r JOIN EstadisticasRaza e ON r.Id_Raza = e.Id_Raza";
		try (Connection conn = ConexionBDSQLServer.GetConexion();
				Statement estatuto = conn.createStatement();
				ResultSet rs = estatuto.executeQuery(sql)) {

			while (rs.next()) {
				Object[] fila = new Object[11];
				fila[0] = rs.getInt("Id_Raza");
				fila[1] = rs.getString("NombreRaza");
				fila[2] = rs.getString("DescripcionRaza");
				fila[3] = rs.getString("TamanoRaza");
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

	/**
	 * Obtiene el ID de una raza dada su nombre.
	 * 
	 * @param nombreRaza Nombre de la raza.
	 * @return ID correspondiente o -1 si no se encuentra.
	 */
	public static int obtenerIdRazaPorNombre(String nombreRaza) {
		int idRaza = -1;
		String sql = "SELECT Id_Raza FROM Razas WHERE NombreRaza = ?";

		try (Connection conexion = ConexionBDSQLServer.GetConexion();
				PreparedStatement sentencia = conexion.prepareStatement(sql)) {

			sentencia.setString(1, nombreRaza);
			ResultSet rs = sentencia.executeQuery();

			if (rs.next()) {
				idRaza = rs.getInt("Id_Raza");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener ID de la raza", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return idRaza;
	}

	
	/**
	 * Busca una raza y sus estadísticas asociadas a partir del nombre.
	 * 
	 * @param nombreRaza Nombre de la raza.
	 * @return Objeto ORaza si se encuentra; null en caso contrario.
	 */
	public static ORaza obtenerRazaPorNombre(String nombreRaza) {
		ORaza raza = null;
		String sqlRaza = "SELECT * FROM Razas WHERE NombreRaza = ?";
		String sqlEstadisticas = "SELECT * FROM EstadisticasRaza WHERE Id_Raza = (SELECT Id_Raza FROM Razas WHERE NombreRaza = ?)";

		try (Connection conn = ConexionBDSQLServer.GetConexion()) {
			try (PreparedStatement psRaza = conn.prepareStatement(sqlRaza)) {
				psRaza.setString(1, nombreRaza);
				ResultSet rsRaza = psRaza.executeQuery();

				if (rsRaza.next()) {
					raza = new ORaza();
					raza.setNombre(rsRaza.getString("NombreRaza"));
					raza.setDescripcion(rsRaza.getString("DescripcionRaza"));
					raza.setTamano(rsRaza.getString("TamanoRaza"));
					raza.setVelocidad(rsRaza.getInt("VelocidadRaza"));

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

	/**
	 * Actualiza la información de una raza y sus estadísticas en la base de datos.
	 * 
	 * @param raza Objeto ORaza con los datos actualizados.
	 */
	public void actualizarRaza(ORaza raza) {
		String sqlRaza = "UPDATE Razas SET DescripcionRaza = ?, TamanoRaza = ?, VelocidadRaza = ? WHERE NombreRaza = ?";
		String sqlEstadisticas = "UPDATE EstadisticasRaza SET Fuerza = ?, Destreza = ?, Constitucion = ?, Inteligencia = ?, Sabiduria = ?, Carisma = ? WHERE Id_Raza = ?";

		try {
			try (PreparedStatement psRaza = conexion.prepareStatement(sqlRaza)) {
				psRaza.setString(1, raza.getDescripcion());
				psRaza.setString(2, raza.getTamano());
				psRaza.setInt(3, raza.getVelocidad());
				psRaza.setString(4, raza.getNombre());
				psRaza.executeUpdate();
			}

			try (PreparedStatement psEstadisticas = conexion.prepareStatement(sqlEstadisticas)) {
				psEstadisticas.setInt(1, raza.getFuerza());
				psEstadisticas.setInt(2, raza.getDestreza());
				psEstadisticas.setInt(3, raza.getConstitucion());
				psEstadisticas.setInt(4, raza.getInteligencia());
				psEstadisticas.setInt(5, raza.getSabiduria());
				psEstadisticas.setInt(6, raza.getCarisma());
				psEstadisticas.setInt(7, raza.getId_Raza());
				psEstadisticas.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar raza", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Recupera todos los nombres de razas de la base de datos.
	 * 
	 * @return ResultSet con los nombres de las razas.
	 */
	public ResultSet obtenerNombresRazas() {
		ResultSet rs = null;
		try {
			conexion = ConexionBDSQLServer.GetConexion();
			Statement stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT NombreRaza FROM Razas");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener nombres de razas", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}

	/**
	 * Obtiene el nombre de una raza a partir de su ID.
	 * 
	 * @param idRaza Identificador de la raza.
	 * @return Nombre de la raza si existe; cadena vacía en caso contrario.
	 */
	public static String obtenerNombreRazaPorId(int idRaza) {
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
	

    public static ORaza obtenerRazaPorId(int idRaza) {
    	ORaza Raza = obtenerRazaPorNombre(obtenerNombreRazaPorId(idRaza));
    	return Raza;
    }

	public void buscarRazasConTableModel(DefaultTableModel model, int pagina, int registrosPorPagina) {

		PreparedStatement pst = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexi�n ala base de Datos
		conexion = ConexionBDSQLServer.GetConexion(); // sqlserver
		sql = "SELECT * FROM Razas ORDER BY Id_Raza OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

		try {

			int C = 5;
			
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, (pagina - 1) * registrosPorPagina);
			pst.setInt(2, registrosPorPagina);

			ResultSet rs = pst.executeQuery();

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
		sql = "SELECT count(id_Raza) as 'Conteo' FROM Razas ";

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