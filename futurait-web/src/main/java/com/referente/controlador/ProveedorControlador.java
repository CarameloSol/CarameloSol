/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.controlador;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.variables.ProveedorAD;
import com.controladorAcceso.BaseControlador;
import com.referente.modelo.RefProveedor;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IProveedorServicio;
import com.referente.servicio.IReferenteServicio;
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
@Named(value = "proveedorControlador")
@ViewScoped
public class ProveedorControlador extends BaseControlador implements Serializable {

    @Inject
    ProveedorAD proveedorAD;
    @EJB
    IProveedorServicio proveedorServicio;
    @EJB
    IReferenteServicio referenteServicio;

    public void inicio() {
        proveedorAD.setListaProveedores(proveedorServicio.buscar(new RefProveedor()));
        proveedorAD.setListaReferente(referenteServicio.buscar(new RefReferente()));
    }

    public void limpiarBusqueda() {
        proveedorAD.setProveedorBusqueda(new RefProveedor());
        buscar();

    }
    
     public void recuperarDatosPersona() {

        proveedorAD.setReferente(referenteServicio.obtenerDatosReferente(proveedorAD.getReferente()));

    }
     

    public void buscar() {

        proveedorAD.setListaProveedores(proveedorServicio.busquedaPorFiltros(proveedorAD.getProveedorBusqueda()));
    }

    public void nuevo() {
        proveedorAD.setProveedor(new RefProveedor());
        proveedorAD.setReferente(new RefReferente());
        proveedorAD.getProveedor().setEstado(Boolean.TRUE);
        proveedorAD.getProveedor();

    }

    public void seleccionarProveedor(RefProveedor proveedor) {
        proveedorAD.setProveedor(proveedor);
        proveedorAD.setReferente(proveedor.getReferente());
        proveedorAD.getProveedor();

    }

    public void guardar() {
        try {
          
            proveedorAD.getProveedor().setReferente(proveedorAD.getReferente());
            proveedorServicio.guardar(proveedorAD.getProveedor());

            proveedorAD.setListaProveedores(proveedorServicio.buscar(new RefProveedor()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgProveedor').hide();");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(RefProveedor proveedor) {

        try {
            proveedorServicio.eliminar(proveedor);
            proveedorAD.setListaProveedores(proveedorServicio.buscar(new RefProveedor()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    

    public ProveedorAD getProveedorAD() {
        return proveedorAD;
    }

    public void setProveedorAD(ProveedorAD proveedorAD) {
        this.proveedorAD = proveedorAD;
    }

}
