/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.PointVo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Point")
@NamedQueries({
    @NamedQuery(name = "Point.findAll", query = "SELECT p FROM Point p"),
    @NamedQuery(name = "Point.findByIdPoint", query = "SELECT p FROM Point p WHERE p.idPoint = :idPoint"),
    @NamedQuery(name = "Point.findByName", query = "SELECT p FROM Point p WHERE p.name = :name"),
    @NamedQuery(name = "Point.findByLatitude", query = "SELECT p FROM Point p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Point.findByLongitude", query = "SELECT p FROM Point p WHERE p.longitude = :longitude")})
public class Point implements Serializable, IEntity<PointVo> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPoint")
    private Integer idPoint;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;
    @JoinColumn(name = "route", referencedColumnName = "idRoute")
    @ManyToOne
    private Route route;

    public Point() {
    }

    public Point(Integer idPoint) {
        this.idPoint = idPoint;
    }

    public Point(Integer idPoint, String name, double latitude, double longitude) {
        this.idPoint = idPoint;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoint != null ? idPoint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Point)) {
            return false;
        }
        Point other = (Point) object;
        if ((this.idPoint == null && other.idPoint != null) || (this.idPoint != null && !this.idPoint.equals(other.idPoint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Point[ idPoint=" + idPoint + " ]";
    }

    @Override
    public PointVo toVo() {
        PointVo vo = new PointVo();
        vo.setIdPoint(getIdPoint());
        //vo.setIdRoute(getRoute().getIdRoute());
        vo.setLatitude(getLatitude());
        vo.setLongitude(getLongitude());
        vo.setName(getName());
        return vo;
    }
}
