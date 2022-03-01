package Fuentes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    private String hostname;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Connection getConexion() {
        String cmd = "hostname"; //Conocer en que PC se esta ejecutando

        try {
            Process p;
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            //Resultado comando Hostname
            this.hostname = br.readLine();

            p.waitFor();
            p.destroy();

        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        String database = "";

        switch (this.hostname) {
            case "ALEXANDER":
                database = "Proyecto_Sucursal_Quito";
                break;
            case "DESKTOP-10M4LLF": //Ricardo
                database = "Proyecto_Sucursal_Valle";
                break;
            case "DESKTOP-2BD5KES": //Leonardo
                database = "Proyecto_Sucursal_Latacunga";
                break;
        }

        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        String URL = "jdbc:sqlserver://" + this.hostname + ":1433;"
                + "instance=SQLEXPRES;"
                + "database=" + database + ";"
                + "user=sa;"
                + "password=P@ssw0rd;"
                + "loginTimeout=30;";

        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(URL);
            System.out.println("CONEXIÓN REALIZADA CON ÉXITO A " + database);
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
