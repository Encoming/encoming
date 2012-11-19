
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.AdministratorFacade;
import com.encoming.encoming.businesslogic.facade.DriverFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.entity.Administrator;
import com.encoming.encoming.vo.AdministratorVo;
import com.encoming.encoming.vo.DriverVo;
import com.encoming.encoming.vo.PersonVo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class tableBeanEmpleados {

    List <AdministratorVo> employeesAdm;
    List <DriverVo> employeesDriv;
    ArrayList<PersonVo> employees;
    ArrayList<PersonVo> employeesDrivers;
    private List<PersonVo> filteredEmployees;  
    private List<PersonVo> filteredDriverEmployees;  



    public tableBeanEmpleados() {
        employeesAdm = new ArrayList();
        employeesDriv = new ArrayList();
        employeesDrivers = new ArrayList();
        employees = new ArrayList();

        
        
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade(); 
        DriverFacade driverFac = FacadeFactory.getInstance().getDriverFacade(); 
        
        employeesAdm = adminFac.getList();
        employeesDriv = driverFac.getList();
        
        for(AdministratorVo admVo : employeesAdm){
            System.out.println("entra!! en ADMIN");
            PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade();
            employees.add(personFac.find(admVo.getPersonidPerson())); 
        
        }
        for(DriverVo driverVo : employeesDriv){
            System.out.println("ENTRA! EN DRIVER VO");
            PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade();
            employeesDrivers.add(personFac.find(driverVo.getPersonId()));    
           
            System.out.println("AGREGO UN DVO");
        }
        
        filteredEmployees = employees; 
    }

    public List<PersonVo> getFilteredEmployees() {
                      
        return filteredEmployees;
    }

    public void setFilteredEmployees(List<PersonVo> filteredEmployees) {
        this.filteredEmployees = filteredEmployees;
    }

    public List<AdministratorVo> getEmployeesAdm() {
        return employeesAdm;
    }

    public void setEmployeesAdm(List<AdministratorVo> employeesAdm) {
        this.employeesAdm = employeesAdm;
    }

    public ArrayList<PersonVo> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<PersonVo> employees) {
        this.employees = employees;
    }

    public List<DriverVo> getEmployeesDriv() {
        return employeesDriv;
    }

    public void setEmployeesDriv(List<DriverVo> employeesDriv) {
        this.employeesDriv = employeesDriv;
    }

    public ArrayList<PersonVo> getEmployeesDrivers() {
        return employeesDrivers;
    }

    public void setEmployeesDrivers(ArrayList<PersonVo> employeesDrivers) {
        this.employeesDrivers = employeesDrivers;
    }

    public List<PersonVo> getFilteredDriverEmployees() {
        return filteredDriverEmployees;
    }

    public void setFilteredDriverEmployees(List<PersonVo> filteredDriverEmployees) {
        this.filteredDriverEmployees = filteredDriverEmployees;
    }


    
    
    
}