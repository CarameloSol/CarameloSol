/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.dao;

import com.acceso.modelo.AccUsuario;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IUsuarioDao extends IGenericoDao<AccUsuario, Long> {

    public List<AccUsuario> buscar(AccUsuario usuario);

    public AccUsuario usuarioLogeado(Long empresa, String usuario);

    public AccUsuario obtenerValidacionNombre(String nombre);
}
