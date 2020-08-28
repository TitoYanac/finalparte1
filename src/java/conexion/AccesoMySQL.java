/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Angelo
 */
public class AccesoMySQL implements IAccesoBD{

    public AccesoMySQL() {
    }
    
    
    
    @Override
    public Connection getConnection() {
        Connection  cn = null;
        
        String url = "jdbc:mysql://localhost:3306/bdpracticads?useSSL=false";
        String user = "root";
        String pass = "root";
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url,user,pass);

            if(cn!=null){
                System.out.println("Connexion establecida");
            }else{
                System.out.println("No se establecio la conexion");
            }           
        }catch (Exception e){            
        }
        return cn; 
    }
    
    
    
    
    
    
    
}
