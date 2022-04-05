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
import com.inventario.modelo.InvCategoria;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.inventario.dao.ICategoriaDao;
import com.inventario.servicio.ICategoriaServicio;


/**
 *
 * @author Ricardo
 */
@Stateless
public class CategoriaServicioImpl implements ICategoriaServicio {

    @EJB
    ICategoriaDao categoriaDao;

   

    @Override
    public List<InvCategoria> buscar(InvCategoria categoria) {
        return categoriaDao.buscar(categoria);
    }

    @Override
    public void actualizar(InvCategoria categoria) throws RegistroNoGuardado {
        categoriaDao.actualizar(categoria);
    }

    @Override
    public void eliminar(InvCategoria categoria) throws RegistroNoEliminado, RegistroNoLocalizado {
        InvCategoria categoriaEliminar= categoriaDao.recuperar(categoria.getId());
        categoriaDao.eliminar(categoriaEliminar);
    }
    private void validacionCategoria(InvCategoria categoria) throws RegistroNoGuardado {
        if (!categoria.getNombre().equals(categoria.getValidacionNombre())) {
            InvCategoria categoriaEncontrado = categoriaDao.obtenerValidacionNombre(categoria.getNombre());
            if (categoriaEncontrado != null) {
                throw new RegistroNoGuardado("La clasificasion ingresada ya existe");
            }
        }
    }
    @Override
    public void guardar(InvCategoria categoria) throws RegistroNoGuardado {
        validacionCategoria(categoria);
        if (categoria.getId()==null) {
            categoriaDao.crear(categoria);
        } else {
            categoriaDao.actualizar(categoria);
        }
    }

    @Override
    public List<InvCategoria> busquedaPorFiltros(InvCategoria categoria) {
        return categoriaDao.busquedaPorFiltros(categoria);
    }

    @Override
    public InvCategoria obtenerPorId(Long id) throws RegistroNoLocalizado {
        return categoriaDao.recuperar(id);
    }

}
