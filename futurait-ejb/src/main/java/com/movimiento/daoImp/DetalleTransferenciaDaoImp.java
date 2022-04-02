/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.daoImp;

import com.genericos.dao.GenericDaoImp;
import com.movimiento.dao.IDetalleTransferenciaDao;
import com.movimiento.modelo.MovDetalleTransferencia;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DetalleTransferenciaDaoImp extends GenericDaoImp<MovDetalleTransferencia, Long>
        implements IDetalleTransferenciaDao {

    public DetalleTransferenciaDaoImp() {
        super(MovDetalleTransferencia.class);
    }


    @Override
    public List<MovDetalleTransferencia> buscar(MovDetalleTransferencia transferencia) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovDetalleTransferencia t where 1=1");
        if (transferencia.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", transferencia.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<MovDetalleTransferencia> busquedaPorFiltros(MovDetalleTransferencia transferencia) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovDetalleTransferencia t where 1=1");
        if (transferencia.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", transferencia.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
}