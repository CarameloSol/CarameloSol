/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.inventario.variables;


import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccUsuario;
import com.inventario.modelo.InvClasificacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "clasificacionAD")
@ViewScoped
public class ClasificacionAD implements Serializable {

    List<InvClasificacion> listaClasificacion = new ArrayList<>();
    InvClasificacion clasificacion = new InvClasificacion();
    InvClasificacion clasificacionBusqueda = new InvClasificacion();

    public List<InvClasificacion> getListaClasificacion() {
        return listaClasificacion;
    }

    public void setListaClasificacion(List<InvClasificacion> listaClasificacion) {
        this.listaClasificacion = listaClasificacion;
    }

    public InvClasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(InvClasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public InvClasificacion getClasificacionBusqueda() {
        return clasificacionBusqueda;
    }

    public void setClasificacionBusqueda(InvClasificacion clasificacionBusqueda) {
        this.clasificacionBusqueda = clasificacionBusqueda;
    }

}
