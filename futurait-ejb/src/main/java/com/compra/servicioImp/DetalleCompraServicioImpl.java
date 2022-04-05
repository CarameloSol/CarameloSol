/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.servicioImp;

import com.compra.dao.ICompraDao;
import com.compra.dao.IDetalleCompraDao;
import com.compra.modelo.ComCompra;
import com.compra.modelo.ComDetalleCompra;
import com.compra.servicio.ICompraServicio;
import com.compra.servicio.IDetalleCompraServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleCompraServicioImpl implements IDetalleCompraServicio {

    @EJB
    IDetalleCompraDao detalleCompraDao;

    @Override
    public List<ComDetalleCompra> buscar(ComDetalleCompra detalleCompra) {
        return detalleCompraDao.buscar(detalleCompra);
    }

    @Override
    public void actualizar(ComDetalleCompra detalleCompra) throws RegistroNoGuardado {
        detalleCompraDao.actualizar(detalleCompra);
    }

    @Override
    public void eliminar(ComDetalleCompra detalleCompra) throws RegistroNoEliminado, RegistroNoLocalizado {
        ComDetalleCompra detalleCompraEliminar = detalleCompraDao.recuperar(detalleCompra.getId());
        detalleCompraDao.eliminar(detalleCompraEliminar);
    }

    @Override
    public void guardar(ComDetalleCompra detalleCompra) throws RegistroNoGuardado {
        if (detalleCompra.getId()==null) {
            detalleCompraDao.crear(detalleCompra);
        } else {
            detalleCompraDao.actualizar(detalleCompra);
        }
    }

    @Override
    public List<ComDetalleCompra> busquedaPorFiltros(ComDetalleCompra detalleCompra) {
        return detalleCompraDao.busquedaPorFiltros(detalleCompra);
    }

    @Override
    public ComDetalleCompra obtenerPorId(Long id) throws RegistroNoLocalizado {
        return detalleCompraDao.recuperar(id);
    }
}
