/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.referente.servicio;




import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.inventario.modelo.InvArticulo;
import com.referente.modelo.RefCliente;
import com.referente.modelo.RefContacto;
import com.referente.modelo.RefDireccion;
import com.referente.modelo.RefProveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo
 */
@Local
public interface IProveedorServicio {

    public RefProveedor obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<RefProveedor> buscar(RefProveedor proveedor);

    public void actualizar(RefProveedor proveedor)
            throws RegistroNoGuardado;

    public void eliminar(RefProveedor proveedor)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(RefProveedor proveedor) throws RegistroNoGuardado ;

   
    public List<RefProveedor> busquedaPorFiltros(RefProveedor proveedor);

}
