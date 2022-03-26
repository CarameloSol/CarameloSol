/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futurait.controladorAcceso;


import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccUsuario;
import com.acceso.servicioImp.IRolServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.acceso.variables.AccesoAD;
import com.futura.acceso.variables.RolAD;
import com.futura.acceso.variables.UsuarioAD;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.context.FacesContext;
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
        validarAcceso();
        rolAD.setListaRoles(rolServicio.buscar(new AccRol()));

    }

    public void nuevo(){
    rolAD.setRol(new AccRol());
    rolAD.getRol().setEmpresa(1l);
    }
    
    public void seleccionarRol(AccRol rol){
        rolAD.setRol(rol);
        rolAD.getRol();
    }
    
    public void guardar() {
        try {
            rolAD.getRol().setEmpresa(1L);
            rolServicio.guardar(rolAD.getRol());
            rolAD.setListaRoles(rolServicio.buscar(new AccRol()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgActualizarRol').hide();");
            PrimeFaces.current().ajax().update("form:pnlActualizarRol");
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
