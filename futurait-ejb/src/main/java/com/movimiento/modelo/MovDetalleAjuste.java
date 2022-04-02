/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.modelo;

import com.inventario.modelo.InvArticulo;
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
@Table(name = "mov_detalle_ajuste", schema = "movimiento")
public class MovDetalleAjuste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_id")
    private Long id;

    @JoinColumn(name = "articulo", referencedColumnName = "art_id")
    @ManyToOne
    private InvArticulo articulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(InvArticulo articulo) {
        this.articulo = articulo;
    }
    
}
