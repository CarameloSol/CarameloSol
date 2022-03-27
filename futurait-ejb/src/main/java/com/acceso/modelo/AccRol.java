/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "acc_rol", schema = "acceso")
public class AccRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Long id;

    @Column(name = "rol_nombre", nullable = false)
    private String nombre;

    @Column(name = "rol_descripcion", nullable = false)
    private String descripcion;

    @Column(name = "empresa", nullable = false)
    private Long empresa;

    @OneToMany(mappedBy = "rol")
    private List<AccUsuario> listaUsuarios;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public List<AccUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<AccUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
