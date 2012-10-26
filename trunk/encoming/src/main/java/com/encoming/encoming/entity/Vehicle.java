/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.ShippingVo;
import com.encoming.encoming.vo.VehicleVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findByPlateNumber", query = "SELECT v FROM Vehicle v WHERE v.vehiclePK.plateNumber = :plateNumber"),
    @NamedQuery(name = "Vehicle.findByPlateLetters", query = "SELECT v FROM Vehicle v WHERE v.vehiclePK.plateLetters = :plateLetters"),
    @NamedQuery(name = "Vehicle.findByType", query = "SELECT v FROM Vehicle v WHERE v.type = :type"),
    @NamedQuery(name = "Vehicle.findByManufacturer", query = "SELECT v FROM Vehicle v WHERE v.manufacturer = :manufacturer"),
    @NamedQuery(name = "Vehicle.findByModel", query = "SELECT v FROM Vehicle v WHERE v.model = :model"),
    @NamedQuery(name = "Vehicle.findByCapacity", query = "SELECT v FROM Vehicle v WHERE v.capacity = :capacity"),
    @NamedQuery(name = "Vehicle.findByStatus", query = "SELECT v FROM Vehicle v WHERE v.status = :status")})
public class Vehicle implements Serializable,IEntity<VehicleVo> {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private VehiclePK vehiclePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private int capacity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private List<Shipping> shippingList;
    @JoinColumn(name = "Driver_idDriver", referencedColumnName = "idDriver")
    @ManyToOne(optional = false)
    private Driver driveridDriver;

    public Vehicle() {
    }

    public Vehicle(VehiclePK vehiclePK) {
        this.vehiclePK = vehiclePK;
    }

    public Vehicle(VehiclePK vehiclePK, String type, String manufacturer, String model, int capacity, String status) {
        this.vehiclePK = vehiclePK;
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
        this.status = status;
    }

    public Vehicle(int plateNumber, String plateLetters) {
        this.vehiclePK = new VehiclePK(plateNumber, plateLetters);
    }

    public VehiclePK getVehiclePK() {
        return vehiclePK;
    }

    public void setVehiclePK(VehiclePK vehiclePK) {
        this.vehiclePK = vehiclePK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Shipping> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Shipping> shippingList) {
        this.shippingList = shippingList;
    }

    public Driver getDriveridDriver() {
        return driveridDriver;
    }

    public void setDriveridDriver(Driver driveridDriver) {
        this.driveridDriver = driveridDriver;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehiclePK != null ? vehiclePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.vehiclePK == null && other.vehiclePK != null) || (this.vehiclePK != null && !this.vehiclePK.equals(other.vehiclePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Vehicle[ vehiclePK=" + vehiclePK + " ]";
    }
    
    // --- Vehicle
    @Override
    public VehicleVo toVo(){
        VehicleVo vehicleVo = new VehicleVo();
        vehicleVo.setIdVehiclePK(getVehiclePK().getPlateNumber());
        vehicleVo.setType(getType());
        vehicleVo.setManufacturer(getManufacturer());
        vehicleVo.setModel(getModel());
        vehicleVo.setCapacity(getCapacity());
        vehicleVo.setStatus(getStatus());
                List<ShippingVo> shippingVos = new ArrayList<ShippingVo>();
        for(Shipping entity : getShippingList()){
            shippingVos.add(entity.toVo());
        }
        vehicleVo.setShippingList(shippingVos);
        vehicleVo.setIdDriver(getDriveridDriver().getIdDriver());        
        return vehicleVo;
    } 
    
}
