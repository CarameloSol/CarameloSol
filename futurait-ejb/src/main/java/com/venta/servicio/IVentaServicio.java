/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.servicio;

 
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
 import com.venta.modelo.VenVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IVentaServicio {

    public VenVenta obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<VenVenta> buscar(VenVenta venta);

    public void actualizar(VenVenta venta)
            throws RegistroNoGuardado;

    public void eliminar(VenVenta venta)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(VenVenta venta) throws RegistroNoGuardado ;

    public List<VenVenta> busquedaPorFiltros(VenVenta venta);

}
