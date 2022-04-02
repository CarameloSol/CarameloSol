/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;




import com.generico.daoImp.IGenericoDao;
import com.venta.modelo.VenNotaCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface INotaCreditoDao extends IGenericoDao<VenNotaCredito, Long> {

    public List<VenNotaCredito> buscar(VenNotaCredito notaCredito);

    
    public List<VenNotaCredito> busquedaPorFiltros(VenNotaCredito notaCredito);
}
