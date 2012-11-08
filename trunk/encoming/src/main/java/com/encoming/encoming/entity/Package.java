/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.InvoiceVo;
import com.encoming.encoming.vo.PackageVo;
import com.encoming.encoming.vo.ShippingVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "package")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Package.findAll", query = "SELECT p FROM Package p"),
    @NamedQuery(name = "Package.findByIdPackage", query = "SELECT p FROM Package p WHERE p.idPackage = :idPackage"),
    @NamedQuery(name = "Package.findByType", query = "SELECT p FROM Package p WHERE p.type = :type"),
    @NamedQuery(name = "Package.findByVolume", query = "SELECT p FROM Package p WHERE p.volume = :volume"),
    @NamedQuery(name = "Package.findByPriority", query = "SELECT p FROM Package p WHERE p.priority = :priority"),
    @NamedQuery(name = "Package.findByWeight", query = "SELECT p FROM Package p WHERE p.weight = :weight")})
public class Package implements Serializable,IEntity<PackageVo> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "idPackage")
    private Integer idPackage;
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
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "received_packet")
    private Date received_packet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageidPackage")
    private List<Shipping> shippingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageidPackage")
    private List<Invoice> invoiceList;

    public Package() {
    }

    public Package(Integer idPackage) {
        this.idPackage = idPackage;
    }

    public Package(Integer idPackage, String type, String volume, String priority, float weight,Date received_packet) {
        this.idPackage = idPackage;
        this.type = type;
        this.volume = volume;
        this.priority = priority;
        this.weight = weight;
        this.received_packet = received_packet;
    }

    public Integer getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(Integer idPackage) {
        this.idPackage = idPackage;
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
    
    public Date getReceived_packet() {
        return received_packet;
    }

    public void setReceived_packet(Date received_packet) {
        this.received_packet = received_packet;
    }

    @XmlTransient
    public List<Shipping> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Shipping> shippingList) {
        this.shippingList = shippingList;
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
        hash += (idPackage != null ? idPackage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Package)) {
            return false;
        }
        Package other = (Package) object;
        if ((this.idPackage == null && other.idPackage != null) || (this.idPackage != null && !this.idPackage.equals(other.idPackage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Package[ idPackage=" + idPackage + " ]";
    }
    
        @Override
    public PackageVo toVo(){
        PackageVo packageVo = new PackageVo();
        packageVo.setIdPackage(getIdPackage());
        packageVo.setType(getType());
        packageVo.setVolume(getVolume());
        packageVo.setPriority(getPriority());
        packageVo.setWeight(getWeight());
        packageVo.setReceived_packet(getReceived_packet());
        List<ShippingVo> shippingVos = new ArrayList<ShippingVo>();
        for(Shipping entity : getShippingList()){
            shippingVos.add(entity.toVo());
        }
        packageVo.setShippingList(shippingVos);
        List<InvoiceVo> invoiceVos = new ArrayList<InvoiceVo>();
        for(Invoice entity : getInvoiceList()){
            invoiceVos.add(entity.toVo());
        }
        packageVo.setShippingList(shippingVos);
        
        return packageVo;
    }
}
