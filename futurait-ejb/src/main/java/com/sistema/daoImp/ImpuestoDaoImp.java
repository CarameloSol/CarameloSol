/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.sistema.dao.IEmpresaDao;
import com.sistema.dao.IImpuestoDao;
import com.sistema.modelo.SisEmpresa;
import com.sistema.modelo.SisImpuesto;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ImpuestoDaoImp extends GenericDaoImp<SisImpuesto, Long>
        implements IImpuestoDao {

    public ImpuestoDaoImp() {
        super(SisImpuesto.class);
    }

    @Override
    public List<SisImpuesto> buscar(SisImpuesto impuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from SisImpuesto t where 1=1");
        if (impuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", impuesto.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<SisImpuesto> busquedaPorFiltros(SisImpuesto impuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from SisImpuesto t where 1=1");
        if (impuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", impuesto.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
