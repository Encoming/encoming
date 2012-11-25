/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class EstudianteVo implements Serializable, IValueObject {
    private Integer id;
    private String nombre;
    private String documento;
    private Date fechaNacimiento;
    private boolean activo;
    private List<InscripcionVo> inscripcionesList;

    public EstudianteVo() {
    }

    public EstudianteVo(Integer id) {
        this.id = id;
    }

    public EstudianteVo(Integer id, String nombre, String documento, Date fechaNacimiento, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        if (!(object instanceof EstudianteVo)) {
            return false;
        }
        EstudianteVo other = (EstudianteVo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.encoming.entity.Estudiantes[ id=" + id + " ]";
//    }

    @Override
    public String toString() {
        return "EstudianteVo{" + "id=" + id + ", nombre=" + nombre + ", documento=" + documento + ", fechaNacimiento=" + fechaNacimiento + ", activo=" + activo + ", inscripcionesList=" + inscripcionesList + '}';
    }
    
}
