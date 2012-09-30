/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.entity.keys.AdministradorPK;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.administradorPK.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByUsuario", query = "SELECT a FROM Administrador a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "Administrador.findByContrasenia", query = "SELECT a FROM Administrador a WHERE a.contrasenia = :contrasenia"),
    @NamedQuery(name = "Administrador.findByTrabajadorcodigo", query = "SELECT a FROM Administrador a WHERE a.administradorPK.trabajadorcodigo = :trabajadorcodigo")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdministradorPK administradorPK;
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
    @JoinColumn(name = "Trabajador_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    public Administrador() {
    }

    public Administrador(AdministradorPK administradorPK) {
        this.administradorPK = administradorPK;
    }

    public Administrador(AdministradorPK administradorPK, String usuario, String contrasenia) {
        this.administradorPK = administradorPK;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Administrador(int idAdministrador, int trabajadorcodigo) {
        this.administradorPK = new AdministradorPK(idAdministrador, trabajadorcodigo);
    }

    public AdministradorPK getAdministradorPK() {
        return administradorPK;
    }

    public void setAdministradorPK(AdministradorPK administradorPK) {
        this.administradorPK = administradorPK;
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

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administradorPK != null ? administradorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.administradorPK == null && other.administradorPK != null) || (this.administradorPK != null && !this.administradorPK.equals(other.administradorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Administrador[ administradorPK=" + administradorPK + " ]";
    }
}
