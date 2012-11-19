/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import java.util.List;

/**
 *
 * @author germanpineros
 */
public class RouteVo implements IValueObject{
    
    private Integer idRoute;
    private double numberKilometers;
    private Integer destinationPoint;
    private Integer originPoint;
    private List<PointVo> pointList;
    private List<ShippingVo> shippingList;
    

    /**
     * @return the idRoute
     */
    public Integer getIdRoute() {
        return idRoute;
    }

    /**
     * @param idRoute the idRoute to set
     */
    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    /**
     * @return the numberKilometers
     */
    public double getNumberKilometers() {
        return numberKilometers;
    }

    /**
     * @param numberKilometers the numberKilometers to set
     */
    public void setNumberKilometers(double numberKilometers) {
        this.numberKilometers = numberKilometers;
    }

    /**
     * @return the pointList
     */
    public List<PointVo> getPointList() {
        return pointList;
    }

    /**
     * @param pointList the pointList to set
     */
    public void setPointList(List<PointVo> pointList) {
        this.pointList =pointList;
    }

    /**
     * @return the shippingList
     */
    public List<ShippingVo> getShippingList() {
        return shippingList;
    }

    /**
     * @param shippingList the shippingList to set
     */
    public void setShippingList(List<ShippingVo> shippingList) {
        this.shippingList=shippingList;
    }

    /**
     * @return the destinationPoint
     */
    public Integer getDestinationPointId() {
        return destinationPoint;
    }

    /**
     * @param destinationPoint the destinationPoint to set
     */
    public void setDestinationPoint(Integer destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    /**
     * @return the originPoint
     */
    public Integer getOriginPointId() {
        return originPoint;
    }

    /**
     * @param originPoint the originPoint to set
     */
    public void setOriginPoint(Integer originPoint) {
        this.originPoint = originPoint;
    }

    @Override
    public String toString() {
        return "RouteVo{" 
                + "  \n\tidRoute=" + idRoute 
                + ", \n\tnumberKilometers=" + numberKilometers 
                + ", \n\tdestinationPoint=" + destinationPoint 
                + ", \n\toriginPoint=" + originPoint 
                + ", \n\tpointList=" + pointList 
                + ", \n\tshippingList=" + shippingList + '}';
    }
    
    
}
