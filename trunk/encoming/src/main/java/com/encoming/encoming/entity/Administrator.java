/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.AdministratorVo;
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
@Table(name = "administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByIdAdministrator", query = "SELECT a FROM Administrator a WHERE a.idAdministrator = :idAdministrator"),
    @NamedQuery(name = "Administrator.findByUsername", query = "SELECT a FROM Administrator a WHERE a.username = :username"),
    @NamedQuery(name = "Administrator.findByPassword", query = "SELECT a FROM Administrator a WHERE a.password = :password")})
public class Administrator implements Serializable, IEntity<AdministratorVo> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAdministrator")
    private Integer idAdministrator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "Person_idPerson", referencedColumnName = "idPerson")
    @ManyToOne(optional = false)
    private Person personidPerson;

    public Administrator() {
    }

    public Administrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public Administrator(Integer idAdministrator, String username, String password) {
        this.idAdministrator = idAdministrator;
        this.username = username;
        this.password = password;
    }

    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(Person personidPerson) {
        this.personidPerson = personidPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrator != null ? idAdministrator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.idAdministrator == null && other.idAdministrator != null) || (this.idAdministrator != null && !this.idAdministrator.equals(other.idAdministrator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Administrator[ idAdministrator=" + idAdministrator + " ]";
    }
    
    @Override
    public AdministratorVo toVo(){
        AdministratorVo administratorVo = new AdministratorVo();
        administratorVo.setIdAdministrator(getIdAdministrator());
        administratorVo.setPassword(getPassword());
        administratorVo.setUsername(getUsername());
        administratorVo.setPersonidPerson(getPersonidPerson().getIdPerson());
        return administratorVo;
    }
       
}
