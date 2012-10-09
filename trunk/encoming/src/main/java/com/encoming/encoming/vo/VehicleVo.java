/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import java.util.List;

/**
 *
 * @author germanpinerosm
 */
public class VehicleVo implements IValueObject{
    
    private Integer idVehiclePK;
    private String manufacturer;
    private String model;
    private int capacity;
    private String status;
    private List<EncomingVo> encomingList;
    private Integer idDriver;

    /**
     * @return the vehiclePK
     */
    public Integer getVehiclePK() {
        return idVehiclePK;
    }

    /**
     * @param vehiclePK the vehiclePK to set
     */
    public void setVehiclePK(Integer idVehiclePK) {
        this.idVehiclePK = idVehiclePK;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the encomingList
     */
    public List<EncomingVo> getEncomingList() {
        return encomingList;
    }

    /**
     * @param encomingList the encomingList to set
     */
    public void setEncomingList(List<EncomingVo> encomingList) {
        this.encomingList = encomingList;
    }

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
    
}
