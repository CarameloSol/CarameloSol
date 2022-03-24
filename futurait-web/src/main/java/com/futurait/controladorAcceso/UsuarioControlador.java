/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futurait.controladorAcceso;

import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccUsuario;
import com.acceso.servicioImp.IUsuarioServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.acceso.variables.AccesoAD;
import com.futura.acceso.variables.UsuarioAD;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    
    public void inicio() {
        validarAcceso();
        usuarioAD.setListaUsuarios(usuarioServicio.buscar(new AccUsuario()));
        
    }
    
    public void nuevo() {
        usuarioAD.setUsuario(new AccUsuario());
    }
    
    public void seleccionarUsuario(AccUsuario usuario) {
        usuarioAD.setUsuario(usuario);
    }
    
    public void guardar() {
        try {
            usuarioServicio.guardar(accesoAD.getUsuario());
        } catch (RegistroNoGuardado ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
       
        try {
            usuarioServicio.eliminar(accesoAD.getUsuario());
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
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
