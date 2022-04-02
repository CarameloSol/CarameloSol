/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caja.daoImp;

import com.caja.dao.ICierreCajaDao;
import com.caja.modelo.CajCierreCaja;
import com.genericos.dao.GenericDaoImp;

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
public class CierreCajaDaoImp extends GenericDaoImp<CajCierreCaja, Long>
        implements ICierreCajaDao {

    public CierreCajaDaoImp() {
        super(CajCierreCaja.class);
    }

    @Override
    public List<CajCierreCaja> buscar(CajCierreCaja cierreCaja) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from CajCierreCaja t where 1=1");
        if (cierreCaja.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", cierreCaja.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<CajCierreCaja> busquedaPorFiltros(CajCierreCaja cierreCaja) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from CajCierreCaja t where 1=1");
        if (cierreCaja.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", cierreCaja.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
