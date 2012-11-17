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

    private String PU = "encomingPU";
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

    public PointFacade getPointFacade() {
        return new PointFacade(PU, ServiceFactory.getInstance().getPointService());
    }

    public PersonFacade getPersonFacade() {
        return new PersonFacade(PU, ServiceFactory.getInstance().getPersonService());
    }

    public DriverFacade getDriverFacade() {
        return new DriverFacade(PU, ServiceFactory.getInstance().getDriverService());
    }

    public VehicleFacade getVehicleFacade() {
        return new VehicleFacade(PU, ServiceFactory.getInstance().getVehicleService());
    }

    public EncomingFacade getEncomingFacade() {
        return new EncomingFacade(PU, ServiceFactory.getInstance().getEncomingService());
    }

    public ShippingFacade getShippingFacade() {
        return new ShippingFacade(PU, ServiceFactory.getInstance().getShippingService());
    }
    
    public InvoiceFacade getInvoiceFacade() {
        return new InvoiceFacade(PU, ServiceFactory.getInstance().getInvoiceService());
    }
    
    public RouteFacade getRouteFacade() {
        return new RouteFacade(PU, ServiceFactory.getInstance().getRouteService());
    }
}
