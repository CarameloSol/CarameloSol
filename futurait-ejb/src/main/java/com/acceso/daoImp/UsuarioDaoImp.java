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
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<AccUsuario> busquedaPorFiltros(AccUsuario usuario) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccUsuario t where 1=1");
        if (usuario.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", usuario.getId());
        }
        if (usuario.getIdRol() != null) {
            sql.append(" and t.rol.id=:rol");
            parametros.put("rol", usuario.getIdRol());
        }
        if (usuario.getNombre() != null) {
            String parametroBusqueda = usuario.getNombre().toLowerCase().replaceAll(" ", "%_%");
            sql.append(" and LOWER(t.nombre) like :nombre");
            parametros.put("nombre", "%" + parametroBusqueda + "%");
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public AccUsuario usuarioLogeado(String identificacion, String usuario) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select u from AccUsuario u inner join "
                + " SisEmpresa e on u.empresa = e.id "
                + " where e.referente.identificacion =:identificacion and u.nombre =:usuario");
        parametros.put("identificacion", identificacion);
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

    @Override
    public AccUsuario obtenerValidacionNombre(String nombre) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccUsuario t where t.nombre=:nombre");
        parametros.put("nombre", nombre);

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
