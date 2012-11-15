/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import java.util.List;

/**
 *
 * @author FAMILIA
 */
public class ShippingVo implements IValueObject {

    private Integer idShipping;
    private Integer idReceiver;
    private String sendedDate;
    private String arrivedDate;
    private double cost;
    private List<InvoiceVo> invoiceList;
    private Integer idVehicle;
    private Integer idPerson;
    private Integer idRoute;
    private Integer idEncoming;

    public ShippingVo() {
    }

    public ShippingVo(Integer idReceiver, String sendedDate, String arrivedDate, double cost) {
        this.idReceiver = idReceiver;
        this.sendedDate = sendedDate;
        this.arrivedDate = arrivedDate;
        this.cost = cost;
    }

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
    public Integer getIdReceiver() {
        return idReceiver;
    }

    /**
     * @param idReceiver the idReceiver to set
     */
    public void setIdReceiver(Integer idReceiver) {
        this.idReceiver = idReceiver;
    }

    /**
     * @return the sendedDate
     */
    public String getSendedDate() {
        return sendedDate;
    }

    /**
     * @param sendedDate the sendedDate to set
     */
    public void setSendedDate(String sendedDate) {
        this.sendedDate = sendedDate;
    }

    /**
     * @return the arrivedDate
     */
    public String getArrivedDate() {
        return arrivedDate;
    }

    /**
     * @param arrivedDate the arrivedDate to set
     */
    public void setArrivedDate(String arrivedDate) {
        this.arrivedDate = arrivedDate;
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

    /**
     * @return the idVehicle
     */
    public Integer getIdVehicle() {
        return idVehicle;
    }

    /**
     * @param idVehicle the idVehicle to set
     */
    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    /**
     * @return the idPerson
     */
    public Integer getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
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
     * @return the idPackage
     */
    public Integer getIdEncoming() {
        return idEncoming;
    }

    /**
     * @param idEncoming the idPackage to set
     */
    public void setIdEncoming(Integer idEncoming) {
        this.idEncoming = idEncoming;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
