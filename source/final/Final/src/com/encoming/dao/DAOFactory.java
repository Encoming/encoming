package com.encoming.dao;

/**
 *
 * @author Jmmartinezro
 */
public class DAOFactory {

    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    private DAOFactory() {
    }

    public EstudianteDAO getEstudianteDAO() {
        return EstudianteDAO.getInstance();
    }
    
    public CursoDAO getCursoDAO() {
        return CursoDAO.getInstance();
    }
    
    public InscripcionDAO getInscripcionDAO() {
        return InscripcionDAO.getInstance();
    }
}
