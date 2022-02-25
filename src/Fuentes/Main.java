package Fuentes;

import Interfaz.JFMenuPrincipal;

/**
 *
 * @author Grupo 4
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.getConexion(3);
        /*JFMenuPrincipal menu = new JFMenuPrincipal();
        menu.setVisible(true);*/
    }
    
}
