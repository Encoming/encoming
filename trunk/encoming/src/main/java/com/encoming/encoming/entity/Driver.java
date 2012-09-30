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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findByIdDriver", query = "SELECT d FROM Driver d WHERE d.idDriver = :idDriver"),
    @NamedQuery(name = "Driver.findByLicense", query = "SELECT d FROM Driver d WHERE d.license = :license")})
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDriver")
    private Integer idDriver;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "license")
    private String license;
    @JoinColumn(name = "Worker_idWorker", referencedColumnName = "idWorker")
    @ManyToOne(optional = false)
    private Worker workeridWorker;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driveridDriver")
    private List<Vehicle> vehicleList;

    public Driver() {
    }

    public Driver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public Driver(Integer idDriver, String license) {
        this.idDriver = idDriver;
        this.license = license;
    }

    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Worker getWorkeridWorker() {
        return workeridWorker;
    }

    public void setWorkeridWorker(Worker workeridWorker) {
        this.workeridWorker = workeridWorker;
    }

    @XmlTransient
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDriver != null ? idDriver.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.idDriver == null && other.idDriver != null) || (this.idDriver != null && !this.idDriver.equals(other.idDriver))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Driver[ idDriver=" + idDriver + " ]";
    }
    
}
