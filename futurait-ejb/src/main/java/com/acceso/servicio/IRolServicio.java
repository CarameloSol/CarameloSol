/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.servicio;

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
public interface IRolServicio {
      public AccRol obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<AccRol> buscar(AccRol rol);

    public void actualizar(AccRol rol)
            throws RegistroNoGuardado;

    public void eliminar(AccRol rol)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(AccRol rol) throws RegistroNoGuardado;
    
        public List<AccRol> busquedaPorFiltros(AccRol rol);

        
}
