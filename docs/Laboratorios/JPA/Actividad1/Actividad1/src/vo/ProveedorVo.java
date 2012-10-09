/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.List;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ProveedorVo implements IValueObject{
    
    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private List<ProductoMateriaPrimaVo> productosMateriasPrimasList;

    /**
     * @return the idAdministrador
     */
    public Integer getIdProveedor() {
        return id;
    }

    /**
     * @param idAdministrador the idAdministrador to set
     */
    public void setIdProveedor(Integer idAdministrador) {
        this.id = idAdministrador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the productosMateriasPrimasList
     */
    public List<ProductoMateriaPrimaVo> getProductosMateriasPrimasList() {
        return productosMateriasPrimasList;
    }

    /**
     * @param productosMateriasPrimasList the productosMateriasPrimasList to set
     */
    public void setProductosMateriasPrimasList(List<ProductoMateriaPrimaVo> productosMateriasPrimasList) {
        this.productosMateriasPrimasList = productosMateriasPrimasList;
    }
    
    
    
}
