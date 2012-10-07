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
    private int numberTolls;
    private List<EncomingVo> encomingList;
    private List<PointVo> pointList;

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
     * @return the encomingList
     */
    public List<EncomingVo> getEncomingList() {
        return encomingList;
    }

    /**
     * @param encomingList the encomingList to set
     */
    public void setEncomingList(List<EncomingVo> encomingList) {
        this.encomingList = encomingList;
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
    
}
