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
import com.sistema.modelo.SisFormaPago;
import com.sistema.servicio.IFormaPagoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class FormaPagoServicioImpl implements IFormaPagoServicio {

    @EJB
    IFormaPagoDao formaPagoDao;

   @EJB
    IReferenteServicio referenteServicio;

  
    @Override
    public List<SisFormaPago> buscar(SisFormaPago formaPago) {
        return formaPagoDao.buscar(formaPago);
    }

    @Override
    public void actualizar(SisFormaPago formaPago) throws RegistroNoGuardado {
        formaPagoDao.actualizar(formaPago);
    }

    @Override
    public void eliminar(SisFormaPago formaPago) throws RegistroNoEliminado, RegistroNoLocalizado {
        SisFormaPago formaPagoEliminar = formaPagoDao.recuperar(formaPago.getId());
        formaPagoDao.eliminar(formaPagoEliminar);
    }

    @Override
    public void guardar(SisFormaPago formaPago) throws RegistroNoGuardado, Exception {
        formaPago.setEstado(Boolean.TRUE);
        if (formaPago.getId()==null) {
            formaPagoDao.crear(formaPago);
        } else {
            formaPagoDao.actualizar(formaPago);
        }
    }

    @Override
    public List<SisFormaPago> busquedaPorFiltros(SisFormaPago formaPago) {
        return formaPagoDao.busquedaPorFiltros(formaPago);
    }

      @Override
    public SisFormaPago obtenerPorId(Long id) throws RegistroNoLocalizado {
        return formaPagoDao.recuperar(id);
    }

}
