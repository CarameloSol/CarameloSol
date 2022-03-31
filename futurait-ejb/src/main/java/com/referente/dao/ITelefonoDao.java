/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.dao;




import com.generico.daoImp.IGenericoDao;
import com.inventario.modelo.InvArticulo;
import com.referente.modelo.RefTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface ITelefonoDao extends IGenericoDao<RefTelefono, Long> {

    public List<RefTelefono> buscar(RefTelefono telefono);

   
    public List<RefTelefono> busquedaPorFiltros(RefTelefono telefono);
}
