/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.variables;

import com.catalogo.modelo.CatCatalogo;
import com.catalogo.modelo.CatItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "catalogoAD")
@ViewScoped
public class CatalogoAD implements Serializable {

    List<CatCatalogo> listaCatalogos = new ArrayList<>();
    CatCatalogo catalogo = new CatCatalogo();
    CatItem item = new CatItem();
    CatCatalogo catalogoBusqueda = new CatCatalogo();
    List<CatItem> listaItemCrear = new ArrayList<>();
    List<CatItem> listaItemEliminar = new ArrayList<>();

    public List<CatCatalogo> getListaCatalogos() {
        return listaCatalogos;
    }

    public void setListaCatalogos(List<CatCatalogo> listaCatalogos) {
        this.listaCatalogos = listaCatalogos;
    }

    public CatCatalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(CatCatalogo catalogo) {
        this.catalogo = catalogo;
    }

    public CatItem getItem() {
        return item;
    }

    public void setItem(CatItem item) {
        this.item = item;
    }

    public CatCatalogo getCatalogoBusqueda() {
        return catalogoBusqueda;
    }

    public void setCatalogoBusqueda(CatCatalogo catalogoBusqueda) {
        this.catalogoBusqueda = catalogoBusqueda;
    }

    public List<CatItem> getListaItemCrear() {
        return listaItemCrear;
    }

    public void setListaItemCrear(List<CatItem> listaItemCrear) {
        this.listaItemCrear = listaItemCrear;
    }

    public List<CatItem> getListaItemEliminar() {
        return listaItemEliminar;
    }

    public void setListaItemEliminar(List<CatItem> listaItemEliminar) {
        this.listaItemEliminar = listaItemEliminar;
    }

 
}
