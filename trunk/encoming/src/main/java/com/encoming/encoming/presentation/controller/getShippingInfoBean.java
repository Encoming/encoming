/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.ShippingFacade;
import com.encoming.encoming.vo.ShippingVo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author THOKK
 */
@ManagedBean
@RequestScoped

public class getShippingInfoBean {
private Integer idShipping;
private String status = "";
    public getShippingInfoBean() {
        
    }
    
    public void findStatus(){
        try{
            ShippingVo shipVo = FacadeFactory.getInstance().getShippingFacade().find(idShipping);
        status += "Respetado usuario su envio ";
        if(shipVo.getSendedDate() != null){
            status += "fue despachado: \n " + shipVo.getSendedDate();
                if(shipVo.getArrivedDate() != null){
                    status += " \n fue recibido en la sucursal en : \n " + shipVo.getArrivedDate();
                }                
        }else {
            status += "Aun no ha sido despachado";
        }
            
        }catch(Exception e){
            status  = "Numero de Envio Inválido";
        }
        
    }

    public Integer getIdShipping() {
        return idShipping;
    }

    public void setIdShipping(Integer idShipping) {
        this.idShipping = idShipping;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
