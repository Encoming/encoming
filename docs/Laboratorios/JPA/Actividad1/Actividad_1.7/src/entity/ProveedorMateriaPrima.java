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
import javax.persistence.Table;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Proveedor_Materia_Prima")
@NamedQueries({
    @NamedQuery(name = "ProveedoreshasMateriasPrimas.findAll", query = "SELECT p FROM ProveedorMateriaPrima p"),
    @NamedQuery(name = "ProveedoreshasMateriasPrimas.findByPrecio", query = "SELECT p FROM ProveedorMateriaPrima p WHERE p.precio = :precio")})
public class ProveedorMateriaPrima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Proveedor_Materia_Prima_ID")
    private Integer proveedorMateriaPrimaID;
    @Basic(optional = false)
    @Column(name = "precio")
    
    private Long precio;
    @JoinColumn(name = "Materia_Prima_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private MateriaPrima materiaPrima;
    
    @JoinColumn(name = "Proveedores_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proveedor proveedor;

    public ProveedorMateriaPrima() {
    }

    public ProveedorMateriaPrima(Integer proveedoreshasMateriasPrimasID) {
        this.proveedorMateriaPrimaID = proveedoreshasMateriasPrimasID;
    }

    public ProveedorMateriaPrima(Integer proveedoreshasMateriasPrimasID, Long precio) {
        this.proveedorMateriaPrimaID = proveedoreshasMateriasPrimasID;
        this.precio = precio;
    }

    public Integer getProveedoreshasMateriasPrimasID() {
        return proveedorMateriaPrimaID;
    }

    public void setProveedoreshasMateriasPrimasID(Integer proveedoreshasMateriasPrimasID) {
        this.proveedorMateriaPrimaID = proveedoreshasMateriasPrimasID;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Integer getProveedorMateriaPrimaID() {
        return proveedorMateriaPrimaID;
    }

    public void setProveedorMateriaPrimaID(Integer proveedorMateriaPrimaID) {
        this.proveedorMateriaPrimaID = proveedorMateriaPrimaID;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedor getProveedoresID() {
        return proveedor;
    }

    public void setProveedoresID(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorMateriaPrimaID != null ? proveedorMateriaPrimaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorMateriaPrima)) {
            return false;
        }
        ProveedorMateriaPrima other = (ProveedorMateriaPrima) object;
        if ((this.proveedorMateriaPrimaID == null && other.proveedorMateriaPrimaID != null) || (this.proveedorMateriaPrimaID != null && !this.proveedorMateriaPrimaID.equals(other.proveedorMateriaPrimaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProveedoreshasMateriasPrimas[ proveedoreshasMateriasPrimasID=" + proveedorMateriaPrimaID + " ]";
    }
}
