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
import com.movimiento.dao.IKardexDao;
import com.movimiento.modelo.MovAjuste;
import com.movimiento.modelo.MovKardex;
import com.movimiento.servicio.IAjusteServicio;
import com.movimiento.servicio.IKardexServicio;
import com.referente.servicio.IReferenteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class KardexServicioImp implements IKardexServicio {

    @EJB
    IKardexDao kardexDao;

   @EJB
    IReferenteServicio referenteServicio;

    @Override
    public List<MovKardex> buscar(MovKardex kardex) {
        return kardexDao.buscar(kardex);
    }

    @Override
    public void actualizar(MovKardex kardex) throws RegistroNoGuardado {
        kardexDao.actualizar(kardex);
    }

    @Override
    public void eliminar(MovKardex kardex) throws RegistroNoEliminado, RegistroNoLocalizado {
        MovKardex kardexEliminar = kardexDao.recuperar(kardex.getId());
        kardexDao.eliminar(kardex);
    }

    @Override
    public void guardar(MovKardex kardex) throws RegistroNoGuardado, Exception {
        if (kardex.getId()==null) {
            kardexDao.crear(kardex);
        } else {
            kardexDao.actualizar(kardex);
        }
    }

    @Override
    public List<MovKardex> busquedaPorFiltros(MovKardex kardex) {
        return kardexDao.busquedaPorFiltros(kardex);
    }

     @Override
    public MovKardex obtenerPorId(Long id) throws RegistroNoLocalizado {
        return kardexDao.recuperar(id);
    }

   
}
