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
@Table(name = "Route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findByIdRoute", query = "SELECT r FROM Route r WHERE r.idRoute = :idRoute"),
    @NamedQuery(name = "Route.findByNumberKilometers", query = "SELECT r FROM Route r WHERE r.numberKilometers = :numberKilometers"),
    @NamedQuery(name = "Route.findByNumberTolls", query = "SELECT r FROM Route r WHERE r.numberTolls = :numberTolls"),
    @NamedQuery(name = "Route.findByPointsList", query = "SELECT r FROM Route r WHERE r.pointsList = :pointsList")})
public class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRoute")
    private Integer idRoute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberKilometers")
    private int numberKilometers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberTolls")
    private int numberTolls;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pointsList")
    private String pointsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeidRoute")
    private List<Encoming> encomingList;

    public Route() {
    }

    public Route(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public Route(Integer idRoute, int numberKilometers, int numberTolls, String pointsList) {
        this.idRoute = idRoute;
        this.numberKilometers = numberKilometers;
        this.numberTolls = numberTolls;
        this.pointsList = pointsList;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public int getNumberKilometers() {
        return numberKilometers;
    }

    public void setNumberKilometers(int numberKilometers) {
        this.numberKilometers = numberKilometers;
    }

    public int getNumberTolls() {
        return numberTolls;
    }

    public void setNumberTolls(int numberTolls) {
        this.numberTolls = numberTolls;
    }

    public String getPointsList() {
        return pointsList;
    }

    public void setPointsList(String pointsList) {
        this.pointsList = pointsList;
    }

    @XmlTransient
    public List<Encoming> getEncomingList() {
        return encomingList;
    }

    public void setEncomingList(List<Encoming> encomingList) {
        this.encomingList = encomingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoute != null ? idRoute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.idRoute == null && other.idRoute != null) || (this.idRoute != null && !this.idRoute.equals(other.idRoute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Route[ idRoute=" + idRoute + " ]";
    }
    
}
