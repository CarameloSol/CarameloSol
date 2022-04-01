/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.daoImp;

import com.catalogo.dao.ICatalogoDao;
import com.catalogo.modelo.CatCatalogo;
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
public class CatalogoDaoImp extends GenericDaoImp<CatCatalogo, Long>
        implements ICatalogoDao {

    public CatalogoDaoImp() {
        super(CatCatalogo.class);
    }

    @Override
    public List<CatCatalogo> buscar(CatCatalogo catalogo) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from CatCatalogo t where 1=1");
        if (catalogo.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", catalogo.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<CatCatalogo> busquedaPorFiltros(CatCatalogo catalogo) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from CatCatalogo t where 1=1");
        if (catalogo.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", catalogo.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
