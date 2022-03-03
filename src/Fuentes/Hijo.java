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
public class Hijo {

    //Atributos
    private int codigo;
    private int CT_Codigo;
    private int empCedula;
    private String nombre;
    private String fechaNac;

    public Hijo(int codigo, int CT_Codigo, int empCedula, String nombre, String fechaNac) {
        this.codigo = codigo;
        this.CT_Codigo = CT_Codigo;
        this.empCedula = empCedula;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCT_Codigo() {
        return CT_Codigo;
    }

    public void setCT_Codigo(int CT_Codigo) {
        this.CT_Codigo = CT_Codigo;
    }

    public int getEmpCedula() {
        return empCedula;
    }

    public void setEmpCedula(int empCedula) {
        this.empCedula = empCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public static boolean verificarNumCedula(String numCedula) {
        boolean resultado = false;
        try {
            int numAux = Integer.parseInt(numCedula);
            if (numCedula.length() == 10) {
                resultado = true;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese correctamente el número de cédula.", "Mensaje", JOptionPane.DEFAULT_OPTION);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese correctamente el número de cédula.", "Mensaje", JOptionPane.DEFAULT_OPTION);
        }
        return resultado;
    }

    public boolean guardarHijo(Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String querry = "set xact_abort on\n"
                        + "begin distributed transaction\n"
                        + "INSERT INTO vista_hijos "
                        + "values (" + this.codigo + "," + this.CT_Codigo + "," + this.empCedula + ",'"
                        + this.nombre + "','" + this.fechaNac + "') "
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

    public boolean modificarHijo(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea modificar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Envia tipos de sentencias sql y tambien trabaja con parametros
                PreparedStatement pps = cn.prepareStatement("set xact_abort on\n"
                        + "begin distributed transaction\n"
                        + "UPDATE vista_hijos SET "
                        + "EMP_CEDULA=" + this.empCedula + ","
                        + "HIJO_NOMBRE='" + this.nombre + "',"
                        + "HIJO_FECHANAC='" + this.fechaNac + "' "
                        + "WHERE HIJO_CODIGO = " + valor + "\n"
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

    public static boolean eliminarHijo(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Eliminando el registro solicitado
                PreparedStatement pps = cn.prepareStatement("set xact_abort on\n"
                        + "begin distributed transaction\n"
                        + "DELETE FROM vista_hijos WHERE HIJO_CODIGO=" + valor + "\n"
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
