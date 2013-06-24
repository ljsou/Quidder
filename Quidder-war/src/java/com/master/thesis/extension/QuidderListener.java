/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.extension;

import java.io.Serializable;
import java.util.Enumeration;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Javier
 */
@ManagedBean
@SessionScoped
public class QuidderListener implements Serializable {

    private static final long serialVersionUID = 8799656478674716638L;
    private String url;

    public String getUrl() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        System.out.println("getAuthType: " + request.getAuthType() + 
                "\n getContextPath: " + request.getContextPath() + 
                "\n getLocalAddr: " + request.getLocalAddr() + 
                "\n getLocalName: " + request.getLocalName() + 
                "\n getMethod: " + request.getMethod() + 
                "\n getPathInfo: " + request.getPathInfo() + 
                "\n getPathTranslated: " + request.getPathTranslated() + 
                "\n getQueryString: " + request.getQueryString() + 
                "\n getRemoteAddr: " + request.getRemoteAddr() + 
                "\n getRemoteHost: " + request.getRemoteHost() + 
                "\n getRemoteUser: " + request.getRemoteUser() + 
                "\n getServerName: " + request.getServerName() + 
                "\n getRequestURL: " + request.getRequestURL().toString());
        Enumeration parameterList = request.getParameterNames();
        while (parameterList.hasMoreElements()) {
            String sName = parameterList.nextElement().toString();
            String[] sMultiple = request.getParameterValues(sName);
            if (1 >= sMultiple.length) // parameter has a single value. print it.
            {
                System.out.println(sName + " = " + request.getParameter(sName));
            } else {
                for (int i = 0; i < sMultiple.length; i++) // if a paramater contains multiple values, print all of them
                {
                    System.out.println(sName + "[" + i + "] = " + sMultiple[i]);
                }
            }
        }
        return this.url;
    }
}
