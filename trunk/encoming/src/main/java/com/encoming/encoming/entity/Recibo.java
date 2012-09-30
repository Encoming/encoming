/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity;

import com.encoming.encoming.entity.keys.ReciboPK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "Recibo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recibo.findAll", query = "SELECT r FROM Recibo r"),
    @NamedQuery(name = "Recibo.findByIdRecibo", query = "SELECT r FROM Recibo r WHERE r.reciboPK.idRecibo = :idRecibo"),
    @NamedQuery(name = "Recibo.findByRemitenteEnvio", query = "SELECT r FROM Recibo r WHERE r.remitenteEnvio = :remitenteEnvio"),
    @NamedQuery(name = "Recibo.findByDestinatarioEnvio", query = "SELECT r FROM Recibo r WHERE r.destinatarioEnvio = :destinatarioEnvio"),
    @NamedQuery(name = "Recibo.findByFecha", query = "SELECT r FROM Recibo r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Recibo.findByEncomiendanumeroguia", query = "SELECT r FROM Recibo r WHERE r.reciboPK.encomiendanumeroguia = :encomiendanumeroguia")})
public class Recibo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReciboPK reciboPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "remitente_envio")
    private String remitenteEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "destinatario_envio")
    private String destinatarioEnvio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Encomienda_numero_guia", referencedColumnName = "numero_guia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encomienda encomienda;

    public Recibo() {
    }

    public Recibo(ReciboPK reciboPK) {
        this.reciboPK = reciboPK;
    }

    public Recibo(ReciboPK reciboPK, String remitenteEnvio, String destinatarioEnvio, Date fecha) {
        this.reciboPK = reciboPK;
        this.remitenteEnvio = remitenteEnvio;
        this.destinatarioEnvio = destinatarioEnvio;
        this.fecha = fecha;
    }

    public Recibo(int idRecibo, int encomiendanumeroguia) {
        this.reciboPK = new ReciboPK(idRecibo, encomiendanumeroguia);
    }

    public ReciboPK getReciboPK() {
        return reciboPK;
    }

    public void setReciboPK(ReciboPK reciboPK) {
        this.reciboPK = reciboPK;
    }

    public String getRemitenteEnvio() {
        return remitenteEnvio;
    }

    public void setRemitenteEnvio(String remitenteEnvio) {
        this.remitenteEnvio = remitenteEnvio;
    }

    public String getDestinatarioEnvio() {
        return destinatarioEnvio;
    }

    public void setDestinatarioEnvio(String destinatarioEnvio) {
        this.destinatarioEnvio = destinatarioEnvio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Encomienda getEncomienda() {
        return encomienda;
    }

    public void setEncomienda(Encomienda encomienda) {
        this.encomienda = encomienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reciboPK != null ? reciboPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recibo)) {
            return false;
        }
        Recibo other = (Recibo) object;
        if ((this.reciboPK == null && other.reciboPK != null) || (this.reciboPK != null && !this.reciboPK.equals(other.reciboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.Recibo[ reciboPK=" + reciboPK + " ]";
    }
    
}
