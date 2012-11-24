/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.CursoFacade;
import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.entity.Cursos;
import com.encoming.utils.DataBaseException;
import com.encoming.utils.ExisteCursoException;
import com.encoming.vo.CursoVo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

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
    
}
