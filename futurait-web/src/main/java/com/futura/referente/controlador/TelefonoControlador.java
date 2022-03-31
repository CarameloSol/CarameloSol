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
import com.futura.referente.variables.TelefonoAD;
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
import com.referente.modelo.RefTelefono;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IContactoServicio;
import com.referente.servicio.IDireccionServicio;
import com.referente.servicio.IProveedorServicio;
import com.referente.servicio.IReferenteServicio;
import com.referente.servicio.ITelefonoServicio;
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
@Named(value = "telefonoControlador")
@ViewScoped
public class TelefonoControlador extends BaseControlador implements Serializable {

    @Inject
    TelefonoAD telefonoAD;
    @EJB
    ITelefonoServicio telefonoServicio;
    @EJB
    IReferenteServicio referenteServicio;

    public void inicio() {
        telefonoAD.setListaTelefonos(telefonoServicio.buscar(new RefTelefono()));
        telefonoAD.setListaReferente(referenteServicio.buscar(new RefReferente()));
    }

    public void limpiarBusqueda() {
        telefonoAD.setTelefonoBusqueda(new RefTelefono());
        buscar();

    }

    public void buscar() {

        telefonoAD.setListaTelefonos(telefonoServicio.busquedaPorFiltros(telefonoAD.getTelefonoBusqueda()));
    }

    public void nuevo() {
        telefonoAD.setTelefono(new RefTelefono());
        telefonoAD.setIdReferente(null);
        telefonoAD.getTelefono();

    }

    public void seleccionarDireccion(RefTelefono telefono) {
        telefonoAD.setTelefono(telefono);
        telefonoAD.setIdReferente(telefono.getReferente().getId());
        telefonoAD.getTelefono();

    }

    public void guardar() {
        try {
            telefonoAD.getTelefono().setId(1l);
           
            RefReferente referenteEncontrada = referenteServicio.obtenerPorId(telefonoAD.getIdReferente());
            telefonoAD.getTelefono().setReferente(referenteEncontrada);
            telefonoServicio.guardar(telefonoAD.getTelefono());

            telefonoAD.setListaTelefonos(telefonoServicio.buscar(new RefTelefono()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(RefTelefono telefono) {

        try {
            telefonoServicio.eliminar(telefono);
            telefonoAD.setListaTelefonos(telefonoServicio.buscar(new RefTelefono()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    

    public TelefonoAD getTelefonoAD() {
        return telefonoAD;
    }

    public void setTelefonoAD(TelefonoAD telefonoAD) {
        this.telefonoAD = telefonoAD;
    }

}
