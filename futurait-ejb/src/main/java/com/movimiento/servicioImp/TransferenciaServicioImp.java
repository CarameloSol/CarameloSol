/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.movimiento.dao.IKardexDao;
import com.movimiento.dao.ITransferenciaDao;
import com.movimiento.modelo.MovKardex;
import com.movimiento.modelo.MovTransferencia;
import com.movimiento.servicio.IKardexServicio;
import com.movimiento.servicio.ITransferenciaServicio;
import com.referente.servicio.IReferenteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class TransferenciaServicioImp implements ITransferenciaServicio {

    @EJB
    ITransferenciaDao transferenciaDao;

    @Override
    public List<MovTransferencia> buscar(MovTransferencia transferencia) {
        return transferenciaDao.buscar(transferencia);
    }

    @Override
    public void actualizar(MovTransferencia transferencia) throws RegistroNoGuardado {
        transferenciaDao.actualizar(transferencia);
    }

    @Override
    public void eliminar(MovTransferencia transferencia) throws RegistroNoEliminado, RegistroNoLocalizado {
        MovTransferencia trensferenciaEliminar = transferenciaDao.recuperar(transferencia.getId());
        transferenciaDao.eliminar(trensferenciaEliminar);
    }

    @Override
    public void guardar(MovTransferencia transferencia) throws RegistroNoGuardado, Exception {
        if (transferencia.getId()==null) {
            transferenciaDao.crear(transferencia);
        } else {
            transferenciaDao.actualizar(transferencia);
        }
    }

    @Override
    public List<MovTransferencia> busquedaPorFiltros(MovTransferencia transferencia) {
        return transferenciaDao.busquedaPorFiltros(transferencia);
    }

    @Override
    public MovTransferencia obtenerPorId(Long id) throws RegistroNoLocalizado {
        return transferenciaDao.recuperar(id);
    }

}
