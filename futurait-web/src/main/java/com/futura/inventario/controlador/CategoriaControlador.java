/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.inventario.controlador;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.inventario.variables.CategoriaAD;
import com.futurait.controladorAcceso.BaseControlador;
import com.inventario.modelo.InvCategoria;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.shaded.commons.io.IOUtils;
import com.inventario.servicio.ICategoriaServicio;

/**
 *
 * @author Ricardo
 */
@Named(value = "categoriaControlador")
@ViewScoped
public class CategoriaControlador extends BaseControlador implements Serializable {

    @Inject
    CategoriaAD categoriaAD;
    @EJB
    ICategoriaServicio categoriaServicio;

    public void inicio() {
        validarAcceso();
        categoriaAD.setListaCategoria(categoriaServicio.buscar(new InvCategoria()));
    }

    public void limpiarBusqueda() {
        categoriaAD.setCategoriaBusqueda(new InvCategoria());
        buscar();

    }

    public void buscar() {
        categoriaAD.setListaCategoria(categoriaServicio.busquedaPorFiltros(categoriaAD.getCategoriaBusqueda()));
    }

    public void nuevo() {
        categoriaAD.setCategoria(new InvCategoria());
        categoriaAD.getCategoria().setValidacionNombre("");
    }

    public void seleccionarCategoria(InvCategoria usuario) {
        categoriaAD.setCategoria(usuario);
        categoriaAD.getCategoria().setValidacionNombre(usuario.getNombre());
    }

    public void guardar() {
        try {
            categoriaAD.getCategoria().setEmpresa(1L);
            categoriaServicio.guardar(categoriaAD.getCategoria());
            categoriaAD.setListaCategoria(categoriaServicio.buscar(new InvCategoria()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgCategoria').hide();");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");
        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(InvCategoria usuario) {

        try {
            categoriaServicio.eliminar(usuario);
            categoriaAD.setListaCategoria(categoriaServicio.buscar(new InvCategoria()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }
    

    public void almacenarImagen(FileUploadEvent event) {

        try {
            categoriaAD.getCategoria().setImagen(IOUtils.toByteArray(event.getFile().getInputStream()));
        } catch (IOException e) {
            addErrorMessage(e.getMessage());
        }
    }

    public CategoriaAD getCategoriaAD() {
        return categoriaAD;
    }

    public void setCategoriaAD(CategoriaAD categoriaAD) {
        this.categoriaAD = categoriaAD;
    }

    public ICategoriaServicio getCategoriaServicio() {
        return categoriaServicio;
    }

    public void setCategoriaServicio(ICategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

  
}
