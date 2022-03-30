/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "inv_articulo", schema = "inventario")
public class InvArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "art_id")
    private Long id;

    @Column(name = "art_nombre", nullable = false)
    private String nombre;

    @Column(name = "art_codigo", nullable = false)
    private String codigo;

    @Column(name = "art_imagen")
    private byte[] imagen;

    @Column(name = "art_precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "art_stock", nullable = false)
    private BigDecimal stock;

    @Column(name = "empresa", nullable = false)
    private Long empresa;

    @Transient
    private String validacionNombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getValidacionNombre() {
        return validacionNombre;
    }

    public void setValidacionNombre(String validacionNombre) {
        this.validacionNombre = validacionNombre;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
