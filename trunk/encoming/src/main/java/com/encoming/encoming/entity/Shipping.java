/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.InvoiceVo;
import com.encoming.encoming.vo.ShippingVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "shipping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipping.findAll", query = "SELECT s FROM Shipping s"),
    @NamedQuery(name = "Shipping.findByIdShipping", query = "SELECT s FROM Shipping s WHERE s.idShipping = :idShipping"),
    @NamedQuery(name = "Shipping.findByIdReceiver", query = "SELECT s FROM Shipping s WHERE s.idReceiver = :idReceiver")})
public class Shipping implements Serializable,IEntity<ShippingVo> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idShipping")
    private Integer idShipping;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idReceiver")
    private int idReceiver;
    @Basic (optional = false)
    @Column (name = "sendedDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sendedDate;
    @Basic (optional = false)
    @Column (name = "arrivedDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrivedDate;
    @JoinColumn(name = "Route_idRoute", referencedColumnName = "idRoute")
    @ManyToOne(optional = false)
    private Route routeidRoute;
    @JoinColumn(name = "Package_idPackage", referencedColumnName = "idPackage")
    @ManyToOne(optional = false)
    private Package packageidPackage;
    @JoinColumns({
        @JoinColumn(name = "Vehicle_plateNumber", referencedColumnName = "plateNumber"),
        @JoinColumn(name = "Vehicle_plateLetters", referencedColumnName = "plateLetters")})
    @ManyToOne(optional = false)
    private Vehicle vehicle;
    @JoinColumn(name = "Client_idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client clientidClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shippingidShipping")
    private List<Invoice> invoiceList;

    public Shipping() {
    }

    public Shipping(Integer idShipping) {
        this.idShipping = idShipping;
    }

    public Shipping(Integer idShipping, int idReceiver) {
        this.idShipping = idShipping;
        this.idReceiver = idReceiver;
    }

    public Integer getIdShipping() {
        return idShipping;
    }

    public void setIdShipping(Integer idShipping) {
        this.idShipping = idShipping;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public Route getRouteidRoute() {
        return routeidRoute;
    }

    public void setRouteidRoute(Route routeidRoute) {
        this.routeidRoute = routeidRoute;
    }

    public Package getPackageidPackage() {
        return packageidPackage;
    }

    public void setPackageidPackage(Package packageidPackage) {
        this.packageidPackage = packageidPackage;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getClientidClient() {
        return clientidClient;
    }

    public void setClientidClient(Client clientidClient) {
        this.clientidClient = clientidClient;
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

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShipping != null ? idShipping.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipping)) {
            return false;
        }
        Shipping other = (Shipping) object;
        if ((this.idShipping == null && other.idShipping != null) || (this.idShipping != null && !this.idShipping.equals(other.idShipping))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Shipping[ idShipping=" + idShipping + " ]";
    }
    
    @Override
    public ShippingVo toVo(){
        ShippingVo shippingVo = new ShippingVo();
        shippingVo.setIdShipping(getIdShipping());
        shippingVo.setIdReceiver(getIdReceiver());
        shippingVo.setSendedDate(getSendedDate());
        shippingVo.setArrivedDate(getArrivedDate());
        shippingVo.setRouteidRoute(getRouteidRoute());
        shippingVo.setPackageidPackage(getPackageidPackage().getIdPackage());
        shippingVo.setVehicle(getVehicle().getIdVehicle());
        shippingVo.setClientidClient(getClientidClient().getIdClient());
        List<InvoiceVo> invoiceVos = new ArrayList<InvoiceVo>();
        for(Invoice entity : getInvoiceList()){
            invoiceVos.add(entity.toVo());
        }
        shippingVo.setInvoiceList(invoiceVos);
        return shippingVo;
    } 
    
}
