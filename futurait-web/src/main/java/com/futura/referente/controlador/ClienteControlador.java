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
import com.futurait.controladorAcceso.BaseControlador;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvCategoria;
import com.inventario.servicio.IArticuloServicio;
import com.inventario.servicio.ICategoriaServicio;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IClienteServicio;
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
@Named(value = "clienteControlador")
@ViewScoped
public class ClienteControlador extends BaseControlador implements Serializable {

    @Inject
    ClienteAD clienteAD;
    @EJB
    IClienteServicio clienteServicio;
    @EJB
    IReferenteServicio referenteServicio;

    public void inicio() {
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
        clienteAD.setIdReferente(null);
        clienteAD.getCliente();

    }

    public void seleccionarCliente(RefCliente cliente) {
        clienteAD.setCliente(cliente);
        clienteAD.setIdReferente(cliente.getReferente().getId());
        clienteAD.getCliente();

    }

    public void guardar() {
        try {
            clienteAD.getCliente().setId(1l);
           
            RefReferente referenteEncontrada = referenteServicio.obtenerPorId(clienteAD.getIdReferente());
            clienteAD.getCliente().setReferente(referenteEncontrada);
            clienteServicio.guardar(clienteAD.getCliente());

            clienteAD.setListaClientes(clienteServicio.buscar(new RefCliente()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");

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

    

    public ClienteAD getClienteAD() {
        return clienteAD;
    }

    public void setClienteAD(ClienteAD clienteAD) {
        this.clienteAD = clienteAD;
    }

}
