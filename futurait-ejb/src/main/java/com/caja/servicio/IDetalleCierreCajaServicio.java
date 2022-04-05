/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caja.servicio;





import com.caja.modelo.CajDetalleCierreCaja;
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
public interface IDetalleCierreCajaServicio {

    public CajDetalleCierreCaja obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<CajDetalleCierreCaja> buscar(CajDetalleCierreCaja detalleCierreCaja);

    public void actualizar(CajDetalleCierreCaja detalleCierreCaja)
            throws RegistroNoGuardado;

    public void eliminar(CajDetalleCierreCaja detalleCierreCaja)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(CajDetalleCierreCaja detalleCierreCaja) throws RegistroNoGuardado ;

   
    public List<CajDetalleCierreCaja> busquedaPorFiltros(CajDetalleCierreCaja detalleCierreCaja);

}
