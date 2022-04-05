/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.servicio;

 
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.venta.modelo.VenDetalleVenta;
 import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleVentaServicio {

    public VenDetalleVenta obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<VenDetalleVenta> buscar(VenDetalleVenta detalleVenta);

    public void actualizar(VenDetalleVenta detalleVenta)
            throws RegistroNoGuardado;

    public void eliminar(VenDetalleVenta detalleVenta)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(VenDetalleVenta detalleVenta) throws RegistroNoGuardado ;

    public List<VenDetalleVenta> busquedaPorFiltros(VenDetalleVenta detalleVenta);

}
