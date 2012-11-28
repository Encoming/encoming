/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.ShippingFacade;
import com.encoming.encoming.vo.ShippingVo;
import com.encoming.encoming.vo.VehicleVo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author THOKK
 */
@ManagedBean
@ViewScoped
public class sendVehicleBean {
    private List<SelectItem> vehicles;
    private Integer idVehicle;
    private Integer idPoint = null;
    private VehicleVo vehicle;
    
    public sendVehicleBean() {
    }
     public List<SelectItem> getVehicles() {
         System.out.println("entra en getVehicles  punto : " + idPoint);
            if(idPoint != null){
            vehicles = new ArrayList<SelectItem>();
            List<VehicleVo> vehiclesList = FacadeFactory.getInstance().getVehicleFacade().getListByPoint(idPoint);
            if (vehiclesList != null) {
                for (VehicleVo vehicleVo : vehiclesList) {
                    vehicles.add(new SelectItem(vehicleVo.getIdVehicle(), 
                            vehicleVo.getPlateLetters().toUpperCase() + " " 
                            +vehicleVo.getPlateNumbers()));
                }
            }
        }
        return vehicles;
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }
     public String dateTime() {
        Date fecha = new Date();
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss  a", Locale.getDefault());
        String fecha2 = formato2.format(fecha);
        return fecha2;

    }
    
    public void sendVehicle(){
       List<ShippingVo> list = FacadeFactory.getInstance().getShippingFacade().findToSend(idVehicle);
       for(ShippingVo ship : list){
           ShippingFacade shipFacFor = FacadeFactory.getInstance().getShippingFacade();
           shipFacFor.updateSendedDate(dateTime(), ship.getIdShipping());
       }
       FacadeFactory.getInstance().getVehicleFacade().updateStatus("En Ruta", idVehicle);
       
            }

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }
    
    public void updateVehicle(ValueChangeEvent event) {
        System.out.println("entro en el del update vehicle");
        idPoint = (Integer) event.getNewValue();
           vehicles = new ArrayList<SelectItem>();
            List<VehicleVo> vehiclesList = FacadeFactory.getInstance().getVehicleFacade().getListByPoint(idPoint);
            if (vehiclesList != null) {
                for (VehicleVo vehicleVo : vehiclesList) {
                    vehicles.add(new SelectItem(vehicleVo.getIdVehicle(), 
                            vehicleVo.getPlateLetters() + " " 
                            +vehicleVo.getPlateNumbers()));
                }
            }
        }
    }

