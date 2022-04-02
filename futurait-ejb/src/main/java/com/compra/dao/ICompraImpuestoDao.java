/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.dao;




import com.compra.modelo.ComCompraImpuesto;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ICompraImpuestoDao extends IGenericoDao<ComCompraImpuesto, Long> {

    public List<ComCompraImpuesto> buscar(ComCompraImpuesto compraImpuesto);

    
    public List<ComCompraImpuesto> busquedaPorFiltros(ComCompraImpuesto compraImpuesto);
}
