
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

    }
    public ArrayList<PersonVo> getEmployees(){
        PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade();
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade();  
        employeesAdm = adminFac.getList();
        for(AdministratorVo admVo : employeesAdm){
            employees.add(personFac.find(admVo.getPersonidPerson()));
        }
        return employees;
    }

    public void setEmployees(ArrayList<PersonVo> employees) {
        this.employees = employees;
    }
    
    
}