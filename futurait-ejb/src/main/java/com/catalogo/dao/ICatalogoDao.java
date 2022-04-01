/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.dao;

import com.catalogo.modelo.CatCatalogo;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ICatalogoDao extends IGenericoDao<CatCatalogo, Long> {

    public List<CatCatalogo> buscar(CatCatalogo catalogo);

    
    public List<CatCatalogo> busquedaPorFiltros(CatCatalogo catalogo);
}
