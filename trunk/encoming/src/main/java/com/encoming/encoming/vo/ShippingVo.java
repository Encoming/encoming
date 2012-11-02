/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import com.encoming.encoming.entity.Route;
import com.encoming.encoming.entity.Vehicle;
import java.util.Date;
import java.util.List;
import javax.enterprise.inject.New;

/**
 *
 * @author FAMILIA
 */
public class ShippingVo {
    
    private Integer idShipping;
    private int idReceiver;
    private Route routeidRoute;
    private Integer packageidPackage;
    private Integer vehicle;
    private Integer clientidClient;
    private Date sendedDate;
    private Date arrivedDate;
    private List<InvoiceVo> invoiceList;

    /**
     * @return the idShipping
     */
    public Integer getIdShipping() {
        return idShipping;
    }

    /**
     * @param idShipping the idShipping to set
     */
    public void setIdShipping(Integer idShipping) {
        this.idShipping = idShipping;
    }

    /**
     * @return the idReceiver
     */
    public int getIdReceiver() {
        return idReceiver;
    }

    /**
     * @param idReceiver the idReceiver to set
     */
    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    /**
     * @return the routeidRoute
     */
    public Route getRouteidRoute() {
        return routeidRoute;
    }

    /**
     * @param routeidRoute the routeidRoute to set
     */
    public void setRouteidRoute(Route routeidRoute) {
        this.routeidRoute = routeidRoute;
    }

    /**
     * @return the packageidPackage
     */
    public Integer getPackageidPackage() {
        return packageidPackage;
    }

    /**
     * @param packageidPackage the packageidPackage to set
     */
    public void setPackageidPackage(Integer packageidPackage) {
        this.packageidPackage = packageidPackage;
    }

    /**
     * @return the vehicle
     */
    public Integer getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Integer vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return the clientidClient
     */
    public Integer getClientidClient() {
        return clientidClient;
    }

    /**
     * @param clientidClient the clientidClient to set
     */
    public void setClientidClient(Integer clientidClient) {
        this.clientidClient = clientidClient;
    }

    /**
     * @return the invoiceList
     */
    public List<InvoiceVo> getInvoiceList() {
        return invoiceList;
    }

    /**
     * @param invoiceList the invoiceList to set
     */
    public void setInvoiceList(List<InvoiceVo> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public Date getSendedDate() {
        return sendedDate;
    }

    public void setSendedDate(Date sendedDate) {
        this.sendedDate = sendedDate;
    }

    public Date getArrivedDate() {
        return arrivedDate;
    }

    public void setArrivedDate(Date arrivedDate) {
        this.arrivedDate = arrivedDate;
    }       
}
