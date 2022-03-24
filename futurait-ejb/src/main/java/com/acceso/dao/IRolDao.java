/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.dao;
import com.acceso.modelo.AccRol;
import com.generico.daoImp.IGenericoDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IRolDao extends IGenericoDao<AccRol, Long>{
        public List<AccRol> buscar(AccRol rol);
}
