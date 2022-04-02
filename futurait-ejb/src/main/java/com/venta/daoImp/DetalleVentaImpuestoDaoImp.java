/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.venta.dao.IDetalleVentaImpuestoDao;
import com.venta.modelo.VenDetalleVentaImpuesto;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleVentaImpuestoDaoImp extends GenericDaoImp<VenDetalleVentaImpuesto, Long>
        implements IDetalleVentaImpuestoDao {

    public DetalleVentaImpuestoDaoImp() {
        super(VenDetalleVentaImpuesto.class);
    }

    @Override
    public List<VenDetalleVentaImpuesto> buscar(VenDetalleVentaImpuesto detalleVentaImpuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenDetalleVentaImpuesto t where 1=1");
        if (detalleVentaImpuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleVentaImpuesto.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenDetalleVentaImpuesto> busquedaPorFiltros(VenDetalleVentaImpuesto detalleVentaImpuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenDetalleVentaImpuesto t where 1=1");
        if (detalleVentaImpuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleVentaImpuesto.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
