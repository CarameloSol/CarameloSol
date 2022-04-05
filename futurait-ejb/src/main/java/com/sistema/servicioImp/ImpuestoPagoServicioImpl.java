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
import com.sistema.dao.IFormaPagoDao;
import com.sistema.dao.IImpuestoDao;
import com.sistema.modelo.SisFormaPago;
import com.sistema.modelo.SisImpuesto;
import com.sistema.servicio.IFormaPagoServicio;
import com.sistema.servicio.IImpuestoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class ImpuestoPagoServicioImpl implements IImpuestoServicio {

    @EJB
    IImpuestoDao impuestoDao;

   @EJB
    IReferenteServicio referenteServicio;

   

    @Override
    public List<SisImpuesto> buscar(SisImpuesto impuesto) {
        return impuestoDao.buscar(impuesto);
    }

    @Override
    public void actualizar(SisImpuesto impuesto) throws RegistroNoGuardado {
        impuestoDao.actualizar(impuesto);
    }

    @Override
    public void eliminar(SisImpuesto impuesto) throws RegistroNoEliminado, RegistroNoLocalizado {
        SisImpuesto impuestoEliminar = impuestoDao.recuperar(impuesto.getId());
        impuestoDao.eliminar(impuestoEliminar);
    }

    @Override
    public void guardar(SisImpuesto impuesto) throws RegistroNoGuardado {
        impuesto.setEstado(Boolean.TRUE);
        if (impuesto.getId()== null) {
            impuestoDao.crear(impuesto);
        } else {
            impuestoDao.actualizar(impuesto);
        }
    }

    @Override
    public List<SisImpuesto> busquedaPorFiltros(SisImpuesto impuesto) {
        return impuestoDao.busquedaPorFiltros(impuesto);
    }

   @Override
    public SisImpuesto obtenerPorId(Long id) throws RegistroNoLocalizado {
        return impuestoDao.recuperar(id);
    }
    
}
