/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

/**
 *
 * @author germanpineros
 */
public class PointVo implements IValueObject {

    private Integer idPoint;
    private String name;
    private Double latitude;
    private Double longitude;
    private Integer idRoute;

    /**
     * @return the idPoint
     */
    public Integer getIdPoint() {
        return idPoint;
    }

    /**
     * @param idPoint the idPoint to set
     */
    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

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
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
