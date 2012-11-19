/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.vo.PointVo;
import com.encoming.encoming.vo.RouteVo;
import com.encoming.encoming.vo.ShippingVo;
import com.encoming.encoming.vo.VehicleVo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean
@RequestScoped
public class OptimalRouteBean {

    double routeDistance;
    RouteVo route;
    PointVo origin;
    PointVo destiny;
    String originCoordinates;
    String destinyCoordinates;

    /**
     * Creates a new instance of OptimalRouteBean
     */
    public OptimalRouteBean() {
        VehicleVo vehicleVo = FacadeFactory.getInstance().getVehicleFacade().find(2);
        ShippingVo shippingVo = vehicleVo.getShippingList().get(1);
        route = FacadeFactory.getInstance().getRouteFacade().find(shippingVo.getIdRoute());
        route.setIdRoute(shippingVo.getIdRoute());
        origin = FacadeFactory.getInstance().getPointFacade().find(route.getOriginPointId());
        destiny = FacadeFactory.getInstance().getPointFacade().find(route.getDestinationPointId());
    }

    public RouteVo getRoute() {
        return route;
    }

    public void setRoute(RouteVo route) {
        this.route = route;
    }

    public PointVo getOrigin() {
        return origin;
    }

    public void setOrigin(PointVo origin) {
        this.origin = origin;
    }

    public PointVo getDestiny() {
        return destiny;
    }

    public void setDestiny(PointVo destiny) {
        this.destiny = destiny;
    }

    public String getOriginCoordinates() {
        return originCoordinates = origin.getLatitude() + ", " + origin.getLongitude();
    }

    public String getDestinyCoordinates() {
        return destinyCoordinates = destiny.getLatitude() + ", " + destiny.getLongitude();
    }

    public double getRouteDistance() {
        return routeDistance;
    }

    public void setRouteDistance(double routeDistance) {
        this.route.setNumberKilometers(routeDistance);
        FacadeFactory.getInstance().getRouteFacade().updateKm(route.getIdRoute(), route.getNumberKilometers());
    }
}
