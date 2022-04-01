/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.servicioImp;



import com.catalogo.dao.ICatalogoDao;
import com.catalogo.modelo.CatCatalogo;
import com.catalogo.servicio.ICatalogoServicio;
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
public class CatalogoServicioImpl implements ICatalogoServicio {

    @EJB
    ICatalogoDao catalogoDao;

   @EJB
    ICatalogoServicio catalogoServicio;

    
    @Override
    public List<CatCatalogo> buscar(CatCatalogo catalogo) {
        return catalogoDao.buscar(catalogo);
    }

    @Override
    public void actualizar(CatCatalogo catalogo) throws RegistroNoGuardado {
        catalogoDao.actualizar(catalogo);
    }

    @Override
    public void eliminar(CatCatalogo catalogo) throws RegistroNoEliminado, RegistroNoLocalizado {
        CatCatalogo catalogoEliminar = catalogoDao.recuperar(catalogo.getId());
        catalogoDao.eliminar(catalogoEliminar);
    }

    @Override
    public void guardar(CatCatalogo catalogo) throws RegistroNoGuardado, Exception {
        catalogo.setEstado(Boolean.TRUE);
        if (catalogo.getId()== null) {
            catalogoDao.crear(catalogo);
        } else {
            catalogoDao.actualizar(catalogo);
        }
    }

    @Override
    public List<CatCatalogo> busquedaPorFiltros(CatCatalogo catalogo) {
        return catalogoDao.busquedaPorFiltros(catalogo);
    }

    @Override
    public CatCatalogo obtenerPorId(Long id) throws RegistroNoLocalizado {
        return catalogoDao.recuperar(id);
    }

}
