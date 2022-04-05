/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.servicioImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.servicio.IReferenteServicio;
import com.sistema.dao.IEmpresaDao;
import com.sistema.modelo.SisEmpresa;
import com.sistema.servicio.IEmpresaServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class EmpresaServicioImpl implements IEmpresaServicio {

    @EJB
    IEmpresaDao empresaDao;

    @EJB
    IReferenteServicio referenteServicio;

    @Override
    public List<SisEmpresa> buscar(SisEmpresa empresa) {
        return empresaDao.buscar(empresa);
    }

    @Override
    public void actualizar(SisEmpresa empresa) throws RegistroNoGuardado {
        empresaDao.actualizar(empresa);
    }

    @Override
    public void eliminar(SisEmpresa empresa) throws RegistroNoEliminado, RegistroNoLocalizado {
        SisEmpresa empresaEliminar = empresaDao.recuperar(empresa.getId());
        empresaDao.eliminar(empresaEliminar);
    }

    @Override
    public void guardar(SisEmpresa empresa) throws RegistroNoGuardado{
        referenteServicio.guardar(empresa.getReferente());
        if (empresa.getId() == null) {
             empresaDao.crear(empresa);
        } else {
            empresaDao.actualizar(empresa);
        }
    }

    @Override
    public List<SisEmpresa> busquedaPorFiltros(SisEmpresa empresa) {
        return empresaDao.busquedaPorFiltros(empresa);
    }

    @Override
    public SisEmpresa obtenerPorId(Long id) throws RegistroNoLocalizado {
        return empresaDao.recuperar(id);
    }

}
