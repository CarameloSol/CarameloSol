/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;




import com.generico.daoImp.IGenericoDao;
import com.venta.modelo.VenPedidoVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IPedidoVentaDao extends IGenericoDao<VenPedidoVenta, Long> {

    public List<VenPedidoVenta> buscar(VenPedidoVenta pedidoVenta);

    
    public List<VenPedidoVenta> busquedaPorFiltros(VenPedidoVenta pedidoVenta);
}
