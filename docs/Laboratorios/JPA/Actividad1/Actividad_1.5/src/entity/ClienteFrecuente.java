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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Familia Martinez
 */
@Entity
@Table(name = "clientes_frecuentes")
@NamedQueries({
    @NamedQuery(name = "ClientesFrecuentes.findAll", query = "SELECT c FROM ClienteFrecuente c"),
    @NamedQuery(name = "ClientesFrecuentes.findById", query = "SELECT c FROM ClienteFrecuente c WHERE c.id = :id"),
    @NamedQuery(name = "ClientesFrecuentes.findByNumCuenta", query = "SELECT c FROM ClienteFrecuente c WHERE c.numCuenta = :numCuenta"),
    @NamedQuery(name = "ClientesFrecuentes.findByDireccion", query = "SELECT c FROM ClienteFrecuente c WHERE c.direccion = :direccion")})
public class ClienteFrecuente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NUM_CUENTA")
    private String numCuenta;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;

    @OneToOne
    @JoinColumn(name = "Cliente_ID")
    private Cliente cliente;

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
        return "entity.ClientesFrecuentes[ id=" + id + " ]";
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
