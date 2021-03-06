/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import dao.MongoProductorDAO;
import dao.MongoVinoDAO;
import design.IAccesoFactory;
import design.IProductorDAO;
import design.IVinoDAO;

/**
 *
 * @author Angelo
 */
public class MongoFactoryDAO implements IAccesoFactory{
    
    static MongoFactoryDAO mongofactorydb;
    
    static{
       mongofactorydb = new MongoFactoryDAO(); 
    }
    
    public static MongoFactoryDAO getInstance(){
        return mongofactorydb;
    }
    
    @Override
    public IVinoDAO getVinoService(){
        return new MongoVinoDAO();
    }
    
    @Override
    public IProductorDAO getProductorService(){
        return new MongoProductorDAO();
    }
    
}
