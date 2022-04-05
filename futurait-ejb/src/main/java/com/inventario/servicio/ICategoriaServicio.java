/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicio;


import com.acceso.modelo.AccUsuario;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.modelo.InvCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ICategoriaServicio {

    public InvCategoria obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<InvCategoria> buscar(InvCategoria categoria);

    public void actualizar(InvCategoria categoria)
            throws RegistroNoGuardado;

    public void eliminar(InvCategoria categoria)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(InvCategoria categoria) throws RegistroNoGuardado ;

    public List<InvCategoria> busquedaPorFiltros(InvCategoria categoria);

}
