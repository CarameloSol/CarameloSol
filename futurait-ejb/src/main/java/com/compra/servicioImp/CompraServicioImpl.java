/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.servicioImp;



import com.compra.dao.ICompraDao;
import com.compra.modelo.ComCompra;
import com.compra.servicio.ICompraServicio;
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
public class CompraServicioImpl implements ICompraServicio {

    @EJB
    ICompraDao compraDao;

    

    @Override
    public List<ComCompra> buscar(ComCompra compra) {
        return compraDao.buscar(compra);
    }

    @Override
    public void actualizar(ComCompra compra) throws RegistroNoGuardado {
        compraDao.actualizar(compra);
    }

    @Override
    public void eliminar(ComCompra compra) throws RegistroNoEliminado, RegistroNoLocalizado {
        ComCompra compraEliminar = compraDao.recuperar(compra.getId());
        compraDao.eliminar(compraEliminar);
    }

    @Override
    public void guardar(ComCompra compra) throws RegistroNoGuardado, Exception {
        if (compra.getId()==null) {
            compraDao.crear(compra);
        } else {
            compraDao.actualizar(compra);
        }
    }

    @Override
    public List<ComCompra> busquedaPorFiltros(ComCompra compra) {
        return compraDao.busquedaPorFiltros(compra);
    }

   @Override
    public ComCompra obtenerPorId(Long id) throws RegistroNoLocalizado {
        return compraDao.recuperar(id);
    }
}
