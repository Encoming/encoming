/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author FAMILIA
 */
public class ShippingVo {

    private Integer idShipping;
    private int idReceiver;
    private Date sendedDate;
    private Date arrivedDate;
    private List<InvoiceVo> invoiceList;
    private Integer idVehicle;
    private Integer idPerson;
    private Integer idRoute;
    private Integer idEncoming;
    
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
     * @return the sendedDate
     */
    public Date getSendedDate() {
        return sendedDate;
    }

    /**
     * @param sendedDate the sendedDate to set
     */
    public void setSendedDate(Date sendedDate) {
        this.sendedDate = sendedDate;
    }

    /**
     * @return the arrivedDate
     */
    public Date getArrivedDate() {
        return arrivedDate;
    }

    /**
     * @param arrivedDate the arrivedDate to set
     */
    public void setArrivedDate(Date arrivedDate) {
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

    @Override
    public String toString() {
        return "ShippingVo{" 
                + "\n\tidShipping=" + idShipping 
                + ",\n\t idReceiver=" + idReceiver 
                + ",\n\t sendedDate=" + sendedDate 
                + ",\n\t arrivedDate=" + arrivedDate 
                + ",\n\t invoiceList=" + invoiceList 
                + ",\n\t idVehicle=" + idVehicle 
                + ",\n\t idPerson=" + idPerson 
                + ",\n\t idRoute=" + idRoute 
                + ",\n\t idEncoming=" + idEncoming + '}';
    }
    
}
