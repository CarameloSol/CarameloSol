/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.servicio;




import com.catalogo.modelo.CatCatalogo;
import com.catalogo.modelo.CatItem;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ICatalogoServicio {

    public CatCatalogo obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<CatCatalogo> buscar(CatCatalogo catalogo);

    public void actualizar(CatCatalogo catalogo)
            throws RegistroNoGuardado;

    public void eliminar(CatCatalogo catalogo)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(CatCatalogo catalogo, List<CatItem> listaItemCrear, List<CatItem> listaItemEliminar) throws RegistroNoGuardado,Exception ;

   
    public List<CatCatalogo> busquedaPorFiltros(CatCatalogo catalogo);

}
