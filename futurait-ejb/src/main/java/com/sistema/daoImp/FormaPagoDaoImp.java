/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.sistema.dao.IEmpresaDao;
import com.sistema.dao.IFormaPagoDao;
import com.sistema.modelo.SisEmpresa;
import com.sistema.modelo.SisFormaPago;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class FormaPagoDaoImp extends GenericDaoImp<SisFormaPago, Long>
        implements IFormaPagoDao {

    public FormaPagoDaoImp() {
        super(SisFormaPago.class);
    }

    @Override
    public List<SisFormaPago> buscar(SisFormaPago formaPago) {
       StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from SisFormaPago t where 1=1");
        if (formaPago.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", formaPago.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList(); 
    }

    @Override
    public List<SisFormaPago> busquedaPorFiltros(SisFormaPago formaPago) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from SisFormaPago t where 1=1");
        if (formaPago.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", formaPago.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
