/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.dao;

import com.acceso.modelo.AccRolMenu;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IRolMenuDao extends IGenericoDao<AccRolMenu, Long>{
        public List<AccRolMenu> buscar(AccRolMenu rolMenu);

    public List<AccRolMenu> busquedaPorFiltros(AccRolMenu rolMenu);
}
