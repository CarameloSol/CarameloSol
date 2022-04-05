/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.venta.dao.IDetalleVentaDao;
import com.venta.modelo.VenDetalleVenta;
import com.venta.servicio.IDetalleVentaServicio;
 import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
 


/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleVentaServicioImpl implements IDetalleVentaServicio {

    @EJB
    IDetalleVentaDao detalleDetalleVentaDao;

   

    @Override
    public List<VenDetalleVenta> buscar(VenDetalleVenta detalleDetalleVenta) {
        return detalleDetalleVentaDao.buscar(detalleDetalleVenta);
    }

    @Override
    public void actualizar(VenDetalleVenta detalleDetalleVenta) throws RegistroNoGuardado {
        detalleDetalleVentaDao.actualizar(detalleDetalleVenta);
    }

    @Override
    public void eliminar(VenDetalleVenta detalleDetalleVenta) throws RegistroNoEliminado, RegistroNoLocalizado {
        VenDetalleVenta detalleDetalleVentaEliminar= detalleDetalleVentaDao.recuperar(detalleDetalleVenta.getId());
        detalleDetalleVentaDao.eliminar(detalleDetalleVentaEliminar);
    }
 
    @Override
    public void guardar(VenDetalleVenta detalleDetalleVenta) throws RegistroNoGuardado {
         if (detalleDetalleVenta.getId()==null) {
            detalleDetalleVentaDao.crear(detalleDetalleVenta);
        } else {
            detalleDetalleVentaDao.actualizar(detalleDetalleVenta);
        }
    }

    @Override
    public List<VenDetalleVenta> busquedaPorFiltros(VenDetalleVenta detalleDetalleVenta) {
        return detalleDetalleVentaDao.busquedaPorFiltros(detalleDetalleVenta);
    }

    @Override
    public VenDetalleVenta obtenerPorId(Long id) throws RegistroNoLocalizado {
        return detalleDetalleVentaDao.recuperar(id);
    }

}
