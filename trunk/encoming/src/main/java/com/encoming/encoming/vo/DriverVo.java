/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import java.util.List;

/**
 *
 * @author germanpineros
 */
public class DriverVo implements IValueObject{
    
    private Integer idDriver;
    private String license;
    private Integer idWorker;
    private List<VehicleVo> vehicleList;  

    /**
     * @return the idDriver
     */
    public Integer getIdDriver() {
        return idDriver;
    }

    /**
     * @param idDriver the idDriver to set
     */
    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    /**
     * @return the license
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license the license to set
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * @return the idWorker
     */
    public Integer getIdWorker() {
        return idWorker;
    }

    /**
     * @param idWorker the idWorker to set
     */
    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
    }

    /**
     * @return the vehicleList
     */
    public List<VehicleVo> getVehicleList() {
        return vehicleList;
    }

    /**
     * @param vehicleList the vehicleList to set
     */
    public void setVehicleList(List<VehicleVo> vehicleList) {
        this.vehicleList = vehicleList;
    }
  
}
