/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicio;



import com.enumerador.TipoBusquedaVentasEnum;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.modelo.InvArticulo;
import com.inventario.modelo.InvImpuestoArticulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IImpuestoArticuloServicio {

    public InvImpuestoArticulo obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<InvImpuestoArticulo> buscar(InvImpuestoArticulo impuestoArticulo);

    public void actualizar(InvImpuestoArticulo impuestoArticulo)
            throws RegistroNoGuardado;

    public void eliminar(InvImpuestoArticulo impuestoArticulo)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(InvImpuestoArticulo impuestoArticulo) throws RegistroNoGuardado ;

   
    public List<InvImpuestoArticulo> busquedaPorFiltros(InvImpuestoArticulo impuestoArticulo);
    public List<InvImpuestoArticulo> busquedaFiltroVentas(String campoBusqueda, TipoBusquedaVentasEnum tipoBusqueda);

}
