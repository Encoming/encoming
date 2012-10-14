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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Familia Martinez
 */
@Entity
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Productos.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Producto p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "Productos.findByUnidad", query = "SELECT p FROM Producto p WHERE p.unidad = :unidad")})
public class Producto implements Serializable {
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
    @Column(name = "PRECIO_VENTA")
    private Long precioVenta;
    @Basic(optional = false)
    @Column(name = "UNIDAD")
    private String unidad;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Factura_Producto> factura_ProductoList;
    
     @JoinTable(name = "productos_materias_primas", joinColumns = {
        @JoinColumn(name = "Producto_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Materia_Prima_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<MateriaPrima> MateriasPrimasList;
    
    @JoinColumn(name = "Tipo_Producto_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, Integer cantidad, Long precioVenta, String unidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.unidad = unidad;
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

    public Long getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Long precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public List<Factura_Producto> getFactura_ProductoList() {
        return factura_ProductoList;
    }

    public void setFactura_ProductoList(List<Factura_Producto> factura_ProductoList) {
        this.factura_ProductoList = factura_ProductoList;
    }

    public List<MateriaPrima> getMateriasPrimasList() {
        return MateriasPrimasList;
    }

    public void setMateriasPrimasList(List<MateriaPrima> MateriasPrimasList) {
        this.MateriasPrimasList = MateriasPrimasList;
    }


    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productos[ id=" + id + " ]";
    }
    
}
