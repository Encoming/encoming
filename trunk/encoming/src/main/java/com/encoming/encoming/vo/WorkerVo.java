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
public class WorkerVo implements IValueObject{
    
    private Integer idWorker;
    private Integer salary;
    private List<DriverVo> driverList;
    private Integer idPerson;
    private List<AdministratorVo> administratorList;

    /**
     * @return the idWorker
     */
    public Integer getIdWorker() {
        return idWorker;
    }

    /**
     * @param idWorker the idWorker to set
     */
    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
    }

    /**
     * @return the salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     * @return the driverList
     */
    public List<DriverVo> getDriverList() {
        return driverList;
    }

    /**
     * @param driverList the driverList to set
     */
    public void setDriverList(List<DriverVo> driverList) {
        this.driverList = driverList;
    }

    /**
     * @return the idPerson
     */
    public Integer getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    /**
     * @return the administratorList
     */
    public List<AdministratorVo> getAdministratorList() {
        return administratorList;
    }

    /**
     * @param administratorList the administratorList to set
     */
    public void setAdministratorList(List<AdministratorVo> administratorList) {
        this.administratorList = administratorList;
    }
    
}
