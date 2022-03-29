/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futurait.controladorAcceso;

import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccUsuario;
import com.acceso.servicio.IRolServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.acceso.variables.UsuarioAD;
import com.ultil.Utilitarios;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.shaded.commons.io.IOUtils;

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

    public void limpiarBusqueda() {
        usuarioAD.setUsuarioBusqueda(new AccUsuario());
        buscar();

    }

    public void buscar() {
        usuarioAD.setListaUsuarios(usuarioServicio.busquedaPorFiltros(usuarioAD.getUsuarioBusqueda()));
    }

    public void nuevo() {
        usuarioAD.setUsuario(new AccUsuario());
        usuarioAD.setIdRol(null);
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
            System.err.println("usuario cla " + usuarioAD.getUsuario().getClave().isEmpty());
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

    public void almacenarImagen(FileUploadEvent event) {

        try {
            usuarioAD.getUsuario().setImagen(IOUtils.toByteArray(event.getFile().getInputStream()));
        } catch (IOException e) {
            addErrorMessage(e.getMessage());
        }
    }

    public UsuarioAD getUsuarioAD() {
        return usuarioAD;
    }

    public void setUsuarioAD(UsuarioAD usuarioAD) {
        this.usuarioAD = usuarioAD;
    }

    public StreamedContent mostrarImagenTemporal(String base64) {
        try {
            base64 = base64.replaceAll("\n", "");
            InputStream is = new ByteArrayInputStream(Base64.getDecoder().decode(base64.getBytes()));
            return DefaultStreamedContent.builder().contentType("image/jpeg").name("image.jpg").stream(() -> is).build();
        } catch (Exception e) {
            return null;
        }

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
