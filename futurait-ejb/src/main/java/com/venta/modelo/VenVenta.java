/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.modelo;

import com.referente.modelo.RefCliente;
import com.referente.modelo.RefReferente;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "ven_venta", schema = "venta")
public class VenVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ven_id")
    private Long id;

    @Column(name = "ven_fecha", nullable = false)
    private Date fecha;

    @Column(name = "ven_numero_documento", nullable = false)
    private String numeroDocumento;

    @Column(name = "ven_subtotal", nullable = false)
    private BigDecimal subTotal;

    @Column(name = "ven_total", nullable = false)
    private BigDecimal total;

    @Column(name = "ven_descuento", nullable = false)
    private BigDecimal descuento;

    @Column(name = "ven_observacion", nullable = true)
    private String observacion;

    @JoinColumn(name = "cliente", referencedColumnName = "cli_id" , nullable = false)
    @ManyToOne
    private RefCliente cliente;

    @Column(name = "empresa")
    private Long empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public RefCliente getCliente() {
        return cliente;
    }

    public void setCliente(RefCliente cliente) {
        this.cliente = cliente;
    }

}
