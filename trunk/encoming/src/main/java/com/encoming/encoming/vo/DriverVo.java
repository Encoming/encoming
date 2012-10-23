/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import com.encoming.encoming.entity.Person;
import java.util.List;

/**
 *
 * @author germanpineros
 */
public class DriverVo implements IValueObject{
    
    private Integer idDriver;
    private String license;
    private List<VehicleVo> vehicleList;
    private Person personidPerson;

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

    /**
     * @return the personidPerson
     */
    public Person getPersonidPerson() {
        return personidPerson;
    }

    /**
     * @param personidPerson the personidPerson to set
     */
    public void setPersonidPerson(Person personidPerson) {
        this.personidPerson = personidPerson;
    }

  
}
