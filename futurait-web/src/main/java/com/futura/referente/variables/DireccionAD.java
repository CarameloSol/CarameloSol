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
import com.referente.modelo.RefDireccion;
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
@Named(value = "direccionAD")
@ViewScoped
public class DireccionAD implements Serializable {

    List<RefDireccion> listaDirecciones = new ArrayList<>();
    RefDireccion direccion = new RefDireccion();
    RefDireccion direccionBusqueda = new RefDireccion();
    List<RefReferente> listaReferente = new ArrayList<>();
    Long idReferente = null;

    public List<RefDireccion> getListaDirecciones() {
        return listaDirecciones;
    }

    public void setListaDirecciones(List<RefDireccion> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }

    public RefDireccion getDireccion() {
        return direccion;
    }

    public void setDireccion(RefDireccion direccion) {
        this.direccion = direccion;
    }

    public RefDireccion getDireccionBusqueda() {
        return direccionBusqueda;
    }

    public void setDireccionBusqueda(RefDireccion direccionBusqueda) {
        this.direccionBusqueda = direccionBusqueda;
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
