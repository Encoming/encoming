/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.encoming.encoming.presentation.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
*
* @author FAMILIA
*/

@ManagedBean
@SessionScoped
public class AdministratorBean implements Serializable {
    private Integer idAdministrator;
    private String username;
    //private String password;
    private Integer personidPerson;
    private boolean loggedIn;
    
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


    /*public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}*/

    public Integer getPersonidPerson() {
        return personidPerson;
    }

    /**
* @param personidPerson the personidPerson to set
*/
    public void setPersonidPerson(Integer personidPerson) {
        this.personidPerson = personidPerson;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public String logOut() {
        idAdministrator = null;
        username = null;
        personidPerson = null;
        loggedIn = false;
        return "logout";
    }
}