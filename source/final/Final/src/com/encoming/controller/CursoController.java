/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.CursoFacade;
import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.utils.DataBaseException;
import com.encoming.utils.ExisteCursoException;
import com.encoming.vo.CursoVo;
import com.encoming.vo.EstudianteVo;
import com.encoming.vo.InscripcionVo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class CursoController { 
    
    public List<Integer> idEstudiantes = new ArrayList<Integer>();
            
    public static String validateName(String text) {
        int a = text.length();
        if (a<4 || a>15) {
            return "La longitud del nombre debe estar entre 4 y 15";
        }
        return "Validado";
    }
    
    public void crearCurso(String nombre, int idPrerequisito, long valor) throws ExisteCursoException{
        CursoVo cursoVo = new CursoVo();
        cursoVo.setNombre(nombre);
        cursoVo.setPrerequisitoCursoId(idPrerequisito);
        cursoVo.setValorCurso(valor);
        CursoFacade cursoFacade = FacadeFactory.getInstance().getCursoFacade();
        try {
            cursoFacade.create(cursoVo);
        } catch (DataBaseException ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object[] getCursosNames(){
        List<String> nombres = new ArrayList<String>();
        List<CursoVo> cursoVos=FacadeFactory.getInstance().getCursoFacade().getList();
        if (cursoVos !=null){
            for(CursoVo cursoVo:cursoVos){
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

    
}
