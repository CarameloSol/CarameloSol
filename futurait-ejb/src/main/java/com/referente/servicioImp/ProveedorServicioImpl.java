/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.dao.IProveedorDao;
import com.referente.modelo.RefProveedor;
import com.referente.servicio.IProveedorServicio;
import com.referente.servicio.IReferenteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ProveedorServicioImpl implements IProveedorServicio {

    @EJB
    IProveedorDao proveedorDao;
    @EJB
    IReferenteServicio referenteServicio;

    @Override
    public List<RefProveedor> buscar(RefProveedor proveedor) {
        return proveedorDao.buscar(proveedor);
    }

    @Override
    public void actualizar(RefProveedor proveedor) throws RegistroNoGuardado {
        proveedorDao.actualizar(proveedor);
    }

    @Override
    public void eliminar(RefProveedor proveedor) throws RegistroNoEliminado, RegistroNoLocalizado {
        RefProveedor proveedorEliminar = proveedorDao.recuperar(proveedor.getId());
        proveedorDao.eliminar(proveedorEliminar);
    }

    @Override
    public void guardar(RefProveedor proveedor) throws RegistroNoGuardado {
       referenteServicio.guardar(proveedor.getReferente());
        if (proveedor.getId()== null) {
            proveedorDao.crear(proveedor);
        } else {
            proveedorDao.actualizar(proveedor);
        }
    }

    @Override
    public List<RefProveedor> busquedaPorFiltros(RefProveedor proveedor) {
        return proveedorDao.busquedaPorFiltros(proveedor);
    }

    @Override
    public RefProveedor obtenerPorId(Long id) throws RegistroNoLocalizado {
        return proveedorDao.recuperar(id);
    }

}
