/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.venta.dao.INotaCreditoDao;
import com.venta.modelo.VenNotaCredito;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class NotaCreditoDaoImp extends GenericDaoImp<VenNotaCredito, Long>
        implements INotaCreditoDao {

    public NotaCreditoDaoImp() {
        super(VenNotaCredito.class);
    }
    
    @Override
    public List<VenNotaCredito> buscar(VenNotaCredito notaCredito) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenNotaCredito t where 1=1");
        if (notaCredito.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", notaCredito.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenNotaCredito> busquedaPorFiltros(VenNotaCredito notaCredito) {
         StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenNotaCredito t where 1=1");
        if (notaCredito.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", notaCredito.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
