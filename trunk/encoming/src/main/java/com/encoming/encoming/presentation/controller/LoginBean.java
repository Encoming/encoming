/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.vo.PersonVo;
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

    private Integer document;
    private String password;
    @ManagedProperty(value = "#{userBean}")
    private PersonBean user;

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
    public PersonBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(PersonBean user) {
        this.user = user;
    }

    /**
     * @return the document
     */
    public Integer getDocument() {
        return document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(Integer document) {
        this.document = document;
    }

    public String login() {
        PersonVo personVo = new PersonVo();
        PersonFacade personFacade = FacadeFactory.getInstance().getPersonFacade();

        personVo.setIdPerson(getDocument());
        personVo.setPassword(getPassword());

        PersonVo login = personFacade.login(personVo);

        if (login != null) {
            user.setIdPerson(login.getIdPerson());
            user.setName(login.getName());
            user.setLastName(login.getLastName());
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
