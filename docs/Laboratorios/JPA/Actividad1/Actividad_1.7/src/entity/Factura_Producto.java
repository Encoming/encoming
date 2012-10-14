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
import javax.persistence.Table;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Facturas_Productos")
public class Factura_Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Factura_Producto_ID")
    private Integer facturaProductoId;
    @JoinColumn(name = "Factura_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Factura factura;
    @JoinColumn(name = "Producto_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Producto producto;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;

    public Factura_Producto() {
    }

    public Factura_Producto(Integer facturaProductoId) {
        this.facturaProductoId = facturaProductoId;
    }

    public Factura_Producto(Integer facturaProductoId, Integer cantidad) {
        this.facturaProductoId = facturaProductoId;
        this.cantidad = cantidad;
    }

    public Integer getFacturaProductoId() {
        return facturaProductoId;
    }

    public void setFacturaProductoId(Integer facturaProductoId) {
        this.facturaProductoId = facturaProductoId;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaProductoId != null ? facturaProductoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura_Producto)) {
            return false;
        }
        Factura_Producto other = (Factura_Producto) object;
        if ((this.facturaProductoId == null && other.facturaProductoId != null) || (this.facturaProductoId != null && !this.facturaProductoId.equals(other.facturaProductoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Factura_Producto[ facturaProductoId=" + facturaProductoId + " ]";
    }
}
