/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.dao;




import com.generico.daoImp.IGenericoDao;
import com.sistema.modelo.SisEmpresa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IEmpresaDao extends IGenericoDao<SisEmpresa, Long> {

    public List<SisEmpresa> buscar(SisEmpresa empresa);

    
    public List<SisEmpresa> busquedaPorFiltros(SisEmpresa empresa);
}
