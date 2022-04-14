/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acceso.controlador;

import com.acceso.modelo.AccUsuario;
import com.acceso.servicio.IUsuarioServicio;
import com.acceso.variables.AccesoAD;
import com.acceso.variables.UsuarioAD;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Ricardo
 */
public abstract class BaseControlador implements Serializable {

    @EJB
    IUsuarioServicio usuarioServicio;
    @Inject
    AccesoAD accesoAD;

    public Boolean validarAcceso() {
        try {
            String loggedUsername = getServletRequest().getRemoteUser();
            if (loggedUsername == null) {
                return Boolean.FALSE;
            }
            if (accesoAD.getRucLogin() == null) {

                getSession().invalidate();
                getServletResponse().sendRedirect("http://localhost:8080/paginas/protegidas/acceso/usuario/inicio.fut");
                PrimeFaces.current().executeScript("location.reload();");
                return Boolean.FALSE;
            }

            AccUsuario usuarioLogeado = usuarioServicio.usuarioLogeado(accesoAD.getRucLogin(), loggedUsername);
            if (usuarioLogeado == null) {
                getSession().invalidate();
                getServletResponse().sendRedirect("http://localhost:8080/paginas/protegidas/acceso/usuario/inicio.fut");
                PrimeFaces.current().executeScript("location.reload();");
                return Boolean.FALSE;

            }

            accesoAD.setUsuario(usuarioLogeado);
        } catch (IOException ex) {
            Logger.getLogger(BaseControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Boolean.TRUE;
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

    /**
     * @param resumen
     */
    protected void addErrorMessage(final String resumen) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", resumen);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addErrorMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     */
    protected void addInfoMessage(final String resumen) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", resumen);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addInfoMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     */
    protected void addWarnMessage(final String resumen) {
        FacesMessage message = new FacesMessage(resumen);
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addWarnMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
