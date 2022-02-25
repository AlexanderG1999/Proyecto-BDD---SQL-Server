package Fuentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 4
 */

public class Conexion {

    public Connection getConexion(int valor) {
        String nombrePC = "";
        String database = "";
        
        switch (valor) {
            case 1:
                nombrePC = "LAPTOP-BDO1H2E7";
                database = "Proyecto_Sucursal_Quito";
                break;
            case 2:
                nombrePC = "DESKTOP-K9I5VUE";
                database = "Proyecto_Sucursal_Valle";
                break;
            case 3:
                nombrePC = "DESKTOP-TFI2VS2";
                database = "Proyecto_Sucursal_Latacunga";
                break;
        }
        
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        String URL = "jdbc:sqlserver://"+nombrePC+":1433;"
            + "instance=SQLEXPRES;"
            + "database="+database+";"
            + "user=sa;"
            + "password=P@ssw0rd;"
            + "loginTimeout=30;";
        
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(URL);
            System.out.println("CONEXIÓN REALIZADA CON ÉXITO A " +database);
            return con;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "CONEXIÓN FALLIDA", "MENSAJE", JOptionPane.DEFAULT_OPTION);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
