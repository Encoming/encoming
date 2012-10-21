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

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Worker")
@NamedQueries({
    @NamedQuery(name = "Worker.findAll", query = "SELECT w FROM Worker w"),
    @NamedQuery(name = "Worker.findByIdWorker", query = "SELECT w FROM Worker w WHERE w.idWorker = :idWorker"),
    @NamedQuery(name = "Worker.findBySalary", query = "SELECT w FROM Worker w WHERE w.salary = :salary")})
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idWorker")
    private Integer idWorker;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private double salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "worker")
    private List<Driver> driverList;
    @JoinColumn(name = "person", referencedColumnName = "idPerson")
    @ManyToOne(optional = false)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "worker")
    private List<Administrator> administratorList;

    public Worker() {
    }

    public Worker(Integer idWorker) {
        this.idWorker = idWorker;
    }

    public Worker(Integer idWorker, double salary) {
        this.idWorker = idWorker;
        this.salary = salary;
    }

    public Integer getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Administrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<Administrator> administratorList) {
        this.administratorList = administratorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWorker != null ? idWorker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Worker)) {
            return false;
        }
        Worker other = (Worker) object;
        if ((this.idWorker == null && other.idWorker != null) || (this.idWorker != null && !this.idWorker.equals(other.idWorker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Worker[ idWorker=" + idWorker + " ]";
    }
    
}
