/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import com.encoming.encoming.entity.Shipping;
import java.util.List;

/**
 *
 * @author germanpineros
 */
public class RouteVo implements IValueObject{
    
    private Integer idRoute;
    private int numberKilometers;
    private int numberTolls;
    private String destinationCity;
    private String originCity;
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
     * @return the numberTolls
     */
    public int getNumberTolls() {
        return numberTolls;
    }

    /**
     * @param numberTolls the numberTolls to set
     */
    public void setNumberTolls(int numberTolls) {
        this.numberTolls = numberTolls;
    }

    /**
     * @return the destinationCity
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * @param destinationCity the destinationCity to set
     */
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    /**
     * @return the originCity
     */
    public String getOriginCity() {
        return originCity;
    }

    /**
     * @param originCity the originCity to set
     */
    public void setOriginCity(String originCity) {
        this.originCity = originCity;
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
        this.pointList = pointList;
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
        this.shippingList = shippingList;
    }

    
}
