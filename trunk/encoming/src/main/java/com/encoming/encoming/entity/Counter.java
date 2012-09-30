/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.entity.keys.CounterPK;
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
@Table(name = "Counter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Counter.findAll", query = "SELECT c FROM Counter c"),
    @NamedQuery(name = "Counter.findByIdCounter", query = "SELECT c FROM Counter c WHERE c.counterPK.idCounter = :idCounter"),
    @NamedQuery(name = "Counter.findByUsuario", query = "SELECT c FROM Counter c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Counter.findByContrasenia", query = "SELECT c FROM Counter c WHERE c.contrasenia = :contrasenia"),
    @NamedQuery(name = "Counter.findByTrabajadorcodigo", query = "SELECT c FROM Counter c WHERE c.counterPK.trabajadorcodigo = :trabajadorcodigo")})
public class Counter implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CounterPK counterPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Contrasenia")
    private String contrasenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "counter")
    private List<Encomienda> encomiendaList;
    @JoinColumn(name = "Trabajador_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    public Counter() {
    }

    public Counter(CounterPK counterPK) {
        this.counterPK = counterPK;
    }

    public Counter(CounterPK counterPK, String usuario, String contrasenia) {
        this.counterPK = counterPK;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Counter(int idCounter, int trabajadorcodigo) {
        this.counterPK = new CounterPK(idCounter, trabajadorcodigo);
    }

    public CounterPK getCounterPK() {
        return counterPK;
    }

    public void setCounterPK(CounterPK counterPK) {
        this.counterPK = counterPK;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public List<Encomienda> getEncomiendaList() {
        return encomiendaList;
    }

    public void setEncomiendaList(List<Encomienda> encomiendaList) {
        this.encomiendaList = encomiendaList;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (counterPK != null ? counterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Counter)) {
            return false;
        }
        Counter other = (Counter) object;
        if ((this.counterPK == null && other.counterPK != null) || (this.counterPK != null && !this.counterPK.equals(other.counterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Counter[ counterPK=" + counterPK + " ]";
    }
    
}
