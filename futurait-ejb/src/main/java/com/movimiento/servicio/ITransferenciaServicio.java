/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.movimiento.modelo.MovTransferencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ITransferenciaServicio {

    public MovTransferencia obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<MovTransferencia> buscar(MovTransferencia transferencia);

    public void actualizar(MovTransferencia transferencia)
            throws RegistroNoGuardado;

    public void eliminar(MovTransferencia transferencia)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(MovTransferencia transferencia) throws RegistroNoGuardado ;

   
    public List<MovTransferencia> busquedaPorFiltros(MovTransferencia transferencia);

}
