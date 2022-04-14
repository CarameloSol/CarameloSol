/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.variables;

import com.acceso.modelo.AccUsuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Ricardo
 */
@Named(value = "accesoAD")
@SessionScoped
public class AccesoAD implements Serializable {

    AccUsuario usuario = new AccUsuario();
    Long empresa = null;
    String rucLogin = null;

    /**
     * Creates a new instance of accesoAD
     */
    public AccesoAD() {
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public AccUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(AccUsuario usuario) {
        this.usuario = usuario;
    }

    public String getRucLogin() {
        return rucLogin;
    }

    public void setRucLogin(String rucLogin) {
        this.rucLogin = rucLogin;
    }

 
}
