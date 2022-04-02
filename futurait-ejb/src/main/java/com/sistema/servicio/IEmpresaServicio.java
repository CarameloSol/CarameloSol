/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.sistema.modelo.SisEmpresa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IEmpresaServicio {

    public SisEmpresa obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<SisEmpresa> buscar(SisEmpresa empresa);

    public void actualizar(SisEmpresa empresa)
            throws RegistroNoGuardado;

    public void eliminar(SisEmpresa empresa)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(SisEmpresa empresa) throws RegistroNoGuardado,Exception ;

   
    public List<SisEmpresa> busquedaPorFiltros(SisEmpresa empresa);

}
