/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.dao;




import com.generico.daoImp.IGenericoDao;
import com.movimiento.modelo.MovTransferencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ITransferenciaDao extends IGenericoDao<MovTransferencia, Long> {

    public List<MovTransferencia> buscar(MovTransferencia transferencia);

    
    public List<MovTransferencia> busquedaPorFiltros(MovTransferencia transferencia);
}
