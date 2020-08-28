/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import design.IAccesoFactory;

/**
 *
 * @author Angelo
 */
public class IFactoryDAO {
    
    static IFactoryDAO ifactoryDAO;
    
    static{
       ifactoryDAO = new IFactoryDAO(); 
    }
    
    public static IFactoryDAO getInstance(){
        return ifactoryDAO;
    }
    
    public static IAccesoFactory getAccesoFactory(String tipo){
        switch(tipo){
            case "MySQL":
                return MySQLFactoryDAO.getInstance();
            case "Mongo":
                return MongoFactoryDAO.getInstance();
            default:
                throw new RuntimeException("Unsupported db type");
        }
        
    }
    
    
    public static MongoFactoryDAO getMongoService(){
        return MongoFactoryDAO.getInstance();
    }
    
    public static MySQLFactoryDAO getMySQLService(){
        return MySQLFactoryDAO.getInstance();
    }
}


/*
    IAccesoFactory accesoFactory = IFactoryDAO.getInstance().getAccesoFactory("MySQL");

    IProductorDAO productorDAO=accesoFactory.getProductorService();

    List<Productor> productorList=productorDAO.filtrarProductoresxRegionxCantidadBotellas(region, cantidad);


    pregunta 1 = productor - filtrarProductoresxRegionxCantidadBotellas(String region,int cantidad) ----> List<Productor>
    pregunta 2 = vino - obtenerVinoxGradoOProductor(String grado, int idProductor) ----> List<Vino>
    pregunta 3 = productor - obtenerProductoresSinProduccion ---> List<Productor>
    pregunta 4 =  vino - obtenerVinoMayorProduccion() ---> Vino
    pregunta 5 = productor - productoresxNVinos(int cantidad) ----> List<Productor>
    pregunta 6 = productor - productoresxVinosSignificativos(int cantidad) ----> List<Productor>
    pregunta 7 = 
    pregunta 8 = productor - obtenerProductoresSinNombreSinProduccion() ----> List<Productor>

*/