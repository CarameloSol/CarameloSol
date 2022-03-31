/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.referente.controlador;

import com.futura.inventario.controlador.*;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.inventario.variables.ArticuloAD;
import com.futura.referente.variables.ClienteAD;
import com.futura.referente.variables.ContactoAD;
import com.futura.referente.variables.DireccionAD;
import com.futura.referente.variables.ProveedorAD;
import com.futurait.controladorAcceso.BaseControlador;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvCategoria;
import com.inventario.servicio.IArticuloServicio;
import com.inventario.servicio.ICategoriaServicio;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefContacto;
import com.referente.modelo.RefDireccion;
import com.referente.modelo.RefProveedor;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IContactoServicio;
import com.referente.servicio.IDireccionServicio;
import com.referente.servicio.IProveedorServicio;
import com.referente.servicio.IReferenteServicio;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.shaded.commons.io.IOUtils;

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

    public void buscar() {

        proveedorAD.setListaProveedores(proveedorServicio.busquedaPorFiltros(proveedorAD.getProveedorBusqueda()));
    }

    public void nuevo() {
        proveedorAD.setProveedor(new RefProveedor());
        proveedorAD.setIdReferente(null);
        proveedorAD.getProveedor();

    }

    public void seleccionarDireccion(RefProveedor proveedor) {
        proveedorAD.setProveedor(proveedor);
        proveedorAD.setIdReferente(proveedor.getReferente().getId());
        proveedorAD.getProveedor();

    }

    public void guardar() {
        try {
            proveedorAD.getProveedor().setId(1l);
           
            RefReferente referenteEncontrada = referenteServicio.obtenerPorId(proveedorAD.getIdReferente());
            proveedorAD.getProveedor().setReferente(referenteEncontrada);
            proveedorServicio.guardar(proveedorAD.getProveedor());

            proveedorAD.setListaProveedores(proveedorServicio.buscar(new RefProveedor()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");

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
