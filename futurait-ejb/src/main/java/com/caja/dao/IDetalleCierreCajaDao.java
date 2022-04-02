/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caja.dao;




import com.caja.modelo.CajDetalleCierreCaja;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleCierreCajaDao extends IGenericoDao<CajDetalleCierreCaja, Long> {

    public List<CajDetalleCierreCaja> buscar(CajDetalleCierreCaja detalleCierreCaja);

    
    public List<CajDetalleCierreCaja> busquedaPorFiltros(CajDetalleCierreCaja detalleCierreCaja);
}
