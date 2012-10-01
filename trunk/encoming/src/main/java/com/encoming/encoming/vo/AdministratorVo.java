/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class AdministratorVo implements IValueObject{
    private Integer idAdministrator;
    private String username;
    private String password;
    private Integer idWorker;

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
     * @return the idWorker
     */
    public Integer getIdWorker() {
        return idWorker;
    }

    /**
     * @param idWorker the idWorker to set
     */
    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
    }
    
    
}
