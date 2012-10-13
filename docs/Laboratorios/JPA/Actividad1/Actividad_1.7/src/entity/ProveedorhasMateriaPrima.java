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
@Table(name = "Proveedores_has_Materias_Primas")
@NamedQueries({
    @NamedQuery(name = "ProveedoreshasMateriasPrimas.findAll", query = "SELECT p FROM ProveedorhasMateriaPrima p"),
    @NamedQuery(name = "ProveedoreshasMateriasPrimas.findByProveedoreshasMateriasPrimasID", query = "SELECT p FROM ProveedorhasMateriaPrima p WHERE p.proveedorhasMateriaPrimaID = :proveedoreshasMateriasPrimasID"),
    @NamedQuery(name = "ProveedoreshasMateriasPrimas.findByPrecio", query = "SELECT p FROM ProveedorhasMateriaPrima p WHERE p.precio = :precio")})
public class ProveedorhasMateriaPrima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Proveedores_has_Materias_Primas_ID")
    private Integer proveedorhasMateriaPrimaID;
    @Basic(optional = false)
    @Column(name = "precio")
    private Long precio;
    @JoinColumn(name = "Materias_Primas_ID", referencedColumnName = "Materias_Primas_ID")
    @ManyToOne(optional = false)
    private MateriaPrima materiaPrima;
    @JoinColumn(name = "Proveedores_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proveedor proveedor;

    public ProveedorhasMateriaPrima() {
    }

    public ProveedorhasMateriaPrima(Integer proveedoreshasMateriasPrimasID) {
        this.proveedorhasMateriaPrimaID = proveedoreshasMateriasPrimasID;
    }

    public ProveedorhasMateriaPrima(Integer proveedoreshasMateriasPrimasID, Long precio) {
        this.proveedorhasMateriaPrimaID = proveedoreshasMateriasPrimasID;
        this.precio = precio;
    }

    public Integer getProveedoreshasMateriasPrimasID() {
        return proveedorhasMateriaPrimaID;
    }

    public void setProveedoreshasMateriasPrimasID(Integer proveedoreshasMateriasPrimasID) {
        this.proveedorhasMateriaPrimaID = proveedoreshasMateriasPrimasID;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public MateriaPrima getMateriaPrimaID() {
        return materiaPrima;
    }

    public void setMateriaPrimaID(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
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
        hash += (proveedorhasMateriaPrimaID != null ? proveedorhasMateriaPrimaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorhasMateriaPrima)) {
            return false;
        }
        ProveedorhasMateriaPrima other = (ProveedorhasMateriaPrima) object;
        if ((this.proveedorhasMateriaPrimaID == null && other.proveedorhasMateriaPrimaID != null) || (this.proveedorhasMateriaPrimaID != null && !this.proveedorhasMateriaPrimaID.equals(other.proveedorhasMateriaPrimaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProveedoreshasMateriasPrimas[ proveedoreshasMateriasPrimasID=" + proveedorhasMateriaPrimaID + " ]";
    }
}
