/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicioImp;

import com.acceso.dao.IRolDao;
import com.acceso.modelo.AccRol;
import com.acceso.servicio.IRolServicio;
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
public class RolServicioImpl implements IRolServicio {

    @EJB
    IRolDao rolDao;

    @Override
    public AccRol obtenerPorId(Long id) throws RegistroNoLocalizado {
        return rolDao.recuperar(id);
    }

    @Override
    public List<AccRol> buscar(AccRol rol) {
        return rolDao.buscar(rol);
    }

    @Override
    public void actualizar(AccRol rol) throws RegistroNoGuardado {

        rolDao.actualizar(rol);
    }

    @Override
    public void eliminar(AccRol rol) throws RegistroNoEliminado, RegistroNoLocalizado {

        AccRol rolEliminar = rolDao.recuperar(rol.getId());
        if (!rolEliminar.getListaUsuarios().isEmpty()) {
            throw new RegistroNoEliminado("Rol asignado a usuarios");
        }
        rolDao.eliminar(rolEliminar);
    }

    @Override
    public void guardar(AccRol rol) throws RegistroNoGuardado {
        if (rol.getId() == null) {
            rolDao.crear(rol);
        } else {
            rolDao.actualizar(rol);
        }

    }

    @Override
    public List<AccRol> busquedaPorFiltros(AccRol rol) {
      return rolDao.busquedaPorFiltros(rol);
    }

}
