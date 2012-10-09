/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

/**
 *
 * @author germanpineros
 */
public class VehiclePKVo implements IValueObject{
    
    private Integer plateNumber;
    private String plateLetters;

    /**
     * @return the plateNumber
     */
    public Integer getPlateNumber() {
        return plateNumber;
    }

    /**
     * @param plateNumber the plateNumber to set
     */
    public void setPlateNumber(Integer plateNumber) {
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
    
}
