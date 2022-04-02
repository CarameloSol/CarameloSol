/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.venta.dao.IDetalleNotaCreditoImpuestoDao;
import com.venta.modelo.VenDetalleNotaCreditoImpuesto;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleNotaCreditoImpuestoDaoImp extends GenericDaoImp<VenDetalleNotaCreditoImpuesto, Long>
        implements IDetalleNotaCreditoImpuestoDao {

    public DetalleNotaCreditoImpuestoDaoImp() {
        super(VenDetalleNotaCreditoImpuesto.class);
    }
    
    @Override
    public List<VenDetalleNotaCreditoImpuesto> buscar(VenDetalleNotaCreditoImpuesto detalleNotaCreditoImpuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenDetalleNotaCreditoImpuesto t where 1=1");
        if (detalleNotaCreditoImpuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleNotaCreditoImpuesto.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenDetalleNotaCreditoImpuesto> busquedaPorFiltros(VenDetalleNotaCreditoImpuesto detalleNotaCreditoImpuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenDetalleNotaCreditoImpuesto t where 1=1");
        if (detalleNotaCreditoImpuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleNotaCreditoImpuesto.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
