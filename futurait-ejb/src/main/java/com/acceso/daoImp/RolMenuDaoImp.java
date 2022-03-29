/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.daoImp;


import com.acceso.dao.IRolMenuDao;

import com.acceso.modelo.AccRolMenu;
import com.genericos.dao.GenericDaoImp;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class RolMenuDaoImp extends GenericDaoImp<AccRolMenu, Long>
        implements IRolMenuDao {

    public RolMenuDaoImp() {
        super(AccRolMenu.class);
    }

  

    @Override
    public List<AccRolMenu> buscar(AccRolMenu rolMenu) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccRolMenu t where 1=1");
        if (rolMenu.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", rolMenu.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<AccRolMenu> busquedaPorFiltros(AccRolMenu rolMenu) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccRolMenu t where 1=1");
        if (rolMenu.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", rolMenu.getId());
        }
        if (rolMenu.getDescripcion()!= null) {
            String parametroBusqueda = rolMenu.getDescripcion().toLowerCase().replaceAll(" ", "%_%");
            sql.append(" and LOWER(t.descripcion) like :descripcion");
            parametros.put("descripcion", "%" + parametroBusqueda + "%");
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
