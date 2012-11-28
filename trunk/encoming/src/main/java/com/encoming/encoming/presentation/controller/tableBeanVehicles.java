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

/**
 *
 * @author THOKK
 */
@ManagedBean
@RequestScoped
public class tableBeanVehicles {

    private List<VehicleVo> vehicles;
    private List<VehicleVo> filteredVehicles;
    
    public tableBeanVehicles() {
        vehicles = new ArrayList();
        vehicles = FacadeFactory.getInstance().getVehicleFacade().getList();
               
    }

    public List<VehicleVo> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleVo> vehicles) {
        this.vehicles = vehicles;
    }

    public List<VehicleVo> getFilteredVehicles() {
        return filteredVehicles;
    }

    public void setFilteredVehicles(List<VehicleVo> filteredVehicles) {
        this.filteredVehicles = filteredVehicles;
    }
    
}
