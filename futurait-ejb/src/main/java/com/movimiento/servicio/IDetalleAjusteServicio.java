/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.movimiento.modelo.MovDetalleAjuste;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleAjusteServicio {

    public MovDetalleAjuste obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<MovDetalleAjuste> buscar(MovDetalleAjuste detalleAjuste);

    public void actualizar(MovDetalleAjuste detalleAjuste)
            throws RegistroNoGuardado;

    public void eliminar(MovDetalleAjuste detalleAjuste)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(MovDetalleAjuste detalleAjuste) throws RegistroNoGuardado ;

   
    public List<MovDetalleAjuste> busquedaPorFiltros(MovDetalleAjuste detalleAjuste);

}
