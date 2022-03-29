/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicioImp;

import com.acceso.dao.IMenuDao;

import com.acceso.modelo.AccMenu;

import com.acceso.servicio.IMenuServicio;

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
public class MenuServicioImpl implements IMenuServicio {

    @EJB
    IMenuDao menuDao;

    @Override
    public AccMenu obtenerPorId(Long id) throws RegistroNoLocalizado {
        return menuDao.recuperar(id);
    }

    @Override
    public List<AccMenu> buscar(AccMenu menu) {
        return menuDao.buscar(menu);
    }

    @Override
    public void actualizar(AccMenu menu) throws RegistroNoGuardado {
        menuDao.actualizar(menu);
    }

    @Override
    public void eliminar(AccMenu menu) throws RegistroNoEliminado, RegistroNoLocalizado {
        AccMenu menuEliminar = menuDao.recuperar(menu.getId());
        if (!menuEliminar.getNombre().isEmpty()) {
            throw new RegistroNoEliminado("Menu asignado");
        }
        menuDao.eliminar(menuEliminar);
            
        }
   

    @Override
    public void guardar(AccMenu menu) throws RegistroNoGuardado {
        if (menu.getId()== null) {
            menuDao.crear(menu);
        } else {
                menuDao.actualizar(menu);
        }
    }

    @Override
    public List<AccMenu> busquedaPorFiltros(AccMenu menu) {
        return menuDao.busquedaPorFiltros(menu);
    }

  
}
