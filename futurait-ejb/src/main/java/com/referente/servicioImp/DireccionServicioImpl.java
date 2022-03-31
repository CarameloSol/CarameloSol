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
import com.referente.dao.IDireccionDao;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefDireccion;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IDireccionServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DireccionServicioImpl implements IDireccionServicio {

    @EJB
    IDireccionDao direccionDao;

    @Override
    public List<RefDireccion> buscar(RefDireccion direccion) {
        return direccionDao.buscar(direccion);
    }

    @Override
    public void actualizar(RefDireccion direccion) throws RegistroNoGuardado {
        direccionDao.actualizar(direccion);
    }

    @Override
    public void eliminar(RefDireccion direccion) throws RegistroNoEliminado, RegistroNoLocalizado {
        RefDireccion direccionEliminar = direccionDao.recuperar(direccion.getId());
        direccionDao.eliminar(direccionEliminar);
    }

    @Override
    public void guardar(RefDireccion direccion) throws RegistroNoGuardado, Exception {
        if (direccion.getId()== null) {
            direccionDao.crear(direccion);
        } else {
            direccionDao.actualizar(direccion);
        }
    }

    @Override
    public List<RefDireccion> busquedaPorFiltros(RefDireccion direccion) {
        return direccionDao.busquedaPorFiltros(direccion);
    }

    @Override
    public RefDireccion obtenerPorId(Long id) throws RegistroNoLocalizado {
        return direccionDao.recuperar(id);
    }

}
