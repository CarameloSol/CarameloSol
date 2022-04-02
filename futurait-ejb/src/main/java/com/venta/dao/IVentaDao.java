/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;




import com.generico.daoImp.IGenericoDao;
import com.venta.modelo.VenVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IVentaDao extends IGenericoDao<VenVenta, Long> {

    public List<VenVenta> buscar(VenVenta venta);

    
    public List<VenVenta> busquedaPorFiltros(VenVenta venta);
}
