/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futura.acceso.variables;

import com.acceso.modelo.AccUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "usuarioAD")
@ViewScoped
public class UsuarioAD implements Serializable {

    List<AccUsuario> listaUsuarios = new ArrayList<>();
    AccUsuario usuario = new AccUsuario();

    public List<AccUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<AccUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * Creates a new instance of usuarioAD
     */
    public UsuarioAD() {
    }

    public AccUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(AccUsuario usuario) {
        this.usuario = usuario;
    }

}
