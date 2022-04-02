/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.daoImp;

import com.compra.modelo.ComDetalleCompra;
import com.genericos.dao.GenericDaoImp;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import com.compra.dao.IDetalleCompraDao;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleCompraDaoImp extends GenericDaoImp<ComDetalleCompra, Long>
        implements IDetalleCompraDao {

    public DetalleCompraDaoImp() {
        super(ComDetalleCompra.class);
    }


    @Override
    public List<ComDetalleCompra> buscar(ComDetalleCompra detalleCompra) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from ComDetalleCompra t where 1=1");
        if (detalleCompra.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleCompra.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<ComDetalleCompra> busquedaPorFiltros(ComDetalleCompra detalleCompra) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from ComDetalleCompra t where 1=1");
        if (detalleCompra.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleCompra.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
