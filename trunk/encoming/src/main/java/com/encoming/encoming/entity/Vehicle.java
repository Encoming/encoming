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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Vehicle")
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findByIdVehicle", query = "SELECT v FROM Vehicle v WHERE v.idVehicle = :idVehicle"),
    @NamedQuery(name = "Vehicle.findByPlateNumber", query = "SELECT v FROM Vehicle v WHERE v.plateNumber = :plateNumber"),
    @NamedQuery(name = "Vehicle.findByPlateLetters", query = "SELECT v FROM Vehicle v WHERE v.plateLetters = :plateLetters"),
    @NamedQuery(name = "Vehicle.findByType", query = "SELECT v FROM Vehicle v WHERE v.type = :type"),
    @NamedQuery(name = "Vehicle.findByManufacturer", query = "SELECT v FROM Vehicle v WHERE v.manufacturer = :manufacturer"),
    @NamedQuery(name = "Vehicle.findByModel", query = "SELECT v FROM Vehicle v WHERE v.model = :model"),
    @NamedQuery(name = "Vehicle.findByCapacity", query = "SELECT v FROM Vehicle v WHERE v.capacity = :capacity"),
    @NamedQuery(name = "Vehicle.findByStatus", query = "SELECT v FROM Vehicle v WHERE v.status = :status")})
public class Vehicle implements Serializable, IEntity<VehicleVo> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVehicle")
    private Integer idVehicle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plateNumber")
    private int plateNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "plateLetters")
    private String plateLetters;
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
    @Size(min = 1, max = 10)
    @Column(name = "capacity")
    private String capacity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private List<Shipping> shippingList;
    @JoinColumn(name = "Point_idPoint", referencedColumnName = "idPoint")
    @ManyToOne
    private Point point;
    @JoinColumn(name = "Driver_idDriver", referencedColumnName = "idDriver")
    @ManyToOne(optional = false)
    private Driver driver;

    public Vehicle() {
    }

    public Vehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public Vehicle(Integer idVehicle, int plateNumber, String plateLetters, String type, String manufacturer, String model, String capacity, String status) {
        this.idVehicle = idVehicle;
        this.plateNumber = plateNumber;
        this.plateLetters = plateLetters;
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
        this.status = status;
    }

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Shipping> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Shipping> shippingList) {
        this.shippingList = shippingList;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicle != null ? idVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.idVehicle == null && other.idVehicle != null) || (this.idVehicle != null && !this.idVehicle.equals(other.idVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.pruebaelementos.Vehicle[ idVehicle=" + idVehicle + " ]";
    }

    @Override
    public VehicleVo toVo() {
        VehicleVo vehicleVo = new VehicleVo();
        vehicleVo.setIdVehicle(getIdVehicle());
        vehicleVo.setIdDriver(getDriver().getIdDriver());
        vehicleVo.setIdPoint(getPoint().getIdPoint());
        vehicleVo.setCapacity(getCapacity());
        vehicleVo.setManufacturer(getManufacturer());
        vehicleVo.setModel(getModel());
        vehicleVo.setPlateLetters(getPlateLetters());
        vehicleVo.setPlateNumber(getPlateNumber());
        vehicleVo.setStatus(getStatus());
        vehicleVo.setType(getType());
        List<ShippingVo> shippingVos = new ArrayList<ShippingVo>();
         for(Shipping entity : getShippingList()){
         shippingVos.add(entity.toVo());
         }
         vehicleVo.setShippingList(shippingVos);
        return vehicleVo;
    }
}
