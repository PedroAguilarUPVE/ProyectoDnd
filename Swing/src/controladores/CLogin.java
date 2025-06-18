package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MUsuario;

public class CLogin {

	public MUsuario BuscarUsuario(MUsuario User) {
		try {
			Statement Conexion = ConexionBDSQLServer.GetConexion().createStatement();
			String Sql = "SELECT Password FROM dbo.Usuarios WHERE usuario='" + User.getUsuario() + "';";

			ResultSet rs = Conexion.executeQuery(Sql);

			while (rs.next()) {
				// System.out.print(rs.getString(1));
				User.setPassword(rs.getString(1));
			}
			rs.close();
			Conexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

		return User;
	}
}
