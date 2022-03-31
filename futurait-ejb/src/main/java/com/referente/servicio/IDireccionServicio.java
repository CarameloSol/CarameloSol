/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.modelo.RefDireccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDireccionServicio {

    public RefDireccion obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<RefDireccion> buscar(RefDireccion direccion);

    public void actualizar(RefDireccion direccion)
            throws RegistroNoGuardado;

    public void eliminar(RefDireccion direccion)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(RefDireccion direccion) throws RegistroNoGuardado,Exception ;

   
    public List<RefDireccion> busquedaPorFiltros(RefDireccion direccion);

}
