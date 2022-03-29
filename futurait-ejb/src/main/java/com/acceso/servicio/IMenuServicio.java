/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicio;

import com.acceso.modelo.AccMenu;
import com.acceso.modelo.AccRol;
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
public interface IMenuServicio {
      public AccMenu obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<AccMenu> buscar(AccMenu menu);

    public void actualizar(AccMenu menu)
            throws RegistroNoGuardado;

    public void eliminar(AccMenu menu)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(AccMenu menu) throws RegistroNoGuardado;
    
        public List<AccMenu> busquedaPorFiltros(AccMenu menu);

        
}
