/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.entity.keys.ClientePK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.clientePK.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByEncomiendasEnviadas", query = "SELECT c FROM Cliente c WHERE c.encomiendasEnviadas = :encomiendasEnviadas"),
    @NamedQuery(name = "Cliente.findByEncomiendasRecibidas", query = "SELECT c FROM Cliente c WHERE c.encomiendasRecibidas = :encomiendasRecibidas"),
    @NamedQuery(name = "Cliente.findByPersonadocumento", query = "SELECT c FROM Cliente c WHERE c.clientePK.personadocumento = :personadocumento")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientePK clientePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "encomiendas_enviadas")
    private int encomiendasEnviadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "encomiendas_recibidas")
    private int encomiendasRecibidas;
    @JoinColumn(name = "Persona_documento", referencedColumnName = "documento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Encomienda> encomiendaList;

    public Cliente() {
    }

    public Cliente(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public Cliente(ClientePK clientePK, int encomiendasEnviadas, int encomiendasRecibidas) {
        this.clientePK = clientePK;
        this.encomiendasEnviadas = encomiendasEnviadas;
        this.encomiendasRecibidas = encomiendasRecibidas;
    }

    public Cliente(int idCliente, int personadocumento) {
        this.clientePK = new ClientePK(idCliente, personadocumento);
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public int getEncomiendasEnviadas() {
        return encomiendasEnviadas;
    }

    public void setEncomiendasEnviadas(int encomiendasEnviadas) {
        this.encomiendasEnviadas = encomiendasEnviadas;
    }

    public int getEncomiendasRecibidas() {
        return encomiendasRecibidas;
    }

    public void setEncomiendasRecibidas(int encomiendasRecibidas) {
        this.encomiendasRecibidas = encomiendasRecibidas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Encomienda> getEncomiendaList() {
        return encomiendaList;
    }

    public void setEncomiendaList(List<Encomienda> encomiendaList) {
        this.encomiendaList = encomiendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientePK != null ? clientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clientePK == null && other.clientePK != null) || (this.clientePK != null && !this.clientePK.equals(other.clientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Cliente[ clientePK=" + clientePK + " ]";
    }
    
}
