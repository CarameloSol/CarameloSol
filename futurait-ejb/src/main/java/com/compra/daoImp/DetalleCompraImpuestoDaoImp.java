/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.daoImp;

import com.compra.modelo.ComDetalleCompraImpuesto;
import com.genericos.dao.GenericDaoImp;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import com.compra.dao.IDetalleCompraImpuestoDao;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleCompraImpuestoDaoImp extends GenericDaoImp<ComDetalleCompraImpuesto, Long>
        implements IDetalleCompraImpuestoDao {

    public DetalleCompraImpuestoDaoImp() {
        super(ComDetalleCompraImpuesto.class);
    }


    @Override
    public List<ComDetalleCompraImpuesto> buscar(ComDetalleCompraImpuesto detalleCompraImpuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from ComDetalleCompraImpuesto t where 1=1");
        if (detalleCompraImpuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleCompraImpuesto.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<ComDetalleCompraImpuesto> busquedaPorFiltros(ComDetalleCompraImpuesto detalleCompraImpuesto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from ComDetalleCompraImpuesto t where 1=1");
        if (detalleCompraImpuesto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleCompraImpuesto.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
