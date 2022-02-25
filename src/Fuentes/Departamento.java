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
public class Departamento {

    //Atributos
    private int depCodigo;
    private int CT_Codigo;
    private String depNombre;
    private float depPresuAnual;

    public Departamento(int depCodigo, int CT_Codigo, String depNombre, float depPresuAnual) {
        this.depCodigo = depCodigo;
        this.CT_Codigo = CT_Codigo;
        this.depNombre = depNombre;
        this.depPresuAnual = depPresuAnual;
    }

    public int getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(int depCodigo) {
        this.depCodigo = depCodigo;
    }

    public int getCT_Codigo() {
        return CT_Codigo;
    }

    public void setCT_Codigo(int CT_Codigo) {
        this.CT_Codigo = CT_Codigo;
    }

    public String getDepNombre() {
        return depNombre;
    }

    public void setDepNombre(String depNombre) {
        this.depNombre = depNombre;
    }

    public float getDepPresuAnual() {
        return depPresuAnual;
    }

    public void setDepPresuAnual(float depPresuAnual) {
        this.depPresuAnual = depPresuAnual;
    }

    public boolean guardarDepartamento(Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String querry = "INSERT INTO departamento "
                        + "values (" + this.depCodigo + "," + this.CT_Codigo + ",'" + this.depNombre + "',"
                        + this.depPresuAnual + ")";

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

    public boolean modificarDepartamento(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea modificar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Envia tipos de sentencias sql y tambien trabaja con parametros
                PreparedStatement pps = cn.prepareStatement("UPDATE departamento SET "
                        + "DEP_CODIGO=" + this.depCodigo + ","
                        + "CT_CODIGO=" + this.CT_Codigo + ","
                        + "DEP_NOMBRE='" + this.depNombre + "',"
                        + "DEP_PERSUPANUAL=" + this.depPresuAnual + " "
                        + "WHERE DEP_CODIGO = " + valor);
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

    public static boolean eliminarDepartamento(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Eliminando el registro solicitado
                PreparedStatement pps = cn.prepareStatement("DELETE FROM departamento WHERE DEP_CODIGO=" + valor);
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
