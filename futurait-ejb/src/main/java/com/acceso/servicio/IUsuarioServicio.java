/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicio;

import com.acceso.modelo.AccUsuario;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IUsuarioServicio {

    public AccUsuario obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<AccUsuario> buscar(AccUsuario usuario);

    public void actualizar(AccUsuario usuario)
            throws RegistroNoGuardado;

    public void eliminar(AccUsuario usuario)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(AccUsuario usuario) throws RegistroNoGuardado,Exception  ;

    public AccUsuario usuarioLogeado(Long empresa, String usuario);
    public List<AccUsuario> busquedaPorFiltros(AccUsuario usuario);

}
