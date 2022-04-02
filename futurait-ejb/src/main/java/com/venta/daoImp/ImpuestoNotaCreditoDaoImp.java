/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.venta.dao.IImpuestoNotaCreditoDao;
import com.venta.modelo.VenImpuestoNotaCredito;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ImpuestoNotaCreditoDaoImp extends GenericDaoImp<VenImpuestoNotaCredito, Long>
        implements IImpuestoNotaCreditoDao {

    public ImpuestoNotaCreditoDaoImp() {
        super(VenImpuestoNotaCredito.class);
    }

    @Override
    public List<VenImpuestoNotaCredito> buscar(VenImpuestoNotaCredito impuestoNotaCredito) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenImpuestoNotaCredito t where 1=1");
        if (impuestoNotaCredito.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", impuestoNotaCredito.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenImpuestoNotaCredito> busquedaPorFiltros(VenImpuestoNotaCredito impuestoNotaCredito) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenImpuestoNotaCredito t where 1=1");
        if (impuestoNotaCredito.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", impuestoNotaCredito.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
