/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean
public class OptimalRouteBean {
    
    String valor;
    
    /**
     * Creates a new instance of OptimalRouteBean
     */
    public OptimalRouteBean() {
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
