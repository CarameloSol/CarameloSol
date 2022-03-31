/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.dao.IPersonaDao;
import com.referente.modelo.RefPersona;
import com.referente.servicio.IPersonaServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class PersonaServicioImpl implements IPersonaServicio {

    @EJB
    IPersonaDao personaDao;

    @Override
    public RefPersona buscar(RefPersona persona) {
        return personaDao.buscar(persona);
    }

   

}
