/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.CursoFacade;
import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.entity.Cursos;
import com.encoming.utils.ExisteCursoException;
import com.encoming.vo.CursoVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andres
 */
public class CursoController {       
    
    public void crearCurso(String nombre, int idPrerequisito, long valor) throws ExisteCursoException{
        CursoVo cursoVo = new CursoVo();
        cursoVo.setNombre(nombre);
        cursoVo.setPrerequisitoCursoId(idPrerequisito);
        cursoVo.setValorCurso(valor);
        CursoFacade cursoFacade = FacadeFactory.getInstance().getCursoFacade();
        cursoFacade.create(cursoVo);
    } 
}
