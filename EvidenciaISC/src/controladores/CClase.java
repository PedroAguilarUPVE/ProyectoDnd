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

public class CClase {
    private static Connection conexion = null;
    private static String sql;

    /**
     * Registra una nueva clase en la base de datos.
     * @param miClase Objeto OClase con los datos a registrar.
     */
    public void registrarClase(OClase clase) {
        String sql = "INSERT INTO Clases (NombreClase, DescripcionClase, TipoClase, DadoDaño) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = ConexionBDSQLServer.GetConexion().prepareStatement(sql)) {
            ps.setString(1, clase.getNombreClase());
            ps.setString(2, clase.getDescripcionClase());
            ps.setString(3, clase.getTipoClase());
            ps.setInt(4, clase.getDadoDaño());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar clase", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * Elimina una clase de la base de datos.
     * @param idClase ID de la clase a eliminar.
     */
    public void borrarClase(String nombreClase) {
        String sql = "DELETE FROM Clases WHERE NombreClase = ?";
        try (PreparedStatement ps = ConexionBDSQLServer.GetConexion().prepareStatement(sql)) {
            ps.setString(1, nombreClase);
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
    
    public String obtenerNombreClasePorId(int idClase) {
        String nombreClase = "";

        String sql = "SELECT NombreClase FROM Clases WHERE Id_Clase = ?";

        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idClase);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nombreClase = rs.getString("NombreClase");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombre de la clase", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return nombreClase;
    }

    /**
     * Obtiene todas las clases de la base de datos y las almacena en un TableModel.
     * @param model Modelo de tabla a llenar con los datos.
     */
    public void buscarClasesConTableModel(DefaultTableModel model) {
        try {
            Statement estatuto = ConexionBDSQLServer.GetConexion().createStatement();
            ResultSet rs = estatuto.executeQuery("SELECT * FROM clases Order By Id_Clase");

            while (rs.next()) {
                Object[] fila = new Object[5]; // Ajustar según la cantidad de columnas
                fila[0] = rs.getInt("id_Clase");
                fila[1] = rs.getString("NombreClase");
                fila[2] = rs.getString("DescripcionClase");
                fila[3] = rs.getString("TipoClase");
                fila[4] = rs.getInt("DadoDaño");

                model.addRow(fila);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar clases", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public OClase buscarClasePorNombre(String nombreClase) {
        OClase clase = null;
        String sql = "SELECT * FROM Clases WHERE NombreClase = ?";
        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreClase);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                clase = new OClase();
                clase.setNombreClase(rs.getString("NombreClase"));
                clase.setDescripcionClase(rs.getString("DescripcionClase"));
                clase.setTipoClase(rs.getString("TipoClase"));
                clase.setDadoDaño(rs.getInt("DadoDaño"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar clase por nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clase;
    }
    
    
    
    public static int obtenerIdClase(String nombreClase) {
        int idClase = -1;
        String sql = "SELECT Id_Clase FROM Clases WHERE NombreClase = ?";

        try (Connection conexion = ConexionBDSQLServer.GetConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
            sentencia.setString(1, nombreClase);
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                idClase = rs.getInt("Id_Clase");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener ID de la clase", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return idClase;
    }
    
    public ResultSet obtenerNombresClases() {
        ResultSet rs = null;
        try {
            conexion = ConexionBDSQLServer.GetConexion();
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery("SELECT NombreClase FROM Clases Order By Id_Clase");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de clases", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    public void eliminarClase(int idClase) {
        try {
            conexion = ConexionBDSQLServer.GetConexion();
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM Clases WHERE Id_Clase = ?");
            stmt.setInt(1, idClase);
            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Clase eliminada correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la clase: " + e.getMessage());
        }
    }
    public void actualizarClase(OClase clase) {
        String sql = "UPDATE Clases SET DescripcionClase = ?, TipoClase = ?, DadoDaño = ? WHERE NombreClase = ?";
        try (PreparedStatement ps = ConexionBDSQLServer.GetConexion().prepareStatement(sql)) {
            ps.setString(1, clase.getDescripcionClase());
            ps.setString(2, clase.getTipoClase());
            ps.setInt(3, clase.getDadoDaño());
            ps.setString(4, clase.getNombreClase());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar clase", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
