/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class DAOFactory {

    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public AdministratorDAO getAdministratorDAO() {
        return AdministratorDAO.getInstance();
    }

    public PointDAO getPointDAO() {
        return PointDAO.getInstance();
    }

    public PersonDAO getPersonDAO() {
        return PersonDAO.getInstance();
    }

    public DriverDAO getDriverDAO() {
        return DriverDAO.getInstance();
    }

    public VehicleDAO getVehicleDAO() {
        return VehicleDAO.getInstance();
    }

    public EncomingDAO getEncomingDAO() {
        return EncomingDAO.getInstance();
    }
    public RouteDAO getRouteDAO() {
        return RouteDAO.getInstance();
    }
    public ShippingDAO getShippingDAO(){
        return ShippingDAO.getInstance();
    }
}
