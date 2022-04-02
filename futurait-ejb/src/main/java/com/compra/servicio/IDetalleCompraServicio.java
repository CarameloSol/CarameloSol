/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.servicio;




import com.compra.modelo.ComDetalleCompra;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleCompraServicio {

    public ComDetalleCompra obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<ComDetalleCompra> buscar(ComDetalleCompra detalleCompra);

    public void actualizar(ComDetalleCompra detalleCompra)
            throws RegistroNoGuardado;

    public void eliminar(ComDetalleCompra detalleCompra)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(ComDetalleCompra detalleCompra) throws RegistroNoGuardado,Exception ;

   
    public List<ComDetalleCompra> busquedaPorFiltros(ComDetalleCompra detalleCompra);

}
