/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.modelo;

import com.inventario.modelo.InvArticulo;
import com.referente.modelo.RefCliente;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "ven_detalle_venta", schema = "venta")
public class VenDetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_id")
    private Long id;

    @Column(name = "ven_cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "ven_precio_compra", nullable = false)
    private BigDecimal precioCompra;

    @Column(name = "ven_descuento", nullable = false)
    private BigDecimal descuento;

    @Column(name = "ven_precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "ven_precio_total", nullable = false)
    private BigDecimal precioTotal;

    @JoinColumn(name = "articulo", referencedColumnName = "art_id", nullable = false)
    @ManyToOne
    private InvArticulo articulo;

    @JoinColumn(name = "venta", referencedColumnName = "ven_id", nullable = false)
    @ManyToOne
    private VenVenta venta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public InvArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(InvArticulo articulo) {
        this.articulo = articulo;
    }

    public VenVenta getVenta() {
        return venta;
    }

    public void setVenta(VenVenta venta) {
        this.venta = venta;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

}
