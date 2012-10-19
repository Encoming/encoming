/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.vo.PersonVo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmanuelmartinezromero
 */
//@Entity
//@Table(name = "person")
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastname"),
    @NamedQuery(name = "Person.findByMail", query = "SELECT p FROM Person p WHERE p.mail = :mail"),
    @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone"),
    @NamedQuery(name = "Person.findByAdress", query = "SELECT p FROM Person p WHERE p.adress = :adress")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPerson")
    private Integer idPerson;
    @Size(max = 25)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Size(max = 30)
    @Column(name = "mail")
    private String mail;
    @Column(name = "phone")
    private Integer phone;
    @Basic(optional = false)
    @Size(max = 25)
    @Column(name = "adress")
    private String adress;
    @Basic(optional = false)
    @Size(max = 45)
    @Column(name = "password")
    private String password;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(Integer idPerson, String lastanames) {
        this.idPerson = idPerson;
        this.lastName = lastanames;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Person[ idPerson=" + idPerson + " ]";
    }

    public PersonVo toVo() {
        PersonVo vo = new PersonVo();
        
        vo.setIdPerson(getIdPerson());
        vo.setName(getName());
        vo.setLastName(getLastName());
        vo.setAdress(getAdress());
        vo.setMail(getMail());
        vo.setPassword(getPassword());
        vo.setPhone(getPhone());
        return vo;
    }
    
}
