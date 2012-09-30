/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.entity.keys.TrabajadorPK;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t"),
    @NamedQuery(name = "Trabajador.findByCodigo", query = "SELECT t FROM Trabajador t WHERE t.trabajadorPK.codigo = :codigo"),
    @NamedQuery(name = "Trabajador.findBySalario", query = "SELECT t FROM Trabajador t WHERE t.salario = :salario"),
    @NamedQuery(name = "Trabajador.findByPersonadocumento", query = "SELECT t FROM Trabajador t WHERE t.trabajadorPK.personadocumento = :personadocumento")})
public class Trabajador extends Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrabajadorPK trabajadorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "salario")
    private String salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
    private List<Conductor> conductorList;
    @JoinColumn(name = "Persona_documento", referencedColumnName = "documento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
    private List<Counter> administradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
    private List<Counter> counterList;

    public Trabajador() {
    }

    public Trabajador(TrabajadorPK trabajadorPK) {
        this.trabajadorPK = trabajadorPK;
    }

    public Trabajador(TrabajadorPK trabajadorPK, String salario) {
        this.trabajadorPK = trabajadorPK;
        this.salario = salario;
    }

    public Trabajador(int codigo, int personadocumento) {
        this.trabajadorPK = new TrabajadorPK(codigo, personadocumento);
    }

    public TrabajadorPK getTrabajadorPK() {
        return trabajadorPK;
    }

    public void setTrabajadorPK(TrabajadorPK trabajadorPK) {
        this.trabajadorPK = trabajadorPK;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @XmlTransient
    public List<Conductor> getConductorList() {
        return conductorList;
    }

    public void setConductorList(List<Conductor> conductorList) {
        this.conductorList = conductorList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Counter> getAdministradorList() {
        return administradorList;
    }

    public void setAdministradorList(List<Counter> administradorList) {
        this.administradorList = administradorList;
    }

    @XmlTransient
    public List<Counter> getCounterList() {
        return counterList;
    }

    public void setCounterList(List<Counter> counterList) {
        this.counterList = counterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trabajadorPK != null ? trabajadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.trabajadorPK == null && other.trabajadorPK != null) || (this.trabajadorPK != null && !this.trabajadorPK.equals(other.trabajadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Trabajador[ trabajadorPK=" + trabajadorPK + " ]";
    }
    
}
