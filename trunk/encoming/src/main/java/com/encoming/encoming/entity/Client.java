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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findBySendedEncomiendas", query = "SELECT c FROM Client c WHERE c.sendedEncomiendas = :sendedEncomiendas"),
    @NamedQuery(name = "Client.findByReceivedEncomiendas", query = "SELECT c FROM Client c WHERE c.receivedEncomiendas = :receivedEncomiendas")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClient")
    private Integer idClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sendedEncomiendas")
    private int sendedEncomiendas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "receivedEncomiendas")
    private int receivedEncomiendas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientidClient")
    private List<Encoming> encomingList;
    @JoinColumn(name = "Person_idPerson", referencedColumnName = "idPerson")
    @ManyToOne(optional = false)
    private Person personidPerson;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, int sendedEncomiendas, int receivedEncomiendas) {
        this.idClient = idClient;
        this.sendedEncomiendas = sendedEncomiendas;
        this.receivedEncomiendas = receivedEncomiendas;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public int getSendedEncomiendas() {
        return sendedEncomiendas;
    }

    public void setSendedEncomiendas(int sendedEncomiendas) {
        this.sendedEncomiendas = sendedEncomiendas;
    }

    public int getReceivedEncomiendas() {
        return receivedEncomiendas;
    }

    public void setReceivedEncomiendas(int receivedEncomiendas) {
        this.receivedEncomiendas = receivedEncomiendas;
    }

    @XmlTransient
    public List<Encoming> getEncomingList() {
        return encomingList;
    }

    public void setEncomingList(List<Encoming> encomingList) {
        this.encomingList = encomingList;
    }

    public Person getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(Person personidPerson) {
        this.personidPerson = personidPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Client[ idClient=" + idClient + " ]";
    }
    
}
