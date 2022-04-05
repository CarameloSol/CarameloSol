/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimiento.servicioImp;



import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.movimiento.dao.IAjusteDao;
import com.movimiento.modelo.MovAjuste;
import com.movimiento.servicio.IAjusteServicio;
import com.referente.servicio.IReferenteServicio;
import com.sistema.dao.IEmpresaDao;
import com.sistema.modelo.SisEmpresa;
import com.sistema.servicio.IEmpresaServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class AjusteServicioImp implements IAjusteServicio {

    @EJB
    IAjusteDao ajusteDao;

   @EJB
    IReferenteServicio referenteServicio;

    

    @Override
    public List<MovAjuste> buscar(MovAjuste ajuste) {
        return ajusteDao.buscar(ajuste);
    }

    @Override
    public void actualizar(MovAjuste ajuste) throws RegistroNoGuardado {
        ajusteDao.actualizar(ajuste);
    }

    @Override
    public void eliminar(MovAjuste ajuste) throws RegistroNoEliminado, RegistroNoLocalizado {
        MovAjuste ajusteEliminar = ajusteDao.recuperar(ajuste.getId());
        ajusteDao.eliminar(ajusteEliminar);
    }

    @Override
    public void guardar(MovAjuste ajuste) throws RegistroNoGuardado {
        ajuste.setEmpresa(1l);
        if (ajuste.getId()==null) {
            ajusteDao.crear(ajuste);
        } else {
            ajusteDao.actualizar(ajuste);
        }
    }

    @Override
    public List<MovAjuste> busquedaPorFiltros(MovAjuste ajuste) {
        return ajusteDao.busquedaPorFiltros(ajuste);
    }

    @Override
    public MovAjuste obtenerPorId(Long id) throws RegistroNoLocalizado {
        return ajusteDao.recuperar(id);
    }
}
