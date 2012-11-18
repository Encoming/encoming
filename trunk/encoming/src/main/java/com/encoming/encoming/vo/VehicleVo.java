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
    private Integer idVehicle;
    private int plateNumber;
    private String plateLetters;
    private String type;
    private String manufacturer;
    private String model;
    private String capacity;
    private String status;
    private List<ShippingVo> shippingList;
    private Integer idPoint;
    private Integer idDriver;

    /**
     * @return the idVehicle
     */
    public Integer getIdVehicle() {
        return idVehicle;
    }

    /**
     * @param idVehicle the idVehicle to set
     */
    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    /**
     * @return the plateNumber
     */
    public int getPlateNumbers() {
        return plateNumber;
    }

    /**
     * @param plateNumber the plateNumber to set
     */
    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * @return the plateLetters
     */
    public String getPlateLetters() {
        return plateLetters;
    }

    /**
     * @param plateLetters the plateLetters to set
     */
    public void setPlateLetters(String plateLetters) {
        this.plateLetters = plateLetters;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
    public String getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(String capacity) {
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
     * @return the shippingList
     */
    public List<ShippingVo> getShippingList() {
        return shippingList;
    }

    /**
     * @param shippingList the shippingList to set
     */
    public void setShippingList(List<ShippingVo> shippingList) {
        this.shippingList = shippingList;
    }

    /**
     * @return the idPoint
     */
    public Integer getIdPoint() {
        return idPoint;
    }

    /**
     * @param idPoint the idPoint to set
     */
    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
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

    @Override
    public String toString() {
        return "VehicleVo{" 
                + "\n\tidVehicle=" + idVehicle 
                + ",\n\t plateNumber=" + plateNumber 
                + ",\n\t plateLetters=" + plateLetters 
                + ",\n\t type=" + type 
                + ",\n\t manufacturer=" + manufacturer 
                + ",\n\t model=" + model 
                + ",\n\t capacity=" + capacity 
                + ",\n\t status=" + status 
                + ",\n\t shippingList=" + shippingList 
                + ",\n\t idPoint=" + idPoint 
                + ",\n\t idDriver=" + idDriver + '}';
    }
}
