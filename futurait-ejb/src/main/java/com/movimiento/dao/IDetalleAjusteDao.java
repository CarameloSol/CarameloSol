/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.dao;




import com.generico.daoImp.IGenericoDao;
import com.movimiento.modelo.MovDetalleAjuste;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IDetalleAjusteDao extends IGenericoDao<MovDetalleAjuste, Long> {

    public List<MovDetalleAjuste> buscar(MovDetalleAjuste detalleAjuste);

    
    public List<MovDetalleAjuste> busquedaPorFiltros(MovDetalleAjuste detalleAjuste);
}
