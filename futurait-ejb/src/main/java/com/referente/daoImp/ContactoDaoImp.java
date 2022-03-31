/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.referente.dao.IContactoDao;
import com.referente.modelo.RefContacto;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ContactoDaoImp extends GenericDaoImp<RefContacto, Long>
        implements IContactoDao {

    public ContactoDaoImp() {
        super(RefContacto.class);
    }

  
    @Override
    public List<RefContacto> buscar(RefContacto contacto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefContacto t where 1=1");
        if (contacto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", contacto.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<RefContacto> busquedaPorFiltros(RefContacto contacto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefContacto t where 1=1");
        if (contacto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", contacto.getId());
        }

        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
