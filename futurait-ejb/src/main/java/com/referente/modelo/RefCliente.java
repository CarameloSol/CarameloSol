/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.modelo;


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
@Table(name = "ref_cliente", schema = "referente")
public class RefCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cli_id")
    private Long id;

    @Column(name = "cli_estado", nullable = false)
    private Boolean estado;

    @JoinColumn(name = "referente", referencedColumnName = "ref_id")
    @ManyToOne
    private RefReferente referente;

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

    public RefReferente getReferente() {
        return referente;
    }

    public void setReferente(RefReferente referente) {
        this.referente = referente;
    }

   

}
