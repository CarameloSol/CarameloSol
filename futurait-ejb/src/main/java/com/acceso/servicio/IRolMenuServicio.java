/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicio;

import com.acceso.modelo.AccRol;
import com.acceso.modelo.AccRolMenu;
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
public interface IRolMenuServicio {
      public AccRolMenu obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<AccRolMenu> buscar(AccRolMenu rolMenu);

    public void actualizar(AccRolMenu rolMenu)
            throws RegistroNoGuardado;

    public void eliminar(AccRolMenu rolMenu)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(AccRolMenu rolMenu) throws RegistroNoGuardado;
    
        public List<AccRolMenu> busquedaPorFiltros(AccRolMenu rolMenu);

        
}
