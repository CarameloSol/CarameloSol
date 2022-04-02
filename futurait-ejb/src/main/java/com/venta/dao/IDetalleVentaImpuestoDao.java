/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;




import com.generico.daoImp.IGenericoDao;
import com.venta.modelo.VenDetalleVentaImpuesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleVentaImpuestoDao extends IGenericoDao<VenDetalleVentaImpuesto, Long> {

    public List<VenDetalleVentaImpuesto> buscar(VenDetalleVentaImpuesto detalleVentaImpuesto);

    
    public List<VenDetalleVentaImpuesto> busquedaPorFiltros(VenDetalleVentaImpuesto detalleVentaImpuesto);
}
