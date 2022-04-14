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
 import com.referente.modelo.RefReferente;
 import com.referente.servicio.IPersonaServicio;
import com.referente.servicio.IReferenteServicio;
import com.sistema.modelo.SisEmpresa;
import com.sistema.servicio.IEmpresaServicio;
import com.sistema.variables.empresaAD;
import java.io.IOException;
import java.io.Serializable;
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
@Named(value = "empresaControlador")
@ViewScoped
public class EmpresaControlador extends BaseControlador implements Serializable {

    @Inject
    empresaAD empresaAD;
    @EJB
    IEmpresaServicio empresaServicio;
    @EJB
    IReferenteServicio referenteServicio;
    @EJB
    IPersonaServicio personaServicio;

    public void inicio() {
        empresaAD.setEmpresaBusqueda(new SisEmpresa());
        empresaAD.getEmpresaBusqueda().setReferente(new RefReferente());
        empresaAD.setListaEmpresas(empresaServicio.buscar(new SisEmpresa()));
    }

    public void limpiarBusqueda() {
        empresaAD.setEmpresaBusqueda(new SisEmpresa());
        buscar();

    }

    public void buscar() {
        empresaAD.setListaEmpresas(empresaServicio.busquedaPorFiltros(empresaAD.getEmpresaBusqueda()));
    }

    public void nuevo() {
        empresaAD.setEmpresa(new SisEmpresa());
        empresaAD.setReferente(new RefReferente());
        empresaAD.getEmpresa().setEstado(Boolean.TRUE);

    }

    public void recuperarDatosPersona() {

        empresaAD.setReferente(referenteServicio.obtenerDatosReferente(empresaAD.getReferente()));

    }

    public void seleccionarEmpresa(SisEmpresa empresa) {
        empresaAD.setEmpresa(empresa);
        empresaAD.setReferente(empresa.getReferente());
        empresaAD.getEmpresa();

    }

    public void guardar() {
        try {
            empresaAD.getReferente().setEmpresa(1l);
            empresaAD.getReferente().setEstado(Boolean.TRUE);
            empresaAD.getEmpresa().setReferente(empresaAD.getReferente());
            empresaServicio.guardar(empresaAD.getEmpresa());
            empresaAD.setListaEmpresas(empresaServicio.buscar(new SisEmpresa()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgEmpresa').hide();");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(SisEmpresa empresa) {

        try {
            empresaServicio.eliminar(empresa);
            empresaAD.setListaEmpresas(empresaServicio.buscar(new SisEmpresa()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void almacenarImagen(FileUploadEvent event) {

        try {
            empresaAD.getEmpresa().setImagen(IOUtils.toByteArray(event.getFile().getInputStream()));
        } catch (IOException e) {
            addErrorMessage(e.getMessage());
        }
    }
 
}
