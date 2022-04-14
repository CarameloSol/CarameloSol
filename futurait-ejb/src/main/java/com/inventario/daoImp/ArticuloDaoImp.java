/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.daoImp;

import com.acceso.modelo.AccUsuario;
import com.enumerador.TipoBusquedaVentasEnum;
import com.genericos.dao.GenericDaoImp;
import com.inventario.dao.IArticuloDao;
import com.inventario.modelo.InvArticulo;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ArticuloDaoImp extends GenericDaoImp<InvArticulo, Long>
        implements IArticuloDao {

    public ArticuloDaoImp() {
        super(InvArticulo.class);
    }

    @Override
    public List<InvArticulo> buscar(InvArticulo articulo) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvArticulo t where 1=1");
        if (articulo.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", articulo.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public InvArticulo obtenerValidacionNombre(String nombre) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvArticulo t where t.nombre=:nombre");
        parametros.put("nombre", nombre);

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        try {
            return (InvArticulo) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<InvArticulo> busquedaPorFiltros(InvArticulo articulo) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvArticulo t where 1=1");
        if (articulo.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", articulo.getId());
        }

        if (articulo.getNombre() != null) {
            String parametroBusqueda = articulo.getNombre().toLowerCase().replaceAll(" ", "%_%");
            sql.append(" and LOWER(t.nombre) like :nombre");
            parametros.put("nombre", "%" + parametroBusqueda + "%");
        }
        sql.append(" order by t.id  desc ");
        System.err.println("SQL " + sql.toString());
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<InvArticulo> busquedaFiltroVentas(String campoBusqueda, TipoBusquedaVentasEnum tipoBusqueda) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvArticulo t where 1=1");

        if (campoBusqueda != null && tipoBusqueda.equals(TipoBusquedaVentasEnum.NOMBRE)) {
            String parametroBusqueda = campoBusqueda.toLowerCase().replaceAll(" ", "%_%");
            sql.append(" and LOWER(t.nombre) like :nombre");
            parametros.put("nombre", "%" + parametroBusqueda + "%");
        }
        if (campoBusqueda != null && tipoBusqueda.equals(TipoBusquedaVentasEnum.CATEGORIA)) {
            String parametroBusqueda = campoBusqueda.toLowerCase().replaceAll(" ", "%_%");
            sql.append(" and LOWER(t.categoria.nombre) like :nombre");
            parametros.put("nombre", "%" + parametroBusqueda + "%");
        }
        if (campoBusqueda != null && tipoBusqueda.equals(TipoBusquedaVentasEnum.CODIGO)) {
            sql.append(" and codigo =:codigo");
            parametros.put("codigo", campoBusqueda);
        }
        System.err.println("conuslta "+sql.toString());
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
