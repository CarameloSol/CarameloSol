/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.modelo.RefReferente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IReferenteServicio {

    public RefReferente obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<RefReferente> buscar(RefReferente referente);

    public void actualizar(RefReferente referente)
            throws RegistroNoGuardado;

    public void eliminar(RefReferente referente)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(RefReferente referente) throws RegistroNoGuardado ;

   
    public List<RefReferente> busquedaPorFiltros(RefReferente referente);
    public RefReferente buscarPorIdentificacion(RefReferente referente);

    public RefReferente obtenerDatosReferente(RefReferente referente);

}
