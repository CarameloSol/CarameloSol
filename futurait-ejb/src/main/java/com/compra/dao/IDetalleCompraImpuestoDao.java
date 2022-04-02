/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.dao;




import com.compra.modelo.ComDetalleCompra;
import com.compra.modelo.ComDetalleCompraImpuesto;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleCompraImpuestoDao extends IGenericoDao<ComDetalleCompraImpuesto, Long> {

    public List<ComDetalleCompraImpuesto> buscar(ComDetalleCompraImpuesto detalleCompraImpuesto);

    
    public List<ComDetalleCompraImpuesto> busquedaPorFiltros(ComDetalleCompraImpuesto detalleCompraImpuesto);
}
