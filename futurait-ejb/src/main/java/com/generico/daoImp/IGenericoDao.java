package com.generico.daoImp;

import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Interface IGenericDao.
 *
 * @param <T> the generic type
 * @param <PK> the generic id type
 * @author Eduardo Proano
 * @revision $Revision: 1.1 $$
 */
public interface IGenericoDao<T, PK extends Serializable> {

   
    void crear(T o) throws RegistroNoGuardado;

   
    T recuperar(PK id) throws RegistroNoLocalizado;

  
    void actualizar(T o) throws RegistroNoGuardado;

  
    void eliminar(T o) throws RegistroNoEliminado;

    Object selectNamedQuerySingle(String query, Map<String, Object> parametros);

    List<Object> selectNamedQueryResultList(String query, Map<String, Object> parametros);
}
