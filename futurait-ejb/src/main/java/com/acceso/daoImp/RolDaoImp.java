/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.daoImp;

import com.acceso.dao.IRolDao;
import com.acceso.modelo.AccRol;
import com.genericos.dao.GenericDaoImp;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class RolDaoImp extends GenericDaoImp<AccRol, Long>
        implements IRolDao {

    public RolDaoImp() {
        super(AccRol.class);
    }

    @Override
    public List<AccRol> buscar(AccRol rol) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccRol t where 1=1");
        if (rol.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", rol.getId());
        }

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
