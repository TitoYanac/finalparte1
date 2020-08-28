/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import design.IVinoDAO;
import java.util.List;
import modelo.Resultado;
import modelo.Vino;

/**
 *
 * @author Angelo
 */
public class MongoVinoDAO  implements IVinoDAO{
    
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

    @Override
    public Vino obtenerVinoMayorProduccion() {
        Vino vino = null;
        return vino;
    }

    @Override
    public List<Vino> obtenerVinoxGradoOProductor(String grado, int idProductor) {
        List<Vino> lista=null;
        return lista;
    }
    
}
