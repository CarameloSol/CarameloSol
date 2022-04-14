/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.dao;



import com.enumerador.TipoBusquedaVentasEnum;
import com.generico.daoImp.IGenericoDao;
import com.inventario.modelo.InvArticulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IArticuloDao extends IGenericoDao<InvArticulo, Long> {

    public List<InvArticulo> buscar(InvArticulo articulo);

    public InvArticulo obtenerValidacionNombre(String nombre);

    public List<InvArticulo> busquedaPorFiltros(InvArticulo articulo);

    public List<InvArticulo> busquedaFiltroVentas(String campoBusqueda, TipoBusquedaVentasEnum tipoBusqueda);
}
