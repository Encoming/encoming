/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.entity.keys.EncomiendaPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Encomienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encomienda.findAll", query = "SELECT e FROM Encomienda e"),
    @NamedQuery(name = "Encomienda.findByNumeroGuia", query = "SELECT e FROM Encomienda e WHERE e.encomiendaPK.numeroGuia = :numeroGuia"),
    @NamedQuery(name = "Encomienda.findByTipo", query = "SELECT e FROM Encomienda e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Encomienda.findByTama\u00f1o", query = "SELECT e FROM Encomienda e WHERE e.tama\u00f1o = :tama\u00f1o"),
    @NamedQuery(name = "Encomienda.findByPrioridad", query = "SELECT e FROM Encomienda e WHERE e.prioridad = :prioridad"),
    @NamedQuery(name = "Encomienda.findByCiudadOrigen", query = "SELECT e FROM Encomienda e WHERE e.ciudadOrigen = :ciudadOrigen"),
    @NamedQuery(name = "Encomienda.findByCiudadDestino", query = "SELECT e FROM Encomienda e WHERE e.ciudadDestino = :ciudadDestino"),
    @NamedQuery(name = "Encomienda.findByRutaidRuta", query = "SELECT e FROM Encomienda e WHERE e.encomiendaPK.rutaidRuta = :rutaidRuta"),
    @NamedQuery(name = "Encomienda.findByVehiculoplacanumeros", query = "SELECT e FROM Encomienda e WHERE e.encomiendaPK.vehiculoplacanumeros = :vehiculoplacanumeros"),
    @NamedQuery(name = "Encomienda.findByVehiculoplacaletras", query = "SELECT e FROM Encomienda e WHERE e.encomiendaPK.vehiculoplacaletras = :vehiculoplacaletras"),
    @NamedQuery(name = "Encomienda.findByCounteridCounter", query = "SELECT e FROM Encomienda e WHERE e.encomiendaPK.counteridCounter = :counteridCounter"),
    @NamedQuery(name = "Encomienda.findByClienteidCliente", query = "SELECT e FROM Encomienda e WHERE e.encomiendaPK.clienteidCliente = :clienteidCliente")})
public class Encomienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EncomiendaPK encomiendaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tama\u00f1o")
    private String tamaño;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "prioridad")
    private String prioridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ciudad_origen")
    private String ciudadOrigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ciudad_destino")
    private String ciudadDestino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encomienda")
    private List<Recibo> reciboList;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "Counter_idCounter", referencedColumnName = "idCounter", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Counter counter;
    @JoinColumns({
        @JoinColumn(name = "Vehiculo_placa_numeros", referencedColumnName = "placa_numeros", insertable = false, updatable = false),
        @JoinColumn(name = "Vehiculo_placa_letras", referencedColumnName = "placa_letras", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Vehiculo vehiculo;
    @JoinColumn(name = "Ruta_idRuta", referencedColumnName = "idRuta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ruta ruta;

    public Encomienda() {
    }

    public Encomienda(EncomiendaPK encomiendaPK) {
        this.encomiendaPK = encomiendaPK;
    }

    public Encomienda(EncomiendaPK encomiendaPK, String tipo, String tamaño, String prioridad, String ciudadOrigen, String ciudadDestino) {
        this.encomiendaPK = encomiendaPK;
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.prioridad = prioridad;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    public Encomienda(int numeroGuia, int rutaidRuta, int vehiculoplacanumeros, String vehiculoplacaletras, int counteridCounter, int clienteidCliente) {
        this.encomiendaPK = new EncomiendaPK(numeroGuia, rutaidRuta, vehiculoplacanumeros, vehiculoplacaletras, counteridCounter, clienteidCliente);
    }

    public EncomiendaPK getEncomiendaPK() {
        return encomiendaPK;
    }

    public void setEncomiendaPK(EncomiendaPK encomiendaPK) {
        this.encomiendaPK = encomiendaPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    @XmlTransient
    public List<Recibo> getReciboList() {
        return reciboList;
    }

    public void setReciboList(List<Recibo> reciboList) {
        this.reciboList = reciboList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encomiendaPK != null ? encomiendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encomienda)) {
            return false;
        }
        Encomienda other = (Encomienda) object;
        if ((this.encomiendaPK == null && other.encomiendaPK != null) || (this.encomiendaPK != null && !this.encomiendaPK.equals(other.encomiendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Encomienda[ encomiendaPK=" + encomiendaPK + " ]";
    }
    
}
