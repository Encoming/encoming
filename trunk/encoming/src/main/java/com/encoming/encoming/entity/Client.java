/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.AdministratorVo;
import com.encoming.encoming.vo.ClientVo;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findBySendedEncoming", query = "SELECT c FROM Client c WHERE c.sendedEncoming = :sendedEncoming"),
    @NamedQuery(name = "Client.findByReceivedEncoming", query = "SELECT c FROM Client c WHERE c.receivedEncoming = :receivedEncoming")})
public class Client implements Serializable,IEntity<ClientVo>  {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClient")
    private Integer idClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sendedEncoming")
    private int sendedEncoming;
    @Basic(optional = false)
    @NotNull
    @Column(name = "receivedEncoming")
    private int receivedEncoming;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientidClient")
    private List<Shipping> shippingList;
    @JoinColumn(name = "Person_idPerson", referencedColumnName = "idPerson")
    @ManyToOne(optional = false)
    private Person personidPerson;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, int sendedEncoming, int receivedEncoming) {
        this.idClient = idClient;
        this.sendedEncoming = sendedEncoming;
        this.receivedEncoming = receivedEncoming;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public int getSendedEncoming() {
        return sendedEncoming;
    }

    public void setSendedEncoming(int sendedEncoming) {
        this.sendedEncoming = sendedEncoming;
    }

    public int getReceivedEncoming() {
        return receivedEncoming;
    }

    public void setReceivedEncoming(int receivedEncoming) {
        this.receivedEncoming = receivedEncoming;
    }

    @XmlTransient
    public List<Shipping> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Shipping> shippingList) {
        this.shippingList = shippingList;
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
    
    @Override
    public ClientVo toVo(){
        ClientVo clientVo = new ClientVo();
        clientVo.setSendedEncoming(getSendedEncoming());
        clientVo.setReceivedEncoming(getReceivedEncoming());
        List<ShippingVo> shippingVos = new ArrayList<ShippingVo>();
        for(Shipping entity : getShippingList()){
            shippingVos.add(entity.toVo());
        }
        clientVo.setShippingList(shippingVos);
        clientVo.setIdPerson(getPersonidPerson().getIdPerson());
        return clientVo;
    }
    
}
