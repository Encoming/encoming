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
public class ClienteVo implements IValueObject{
    private Integer id;
    private String nombreCompleto;
    private String documento;
    private Integer telefono;
    private String email;
    private List<FacturaVo> facturasList;
    private Integer clienteFrecuenteId;

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

    public List<FacturaVo> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<FacturaVo> facturasList) {
        this.facturasList = facturasList;
    }

    public Integer getClienteFrecuenteId() {
        return clienteFrecuenteId;
    }

    public void setClienteFrecuenteId(Integer clienteFrecuenteId) {
        this.clienteFrecuenteId = clienteFrecuenteId;
    }
    
    
    
}
