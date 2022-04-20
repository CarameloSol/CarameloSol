/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.modelo;

import com.sistema.modelo.SisImpuesto;
import java.io.Serializable;
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
@Table(name = "inv_impuesto_articulo", schema = "inventario")
public class InvImpuestoArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "imp_id")
    private Long id;

    @Column(name = "empresa", nullable = false)
    private Long empresa;

    @JoinColumn(name = "articulo", referencedColumnName = "art_id")
    @ManyToOne
    private InvArticulo articulo;
    
    @JoinColumn(name = "impuesto", referencedColumnName = "imp_id")
    @ManyToOne
    private SisImpuesto impuesto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public InvArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(InvArticulo articulo) {
        this.articulo = articulo;
    }

    public SisImpuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(SisImpuesto impuesto) {
        this.impuesto = impuesto;
    }

    
   }
