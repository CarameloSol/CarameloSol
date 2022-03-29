/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.dao;
import com.acceso.modelo.AccMenu;

import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IMenuDao extends IGenericoDao<AccMenu, Long>{
        public List<AccMenu> buscar(AccMenu menu);

    public List<AccMenu> busquedaPorFiltros(AccMenu menu);
}
