/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.vo;

import java.io.Serializable;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class InscripcionVo implements Serializable, IValueObject {
    private Integer id;
    private long valorPagado;
    private String estado;
    private Integer estudianteId;
    private Integer cursoId;

    public InscripcionVo() {
    }

    public InscripcionVo(Integer id) {
        this.id = id;
    }

    public InscripcionVo(Integer id, long valorPagado, String estado) {
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

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
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
        if (!(object instanceof InscripcionVo)) {
            return false;
        }
        InscripcionVo other = (InscripcionVo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.entity.Inscripciones[ id=" + id + " ]";
    }
    
}
