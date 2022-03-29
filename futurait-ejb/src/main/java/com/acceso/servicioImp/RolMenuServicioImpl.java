/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicioImp;

import com.acceso.dao.IRolDao;
import com.acceso.dao.IRolMenuDao;
import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccRolMenu;
import com.acceso.servicio.IRolMenuServicio;
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
public class RolMenuServicioImpl implements IRolMenuServicio {

    @EJB
    IRolMenuDao rolMenuDao;

    @Override
    public AccRolMenu obtenerPorId(Long id) throws RegistroNoLocalizado {
        return rolMenuDao.recuperar(id);
    }

    @Override
    public List<AccRolMenu> buscar(AccRolMenu rolMenu) {
        return rolMenuDao.buscar(rolMenu);
    }

    @Override
    public void actualizar(AccRolMenu rolMenu) throws RegistroNoGuardado {
        rolMenuDao.actualizar(rolMenu);
    }

    @Override
    public void eliminar(AccRolMenu rolMenu) throws RegistroNoEliminado, RegistroNoLocalizado {
        AccRolMenu menuEliminar = rolMenuDao.recuperar(rolMenu.getId());
         if (!menuEliminar.getDescripcion().isEmpty()) {
            throw new RegistroNoEliminado("Rol Menu asignado");
        }
        rolMenuDao.eliminar(menuEliminar);
        }
    

    @Override
    public void guardar(AccRolMenu rolMenu) throws RegistroNoGuardado {
        if (rolMenu.getId()== null) {
            rolMenuDao.crear(rolMenu);
        } else {
            rolMenuDao.actualizar(rolMenu);
        }
    }

    @Override
    public List<AccRolMenu> busquedaPorFiltros(AccRolMenu rolMenu) {
        return rolMenuDao.busquedaPorFiltros(rolMenu);
    }

    
}
