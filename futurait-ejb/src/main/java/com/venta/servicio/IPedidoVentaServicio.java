/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.servicio;

 
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.venta.modelo.VenPedidoVenta;
 import com.venta.modelo.VenVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IPedidoVentaServicio {

    public VenPedidoVenta obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<VenPedidoVenta> buscar(VenPedidoVenta pedidoVenta);

    public void actualizar(VenPedidoVenta pedidoVenta)
            throws RegistroNoGuardado;

    public void eliminar(VenPedidoVenta pedidoVenta)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(VenPedidoVenta pedidoVenta) throws RegistroNoGuardado ;

    public List<VenPedidoVenta> busquedaPorFiltros(VenPedidoVenta pedidoVenta);

}
