/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ServiceFactory {

    private static ServiceFactory instance;

    public static synchronized ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public AdministratorService getAdministratorService() {
        return AdministratorService.getInstance();
    }

    public PointService getPointService() {
        return PointService.getInstance();
    }

    public PersonService getPersonService() {
        return PersonService.getInstance();
    }

    public DriverService getDriverService() {
        return DriverService.getInstance();
    }

    public VehicleService getVehicleService() {
        return VehicleService.getInstance();
    }

    public EncomingService getEncomingService() {
        return EncomingService.getInstance();
    }

    public ShippingService getShippingService() {
        return ShippingService.getInstance();
    }

    public InvoiceService getInvoiceService() {
        return InvoiceService.getInstance();
    }

    public RouteService getRouteService() {
        return RouteService.getInstance();
    }
}
