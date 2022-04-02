/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.daoImp;

import com.sistema.daoImp.*;
import com.genericos.dao.GenericDaoImp;

import com.referente.dao.IClienteDao;
import com.referente.modelo.RefCliente;
import com.sistema.dao.IEmpresaDao;
import com.sistema.modelo.SisEmpresa;
import com.venta.dao.IDetalleNotaCreditoDao;
import com.venta.modelo.VenDetalleNotaCredito;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleNotaCreditoDaoImp extends GenericDaoImp<VenDetalleNotaCredito, Long>
        implements IDetalleNotaCreditoDao {

    public DetalleNotaCreditoDaoImp() {
        super(VenDetalleNotaCredito.class);
    }
    @Override
    public List<VenDetalleNotaCredito> buscar(VenDetalleNotaCredito detalleNotaCredito) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenDetalleNotaCredito t where 1=1");
        if (detalleNotaCredito.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleNotaCredito.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<VenDetalleNotaCredito> busquedaPorFiltros(VenDetalleNotaCredito detalleNotaCredito) {
         StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from VenDetalleNotaCredito t where 1=1");
        if (detalleNotaCredito.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", detalleNotaCredito.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
