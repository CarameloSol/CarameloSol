/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.servicio;




import com.compra.modelo.ComCompraImpuesto;
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
public interface ICompraImpuestoServicio {

    public ComCompraImpuesto obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<ComCompraImpuesto> buscar(ComCompraImpuesto compraImpuesto);

    public void actualizar(ComCompraImpuesto compraImpuesto)
            throws RegistroNoGuardado;

    public void eliminar(ComCompraImpuesto compraImpuesto)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(ComCompraImpuesto compraImpuesto) throws RegistroNoGuardado ;

   
    public List<ComCompraImpuesto> busquedaPorFiltros(ComCompraImpuesto compraImpuesto);

}
