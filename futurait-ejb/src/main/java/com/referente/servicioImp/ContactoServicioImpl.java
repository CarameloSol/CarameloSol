/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicioImp;



import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.dao.IContactoDao;
import com.referente.modelo.RefContacto;
import com.referente.servicio.IContactoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class ContactoServicioImpl implements IContactoServicio {

    @EJB
    IContactoDao contactoDao;

    @Override
    public List<RefContacto> buscar(RefContacto contacto) {
        return contactoDao.buscar(contacto);
    }

    @Override
    public void actualizar(RefContacto contacto) throws RegistroNoGuardado {
        contactoDao.actualizar(contacto);
    }

    @Override
    public void eliminar(RefContacto contacto) throws RegistroNoEliminado, RegistroNoLocalizado {
        RefContacto contactoEliminar = contactoDao.recuperar(contacto.getId());
        contactoDao.eliminar(contactoEliminar);
    }

    @Override
    public void guardar(RefContacto contacto) throws RegistroNoGuardado {
        if (contacto.getId()== null) {
            contactoDao.crear(contacto);
        } else {
            contactoDao.actualizar(contacto);
        }
    }

    @Override
    public List<RefContacto> busquedaPorFiltros(RefContacto contacto) {
        return contactoDao.busquedaPorFiltros(contacto);
    }

    @Override
    public RefContacto obtenerPorId(Long id) throws RegistroNoLocalizado {
        return contactoDao.recuperar(id);
    }

}
