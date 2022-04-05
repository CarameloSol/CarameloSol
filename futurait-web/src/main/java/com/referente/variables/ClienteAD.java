/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.variables;

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
    RefReferente referente = new RefReferente();
    RefCliente clienteBusqueda = new RefCliente();
    List<RefReferente> listaReferente = new ArrayList<>();

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

 

    public RefReferente getReferente() {
        return referente;
    }

    public void setReferente(RefReferente referente) {
        this.referente = referente;
    }

}
