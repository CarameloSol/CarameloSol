/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.venta.variables;

import com.inventario.modelo.InvArticulo;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefReferente;
import com.venta.modelo.VenDetalleVenta;
import com.venta.modelo.VenVenta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "ventaAD")
@ViewScoped
public class VentaAD implements Serializable {

    VenVenta venta = new VenVenta();
    List<InvArticulo> listaArticulos = new ArrayList<>();
    List<VenDetalleVenta> listaDetalleVentaCreacion = new ArrayList<>();

    public VenVenta getVenta() {
        return venta;
    }

    public void setVenta(VenVenta venta) {
        this.venta = venta;
    }

    public List<InvArticulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<InvArticulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public List<VenDetalleVenta> getListaDetalleVentaCreacion() {
        return listaDetalleVentaCreacion;
    }

    public void setListaDetalleVentaCreacion(List<VenDetalleVenta> listaDetalleVentaCreacion) {
        this.listaDetalleVentaCreacion = listaDetalleVentaCreacion;
    }

}
