/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
 import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.venta.dao.IVentaDao;
import com.venta.modelo.VenVenta;
import com.venta.servicio.IVentaServicio;


/**
 *
 * @author Ricardo
 */
@Stateless
public class VentaServicioImpl implements IVentaServicio {

    @EJB
    IVentaDao ventaDao;

   

    @Override
    public List<VenVenta> buscar(VenVenta venta) {
        return ventaDao.buscar(venta);
    }

    @Override
    public void actualizar(VenVenta venta) throws RegistroNoGuardado {
        ventaDao.actualizar(venta);
    }

    @Override
    public void eliminar(VenVenta venta) throws RegistroNoEliminado, RegistroNoLocalizado {
        VenVenta ventaEliminar= ventaDao.recuperar(venta.getId());
        ventaDao.eliminar(ventaEliminar);
    }
 
    @Override
    public void guardar(VenVenta venta) throws RegistroNoGuardado {
         if (venta.getId()==null) {
            ventaDao.crear(venta);
        } else {
            ventaDao.actualizar(venta);
        }
    }

    @Override
    public List<VenVenta> busquedaPorFiltros(VenVenta venta) {
        return ventaDao.busquedaPorFiltros(venta);
    }

    @Override
    public VenVenta obtenerPorId(Long id) throws RegistroNoLocalizado {
        return ventaDao.recuperar(id);
    }

}
