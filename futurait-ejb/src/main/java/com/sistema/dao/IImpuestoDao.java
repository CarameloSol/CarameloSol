/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.dao;




import com.generico.daoImp.IGenericoDao;
import com.sistema.modelo.SisImpuesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IImpuestoDao extends IGenericoDao<SisImpuesto, Long> {

    public List<SisImpuesto> buscar(SisImpuesto impuesto);

    
    public List<SisImpuesto> busquedaPorFiltros(SisImpuesto impuesto);
}
