/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.EncomingVo;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Encoming")
@NamedQueries({
    @NamedQuery(name = "Encoming.findAll", query = "SELECT e FROM Encoming e"),
    @NamedQuery(name = "Encoming.findByIdPackage", query = "SELECT e FROM Encoming e WHERE e.idEncoming = :idPackage"),
    @NamedQuery(name = "Encoming.findByType", query = "SELECT e FROM Encoming e WHERE e.type = :type"),
    @NamedQuery(name = "Encoming.findByVolume", query = "SELECT e FROM Encoming e WHERE e.volume = :volume"),
    @NamedQuery(name = "Encoming.findByPriority", query = "SELECT e FROM Encoming e WHERE e.priority = :priority"),
    @NamedQuery(name = "Encoming.findByWeight", query = "SELECT e FROM Encoming e WHERE e.weight = :weight"),
    @NamedQuery(name = "Encoming.findByReceivedPacket", query = "SELECT e FROM Encoming e WHERE e.receivedPacket = :receivedPacket")})
public class Encoming implements Serializable, IEntity<EncomingVo> {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPackage")
    private Integer idEncoming;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "volume")
    private String volume;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private float weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "received_packet")
    //@Temporal(TemporalType.DATE)
    private String receivedPacket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encoming")
    private List<Invoice> invoiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encoming")
    private List<Shipping> shippingList;

    public Encoming() {
    }

    public Encoming(Integer idPackage) {
        this.idEncoming = idPackage;
    }

    public Encoming(Integer idPackage, String type, String volume, String priority, float weight, String receivedPacket) {
        this.idEncoming = idPackage;
        this.type = type;
        this.volume = volume;
        this.priority = priority;
        this.weight = weight;
        this.receivedPacket = receivedPacket;
    }

    public Integer getIdEncoming() {
        return idEncoming;
    }

    public void setIdEncoming(Integer idEncoming) {
        this.idEncoming = idEncoming;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getReceivedPacket() {
        return receivedPacket;
    }

    public void setReceivedPacket(String receivedPacket) {
        this.receivedPacket = receivedPacket;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<Shipping> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Shipping> shippingList) {
        this.shippingList = shippingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncoming != null ? idEncoming.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encoming)) {
            return false;
        }
        Encoming other = (Encoming) object;
        if ((this.idEncoming == null && other.idEncoming != null) || (this.idEncoming != null && !this.idEncoming.equals(other.idEncoming))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Encoming[ idPackage=" + idEncoming + " ]";
    }

    @Override
    public EncomingVo toVo() {
        EncomingVo encomingVo = new EncomingVo();
        encomingVo.setIdEncoming(getIdEncoming());
        encomingVo.setType(getType());
        encomingVo.setVolume(getVolume());
        encomingVo.setPriority(getPriority());
        encomingVo.setWeight(getWeight());
        encomingVo.setReceived_packet(getReceivedPacket());
        List<ShippingVo> shippingVos = new ArrayList<ShippingVo>();
        for(Shipping entity : getShippingList()){
            shippingVos.add(entity.toVo());
        }
        encomingVo.setShippingList(shippingVos);
        List<InvoiceVo> invoiceVos = new ArrayList<InvoiceVo>();
        for(Invoice entity : getInvoiceList()){
            invoiceVos.add(entity.toVo());
        }
        encomingVo.setShippingList(shippingVos);
        
        return encomingVo;
    }
}
