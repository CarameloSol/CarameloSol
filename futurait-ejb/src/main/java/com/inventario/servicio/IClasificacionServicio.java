/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicio;


import com.acceso.modelo.AccUsuario;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.modelo.InvClasificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IClasificacionServicio {

    public InvClasificacion obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<InvClasificacion> buscar(InvClasificacion clasificacion);

    public void actualizar(InvClasificacion clasificacion)
            throws RegistroNoGuardado;

    public void eliminar(InvClasificacion clasificacion)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(InvClasificacion clasificacion) throws RegistroNoGuardado,Exception ;

    public List<InvClasificacion> busquedaPorFiltros(InvClasificacion clasificacion);

}
