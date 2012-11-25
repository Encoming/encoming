/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.CursoFacade;
import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.utils.ExisteCursoException;
import com.encoming.vo.CursoVo;
import com.encoming.vo.EstudianteVo;
import com.encoming.vo.InscripcionVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andres
 */
public class CursoController { 
    
    public List<Integer> idEstudiantes = new ArrayList<Integer>();
            
    public static String validateName(String text) {
        int a = text.length();
        if (a < 4 || a > 50) {
            return "La longitud del nombre debe estar entre 4 y 50";
        }
        return "Validado";
    }

    public void crearCurso(String nombre, String prerequisito, long valor) throws ExisteCursoException {
        assert !"Prueba0".equals(nombre) : "Tratando de crear un curso Prueba0";
        if (FacadeFactory.getInstance().getCursoFacade().findByName(nombre) == null) {
            CursoVo prerequisitos = FacadeFactory.getInstance().getCursoFacade().findByName(prerequisito);

            CursoVo cursoVo = new CursoVo();
            cursoVo.setNombre(nombre);
            try {
                cursoVo.setPrerequisitoCursoId(prerequisitos.getId());
            } catch (NullPointerException e) {
            }
            cursoVo.setValorCurso(valor);
            CursoFacade cursoFacade = FacadeFactory.getInstance().getCursoFacade();

            cursoFacade.create1(cursoVo);
        } else {
            throw new ExisteCursoException("Ya existe el curso");
        }

    }

    public Object[] getCursosNames() {
        List<String> nombres = new ArrayList<String>();
        List<CursoVo> cursoVos = FacadeFactory.getInstance().getCursoFacade().getList();
        if (cursoVos != null) {
            for (CursoVo cursoVo : cursoVos) {
                nombres.add(cursoVo.getNombre());
            }
        }
        return nombres.toArray();
    } 
    
    public List<String> EstudiantesPorCurso(String nombre){
        idEstudiantes = new ArrayList<Integer>();
        CursoVo curso = FacadeFactory.getInstance().getCursoFacade().findByName(nombre);
        if (curso.getInscripcionesList() != null || curso.getInscripcionesList().isEmpty()){
            for (InscripcionVo inscripcion : curso.getInscripcionesList()){
                idEstudiantes.add(inscripcion.getEstudianteId());
            }
        }
        List<String> nombres = new ArrayList<String>();
        List<EstudianteVo> estudianteVos = FacadeFactory.getInstance().getEstudianteFacade().getList();
        if (estudianteVos != null){
            for(Integer idEstudiante : idEstudiantes){
                    for (EstudianteVo estudianteVo : estudianteVos){
                        if(idEstudiante == estudianteVo.getId()){
                            nombres.add(estudianteVo.getNombre());
                        }
                    }    
            }
        }
        return nombres;
    }

    public static String validateCost(String str) {
        if (str.length() == 0) {
            return "¡El costo debe ser mayor a $0!";
        }
        Integer id = Integer.parseInt(str);
        if (id < 30000 || id > 500000) {
            return "¡El costo debe estar entre $30000 y $500000¡";
        }
        return "Validado";
    }
}
