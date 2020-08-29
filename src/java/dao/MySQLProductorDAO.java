/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.FactoryDB;
import design.IProductorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    PreparedStatement ps=null;
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
    
    
    /********************
        PREGUNTA 3
    *********************/
    
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
    
    
    /********************
        PREGUNTA 8
    *********************/
    @Override
    public List<Productor> obtenerProductoresSinNombreSinProduccion() {
        List<Productor> productorList = new ArrayList<>();
        
        try{
            st=cn.createStatement();
            rs=st.executeQuery("CALL SP_productorSinNombreSinProducir()");
            
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
    
    /********************
        PREGUNTA 1
    *********************/
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
    
    
     /********************
        PREGUNTA 5
    *********************/
    
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
                productor.setCantidad(rs.getInt("cantidad"));
                
                productorList.add(productor);
                
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
      
        List<Productor> productorList = new ArrayList<>();
        
        try{
            st=cn.createStatement();
            ResultSet rs1=null;
            rs=st.executeQuery("CALL SP_productorxVinoSignificativo("+cantidad+")");
            
            while(rs.next()){
                
                Productor productor=new Productor();
                productor.setId(rs.getInt("idProductor"));
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
    
    
    /********************
        PREGUNTA 7
    *********************/
    @Override
    public List<Productor> productoresxVinosDeProductor(int idProductor) {
      
        System.out.println("INGRESO FUNCION 7");
        List<Productor> productorList = new ArrayList<Productor>();
        
        try{
            //st=cn.createStatement();

            //rs=st.executeQuery("CALL SP_productoresxVinoDeProductor("+idProductor+")");
            
            
            ps = cn.prepareStatement("{CALL SP_productoresxVinoDeProductor(?)}");
            ps.setInt(1,idProductor);
            rs =ps.executeQuery();
            
            while(rs.next()){
                
                Productor productor=new Productor();
                productor.setId(rs.getInt("idProductor"));
                productor.setNombre(rs.getString("nombre"));
                productor.setApellido(rs.getString("apellido"));

                
                productorList.add(productor);
                
            }

            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        
        return productorList;
    
    }
    
    
}
