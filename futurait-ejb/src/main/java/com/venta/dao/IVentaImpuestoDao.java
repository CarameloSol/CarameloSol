/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;




import com.generico.daoImp.IGenericoDao;
import com.venta.modelo.VenVenta;
import com.venta.modelo.VenVentaImpuesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IVentaImpuestoDao extends IGenericoDao<VenVentaImpuesto, Long> {

    public List<VenVentaImpuesto> buscar(VenVentaImpuesto ventaImpuesto);

    
    public List<VenVentaImpuesto> busquedaPorFiltros(VenVentaImpuesto ventaImpuesto);
}
