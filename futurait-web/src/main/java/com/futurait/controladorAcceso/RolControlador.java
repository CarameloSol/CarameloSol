/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futurait.controladorAcceso;

import com.acceso.modelo.AccRol;
import com.acceso.servicioImp.IRolServicio;
import com.futura.acceso.variables.AccesoAD;
import com.futura.acceso.variables.RolAD;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Ricardo
 */
@Named(value = "rolControlador")
@ViewScoped
public class RolControlador extends BaseControlador implements Serializable {

    @Inject
    RolAD rolAD;

    @EJB
    IRolServicio rolServicio;

    public void inicio() {
        validarAcceso();
        rolAD.setListaRoles(rolServicio.buscar(new AccRol()));

    }

    public RolAD getRolAD() {
        return rolAD;
    }

    public void setRolAD(RolAD rolAD) {
        this.rolAD = rolAD;
    }

}
