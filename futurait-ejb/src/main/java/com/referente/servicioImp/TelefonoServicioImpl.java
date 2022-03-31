/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.dao.ITelefonoDao;
import com.referente.modelo.RefTelefono;
import com.referente.servicio.ITelefonoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class TelefonoServicioImpl implements ITelefonoServicio{

    @EJB
    ITelefonoDao telefonoDao;

   
    @Override
    public List<RefTelefono> buscar(RefTelefono telefono) {
        return telefonoDao.buscar(telefono);
    }

    @Override
    public void actualizar(RefTelefono telefono) throws RegistroNoGuardado {
        telefonoDao.actualizar(telefono);
    }

    @Override
    public void eliminar(RefTelefono telefono) throws RegistroNoEliminado, RegistroNoLocalizado {
        RefTelefono telefonoEliminar = telefonoDao.recuperar(telefono.getId());
        telefonoDao.eliminar(telefonoEliminar);
    }

    @Override
    public void guardar(RefTelefono telefono) throws RegistroNoGuardado, Exception {
        if (telefono.getId()== null) {
            telefonoDao.crear(telefono);
        } else {
            telefonoDao.actualizar(telefono);
        }
    }

    @Override
    public List<RefTelefono> busquedaPorFiltros(RefTelefono telefono) {
        return telefonoDao.busquedaPorFiltros(telefono);
    }

     @Override
    public RefTelefono obtenerPorId(Long id) throws RegistroNoLocalizado {
        return telefonoDao.recuperar(id);
    }

    
}
