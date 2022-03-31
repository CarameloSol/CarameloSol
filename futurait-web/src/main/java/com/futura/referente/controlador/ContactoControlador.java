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
import com.futurait.controladorAcceso.BaseControlador;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvCategoria;
import com.inventario.servicio.IArticuloServicio;
import com.inventario.servicio.ICategoriaServicio;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefContacto;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IContactoServicio;
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
@Named(value = "contactoControlador")
@ViewScoped
public class ContactoControlador extends BaseControlador implements Serializable {

    @Inject
    ContactoAD contactoAD;
    @EJB
    IContactoServicio contactoServicio;
    @EJB
    IReferenteServicio referenteServicio;

    public void inicio() {
        contactoAD.setListaContactos(contactoServicio.buscar(new RefContacto()));
        contactoAD.setListaReferente(referenteServicio.buscar(new RefReferente()));
    }

    public void limpiarBusqueda() {
        contactoAD.setContactoBusqueda(new RefContacto());
        buscar();

    }

    public void buscar() {

        contactoAD.setListaContactos(contactoServicio.busquedaPorFiltros(contactoAD.getContactoBusqueda()));
    }

    public void nuevo() {
        contactoAD.setContacto(new RefContacto());
        contactoAD.setIdReferente(null);
        contactoAD.getContacto();

    }

    public void seleccionarContacto(RefContacto contacto) {
        contactoAD.setContacto(contacto);
        contactoAD.setIdReferente(contacto.getReferente().getId());
        contactoAD.getContacto();

    }

    public void guardar() {
        try {
            contactoAD.getContacto().setId(1l);
           
            RefReferente referenteEncontrada = referenteServicio.obtenerPorId(contactoAD.getIdReferente());
            contactoAD.getContacto().setReferente(referenteEncontrada);
            contactoServicio.guardar(contactoAD.getContacto());

            contactoAD.setListaContactos(contactoServicio.buscar(new RefContacto()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(RefContacto contacto) {

        try {
            contactoServicio.eliminar(contacto);
            contactoAD.setListaContactos(contactoServicio.buscar(new RefContacto()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    

    public ContactoAD getContactoAD() {
        return contactoAD;
    }

    public void setContactoAD(ContactoAD contactoAD) {
        this.contactoAD = contactoAD;
    }

}
