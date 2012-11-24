package com.encoming.dao;

/**
 *
 * @author Jmmartinezro
 */
public class DAOFactory {

    private DAOFactory() {
    }

    public CursoDAO getCursoDAO() {
        return CursoDAO.getInstance();
    }
    
    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
}
