/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.servicioImp;



import com.compra.dao.ICompraImpuestoDao;
import com.compra.modelo.ComCompraImpuesto;
import com.compra.servicio.ICompraImpuestoServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.sistema.modelo.SisEmpresa;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class CompraImpuestoServicioImpl implements ICompraImpuestoServicio {

    @EJB
    ICompraImpuestoDao compraImpuestoDao;

   
    @Override
    public List<ComCompraImpuesto> buscar(ComCompraImpuesto compraImpuesto) {
        return compraImpuestoDao.buscar(compraImpuesto);
    }

    @Override
    public void actualizar(ComCompraImpuesto compraImpuesto) throws RegistroNoGuardado {
        compraImpuestoDao.actualizar(compraImpuesto);
    }

    @Override
    public void eliminar(ComCompraImpuesto compraImpuesto) throws RegistroNoEliminado, RegistroNoLocalizado {
        ComCompraImpuesto compraImpuestoEliminar = compraImpuestoDao.recuperar(compraImpuesto.getId());
        compraImpuestoDao.eliminar(compraImpuestoEliminar);
    }

    @Override
    public void guardar(ComCompraImpuesto compraImpuesto) throws RegistroNoGuardado, Exception {
        if (compraImpuesto.getId()==null) {
            compraImpuestoDao.crear(compraImpuesto);
        } else {
            compraImpuestoDao.actualizar(compraImpuesto);
        }
    }

    @Override
    public List<ComCompraImpuesto> busquedaPorFiltros(ComCompraImpuesto compraImpuesto) {
        return compraImpuestoDao.busquedaPorFiltros(compraImpuesto);
    }

    @Override
    public ComCompraImpuesto obtenerPorId(Long id) throws RegistroNoLocalizado {
        return compraImpuestoDao.recuperar(id);
    }

}
