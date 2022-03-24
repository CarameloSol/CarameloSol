/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futurait.controladorAcceso;

import com.acceso.modelo.AccUsuario;
import com.acceso.servicioImp.IUsuarioServicio;
import com.futura.acceso.variables.AccesoAD;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo
 */
public abstract class BaseControlador implements Serializable {

    @EJB
    IUsuarioServicio usuarioServicio;
    @Inject
    AccesoAD accesoAD;

    public void validarAcceso() {

      

//        String loggedUsername = getServletRequest().getRemoteUser();
//        AccUsuario usuarioLogeado = usuarioServicio.usuarioLogeado(accesoAD.getEmpresa(), loggedUsername);
//        if (usuarioLogeado == null) {
//            getSession().invalidate();
//        }
//        accesoAD.setUsuario(usuarioLogeado);
    }

    public String urlBase() {
        String serverName = getServletRequest().getServerName();
        String contexto = getServletRequest().getContextPath();
        String scheme = getServletRequest().getHeader("X-Forwarded-Proto");
        if (scheme == null) {
            scheme = getServletRequest().getScheme();
            int serverPort = getServletRequest().getServerPort();
            return scheme + "://" + serverName + ":" + serverPort
                    + contexto;
        }
        return scheme + "://" + serverName + contexto;
    }

    protected HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    /**
     * @param parameterName
     * @return
     */
    protected Object getRequestParameter(final String parameterName) {
        return getFacesContext().getExternalContext().getRequestParameterMap().get(parameterName);
    }

    protected HttpServletResponse getServletResponse() {
        return (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
    }

    protected HttpServletRequest getServletRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    /**
     * @return
     */
    protected static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
