/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.ServiceFactory;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class FacadeFactory {

    private String PU = "encoming";
    private static FacadeFactory instance;

    public static synchronized FacadeFactory getInstance() {
        if (instance == null) {
            instance = new FacadeFactory();
        }
        return instance;
    }

    public AdministratorFacade getAdministratorFacade() {
        return new AdministratorFacade(PU, ServiceFactory.getInstance().getAdministratorService());
    }
}