/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

import java.util.List;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class EncomingVo implements IValueObject{
    
    private Integer idEncoming;
    private String type;
    private String volume;
    private String priority;
    private String origin;
    private String destiny;
    private Integer IdVehicle;
    private Integer idRoute;
    private Integer idClient;
    private Integer idAdministrator;
    private List<InvoiceVo> invoiceList;

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

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the destiny
     */
    public String getDestiny() {
        return destiny;
    }

    /**
     * @param destiny the destiny to set
     */
    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    /**
     * @return the IdVehicle
     */
    public Integer getIdVehicle() {
        return IdVehicle;
    }

    /**
     * @param IdVehicle the IdVehicle to set
     */
    public void setIdVehicle(Integer IdVehicle) {
        this.IdVehicle = IdVehicle;
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
     * @return the idAdministrator
     */
    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    /**
     * @param idAdministrator the idAdministrator to set
     */
    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
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
    
}
