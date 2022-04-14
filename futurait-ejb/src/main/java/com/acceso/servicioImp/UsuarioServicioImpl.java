/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicioImp;

import com.acceso.dao.IUsuarioDao;
import com.acceso.modelo.AccUsuario;
import com.acceso.servicio.IUsuarioServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.security.MessageDigest;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.commons.codec.binary.Base64;

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

    private void validacionUsuario(AccUsuario usuario) throws RegistroNoGuardado {
        if (!usuario.getNombre().equals(usuario.getValidacionNombre())) {
            AccUsuario usuarioEncontrado = usuarioDao.obtenerValidacionNombre(usuario.getNombre());
            if (usuarioEncontrado != null) {
                throw new RegistroNoGuardado("El usuario ingresado ya existe");
            }
        }
    }

    @Override
    public void guardar(AccUsuario usuario) throws RegistroNoGuardado,Exception {
        validacionUsuario(usuario);
        if (usuario.getClave().isEmpty()) {
            usuario.setClave(usuario.getValidacionClave());
        } else {
            usuario.setClave(SHA256(usuario.getClave()));
        }
        if (usuario == null) {
            usuarioDao.crear(usuario);
        } else {
            usuarioDao.actualizar(usuario);
        }
    }

    /**
     *
     * @param args
     * @return
     * @throws Exception
     */
    public static String SHA256(final String args) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(args.getBytes());
        md.digest();

        String hash = Base64.encodeBase64String(md.digest(args.getBytes()));
        return hash.trim();

    }

    @Override
    public AccUsuario usuarioLogeado(String identificacion, String usuario) {
        return usuarioDao.usuarioLogeado(identificacion, usuario);
    }

    @Override
    public List<AccUsuario> busquedaPorFiltros(AccUsuario usuario) {
        return usuarioDao.busquedaPorFiltros(usuario);
    }

}
