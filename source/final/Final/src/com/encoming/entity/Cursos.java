/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.entity;

import com.encoming.vo.CursoVo;
import com.encoming.vo.InscripcionVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Entity
@Table(name = "cursos")
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findById", query = "SELECT c FROM Cursos c WHERE c.id = :id"),
    @NamedQuery(name = "Cursos.findByNombre", query = "SELECT c FROM Cursos c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cursos.findByValorCurso", query = "SELECT c FROM Cursos c WHERE c.valorCurso = :valorCurso")})
public class Cursos implements Serializable, IEntity<CursoVo> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "VALOR_CURSO")
    private long valorCurso;
    @OneToOne
    @Column(name = "PRERREQUISITO_CURSO_ID")
    private Cursos prerequisito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoId")
    private List<Inscripciones> inscripcionesList;

    public Cursos() {
    }

    public Cursos(Integer id) {
        this.id = id;
    }

    public Cursos(Integer id, String nombre, long valorCurso) {
        this.id = id;
        this.nombre = nombre;
        this.valorCurso = valorCurso;
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

    public long getValorCurso() {
        return valorCurso;
    }

    public void setValorCurso(long valorCurso) {
        this.valorCurso = valorCurso;
    }

    public Cursos getPrerequisito() {
        return prerequisito;
    }

    public void setPrerequisito(Cursos prerequisito) {
        this.prerequisito = prerequisito;
    }

    public List<Inscripciones> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripciones> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
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
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.entity.Cursos[ id=" + id + " ]";
    }

    @Override
    public CursoVo toVo() {
        CursoVo cursoVo = new CursoVo();
        cursoVo.setId(getId());

        List<InscripcionVo> inscripcionVo = new ArrayList<InscripcionVo>();
        for (Inscripciones entity : getInscripcionesList()) {
            inscripcionVo.add(entity.toVo());
        }
        cursoVo.setInscripcionesList(inscripcionVo);
        cursoVo.setNombre(getNombre());
        cursoVo.setPrerequisitoCursoId(getPrerequisito().getId());
        cursoVo.setValorCurso(getValorCurso());

        return cursoVo;
    }
}
