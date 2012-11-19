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
    private String pointName;
    private String plateLetters;
    private Integer plateNumbers;
    private VehicleVo vehiculoVo;
    private List<SelectItem> points; 
    ArrayList<ShippingVo> filteredShipList = new ArrayList();
    private ArrayList<ShippingVo> shippingLessing = new ArrayList();
    public getShippingBean() {
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

    public String getIdPoint() {
        return pointName;
    }

    public void setIdPoint(String idPoint) {
        this.pointName= idPoint;
    }
    
        public List<SelectItem> getPoints() {
        if (points == null) {
            points = new ArrayList<SelectItem>();
            List<PointVo> pointList = FacadeFactory.getInstance().getPointFacade().getList();
            if (pointList != null) {
                for (PointVo point : pointList) {
                    points.add(new SelectItem(point.getName(), point.getName()));
                }
            }
        }
        return points;
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
            if(routeVo.getDestinationCity().equals(pointName)){
                
                filteredShipList.add(ship);
            }else{
                shippingLessing.add(ship);
            }
            System.out.println("paso la mitad");
        PointFacade pointFac = FacadeFactory.getInstance().getPointFacade();
        PointVo pointVo = pointFac.findByName(pointName);
        vehiculoVoAuxiliar.setCapacity(vehiculoVo.getCapacity());
        vehiculoVoAuxiliar.setIdDriver(vehiculoVo.getIdDriver());
        vehiculoVoAuxiliar.setIdPoint(pointVo.getIdPoint());
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
