/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;




import com.generico.daoImp.IGenericoDao;
import com.venta.modelo.VenDetalleVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleVentaDao extends IGenericoDao<VenDetalleVenta, Long> {

    public List<VenDetalleVenta> buscar(VenDetalleVenta detalleVenta);

    
    public List<VenDetalleVenta> busquedaPorFiltros(VenDetalleVenta detalleVenta);
}
