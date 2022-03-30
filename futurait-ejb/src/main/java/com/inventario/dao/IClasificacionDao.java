/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.dao;



import com.generico.daoImp.IGenericoDao;
import com.inventario.modelo.InvClasificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IClasificacionDao extends IGenericoDao<InvClasificacion, Long> {

    public List<InvClasificacion> buscar(InvClasificacion clasificacion);

    public InvClasificacion obtenerValidacionNombre(String nombre);

    public List<InvClasificacion> busquedaPorFiltros(InvClasificacion clasificacion);
}
