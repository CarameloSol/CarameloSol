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
public class ProveedorAD implements Serializable {

    List<RefProveedor> listaProveedores = new ArrayList<>();
    RefProveedor proveedor = new RefProveedor();
    RefProveedor proveedorBusqueda = new RefProveedor();
    List<RefReferente> listaReferente = new ArrayList<>();
    Long idReferente = null;

    public List<RefProveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<RefProveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public RefProveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(RefProveedor proveedor) {
        this.proveedor = proveedor;
    }

    public RefProveedor getProveedorBusqueda() {
        return proveedorBusqueda;
    }

    public void setProveedorBusqueda(RefProveedor proveedorBusqueda) {
        this.proveedorBusqueda = proveedorBusqueda;
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
