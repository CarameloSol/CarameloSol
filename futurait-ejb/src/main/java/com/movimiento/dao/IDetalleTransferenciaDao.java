/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.dao;




import com.generico.daoImp.IGenericoDao;
import com.movimiento.modelo.MovDetalleTransferencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleTransferenciaDao extends IGenericoDao<MovDetalleTransferencia, Long> {

    public List<MovDetalleTransferencia> buscar(MovDetalleTransferencia transferencia);

    
    public List<MovDetalleTransferencia> busquedaPorFiltros(MovDetalleTransferencia transferencia);
}
