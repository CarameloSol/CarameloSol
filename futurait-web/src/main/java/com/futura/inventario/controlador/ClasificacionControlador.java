/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.inventario.controlador;

import com.futurait.controladorAcceso.*;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.acceso.variables.UsuarioAD;
import com.futura.inventario.variables.ClasificacionAD;
import com.inventario.modelo.InvClasificacion;
import com.inventario.servicio.IClasificacionServicio;

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
@Named(value = "clasificacionControlador")
@ViewScoped
public class ClasificacionControlador extends BaseControlador implements Serializable {

    @Inject
    ClasificacionAD clasificacionAD;
    @EJB
    IClasificacionServicio clasificacionServicio;

    public void inicio() {
        validarAcceso();
        clasificacionAD.setListaClasificacion(clasificacionServicio.buscar(new InvClasificacion()));
       
    }

    public void limpiarBusqueda() {
        clasificacionAD.setClasificacionBusqueda(new InvClasificacion());
        buscar();

    }

    public void buscar() {
        clasificacionAD.setListaClasificacion(clasificacionServicio.busquedaPorFiltros(clasificacionAD.getClasificacionBusqueda()));
    }

    public void nuevo() {
        clasificacionAD.setClasificacion(new InvClasificacion());
        
    }

    public void seleccionarClasificacion(InvClasificacion clasificacion) {
        clasificacionAD.setClasificacion(clasificacion);
        
    }

    public void guardar() {
        try {
           
            clasificacionAD.getClasificacion().setNombre(String.valueOf(0));
            
          
            clasificacionServicio.guardar(clasificacionAD.getClasificacion());
            clasificacionAD.setListaClasificacion(clasificacionServicio.buscar(new InvClasificacion()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");
        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(InvClasificacion clasificacion) {

        try {
            clasificacionServicio.eliminar(clasificacion);
            clasificacionAD.setListaClasificacion(clasificacionServicio.buscar(new InvClasificacion()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void almacenarImagen(FileUploadEvent event) {

        try {
            clasificacionAD.getClasificacion().setImagen(IOUtils.toByteArray(event.getFile().getInputStream()));
        } catch (IOException e) {
            addErrorMessage(e.getMessage());
        }
    }

    public ClasificacionAD getClasificacionAD() {
        return clasificacionAD;
    }

    public void setUsuarioAD(UsuarioAD usuarioAD) {
        this.clasificacionAD = clasificacionAD;
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

    
}
