/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.variables;

import com.sistema.modelo.SisImpuesto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "impuestoAD")
@ViewScoped
public class ImpuestoAD implements Serializable {

    List<SisImpuesto> listaImpuestos = new ArrayList<>();
    SisImpuesto impuesto = new SisImpuesto();
    SisImpuesto impuestoBusqueda = new SisImpuesto();

    public List<SisImpuesto> getListaImpuestos() {
        return listaImpuestos;
    }

    public void setListaImpuestos(List<SisImpuesto> listaImpuestos) {
        this.listaImpuestos = listaImpuestos;
    }

    public SisImpuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(SisImpuesto impuesto) {
        this.impuesto = impuesto;
    }

    public SisImpuesto getImpuestoBusqueda() {
        return impuestoBusqueda;
    }

    public void setImpuestoBusqueda(SisImpuesto impuestoBusqueda) {
        this.impuestoBusqueda = impuestoBusqueda;
    }

  

}
