/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.dao.IClasificacionDao;
import com.inventario.modelo.InvClasificacion;
import com.inventario.servicio.IClasificacionServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class ClasificacionServicioImpl implements IClasificacionServicio {

    @EJB
    IClasificacionDao clasificacionDao;

   

    @Override
    public List<InvClasificacion> buscar(InvClasificacion clasificacion) {
        return clasificacionDao.buscar(clasificacion);
    }

    @Override
    public void actualizar(InvClasificacion clasificacion) throws RegistroNoGuardado {
        clasificacionDao.actualizar(clasificacion);
    }

    @Override
    public void eliminar(InvClasificacion clasificacion) throws RegistroNoEliminado, RegistroNoLocalizado {
        InvClasificacion clasificacionEliminar= clasificacionDao.recuperar(clasificacion.getId());
        clasificacionDao.eliminar(clasificacionEliminar);
    }

    @Override
    public void guardar(InvClasificacion clasificacion) throws RegistroNoGuardado, Exception {
        if (clasificacion.getId()==null) {
            clasificacionDao.crear(clasificacion);
        } else {
            clasificacionDao.actualizar(clasificacion);
        }
    }

    @Override
    public List<InvClasificacion> busquedaPorFiltros(InvClasificacion clasificacion) {
        return clasificacionDao.busquedaPorFiltros(clasificacion);
    }

    @Override
    public InvClasificacion obtenerPorId(Long id) throws RegistroNoLocalizado {
        return clasificacionDao.recuperar(id);
    }

}
