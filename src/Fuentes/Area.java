package Fuentes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 4
 */
public class Area {

    //Atributos
    private int codigo;
    private String ambito;
    private String descripcion;

    public Area(int codigo, String ambito, String descripcion) {
        this.codigo = codigo;
        this.ambito = ambito;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean guardarArea(Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String querry = "INSERT INTO area "
                        + "values (" + this.codigo + ",'" + this.ambito + "','" + this.descripcion + "')";

                //Ingresando datos a SQL Server
                Statement stmt = cn.createStatement();//Envia tipos de sentencias sql
                stmt.executeUpdate(querry);//ejecuta la sentencia
                JOptionPane.showMessageDialog(null, "Registro agregado con ÉXITO.", "Mensaje", JOptionPane.DEFAULT_OPTION);
                resultado = true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "NO se logro agregar el registro.", "Mensaje", JOptionPane.DEFAULT_OPTION);
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resultado = false;
        }
        return resultado;
    }

    public boolean modificarArea(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea modificar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Envia tipos de sentencias sql y tambien trabaja con parametros
                PreparedStatement pps = cn.prepareStatement("UPDATE area SET "
                        + "AREA_AMBITO='" + this.ambito + "',"
                        + "AREA_DESCRIPCION='" + this.descripcion + "' "
                        + "WHERE AREA_COD = " + valor);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Actualizado.", "Mensaje", JOptionPane.DEFAULT_OPTION);
                resultado = true;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "NO se logro actualizar el registro.", "Mensaje", JOptionPane.DEFAULT_OPTION);
            }
        } else {
            resultado = false;
        }

        return resultado;
    }

    public static boolean eliminarArea(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Eliminando el registro solicitado
                PreparedStatement pps = cn.prepareStatement("DELETE FROM area WHERE AREA_COD=" + valor + "");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito.", "Mensaje", JOptionPane.DEFAULT_OPTION);

                //Retorna true en el caso de una eliminacion con exito
                resultado = true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "NO se logro eliminar el registro.", "Mensaje", JOptionPane.DEFAULT_OPTION);
            }
        } else {
            resultado = false;
        }
        return resultado;
    }
}
