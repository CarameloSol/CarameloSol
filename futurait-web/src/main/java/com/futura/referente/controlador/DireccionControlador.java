/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.referente.controlador;

import com.futura.inventario.controlador.*;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.inventario.variables.ArticuloAD;
import com.futura.referente.variables.ClienteAD;
import com.futura.referente.variables.ContactoAD;
import com.futura.referente.variables.DireccionAD;
import com.futurait.controladorAcceso.BaseControlador;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvCategoria;
import com.inventario.servicio.IArticuloServicio;
import com.inventario.servicio.ICategoriaServicio;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefContacto;
import com.referente.modelo.RefDireccion;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IContactoServicio;
import com.referente.servicio.IDireccionServicio;
import com.referente.servicio.IReferenteServicio;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Named(value = "direccionControlador")
@ViewScoped
public class DireccionControlador extends BaseControlador implements Serializable {

    @Inject
    DireccionAD direccionAD;
    @EJB
    IDireccionServicio direccionServicio;
    @EJB
    IReferenteServicio referenteServicio;

    public void inicio() {
        direccionAD.setListaDirecciones(direccionServicio.buscar(new RefDireccion()));
        direccionAD.setListaReferente(referenteServicio.buscar(new RefReferente()));
    }

    public void limpiarBusqueda() {
        direccionAD.setDireccionBusqueda(new RefDireccion());
        buscar();

    }

    public void buscar() {

        direccionAD.setListaDirecciones(direccionServicio.busquedaPorFiltros(direccionAD.getDireccionBusqueda()));
    }

    public void nuevo() {
        direccionAD.setDireccion(new RefDireccion());
        direccionAD.setIdReferente(null);
        direccionAD.getDireccion();

    }

    public void seleccionarDireccion(RefDireccion direccion) {
        direccionAD.setDireccion(direccion);
        direccionAD.setIdReferente(direccion.getReferente().getId());
        direccionAD.getDireccion();

    }

    public void guardar() {
        try {
            direccionAD.getDireccion().setId(1l);
           
            RefReferente referenteEncontrada = referenteServicio.obtenerPorId(direccionAD.getIdReferente());
            direccionAD.getDireccion().setReferente(referenteEncontrada);
            direccionServicio.guardar(direccionAD.getDireccion());

            direccionAD.setListaDirecciones(direccionServicio.buscar(new RefDireccion()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(RefDireccion direccion) {

        try {
            direccionServicio.eliminar(direccion);
            direccionAD.setListaDirecciones(direccionServicio.buscar(new RefDireccion()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    

    public DireccionAD getDireccionAD() {
        return direccionAD;
    }

    public void setDireccionAD(DireccionAD direccionAD) {
        this.direccionAD = direccionAD;
    }

}
