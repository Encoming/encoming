/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.AdministratorFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.vo.AdministratorVo;
import com.encoming.encoming.vo.PersonVo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author THOKK
 */
@ManagedBean
@RequestScoped
public class AddEmployeeBean {

    private Integer idPerson;
    private String name;
    private String lastName;
    private String mail;
    private Integer phone;
    private String adress;
    
    private Integer idAdministrator;
    private String username;
    private String password;
    private Integer personidPerson;

    public Integer getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(Integer personidPerson) {
        this.personidPerson = personidPerson;
    }

    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public AddEmployeeBean() {
    }
    public void addEmployee(){
        this.personidPerson = idPerson;
        PersonVo personVo = new PersonVo();
        personVo.setAdress(adress);
        personVo.setIdPerson(idPerson);
        personVo.setLastName(lastName);
        personVo.setMail(mail);
        personVo.setName(name);
        personVo.setPhone(phone);
        
        AdministratorVo adminVo = new AdministratorVo();
        adminVo.setIdAdministrator(idAdministrator);
        adminVo.setPassword(password);
        adminVo.setUsername(username);     
        adminVo.setPersonidPerson(personidPerson);
        
        PersonFacade personFac = FacadeFactory.getInstance().getPersonFacade(); 
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade();   
        
        personFac.persist(personVo);
        adminFac.persist(adminVo);
    }
}
