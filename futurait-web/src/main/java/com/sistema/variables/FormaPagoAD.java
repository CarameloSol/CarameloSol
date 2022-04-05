/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.variables;


import com.sistema.modelo.SisFormaPago;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "formaPagoAD")
@ViewScoped
public class FormaPagoAD implements Serializable {

    List<SisFormaPago> listaFormasPago = new ArrayList<>();
    SisFormaPago formaPago = new SisFormaPago();
    SisFormaPago formaPagoBusqueda = new SisFormaPago();

    public List<SisFormaPago> getListaFormasPago() {
        return listaFormasPago;
    }

    public void setListaFormasPago(List<SisFormaPago> listaFormasPago) {
        this.listaFormasPago = listaFormasPago;
    }

    public SisFormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(SisFormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public SisFormaPago getFormaPagoBusqueda() {
        return formaPagoBusqueda;
    }

    public void setFormaPagoBusqueda(SisFormaPago formaPagoBusqueda) {
        this.formaPagoBusqueda = formaPagoBusqueda;
    }

    

}
