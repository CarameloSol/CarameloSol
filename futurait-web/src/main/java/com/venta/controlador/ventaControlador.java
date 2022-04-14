/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.controlador;

import com.acceso.controlador.BaseControlador;
import com.enumerador.TipoBusquedaVentasEnum;
import com.venta.variables.VentaAD;
import com.inventario.modelo.InvArticulo;
import com.inventario.servicio.IArticuloServicio;
import com.venta.modelo.VenDetalleVenta;
import com.venta.modelo.VenVenta;
import com.venta.servicio.IVentaServicio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

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

    public void buscarProductos() {
        ventaAD.setListaArticulos(articuloServicio.busquedaFiltroVentas(ventaAD.getCampoBusquedaProductos(), ventaAD.getTipoBusqueda()));
    }

    public void modificarCantidadArticulo(VenDetalleVenta detalleVenta) {
        if (detalleVenta.getCantidad() == null) {
            detalleVenta.setCantidad(BigDecimal.ZERO);
        }
        if (detalleVenta.getPrecioUnitario() == null) {
            detalleVenta.setPrecioUnitario(BigDecimal.ZERO);
        }
        if (BigDecimal.ZERO.compareTo(detalleVenta.getCantidad()) == 1) {
            ventaAD.getListaDetalleVentaCreacion().remove(detalleVenta);
            return;
        }
        detalleVenta.setPrecioTotal(detalleVenta.getCantidad().multiply(detalleVenta.getPrecioUnitario()));
        calcularTotales();

    }

    public void seleccionarProductoVenta(InvArticulo articulo) {

        VenDetalleVenta detalleVenta = new VenDetalleVenta();
        detalleVenta.setArticulo(articulo);
        detalleVenta.setCantidad(BigDecimal.ONE);
        detalleVenta.setPrecioUnitario(articulo.getPrecio());
        detalleVenta.setPrecioTotal(detalleVenta.getCantidad().multiply(detalleVenta.getPrecioUnitario()));

        if (ventaAD.getListaDetalleVentaCreacion().isEmpty()) {
            ventaAD.getListaDetalleVentaCreacion().add(0, detalleVenta);
        } else {

            Optional<VenDetalleVenta> resultado = ventaAD.getListaDetalleVentaCreacion().stream().
                    filter(obj -> Objects.equals(obj.getArticulo().getId(), articulo.getId())).findFirst();
            if (resultado.isPresent()) {
                resultado.get().setCantidad(resultado.get().getCantidad().add(BigDecimal.ONE));
                resultado.get().setPrecioTotal(resultado.get().getCantidad().multiply(resultado.get().getPrecioUnitario()));
            } else {
                ventaAD.getListaDetalleVentaCreacion().add(0, detalleVenta);
            }
        }
        calcularTotales();
    }

    private void calcularTotales() {
        ventaAD.setSubTotal(BigDecimal.ZERO);
        ventaAD.getListaDetalleVentaCreacion().stream().forEach(obj -> {
            ventaAD.getListaDetalleVentaCreacion();
            ventaAD.setSubTotal(ventaAD.getSubTotal().add(obj.getPrecioTotal()));
        });
        PrimeFaces.current().ajax().update("form:totales");

    }

    public void eliminarProductoVenta(VenDetalleVenta detalleVenta) {
        ventaAD.getListaDetalleVentaCreacion().remove(detalleVenta);
        calcularTotales();
    }

    public void seleccionarVenta(VenVenta venta) {

    }

}
