/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.InvoiceVo;
import com.encoming.encoming.vo.ShippingVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "Shipping")
@NamedQueries({
    @NamedQuery(name = "Shipping.findAll", query = "SELECT s FROM Shipping s"),
    @NamedQuery(name = "Shipping.findByIdShipping", query = "SELECT s FROM Shipping s WHERE s.idShipping = :idShipping"),
    @NamedQuery(name = "Shipping.findByIdReceiver", query = "SELECT s FROM Shipping s WHERE s.idReceiver = :idReceiver"),
    @NamedQuery(name = "Shipping.findByCost", query = "SELECT s FROM Shipping s WHERE s.cost = :cost"),
    @NamedQuery(name = "Shipping.findBySendedDate", query = "SELECT s FROM Shipping s WHERE s.sendedDate = :sendedDate"),
    @NamedQuery(name = "Shipping.findByArrivedDate", query = "SELECT s FROM Shipping s WHERE s.arrivedDate = :arrivedDate")})
public class Shipping implements Serializable, IEntity<ShippingVo> {

    private static long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "idShipping")
    private Integer idShipping;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idReceiver")
    private Integer idReceiver;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "sendedDate")
    //@Temporal(TemporalType.TIMESTAMP)
    private String sendedDate;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "arrivedDate")
    //@Temporal(TemporalType.TIMESTAMP)
    private String arrivedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipping")
//    private List<Invoice> invoiceList;
    @JoinColumn(name = "Vehicle_idVehicle", referencedColumnName = "idVehicle")
    @ManyToOne(optional = false)
    private Vehicle vehicle;
    @JoinColumn(name = "Person_idPerson", referencedColumnName = "idPerson")
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "Route_idRoute", referencedColumnName = "idRoute")
    @ManyToOne(optional = false)
    private Route route;
    @JoinColumn(name = "Package_idPackage", referencedColumnName = "idPackage")
    @ManyToOne(optional = false)
    private Encoming encoming;
//    @OneToOne(mappedBy = "shipping")
//    private Invoice invoice
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipping")
    private List<Invoice> invoiceList;

    public Shipping() {
    }

    public Shipping(Integer idShipping) {
        this.idShipping = idShipping;
    }

    public Shipping(Integer idShipping, Integer idReceiver, String sendedDate, String arrivedDate, Double cost) {
        this.idShipping = idShipping;
        this.idReceiver = idReceiver;
        this.sendedDate = sendedDate;
        this.arrivedDate = arrivedDate;
        this.cost = cost;

    }

    public Integer getIdShipping() {
        return idShipping;
    }

    public void setIdShipping(Integer idShipping) {
        this.idShipping = idShipping;
    }

    public Integer getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(Integer idReceiver) {
        this.idReceiver = idReceiver;
    }

    public String getSendedDate() {
        return sendedDate;
    }

    public void setSendedDate(String sendedDate) {
        this.sendedDate = sendedDate;
    }

    public String getArrivedDate() {
        return arrivedDate;
    }

    public void setArrivedDate(String arrivedDate) {
        this.arrivedDate = arrivedDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Encoming getEncoming() {
        return encoming;
    }

    public void setEncoming(Encoming encoming) {
        this.encoming = encoming;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdShipping() != null ? getIdShipping().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipping)) {
            return false;
        }
        Shipping other = (Shipping) object;
        if ((this.getIdShipping() == null && other.getIdShipping() != null) || (this.getIdShipping() != null && !this.idShipping.equals(other.idShipping))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Shipping[ idShipping=" + getIdShipping() + " ]";
    }

    @Override
    public ShippingVo toVo() {
        ShippingVo shippingVo = new ShippingVo();
        shippingVo.setArrivedDate(getArrivedDate());
        shippingVo.setIdEncoming(getEncoming().getIdEncoming());
        shippingVo.setIdPerson(getPerson().getIdPerson());
        shippingVo.setIdReceiver(getIdReceiver());
        shippingVo.setCost(getCost());
        shippingVo.setIdRoute(getRoute().getIdRoute());
        shippingVo.setIdShipping(getIdShipping());
        shippingVo.setSendedDate(getSendedDate());
        shippingVo.setIdVehicle(getVehicle().getIdVehicle());
        
        List<InvoiceVo> invoiceVos = new ArrayList<InvoiceVo>();
        for(Invoice entity : getInvoiceList()){
            invoiceVos.add(entity.toVo());
        }
        shippingVo.setInvoiceList(invoiceVos);
        
        return shippingVo;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}
