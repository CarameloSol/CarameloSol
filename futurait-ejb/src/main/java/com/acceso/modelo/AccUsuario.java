/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.modelo;

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
import javax.persistence.Transient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "acc_usuario", schema = "acceso")
public class AccUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_clave", nullable = false)
    private String clave;

    @Column(name = "usu_nombre", nullable = false)
    private String nombre;

    @Column(name = "empresa", nullable = false)
    private Long empresa;

    @JoinColumn(name = "rol", referencedColumnName = "rol_id")
    @ManyToOne
    private AccRol rol;

    @Transient
    private String validacionNombre;

    @Transient
    private String validacionClave;

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public AccUsuario(Long id) {
        this.id = id;
    }

    public AccUsuario() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValidacionNombre() {
        return validacionNombre;
    }

    public void setValidacionNombre(String validacionNombre) {
        this.validacionNombre = validacionNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccUsuario)) {
            return false;
        }
        AccUsuario other = (AccUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acceso.modelo.Usuario[ id=" + id + " ]";
    }

    public String getValidacionClave() {
        return validacionClave;
    }

    public void setValidacionClave(String validacionClave) {
        this.validacionClave = validacionClave;
    }

    public AccRol getRol() {
        return rol;
    }

    public void setRol(AccRol rol) {
        this.rol = rol;
    }

}
