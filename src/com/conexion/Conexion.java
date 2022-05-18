
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cooper
 */
public class Conexion {
    
    private Connection conn;
    
    String url = "jdbc:firebirdsql:localhost/3050:C:/Program Files (x86)/Common Files/Aspel/Sistemas Aspel/CAJA4.00/Datos/CAJA40.FDB?charSet=UTF8";
    String user = "SYSDBA";
    String pass = "masterkey";

    public Conexion(){
        try{
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            System.out.println("Registrando el Driver");
        }catch(ClassNotFoundException e){
            //System.out.println("No se registro el Driver " + e.getMessage());
        }
        
        try{
            conn = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Conexion exitosa");
        }catch(SQLException e){
            System.out.println("Error al conectar " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar " + e.getMessage());
        }
    }
    
    public Connection getConnection() throws SQLException{
        return conn;
    }
    
    
}
