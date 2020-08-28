/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import modelo.Productor;
import modelo.Resultado;

/**
 *
 * @author Angelo
 */
public interface IProductorDAO {
    void crearProductor(Productor productor);
    
    Productor obtenerProductorxId(int id);
    
    List<Productor> obtenerProductores();
    
    Resultado eliminarProductor(int id);
    
    List<Productor> obtenerProductoresSinProduccion();
    
    List<Productor> obtenerProductoresSinNombreSinProduccion();
    
    List<Productor> filtrarProductoresxRegionxCantidadBotellas(String region, int cantidad);
    
    List<Productor> productoresxNVinos(int cantidad);
    
    List<Productor> productoresxVinosSignificativos(int cantidad);
}
