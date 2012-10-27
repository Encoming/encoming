/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.MenuModel;

/**
 *
 * @author andres
 */
@ManagedBean
@SessionScoped
public class MainMenuBean {

    private String page = "/inicio.xhtml";
    
    public MainMenuBean() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    public void inicio() {  
        page = "/inicio.xhtml";
    }  
      
    public void quienesSomos() {  
        page = "/quienesSomos.xhtml"; 
    }
    
    public void consultarSucursales() {  
        page = "/consultarSucursales.xhtml"; 
    } 
    
    public void consultarPrecios() {  
        page = "/consultarPrecios.xhtml"; 
    }
    
    public void detallesEncomienda() {  
        page = "/detallesEncomienda.xhtml"; 
    }     
    
}
