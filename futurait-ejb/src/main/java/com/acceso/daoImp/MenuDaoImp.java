/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.daoImp;

import com.acceso.dao.IMenuDao;
import com.acceso.dao.IRolDao;
import com.acceso.modelo.AccMenu;
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
public class MenuDaoImp extends GenericDaoImp<AccMenu, Long>
        implements IMenuDao {

    public MenuDaoImp() {
        super(AccMenu.class);
    }


    @Override
    public List<AccMenu> buscar(AccMenu menu) {
           StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccMenu t where 1=1");
        if (menu.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", menu.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<AccMenu> busquedaPorFiltros(AccMenu menu) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from AccMenu t where 1=1");
        if (menu.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", menu.getId());
        }
        if (menu.getNombre() != null) {
            String parametroBusqueda = menu.getNombre().toLowerCase().replaceAll(" ", "%_%");
            sql.append(" and LOWER(t.nombre) like :nombre");
            parametros.put("nombre", "%" + parametroBusqueda + "%");
        }
        
           if (menu.getPath()!= null) {
            String parametroBusqueda = menu.getPath().toLowerCase().replaceAll(" ", "%_%");
            sql.append(" and LOWER(t.path) like :path");
            parametros.put("path", "%" + parametroBusqueda + "%");
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
