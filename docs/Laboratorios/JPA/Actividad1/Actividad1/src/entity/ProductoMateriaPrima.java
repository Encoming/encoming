/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Producto_Materia_Prima")
@NamedQueries({
    @NamedQuery(name = "ProductoMateriaPrima.findAll", query = "SELECT p FROM ProductoMateriaPrima p"),
    @NamedQuery(name = "ProductoMateriaPrima.findById", query = "SELECT p FROM ProductoMateriaPrima p WHERE p.id = :id"),
    @NamedQuery(name = "ProductoMateriaPrima.findByNombre", query = "SELECT p FROM ProductoMateriaPrima p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProductoMateriaPrima.findByCantidad", query = "SELECT p FROM ProductoMateriaPrima p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "ProductoMateriaPrima.findByPrecio", query = "SELECT p FROM ProductoMateriaPrima p WHERE p.precio = :precio")})
public class ProductoMateriaPrima implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private Long precio;
    @ManyToMany(mappedBy = "productosMateriaPrimaList")
    private List<Producto> productosList;
    @JoinColumn(name = "Proveedor_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proveedor proveedoresID;

    public ProductoMateriaPrima() {
    }

    public ProductoMateriaPrima(Integer id) {
        this.id = id;
    }

    public ProductoMateriaPrima(Integer id, String nombre, int cantidad, long precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public List<Producto> getProductoList() {
        return productosList;
    }

    public void setProductoList(List<Producto> productosList) {
        this.productosList = productosList;
    }

    public Proveedor getProveedorID() {
        return proveedoresID;
    }

    public void setProveedorID(Proveedor proveedoresID) {
        this.proveedoresID = proveedoresID;
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
        if (!(object instanceof ProductoMateriaPrima)) {
            return false;
        }
        ProductoMateriaPrima other = (ProductoMateriaPrima) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProductoMateriaPrima[ id=" + id + " ]";
    }
    
}
