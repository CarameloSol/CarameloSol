/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicioImp;

import com.inventario.servicioImp.*;
import com.acceso.modelo.AccUsuario;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.dao.IArticuloDao;
import com.inventario.modelo.InvArticulo;
import com.inventario.servicio.IArticuloServicio;
import com.referente.dao.IClienteDao;
import com.referente.dao.IReferenteDao;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefReferente;
import com.referente.servicio.IClienteServicio;
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
        if (referente.getId()== null) {
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

}
