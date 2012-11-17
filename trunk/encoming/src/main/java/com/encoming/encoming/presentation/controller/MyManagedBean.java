package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.vo.PointVo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "yourManagedBean")
@ViewScoped
public class MyManagedBean {

    private String buttonValue;
    private PointVo point;

    public void setButtonValue(String buttonValue) {
        this.buttonValue = buttonValue;
        System.out.println("ButtonValue = "+buttonValue+"-------------------------------------------------");
    }

    public String getButtonValue() {
        return buttonValue;
    }

    public PointVo getPoint() {
        return point;
    }

    public void setPoint(PointVo point) {
        this.point = point;
    }
    
}
