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
import com.futura.acceso.variables.UsuarioAD;
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
@Named(value = "usuarioControlador")
@ViewScoped
public class UsuarioControlador extends BaseControlador implements Serializable {
    
    @Inject
    UsuarioAD usuarioAD;
    @EJB
    IRolServicio rolServicio;
    
    public void inicio() {
        validarAcceso();
        usuarioAD.setListaUsuarios(usuarioServicio.buscar(new AccUsuario()));
        usuarioAD.setListaRoles(rolServicio.buscar(new AccRol()));
    }
    
    public void nuevo() {
        usuarioAD.setUsuario(new AccUsuario());
        usuarioAD.getUsuario().setValidacionNombre("");
        usuarioAD.getUsuario().setValidacionClave("");
    }
    
    public void seleccionarUsuario(AccUsuario usuario) {
        usuarioAD.setUsuario(usuario);
        usuarioAD.setIdRol(usuario.getRol().getId());
        usuarioAD.getUsuario().setValidacionNombre(usuario.getNombre());
        usuarioAD.getUsuario().setValidacionClave(usuario.getClave());
    }
    
    public void guardar() {
        try {
            usuarioAD.getUsuario().setEmpresa(1L);
            AccRol rolEncontrado = rolServicio.obtenerPorId(usuarioAD.getIdRol());
            usuarioAD.getUsuario().setRol(rolEncontrado);
            usuarioServicio.guardar(usuarioAD.getUsuario());
            usuarioAD.setListaUsuarios(usuarioServicio.buscar(new AccUsuario()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgUsuario').hide();");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");
        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }
    
    public void eliminar(AccUsuario usuario) {
        
        try {
            usuarioServicio.eliminar(usuario);
            usuarioAD.setListaUsuarios(usuarioServicio.buscar(new AccUsuario()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }
    
    public UsuarioAD getUsuarioAD() {
        return usuarioAD;
    }
    
    public void setUsuarioAD(UsuarioAD usuarioAD) {
        this.usuarioAD = usuarioAD;
    }
    
    public void cerrarCesion() {
        System.err.println("cerrar cesion");
        getSession().invalidate();
        PrimeFaces.current().executeScript("location.reload();");
    }
    
    public String redireccionarUrl(String urlDestino) {
        String urlFinal = urlBase()
                + urlDestino;
        return urlFinal;
    }
    
}
