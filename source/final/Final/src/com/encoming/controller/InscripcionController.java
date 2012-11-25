/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.businesslogic.facade.InscripcionFacade;
import com.encoming.utils.DataBaseException;
import com.encoming.vo.CursoVo;
import com.encoming.vo.EstudianteVo;
import com.encoming.vo.InscripcionVo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class InscripcionController {
    public void inscribirEstudiante(String nombreEstudiante,String nombreMateria){
        //FacadeFactory.getInstance().getInscripcionFacade().inscribirEstudiante(nombreEstudiante, nombreMateria);
        EstudianteVo estudianteVo = FacadeFactory.getInstance().getEstudianteFacade().findByName(nombreEstudiante);
        CursoVo cursoVo = FacadeFactory.getInstance().getCursoFacade().findByName(nombreMateria);
        System.out.println("Nombre = "+nombreEstudiante);
        
        System.out.println(cursoVo);
        System.out.println(estudianteVo);
        
        InscripcionVo inscripcionVo = new InscripcionVo();
        
        inscripcionVo.setEstado("Inscrito");
        inscripcionVo.setEstudianteId(estudianteVo.getId());
        inscripcionVo.setCursoId(cursoVo.getId());
        inscripcionVo.setValorPagado(cursoVo.getValorCurso());
        
        InscripcionFacade inscripcionFacade = FacadeFactory.getInstance().getInscripcionFacade();
        try {
            inscripcionFacade.create(inscripcionVo);
        } catch (DataBaseException ex) {
            Logger.getLogger(InscripcionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
