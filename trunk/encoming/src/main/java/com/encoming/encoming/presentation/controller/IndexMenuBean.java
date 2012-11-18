/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author andres
 */
@ManagedBean
@SessionScoped
public class IndexMenuBean implements Serializable{

    private String page = "/whoAreWe.xhtml";
            
    public IndexMenuBean() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    public void whoAreWe(){
        page = "/whoAreWe.xhtml";
    }
    
    public void ourPoints(){
        page = "/ourPoints.xhtml";
    }
    
}
