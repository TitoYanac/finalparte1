/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;

/**
 *
 * @author Angelo
 */
public class AccesoMongoDB implements IAccesoBD{

    public AccesoMongoDB() {
    }
    
    
    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
