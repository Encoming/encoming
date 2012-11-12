/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.AdministratorFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.vo.PersonVo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author THOKK
 */
@ManagedBean
@SessionScoped
public class removeEmployeeBean {
        
    private Integer id;
    private PersonVo auxPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonVo getAuxPerson() {
        return auxPerson;
    }

    public void setAuxPerson(PersonVo auxPerson) {
        this.auxPerson = auxPerson;
    }
    
    public removeEmployeeBean() {
    }
    
        public void find(){
        PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade(); 
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade();   
        
        auxPerson = personFac.find(this.id);
        
    }
    
    public void delete(){
        System.out.println("entro");
        System.out.println("id a buscar : " + auxPerson.getIdPerson());
        System.out.println("entro2");
        PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade(); 
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade();   
        System.out.println("*******************crea las instanias");
        adminFac.delete(auxPerson.getIdPerson());
         System.out.println("*******************borra el admin");
        personFac.delete(auxPerson.getIdPerson());
         System.out.println("*******************borro la persona");
        auxPerson = null;
        id = null;
    }
}
