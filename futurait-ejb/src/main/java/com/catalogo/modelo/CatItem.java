/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.modelo;

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
@Table(name = "cat_item", schema = "catalogo")
public class CatItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ite_id")
    private Long id;

    @Column(name = "ite_estado", nullable = false)
    private Boolean estado;

    @Column(name = "ite_nombre", nullable = false)
    private String nombre;
    
    @Column(name = "ite_codigo", nullable = false)
    private String codigo;
    
    @JoinColumn(name = "catalogo", referencedColumnName = "cat_id")
    @ManyToOne
    private CatCatalogo catalogo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public CatCatalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(CatCatalogo catalogo) {
        this.catalogo = catalogo;
    }

}
