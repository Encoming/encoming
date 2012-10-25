/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Vehicle.findByPlateNumber", query = "SELECT v FROM Vehicle v WHERE v.plateNumber = :plateNumber"),
    @NamedQuery(name = "Vehicle.findByPlateLetters", query = "SELECT v FROM Vehicle v WHERE v.plateLetters = :plateLetters"),
    @NamedQuery(name = "Vehicle.findByType", query = "SELECT v FROM Vehicle v WHERE v.type = :type"),
    @NamedQuery(name = "Vehicle.findByManufacturer", query = "SELECT v FROM Vehicle v WHERE v.manufacturer = :manufacturer"),
    @NamedQuery(name = "Vehicle.findByModel", query = "SELECT v FROM Vehicle v WHERE v.model = :model"),
    @NamedQuery(name = "Vehicle.findByCapacity", query = "SELECT v FROM Vehicle v WHERE v.capacity = :capacity"),
    @NamedQuery(name = "Vehicle.findByStatus", query = "SELECT v FROM Vehicle v WHERE v.status = :status"),
    @NamedQuery(name = "Vehicle.findByIdVehicle", query = "SELECT v FROM Vehicle v WHERE v.idVehicle = :idVehicle")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "capacity")
    private int capacity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVehicle")
    private Integer idVehicle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleidVehicle")
    private List<Encoming> encomingList;
    @JoinColumn(name = "driver", referencedColumnName = "idDriver")
    @ManyToOne(optional = false)
    private Driver driver;
    @JoinColumn(name = "Point_idPoint", referencedColumnName = "idPoint")
    @ManyToOne
    private Point pointidPoint;

    public Vehicle() {
    }

    public Vehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public Vehicle(Integer idVehicle, int plateNumber, String plateLetters, String type, String manufacturer, String model, int capacity, String status) {
        this.idVehicle = idVehicle;
        this.plateNumber = plateNumber;
        this.plateLetters = plateLetters;
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
        this.status = status;
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

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public List<Encoming> getEncomingList() {
        return encomingList;
    }

    public void setEncomingList(List<Encoming> encomingList) {
        this.encomingList = encomingList;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Point getPointidPoint() {
        return pointidPoint;
    }

    public void setPointidPoint(Point pointidPoint) {
        this.pointidPoint = pointidPoint;
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
        return "com.encoming.encoming.entity.Vehicle[ idVehicle=" + idVehicle + " ]";
    }
}
