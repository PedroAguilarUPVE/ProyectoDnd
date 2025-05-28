package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import conexion.ConexionBDSQLServer;
import modelos.OSubclase;

public class CSubclase {
    private static Connection conexion = null;
    private static String sql;

    /**
     * Registra una nueva subclase en la base de datos.
     * @param miSubclase Objeto OSubclase con los datos a registrar.
     */
    public void registrarSubclase(OSubclase miSubclase) {
        PreparedStatement sentencia = null;
        conexion = ConexionBDSQLServer.GetConexion(); // Obtener conexión a SQL Server
        
        sql = "INSERT INTO Subclases (Id_Subclase, Id_Clase, NombreSubclase, DescripcionSubclase) VALUES(?,?,?,?)";

        try {
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, miSubclase.getId_Subclase());
            sentencia.setInt(2, miSubclase.getId_Clase());
            sentencia.setString(3, miSubclase.getNombreSubclase());
            sentencia.setString(4, miSubclase.getDescripcionSubclase());

            if (sentencia.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Subclase registrada exitosamente", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Elimina una subclase de la base de datos.
     * @param idSubclase ID de la subclase a eliminar.
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
     * Obtiene todas las subclases de la base de datos y las almacena en un TableModel.
     * @param model Modelo de tabla a llenar con los datos.
     */
    public void buscarSubclasesConTableModel(DefaultTableModel model) {
        try {
            Statement estatuto = ConexionBDSQLServer.GetConexion().createStatement();
            ResultSet rs = estatuto.executeQuery("SELECT * FROM Subclases");

            while (rs.next()) {
                Object[] fila = new Object[4]; // Ajustar según la cantidad de columnas
                fila[0] = rs.getInt("Id_Subclase");
                fila[1] = rs.getInt("Id_Clase");
                fila[2] = rs.getString("NombreSubclase");
                fila[3] = rs.getString("DescripcionSubclase");

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
     * Obtiene los nombres de las subclases de la base de datos.
     * @param idClase ID de la clase para la cual se deben obtener las subclases.
     * @return ResultSet con los nombres de las subclases.
     */
    public int obtenerIdSubclasePorNombre(String nombreSubclase) {
        int idSubclase = -1;
        String sql = "SELECT Id_Subclase FROM Subclases WHERE NombreSubclase = ?";

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
    public String obtenerNombreSubclasePorId(int idSubclase) {
        String nombreSubclase = "";

        String sql = "SELECT NombreSubclase FROM Subclases WHERE Id_Subclase = ?";

        try (Connection conn = ConexionBDSQLServer.GetConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idSubclase);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nombreSubclase = rs.getString("NombreSubclase");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombre de la subclase", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return nombreSubclase;
    }
    
    public ResultSet obtenerNombresSubclases(int idClase) {
        ResultSet rs = null;
        try {
            conexion = ConexionBDSQLServer.GetConexion();
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery("SELECT NombreSubclase FROM Subclases WHERE Id_Clase = " + idClase);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de subclases", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
}
