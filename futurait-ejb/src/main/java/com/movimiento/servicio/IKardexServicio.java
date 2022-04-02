/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.movimiento.modelo.MovKardex;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IKardexServicio {

    public MovKardex obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<MovKardex> buscar(MovKardex kardex);

    public void actualizar(MovKardex kardex)
            throws RegistroNoGuardado;

    public void eliminar(MovKardex kardex)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(MovKardex kardex) throws RegistroNoGuardado,Exception ;

   
    public List<MovKardex> busquedaPorFiltros(MovKardex kardex);

}
