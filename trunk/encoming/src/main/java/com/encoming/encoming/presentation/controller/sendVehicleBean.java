/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.vo.VehicleVo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author THOKK
 */
@ManagedBean
@RequestScoped
public class sendVehicleBean {
    private List<SelectItem> vehicles;
    private Integer idPoint = null;
    
    public sendVehicleBean() {
    }
     public List<SelectItem> getVehicles() {
        if (vehicles == null && idPoint != null) {
            vehicles = new ArrayList<SelectItem>();
            List<VehicleVo> vehiclesList = FacadeFactory.getInstance().getVehicleFacade().getListByPoint(idPoint);
            if (vehiclesList != null) {
                for (VehicleVo vehicle : vehiclesList) {
                    vehicles.add(new SelectItem(vehicle.getIdVehicle(), 
                            vehicle.getPlateLetters() + " " 
                            +vehicle.getPlateNumbers()));
                }
            }
        }
        return vehicles;
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }
    
    public void sendVehicle(){
        
    }
}
