/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PointFacade;
import com.encoming.encoming.vo.PointVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean
@RequestScoped
public class PointBean implements Serializable {

    private MapModel model;
    private String title;
    private double lat;
    private double lng;
    private List<SelectItem> points;
    private List<SelectItem> latLngPoints;
    private List<PointVo> pointsVo;

    public PointBean() {
        model = addMarkers();
    }

    public MapModel getModel() {
        return model;
    }

    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void addPoint(ActionEvent actionEvent) {

        PointVo pointVo = new PointVo();
        PointFacade pointFacade = FacadeFactory.getInstance().getPointFacade();

        pointVo.setName(getTitle());
        pointVo.setLatitude(getLat());
        pointVo.setLongitude(getLng());

        pointFacade.persist(pointVo);

        Marker marker = new Marker(new LatLng(lat, lng), title);
        model.addOverlay(marker);
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha agregado un nuevo punto",
                "Nombre:" + title
                + "\n\nLatitud:" + lat
                + ", Longitud:" + lng));
    }

    public List<SelectItem> getPoints() {
        if (points == null) {
            points = new ArrayList<SelectItem>();
            List<PointVo> pointList = FacadeFactory.getInstance().getPointFacade().getList();
            if (pointList != null) {
                for (PointVo point : pointList) {
                    points.add(new SelectItem(point.getIdPoint(), point.getName()));
                }
            }
        }
        return points;
    }

    public List<SelectItem> getLatLngPoints() {
        if (latLngPoints == null) {
            latLngPoints = new ArrayList<SelectItem>();
            List<PointVo> pointList = FacadeFactory.getInstance().getPointFacade().getList();
            if (pointList != null) {
                for (PointVo point : pointList) {
                    latLngPoints.add(new SelectItem(point.getLatitude()+", "+point.getLongitude(), point.getName()));
                }
            }
        }
        return latLngPoints;
    }

    private List<PointVo> getPointsVo() {
        if (pointsVo == null) {
            pointsVo = new ArrayList<PointVo>();
            List<PointVo> pointList = FacadeFactory.getInstance().getPointFacade().getList();
            if (pointList != null) {
                for (PointVo point : pointList) {
                    pointsVo.add(point);
                }
            }
        }
        return pointsVo;
    }

    private List<Marker> pointVoToMarker() {
        List<PointVo> voPoints = getPointsVo();
        List<Marker> markers = new ArrayList<Marker>();
        for (PointVo pointVo : voPoints) {
            markers.add(new Marker(new LatLng(pointVo.getLatitude(), pointVo.getLongitude()), pointVo.getName()));
        }
        return markers;
    }

    private MapModel addMarkers() {
        List<Marker> markers = pointVoToMarker();
        MapModel map = new DefaultMapModel();
        for (Marker marker : markers) {
            map.addOverlay(marker);
        }
        return map;
    }

    public String getInitialCoordinates() {
        String coordinates;
        try {
            PointVo pointVo = getPointsVo().get(0);
            coordinates = pointVo.getLatitude() + "," + pointVo.getLongitude();
        } catch (Exception e) {
            coordinates = "4.636253254870502,-74.06657649212656";
        }
        return coordinates;
    }

    public String getPointCoordinates(PointVo point) {
        return point.getLatitude()+", "+point.getLongitude();
    }
    
    /**
     * @param latLngPoints the latLngPoints to set
     */
    public void setLatLngPoints(List<SelectItem> latLngPoints) {
        this.latLngPoints = latLngPoints;
    }
}
