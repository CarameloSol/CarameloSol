/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.daoImp;




import com.genericos.dao.GenericDaoImp;
import com.inventario.dao.IClasificacionDao;
import com.inventario.modelo.InvClasificacion;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class ClasificacionDaoImp extends GenericDaoImp<InvClasificacion, Long>
        implements IClasificacionDao {

    public ClasificacionDaoImp() {
        super(InvClasificacion.class);
    }

   

    @Override
    public List<InvClasificacion> buscar(InvClasificacion clasificacion) {
       StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvClasificacion t where 1=1");
        if (clasificacion.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", clasificacion.getId());
        }
        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<InvClasificacion> busquedaPorFiltros(InvClasificacion clasificacion) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvClasificacion t where 1=1");
        if (clasificacion.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", clasificacion.getId());
        }
       
        if (clasificacion.getNombre() != null) {
            String parametroBusqueda = clasificacion.getNombre().toLowerCase().replaceAll(" ", "%_%");
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
    public InvClasificacion obtenerValidacionNombre(String nombre) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from InvClasificacion t where t.nombre=:nombre");
        parametros.put("nombre", nombre);

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        try {
            return (InvClasificacion) q.getSingleResult();
        } catch (Exception e) {
            return null;
    }
        
    }
}
