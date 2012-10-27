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

    private MenuModel model;  
    private String page ="/index.xhtml";
    
    public MainMenuBean() {
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    public void Consultar() {  
        page = "/Administrador/Personal.xhtml";
    }  
      
    public void update() {  
        addMessage("Data updated");  
    }  
      
    public void delete() {  
        page ="/index.xhtml";
    } 
    
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
}
