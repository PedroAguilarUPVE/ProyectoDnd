package vistas;

import java.sql.Connection;

import conexion.ConexionBDSQLServer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteSimple {

    public static void main(String[] args) {
        Connection conn = ConexionBDSQLServer.GetConexion();
        try {
            String reportPath =  "src/reportes/Flower.jrxml";;
            JasperReport report = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(report, null, conn);
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}