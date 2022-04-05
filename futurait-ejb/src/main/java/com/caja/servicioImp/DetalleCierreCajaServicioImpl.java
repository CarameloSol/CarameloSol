/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caja.servicioImp;



import com.caja.dao.ICierreCajaDao;
import com.caja.dao.IDetalleCierreCajaDao;
import com.caja.modelo.CajCierreCaja;
import com.caja.modelo.CajDetalleCierreCaja;
import com.caja.servicio.ICierreCajaServicio;
import com.caja.servicio.IDetalleCierreCajaServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleCierreCajaServicioImpl implements IDetalleCierreCajaServicio {

    @EJB
    IDetalleCierreCajaDao detalleCierrecajaDao;

    

    @Override
    public List<CajDetalleCierreCaja> buscar(CajDetalleCierreCaja detalleCierreCaja) {
        return detalleCierrecajaDao.buscar(detalleCierreCaja);
    }

    @Override
    public void actualizar(CajDetalleCierreCaja detalleCierreCaja) throws RegistroNoGuardado {
        detalleCierrecajaDao.actualizar(detalleCierreCaja);
    }

    @Override
    public void eliminar(CajDetalleCierreCaja detalleCierreCaja) throws RegistroNoEliminado, RegistroNoLocalizado {
        CajDetalleCierreCaja detalleCierreCajaEliminar = detalleCierrecajaDao.recuperar(detalleCierreCaja.getId());
        detalleCierrecajaDao.eliminar(detalleCierreCajaEliminar);
    }

    @Override
    public void guardar(CajDetalleCierreCaja detalleCierreCaja) throws RegistroNoGuardado {
        if (detalleCierreCaja.getId()==null) {
            detalleCierrecajaDao.crear(detalleCierreCaja);
        } else {
            detalleCierrecajaDao.actualizar(detalleCierreCaja);
        }
    }

    @Override
    public List<CajDetalleCierreCaja> busquedaPorFiltros(CajDetalleCierreCaja detalleCierreCaja) {
        return detalleCierrecajaDao.busquedaPorFiltros(detalleCierreCaja);
    }

    @Override
    public CajDetalleCierreCaja obtenerPorId(Long id) throws RegistroNoLocalizado {
        return detalleCierrecajaDao.recuperar(id);
    }

    
}
