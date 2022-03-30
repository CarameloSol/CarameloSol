/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.inventario.controlador;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.inventario.variables.ClasificacionAD;
import com.futurait.controladorAcceso.BaseControlador;
import com.inventario.modelo.InvClasificacion;
import com.inventario.servicio.IClasificacionServicio;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
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
        clasificacionAD.getClasificacion().setValidacionNombre("");
    }

    public void seleccionarClasificacion(InvClasificacion usuario) {
        clasificacionAD.setClasificacion(usuario);
        clasificacionAD.getClasificacion().setValidacionNombre(usuario.getNombre());
    }

    public void guardar() {
        try {
            clasificacionAD.getClasificacion().setEmpresa(1L);
            clasificacionServicio.guardar(clasificacionAD.getClasificacion());
            clasificacionAD.setListaClasificacion(clasificacionServicio.buscar(new InvClasificacion()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgClasificacion').hide();");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");
        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(InvClasificacion usuario) {

        try {
            clasificacionServicio.eliminar(usuario);
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

    public void setClasificacionAD(ClasificacionAD clasificacionAD) {
        this.clasificacionAD = clasificacionAD;
    }

    public IClasificacionServicio getClasificacionServicio() {
        return clasificacionServicio;
    }

    public void setClasificacionServicio(IClasificacionServicio clasificacionServicio) {
        this.clasificacionServicio = clasificacionServicio;
    }

  
}
