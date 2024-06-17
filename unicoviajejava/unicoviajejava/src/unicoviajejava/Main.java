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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import unicoviajejava.CConexion.ConexionMySQL;



public class Main {
    
    public static void main(String[] args) {
        
        // Conectar a la base de datos
        Connection conn = ConexionMySQL.conectar();
        if (conn != null) 
      
        {
            try {
                // Consulta de ejemplo
                String sql = "SELECT * FROM tabla_unicoviajejava";
                try (PreparedStatement statement = conn.prepareStatement(sql); ResultSet result = statement.executeQuery()) {
                    // Procesar resultados
                    while (result.next()) {
                        
                        // Ejemplo: Obtener valor de una columna
                        String columna1 = result.getString("nombre_columna");
                        System.out.println("Valor de la columna: " + columna1);
                    }
                    // Cerrar recursos
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            }
        }
    }
}

   
    
    
    
    
    

