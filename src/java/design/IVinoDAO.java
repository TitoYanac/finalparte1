/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import modelo.Resultado;
import modelo.Vino;

/**
 *
 * @author Angelo
 */
public interface IVinoDAO {
    void crearVino(Vino vino);
    
    List<Vino> obtenerVinos();
    
    Resultado eliminarVino(int id);
    
    Vino obtenerVinoMayorProduccion();
    
    List<Vino> obtenerVinoxGradoOProductor(String grado, int idProductor);
}
