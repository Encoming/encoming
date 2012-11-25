/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.dao;

import com.encoming.entity.Cursos;
import com.encoming.entity.Estudiantes;
import com.encoming.entity.Inscripciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class InscripcionDAO implements IDAO<Inscripciones> {

    private static InscripcionDAO instance;

    private InscripcionDAO() {
    }

    public static synchronized InscripcionDAO getInstance() {
        if (instance == null) {
            instance = new InscripcionDAO();
        }
        return instance;
    }

    @Override
    public void persist(Inscripciones entity, EntityManager em) {
        em.persist(entity);
    }

    @Override
    public Inscripciones find(Object id, EntityManager em) {
        return (Inscripciones) em.find(Inscripciones.class, id);
    }

    @Override
    public void update(Inscripciones entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Inscripciones> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isStudentSubscribed(Integer estudianteId, Integer prerequisitoCursoId, EntityManager em) {
        Inscripciones inscripcion;
        Estudiantes estudiante = DAOFactory.getInstance().getEstudianteDAO().findById(estudianteId, em);
        Cursos prerequisito = DAOFactory.getInstance().getCursoDAO().findById(prerequisitoCursoId, em);
        Query q = em.createQuery("SELECT c FROM Inscripciones c WHERE c.estudianteId =:eid AND c.cursoId =:prerequisitoCursoId")
                .setParameter("eid", estudiante)
                .setParameter("prerequisitoCursoId", prerequisito);
        try {
            inscripcion = (Inscripciones) q.getSingleResult();
            return true;
        } catch (NonUniqueResultException e) {
            inscripcion = (Inscripciones) q.getResultList().get(0);
            return true;
        } catch (NoResultException e) {
            inscripcion = null;
            return false;
        }
    }

    public Inscripciones findSubscriptionByStudentAndCourse(Integer estudianteId, Integer cursoId, EntityManager em) {
        Inscripciones inscripcion;
        Estudiantes estudiante = DAOFactory.getInstance().getEstudianteDAO().findById(estudianteId, em);
        Cursos prerequisito = DAOFactory.getInstance().getCursoDAO().findById(cursoId, em);
        Query q = em.createQuery("SELECT c FROM Inscripciones c WHERE c.estudianteId =:eid AND c.cursoId =:prerequisitoCursoId")
                .setParameter("eid", estudiante)
                .setParameter("prerequisitoCursoId", prerequisito);
        try {
            return inscripcion = (Inscripciones) q.getSingleResult();
            
        } catch (NonUniqueResultException e) {
            return inscripcion = (Inscripciones) q.getResultList().get(0);
            
        } catch (NoResultException e) {
            return inscripcion = null;
        }
    }
}
