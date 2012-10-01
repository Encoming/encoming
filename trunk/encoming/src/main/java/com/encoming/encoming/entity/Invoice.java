/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByIdInvoice", query = "SELECT i FROM Invoice i WHERE i.idInvoice = :idInvoice"),
    @NamedQuery(name = "Invoice.findBySender", query = "SELECT i FROM Invoice i WHERE i.sender = :sender"),
    @NamedQuery(name = "Invoice.findByReceiver", query = "SELECT i FROM Invoice i WHERE i.receiver = :receiver"),
    @NamedQuery(name = "Invoice.findByMoment", query = "SELECT i FROM Invoice i WHERE i.moment = :moment")})
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInvoice")
    private Integer idInvoice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "sender")
    private String sender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "moment")
    @Temporal(TemporalType.DATE)
    private Date moment;
    @JoinColumn(name = "encoming", referencedColumnName = "idEncoming")
    @ManyToOne(optional = false)
    private Encoming encoming;

    public Invoice() {
    }

    public Invoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Invoice(Integer idInvoice, String sender, String receiver) {
        this.idInvoice = idInvoice;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public Encoming getEncoming() {
        return encoming;
    }

    public void setEncoming(Encoming encoming) {
        this.encoming = encoming;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvoice != null ? idInvoice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.idInvoice == null && other.idInvoice != null) || (this.idInvoice != null && !this.idInvoice.equals(other.idInvoice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Invoice[ idInvoice=" + idInvoice + " ]";
    }
    
}
