/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import conexion.AccesoMongoDB;
import conexion.AccesoMySQL;
import conexion.IAccesoBD;

/**
 *
 * @author Angelo
 */
public class FactoryDB {
    
    static FactoryDB factorydb;
    
    static{
       factorydb = new FactoryDB(); 
    }
    
    public static FactoryDB getInstance(){
        return factorydb;
    }
    
    
    public static IAccesoBD getAccesoBD(String bd){
        
        switch(bd){
            case "MySQL":
                return new AccesoMySQL();
            case "MongoDB":
                return new AccesoMongoDB();
            default:
                throw new RuntimeException("Unsupported db type");
        }
    }
}
