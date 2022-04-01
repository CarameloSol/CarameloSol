/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.servicioImp;

import com.catalogo.dao.IItemDao;
import com.catalogo.modelo.CatItem;
import com.catalogo.servicio.IItemServicio;
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
public class ItemServicioImpl implements IItemServicio {

    @EJB
    IItemDao itemDao;



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
    public void guardar(CatItem item) throws RegistroNoGuardado {
        if (item.getId() == null) {
            item.setEstado(Boolean.TRUE);
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

    @Override
    public void guardarListaItem(List<CatItem> listaItemCrear)throws RegistroNoGuardado {
        for (CatItem catItem : listaItemCrear) {
            guardar(catItem);
        }
    }

    @Override
    public void eliminarItem(List<CatItem> listaItemEliminar)throws RegistroNoEliminado, RegistroNoLocalizado  {
        for (CatItem catItem : listaItemEliminar) {
            eliminar(catItem);
        }
    }

}
