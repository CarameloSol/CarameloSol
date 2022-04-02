/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.dao;




import com.compra.modelo.ComCompra;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ICompraDao extends IGenericoDao<ComCompra, Long> {

    public List<ComCompra> buscar(ComCompra compra);

    
    public List<ComCompra> busquedaPorFiltros(ComCompra compra);
}
