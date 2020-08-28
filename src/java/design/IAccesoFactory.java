/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

/**
 *
 * @author Angelo
 */
public interface IAccesoFactory {
    
    public IVinoDAO getVinoService();
    
    public IProductorDAO getProductorService();
    
}
