/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caja.servicioImp;



import com.caja.dao.ICierreCajaDao;
import com.caja.modelo.CajCierreCaja;
import com.caja.servicio.ICierreCajaServicio;
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
public class CierreCajaServicioImpl implements ICierreCajaServicio {

    @EJB
    ICierreCajaDao cierrecajaDao;

    

    @Override
    public List<CajCierreCaja> buscar(CajCierreCaja cierreCaja) {
        return cierrecajaDao.buscar(cierreCaja);
    }

    @Override
    public void actualizar(CajCierreCaja cierreCaja) throws RegistroNoGuardado {
        cierrecajaDao.actualizar(cierreCaja);
    }

    @Override
    public void eliminar(CajCierreCaja cierreCaja) throws RegistroNoEliminado, RegistroNoLocalizado {
        CajCierreCaja cierreCajaEliminar = cierrecajaDao.recuperar(cierreCaja.getId());
        cierrecajaDao.eliminar(cierreCajaEliminar);
    }

    @Override
    public void guardar(CajCierreCaja cierreCaja) throws RegistroNoGuardado {
        if (cierreCaja.getId()==null) {
            cierrecajaDao.crear(cierreCaja);
        } else {
            cierrecajaDao.actualizar(cierreCaja);
        }
    }

    @Override
    public List<CajCierreCaja> busquedaPorFiltros(CajCierreCaja cierreCaja) {
        return cierrecajaDao.busquedaPorFiltros(cierreCaja);
    }

   @Override
    public CajCierreCaja obtenerPorId(Long id) throws RegistroNoLocalizado {
        return cierrecajaDao.recuperar(id);
    }

}
