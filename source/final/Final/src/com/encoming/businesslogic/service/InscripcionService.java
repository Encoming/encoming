/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.service;

import com.encoming.dao.CursoDAO;
import com.encoming.dao.DAOFactory;
import com.encoming.dao.EstudianteDAO;
import com.encoming.dao.InscripcionDAO;
import com.encoming.entity.Cursos;
import com.encoming.entity.Estudiantes;
import com.encoming.entity.Inscripciones;
import com.encoming.vo.CursoVo;
import com.encoming.vo.EstudianteVo;
import com.encoming.vo.InscripcionVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class InscripcionService implements IService<InscripcionVo> {

    private static InscripcionService instance;

    private InscripcionService() {
    }

    public static synchronized InscripcionService getInstance() {
        if (instance == null) {
            instance = new InscripcionService();
        }
        return instance;
    }

    @Override
    public void create(InscripcionVo vo, EntityManager em) {
        Inscripciones inscripcion = new Inscripciones();
        inscripcion.setCursoId(DAOFactory.getInstance().getCursoDAO().find(vo.getCursoId(), em));
        inscripcion.setEstado(vo.getEstado());
        inscripcion.setEstudianteId(DAOFactory.getInstance().getEstudianteDAO().find(vo.getEstudianteId(), em));
        inscripcion.setValorPagado(vo.getValorPagado());

        DAOFactory.getInstance().getInscripcionDAO().persist(inscripcion, em);
    }

    @Override
    public InscripcionVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(InscripcionVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<InscripcionVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void inscribirEstudiante(String nombreEstudiante, String nombreMateria, EntityManager em) {
        EstudianteDAO estudianteDAO = DAOFactory.getInstance().getEstudianteDAO();
        Estudiantes estudiantes = estudianteDAO.findByName(nombreEstudiante, em);

        CursoDAO cursoDAO = DAOFactory.getInstance().getCursoDAO();
        Cursos curso = cursoDAO.findByName(nombreMateria, em);

        Inscripciones inscripcion = new Inscripciones();
        inscripcion.setEstudianteId(estudiantes);
        inscripcion.setCursoId(curso);
        inscripcion.setValorPagado(curso.getValorCurso());
        inscripcion.setEstado("Inscrito");

        InscripcionDAO inscripcionDAO = DAOFactory.getInstance().getInscripcionDAO();
        inscripcionDAO.persist(inscripcion, em);
    }

    public boolean estudianteCumplePreRequisitos(EstudianteVo estudianteVo, CursoVo cursoVo, EntityManager em) {
        CursoDAO cursoDAO = DAOFactory.getInstance().getCursoDAO();
        Cursos curso = cursoDAO.find(cursoVo.getId(), em);

        EstudianteDAO estudianteDAO = DAOFactory.getInstance().getEstudianteDAO();
        Estudiantes estudiante = estudianteDAO.find(estudianteVo.getId(), em);

//        List<Estudiantes> students = curso.getInscripcionesList();
//
//        for (Student student1 : students) {
//            if (estudiante.getId() == student1.getId()) {
//                return true;
//            }
//        }
        return false;
    }

    public boolean estudianteCumplePreRequisitos(Integer estudianteId, Integer prerequisitoCursoId, EntityManager em) {

        if (prerequisitoCursoId == null) {
            return true;
        } else {
            return DAOFactory.getInstance().getInscripcionDAO().isStudentSubscribed(estudianteId, prerequisitoCursoId, em);
        }
    }
}
