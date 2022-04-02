/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.dao;




import com.generico.daoImp.IGenericoDao;
import com.movimiento.modelo.MovKardex;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IKardexDao extends IGenericoDao<MovKardex, Long> {

    public List<MovKardex> buscar(MovKardex kardex);

    
    public List<MovKardex> busquedaPorFiltros(MovKardex kardex);
}
