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
public class ReferenteAD implements Serializable {

    List<RefReferente> listaReferentes = new ArrayList<>();
    RefReferente referente = new RefReferente();
    RefReferente referenteBusqueda = new RefReferente();

    public List<RefReferente> getListaReferentes() {
        return listaReferentes;
    }

    public void setListaReferentes(List<RefReferente> listaReferentes) {
        this.listaReferentes = listaReferentes;
    }

    public RefReferente getReferente() {
        return referente;
    }

    public void setReferente(RefReferente referente) {
        this.referente = referente;
    }

    public RefReferente getReferenteBusqueda() {
        return referenteBusqueda;
    }

    public void setReferenteBusqueda(RefReferente referenteBusqueda) {
        this.referenteBusqueda = referenteBusqueda;
    }
    
}
