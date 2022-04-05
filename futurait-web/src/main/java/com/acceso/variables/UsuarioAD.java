/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.variables;

import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "usuarioAD")
@ViewScoped
public class UsuarioAD implements Serializable {

    List<AccUsuario> listaUsuarios = new ArrayList<>();
    List<AccRol> listaRoles = new ArrayList<>();
    AccUsuario usuario = new AccUsuario();
    AccUsuario usuarioBusqueda = new AccUsuario();
    Long idRol = null;

    public List<AccUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<AccUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * Creates a new instance of usuarioAD
     */
    public UsuarioAD() {
    }

    public AccUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(AccUsuario usuario) {
        this.usuario = usuario;
    }

    public List<AccRol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<AccRol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public AccUsuario getUsuarioBusqueda() {
        return usuarioBusqueda;
    }

    public void setUsuarioBusqueda(AccUsuario usuarioBusqueda) {
        this.usuarioBusqueda = usuarioBusqueda;
    }

}
