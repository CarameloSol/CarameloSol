/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caja.dao;




import com.caja.modelo.CajCierreCaja;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ICierreCajaDao extends IGenericoDao<CajCierreCaja, Long> {

    public List<CajCierreCaja> buscar(CajCierreCaja cierreCaja);

    
    public List<CajCierreCaja> busquedaPorFiltros(CajCierreCaja cierreCaja);
}
