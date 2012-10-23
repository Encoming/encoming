/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.AdministratorFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.vo.AdministratorVo;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    @ManagedProperty(value = "#{userBean}")
    private AdministratorBean user;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
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
     * @return the user
     */
    public AdministratorBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(AdministratorBean user) {
        this.user = user;
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

    public String login() {
        AdministratorVo administratorVo = new AdministratorVo();
        AdministratorFacade administratorFacade = FacadeFactory.getInstance().getAdministratorFacade();

        administratorVo.setUsername(getUsername());
        administratorVo.setPassword(getPassword());

        AdministratorVo login = administratorFacade.login(administratorVo);

        if (login != null) {
            user.setUsername(login.getUsername());
            user.setType(login.getType());
            user.setPersonidPerson(login.getPersonidPerson());
            user.setLoggedIn(true);
            return "success";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    "loginForm:idUser", new FacesMessage(
                    "Id de usuario o contraseña inválidos"));
            return "failure";
        }
    }
}
