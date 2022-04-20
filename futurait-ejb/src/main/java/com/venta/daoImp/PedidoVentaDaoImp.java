/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.genericos.dao.GenericDaoImp;
import com.venta.dao.IPedidoVentaDao;

import com.venta.modelo.VenPedidoVenta;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class PedidoVentaDaoImp extends GenericDaoImp<VenPedidoVenta, Long>
        implements IPedidoVentaDao {

    public PedidoVentaDaoImp() {
        super(VenPedidoVenta.class);
    }

    @Override
    public List<VenPedidoVenta> buscar(VenPedidoVenta pedidoVenta) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenPedidoVenta t where 1=1");
        if (pedidoVenta.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", pedidoVenta.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenPedidoVenta> busquedaPorFiltros(VenPedidoVenta pedidoVenta) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenPedidoVenta t where 1=1");
        if (pedidoVenta.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", pedidoVenta.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }


   
    

    }
