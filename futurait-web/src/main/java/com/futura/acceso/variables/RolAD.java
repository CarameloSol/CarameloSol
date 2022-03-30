/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.acceso.variables;

import com.acceso.modelo.AccRol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "rolAD")
@ViewScoped
public class RolAD implements Serializable {

    List<AccRol> listaRoles = new ArrayList<>();
    AccRol rol = new AccRol();
    AccRol rolBusqueda = new AccRol();

    public List<AccRol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<AccRol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public AccRol getRol() {
        return rol;
    }

    public void setRol(AccRol rol) {
        this.rol = rol;
    }

    public AccRol getRolBusqueda() {
        return rolBusqueda;
    }

    public void setRolBusqueda(AccRol rolBusqueda) {
        this.rolBusqueda = rolBusqueda;
    }

}
