/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author andres
 */
@ManagedBean
@SessionScoped
public class AdminMenuBean {

    private String page = "/adminPoints.xhtml";
            
    public AdminMenuBean() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    public void createEncoming(){
        page = "/createEncoming.xhtml";
    }
    
    public void adminPersonal(){
        page = "/adminPersonal.xhtml";
    }
    
    public void adminPoints(){
        page = "/adminPoints.xhtml";
    }
    
    public void adminVehicles(){
        page = "/adminVehicles.xhtml";
    }
    
}
