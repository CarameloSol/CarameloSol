/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caja.daoImp;

import com.caja.dao.ICierreCajaDao;
import com.caja.dao.IDetalleCierreCajaDao;
import com.caja.modelo.CajCierreCaja;
import com.caja.modelo.CajDetalleCierreCaja;
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
public class DetalleCierreCajaDaoImp extends GenericDaoImp<CajDetalleCierreCaja, Long>
        implements IDetalleCierreCajaDao {

    public DetalleCierreCajaDaoImp() {
        super(CajDetalleCierreCaja.class);
    }


    @Override
    public List<CajDetalleCierreCaja> buscar(CajDetalleCierreCaja detalleCierreCaja) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from CajDetalleCierreCaja t where 1=1");
        if (detalleCierreCaja.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleCierreCaja.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<CajDetalleCierreCaja> busquedaPorFiltros(CajDetalleCierreCaja detalleCierreCaja) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from CajDetalleCierreCaja t where 1=1");
        if (detalleCierreCaja.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleCierreCaja.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
