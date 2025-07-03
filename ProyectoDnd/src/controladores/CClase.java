 package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import conexion.ConexionBDSQLServer;
import modelos.OClase;
import modelos.ORaza;

/**
 * Controlador para gestionar operaciones relacionadas con la entidad Clase
 * en la base de datos: registrar, actualizar, eliminar y consultar.
 */
public class CClase {

    private static Connection conexion = null;
	private static String sql;
	/**
     * Registra una nueva clase en la base de datos.
     *
     * @param clase Objeto OClase con los datos a registrar.
     */
    public void registrarClase(OClase clase) {
        String sql = "INSERT INTO Clases (Nombre, Descripcion, Tipo, DadoDano) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = ConexionBDSQLServer.GetConexion().prepareStatement(sql)) {
            ps.setString(1, clase.getNombre());
            ps.setString(2, clase.getDescripcion());
            ps.setString(3, clase.getTipo());
            ps.setInt(4, clase.getDadoDano());
            ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Clase registrada exitosamente");
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al registrar clase", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
    }

    /**
     * Elimina una clase de la base de datos por su nombre.
     *
     * @param Nombre Nombre de la clase a eliminar.
     */
    public void borrarClase(String Nombre) {
        String sql = "DELETE FROM Clases WHERE Nombre = ?";
        try (PreparedStatement ps = ConexionBDSQLServer.GetConexion().prepareStatement(sql)) {
            ps.setString(1, Nombre);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Clase borrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la clase.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al borrar la clase", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Obtiene el nombre de una clase dado su ID.
     *
     * @param idClase ID de la clase.
     * @return Nombre de la clase, o cadena vacía si no se encuentra.
     */
    public static String obtenerNombreClasePorId(int idClase) {
        String nombreClase = "";
        String sql = "SELECT Nombre FROM Clases WHERE Id_Clase = ?";

        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idClase);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombreClase = rs.getString("Nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombre de la clase", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return nombreClase;
    }

    public static OClase obtenerClasePorId(int idClase) {
    	OClase clase = buscarClasePorNombre(obtenerNombreClasePorId(idClase));
    	return clase;
    }
    
    /**
     * Llena un modelo de tabla con todas las clases existentes en la base de datos.
     *
     * @param model Modelo de tabla donde se insertarán los datos.
     */
    public void buscarClasesConTableModel(DefaultTableModel model) {
        String sql = "SELECT * FROM Clases ORDER BY Id_Clase";
        try (Statement stmt = ConexionBDSQLServer.GetConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("Id_Clase");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("Descripcion");
                fila[3] = rs.getString("Tipo");
                fila[4] = rs.getInt("DadoDano");

                model.addRow(fila);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar clases", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Busca una clase por su nombre y devuelve un objeto OClase con sus datos.
     *
     * @param Nombre Nombre de la clase a buscar.
     * @return Objeto OClase si se encuentra, o null si no existe.
     */
    public static OClase buscarClasePorNombre(String Nombre) {
        OClase clase = null;
        String sql = "SELECT * FROM Clases WHERE Nombre = ?";
        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, Nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                clase = new OClase();
                clase.setNombre(rs.getString("Nombre"));
                clase.setDescripcion(rs.getString("Descripcion"));
                clase.setTipo(rs.getString("Tipo"));
                clase.setDadoDano(rs.getInt("DadoDano"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar clase por nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return clase;
    }

    /**
     * Obtiene el ID de una clase dado su nombre.
     *
     * @param Nombre Nombre de la clase.
     * @return ID de la clase, o -1 si no se encuentra.
     */
    public static int obtenerIdClasePorNombre(String Nombre) {
        int idClase = -1;
        String sql = "SELECT Id_Clase FROM Clases WHERE Nombre = ?";

        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, Nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idClase = rs.getInt("Id_Clase");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener ID de la clase", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return idClase;
    }

    /**
     * Devuelve un ResultSet con todos los nombres de clases, ordenados por ID.
     *
     * @return ResultSet con los nombres de las clases.
     */
    public ResultSet obtenerNombresClases() {
        ResultSet rs = null;
        String sql = "SELECT Nombre FROM Clases ORDER BY Id_Clase";
        try {
            Connection conn = ConexionBDSQLServer.GetConexion();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de clases", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return rs;
    }

    /**
     * Elimina una clase de la base de datos dado su ID.
     *
     * @param idClase ID de la clase a eliminar.
     */
    public void eliminarClase(int idClase) {
        String sql = "DELETE FROM Clases WHERE Id_Clase = ?";
        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idClase);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Clase eliminada correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la clase: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de una clase en la base de datos.
     *
     * @param clase Objeto OClase con los nuevos datos de la clase.
     */
    public static void actualizarClase(OClase clase) {
        String sql = "UPDATE Clases SET Descripcion = ?, Tipo = ?, DadoDano = ? WHERE Nombre = ?";
        try (PreparedStatement ps = ConexionBDSQLServer.GetConexion().prepareStatement(sql)) {
            ps.setString(1, clase.getDescripcion());
            ps.setString(2, clase.getTipo());
            ps.setInt(3, clase.getDadoDano());
            ps.setString(4, clase.getNombre());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar clase", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	public void buscarClasesConTableModel(DefaultTableModel model, int pagina, int registrosPorPagina) {

		PreparedStatement pst = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexi�n ala base de Datos
		conexion = ConexionBDSQLServer.GetConexion(); // sqlserver
		sql = "SELECT * FROM Clases ORDER BY Id_Clase OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

		try {

			pst = conexion.prepareStatement(sql);
			pst.setInt(1, (pagina - 1) * registrosPorPagina);
			pst.setInt(2, registrosPorPagina);

			ResultSet rs = pst.executeQuery();

			model.setRowCount(0); // Limpiar tabla
			while (rs.next()) {
				Object[] fila = new Object[5];
				for (int i = 0; i < 5; i++)
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
		sql = "SELECT count(id_Clase) as 'Conteo' FROM clases ";

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

