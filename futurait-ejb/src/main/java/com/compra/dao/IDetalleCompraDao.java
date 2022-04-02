/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.dao;




import com.compra.modelo.ComDetalleCompra;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleCompraDao extends IGenericoDao<ComDetalleCompra, Long> {

    public List<ComDetalleCompra> buscar(ComDetalleCompra detalleCompra);

    
    public List<ComDetalleCompra> busquedaPorFiltros(ComDetalleCompra detalleCompra);
}
