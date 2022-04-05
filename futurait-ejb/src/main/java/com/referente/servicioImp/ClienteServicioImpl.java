/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicioImp;



import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.referente.dao.IClienteDao;
import com.referente.modelo.RefCliente;
import com.referente.servicio.IClienteServicio;
import com.referente.servicio.IReferenteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Ricardo
 */
@Stateless
public class ClienteServicioImpl implements IClienteServicio {

    @EJB
    IClienteDao clienteDao;

   @EJB
    IReferenteServicio referenteServicio;

    @Override
    public List<RefCliente> buscar(RefCliente cliente) {
        return clienteDao.buscar(cliente);
    }

    @Override
    public void actualizar(RefCliente cliente) throws RegistroNoGuardado {
        clienteDao.actualizar(cliente);
    }

    @Override
    public void eliminar(RefCliente cliente) throws RegistroNoEliminado, RegistroNoLocalizado {
        RefCliente clienteEliminar = clienteDao.recuperar(cliente.getId());
        clienteDao.eliminar(clienteEliminar);
    }

    private void validacionCliente(){
        
    }
    
    @Override
    public void guardar(RefCliente cliente) throws RegistroNoGuardado {
        cliente.setEstado(Boolean.TRUE);
       referenteServicio.guardar(cliente.getReferente());
        if (cliente.getId()== null) {
            clienteDao.crear(cliente);
        } else {
            clienteDao.actualizar(cliente);
        }
        
    }

    @Override
    public List<RefCliente> busquedaPorFiltros(RefCliente cliente) {
        return clienteDao.busquedaPorFiltros(cliente);
    }

    @Override
    public RefCliente obtenerPorId(Long id) throws RegistroNoLocalizado {
        return clienteDao.recuperar(id);
    }

}
