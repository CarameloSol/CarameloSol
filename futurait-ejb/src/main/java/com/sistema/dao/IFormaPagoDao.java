/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.dao;




import com.generico.daoImp.IGenericoDao;
import com.sistema.modelo.SisFormaPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IFormaPagoDao extends IGenericoDao<SisFormaPago, Long> {

    public List<SisFormaPago> buscar(SisFormaPago formaPago);

    
    public List<SisFormaPago> busquedaPorFiltros(SisFormaPago formaPago);
}
