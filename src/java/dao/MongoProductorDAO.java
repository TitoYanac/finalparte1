/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.FactoryDB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import conexion.AccesoMongoDB;
import conexion.IAccesoBD;
import design.IProductorDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import modelo.Productor;
import modelo.Resultado;

/**
 *
 * @author Angelo
 */
public class MongoProductorDAO implements IProductorDAO{
    
    Connection cn ;
    AccesoMongoDB accesoMongoDB;
    DBCollection colecion;
    
    public MongoProductorDAO() {
        accesoMongoDB=(AccesoMongoDB)FactoryDB.getInstance().getAccesoBD("MongoDB");
        cn=accesoMongoDB.getConnection();
    }
    
    
    
    @Override
    public void crearProductor(Productor productor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productor obtenerProductorxId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Productor> obtenerProductores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resultado eliminarProductor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /********************
        PREGUNTA 3
    *********************/

    @Override
    public List<Productor> obtenerProductoresSinProduccion() {
            
        List<Productor> productorList = new ArrayList<Productor>();
        List<Productor> productorList1 = new ArrayList<Productor>();
        
        try{
            colecion = accesoMongoDB.getBaseDatos().getCollection("productores");
            DBCursor cursor;
            cursor=colecion.find();
            
            //query.put("nombre", new BasicDBObject("$gt",1));

            
            
            while(cursor.hasNext()){

               Productor productor=new Productor();
               productor.setId(Integer.parseInt(cursor.next().get("idProductor")+""));
               productor.setNombre(cursor.curr().get("nombre")+"");
               productor.setApellido(cursor.curr().get("apellido")+"");
               
               productorList1.add(productor);
            }
            
            
            colecion = accesoMongoDB.getBaseDatos().getCollection("produccion");
            
            for(int i=0;i<productorList1.size();i++){
                int id=productorList1.get(i).getId();
                BasicDBObject query = new BasicDBObject();
                query.put("Productores_idProductor", id);
                cursor=colecion.find(query);
                
                if(cursor.hasNext()!=true){

                    Productor productor=new Productor();
                    productor.setId(productorList1.get(i).getId());
                    productor.setNombre(productorList1.get(i).getNombre());
                    productor.setApellido(productorList1.get(i).getApellido());
                    
                    productorList.add(productor);
                 }
            }
             
        }
        catch(Exception e){
            e.getMessage();
        }
        
        
        
        return productorList;
    
    }
    
    
    /********************
        PREGUNTA 8
    *********************/
    @Override
    public List<Productor> obtenerProductoresSinNombreSinProduccion() {
        
        List<Productor> productorList = new ArrayList<>();
        List<Productor> productorList1 = new ArrayList<>();
        
        try{
            colecion = accesoMongoDB.getBaseDatos().getCollection("productores");
            DBCursor cursor;
            BasicDBObject query1 = new BasicDBObject();
            query1.put("nombre", null);
            cursor=colecion.find(query1);
            
            //query.put("nombre", new BasicDBObject("$gt",1));

            while(cursor.hasNext()){

               Productor productor=new Productor();
               productor.setId(Integer.parseInt(cursor.next().get("idProductor")+""));
               productor.setNombre(cursor.curr().get("nombre")+"");
               productor.setApellido(cursor.curr().get("apellido")+"");
               
               productorList1.add(productor);
            }
            
            
            colecion = accesoMongoDB.getBaseDatos().getCollection("produccion");
            
            for(int i=0;i<productorList1.size();i++){
                int id=productorList1.get(i).getId();
                BasicDBObject query = new BasicDBObject();
                query.put("Productores_idProductor", id);
                cursor=colecion.find(query);
                
                if(cursor.hasNext()!=true){

                    Productor productor=new Productor();
                    productor.setId(productorList1.get(i).getId());
                    productor.setNombre(productorList1.get(i).getNombre());
                    productor.setApellido(productorList1.get(i).getApellido());
                    
                    productorList.add(productor);
                 }
            }
             
        }
        catch(Exception e){
            e.getMessage();
        }
        
        
        
        return productorList;
    
    }
    
    /********************
        PREGUNTA 1
    *********************/
    @Override
    public List<Productor> filtrarProductoresxRegionxCantidadBotellas(String region, int cantidad) {
    
        List<Productor> productorList = new ArrayList<Productor>();
        List<Productor> productorList1 = new ArrayList<Productor>();
        
        try{
            colecion = accesoMongoDB.getBaseDatos().getCollection("produccion");
            DBCursor cursor;
            BasicDBObject query1 = new BasicDBObject();
            query1.put("cantidadBotellas", new BasicDBObject("$gt", cantidad));
            cursor=colecion.find(query1);
            
            //query.put("nombre", new BasicDBObject("$gt",1));

            while(cursor.hasNext()){

               Productor productor=new Productor();
               productor.setId(Integer.parseInt(cursor.next().get("Productores_idProductor")+""));
               
               productorList1.add(productor);
            }
            
            
            colecion = accesoMongoDB.getBaseDatos().getCollection("productores");
            
            for(int i=0;i<productorList1.size();i++){
                int id=productorList1.get(i).getId();
                BasicDBObject query = new BasicDBObject();
                query.put("idProductor", id);
                query.put("region", region);
                cursor=colecion.find(query);
                
                if(cursor.hasNext()){

                    Productor productor=new Productor();
                    productor.setId(Integer.parseInt(cursor.next().get("idProductor")+""));
                    productor.setNombre(cursor.curr().get("nombre")+"");
                    productor.setApellido(cursor.curr().get("apellido")+"");
                      
                    productorList.add(productor);
                 }
            }
             
        }
        catch(Exception e){
            e.getMessage();
        }
        
        
        
        return productorList;
    
    }
    
    
    /********************
        PREGUNTA 5
    *********************/
    
    @Override
    public List<Productor> productoresxNVinos(int cantidad) {
        
        List<Productor> productorList = new ArrayList<Productor>();
        List<Productor> productorList1 = new ArrayList<Productor>();
        
        try{
            colecion = accesoMongoDB.getBaseDatos().getCollection("productores");
            DBCursor cursor;

            cursor=colecion.find();
            while(cursor.hasNext()){
                
               Productor productor=new Productor();
               productor.setId(Integer.parseInt(cursor.next().get("idProductor")+""));
               productor.setNombre(cursor.curr().get("nombre")+"");
               productor.setApellido(cursor.curr().get("apellido")+"");
               
               productorList1.add(productor);
            }
            
            
            colecion = accesoMongoDB.getBaseDatos().getCollection("produccion");

            for(int i=0;i<productorList1.size();i++){
                int id=productorList1.get(i).getId();
                BasicDBObject query = new BasicDBObject();
                query.put("Productores_idProductor", id);
                long cantidadAux=colecion.count(query);

                
                
                if(cantidadAux>=cantidad){
                    Productor productor=new Productor();
                    productor.setId(productorList1.get(i).getId());
                    productor.setNombre(productorList1.get(i).getNombre());
                    productor.setApellido(productorList1.get(i).getApellido());
                    productor.setCantidad(Integer.parseInt(cantidadAux+""));
                    
                    productorList.add(productor);
                }
            }
             
        }
        catch(Exception e){
            e.getMessage();
        }
        
        
        
        return productorList;
    
    }
    
    /********************
        PREGUNTA 6
    *********************/
    @Override
    public List<Productor> productoresxVinosSignificativos(int cantidad) {
        
        List<Productor> productorList = new ArrayList<Productor>();
        List<Productor> productorList1 = new ArrayList<Productor>();
        
        try{
            colecion = accesoMongoDB.getBaseDatos().getCollection("productores");
            DBCursor cursor;
            //BasicDBObject query1 = new BasicDBObject();
            //query1.put("cantidadBotellas", new BasicDBObject("$gt", 10));
           // query1.put("Productores_idProductor", 2);
            //long as=colecion.count(query1);
            
            //query.put("nombre", new BasicDBObject("$gt",1));
            cursor=colecion.find();
            while(cursor.hasNext()){
                
               Productor productor=new Productor();
               productor.setId(Integer.parseInt(cursor.next().get("idProductor")+""));
               productor.setNombre(cursor.curr().get("nombre")+"");
               productor.setApellido(cursor.curr().get("apellido")+"");
               
               productorList1.add(productor);
            }
            
            
            colecion = accesoMongoDB.getBaseDatos().getCollection("produccion");

            for(int i=0;i<productorList1.size();i++){
                int id=productorList1.get(i).getId();
                BasicDBObject query = new BasicDBObject();
                query.put("cantidadBotellas", new BasicDBObject("$gt", cantidad));
                query.put("Productores_idProductor", id);
                long cantidadAux=colecion.count(query);

                
                
                if(cantidadAux>0){
                    Productor productor=new Productor();
                    productor.setId(productorList1.get(i).getId());
                    productor.setNombre(productorList1.get(i).getNombre());
                    productor.setApellido(productorList1.get(i).getApellido());
                    productor.setCantidad(Integer.parseInt(cantidadAux+""));
                    
                    productorList.add(productor);
                }
            }
             
        }
        catch(Exception e){
            e.getMessage();
        }
        
        
        
        return productorList;
        
        
    }
    
    
    /********************
        PREGUNTA 7
    *********************/
    @Override
    public List<Productor> productoresxVinosDeProductor(int idProductor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
