/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angelo
 */
public class AccesoMongoDB implements IAccesoBD{
    
    DB BaseDatos;
    
    public AccesoMongoDB() {
            
    }
    
    
    @Override
    public Connection getConnection() {
                
        Connection  cn = null;

        try{
            MongoClient mongo = new MongoClient("localhost",27017);
            BaseDatos= mongo.getDB("PruebaDB");
            System.out.println("Connect to data base  mongo successfully");
        }catch (Exception ex){ 
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        return cn; 
    
    }

    public DB getBaseDatos() {
        return BaseDatos;
    }

    public void setBaseDatos(DB BaseDatos) {
        this.BaseDatos = BaseDatos;
    }
    
}
