/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.AdministratorFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.vo.AdministratorVo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
*
* @author juanmanuelmartinezromero
*/
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable{

    private String username;
    private String password;
    @ManagedProperty(value = "#{administratorBean}")
    private AdministratorBean user;

    public LoginBean() {
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

    public AdministratorBean getUser() {
        return user;
    }

    public void setUser(AdministratorBean user) {
        this.user = user;
    }

    public String login() {
        AdministratorVo administratorVo = new AdministratorVo();
        AdministratorFacade administratorFacade = FacadeFactory.getInstance().getAdministratorFacade();

        administratorVo.setUsername(getUsername());
        administratorVo.setPassword(getPassword());

        AdministratorVo login = administratorFacade.login(administratorVo);

        if (login != null) {
            user.setUsername(login.getUsername());
            user.setPersonidPerson(login.getPersonidPerson());
            user.setLoggedIn(true);
            return "success";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    "loginForm:idUser", new FacesMessage(
                    "¡Id de usuario o contraseña inválidos!"));
            return "failure";
        }
    }
}
