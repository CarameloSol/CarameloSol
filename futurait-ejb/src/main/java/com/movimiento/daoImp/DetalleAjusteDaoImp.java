/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.daoImp;

import com.genericos.dao.GenericDaoImp;
import com.movimiento.dao.IAjusteDao;
import com.movimiento.dao.IDetalleAjusteDao;
import com.movimiento.modelo.MovAjuste;
import com.movimiento.modelo.MovDetalleAjuste;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleAjusteDaoImp extends GenericDaoImp<MovDetalleAjuste, Long>
        implements IDetalleAjusteDao {

    public DetalleAjusteDaoImp() {
        super(MovDetalleAjuste.class);
    }

    @Override
    public List<MovDetalleAjuste> buscar(MovDetalleAjuste detalleAjuste) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovDetalleAjuste t where 1=1");
        if (detalleAjuste.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleAjuste.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<MovDetalleAjuste> busquedaPorFiltros(MovDetalleAjuste detalleAjuste) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovDetalleAjuste t where 1=1");
        if (detalleAjuste.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleAjuste.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
