/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;




import com.generico.daoImp.IGenericoDao;
import com.venta.modelo.VenDetalleNotaCredito;
import com.venta.modelo.VenDetalleNotaCreditoImpuesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleNotaCreditoImpuestoDao extends IGenericoDao<VenDetalleNotaCreditoImpuesto, Long> {

    public List<VenDetalleNotaCreditoImpuesto> buscar(VenDetalleNotaCreditoImpuesto detalleNotaCreditoImpuesto);

    
    public List<VenDetalleNotaCreditoImpuesto> busquedaPorFiltros(VenDetalleNotaCreditoImpuesto detalleNotaCreditoImpuesto);
}
