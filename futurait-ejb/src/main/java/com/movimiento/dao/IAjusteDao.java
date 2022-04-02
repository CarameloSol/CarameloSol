/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.dao;




import com.generico.daoImp.IGenericoDao;
import com.movimiento.modelo.MovAjuste;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IAjusteDao extends IGenericoDao<MovAjuste, Long> {

    public List<MovAjuste> buscar(MovAjuste ajuste);

    
    public List<MovAjuste> busquedaPorFiltros(MovAjuste ajuste);
}
