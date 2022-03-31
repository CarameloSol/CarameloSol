/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.referente.dao.IProveedorDao;
import com.referente.modelo.RefProveedor;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ProveedorDaoImp extends GenericDaoImp<RefProveedor, Long>
        implements IProveedorDao {

    public ProveedorDaoImp() {
        super(RefProveedor.class);
    }

   
    @Override
    public List<RefProveedor> buscar(RefProveedor proveedor) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefProveedor t where 1=1");
        if (proveedor.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", proveedor.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<RefProveedor> busquedaPorFiltros(RefProveedor proveedor) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefProveedor t where 1=1");
        if (proveedor.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", proveedor.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
