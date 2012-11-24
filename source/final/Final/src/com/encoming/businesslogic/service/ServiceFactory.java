package com.encoming.businesslogic.service;

/**
 *
 * @author Alexander
 */
public class ServiceFactory {

    private ServiceFactory() {
    }

    public CursoService getCursoService() {
        return CursoService.getInstance();
    }
    
    public EstudianteService getEstudianteService() {
        return EstudianteService.getInstance();
    }
    
    public InscripcionService getInscripcionService() {
        return InscripcionService.getInstance();
    }
   
    private static ServiceFactory instance;

    public static synchronized ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }  
}
