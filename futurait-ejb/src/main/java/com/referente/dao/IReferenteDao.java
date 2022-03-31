/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.dao;




import com.generico.daoImp.IGenericoDao;
import com.referente.modelo.RefReferente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IReferenteDao extends IGenericoDao<RefReferente, Long> {

    public List<RefReferente> buscar(RefReferente referente);

    public RefReferente obtenerValidacionNombre(String nombre);

    public List<RefReferente> busquedaPorFiltros(RefReferente referente);

    public RefReferente buscarPorIdentificacion(RefReferente referente);
}
