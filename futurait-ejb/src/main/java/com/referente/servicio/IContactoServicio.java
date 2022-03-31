/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.modelo.RefContacto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IContactoServicio {

    public RefContacto obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<RefContacto> buscar(RefContacto contacto);

    public void actualizar(RefContacto contacto)
            throws RegistroNoGuardado;

    public void eliminar(RefContacto contacto)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(RefContacto contacto) throws RegistroNoGuardado,Exception ;

   
    public List<RefContacto> busquedaPorFiltros(RefContacto contacto);

}
