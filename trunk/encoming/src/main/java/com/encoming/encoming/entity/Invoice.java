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
    @NamedQuery(name = "Invoice.findByDate", query = "SELECT i FROM Invoice i WHERE i.date = :date"),
    @NamedQuery(name = "Invoice.findByEncomiendaRutaidRuta", query = "SELECT i FROM Invoice i WHERE i.encomiendaRutaidRuta = :encomiendaRutaidRuta"),
    @NamedQuery(name = "Invoice.findByEncomiendaClienteidCliente", query = "SELECT i FROM Invoice i WHERE i.encomiendaClienteidCliente = :encomiendaClienteidCliente")})
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Encomienda_Ruta_idRuta")
    private int encomiendaRutaidRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Encomienda_Cliente_idCliente")
    private int encomiendaClienteidCliente;
    @JoinColumn(name = "Encoming_idEncoming", referencedColumnName = "idEncoming")
    @ManyToOne(optional = false)
    private Encoming encomingidEncoming;

    public Invoice() {
    }

    public Invoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Invoice(Integer idInvoice, String sender, String receiver, Date date, int encomiendaRutaidRuta, int encomiendaClienteidCliente) {
        this.idInvoice = idInvoice;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.encomiendaRutaidRuta = encomiendaRutaidRuta;
        this.encomiendaClienteidCliente = encomiendaClienteidCliente;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEncomiendaRutaidRuta() {
        return encomiendaRutaidRuta;
    }

    public void setEncomiendaRutaidRuta(int encomiendaRutaidRuta) {
        this.encomiendaRutaidRuta = encomiendaRutaidRuta;
    }

    public int getEncomiendaClienteidCliente() {
        return encomiendaClienteidCliente;
    }

    public void setEncomiendaClienteidCliente(int encomiendaClienteidCliente) {
        this.encomiendaClienteidCliente = encomiendaClienteidCliente;
    }

    public Encoming getEncomingidEncoming() {
        return encomingidEncoming;
    }

    public void setEncomingidEncoming(Encoming encomingidEncoming) {
        this.encomingidEncoming = encomingidEncoming;
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
