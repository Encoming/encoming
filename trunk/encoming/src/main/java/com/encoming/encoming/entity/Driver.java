/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.DriverVo;
import com.encoming.encoming.vo.ShippingVo;
import com.encoming.encoming.vo.VehicleVo;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author andres
 */
@Entity
@Table(name = "driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findByIdDriver", query = "SELECT d FROM Driver d WHERE d.idDriver = :idDriver"),
    @NamedQuery(name = "Driver.findByLicense", query = "SELECT d FROM Driver d WHERE d.license = :license")})
public class Driver implements Serializable,IEntity<DriverVo>{
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
  /*  @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private List<Vehicle> vehicleList = null;*/
    @JoinColumn(name = "Person_idPerson", referencedColumnName = "idPerson")
    @ManyToOne(optional = false)
    private Person personidPerson;

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

  /*  @XmlTransient
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }*/

    public Person getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(Person personidPerson) {
        this.personidPerson = personidPerson;
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
    
        @Override
    public DriverVo toVo(){
        DriverVo driverVo = new DriverVo();
        driverVo.setIdDriver(getIdDriver());
        driverVo.setLicense(getLicense());        
       /*     System.out.println("llega antes de pasar el list de vehiculos");
        List<VehicleVo> vehicleVos = new ArrayList<VehicleVo>();
        if(getVehicleList()!= null){
            System.out.println("ENTRA EN EL FOR");
        for(Vehicle entity : getVehicleList()){
            vehicleVos.add(entity.toVo());
        }
        System.out.println("pasa el for");
        driverVo.setVehicleList(vehicleVos);
        }   */
        driverVo.setPersonidPerson(getPersonidPerson().getIdPerson());
        return driverVo;
    }
    
}
