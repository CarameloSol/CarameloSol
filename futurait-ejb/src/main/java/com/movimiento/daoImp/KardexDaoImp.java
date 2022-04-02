/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.daoImp;

import com.genericos.dao.GenericDaoImp;
import com.movimiento.dao.IDetalleTransferenciaDao;
import com.movimiento.dao.IKardexDao;
import com.movimiento.modelo.MovDetalleTransferencia;
import com.movimiento.modelo.MovKardex;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class KardexDaoImp extends GenericDaoImp<MovKardex, Long>
        implements IKardexDao {

    public KardexDaoImp() {
        super(MovKardex.class);
    }



    @Override
    public List<MovKardex> buscar(MovKardex kardex) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovKardex t where 1=1");
        if (kardex.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", kardex.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<MovKardex> busquedaPorFiltros(MovKardex kardex) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from MovKardex t where 1=1");
        if (kardex.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", kardex.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
}