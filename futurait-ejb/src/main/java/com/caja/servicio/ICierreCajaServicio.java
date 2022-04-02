/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caja.servicio;




import com.caja.modelo.CajCierreCaja;
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
public interface ICierreCajaServicio {

    public CajCierreCaja obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<CajCierreCaja> buscar(CajCierreCaja cierreCaja);

    public void actualizar(CajCierreCaja cierreCaja)
            throws RegistroNoGuardado;

    public void eliminar(CajCierreCaja cierreCaja)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(CajCierreCaja cierreCaja) throws RegistroNoGuardado,Exception ;

   
    public List<CajCierreCaja> busquedaPorFiltros(CajCierreCaja cierreCaja);

}
