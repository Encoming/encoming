/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import com.encoming.encoming.entity.Shipping;
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
    private Shipping shippingidShipping;
    private com.encoming.encoming.entity.Package packageidPackage;
    

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
     * @return the shippingidShipping
     */
    public Shipping getShippingidShipping() {
        return shippingidShipping;
    }

    /**
     * @param shippingidShipping the shippingidShipping to set
     */
    public void setShippingidShipping(Shipping shippingidShipping) {
        this.shippingidShipping = shippingidShipping;
    }

    /**
     * @return the packageidPackage
     */
    public com.encoming.encoming.entity.Package getPackageidPackage() {
        return packageidPackage;
    }

    /**
     * @param packageidPackage the packageidPackage to set
     */
    public void setPackageidPackage(com.encoming.encoming.entity.Package packageidPackage) {
        this.packageidPackage = packageidPackage;
    }
    
}
