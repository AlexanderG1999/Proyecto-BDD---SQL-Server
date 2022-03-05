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
 * @author GRUPO 4
 */
public class Empleado {

    //Atributos
    private int numCedula;
    private int CT_Codigo;
    private int depCodigo;
    private String nombre;
    private int numHijos;
    private int numTelefono;
    private float salario;
    private String fechaContrato;

    public Empleado(int numCedula, int CT_Codigo, int depCodigo, String nombre, int numHijos, int numTelefono, float salario, String fechaContrato) {
        this.numCedula = numCedula;
        this.CT_Codigo = CT_Codigo;
        this.depCodigo = depCodigo;
        this.nombre = nombre;
        this.numHijos = numHijos;
        this.numTelefono = numTelefono;
        this.salario = salario;
        this.fechaContrato = fechaContrato;
    }

    public int getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(int numCedula) {
        this.numCedula = numCedula;
    }

    public int getCT_Codigo() {
        return CT_Codigo;
    }

    public void setCT_Codigo(int CT_Codigo) {
        this.CT_Codigo = CT_Codigo;
    }

    public int getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(int depCodigo) {
        this.depCodigo = depCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
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

    public boolean guardarEmpleado(Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String querry1 = "set xact_abort on "
                        //+ "begin distributed transaction "
                        + "insert into vista_empleado values (" + this.numCedula + "," + this.CT_Codigo + "," + this.depCodigo
                        + ",'" + this.nombre + "'" + "," + this.numHijos + "," + this.numTelefono + ") ";
                //+ "commit transaction";

                String querry2 = "INSERT INTO [ALEXANDER].Proyecto_Sucursal_Quito.dbo.NOMINAS_EMPLEADOS "
                        + "values (" + this.numCedula + "," + this.salario + ",'" + this.fechaContrato + "')";

                //Ingresando datos a SQL Server
                Statement stmt = cn.createStatement();//Envia tipos de sentencias sql
                stmt.executeUpdate(querry1);//ejecuta la sentencia
                stmt.executeUpdate(querry2);//ejecuta la sentencia

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

    public boolean modificarEmpleado(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea modificar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Envia tipos de sentencias sql y tambien trabaja con parametros
                PreparedStatement pps1 = cn.prepareStatement("set xact_abort on\n"
                        //+ "begin distributed transaction\n"
                        + "UPDATE vista_empleado SET "
                        + "DEP_CODIGO=" + this.depCodigo + ","
                        + "EMP_NOMBRE='" + this.nombre + "',"
                        + "EMP_NUMHIJOS=" + this.numHijos + ","
                        + "EMP_TELEFONO=" + this.numTelefono + " "
                        + "WHERE EMP_CEDULA = " + valor);
                //+ "commit transaction");

                PreparedStatement pps2 = cn.prepareStatement("UPDATE [ALEXANDER].Proyecto_Sucursal_Quito.dbo.NOMINAS_EMPLEADOS SET "
                        + "EMP_SALARIO=" + this.salario + ","
                        + "EMP_FECHACONTRATO='" + this.fechaContrato + "' "
                        + "WHERE EMP_CEDULA = " + valor);

                pps1.executeUpdate();
                pps2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Actualizado.", "Mensaje", JOptionPane.DEFAULT_OPTION);
                resultado = true;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "NO se logro actualizar el registro.", "Mensaje", JOptionPane.DEFAULT_OPTION);
                System.out.println(ex);
            }
        } else {
            resultado = false;
        }

        return resultado;
    }

    public static boolean eliminarEmpleado(int valor, Connection cn) {
        boolean resultado = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Registro?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                //Eliminando el registro solicitado
                PreparedStatement pps1 = cn.prepareStatement("set xact_abort on\n"
                        //+ "begin distributed transaction\n"
                        + "DELETE FROM vista_empleado where EMP_CEDULA=" + valor);
                //+ "commit transaction");

                PreparedStatement pps2 = cn.prepareStatement("DELETE FROM [ALEXANDER].Proyecto_Sucursal_Quito.dbo.NOMINAS_EMPLEADOS "
                        + "where EMP_CEDULA=" + valor);

                pps1.executeUpdate();
                pps2.executeUpdate();
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
