/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.venta.dao.IPedidoVentaDao;
 import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.venta.modelo.VenPedidoVenta;
import com.venta.servicio.IPedidoVentaServicio;


/**
 *
 * @author Ricardo
 */
@Stateless
public class PedidoVentaServicioImpl implements IPedidoVentaServicio {

    @EJB
    IPedidoVentaDao pedidoVentaDao;

  

    @Override
    public List<VenPedidoVenta> buscar(VenPedidoVenta pedidoVenta) {
        return pedidoVentaDao.buscar(pedidoVenta);
    }

    @Override
    public void actualizar(VenPedidoVenta pedidoVenta) throws RegistroNoGuardado {
        pedidoVentaDao.actualizar(pedidoVenta);
    }

    @Override
    public void eliminar(VenPedidoVenta pedidoVenta) throws RegistroNoEliminado, RegistroNoLocalizado {
        VenPedidoVenta pedidoVentaEliminar = pedidoVentaDao.recuperar(pedidoVenta.getId());
        pedidoVentaDao.eliminar(pedidoVentaEliminar);
    }

    @Override
    public void guardar(VenPedidoVenta pedidoVenta) throws RegistroNoGuardado {
        if (pedidoVenta.getId()==null) {
            pedidoVentaDao.crear(pedidoVenta);
        } else {
            pedidoVentaDao.actualizar(pedidoVenta);
        }
    }

    @Override
    public List<VenPedidoVenta> busquedaPorFiltros(VenPedidoVenta pedidoVenta) {
        return pedidoVentaDao.busquedaPorFiltros(pedidoVenta);
    }

     @Override
    public VenPedidoVenta obtenerPorId(Long id) throws RegistroNoLocalizado {
        return pedidoVentaDao.recuperar(id);
    }

   
}
