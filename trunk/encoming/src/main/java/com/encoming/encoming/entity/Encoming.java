/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
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
    @NamedQuery(name = "Encoming.findByIdEncoming", query = "SELECT e FROM Encoming e WHERE e.idEncoming = :idEncoming"),
    @NamedQuery(name = "Encoming.findByType", query = "SELECT e FROM Encoming e WHERE e.type = :type"),
    @NamedQuery(name = "Encoming.findByVolume", query = "SELECT e FROM Encoming e WHERE e.volume = :volume"),
    @NamedQuery(name = "Encoming.findByPriority", query = "SELECT e FROM Encoming e WHERE e.priority = :priority"),
    @NamedQuery(name = "Encoming.findByOrigin", query = "SELECT e FROM Encoming e WHERE e.origin = :origin"),
    @NamedQuery(name = "Encoming.findByDestiny", query = "SELECT e FROM Encoming e WHERE e.destiny = :destiny")})
public class Encoming implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEncoming")
    private Integer idEncoming;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
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
    @Size(min = 1, max = 15)
    @Column(name = "origin")
    private String origin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "destiny")
    private String destiny;
    @JoinColumn(name = "Vehicle_idVehicle", referencedColumnName = "idVehicle")
    @ManyToOne(optional = false)
    private Vehicle vehicleidVehicle;
    @JoinColumn(name = "client", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "route", referencedColumnName = "idRoute")
    @ManyToOne(optional = false)
    private Route route;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encoming")
    private List<Invoice> invoiceList;

    public Encoming() {
    }

    public Encoming(Integer idEncoming) {
        this.idEncoming = idEncoming;
    }

    public Encoming(Integer idEncoming, String type, String volume, String priority, String origin, String destiny) {
        this.idEncoming = idEncoming;
        this.type = type;
        this.volume = volume;
        this.priority = priority;
        this.origin = origin;
        this.destiny = destiny;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public Vehicle getVehicleidVehicle() {
        return vehicleidVehicle;
    }

    public void setVehicleidVehicle(Vehicle vehicleidVehicle) {
        this.vehicleidVehicle = vehicleidVehicle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
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
        return "com.encoming.encoming.entity.Encoming[ idEncoming=" + idEncoming + " ]";
    }
    
}
