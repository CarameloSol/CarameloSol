/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.variables;

  import com.referente.modelo.RefReferente;
import com.sistema.modelo.SisEmpresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "empresaAD")
@ViewScoped
public class empresaAD implements Serializable {

    List<SisEmpresa> listaEmpresas = new ArrayList<>();
    SisEmpresa empresa = new SisEmpresa();
    RefReferente referente = new RefReferente();
    SisEmpresa empresaBusqueda = new SisEmpresa();

    public List<SisEmpresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<SisEmpresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public SisEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(SisEmpresa empresa) {
        this.empresa = empresa;
    }

    public RefReferente getReferente() {
        return referente;
    }

    public void setReferente(RefReferente referente) {
        this.referente = referente;
    }

    public SisEmpresa getEmpresaBusqueda() {
        return empresaBusqueda;
    }

    public void setEmpresaBusqueda(SisEmpresa empresaBusqueda) {
        this.empresaBusqueda = empresaBusqueda;
    }

   

}
