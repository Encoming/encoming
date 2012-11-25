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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class CursoController {       

    public static String validateName(String text) {
        int a = text.length();
        if (a<4 || a>15) {
            return "La longitud del nombre debe estar entre 4 y 15";
        }
        return "Validado";
    }
    
    public void crearCurso(String nombre, String prerequisito, long valor) throws ExisteCursoException{
        CursoVo prerequisitos=FacadeFactory.getInstance().getCursoFacade().findByName(prerequisito);
        System.out.println("Prereq = "+prerequisito);
        
        CursoVo cursoVo = new CursoVo();
        cursoVo.setNombre(nombre);
        cursoVo.setPrerequisitoCursoId(prerequisitos.getId());
        cursoVo.setValorCurso(valor);
        System.out.println("Curso = "+cursoVo);
        CursoFacade cursoFacade = FacadeFactory.getInstance().getCursoFacade();
        
        cursoFacade.create1(cursoVo);
        
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
