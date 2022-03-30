/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.inventario.variables;


import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccUsuario;
import com.inventario.modelo.InvArticulo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "articuloAD")
@ViewScoped
public class ArticuloAD implements Serializable {

    List<InvArticulo> listaArticulos = new ArrayList<>();
    InvArticulo articulo = new InvArticulo();
    InvArticulo articuloBusqueda = new InvArticulo();

    public List<InvArticulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<InvArticulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public InvArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(InvArticulo articulo) {
        this.articulo = articulo;
    }

    public InvArticulo getArticuloBusqueda() {
        return articuloBusqueda;
    }

    public void setArticuloBusqueda(InvArticulo articuloBusqueda) {
        this.articuloBusqueda = articuloBusqueda;
    }


}
