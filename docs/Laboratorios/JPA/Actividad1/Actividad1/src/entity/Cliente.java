/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import vo.ClienteVo;
import vo.FacturaVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByNombreCompleto", query = "SELECT c FROM Cliente c WHERE c.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "Cliente.findByDocumento", query = "SELECT c FROM Cliente c WHERE c.documento = :documento"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")})
public class Cliente implements Serializable, IEntity<ClienteVo> {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    
    @Basic(optional = false)
    @Column(name = "DOCUMENTO")
    private String documento;
    
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private Integer telefono;
    
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Factura> facturasList;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientesID")
    //@OneToOne
    //private List<ClienteFrecuente> clientesFrecuenteList;
    @OneToOne
    private ClienteFrecuente clienteFrecuente;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nombreCompleto, String documento, int telefono, String email) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Factura> getFacturasList() {
        return getFacturasList();
    }

    public void setFacturaList(List<Factura> facturasList) {
        this.setFacturasList(facturasList);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cliente[ id=" + getId() + " ]";
    }

    /**
     * @param facturasList the facturasList to set
     */
    public void setFacturasList(List<Factura> facturasList) {
        this.facturasList = facturasList;
    }

    /**
     * @return the clienteFrecuente
     */
    public ClienteFrecuente getClienteFrecuente() {
        return clienteFrecuente;
    }

    /**
     * @param clienteFrecuente the clienteFrecuente to set
     */
    public void setClienteFrecuente(ClienteFrecuente clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
    }

    @Override
    public ClienteVo toVo() {
        ClienteVo clienteVo = new ClienteVo();
        clienteVo.setClienteFrecuenteId(getClienteFrecuente().getId());
        clienteVo.setDocumento(getDocumento());
        clienteVo.setEmail(getEmail());
        
        List<FacturaVo> facturaVos = new ArrayList<FacturaVo>();
        for (Factura entity:getFacturasList()){
            facturaVos.add(entity.toVo());
        }
        
        clienteVo.setFacturasList(facturaVos);
        clienteVo.setId(getId());
        clienteVo.setNombreCompleto(getNombreCompleto());
        clienteVo.setTelefono(getTelefono());
        return clienteVo;
    }
    
}
