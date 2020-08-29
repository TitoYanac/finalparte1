/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import Factory.IFactoryDAO;
import design.IAccesoFactory;
import design.IProductorDAO;
import design.IVinoDAO;
import java.awt.event.ActionEvent;
import vista.VistaEscritorio;

import java.awt.event.ActionListener;
import java.util.List;
import modelo.Productor;
import modelo.Vino;

/**
 *
 * @author Hp pavilion
 */
public class ControladorEscritorio implements ActionListener {
   private VistaEscritorio vista;        
    private IAccesoFactory acceso;
    private IProductorDAO modeloProductor;
    private IVinoDAO modeloVino;
    
    //private MySQLFactoryDAO factoryMYSQL =IFactoryDAO.getMySQLService() ;
    
       
    public ControladorEscritorio(VistaEscritorio vista,IAccesoFactory acceso ){
        this.vista = vista;
        this.acceso = acceso;
        modeloProductor = this.acceso.getProductorService();
        modeloVino = this.acceso.getVinoService();
        
        this.vista.btnbuscar1.addActionListener(this);
        this.vista.btnbuscar2.addActionListener(this);
        this.vista.btnbuscar3.addActionListener(this);
        this.vista.btnbuscar4.addActionListener(this);
        this.vista.btnbuscar5.addActionListener(this);
        this.vista.btnbuscar6.addActionListener(this);
        this.vista.btnbuscar7.addActionListener(this);
        this.vista.btnbuscar8.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Consultas");
        vista.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.btnbuscar1){
            List<Productor> resultado;
            Productor productor;
            String texto = "";            
            resultado = modeloProductor.filtrarProductoresxRegionxCantidadBotellas(vista.txtregion1.getText(),Integer.parseInt(vista.txtcantidad1.getText()));
            
            for (int i = 0; i < resultado.size(); i++) {
                productor = resultado.get(i);
                texto += productor.getNombre() + " " +  productor.getApellido() + " ,";
            }
            vista.txtresultado.setText(texto);
        }else
        if(e.getSource() == vista.btnbuscar2){
            List<Vino> resultado;
            Vino vino;
            String texto = "";
            String idProd = vista.txtproductor2.getText();
            int idProd2;
            if(idProd.equals("")){
                idProd2 = 0;
            }else{
                idProd2 = Integer.parseInt(vista.txtproductor2.getText());
            }            
            resultado = modeloVino.obtenerVinoxGradoOProductor(vista.txtgrado2.getText(),idProd2);
            
            for (int i = 0; i < resultado.size(); i++) {
                vino = resultado.get(i);
                texto += "ID Vino: " + vino.getId() + "\n";
            }
            vista.txtresultado.setText(texto);
        }else
        if(e.getSource() == vista.btnbuscar3){
            List<Productor> resultado;
            Productor productor;
            String texto = "";
            resultado = modeloProductor.obtenerProductoresSinProduccion();
            
            for (int i = 0; i < resultado.size(); i++) {
                productor = resultado.get(i);
                texto += "Numero: " + productor.getId() + ", Nombre:  " + productor.getNombre() + ", Apellido: " + productor.getApellido() + "\n";
            }
            vista.txtresultado.setText(texto);
        }else
        if(e.getSource() == vista.btnbuscar4){
            Vino vino;
            String texto = "";
            vino = modeloVino.obtenerVinoMayorProduccion();
            texto = "Vino más producido\nId : " + vino.getId() + ", Nombre : " + vino.getNombre();
            vista.txtresultado.setText(texto);
        }else
        if(e.getSource() == vista.btnbuscar5){
            List<Productor> resultado;
            Productor productor;
            String texto = "";
            resultado = modeloProductor.productoresxNVinos(Integer.parseInt(vista.txtcantidad5.getText()));
            
            for (int i = 0; i < resultado.size(); i++) {
                productor = resultado.get(i);
                texto += "Nombre: " + productor.getNombre() + ", Apellido: " +  productor.getApellido() + "\n";
            }
            vista.txtresultado.setText(texto);
        }else
        if(e.getSource() == vista.btnbuscar6){
            List<Productor> resultado;
            Productor productor;
            String texto = "";
            resultado = modeloProductor.productoresxVinosSignificativos(Integer.parseInt(vista.txtcantidad6.getText()));
            
            for (int i = 0; i < resultado.size(); i++) {
                productor = resultado.get(i);
                texto += "Nombre: " + productor.getNombre() + ", Vinos Significativos: " +  productor.getCantidad() + "\n";
            }
            vista.txtresultado.setText(texto);
        }
        else
        if(e.getSource() == vista.btnbuscar7){
            List<Productor> resultado;
            Productor productor;
            String texto = "";
            resultado = modeloProductor.productoresxVinosDeProductor(Integer.parseInt(vista.txtproductor7.getText()));

            for (int i = 0; i < resultado.size(); i++) {
                productor = resultado.get(i);
                texto += "ID Productor: " + productor.getId() +" - Nombre : "+productor.getNombre()+"\n";
            }
            vista.txtresultado.setText(texto);
        }
        else
        if(e.getSource() == vista.btnbuscar8){
            List<Productor> resultado;
            Productor productor;
            String texto = "";
            resultado = modeloProductor.obtenerProductoresSinNombreSinProduccion();
            
            for (int i = 0; i < resultado.size(); i++) {
                productor = resultado.get(i);
                texto += "ID Productor: " + productor.getId() + ", Apellido: " + productor.getApellido() + "\n";
            }
            vista.txtresultado.setText(texto);            
            
        }
    }
    
}
