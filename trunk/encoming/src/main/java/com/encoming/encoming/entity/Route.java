/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.PointVo;
import com.encoming.encoming.vo.RouteVo;
import com.encoming.encoming.vo.ShippingVo;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author andres
 */
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findByIdRoute", query = "SELECT r FROM Route r WHERE r.idRoute = :idRoute"),
    @NamedQuery(name = "Route.findByNumberKilometers", query = "SELECT r FROM Route r WHERE r.numberKilometers = :numberKilometers"),
    @NamedQuery(name = "Route.findByNumberTolls", query = "SELECT r FROM Route r WHERE r.numberTolls = :numberTolls"),
    @NamedQuery(name = "Route.findByDestinationCity", query = "SELECT r FROM Route r WHERE r.destinationCity = :destinationCity"),
    @NamedQuery(name = "Route.findByOriginCity", query = "SELECT r FROM Route r WHERE r.originCity = :originCity")})
public class Route implements Serializable,IEntity<RouteVo>{
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
    @Size(min = 1, max = 20)
    @Column(name = "destinationCity")
    private String destinationCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "originCity")
    private String originCity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    private List<Point> pointList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeidRoute")
    private List<Shipping> shippingList;

    public Route() {
    }

    public Route(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public Route(Integer idRoute, int numberKilometers, int numberTolls, String destinationCity, String originCity) {
        this.idRoute = idRoute;
        this.numberKilometers = numberKilometers;
        this.numberTolls = numberTolls;
        this.destinationCity = destinationCity;
        this.originCity = originCity;
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

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    @XmlTransient
    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    @XmlTransient
    public List<Shipping> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Shipping> shippingList) {
        this.shippingList = shippingList;
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
    
    @Override
    public RouteVo toVo(){
        RouteVo routeVo = new RouteVo();
        routeVo.setNumberKilometers(getNumberKilometers());
        routeVo.setNumberTolls(getNumberTolls());
        routeVo.setDestinationCity(getDestinationCity());
        routeVo.setOriginCity(getOriginCity());
        List<PointVo> pointVos = new ArrayList<PointVo>();
        for(Point entity : getPointList()){
            pointVos.add(entity.toVo());
        }
        routeVo.setPointList(pointVos);
        List<ShippingVo> shippingVos = new ArrayList<ShippingVo>();
        for(Shipping entity : getShippingList()){
            shippingVos.add(entity.toVo());
        }
        routeVo.setShippingList(shippingVos);
        return routeVo;
    } 
    
}
