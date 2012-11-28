/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.AdministratorFacade;
import com.encoming.encoming.businesslogic.facade.DriverFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.vo.AdministratorVo;
import com.encoming.encoming.vo.PersonVo;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

    public void find() {
        PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade();
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade();

        auxPerson = personFac.find(this.id);

    }

    public void delete() {
        Object auxi;
        System.out.println("entro");
        System.out.println("id a buscar : " + auxPerson.getIdPerson());
        System.out.println("entro2");
        PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade();
        DriverFacade drivFac = FacadeFactory.getInstance().getDriverFacade();
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade();
        System.out.println("*******************crea las instanias");
        // try to delete a adminstrator and if it isn't then try to delete as a driver

        //adminFac.delete(auxPerson.getIdPerson());
        try {
            personFac.delete(auxPerson.getIdPerson());
            auxPerson = null;
            id = null;
            addMessage("Los datos fueron borrados");
        } catch (Exception e) {
            addMessage("Error! Los datos no pudieron ser guardados");
        }


    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
