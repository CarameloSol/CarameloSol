/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.dao;



import com.enumerador.TipoBusquedaVentasEnum;
import com.generico.daoImp.IGenericoDao;
import com.inventario.modelo.InvImpuestoArticulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IImpuestoArticuloDao extends IGenericoDao<InvImpuestoArticulo, Long> {

    public List<InvImpuestoArticulo> buscar(InvImpuestoArticulo impuestoArticulo);

    public InvImpuestoArticulo obtenerValidacionNombre(String nombre);

    public List<InvImpuestoArticulo> busquedaPorFiltros(InvImpuestoArticulo impuestoArticulo);

    public List<InvImpuestoArticulo> busquedaFiltroVentas(String campoBusqueda, TipoBusquedaVentasEnum tipoBusqueda);
}
