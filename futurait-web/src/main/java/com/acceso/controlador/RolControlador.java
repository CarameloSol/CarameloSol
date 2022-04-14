/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.controlador;

import com.acceso.modelo.AccRol;
import com.acceso.servicio.IRolServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.acceso.variables.RolAD;
import com.google.gson.Gson;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

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
        if (validarAcceso()) {
            rolAD.setListaRoles(rolServicio.buscar(new AccRol()));
        }

    }

    public void nuevo() {
        rolAD.setRol(new AccRol());
        rolAD.getRol().setEstado(Boolean.TRUE);
        rolAD.getRol().setEmpresa(1l);
    }

    public void seleccionarRol(AccRol rol) {
        rolAD.setRol(rol);
        rolAD.getRol();
    }

    public void limpiarBusqueda() {
        rolAD.setRolBusqueda(new AccRol());
        buscar();

    }

    public void buscar() {
        rolAD.setListaRoles(rolServicio.busquedaPorFiltros(rolAD.getRolBusqueda()));
    }

    public void guardar() {
        try {
            Gson gson = new Gson();
            String JSON = gson.toJson(rolAD.getRol());

            AccRol cat = gson.fromJson(JSON, AccRol.class);
            rolAD.getRol().setEmpresa(1L);
            rolServicio.guardar(rolAD.getRol());
            rolAD.setListaRoles(rolServicio.buscar(new AccRol()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");
            PrimeFaces.current().executeScript("PF('dlgRol').hide();");
        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(AccRol rol) {

        try {
            rolServicio.eliminar(rol);
            rolAD.setListaRoles(rolServicio.buscar(new AccRol()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public RolAD getRolAD() {
        return rolAD;
    }

    public void setRolAD(RolAD rolAD) {
        this.rolAD = rolAD;
    }

}
