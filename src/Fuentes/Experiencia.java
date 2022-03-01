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
public class Experiencia {

    //Atributos
    private int empCedula;
    private int CT_Codigo;
    private int areaCod;

    public Experiencia(int empCedula, int CT_Codigo, int areaCod) {
        this.empCedula = empCedula;
        this.CT_Codigo = CT_Codigo;
        this.areaCod = areaCod;
    }

    public int getEmpCedula() {
        return empCedula;
    }

    public void setEmpCedula(int empCedula) {
        this.empCedula = empCedula;
    }

    public int getCT_Codigo() {
        return CT_Codigo;
    }

    public void setCT_Codigo(int CT_Codigo) {
        this.CT_Codigo = CT_Codigo;
    }

    public int getAreaCod() {
        return areaCod;
    }

    public void setAreaCod(int areaCod) {
        this.areaCod = areaCod;
    }

    public boolean guardarExperiencia(Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String querry = "set xact_abort on\n"
                        + "begin distributed transaction\n"
                        + "INSERT INTO vista_experiencia "
                        + "values (" + this.empCedula + "," + this.CT_Codigo + "," + this.areaCod + ")"
                        + "commit transaction";

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

    public boolean modificarExperiencia(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea modificar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Envia tipos de sentencias sql y tambien trabaja con parametros
                PreparedStatement pps = cn.prepareStatement("set xact_abort on\n"
                        + "begin distributed transaction\n"
                        + "UPDATE vista_experiencia SET "
                        + "AREA_COD=" + this.areaCod + " "
                        + "WHERE EMP_CEDULA = " + valor + "\n"
                        + "commit transaction");

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

    public static boolean eliminarExperiencia(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Eliminando el registro solicitado
                PreparedStatement pps = cn.prepareStatement("set xact_abort on\n"
                        + "begin distributed transaction\n"
                        + "DELETE FROM vista_experiencia WHERE EMP_CEDULA=" + valor + "\n"
                        + "commit transaction");

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
