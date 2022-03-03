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
public class CentroDeTrabajo {

    //Atributos
    private int CT_Codigo;
    private int jefCedula;
    private String nombre;
    private int numPoblacion;
    private String direccion;

    public CentroDeTrabajo(int CT_Codigo, int jefCedula, String nombre, int numPoblacion, String direccion) {
        this.CT_Codigo = CT_Codigo;
        this.jefCedula = jefCedula;
        this.nombre = nombre;
        this.numPoblacion = numPoblacion;
        this.direccion = direccion;
    }

    public int getCT_Codigo() {
        return CT_Codigo;
    }

    public void setCT_Codigo(int CT_Codigo) {
        this.CT_Codigo = CT_Codigo;
    }

    public int getJefCedula() {
        return jefCedula;
    }

    public void setJefCedula(int jefCedula) {
        this.jefCedula = jefCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPoblacion() {
        return numPoblacion;
    }

    public void setNumPoblacion(int numPoblacion) {
        this.numPoblacion = numPoblacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean guardarCT(Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String querry = "INSERT INTO CENTRO_DE_TRABAJO "
                        + "values (" + this.CT_Codigo + "," + this.jefCedula + ",'" + this.nombre + "',"
                        + this.numPoblacion + ",'" + this.direccion + "')";

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

    public boolean modificarCT(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea modificar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Envia tipos de sentencias sql y tambien trabaja con parametros
                PreparedStatement pps = cn.prepareStatement("UPDATE CENTRO_DE_TRABAJO SET "
                        + "JEFE_CEDULA=" + this.jefCedula + ","
                        + "CT_NOMBRE='" + this.nombre + "',"
                        + "CT_POBLACION=" + this.numPoblacion + ","
                        + "CT_DIRECCION='" + this.direccion + "' "
                        + "WHERE CT_CODIGO = " + valor);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Actualizado.", "Mensaje", JOptionPane.DEFAULT_OPTION);
                resultado = true;

            } catch (SQLException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "NO se logro actualizar el registro.", "Mensaje", JOptionPane.DEFAULT_OPTION);
            }
        } else {
            resultado = false;
        }

        return resultado;
    }

    public static boolean eliminarCT(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Eliminando el registro solicitado
                PreparedStatement pps = cn.prepareStatement("DELETE FROM CENTRO_DE_TRABAJO WHERE CT_CODIGO=" + valor);
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
