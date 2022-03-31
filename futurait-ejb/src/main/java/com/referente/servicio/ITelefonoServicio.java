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
import com.referente.modelo.RefTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ITelefonoServicio {

    public RefTelefono obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<RefTelefono> buscar(RefTelefono telefono);

    public void actualizar(RefTelefono telefono)
            throws RegistroNoGuardado;

    public void eliminar(RefTelefono telefono)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(RefTelefono telefono) throws RegistroNoGuardado,Exception ;

   
    public List<RefTelefono> busquedaPorFiltros(RefTelefono telefono);

}
