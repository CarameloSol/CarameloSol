/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.daoImp;




import com.genericos.dao.GenericDaoImp;
import com.inventario.modelo.InvCategoria;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import com.inventario.dao.ICategoriaDao;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ClasificacionDaoImp extends GenericDaoImp<InvCategoria, Long>
        implements ICategoriaDao {

    public ClasificacionDaoImp() {
        super(InvCategoria.class);
    }

   

    @Override
    public List<InvCategoria> buscar(InvCategoria categoria) {
       StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvCategoria t where 1=1");
        if (categoria.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", categoria.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<InvCategoria> busquedaPorFiltros(InvCategoria categoria) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvCategoria t where 1=1");
        if (categoria.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", categoria.getId());
        }
       
        if (categoria.getNombre() != null) {
            String parametroBusqueda = categoria.getNombre().toLowerCase().replaceAll(" ", "%_%");
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
    public InvCategoria obtenerValidacionNombre(String nombre) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvCategoria t where t.nombre=:nombre");
        parametros.put("nombre", nombre);

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        try {
            return (InvCategoria) q.getSingleResult();
        } catch (Exception e) {
            return null;
    }
        
    }
}
