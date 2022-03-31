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
import com.referente.modelo.RefProveedor;
import com.referente.modelo.RefReferente;
import com.referente.modelo.RefTelefono;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "proveedorAD")
@ViewScoped
public class TelefonoAD implements Serializable {

    List<RefTelefono> listaTelefonos = new ArrayList<>();
    RefTelefono telefono = new RefTelefono();
    RefTelefono telefonoBusqueda = new RefTelefono();
    List<RefReferente> listaReferente = new ArrayList<>();
    Long idReferente = null;

    public List<RefTelefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(List<RefTelefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    public RefTelefono getTelefono() {
        return telefono;
    }

    public void setTelefono(RefTelefono telefono) {
        this.telefono = telefono;
    }

    public RefTelefono getTelefonoBusqueda() {
        return telefonoBusqueda;
    }

    public void setTelefonoBusqueda(RefTelefono telefonoBusqueda) {
        this.telefonoBusqueda = telefonoBusqueda;
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
