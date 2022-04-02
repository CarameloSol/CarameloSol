/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;




import com.generico.daoImp.IGenericoDao;
import com.venta.modelo.VenImpuestoNotaCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IImpuestoNotaCreditoDao extends IGenericoDao<VenImpuestoNotaCredito, Long> {

    public List<VenImpuestoNotaCredito> buscar(VenImpuestoNotaCredito impuestoNotaCredito);

    
    public List<VenImpuestoNotaCredito> busquedaPorFiltros(VenImpuestoNotaCredito impuestoNotaCredito);
}
