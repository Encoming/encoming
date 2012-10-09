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
import javax.persistence.Table;
import vo.ProductoMateriaPrimaVo;
import vo.ProveedorVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Proveedor")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findById", query = "SELECT p FROM Proveedor p WHERE p.id = :id"),
    @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedor.findByEmail", query = "SELECT p FROM Proveedor p WHERE p.email = :email")})
public class Proveedor implements Serializable, IEntity<ProveedorVo> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<ProductoMateriaPrima> productosMateriasPrimasList;

    public Proveedor() {
    }

    public Proveedor(Integer id) {
        this.id = id;
    }

    public Proveedor(Integer id, String nombre, String telefono, String direccion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProductoMateriaPrima> getProductosMateriasPrimasList() {
        return productosMateriasPrimasList;
    }

    public void setProductoMateriaPrimaList(List<ProductoMateriaPrima> productosMateriasPrimasList) {
        this.productosMateriasPrimasList = productosMateriasPrimasList;
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
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Proveedor[ id=" + id + " ]";
    }

    @Override
    public ProveedorVo toVo() {
        ProveedorVo proveedorVo=new ProveedorVo();
        proveedorVo.setNombre(getNombre());
        proveedorVo.setDireccion(getDireccion());
        proveedorVo.setTelefono(getTelefono());
        proveedorVo.setEmail(getEmail());
        proveedorVo.setIdProveedor(getId());
        List<ProductoMateriaPrimaVo> productosMateriasPrimasVos = new ArrayList<ProductoMateriaPrimaVo>();
        for(ProductoMateriaPrima entity:getProductosMateriasPrimasList()){
            productosMateriasPrimasVos.add(entity.toVo());
        }
        proveedorVo.setProductosMateriasPrimasList(productosMateriasPrimasVos);
        
        return null;
    }
    
}
