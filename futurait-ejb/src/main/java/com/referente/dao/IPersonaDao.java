/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.dao;




import com.generico.daoImp.IGenericoDao;
import com.inventario.modelo.InvArticulo;
import com.referente.modelo.RefPersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IPersonaDao extends IGenericoDao<RefPersona, Long> {

    public RefPersona buscar(RefPersona referente);

}
