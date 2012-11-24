/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.vo;

import java.io.Serializable;
import java.util.List;

public class CursoVo implements Serializable, IValueObject {

    private Integer id;
    private String nombre;
    private long valorCurso;
    private Integer prerequisitoCursoId;
    private List<InscripcionVo> inscripcionesList;


    public CursoVo() {
    }

    public CursoVo(Integer id) {
        this.id = id;
    }

    public CursoVo(Integer id, String nombre, long valorCurso) {
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

    public Integer getPrerequisitoCursoId() {
        return prerequisitoCursoId;
    }

    public void setPrerequisitoCursoId(Integer prerequisitoCursoId) {
        this.prerequisitoCursoId = prerequisitoCursoId;
    }

    public List<InscripcionVo> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<InscripcionVo> inscripcionesList) {
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
        if (!(object instanceof CursoVo)) {
            return false;
        }
        CursoVo other = (CursoVo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.entity.Cursos[ id=" + id + " ]";
    }
}
