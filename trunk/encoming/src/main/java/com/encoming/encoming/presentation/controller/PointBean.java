/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PointFacade;
import com.encoming.encoming.vo.PointVo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean
@SessionScoped
public class PointBean implements Serializable {

    private MapModel model;
    private String title;
    private double lat;
    private double lng;

    public PointBean() {
        model = new DefaultMapModel();
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
}
