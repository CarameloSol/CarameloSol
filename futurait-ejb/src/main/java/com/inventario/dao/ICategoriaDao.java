/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.dao;



import com.generico.daoImp.IGenericoDao;
import com.inventario.modelo.InvCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ICategoriaDao extends IGenericoDao<InvCategoria, Long> {

    public List<InvCategoria> buscar(InvCategoria categoria);

    public InvCategoria obtenerValidacionNombre(String nombre);

    public List<InvCategoria> busquedaPorFiltros(InvCategoria categoria);
}
