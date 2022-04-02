/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.venta.dao.IVentaImpuestoDao;
import com.venta.modelo.VenVentaImpuesto;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class VentaImpuestoDaoImp extends GenericDaoImp<VenVentaImpuesto, Long>
        implements IVentaImpuestoDao {

    public VentaImpuestoDaoImp() {
        super(VenVentaImpuesto.class);
    }

    @Override
    public List<VenVentaImpuesto> buscar(VenVentaImpuesto ventaImpuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenVentaImpuesto t where 1=1");
        if (ventaImpuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", ventaImpuesto.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenVentaImpuesto> busquedaPorFiltros(VenVentaImpuesto ventaImpuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenVentaImpuesto t where 1=1");
        if (ventaImpuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", ventaImpuesto.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
