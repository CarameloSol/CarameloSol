/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controlador;


 import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
 import com.acceso.controlador.BaseControlador;
import com.sistema.modelo.SisFormaPago;
import com.sistema.servicio.IFormaPagoServicio;
import com.sistema.variables.FormaPagoAD;
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
@Named(value = "formaPagoControlador")
@ViewScoped
public class FormaPagoControlador extends BaseControlador  implements Serializable {

    @Inject
    FormaPagoAD formaPagoAD;

    @EJB
    IFormaPagoServicio formaPagoServicio;

    public void inicio() {
        validarAcceso();
        formaPagoAD.setListaFormasPago(formaPagoServicio.buscar(new SisFormaPago()));

    }

    public void nuevo() {
        formaPagoAD.setFormaPago(new SisFormaPago());
       formaPagoAD.getFormaPago().setEstado(Boolean.TRUE);
        formaPagoAD.getFormaPago().setEmpresa(1l);
    }

    public void seleccionarFormaPago(SisFormaPago formaPago) {
        formaPagoAD.setFormaPago(formaPago);
        formaPagoAD.getFormaPago();
    }

    public void limpiarBusqueda() {
        formaPagoAD.setFormaPagoBusqueda(new SisFormaPago());
        buscar();

    }

    public void buscar() {
        formaPagoAD.setListaFormasPago(formaPagoServicio.busquedaPorFiltros(formaPagoAD.getFormaPagoBusqueda()));
    }

    public void guardar() {
        try {
            formaPagoAD.getFormaPago().setEmpresa(1L);
            formaPagoServicio.guardar(formaPagoAD.getFormaPago());
            formaPagoAD.setListaFormasPago(formaPagoServicio.buscar(new SisFormaPago()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");
            PrimeFaces.current().executeScript("PF('dlgFormaPago').hide();");
        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(SisFormaPago formaPago) {

        try {
            formaPagoServicio.eliminar(formaPago);
            formaPagoAD.setListaFormasPago(formaPagoServicio.buscar(new SisFormaPago()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public FormaPagoAD getFormaPagoAD() {
        return formaPagoAD;
    }

    public void setFormaPagoAD(FormaPagoAD formaPagoAD) {
        this.formaPagoAD = formaPagoAD;
    }

}
