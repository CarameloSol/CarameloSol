/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.sistema.modelo.SisFormaPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IFormaPagoServicio {

    public SisFormaPago obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<SisFormaPago> buscar(SisFormaPago formaPago);

    public void actualizar(SisFormaPago formaPago)
            throws RegistroNoGuardado;

    public void eliminar(SisFormaPago formaPago)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(SisFormaPago formaPago) throws RegistroNoGuardado ;

   
    public List<SisFormaPago> busquedaPorFiltros(SisFormaPago formaPago);

}
