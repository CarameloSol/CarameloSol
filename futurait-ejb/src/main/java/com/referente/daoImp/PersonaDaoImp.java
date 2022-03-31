/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.daoImp;

import com.genericos.dao.GenericDaoImp;
import com.referente.dao.IPersonaDao;
import com.referente.modelo.RefPersona;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class PersonaDaoImp extends GenericDaoImp<RefPersona, Long>
        implements IPersonaDao {

    public PersonaDaoImp() {
        super(RefPersona.class);
    }

    @Override
    public RefPersona buscar(RefPersona persona) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefPersona t where 1=1");

        if (persona.getCedula() != null) {
            sql.append(" and t.cedula=:cedula");
            parametros.put("cedula", persona.getCedula());
        }
        Query q = this.em.createQuery(sql.toString());

        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        try {
            return (RefPersona) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

}
