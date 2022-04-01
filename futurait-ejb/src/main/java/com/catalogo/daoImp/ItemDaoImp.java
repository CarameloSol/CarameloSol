/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.daoImp;

import com.catalogo.dao.IItemDao;
import com.catalogo.modelo.CatItem;
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
public class ItemDaoImp extends GenericDaoImp<CatItem, Long>
        implements IItemDao {

    public ItemDaoImp() {
        super(CatItem.class);
    }

    @Override
    public List<CatItem> buscar(CatItem item) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from CatItem t where 1=1");
        if (item.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", item.getId());
        }
          if (item.getCatalogo() != null) {
            sql.append(" and t.catalogo=:catalogo");
            parametros.put("catalogo", item.getCatalogo());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<CatItem> busquedaPorFiltros(CatItem item) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from CatItem t where 1=1");
        if (item.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", item.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
