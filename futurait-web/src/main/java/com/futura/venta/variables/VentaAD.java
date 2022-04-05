/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.venta.variables;

import com.inventario.modelo.InvArticulo;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefReferente;
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

    List<VenVenta> listaventas = new ArrayList<>();
    VenVenta venta = new VenVenta();
    VenVenta ventaBusqueda = new VenVenta();
    List<InvArticulo> listaArticulos = new ArrayList<>();

    public List<VenVenta> getListaventas() {
        return listaventas;
    }

    public void setListaventas(List<VenVenta> listaventas) {
        this.listaventas = listaventas;
    }

    public VenVenta getVenta() {
        return venta;
    }

    public void setVenta(VenVenta venta) {
        this.venta = venta;
    }

    public VenVenta getVentaBusqueda() {
        return ventaBusqueda;
    }

    public void setVentaBusqueda(VenVenta ventaBusqueda) {
        this.ventaBusqueda = ventaBusqueda;
    }

    public List<InvArticulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<InvArticulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

   
}
