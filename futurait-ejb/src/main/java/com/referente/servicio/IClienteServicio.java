/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.modelo.InvArticulo;
import com.referente.modelo.RefCliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IClienteServicio {

    public RefCliente obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<RefCliente> buscar(RefCliente cliente);

    public void actualizar(RefCliente cliente)
            throws RegistroNoGuardado;

    public void eliminar(RefCliente cliente)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(RefCliente cliente) throws RegistroNoGuardado,Exception ;

   
    public List<RefCliente> busquedaPorFiltros(RefCliente cliente);

}
