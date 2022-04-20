/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicioImp;

import com.enumerador.TipoBusquedaVentasEnum;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.dao.IImpuestoArticuloDao;
import com.inventario.modelo.InvImpuestoArticulo;
import com.inventario.servicio.IImpuestoArticuloServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ImpuestoArticuloServicioImpl implements IImpuestoArticuloServicio {

    @EJB
    IImpuestoArticuloDao impuestoArticuloDao;
    
    
    @Override
    public List<InvImpuestoArticulo> buscar(InvImpuestoArticulo impuestoArticulo) {
        return impuestoArticuloDao.buscar(impuestoArticulo);
    }

    @Override
    public void actualizar(InvImpuestoArticulo impuestoArticulo) throws RegistroNoGuardado {
        impuestoArticuloDao.actualizar(impuestoArticulo);
    }

    @Override
    public void eliminar(InvImpuestoArticulo impuestoArticulo) throws RegistroNoEliminado, RegistroNoLocalizado {
        InvImpuestoArticulo impuestoArticuloEliminar = impuestoArticuloDao.recuperar(impuestoArticulo.getId());
        impuestoArticuloDao.eliminar(impuestoArticuloEliminar);
    }

    @Override
    public void guardar(InvImpuestoArticulo impuestoArticulo) throws RegistroNoGuardado {
        if (impuestoArticulo.getId()==null) {
            impuestoArticuloDao.crear(impuestoArticulo);
        } else {
            impuestoArticuloDao.actualizar(impuestoArticulo);
        }
    }

    @Override
    public List<InvImpuestoArticulo> busquedaPorFiltros(InvImpuestoArticulo impuestoArticulo) {
        return impuestoArticuloDao.busquedaPorFiltros(impuestoArticulo);
    }

    @Override
    public List<InvImpuestoArticulo> busquedaFiltroVentas(String campoBusqueda, TipoBusquedaVentasEnum tipoBusqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InvImpuestoArticulo obtenerPorId(Long id) throws RegistroNoLocalizado {
        return impuestoArticuloDao.recuperar(id);
    }

}
