/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.FactoryDB;
import design.IProductorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Productor;
import modelo.Resultado;

/**
 *
 * @author Angelo
 */
public class MySQLProductorDAO implements IProductorDAO{
    
    Statement st=null;
    ResultSet rs=null;
    Connection cn ;

    public MySQLProductorDAO() {
        cn=FactoryDB.getInstance().getAccesoBD("MySQL").getConnection();
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

    @Override
    public List<Productor> obtenerProductoresSinProduccion() {
        
        List<Productor> productorList = new ArrayList<>();
        
        try{
            st=cn.createStatement();
            rs=st.executeQuery("CALL SP_productorSinProducir()");
            
            while(rs.next()){
                
                Productor productor=new Productor();
                productor.setId(rs.getInt("idProductor"));
                productor.setNombre(rs.getString("nombre"));
                productor.setApellido(rs.getString("apellido"));
                
                productorList.add(productor);
                
            }
            
        }
        catch(Exception e){
            e.getMessage();
        }
        
        
        
        return productorList;
    }

    @Override
    public List<Productor> obtenerProductoresSinNombreSinProduccion() {
        List<Productor> productorList = new ArrayList<>();
        
        try{
            st=cn.createStatement();
            rs=st.executeQuery("CALL SP_productorSinNombreSinProducir()");
            
            while(rs.next()){
                
                Productor productor=new Productor();
                productor.setId(rs.getInt("idProductor"));
                productor.setApellido(rs.getString("apellido"));
                
                productorList.add(productor);
                
            }
            
        }
        catch(Exception e){
            e.getMessage();
        }
        
        return productorList;

    }

    @Override
    public List<Productor> filtrarProductoresxRegionxCantidadBotellas(String region, int cantidad) {
        List<Productor> productorList = new ArrayList<>();
        
        try{
            st=cn.createStatement();
            rs=st.executeQuery("CALL SP_productorxregionxcantidad ('"+region+"',"+cantidad+")");
            
            while(rs.next()){
                
                Productor productor=new Productor();
                productor.setNombre(rs.getString("nombre"));
                productor.setApellido(rs.getString("apellido"));
                
                productorList.add(productor);
                
            }
            
        }
        catch(Exception e){
            e.getMessage();
        }
        
        return productorList;
    }

    @Override
    public List<Productor> productoresxNVinos(int cantidad) {
        List<Productor> productorList = new ArrayList<>();
        
        try{
            st=cn.createStatement();
            rs=st.executeQuery("CALL SP_productorsxNVinos("+cantidad+")");
            
            while(rs.next()){
                
                Productor productor=new Productor();
                productor.setNombre(rs.getString("nombre"));
                productor.setApellido(rs.getString("apellido"));
                
                productorList.add(productor);
                
            }
            
        }
        catch(Exception e){
            e.getMessage();
        }

        
        return productorList;
    }

    @Override
    public List<Productor> productoresxVinosSignificativos(int cantidad) {
        
        List<Productor> productorList = new ArrayList<>();
        
        try{
            st=cn.createStatement();
            rs=st.executeQuery("CALL SP_productorxVinoSignificativo("+cantidad+")");
            
            while(rs.next()){
                
                Productor productor=new Productor();
                productor.setNombre(rs.getString("nombre"));
                productor.setApellido(rs.getString("apellido"));
                productor.setCantidad(rs.getInt("cantidad"));
                productorList.add(productor);
                
            }
            
        }
        catch(Exception e){
            e.getMessage();
        }

        
        return productorList;
    }
    
    
}
