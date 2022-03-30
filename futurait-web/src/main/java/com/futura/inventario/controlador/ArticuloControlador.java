/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.inventario.controlador;

import com.futurait.controladorAcceso.*;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;

import com.futura.inventario.variables.ArticuloAD;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvClasificacion;
import com.inventario.servicio.IArticuloServicio;
import com.inventario.servicio.IClasificacionServicio;
import com.inventario.servicioImp.ArticuloServicioImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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

    public void inicio() {
        articuloAD.setListaArticulos(articuloServicio.buscar(new InvArticulo()));
        
      
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
        
    }

    public void seleccionarArticulo(InvArticulo articulo) {
        articuloAD.setArticulo(articulo);

       
    }

    public void guardar() {
        try {
            
            articuloAD.getArticulo().setNombre(String.valueOf(0));
            
            
            articuloServicio.guardar(articuloAD.getArticulo());
            articuloAD.setListaArticulos(articuloServicio.buscar(new InvArticulo()));
            addInfoMessage("Guardado exitoso");
            PrimeFaces.current().executeScript("");
            PrimeFaces.current().ajax().update("");
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

    public StreamedContent mostrarImagenTemporal(String base64) {
        try {
            base64 = base64.replaceAll("\n", "");
            InputStream is = new ByteArrayInputStream(Base64.getDecoder().decode(base64.getBytes()));
            return DefaultStreamedContent.builder().contentType("image/jpeg").name("image.jpg").stream(() -> is).build();
        } catch (Exception e) {
            return null;
        }

    }

    

   

}
