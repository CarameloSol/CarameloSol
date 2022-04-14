/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.controlador;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.variables.ArticuloAD;
import com.acceso.controlador.BaseControlador;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvCategoria;
import com.inventario.servicio.IArticuloServicio;
import com.inventario.servicio.ICategoriaServicio;
import com.sistema.modelo.SisImpuesto;
import com.sistema.servicio.IImpuestoServicio;
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
@Named(value = "articuloControlador")
@ViewScoped
public class ArticuloControlador extends BaseControlador implements Serializable {

    @Inject
    ArticuloAD articuloAD;
    @EJB
    IArticuloServicio articuloServicio;
    @EJB
    ICategoriaServicio categoriaServicio;
@EJB
    IImpuestoServicio impuestoServicio;


    public void inicio() {
        articuloAD.setListaArticulos(articuloServicio.buscar(new InvArticulo()));
        articuloAD.setListaCategoria(categoriaServicio.buscar(new InvCategoria()));
        articuloAD.setListaImpuestos(impuestoServicio.buscar(new SisImpuesto()));
    }

    public void limpiarBusqueda() {
        articuloAD.setArticuloBusqueda(new InvArticulo());
        buscar();

    }

    public void buscar() {

        articuloAD.setListaArticulos(articuloServicio.busquedaPorFiltros(articuloAD.getArticuloBusqueda()));
    }

    public void nuevo() {
        articuloAD.setArticulo(new InvArticulo());
        articuloAD.setIdCategoria(null);
        articuloAD.setIdImpuesto(null);
        articuloAD.getArticulo().setValidacionNombre("");

    }

    public void seleccionarArticulo(InvArticulo articulo) {
        articuloAD.setArticulo(articulo);
        articuloAD.setIdCategoria(articulo.getCategoria().getId());
          articuloAD.setIdImpuesto(articulo.getImpuesto().getId());
        articuloAD.getArticulo().setValidacionNombre(articulo.getNombre());

    }

    public void guardar() {
        try {
            articuloAD.getArticulo().setEmpresa(1L);
            articuloAD.getArticulo().setStock(BigDecimal.ZERO);
            InvCategoria categoriaEncontrada = categoriaServicio.obtenerPorId(articuloAD.getIdCategoria());
            SisImpuesto impuestoEncontrado = impuestoServicio.obtenerPorId(articuloAD.getIdImpuesto());
            articuloAD.getArticulo().setCategoria(categoriaEncontrada);
            articuloAD.getArticulo().setImpuesto(impuestoEncontrado);
            articuloServicio.guardar(articuloAD.getArticulo());

            articuloAD.setListaArticulos(articuloServicio.buscar(new InvArticulo()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("PF('dlgArticulo').hide();");
            PrimeFaces.current().ajax().update("form:contenidoPrincipal");

        } catch (RegistroNoGuardado ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void eliminar(InvArticulo articulo) {

        try {
            articuloServicio.eliminar(articulo);
            articuloAD.setListaArticulos(articuloServicio.buscar(new InvArticulo()));
            addInfoMessage("Registro eliminado");
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void almacenarImagen(FileUploadEvent event) {

        try {
            articuloAD.getArticulo().setImagen(IOUtils.toByteArray(event.getFile().getInputStream()));
        } catch (IOException e) {
            addErrorMessage(e.getMessage());
        }
    }

    public ArticuloAD getArticuloAD() {
        return articuloAD;
    }

    public void setArticuloAD(ArticuloAD articuloAD) {
        this.articuloAD = articuloAD;
    }

}
