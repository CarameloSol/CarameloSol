/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compra.servicio;




import com.compra.modelo.ComCompra;
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
public interface ICompraServicio {

    public ComCompra obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<ComCompra> buscar(ComCompra compra);

    public void actualizar(ComCompra compra)
            throws RegistroNoGuardado;

    public void eliminar(ComCompra compra)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(ComCompra compra) throws RegistroNoGuardado ;

   
    public List<ComCompra> busquedaPorFiltros(ComCompra compra);

}
