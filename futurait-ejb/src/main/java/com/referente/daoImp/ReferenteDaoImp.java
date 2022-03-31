/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.daoImp;


import com.genericos.dao.GenericDaoImp;

import com.referente.dao.IReferenteDao;
import com.referente.modelo.RefPersona;
import com.referente.modelo.RefReferente;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ReferenteDaoImp extends GenericDaoImp<RefReferente, Long>
        implements IReferenteDao {

    public ReferenteDaoImp() {
        super(RefReferente.class);
    }

    @Override
    public List<RefReferente> buscar(RefReferente referente) {
         StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefReferente t where 1=1");
        if (referente.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", referente.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    @Override
    public RefReferente obtenerValidacionNombre(String nombre) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefReferente t where t.nombre=:nombre");
        parametros.put("nombre", nombre);

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        try {
            return (RefReferente) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<RefReferente> busquedaPorFiltros(RefReferente referente) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefReferente t where 1=1");
        if (referente.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", referente.getId());
        }
        
        if (referente.getNombre() != null) {
            String parametroBusqueda = referente.getNombre().toLowerCase().replaceAll(" ", "%_%");
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
    public RefReferente buscarPorIdentificacion(RefReferente referente) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from RefReferente t where 1=1");

        if (referente.getIdentificacion() != null) {
            sql.append(" and t.identificacion=:identificacion");
            parametros.put("identificacion", referente.getIdentificacion());
        }
        Query q = this.em.createQuery(sql.toString());

        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        try {
            return (RefReferente) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    }
