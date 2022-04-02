/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.daoImp;

import com.genericos.dao.GenericDaoImp;
import com.movimiento.dao.IAjusteDao;
import com.movimiento.modelo.MovAjuste;

import com.sistema.dao.IEmpresaDao;
import com.sistema.modelo.SisEmpresa;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class AjusteDaoImp extends GenericDaoImp<MovAjuste, Long>
        implements IAjusteDao {

    public AjusteDaoImp() {
        super(MovAjuste.class);
    }

    @Override
    public List<MovAjuste> buscar(MovAjuste ajuste) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovAjuste t where 1=1");
        if (ajuste.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", ajuste.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<MovAjuste> busquedaPorFiltros(MovAjuste ajuste) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovAjuste t where 1=1");
        if (ajuste.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", ajuste.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
