/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.referente.variables;

import com.futura.inventario.variables.*;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvCategoria;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefReferente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "clienteAD")
@ViewScoped
public class ClienteAD implements Serializable {

    List<RefCliente> listaClientes = new ArrayList<>();
    RefCliente cliente = new RefCliente();
    RefCliente clienteBusqueda = new RefCliente();
    List<RefReferente> listaReferente = new ArrayList<>();
    Long idReferente = null;

    public List<RefCliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<RefCliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public RefCliente getCliente() {
        return cliente;
    }

    public void setCliente(RefCliente cliente) {
        this.cliente = cliente;
    }

    public RefCliente getClienteBusqueda() {
        return clienteBusqueda;
    }

    public void setClienteBusqueda(RefCliente clienteBusqueda) {
        this.clienteBusqueda = clienteBusqueda;
    }

    public List<RefReferente> getListaReferente() {
        return listaReferente;
    }

    public void setListaReferente(List<RefReferente> listaReferente) {
        this.listaReferente = listaReferente;
    }

    public Long getIdReferente() {
        return idReferente;
    }

    public void setIdReferente(Long idReferente) {
        this.idReferente = idReferente;
    }
   

}
