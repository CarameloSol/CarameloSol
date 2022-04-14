/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.controlador;

import com.catalogo.modelo.CatCatalogo;
import com.catalogo.modelo.CatItem;
import com.catalogo.servicio.ICatalogoServicio;
import com.catalogo.servicio.IItemServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.catalogo.variables.ItemAD;
import com.acceso.controlador.BaseControlador;
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
@Named(value = "itemControlador")
@ViewScoped
public class ItemControlador extends BaseControlador implements Serializable {

    @Inject
    ItemAD itemAD;
    @EJB
    IItemServicio itemServicio;
    @EJB
    ICatalogoServicio catalogoServicio;
   

    public void inicio() {
        itemAD.setItemBusqueda(new CatItem());
        itemAD.getItemBusqueda().setCatalogo(new CatCatalogo());
        itemAD.setListaItems(itemServicio.buscar(new CatItem()));
        itemAD.setListaCatalogo(catalogoServicio.buscar(new CatCatalogo()));
    }

    public void limpiarBusqueda() {
        itemAD.setItemBusqueda(new CatItem());
        buscar();

    }

    public void buscar() {
        itemAD.setListaItems(itemServicio.busquedaPorFiltros(itemAD.getItemBusqueda()));
    }

    public void nuevo() {
        itemAD.setItem(new CatItem());
        itemAD.setCatalogo(new CatCatalogo());
        itemAD.getItem();

    }

   

    public void seleccionarCliente(CatItem item) {
        itemAD.setItem(item);
        itemAD.setCatalogo(item.getCatalogo());
        itemAD.getItem();

    }

    public void guardar() {
        try {
            
            itemAD.getCatalogo().setEstado(Boolean.TRUE);
            itemAD.getItem().setCatalogo(itemAD.getCatalogo());
            itemServicio.guardar(itemAD.getItem());
            itemAD.setListaItems(itemServicio.buscar(new CatItem()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(CatItem item) {

        try {
            itemServicio.eliminar(item);
            itemAD.setListaItems(itemServicio.buscar(new CatItem()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

  

    public ItemAD getItemAD() {
        return itemAD;
    }

    public void setItemAD(ItemAD itemAD) {
        this.itemAD = itemAD;
    }

}
