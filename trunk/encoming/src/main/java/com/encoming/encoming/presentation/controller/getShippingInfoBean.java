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
private String query;

    public getShippingInfoBean() {
        
    }
    
    public void findStatus(){
        
        query = idShipping + "";
        try{
            ShippingVo shipVo = FacadeFactory.getInstance().getShippingFacade().find(query);
        status += "Respetado usuario su envio ";
        if(shipVo.getSendedDate() != null){
            status += "fue despachado: \n " + shipVo.getSendedDate();
                if(shipVo.getArrivedDate() != null){
                    status += " \n fue recibido en la sucursal : \n " + shipVo.getArrivedDate();
                }                
        }else {
            status += "aun no ha sido despachado";
        }
            
        }catch(Exception e){
            status  = "¡El número de Envío no existe!";
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

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
    
    
}
