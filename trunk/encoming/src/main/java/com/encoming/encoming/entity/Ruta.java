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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
    @NamedQuery(name = "Ruta.findByIdRuta", query = "SELECT r FROM Ruta r WHERE r.idRuta = :idRuta"),
    @NamedQuery(name = "Ruta.findByNumeroKm", query = "SELECT r FROM Ruta r WHERE r.numeroKm = :numeroKm"),
    @NamedQuery(name = "Ruta.findByNumeroPeajes", query = "SELECT r FROM Ruta r WHERE r.numeroPeajes = :numeroPeajes"),
    @NamedQuery(name = "Ruta.findByListaCiudades", query = "SELECT r FROM Ruta r WHERE r.listaCiudades = :listaCiudades")})
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRuta")
    private Integer idRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_km")
    private int numeroKm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_peajes")
    private int numeroPeajes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lista_ciudades")
    private String listaCiudades;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta")
    private List<Encomienda> encomiendaList;

    public Ruta() {
    }

    public Ruta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Ruta(Integer idRuta, int numeroKm, int numeroPeajes, String listaCiudades) {
        this.idRuta = idRuta;
        this.numeroKm = numeroKm;
        this.numeroPeajes = numeroPeajes;
        this.listaCiudades = listaCiudades;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public int getNumeroKm() {
        return numeroKm;
    }

    public void setNumeroKm(int numeroKm) {
        this.numeroKm = numeroKm;
    }

    public int getNumeroPeajes() {
        return numeroPeajes;
    }

    public void setNumeroPeajes(int numeroPeajes) {
        this.numeroPeajes = numeroPeajes;
    }

    public String getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(String listaCiudades) {
        this.listaCiudades = listaCiudades;
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
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Ruta[ idRuta=" + idRuta + " ]";
    }
    
}
