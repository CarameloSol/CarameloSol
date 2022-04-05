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
@Named(value = "itemAD")
@ViewScoped
public class ItemAD implements Serializable {

    List<CatItem> listaItems = new ArrayList<>();
    CatItem item = new CatItem();
    CatCatalogo catalogo = new CatCatalogo();
    CatItem itemBusqueda = new CatItem();
    List<CatCatalogo> listaCatalogo = new ArrayList<>();

    public List<CatItem> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<CatItem> listaItems) {
        this.listaItems = listaItems;
    }

    public CatItem getItem() {
        return item;
    }

    public void setItem(CatItem item) {
        this.item = item;
    }

    public CatCatalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(CatCatalogo catalogo) {
        this.catalogo = catalogo;
    }

    public CatItem getItemBusqueda() {
        return itemBusqueda;
    }

    public void setItemBusqueda(CatItem itemBusqueda) {
        this.itemBusqueda = itemBusqueda;
    }

    public List<CatCatalogo> getListaCatalogo() {
        return listaCatalogo;
    }

    public void setListaCatalogo(List<CatCatalogo> listaCatalogo) {
        this.listaCatalogo = listaCatalogo;
    }

   
    
}
