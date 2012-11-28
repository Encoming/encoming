/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.DriverFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.vo.DriverVo;
import com.encoming.encoming.vo.PersonVo;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author THOKK
 */
@ManagedBean
@RequestScoped
public class AddDriverEmployeeBean {

    private Integer idPerson;
    private String name;
    private String lastName;
    private String mail;
    private Integer phone;
    private String adress;
    
    private String license;
    private Integer idDriver;

    public AddDriverEmployeeBean() {
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }
    
    
    public void addDriver(){
        PersonVo personVo = new PersonVo();
        System.out.println("crea la persona");
        personVo.setAdress(adress);
        personVo.setIdPerson(idPerson);
        personVo.setLastName(lastName);
        personVo.setMail(mail);
        personVo.setName(name);
        personVo.setPhone(phone);
        
        
        DriverVo driverVo = new DriverVo();
        driverVo.setIdDriver(idDriver);
        driverVo.setLicense(license);
        driverVo.setPersonId(idPerson);
        System.out.println("ya casi");
        PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade(); 
        DriverFacade driverFac = FacadeFactory.getInstance().getDriverFacade();
        System.out.println("crea las instancias");
        try {
        personFac.persist(personVo);
        System.out.println("persiste la persona");
        driverFac.persist(driverVo);
        System.out.println("persiste al driver");
            addMessage("Los datos fueron guardados");
        } catch (Exception e) {
            addMessage("¡Los datos no pudieron ser guardados!");
        }
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
