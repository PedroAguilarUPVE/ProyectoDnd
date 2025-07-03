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
import modelos.OSubclase;

/**
 * Clase controladora para gestionar las operaciones relacionadas con la tabla Subclases en la base de datos.
 * Incluye métodos para registrar, eliminar, buscar y obtener datos de subclases.
 * 
 * Utiliza la clase {@link ConexionBDSQLServer} para establecer la conexión con SQL Server.
 * 
 * @author Jesús
 */
public class CSubclase {
    private static Connection conexion = null;
    private static String sql;

    /**
     * Registra una nueva subclase en la base de datos.
     *
     * @param miSubclase Objeto {@link OSubclase} que contiene los datos de la subclase a registrar.
     */
    public void registrarSubclase(OSubclase miSubclase) {
        PreparedStatement sentencia = null;
        conexion = ConexionBDSQLServer.GetConexion(); // Obtener conexión a SQL Server
        
        sql = "INSERT INTO Subclases ( Id_Clase, nombre, Descripcion) VALUES(?,?,?)";

        try {
            sentencia = conexion.prepareStatement(sql);
            //sentencia.setInt(1, miSubclase.getId_Subclase());
            sentencia.setInt(1, miSubclase.getId_Clase());
            sentencia.setString(2, miSubclase.getNombre());
            sentencia.setString(3, miSubclase.getDescripcion());

            if (sentencia.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Subclase registrada exitosamente", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    public static void actualizarSubclase(OSubclase subclase) {
        String sql = "UPDATE Subclases SET Descripcion = ?, id_Clase = ? WHERE id_Subclase = ?";
        try (PreparedStatement ps = ConexionBDSQLServer.GetConexion().prepareStatement(sql)) {
            ps.setString(1, subclase.getDescripcion());
            ps.setInt(2, subclase.getId_Clase());
            ps.setInt(3, subclase.getId_Subclase());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar clase", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    /**
     * Elimina una subclase existente de la base de datos, dado su ID.
     *
     * @param idSubclase ID de la subclase que se desea eliminar.
     */
    public void borrarSubclase(int idSubclase) {
        try {
            Statement estatuto = ConexionBDSQLServer.GetConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM Subclases WHERE Id_Subclase=" + idSubclase);
            JOptionPane.showMessageDialog(null, "Subclase eliminada exitosamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar subclase", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Consulta todas las subclases en la base de datos y las agrega a un {@link DefaultTableModel}.
     *
     * @param model Modelo de tabla que será llenado con los datos de las subclases.
     */
    public void buscarSubclasesConTableModel(DefaultTableModel model) {
        try {
            Statement estatuto = ConexionBDSQLServer.GetConexion().createStatement();
            ResultSet rs = estatuto.executeQuery("SELECT * FROM Subclases");

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("Id_Subclase");
                fila[1] = rs.getInt("Id_Clase");
                fila[2] = rs.getString("Nombre");
                fila[3] = rs.getString("Descripcion");

                model.addRow(fila);
            }
            rs.close();
            estatuto.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar subclases", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    /**
     * Obtiene el ID de una subclase dado su nombre.
     *
     * @param nombreSubclase Nombre de la subclase.
     * @return El ID correspondiente de la subclase, o -1 si no se encuentra.
     */
    public static int obtenerIdSubclasePorNombre(String nombreSubclase) {
        int idSubclase = -1;
        String sql = "SELECT Id_Subclase FROM Subclases WHERE Nombre = ?";

        try (Connection conexion = ConexionBDSQLServer.GetConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
            sentencia.setString(1, nombreSubclase);
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                idSubclase = rs.getInt("Id_Subclase");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener ID de la subclase", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return idSubclase;
    }

    /**
     * Obtiene el nombre de una subclase dado su ID.
     *
     * @param idSubclase ID de la subclase.
     * @return Nombre de la subclase, o una cadena vacía si no se encuentra.
     */
    public String obtenerNombreSubclasePorId(int idSubclase) {
        String nombreSubclase = "";
        String sql = "SELECT nombre FROM Subclases WHERE Id_Subclase = ?";

        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idSubclase);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nombreSubclase = rs.getString("nombre");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombre de la subclase", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return nombreSubclase;
    }
    
    public static OSubclase buscarSubclasePorId(int idSubclase) {
        OSubclase subclase = null;
        String sql = "SELECT * FROM Subclases WHERE id_Subclase = ?";
        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSubclase);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                subclase = new OSubclase();
                subclase.setNombre(rs.getString("Nombre"));
                subclase.setDescripcion(rs.getString("Descripcion"));
                subclase.setId_Clase(rs.getInt("id_Clase"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar subclase por nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return subclase;
    }
    

    /**
     * Obtiene los nombres de todas las subclases que pertenecen a una clase específica.
     *
     * @param idClase ID de la clase.
     * @return ResultSet que contiene los nombres de las subclases asociadas.
     */
    public ResultSet obtenerNombresSubclases(int idClase) {
        ResultSet rs = null;
        try {
            conexion = ConexionBDSQLServer.GetConexion();
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery("SELECT nombre FROM Subclases WHERE Id_Clase = " + idClase);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de subclases", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
	public void buscarSubclasesConTableModel(DefaultTableModel model, int pagina, int registrosPorPagina) {

		PreparedStatement pst = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexi�n ala base de Datos
		conexion = ConexionBDSQLServer.GetConexion(); // sqlserver
		sql = "SELECT * FROM Subclases ORDER BY Id_Subclase OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

		try {

			pst = conexion.prepareStatement(sql);
			pst.setInt(1, (pagina - 1) * registrosPorPagina);
			pst.setInt(2, registrosPorPagina);

			ResultSet rs = pst.executeQuery();

			model.setRowCount(0); // Limpiar tabla
			while (rs.next()) {
				Object[] fila = new Object[4];
				for (int i = 0; i < 4; i++)
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
		sql = "SELECT count(id_Subclase) as 'Conteo' FROM Subclases ";

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
