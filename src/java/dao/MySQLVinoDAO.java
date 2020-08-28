/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.FactoryDB;
import design.IVinoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Resultado;
import modelo.Vino;

/**
 *
 * @author Angelo
 */
public class MySQLVinoDAO implements IVinoDAO{
    
    Statement st=null;
    ResultSet rs=null;
    Connection cn ;

    public MySQLVinoDAO() {
        cn=FactoryDB.getInstance().getAccesoBD("MySQL").getConnection();
    }
    
    
    
    @Override
    public void crearVino(Vino vino) {
        
    }



    @Override
    public List<Vino> obtenerVinos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resultado eliminarVino(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vino obtenerVinoMayorProduccion() {
        Vino vino = new Vino();
        
        try{
            st=cn.createStatement();
            rs=st.executeQuery("CALL SP_vinoMayorProduccion()");
            
            while(rs.next()){
                vino.setId(rs.getInt("Vinos_idVino"));
                vino.setNombre(rs.getString("nombre"));
   
            }
            
        }
        catch(Exception e){
            e.getMessage();
        }
        

        return vino;
    }

    @Override
    public List<Vino> obtenerVinoxGradoOProductor(String grado, int idProductor) {
    
        List<Vino> vinoList = new ArrayList<Vino>();
        
        try{
            st=cn.createStatement();
            if(grado!=null || grado!=""){
                rs=st.executeQuery("CALL SP_vinoxGrado('"+grado+"')");
                
                while(rs.next()){
                    Vino vino = new Vino();
                    vino.setId(rs.getInt("idVino"));
                    
                    vinoList.add(vino);
   
                }
            }
            else if(idProductor>0){
                rs=st.executeQuery("CALL SP_vinoxProductor("+idProductor+")");
                while(rs.next()){
                    Vino vino = new Vino();
                    vino.setId(rs.getInt("Vinos_idVino"));
                    
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
