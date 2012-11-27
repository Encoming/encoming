/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author FAMILIA
 */
//@ManagedBean
//@RequestScoped
@FacesValidator(value = "emailValidatorBean")
public class EmailValidatorBean implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        String email = String.valueOf(value);
        boolean valid = true;
        if (email.length() == 0) {
            valid = true;
        } else {
            if (!email.endsWith("@gmail.com")
                    && !email.endsWith("@hotmail.com")
                    && !email.endsWith("@yahoo.es")
                    && !email.endsWith("@unal.edu.co")) {
                valid = false;
            }
            if (email.indexOf('@') < 4 || email.indexOf('@') > 20) {
                valid = false;
            }
        }
        if (!valid) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "¡Dirección Email Inválida, Ingrese un Dominio Válido!",
                    "¡La dirección de correo electrónico que ha introducido no es válido!");
            throw new ValidatorException(message);
        }
    }
}
