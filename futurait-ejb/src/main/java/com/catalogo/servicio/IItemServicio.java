/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.servicio;




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
public interface IItemServicio {

    public CatItem obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<CatItem> buscar(CatItem item);

    public void actualizar(CatItem item)
            throws RegistroNoGuardado;

    public void eliminar(CatItem item)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(CatItem item) throws RegistroNoGuardado,Exception ;

   
    public List<CatItem> busquedaPorFiltros(CatItem item);

}
