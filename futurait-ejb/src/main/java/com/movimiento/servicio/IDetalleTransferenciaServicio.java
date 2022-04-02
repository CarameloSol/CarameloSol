/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.movimiento.modelo.MovDetalleTransferencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleTransferenciaServicio {

    public MovDetalleTransferencia obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<MovDetalleTransferencia> buscar(MovDetalleTransferencia detalleTransferencia);

    public void actualizar(MovDetalleTransferencia detalleTransferencia)
            throws RegistroNoGuardado;

    public void eliminar(MovDetalleTransferencia detalleTransferencia)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(MovDetalleTransferencia detalleTransferencia) throws RegistroNoGuardado,Exception ;

   
    public List<MovDetalleTransferencia> busquedaPorFiltros(MovDetalleTransferencia detalleTransferencia);

}
