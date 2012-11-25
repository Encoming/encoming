/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.entity;

import com.encoming.vo.InscripcionVo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "inscripciones")
@NamedQueries({
    @NamedQuery(name = "Inscripciones.findAll", query = "SELECT i FROM Inscripciones i"),
    @NamedQuery(name = "Inscripciones.findById", query = "SELECT i FROM Inscripciones i WHERE i.id = :id"),
    @NamedQuery(name = "Inscripciones.findByValorPagado", query = "SELECT i FROM Inscripciones i WHERE i.valorPagado = :valorPagado"),
    @NamedQuery(name = "Inscripciones.findByEstado", query = "SELECT i FROM Inscripciones i WHERE i.estado = :estado")})
public class Inscripciones implements Serializable, IEntity<InscripcionVo> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "VALOR_PAGADO")
    private long valorPagado;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ESTUDIANTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estudiantes estudianteId;
    @JoinColumn(name = "CURSO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cursos cursoId;

    public Inscripciones() {
    }

    public Inscripciones(Integer id) {
        this.id = id;
    }

    public Inscripciones(Integer id, long valorPagado, String estado) {
        this.id = id;
        this.valorPagado = valorPagado;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(long valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Estudiantes getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Estudiantes estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Cursos getCursoId() {
        return cursoId;
    }

    public void setCursoId(Cursos cursoId) {
        this.cursoId = cursoId;
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
        if (!(object instanceof Inscripciones)) {
            return false;
        }
        Inscripciones other = (Inscripciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.encoming.entity.Inscripciones[ id=" + id + " ]";
//    }

    @Override
    public String toString() {
        return "Inscripciones{" 
                + "\nid=" + id 
                + ",\n valorPagado=" + valorPagado 
                + ",\n estado=" + estado 
                + ",\n estudianteId=" + estudianteId 
                + ",\n cursoId=" + cursoId + '}';
    }

    
    
    @Override
    public InscripcionVo toVo() {
        InscripcionVo inscripcionVo = new InscripcionVo();
        inscripcionVo.setCursoId(getCursoId().getId());
        inscripcionVo.setEstado(getEstado());
        inscripcionVo.setEstudianteId(getEstudianteId().getId());
        inscripcionVo.setId(getId());
        inscripcionVo.setValorPagado(getValorPagado());
        return inscripcionVo;
    }
    
}
