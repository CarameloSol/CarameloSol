/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.servicioImp;

import com.compra.dao.IDetalleCompraImpuestoDao;
import com.compra.modelo.ComDetalleCompraImpuesto;
import com.compra.servicio.IDetalleCompraImpuestoServicio;
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
public class DetalleCompraImpuestoServicioImpl implements IDetalleCompraImpuestoServicio {

    @EJB
    IDetalleCompraImpuestoDao detalleCompraImpuestoDao;

    @Override
    public List<ComDetalleCompraImpuesto> buscar(ComDetalleCompraImpuesto detalleCompraImpuesto) {
        return detalleCompraImpuestoDao.buscar(detalleCompraImpuesto);
    }

    @Override
    public void actualizar(ComDetalleCompraImpuesto detalleCompraImpuesto) throws RegistroNoGuardado {
        detalleCompraImpuestoDao.actualizar(detalleCompraImpuesto);
    }

    @Override
    public void eliminar(ComDetalleCompraImpuesto detalleCompraImpuesto) throws RegistroNoEliminado, RegistroNoLocalizado {
        ComDetalleCompraImpuesto detalleCompraImpuestoEliminar = detalleCompraImpuestoDao.recuperar(detalleCompraImpuesto.getId());
        detalleCompraImpuestoDao.eliminar(detalleCompraImpuestoEliminar);
    }

    @Override
    public void guardar(ComDetalleCompraImpuesto detalleCompraImpuesto) throws RegistroNoGuardado {
        if (detalleCompraImpuesto.getId()== null) {
            detalleCompraImpuestoDao.crear(detalleCompraImpuesto);
        } else {
            detalleCompraImpuestoDao.actualizar(detalleCompraImpuesto);
        }
    }

    @Override
    public List<ComDetalleCompraImpuesto> busquedaPorFiltros(ComDetalleCompraImpuesto detalleCompraImpuesto) {
        return detalleCompraImpuestoDao.busquedaPorFiltros(detalleCompraImpuesto);
    }

    @Override
    public ComDetalleCompraImpuesto obtenerPorId(Long id) throws RegistroNoLocalizado {
        return detalleCompraImpuestoDao.recuperar(id);
    }
}
