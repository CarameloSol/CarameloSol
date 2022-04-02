/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.servicio;




import com.compra.modelo.ComDetalleCompraImpuesto;
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
public interface IDetalleCompraImpuestoServicio {

    public ComDetalleCompraImpuesto obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<ComDetalleCompraImpuesto> buscar(ComDetalleCompraImpuesto detalleCompraImpuesto);

    public void actualizar(ComDetalleCompraImpuesto detalleCompraImpuesto)
            throws RegistroNoGuardado;

    public void eliminar(ComDetalleCompraImpuesto detalleCompraImpuesto)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(ComDetalleCompraImpuesto detalleCompraImpuesto) throws RegistroNoGuardado,Exception ;

   
    public List<ComDetalleCompraImpuesto> busquedaPorFiltros(ComDetalleCompraImpuesto detalleCompraImpuesto);

}
