/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Factory.IFactoryDAO;
import design.IAccesoFactory;
import vista.VistaEscritorio;

/**
 *
 * @author Hp pavilion
 */
public class EjecutarApEscritorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VistaEscritorio vista = new VistaEscritorio();
        IAccesoFactory acceso = IFactoryDAO.getAccesoFactory("MySQL");
        ControladorEscritorio controlador = new ControladorEscritorio(vista,acceso);
        controlador.iniciar();
        vista.setVisible(true);        
       
    }
    
}
