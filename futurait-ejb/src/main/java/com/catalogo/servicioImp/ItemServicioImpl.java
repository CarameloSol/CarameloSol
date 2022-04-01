/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.servicioImp;



import com.catalogo.dao.ICatalogoDao;
import com.catalogo.dao.IItemDao;
import com.catalogo.modelo.CatCatalogo;
import com.catalogo.modelo.CatItem;
import com.catalogo.servicio.ICatalogoServicio;
import com.catalogo.servicio.IItemServicio;
import com.referente.servicioImp.*;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.dao.IClienteDao;
import com.referente.modelo.RefCliente;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IReferenteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class ItemServicioImpl implements IItemServicio {

    @EJB
    IItemDao itemDao;

   @EJB
    ICatalogoServicio catalogoServicio;

   

    @Override
    public List<CatItem> buscar(CatItem item) {
        return itemDao.buscar(item);
    }

    @Override
    public void actualizar(CatItem item) throws RegistroNoGuardado {
        itemDao.actualizar(item);
    }

    @Override
    public void eliminar(CatItem item) throws RegistroNoEliminado, RegistroNoLocalizado {
        CatItem itemEliminar = itemDao.recuperar(item.getId());
        itemDao.eliminar(itemEliminar);
    }

    @Override
    public void guardar(CatItem item) throws RegistroNoGuardado, Exception {
        item.setEstado(Boolean.TRUE);
        catalogoServicio.guardar(item.getCatalogo());
        if (item.getId()== null) {
            itemDao.crear(item);
        } else {
            itemDao.actualizar(item);
        }
    }

    @Override
    public List<CatItem> busquedaPorFiltros(CatItem item) {
        return itemDao.busquedaPorFiltros(item);
    }

     @Override
    public CatItem obtenerPorId(Long id) throws RegistroNoLocalizado {
        return itemDao.recuperar(id);
    }
    
}
