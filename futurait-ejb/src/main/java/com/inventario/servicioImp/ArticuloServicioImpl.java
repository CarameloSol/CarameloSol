/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicioImp;



import com.acceso.modelo.AccUsuario;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.dao.IArticuloDao;
import com.inventario.modelo.InvArticulo;
import com.inventario.servicio.IArticuloServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class ArticuloServicioImpl implements IArticuloServicio {

    @EJB
    IArticuloDao articuloDao;

    @Override
    public List<InvArticulo> buscar(InvArticulo articulo) {
        return articuloDao.buscar(articulo);
    }

    @Override
    public void actualizar(InvArticulo articulo) throws RegistroNoGuardado {
        articuloDao.actualizar(articulo);
    }

    @Override
    public void eliminar(InvArticulo articulo) throws RegistroNoEliminado, RegistroNoLocalizado {
        InvArticulo articuloEliminar= articuloDao.recuperar(articulo.getId());
        articuloDao.eliminar(articuloEliminar);
    }
    private void validacionUsuario(InvArticulo articulo) throws RegistroNoGuardado {
        if (!articulo.getNombre().equals(articulo.getValidacionNombre())) {
            InvArticulo articuloEncontrado = articuloDao.obtenerValidacionNombre(articulo.getNombre());
            if (articuloEncontrado != null) {
                throw new RegistroNoGuardado("El articulo ingresado ya existe");
            }
        }
    }
    @Override
    public void guardar(InvArticulo articulo) throws RegistroNoGuardado {
        validacionUsuario(articulo);
       if (articulo.getId() == null) {
            articuloDao.crear(articulo);
        } else {
            articuloDao.actualizar(articulo);
        }
    }

    @Override
    public List<InvArticulo> busquedaPorFiltros(InvArticulo articulo) {
        return articuloDao.busquedaPorFiltros(articulo);
    }

    @Override
    public InvArticulo obtenerPorId(Long id) throws RegistroNoLocalizado {
        return articuloDao.recuperar(id);
    }

}
