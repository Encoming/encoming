package com.encoming.businesslogic.facade;

import com.encoming.businesslogic.service.ServiceFactory;


/**
 *
 * @author Alexander
 */
public class FacadeFactory {

    private String PU = "FinalPU";

    private FacadeFactory() {
    }

    public CursoFacade getCursoFacade() {
        return new CursoFacade(PU, ServiceFactory.getInstance().getCursoService());
    }
    
    private static FacadeFactory instance;

    public static synchronized FacadeFactory getInstance() {
        if (instance == null) {
            instance = new FacadeFactory();
        }
        return instance;
    }
}
