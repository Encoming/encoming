/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Cliente_Frecuente")
@NamedQueries({
    @NamedQuery(name = "ClienteFrecuente.findAll", query = "SELECT c FROM ClienteFrecuente c"),
    @NamedQuery(name = "ClienteFrecuente.findById", query = "SELECT c FROM ClienteFrecuente c WHERE c.id = :id"),
    @NamedQuery(name = "ClienteFrecuente.findByNumCuenta", query = "SELECT c FROM ClienteFrecuente c WHERE c.numCuenta = :numCuenta"),
    @NamedQuery(name = "ClienteFrecuente.findByDireccion", query = "SELECT c FROM ClienteFrecuente c WHERE c.direccion = :direccion")})
public class ClienteFrecuente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUM_CUENTA")
    private String numCuenta;
    @Column(name = "DIRECCION")
    private String direccion;
    //@JoinColumn(name = "Cliente_ID", referencedColumnName = "ID")
    //@ManyToOne(optional = false)
    @OneToOne
    @JoinColumn(name="clienteFrecuente")
    private Cliente clientesID;

    public ClienteFrecuente() {
    }

    public ClienteFrecuente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente getClienteID() {
        return clientesID;
    }

    public void setClienteID(Cliente clientesID) {
        this.clientesID = clientesID;
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
        if (!(object instanceof ClienteFrecuente)) {
            return false;
        }
        ClienteFrecuente other = (ClienteFrecuente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClienteFrecuente[ id=" + id + " ]";
    }
    
}
