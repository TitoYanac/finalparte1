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
import design.IVinoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import modelo.Resultado;
import modelo.Vino;

/**
 *
 * @author Angelo
 */
public class MongoVinoDAO  implements IVinoDAO{
    
    Connection cn ;
    AccesoMongoDB accesoMongoDB;
    DBCollection colecion;
    
    public MongoVinoDAO() {
        accesoMongoDB=(AccesoMongoDB)FactoryDB.getInstance().getAccesoBD("MongoDB");
        cn=accesoMongoDB.getConnection();
    }
    
    
    @Override
    public void crearVino(Vino vino) {
        
        
    }


    @Override
    public List<Vino> obtenerVinos() {
        List<Vino> lista=null;
        return lista;
    }

    @Override
    public Resultado eliminarVino(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /********************
        PREGUNTA 4
    *********************/
    @Override
    public Vino obtenerVinoMayorProduccion() {
        List<Vino> vinoList = new ArrayList<Vino>();
        List<Vino> vinoList1 = new ArrayList<Vino>();
        
        int cantidad=0;
        Vino vino=new Vino();
        
        try{
            colecion = accesoMongoDB.getBaseDatos().getCollection("vinos");
            DBCursor cursor;

            cursor=colecion.find();

            while(cursor.hasNext()){

               Vino vinoAux=new Vino();
               vinoAux.setId(Integer.parseInt(cursor.next().get("idVino")+""));
               vinoAux.setNombre(cursor.curr().get("nombre")+"");
               vinoAux.setGrado(cursor.curr().get("grado")+"");
               
               vinoList1.add(vinoAux);
            }
            
            
            colecion = accesoMongoDB.getBaseDatos().getCollection("produccion");
            
            for(int i=0;i<vinoList1.size();i++){
                int id=vinoList1.get(i).getId();
                BasicDBObject query = new BasicDBObject();
                query.put("Vinos_idVino", id);
                cursor=colecion.find(query);
                int cantidadAux=0;
                if(cursor.hasNext()){
                    int cantBotellas=Integer.parseInt(cursor.next().get("cantidadBotellas")+"");
                    cantidadAux=cantidadAux+cantBotellas;
                }
                
                if(cantidad<cantidadAux){
                    cantidad=cantidadAux;
                    vino.setId(vinoList1.get(i).getId());
                    vino.setNombre(vinoList1.get(i).getNombre());
                    vino.setGrado(vinoList1.get(i).getGrado());
                    vino.setCantidad(cantidad);
                }
            }
             
        }
        catch(Exception e){
            e.getMessage();
        }
        
        
        
        return vino;
    }
    
    /********************
        PREGUNTA 2
    *********************/
    @Override
    public List<Vino> obtenerVinoxGradoOProductor(String grado, int idProductor) {
        
        List<Vino> vinoList = new ArrayList<Vino>();
        List<Vino> vinoList1 = new ArrayList<Vino>();
        
        try{
            colecion = accesoMongoDB.getBaseDatos().getCollection("vinos");
            DBCursor cursor;
            BasicDBObject query1 = new BasicDBObject();
            query1.put("grado", new BasicDBObject("$gt", grado));
            cursor=colecion.find(query1);
            
            //query.put("nombre", new BasicDBObject("$gt",1));

            while(cursor.hasNext()){

               Vino vino=new Vino();
               vino.setId(Integer.parseInt(cursor.next().get("idVino")+""));
               vino.setNombre(cursor.curr().get("nombre")+"");
               vino.setGrado(cursor.curr().get("grado")+"");
               
               vinoList1.add(vino);
            }
            
            
            colecion = accesoMongoDB.getBaseDatos().getCollection("produccion");
            
            for(int i=0;i<vinoList1.size();i++){
                int id=vinoList1.get(i).getId();
                BasicDBObject query = new BasicDBObject();
                query.put("Vinos_idVino", id);
                query.put("Productores_idProductor", idProductor);
                cursor=colecion.find(query);
                
                if(cursor.hasNext()){

                    Vino vino=new Vino();
                    vino.setId(vinoList1.get(i).getId());
                    vino.setNombre(vinoList1.get(i).getNombre());
                    vino.setGrado(vinoList1.get(i).getGrado());
                    
                    vinoList.add(vino);
                 }
            }
             
        }
        catch(Exception e){
            e.getMessage();
        }
        
        
        
        return vinoList;
        
        
        
        
    }
    
}
