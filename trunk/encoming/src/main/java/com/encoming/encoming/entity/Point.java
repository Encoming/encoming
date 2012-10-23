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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "point")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Point.findAll", query = "SELECT p FROM Point p"),
    @NamedQuery(name = "Point.findByIdPoint", query = "SELECT p FROM Point p WHERE p.idPoint = :idPoint"),
    @NamedQuery(name = "Point.findByName", query = "SELECT p FROM Point p WHERE p.name = :name")})
public class Point implements Serializable,IEntity<PointVo> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPoint")
    private Integer idPoint;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "Route_idRoute", referencedColumnName = "idRoute")
    @ManyToOne(optional = false)
    private Route routeidRoute;

    public Point() {
    }

    public Point(Integer idPoint) {
        this.idPoint = idPoint;
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

    public Route getRouteidRoute() {
        return routeidRoute;
    }

    public void setRouteidRoute(Route routeidRoute) {
        this.routeidRoute = routeidRoute;
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
    public PointVo toVo(){
        PointVo pointVo = new PointVo();
        pointVo.setIdPoint(getIdPoint());
        pointVo.setName(getName());
        pointVo.setIdRoute(getRouteidRoute().getIdRoute());      
        return pointVo;
    } 
}
