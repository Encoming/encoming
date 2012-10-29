
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.AdministratorFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.entity.Administrator;
import com.encoming.encoming.vo.AdministratorVo;
import com.encoming.encoming.vo.PersonVo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class tableBeanEmpleados {

    List <AdministratorVo> employeesAdm;
    ArrayList<PersonVo> employees;

    public tableBeanEmpleados() {
        employeesAdm = new ArrayList();
        employees = new ArrayList();
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade();  
        employeesAdm = adminFac.getList();
        for(AdministratorVo admVo : employeesAdm){
            PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade();
            employees.add(personFac.find(admVo.getPersonidPerson()));
        }
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

    
    
    
}