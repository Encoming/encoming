/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.entity.keys.ConductorPK;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Conductor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c"),
    @NamedQuery(name = "Conductor.findByIdConductor", query = "SELECT c FROM Conductor c WHERE c.conductorPK.idConductor = :idConductor"),
    @NamedQuery(name = "Conductor.findByLicenciaConduccion", query = "SELECT c FROM Conductor c WHERE c.licenciaConduccion = :licenciaConduccion"),
    @NamedQuery(name = "Conductor.findByTrabajadorcodigo", query = "SELECT c FROM Conductor c WHERE c.conductorPK.trabajadorcodigo = :trabajadorcodigo"),
    @NamedQuery(name = "Conductor.findByVehiculoplacanumeros", query = "SELECT c FROM Conductor c WHERE c.conductorPK.vehiculoplacanumeros = :vehiculoplacanumeros"),
    @NamedQuery(name = "Conductor.findByVehiculoplacaletras", query = "SELECT c FROM Conductor c WHERE c.conductorPK.vehiculoplacaletras = :vehiculoplacaletras")})
public class Conductor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConductorPK conductorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "licencia_conduccion")
    private String licenciaConduccion;
    @JoinColumns({
        @JoinColumn(name = "Vehiculo_placa_numeros", referencedColumnName = "placa_numeros", insertable = false, updatable = false),
        @JoinColumn(name = "Vehiculo_placa_letras", referencedColumnName = "placa_letras", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Vehiculo vehiculo;
    @JoinColumn(name = "Trabajador_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    public Conductor() {
    }

    public Conductor(ConductorPK conductorPK) {
        this.conductorPK = conductorPK;
    }

    public Conductor(ConductorPK conductorPK, String licenciaConduccion) {
        this.conductorPK = conductorPK;
        this.licenciaConduccion = licenciaConduccion;
    }

    public Conductor(int idConductor, int trabajadorcodigo, int vehiculoplacanumeros, String vehiculoplacaletras) {
        this.conductorPK = new ConductorPK(idConductor, trabajadorcodigo, vehiculoplacanumeros, vehiculoplacaletras);
    }

    public ConductorPK getConductorPK() {
        return conductorPK;
    }

    public void setConductorPK(ConductorPK conductorPK) {
        this.conductorPK = conductorPK;
    }

    public String getLicenciaConduccion() {
        return licenciaConduccion;
    }

    public void setLicenciaConduccion(String licenciaConduccion) {
        this.licenciaConduccion = licenciaConduccion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conductorPK != null ? conductorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.conductorPK == null && other.conductorPK != null) || (this.conductorPK != null && !this.conductorPK.equals(other.conductorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Conductor[ conductorPK=" + conductorPK + " ]";
    }
    
}
