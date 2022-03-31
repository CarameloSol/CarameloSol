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
import com.referente.modelo.RefContacto;
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
@Named(value = "contactoAD")
@ViewScoped
public class ContactoAD implements Serializable {

    List<RefContacto> listaContactos = new ArrayList<>();
    RefContacto contacto = new RefContacto();
    RefContacto contactoBusqueda = new RefContacto();
    List<RefReferente> listaReferente = new ArrayList<>();
    Long idReferente = null;

    public List<RefContacto> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(List<RefContacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public RefContacto getContacto() {
        return contacto;
    }

    public void setContacto(RefContacto contacto) {
        this.contacto = contacto;
    }

    public RefContacto getContactoBusqueda() {
        return contactoBusqueda;
    }

    public void setContactoBusqueda(RefContacto contactoBusqueda) {
        this.contactoBusqueda = contactoBusqueda;
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
