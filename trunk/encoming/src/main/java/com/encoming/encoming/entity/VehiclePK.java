/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.VehiclePKVo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author andres
 */
@Embeddable
public class VehiclePK implements Serializable,IEntity<VehiclePKVo> {
    @Basic(optional = false)
    @NotNull
    @Column(name = "plateNumber")
    private int plateNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "plateLetters")
    private String plateLetters;

    public VehiclePK() {
    }

    public VehiclePK(int plateNumber, String plateLetters) {
        this.plateNumber = plateNumber;
        this.plateLetters = plateLetters;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateLetters() {
        return plateLetters;
    }

    public void setPlateLetters(String plateLetters) {
        this.plateLetters = plateLetters;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) plateNumber;
        hash += (plateLetters != null ? plateLetters.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiclePK)) {
            return false;
        }
        VehiclePK other = (VehiclePK) object;
        if (this.plateNumber != other.plateNumber) {
            return false;
        }
        if ((this.plateLetters == null && other.plateLetters != null) || (this.plateLetters != null && !this.plateLetters.equals(other.plateLetters))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.VehiclePK[ plateNumber=" + plateNumber + ", plateLetters=" + plateLetters + " ]";
    }
    
    public VehiclePKVo toVo(){
        VehiclePKVo vehiclePKVo = new VehiclePKVo();
        vehiclePKVo.setPlateNumber(getPlateNumber());
        vehiclePKVo.setPlateLetters(getPlateLetters());
        return vehiclePKVo;
    }
    
}
