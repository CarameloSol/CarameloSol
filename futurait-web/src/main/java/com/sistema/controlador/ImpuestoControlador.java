/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controlador;

import com.acceso.controlador.BaseControlador;
   import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.sistema.modelo.SisImpuesto;
import com.sistema.servicio.IImpuestoServicio;
import com.sistema.variables.ImpuestoAD;
 import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Ricardo
 */
@Named(value = "impuestoControlador")
@ViewScoped
public class ImpuestoControlador extends BaseControlador implements Serializable {

    @Inject
    ImpuestoAD impuestoAD;

    @EJB
    IImpuestoServicio impuestoServicio;

    public void inicio() {
        validarAcceso();
        impuestoAD.setListaImpuestos(impuestoServicio.buscar(new SisImpuesto()));

    }

    public void nuevo() {
        impuestoAD.setImpuesto(new SisImpuesto());
        impuestoAD.getImpuesto().setEmpresa(1l);
        impuestoAD.getImpuesto().setEstado(Boolean.TRUE);
    }

    public void seleccionarImpuesto(SisImpuesto impuesto) {
        impuestoAD.setImpuesto(impuesto);
        impuestoAD.getImpuesto();
    }

    public void limpiarBusqueda() {
        impuestoAD.setImpuestoBusqueda(new SisImpuesto());
        buscar();

    }

    public void buscar() {
        impuestoAD.setListaImpuestos(impuestoServicio.busquedaPorFiltros(impuestoAD.getImpuestoBusqueda()));
    }

    public void guardar() {
        try {
            impuestoAD.getImpuesto().setEmpresa(1L);
            impuestoServicio.guardar(impuestoAD.getImpuesto());
            impuestoAD.setListaImpuestos(impuestoServicio.buscar(new SisImpuesto()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");
            PrimeFaces.current().executeScript("PF('dlgImpuesto').hide();");
        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(SisImpuesto impuesto) {

        try {
            impuestoServicio.eliminar(impuesto);
            impuestoAD.setListaImpuestos(impuestoServicio.buscar(new SisImpuesto()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public ImpuestoAD getImpuestoAD() {
        return impuestoAD;
    }

    public void setImpuestoAD(ImpuestoAD impuestoAD) {
        this.impuestoAD = impuestoAD;
    }

}
