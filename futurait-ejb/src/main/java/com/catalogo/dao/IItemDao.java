/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.dao;

import com.catalogo.modelo.CatItem;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IItemDao extends IGenericoDao<CatItem, Long> {

    public List<CatItem> buscar(CatItem item);

    
    public List<CatItem> busquedaPorFiltros(CatItem item);
}
