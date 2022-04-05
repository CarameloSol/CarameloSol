/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.venta.controlador;

import com.controladorAcceso.BaseControlador;
import com.futura.venta.variables.VentaAD;
import com.inventario.modelo.InvArticulo;
import com.inventario.servicio.IArticuloServicio;
import com.venta.modelo.VenDetalleVenta;
import com.venta.modelo.VenVenta;
import com.venta.servicio.IVentaServicio;
import java.io.Serializable;
import java.math.BigDecimal;
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

    @EJB
    IVentaServicio ventaServicio;

    public void inicio() {
        ventaAD.getListaDetalleVentaCreacion().clear();
        ventaAD.setListaArticulos(articuloServicio.buscar(new InvArticulo()));

    }

    public void seleccionarProductoVenta(InvArticulo articulo) {
        VenDetalleVenta detalleVenta = new VenDetalleVenta();
        detalleVenta.setArticulo(articulo);
        detalleVenta.setCantidad(BigDecimal.TEN);
        detalleVenta.setPrecioUnitario(BigDecimal.ONE);
        detalleVenta.setPrecioTotal(detalleVenta.getCantidad().multiply(detalleVenta.getPrecioUnitario()));

        ventaAD.getListaDetalleVentaCreacion().add(detalleVenta);
        System.err.println("id pro " + articulo.getId());
    }

    public void eliminarProductoVenta(VenDetalleVenta detalleVenta) {
        ventaAD.getListaDetalleVentaCreacion().remove(detalleVenta);
    }

    public void seleccionarVenta(VenVenta venta) {

    }

}
