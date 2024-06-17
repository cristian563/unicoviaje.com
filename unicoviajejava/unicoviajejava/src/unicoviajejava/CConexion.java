/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicoviajejava;

/**
 *
 * @author romer
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CConexion {

public class ConexionMySQL {
    // URL de la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/unicoviajejava";
    // Credenciales de acceso
    static final String USER = "root";
    static final String PASS = "27487660";

    public static Connection conectar() {
        Connection conn = null;
        
        try {
            // Establecer la conexión
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos.");
            
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conn;
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
