package com.encoming.encoming.presentation.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "yourManagedBean")
@ViewScoped
public class MyManagedBean {

    private String buttonValue;

    public void setButtonValue(String buttonValue) {
        this.buttonValue = buttonValue;
        System.out.println("ButtonValue = "+buttonValue+"-------------------------------------------------");
    }

    public String getButtonValue() {
        return buttonValue;
    }    
}
