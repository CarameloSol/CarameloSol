/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.daoImp;

import com.enumerador.TipoBusquedaVentasEnum;
import com.genericos.dao.GenericDaoImp;
import com.inventario.dao.IImpuestoArticuloDao;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvImpuestoArticulo;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ImpuestoArticuloDaoImp extends GenericDaoImp<InvImpuestoArticulo, Long>
        implements IImpuestoArticuloDao {

    public ImpuestoArticuloDaoImp() {
        super(InvImpuestoArticulo.class);
    }

    @Override
    public List<InvImpuestoArticulo> buscar(InvImpuestoArticulo impuestoArticulo) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvImpuestoArticulo t where 1=1");
        if (impuestoArticulo.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", impuestoArticulo.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public InvImpuestoArticulo obtenerValidacionNombre(String nombre) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvImpuestoArticulo t where t.nombre=:nombre");
        parametros.put("nombre", nombre);

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        try {
            return (InvImpuestoArticulo) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<InvImpuestoArticulo> busquedaPorFiltros(InvImpuestoArticulo impuestoArticulo) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvImpuestoArticulo t where 1=1");
        if (impuestoArticulo.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", impuestoArticulo.getId());
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
    public List<InvImpuestoArticulo> busquedaFiltroVentas(String campoBusqueda, TipoBusquedaVentasEnum tipoBusqueda) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvImpuestoArticulo t where 1=1");
        
        
        System.err.println("conuslta " + sql.toString());
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
