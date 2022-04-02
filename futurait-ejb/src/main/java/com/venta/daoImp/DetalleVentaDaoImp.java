/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.venta.dao.IDetalleVentaDao;
import com.venta.modelo.VenDetalleVenta;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleVentaDaoImp extends GenericDaoImp<VenDetalleVenta, Long>
        implements IDetalleVentaDao {

    public DetalleVentaDaoImp() {
        super(VenDetalleVenta.class);
    }

    @Override
    public List<VenDetalleVenta> buscar(VenDetalleVenta detalleVenta) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenDetalleVenta t where 1=1");
        if (detalleVenta.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleVenta.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenDetalleVenta> busquedaPorFiltros(VenDetalleVenta detalleVenta) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenDetalleVenta t where 1=1");
        if (detalleVenta.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleVenta.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
