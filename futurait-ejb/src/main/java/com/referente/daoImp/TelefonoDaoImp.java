/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.referente.dao.IClienteDao;
import com.referente.dao.ITelefonoDao;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefTelefono;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class TelefonoDaoImp extends GenericDaoImp<RefTelefono, Long>
        implements ITelefonoDao {

    public TelefonoDaoImp() {
        super(RefTelefono.class);
    }

 
    @Override
    public List<RefTelefono> buscar(RefTelefono telefono) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefTelefono t where 1=1");
        if (telefono.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", telefono.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<RefTelefono> busquedaPorFiltros(RefTelefono telefono) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefTelefono t where 1=1");
        if (telefono.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", telefono.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
