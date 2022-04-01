/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.catalogo.controlador;

import com.catalogo.modelo.CatCatalogo;
import com.catalogo.modelo.CatItem;
import com.catalogo.servicio.ICatalogoServicio;
import com.catalogo.servicio.IItemServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.futura.catalogo.variables.CatalogoAD;
import com.futurait.controladorAcceso.BaseControlador;
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
@Named(value = "catalogoControlador")
@ViewScoped
public class CatalogoControlador extends BaseControlador implements Serializable {

    @Inject
    CatalogoAD catalogoAD;
    @EJB
    ICatalogoServicio catalogoServicio;
    @EJB
    IItemServicio itemServicio;
    

    public void inicio() {
        catalogoAD.setCatalogoBusqueda(new CatCatalogo());
        
        catalogoAD.setListaCatalogos(catalogoServicio.buscar(new CatCatalogo()));
        catalogoAD.setListaItem(itemServicio.buscar(new CatItem()));
    }

    public void limpiarBusqueda() {
        catalogoAD.setCatalogoBusqueda(new CatCatalogo());
        buscar();

    }

    public void buscar() {
        catalogoAD.setListaCatalogos(catalogoServicio.busquedaPorFiltros(catalogoAD.getCatalogoBusqueda()));
    }

    public void nuevo() {
        catalogoAD.setCatalogo(new CatCatalogo());
        catalogoAD.setItem(new CatItem());
        catalogoAD.getCatalogo();

    }

   

    public void seleccionarCatalogo(CatCatalogo catalogo) {
        catalogoAD.setCatalogo(catalogo);
        
        catalogoAD.getCatalogo();

    }

    public void guardar() {
        try {
            catalogoAD.getItem().setEstado(Boolean.TRUE);
            
            
            catalogoServicio.guardar(catalogoAD.getCatalogo());
            catalogoAD.setListaCatalogos(catalogoServicio.buscar(new CatCatalogo()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgCatalogo').hide();");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(CatCatalogo catalogo) {

        try {
            catalogoServicio.eliminar(catalogo);
            catalogoAD.setListaCatalogos(catalogoServicio.buscar(new CatCatalogo()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

   

    public CatalogoAD getCatalogoAD() {
        return catalogoAD;
    }

    public void setCatalogoAD(CatalogoAD catalogoAD) {
        this.catalogoAD = catalogoAD;
    }

}
