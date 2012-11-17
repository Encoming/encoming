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
    private int numberKilometers;
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
    public int getNumberKilometers() {
        return numberKilometers;
    }

    /**
     * @param numberKilometers the numberKilometers to set
     */
    public void setNumberKilometers(int numberKilometers) {
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
        this.setPointList(pointList);
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
        this.setShippingList(shippingList);
    }

    /**
     * @return the destinationPoint
     */
    public Integer getDestinationPoint() {
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
    public Integer getOriginPoint() {
        return originPoint;
    }

    /**
     * @param originPoint the originPoint to set
     */
    public void setOriginPoint(Integer originPoint) {
        this.originPoint = originPoint;
    }
}
