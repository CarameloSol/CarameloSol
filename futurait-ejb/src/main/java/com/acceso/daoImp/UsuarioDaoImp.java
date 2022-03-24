/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.daoImp;

import com.acceso.dao.IUsuarioDao;
import com.acceso.modelo.AccUsuario;
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
public class UsuarioDaoImp extends GenericDaoImp<AccUsuario, Long>
        implements IUsuarioDao {

    public UsuarioDaoImp() {
        super(AccUsuario.class);
    }

    @Override
    public List<AccUsuario> buscar(AccUsuario usuario) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccUsuario t where 1=1");
        if (usuario.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", usuario.getId());
        }

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public AccUsuario usuarioLogeado(Long empresa, String usuario) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccUsuario t where t.empresa=:empresa and t.nombre=:usuario");
        System.err.println("empre--  "+empresa);
        parametros.put("empresa", empresa);
        parametros.put("usuario", usuario);

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        try {
            return (AccUsuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
