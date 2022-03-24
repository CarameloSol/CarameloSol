/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futurait.controladorAcceso;

import com.futura.acceso.variables.AccesoAD;
import static com.futurait.controladorAcceso.UsuarioControlador.getFacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Ricardo
 */
public class SesionManagement  implements HttpSessionListener{
  @Inject 
  AccesoAD accesoAD;
  
        public void sessionCreated(HttpSessionEvent se) {
        }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
      
   
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
    
}
