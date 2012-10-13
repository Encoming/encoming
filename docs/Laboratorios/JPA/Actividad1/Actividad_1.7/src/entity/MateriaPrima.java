/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Materias_Primas")
@NamedQueries({
    @NamedQuery(name = "MateriasPrimas.findAll", query = "SELECT m FROM MateriaPrima m"),
    @NamedQuery(name = "MateriasPrimas.findByMateriasPrimasID", query = "SELECT m FROM MateriaPrima m WHERE m.materiasPrimasID = :materiasPrimasID")})
public class MateriaPrima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Materias_Primas_ID")
    private Integer materiasPrimasID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaPrima")
    private List<ProveedorhasMateriaPrima> proveedoreshasMateriasPrimas;
    @JoinColumn(name = "Productos_Materias_Primas_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProductoMateriaPrima productoMateriaPrima;
    @JoinColumn(name = "Productos_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Producto producto;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer materiasPrimasID) {
        this.materiasPrimasID = materiasPrimasID;
    }

    public Integer getMateriasPrimasID() {
        return materiasPrimasID;
    }

    public void setMateriasPrimasID(Integer materiasPrimasID) {
        this.materiasPrimasID = materiasPrimasID;
    }

    public List<ProveedorhasMateriaPrima> getProveedoreshasMateriasPrimasList() {
        return proveedoreshasMateriasPrimas;
    }

    public void setProveedoreshasMateriasPrimasList(List<ProveedorhasMateriaPrima> proveedoreshasMateriasPrimasList) {
        this.proveedoreshasMateriasPrimas = proveedoreshasMateriasPrimasList;
    }

    public ProductoMateriaPrima getProductoMateriaPrimaID() {
        return productoMateriaPrima;
    }

    public void setProductosMateriasPrimasID(ProductoMateriaPrima productoMateriaPrimas) {
        this.productoMateriaPrima = productoMateriaPrimas;
    }

    public Producto getProductoID() {
        return producto;
    }

    public void setProductoID(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiasPrimasID != null ? materiasPrimasID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaPrima)) {
            return false;
        }
        MateriaPrima other = (MateriaPrima) object;
        if ((this.materiasPrimasID == null && other.materiasPrimasID != null) || (this.materiasPrimasID != null && !this.materiasPrimasID.equals(other.materiasPrimasID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MateriasPrimas[ materiasPrimasID=" + materiasPrimasID + " ]";
    }
}
