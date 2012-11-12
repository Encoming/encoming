/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import java.util.Date;

/**
 *
 * @author germanpinerosm
 */
public class InvoiceVo implements IValueObject{
    private Integer idInvoice;
    private String sender;
    private String receiver;
    private Date moment;
    private Integer idShipping;
    private Integer idEncoming;
    

    /**
     * @return the idInvoice
     */
    public Integer getIdInvoice() {
        return idInvoice;
    }

    /**
     * @param idInvoice the idInvoice to set
     */
    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * @return the moment
     */
    public Date getMoment() {
        return moment;
    }

    /**
     * @param moment the moment to set
     */
    public void setMoment(Date moment) {
        this.moment = moment;
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
     * @return the idEncoming
     */
    public Integer getIdEncoming() {
        return idEncoming;
    }

    /**
     * @param idEncoming the idEncoming to set
     */
    public void setIdEncoming(Integer idEncoming) {
        this.idEncoming = idEncoming;
    }
    
}
