/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class DAOFactory {

    public ClienteDAO getAdministratorDAO() {
        return ClienteDAO.getInstance();
    }
    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
}
