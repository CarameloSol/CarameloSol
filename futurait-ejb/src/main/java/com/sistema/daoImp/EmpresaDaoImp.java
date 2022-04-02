/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.daoImp;

import com.genericos.dao.GenericDaoImp;

import com.referente.dao.IClienteDao;
import com.referente.modelo.RefCliente;
import com.sistema.dao.IEmpresaDao;
import com.sistema.modelo.SisEmpresa;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class EmpresaDaoImp extends GenericDaoImp<SisEmpresa, Long>
        implements IEmpresaDao {

    public EmpresaDaoImp() {
        super(SisEmpresa.class);
    }

    @Override
    public List<SisEmpresa> buscar(SisEmpresa empresa) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from SisEmpresa t where 1=1");
        if (empresa.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", empresa.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<SisEmpresa> busquedaPorFiltros(SisEmpresa empresa) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from SisEmpresa t where 1=1");
        if (empresa.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", empresa.getId());
        }
        
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
    
    

    }
