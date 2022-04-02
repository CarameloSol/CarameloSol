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
import com.movimiento.dao.IDetalleAjusteDao;
import com.movimiento.modelo.MovAjuste;
import com.movimiento.modelo.MovDetalleAjuste;
import com.movimiento.servicio.IAjusteServicio;
import com.movimiento.servicio.IDetalleAjusteServicio;
import com.referente.servicio.IReferenteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleAjusteServicioImp implements IDetalleAjusteServicio {

    @EJB
    IDetalleAjusteDao detalleAjusteDao;

   @EJB
    IReferenteServicio referenteServicio;

    @Override
    public List<MovDetalleAjuste> buscar(MovDetalleAjuste detalleAjuste) {
        return detalleAjusteDao.buscar(detalleAjuste);
    }

    @Override
    public void actualizar(MovDetalleAjuste detalleAjuste) throws RegistroNoGuardado {
        detalleAjusteDao.actualizar(detalleAjuste);
    }

    @Override
    public void eliminar(MovDetalleAjuste detalleAjuste) throws RegistroNoEliminado, RegistroNoLocalizado {
        MovDetalleAjuste detalleAjusteEliminar = detalleAjusteDao.recuperar(detalleAjuste.getId());
        detalleAjusteDao.eliminar(detalleAjusteEliminar);
    }

    @Override
    public void guardar(MovDetalleAjuste detalleAjuste) throws RegistroNoGuardado, Exception {
        if (detalleAjuste.getId()== null) {
            detalleAjusteDao.crear(detalleAjuste);
        } else {
            detalleAjusteDao.actualizar(detalleAjuste);
        }
    }

    @Override
    public List<MovDetalleAjuste> busquedaPorFiltros(MovDetalleAjuste detalleAjuste) {
        return detalleAjusteDao.busquedaPorFiltros(detalleAjuste);
    }

    @Override
    public MovDetalleAjuste obtenerPorId(Long id) throws RegistroNoLocalizado {
        return detalleAjusteDao.recuperar(id);
    }
}
