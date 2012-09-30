/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity.keys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Embeddable
public class EncomiendaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_guia")
    private int numeroGuia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ruta_idRuta")
    private int rutaidRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vehiculo_placa_numeros")
    private int vehiculoplacanumeros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Vehiculo_placa_letras")
    private String vehiculoplacaletras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Counter_idCounter")
    private int counteridCounter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cliente_idCliente")
    private int clienteidCliente;

    public EncomiendaPK() {
    }

    public EncomiendaPK(int numeroGuia, int rutaidRuta, int vehiculoplacanumeros, String vehiculoplacaletras, int counteridCounter, int clienteidCliente) {
        this.numeroGuia = numeroGuia;
        this.rutaidRuta = rutaidRuta;
        this.vehiculoplacanumeros = vehiculoplacanumeros;
        this.vehiculoplacaletras = vehiculoplacaletras;
        this.counteridCounter = counteridCounter;
        this.clienteidCliente = clienteidCliente;
    }

    public int getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(int numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public int getRutaidRuta() {
        return rutaidRuta;
    }

    public void setRutaidRuta(int rutaidRuta) {
        this.rutaidRuta = rutaidRuta;
    }

    public int getVehiculoplacanumeros() {
        return vehiculoplacanumeros;
    }

    public void setVehiculoplacanumeros(int vehiculoplacanumeros) {
        this.vehiculoplacanumeros = vehiculoplacanumeros;
    }

    public String getVehiculoplacaletras() {
        return vehiculoplacaletras;
    }

    public void setVehiculoplacaletras(String vehiculoplacaletras) {
        this.vehiculoplacaletras = vehiculoplacaletras;
    }

    public int getCounteridCounter() {
        return counteridCounter;
    }

    public void setCounteridCounter(int counteridCounter) {
        this.counteridCounter = counteridCounter;
    }

    public int getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(int clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroGuia;
        hash += (int) rutaidRuta;
        hash += (int) vehiculoplacanumeros;
        hash += (vehiculoplacaletras != null ? vehiculoplacaletras.hashCode() : 0);
        hash += (int) counteridCounter;
        hash += (int) clienteidCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncomiendaPK)) {
            return false;
        }
        EncomiendaPK other = (EncomiendaPK) object;
        if (this.numeroGuia != other.numeroGuia) {
            return false;
        }
        if (this.rutaidRuta != other.rutaidRuta) {
            return false;
        }
        if (this.vehiculoplacanumeros != other.vehiculoplacanumeros) {
            return false;
        }
        if ((this.vehiculoplacaletras == null && other.vehiculoplacaletras != null) || (this.vehiculoplacaletras != null && !this.vehiculoplacaletras.equals(other.vehiculoplacaletras))) {
            return false;
        }
        if (this.counteridCounter != other.counteridCounter) {
            return false;
        }
        if (this.clienteidCliente != other.clienteidCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.EncomiendaPK[ numeroGuia=" + numeroGuia + ", rutaidRuta=" + rutaidRuta + ", vehiculoplacanumeros=" + vehiculoplacanumeros + ", vehiculoplacaletras=" + vehiculoplacaletras + ", counteridCounter=" + counteridCounter + ", clienteidCliente=" + clienteidCliente + " ]";
    }
    
}
