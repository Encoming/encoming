/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import com.encoming.encoming.entity.Person;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class AdministratorVo implements IValueObject{
    private Integer idAdministrator;
    private String username;
    private String password;
    private String type;
    private Integer personidPerson;

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
   
    
}
