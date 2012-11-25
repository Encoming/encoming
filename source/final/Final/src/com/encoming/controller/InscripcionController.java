/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.businesslogic.facade.InscripcionFacade;
import com.encoming.utils.DataBaseException;
import com.encoming.utils.NoActivoException;
import com.encoming.utils.NoPrerrequisitosException;
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

    public void inscribirEstudiante(String nombreEstudiante, String nombreMateria)throws NoActivoException{
        EstudianteVo estudianteVo = FacadeFactory.getInstance().getEstudianteFacade().findByName(nombreEstudiante);
        if (!estudianteVo.getActivo()) {
            throw new NoActivoException("El estudiante no esta activo");
        }
        CursoVo cursoVo = FacadeFactory.getInstance().getCursoFacade().findByName(nombreMateria);
        System.out.println(cursoVo);
        InscripcionVo inscripcionVo = new InscripcionVo();

        inscripcionVo.setEstado("Inscrito");
        inscripcionVo.setEstudianteId(estudianteVo.getId());
        inscripcionVo.setCursoId(cursoVo.getId());
        inscripcionVo.setValorPagado(cursoVo.getValorCurso());

        InscripcionFacade inscripcionFacade = FacadeFactory.getInstance().getInscripcionFacade();
        try {
            boolean cumplePrerequisitos = inscripcionFacade.estudianteCumplePreRequisitos(estudianteVo.getId(), cursoVo.getPrerequisitoCursoId());
            if (cumplePrerequisitos==false) {
                throw new NoPrerrequisitosException("No se cumplen con los prerequisitos");
            }
            inscripcionFacade.create(inscripcionVo);
        } catch (NoPrerrequisitosException ex) {
            Logger.getLogger(InscripcionController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (DataBaseException ex) {
            Logger.getLogger(InscripcionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public InscripcionVo getInscripcionVo(String nombreEstudiante, String nombreMateria) {
        EstudianteVo estudianteVo = FacadeFactory.getInstance().getEstudianteFacade().findByName(nombreEstudiante);
        CursoVo cursoVo = FacadeFactory.getInstance().getCursoFacade().findByName(nombreMateria);

        System.out.println(cursoVo);
        System.out.println(estudianteVo);

        InscripcionVo inscripcionVo = new InscripcionVo();

        inscripcionVo.setEstado("Inscrito");
        inscripcionVo.setEstudianteId(estudianteVo.getId());
        inscripcionVo.setCursoId(cursoVo.getId());
        inscripcionVo.setValorPagado(cursoVo.getValorCurso());

        return inscripcionVo;
    }

    public String getNameStudentFromInscription(InscripcionVo inscripcionVo) {
        EstudianteVo estudianteVo = FacadeFactory.getInstance().getEstudianteFacade().findById(inscripcionVo.getEstudianteId());
        return estudianteVo.getNombre();
    }

    public String getNameCourseFromInscription(InscripcionVo inscripcionVo) {
        CursoVo cursoVo = FacadeFactory.getInstance().getCursoFacade().findById(inscripcionVo.getCursoId());
        return cursoVo.getNombre();
    }

    private boolean cumplePreRequisitos(EstudianteVo estudianteVo, CursoVo cursoVo) {
        InscripcionFacade inscripcionFacade = FacadeFactory.getInstance().getInscripcionFacade();
        return inscripcionFacade.estudianteCumplePreRequisitos(estudianteVo,cursoVo);
    }
}
