/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.servicioImp;



import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.movimiento.dao.IAjusteDao;
import com.movimiento.dao.IDetalleTransferenciaDao;
import com.movimiento.modelo.MovAjuste;
import com.movimiento.modelo.MovDetalleTransferencia;
import com.movimiento.servicio.IAjusteServicio;
import com.movimiento.servicio.IDetalleTransferenciaServicio;
import com.referente.servicio.IReferenteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleTransferenciaServicioImp implements IDetalleTransferenciaServicio {

    @EJB
    IDetalleTransferenciaDao detalleTransferenciaDao;

   @EJB
    IReferenteServicio referenteServicio;

   

    @Override
    public List<MovDetalleTransferencia> buscar(MovDetalleTransferencia detalleTransferencia) {
        return detalleTransferenciaDao.buscar(detalleTransferencia);
    }

    @Override
    public void actualizar(MovDetalleTransferencia detalleTransferencia) throws RegistroNoGuardado {
        detalleTransferenciaDao.actualizar(detalleTransferencia);
    }

    @Override
    public void eliminar(MovDetalleTransferencia detalleTransferencia) throws RegistroNoEliminado, RegistroNoLocalizado {
        MovDetalleTransferencia detalleTransferenciaEliminar = detalleTransferenciaDao.recuperar(detalleTransferencia.getId());
        detalleTransferenciaDao.eliminar(detalleTransferenciaEliminar);
    }

    @Override
    public void guardar(MovDetalleTransferencia detalleTransferencia) throws RegistroNoGuardado {
        if (detalleTransferencia.getId()==null) {
            detalleTransferenciaDao.crear(detalleTransferencia);
        } else {
            detalleTransferenciaDao.actualizar(detalleTransferencia);
        }
    }

    @Override
    public List<MovDetalleTransferencia> busquedaPorFiltros(MovDetalleTransferencia detalleTransferencia) {
        return detalleTransferenciaDao.busquedaPorFiltros(detalleTransferencia);
    }

     @Override
    public MovDetalleTransferencia obtenerPorId(Long id) throws RegistroNoLocalizado {
        return detalleTransferenciaDao.recuperar(id);
    }

   
}
