/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicio;

import com.acceso.dao.IUsuarioDao;
import com.acceso.modelo.AccUsuario;
import com.acceso.servicioImp.IUsuarioServicio;
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
public class UsuarioServicioImpl implements IUsuarioServicio {

    @EJB
    IUsuarioDao usuarioDao;

    @Override
    public AccUsuario obtenerPorId(Long id) throws RegistroNoLocalizado {
        return usuarioDao.recuperar(id);
    }

    @Override
    public List<AccUsuario> buscar(AccUsuario usuario) {
        return usuarioDao.buscar(usuario);
    }

    @Override
    public void actualizar(AccUsuario usuario) throws RegistroNoGuardado {

        usuarioDao.actualizar(usuario);
    }

    @Override
    public void eliminar(AccUsuario usuario) throws RegistroNoEliminado, RegistroNoLocalizado {

        AccUsuario usuarioEliminar = usuarioDao.recuperar(usuario.getId());
        usuarioDao.eliminar(usuarioEliminar);
    }

    @Override
    public void guardar(AccUsuario usuario) throws RegistroNoGuardado {
        if (usuario == null) {
            usuarioDao.crear(usuario);
        } else {
            usuarioDao.actualizar(usuario);
        }
    }

    @Override
    public AccUsuario usuarioLogeado(Long empresa, String usuario) {
        return usuarioDao.usuarioLogeado(empresa, usuario);
    }

}
