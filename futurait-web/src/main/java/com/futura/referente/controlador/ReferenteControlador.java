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
import com.futura.referente.variables.ProveedorAD;
import com.futura.referente.variables.ReferenteAD;
import com.futurait.controladorAcceso.BaseControlador;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvCategoria;
import com.inventario.servicio.IArticuloServicio;
import com.inventario.servicio.ICategoriaServicio;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefContacto;
import com.referente.modelo.RefDireccion;
import com.referente.modelo.RefProveedor;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IContactoServicio;
import com.referente.servicio.IDireccionServicio;
import com.referente.servicio.IProveedorServicio;
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
@Named(value = "referenteControlador")
@ViewScoped
public class ReferenteControlador extends BaseControlador implements Serializable {

    @Inject
    ReferenteAD referenteAD;
    @EJB
    IReferenteServicio referenteServicio;
    

    public void inicio() {
        referenteAD.setListaReferentes(referenteServicio.buscar(new RefReferente()));
        
    }

    public void limpiarBusqueda() {
        referenteAD.setReferenteBusqueda(new RefReferente());
        buscar();

    }

    public void buscar() {

        referenteAD.setListaReferentes(referenteServicio.busquedaPorFiltros(referenteAD.getReferenteBusqueda()));
    }

    public void nuevo() {
        referenteAD.setReferente(new RefReferente());
        
        referenteAD.getReferente();

    }

    public void seleccionarReferente(RefReferente referente) {
        referenteAD.setReferente(referente);
        
        referenteAD.getReferente();

    }

    public void guardar() {
        try {
            referenteAD.getReferente().setId(1l);
            
            referenteServicio.guardar(referenteAD.getReferente());

            referenteAD.setListaReferentes(referenteServicio.buscar(new RefReferente()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(RefReferente referente) {

        try {
            referenteServicio.eliminar(referente);
            referenteAD.setListaReferentes(referenteServicio.buscar(new RefReferente()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    

    public ReferenteAD getReferenteAD() {
        return referenteAD;
    }

    public void setReferenteAD(ReferenteAD referenteAD) {
        this.referenteAD = referenteAD;
    }

}
