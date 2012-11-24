package com.encoming.businesslogic.facade;

import com.encoming.businesslogic.service.ServiceFactory;

/**
 *
 * @author Alexander
 */
public class FacadeFactory {

    private String PU = "FinalPU";
    private static FacadeFactory instance;

    public static synchronized FacadeFactory getInstance() {
        if (instance == null) {
            instance = new FacadeFactory();
        }
        return instance;
    }

    private FacadeFactory() {
    }

    public CursoFacade getCursoFacade() {
        return new CursoFacade(PU, ServiceFactory.getInstance().getCursoService());
    }

    public EstudianteFacade getEstudianteFacade() {
        return new EstudianteFacade(PU, ServiceFactory.getInstance().getEstudianteService());
    }

    public InscripcionFacade getInscripcionFacade() {
        return new InscripcionFacade(PU, ServiceFactory.getInstance().getInscripcionService());
    }
}
