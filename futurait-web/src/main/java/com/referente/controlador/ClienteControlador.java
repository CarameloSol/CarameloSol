/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.controlador;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.variables.ClienteAD;
import com.controladorAcceso.BaseControlador;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IPersonaServicio;
import com.referente.servicio.IReferenteServicio;
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
@Named(value = "clienteControlador")
@ViewScoped
public class ClienteControlador extends BaseControlador implements Serializable {

    @Inject
    ClienteAD clienteAD;
    @EJB
    IClienteServicio clienteServicio;
    @EJB
    IReferenteServicio referenteServicio;
    @EJB
    IPersonaServicio personaServicio;

    public void inicio() {
        clienteAD.setClienteBusqueda(new RefCliente());
        clienteAD.getClienteBusqueda().setReferente(new RefReferente());
        clienteAD.setListaClientes(clienteServicio.buscar(new RefCliente()));
        clienteAD.setListaReferente(referenteServicio.buscar(new RefReferente()));
    }

    public void limpiarBusqueda() {
        clienteAD.setClienteBusqueda(new RefCliente());
        buscar();

    }

    public void buscar() {
        clienteAD.setListaClientes(clienteServicio.busquedaPorFiltros(clienteAD.getClienteBusqueda()));
    }

    public void nuevo() {
        clienteAD.setCliente(new RefCliente());
        clienteAD.setReferente(new RefReferente());
        clienteAD.getCliente();

    }

    public void recuperarDatosPersona() {

        clienteAD.setReferente(referenteServicio.obtenerDatosReferente(clienteAD.getReferente()));

    }

    public void seleccionarCliente(RefCliente cliente) {
        clienteAD.setCliente(cliente);
        clienteAD.setReferente(cliente.getReferente());
        clienteAD.getCliente();

    }

    public void guardar() {
        try {
            clienteAD.getReferente().setEmpresa(1l);
            clienteAD.getReferente().setEstado(Boolean.TRUE);
            clienteAD.getCliente().setReferente(clienteAD.getReferente());
            clienteServicio.guardar(clienteAD.getCliente());
            clienteAD.setListaClientes(clienteServicio.buscar(new RefCliente()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgCliente').hide();");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(RefCliente cliente) {

        try {
            clienteServicio.eliminar(cliente);
            clienteAD.setListaClientes(clienteServicio.buscar(new RefCliente()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void almacenarImagen(FileUploadEvent event) {

        try {
            clienteAD.getCliente().setImagen(IOUtils.toByteArray(event.getFile().getInputStream()));
        } catch (IOException e) {
            addErrorMessage(e.getMessage());
        }
    }

    public ClienteAD getClienteAD() {
        return clienteAD;
    }

    public void setClienteAD(ClienteAD clienteAD) {
        this.clienteAD = clienteAD;
    }

}
