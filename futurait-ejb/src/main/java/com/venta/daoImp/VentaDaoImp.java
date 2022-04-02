/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.venta.dao.IVentaDao;
import com.venta.modelo.VenVenta;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class VentaDaoImp extends GenericDaoImp<VenVenta, Long>
        implements IVentaDao {

    public VentaDaoImp() {
        super(VenVenta.class);
    }


    @Override
    public List<VenVenta> buscar(VenVenta venta) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenVenta t where 1=1");
        if (venta.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", venta.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenVenta> busquedaPorFiltros(VenVenta venta) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenVenta t where 1=1");
        if (venta.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", venta.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
