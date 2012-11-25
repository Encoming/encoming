/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.CursoFacade;
import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.utils.ExisteCursoException;
import com.encoming.vo.CursoVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andres
 */
public class CursoController {       

    public static String validateName(String text) {
        int a = text.length();
        if (a<4 || a>25) {
            return "La longitud del nombre debe estar entre 4 y 15";
        }
        return "Validado";
    }
    
    public void crearCurso(String nombre, String prerequisito, long valor) throws ExisteCursoException{
        if (FacadeFactory.getInstance().getCursoFacade().findByName(nombre)==null) {
            CursoVo prerequisitos = FacadeFactory.getInstance().getCursoFacade().findByName(prerequisito);
            System.out.println("Prereq = " + prerequisitos);
            
            CursoVo cursoVo = new CursoVo();
            cursoVo.setNombre(nombre);
            try {
                cursoVo.setPrerequisitoCursoId(prerequisitos.getId());
            } catch (NullPointerException e) {
            }
            cursoVo.setValorCurso(valor);
            System.out.println("Curso = " + cursoVo);
            CursoFacade cursoFacade = FacadeFactory.getInstance().getCursoFacade();
            
            cursoFacade.create1(cursoVo);
        } else {
            throw new ExisteCursoException("Ya existe el curso");
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
    
}
