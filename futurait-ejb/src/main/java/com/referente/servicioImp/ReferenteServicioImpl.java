/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.dao.IReferenteDao;
import com.referente.modelo.RefPersona;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IPersonaServicio;
import com.referente.servicio.IReferenteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ReferenteServicioImpl implements IReferenteServicio {

    @EJB
    IReferenteDao referenteDao;
    @EJB
    IPersonaServicio personaServicio;

    @Override
    public List<RefReferente> buscar(RefReferente referente) {
        return referenteDao.buscar(referente);
    }

    @Override
    public void actualizar(RefReferente referente) throws RegistroNoGuardado {
        referenteDao.actualizar(referente);
    }

    @Override
    public void eliminar(RefReferente referente) throws RegistroNoEliminado, RegistroNoLocalizado {
        RefReferente referenteEliminar = referenteDao.recuperar(referente.getId());
        referenteDao.eliminar(referenteEliminar);
    }

    @Override
    public void guardar(RefReferente referente) throws RegistroNoGuardado, Exception {
        if (referente.getId() == null) {
            referenteDao.crear(referente);
        } else {
            referenteDao.actualizar(referente);
        }
    }

    @Override
    public List<RefReferente> busquedaPorFiltros(RefReferente referente) {
        return referenteDao.busquedaPorFiltros(referente);
    }

    @Override
    public RefReferente obtenerPorId(Long id) throws RegistroNoLocalizado {
        return referenteDao.recuperar(id);
    }

    @Override
    public RefReferente buscarPorIdentificacion(RefReferente referente) {
        return referenteDao.buscarPorIdentificacion(referente);
    }

    @Override
    public RefReferente obtenerDatosReferente(RefReferente referente) {
        RefReferente referenteEncontrado = buscarPorIdentificacion(referente);
        if (referenteEncontrado == null) {
            RefPersona personaEncontrada = personaServicio.buscar(new RefPersona(referente.getIdentificacion()));
            if (personaEncontrada != null) {
                String[] listaNombres = personaEncontrada.getNombres().split(" ");
                String apellido = "";
                String nombre = "";
                if (listaNombres.length == 5) {
                    apellido = listaNombres[0] + " " + listaNombres[1] + " " + listaNombres[2];
                    nombre = listaNombres[3] + " " + listaNombres[4] + " " + listaNombres[5];
                }

                if (listaNombres.length == 5) {
                    apellido = listaNombres[0] + " " + listaNombres[1];
                    nombre = listaNombres[2] + " " + listaNombres[3] + " " + listaNombres[4];
                }

                if (listaNombres.length == 4) {
                    apellido = listaNombres[0] + " " + listaNombres[1];
                    nombre = listaNombres[2] + " " + listaNombres[3];
                }
                if (listaNombres.length == 3) {
                    apellido = listaNombres[0] + " " + listaNombres[1];
                    nombre = listaNombres[2];
                }
                if (listaNombres.length == 2) {
                    apellido = listaNombres[0];
                    nombre = listaNombres[1];
                }

                referente.setNombre(nombre);
                referente.setApellido(apellido);
            } else {
                referente.setNombre("");
                referente.setApellido("");
            }
        } else {
            referente = referenteEncontrado;
        }
        return referente;
    }

}
