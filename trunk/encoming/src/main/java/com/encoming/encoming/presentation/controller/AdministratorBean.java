/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import java.io.Serializable;

/**
 *
 * @author FAMILIA
 */
public class AdministratorBean implements Serializable {
    private Integer idAdministrator;
    private String username;
    private String password;
    private String type;
    private Integer personidPerson;
    private boolean loggedIn;
    
     /**
     * Creates a new instance of AdministratorBean
     */
    public AdministratorBean() {
    }

    /**
     * @return the idAdministrator
     */
    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    /**
     * @param idAdministrator the idAdministrator to set
     */
    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the personidPerson
     */
    public Integer getPersonidPerson() {
        return personidPerson;
    }

    /**
     * @param personidPerson the personidPerson to set
     */
    public void setPersonidPerson(Integer personidPerson) {
        this.personidPerson = personidPerson;
    }

    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public String logOut() {
        setIdAdministrator(null);
        setPersonidPerson(null);
        setType(null);
        setUsername(null);
        setPassword(null);
        setLoggedIn(false);
        return "logout";
    }
    
}
