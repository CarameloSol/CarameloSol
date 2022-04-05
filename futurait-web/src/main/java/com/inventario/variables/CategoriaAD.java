/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.variables;


import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccUsuario;
import com.inventario.modelo.InvCategoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "categoriaAD")
@ViewScoped
public class CategoriaAD implements Serializable {

    List<InvCategoria> listaCategoria = new ArrayList<>();
    InvCategoria categoria = new InvCategoria();
    InvCategoria categoriaBusqueda = new InvCategoria();

    public List<InvCategoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<InvCategoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public InvCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(InvCategoria categoria) {
        this.categoria = categoria;
    }

    public InvCategoria getCategoriaBusqueda() {
        return categoriaBusqueda;
    }

    public void setCategoriaBusqueda(InvCategoria categoriaBusqueda) {
        this.categoriaBusqueda = categoriaBusqueda;
    }

}
