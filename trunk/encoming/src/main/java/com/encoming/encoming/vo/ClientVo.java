/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import com.encoming.encoming.entity.Shipping;
import java.util.List;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ClientVo implements IValueObject{
    private Integer idClient;
    private int sendedEncoming;
    private int receivedEncoming;
    private List<ShippingVo> shippingList;
    private Integer idPerson;

    /**
     * @return the idClient
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the sendedEncoming
     */
    public int getSendedEncoming() {
        return sendedEncoming;
    }

    /**
     * @param sendedEncoming the sendedEncoming to set
     */
    public void setSendedEncoming(int sendedEncoming) {
        this.sendedEncoming = sendedEncoming;
    }

    /**
     * @return the receivedEncoming
     */
    public int getReceivedEncoming() {
        return receivedEncoming;
    }

    /**
     * @param receivedEncoming the receivedEncoming to set
     */
    public void setReceivedEncoming(int receivedEncoming) {
        this.receivedEncoming = receivedEncoming;
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
     * @return the shippingList
     */
    public List<ShippingVo> getShippingList() {
        return shippingList;
    }

    /**
     * @param shippingList the shippingList to set
     */
    public void setShippingList(List<ShippingVo> shippingList) {
        this.shippingList = shippingList;
    }

   
    
}
