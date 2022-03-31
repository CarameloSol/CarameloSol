/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.daoImp;

import com.genericos.dao.GenericDaoImp;
import com.referente.dao.IClienteDao;
import com.referente.dao.IDireccionDao;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefDireccion;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class DireccionDaoImp extends GenericDaoImp<RefDireccion, Long>
        implements IDireccionDao {

    public DireccionDaoImp() {
        super(RefDireccion.class);
    }

    @Override
    public List<RefDireccion> buscar(RefDireccion direccion) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefDireccion t where 1=1");
        if (direccion.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", direccion.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<RefDireccion> busquedaPorFiltros(RefDireccion direccion) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefDireccion t where 1=1");
        if (direccion.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", direccion.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
