/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PointFacade;
import com.encoming.encoming.businesslogic.facade.VehicleFacade;
import com.encoming.encoming.vo.PointVo;
import com.encoming.encoming.vo.RouteVo;
import com.encoming.encoming.vo.ShippingVo;
import com.encoming.encoming.vo.VehicleVo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 * @author THOKK
 */

@ManagedBean
@RequestScoped
public class getShippingBean {
    private Integer idPoint;
    private String plateLetters;
    private Integer plateNumbers;
    private VehicleVo vehiculoVo;
    
    ArrayList<ShippingVo> filteredShipList = new ArrayList();
    private ArrayList<ShippingVo> shippingLessing = new ArrayList();
    
    public getShippingBean() {
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }

    public String getPlateLetters() {
        return plateLetters;
    }

    public void setPlateLetters(String plateLetters) {
        this.plateLetters = plateLetters;
    }

    public Integer getPlateNumbers() {
        return plateNumbers;
    }

    public void setPlateNumbers(Integer plateNumbers) {
        this.plateNumbers = plateNumbers;
    }
    
    public VehicleVo getVehiculoVo() {
        return vehiculoVo;
    }



    public void find(){
        VehicleFacade vehFacade = FacadeFactory.getInstance().getVehicleFacade();
        vehiculoVo = vehFacade.findByPlate(plateNumbers, plateLetters);
        
    }
    public void operateShipping(){
        filteredShipList.clear();
        shippingLessing.clear();
        
        VehicleFacade vehFacade = FacadeFactory.getInstance().getVehicleFacade();
        vehiculoVo = vehFacade.findByPlate(plateNumbers, plateLetters);
        VehicleVo vehiculoVoAuxiliar = new VehicleVo();
        
        for(ShippingVo ship : vehiculoVo.getShippingList()){
            RouteVo routeVo = FacadeFactory.getInstance().getRouteFacade().find(ship.getIdRoute());     
            if(routeVo.getDestinationPointId().equals(idPoint)){
                filteredShipList.add(ship);
            }else{
                shippingLessing.add(ship);
            }
       
        vehiculoVoAuxiliar.setCapacity(vehiculoVo.getCapacity());
        vehiculoVoAuxiliar.setIdDriver(vehiculoVo.getIdDriver());
        vehiculoVoAuxiliar.setIdPoint(idPoint);
        vehiculoVoAuxiliar.setManufacturer(vehiculoVo.getManufacturer());
        vehiculoVoAuxiliar.setModel(vehiculoVo.getModel());
        vehiculoVoAuxiliar.setPlateLetters(vehiculoVo.getPlateLetters());
        vehiculoVoAuxiliar.setPlateNumber(vehiculoVo.getPlateNumbers());
        if(shippingLessing.isEmpty())
        {
        vehiculoVoAuxiliar.setStatus("Disponible");
        }else{
            vehiculoVoAuxiliar.setStatus(vehiculoVo.getStatus());
        }
        
        vehiculoVoAuxiliar.setType(vehiculoVo.getType());
        vehiculoVoAuxiliar.setShippingList(shippingLessing);
        VehicleFacade vFac = FacadeFactory.getInstance().getVehicleFacade();
        vFac.update(vehiculoVoAuxiliar);
        }
    }

    
}
