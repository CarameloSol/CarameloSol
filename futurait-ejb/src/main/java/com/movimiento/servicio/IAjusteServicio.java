/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.movimiento.modelo.MovAjuste;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IAjusteServicio {

    public MovAjuste obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<MovAjuste> buscar(MovAjuste ajuste);

    public void actualizar(MovAjuste ajuste)
            throws RegistroNoGuardado;

    public void eliminar(MovAjuste ajuste)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(MovAjuste ajuste) throws RegistroNoGuardado ;

   
    public List<MovAjuste> busquedaPorFiltros(MovAjuste ajuste);

}
