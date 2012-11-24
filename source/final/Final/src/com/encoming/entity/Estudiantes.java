/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "estudiantes")
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findById", query = "SELECT e FROM Estudiantes e WHERE e.id = :id"),
    @NamedQuery(name = "Estudiantes.findByNombre", query = "SELECT e FROM Estudiantes e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiantes.findByDocumento", query = "SELECT e FROM Estudiantes e WHERE e.documento = :documento"),
    @NamedQuery(name = "Estudiantes.findByFechaNacimiento", query = "SELECT e FROM Estudiantes e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Estudiantes.findByActivo", query = "SELECT e FROM Estudiantes e WHERE e.activo = :activo")})
public class Estudiantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DOCUMENTO")
    private String documento;
    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudianteId")
    private List<Inscripciones> inscripcionesList;

    public Estudiantes() {
    }

    public Estudiantes(Integer id) {
        this.id = id;
    }

    public Estudiantes(Integer id, String nombre, String documento, Date fechaNacimiento, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Inscripciones> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripciones> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.entity.Estudiantes[ id=" + id + " ]";
    }
    
}
