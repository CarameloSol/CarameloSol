/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.venta.controlador;

import com.futura.venta.variables.VentaAD;
import com.futurait.controladorAcceso.BaseControlador;
import com.inventario.servicio.IArticuloServicio;
import com.venta.modelo.VenVenta;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Ricardo
 */
@Named(value = "ventaControlador")
@ViewScoped
public class ventaControlador extends BaseControlador implements Serializable {

    @Inject
    VentaAD ventaAD;

    @EJB
    IArticuloServicio articuloServicio;

    public void inicio() {
      
        
    }
    
     public void seleccionarVenta(VenVenta venta) {
       
        

    }

}
