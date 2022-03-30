/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicio;



import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.modelo.InvArticulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IArticuloServicio {

    public InvArticulo obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<InvArticulo> buscar(InvArticulo articulo);

    public void actualizar(InvArticulo articulo)
            throws RegistroNoGuardado;

    public void eliminar(InvArticulo articulo)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(InvArticulo articulo) throws RegistroNoGuardado,Exception ;

   
    public List<InvArticulo> busquedaPorFiltros(InvArticulo articulo);

}
