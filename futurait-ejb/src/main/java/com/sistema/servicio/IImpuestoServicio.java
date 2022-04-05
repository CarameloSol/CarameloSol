/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.sistema.modelo.SisImpuesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IImpuestoServicio {

    public SisImpuesto obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<SisImpuesto> buscar(SisImpuesto impuesto);

    public void actualizar(SisImpuesto impuesto)
            throws RegistroNoGuardado;

    public void eliminar(SisImpuesto impuesto)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(SisImpuesto impuesto) throws RegistroNoGuardado ;

   
    public List<SisImpuesto> busquedaPorFiltros(SisImpuesto impuesto);

}
