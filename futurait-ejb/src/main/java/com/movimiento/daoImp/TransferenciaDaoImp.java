/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.daoImp;

import com.genericos.dao.GenericDaoImp;
import com.movimiento.dao.IKardexDao;
import com.movimiento.dao.ITransferenciaDao;
import com.movimiento.modelo.MovKardex;
import com.movimiento.modelo.MovTransferencia;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class TransferenciaDaoImp extends GenericDaoImp<MovTransferencia, Long>
        implements ITransferenciaDao {

    public TransferenciaDaoImp() {
        super(MovTransferencia.class);
    }


    @Override
    public List<MovTransferencia> buscar(MovTransferencia transferencia) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovTransferencia t where 1=1");
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
    public List<MovTransferencia> busquedaPorFiltros(MovTransferencia transferencia) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovTransferencia t where 1=1");
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