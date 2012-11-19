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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Route.findByNumberKilometers", query = "SELECT r FROM Route r WHERE r.numberKilometers = :numberKilometers")})
public class Route implements Serializable, IEntity<RouteVo> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRoute")
    private Integer idRoute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberKilometers")
    private double numberKilometers;
    @OneToOne
    private Point originPoint;
    @OneToOne
    private Point destinationPoint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    private List<Point> pointList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    private List<Shipping> shippingList;

    public Route() {
    }

    public Route(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public Route(Integer idRoute, int numberKilometers, int numberTolls, String destinationCity, String originCity) {
        this.idRoute = idRoute;
        this.numberKilometers = numberKilometers;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public double getNumberKilometers() {
        return numberKilometers;
    }

    public void setNumberKilometers(double numberKilometers) {
        this.numberKilometers = numberKilometers;
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

    public Point getOriginPoint() {
        return originPoint;
    }

    public void setOriginPoint(Point originPoint) {
        this.originPoint = originPoint;
    }

    public Point getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(Point destinationPoint) {
        this.destinationPoint = destinationPoint;
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
        return "RouteE{" 
                + "idRoute=" + idRoute 
                + ",\n\t numberKilometers=" + numberKilometers 
                + ",\n\t originPoint=" + originPoint 
                + ",\n\t destinationPoint=" + destinationPoint 
                + ",\n\t pointList=" + pointList 
                + ",\n\t shippingList=" + shippingList + '}';
    }

    

    @Override
    public RouteVo toVo() {
        RouteVo routeVo = new RouteVo();
        routeVo.setNumberKilometers(getNumberKilometers());
        routeVo.setOriginPoint(getOriginPoint().getIdPoint());
        routeVo.setDestinationPoint(getDestinationPoint().getIdPoint());
        List<PointVo> pointVos = new ArrayList<PointVo>();
        for (Point entity : getPointList()) {
            pointVos.add(entity.toVo());
        }
        routeVo.setPointList(pointVos);
        List<ShippingVo> shippingVos = new ArrayList<ShippingVo>();
        for (Shipping entity : getShippingList()) {
            shippingVos.add(entity.toVo());
        }
        routeVo.setShippingList(shippingVos);
        return routeVo;
    }
}
