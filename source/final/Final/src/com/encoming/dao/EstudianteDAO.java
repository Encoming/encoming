/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.dao;

import com.encoming.entity.Estudiantes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class EstudianteDAO implements IDAO<Estudiantes> {

    private static EstudianteDAO instance;

    private EstudianteDAO() {
    }

    public static synchronized EstudianteDAO getInstance() {
        if (instance == null) {
            instance = new EstudianteDAO();
        }
        return instance;
    }

    @Override
    public void persist(Estudiantes entity, EntityManager em) {
        em.persist(entity);
    }

    @Override
    public Estudiantes find(Object id, EntityManager em) {
        return (Estudiantes) em.find(Estudiantes.class, id);
    }

    @Override
    public void update(Estudiantes entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Estudiantes> getList(EntityManager em) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Estudiantes.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    public Estudiantes findByDocument(String documento, EntityManager em) {
        Estudiantes student;
        Query q = em.createQuery("SELECT t FROM Estudiantes t WHERE t.documento LIKE :documento").
                setParameter("documento", documento);

        try {
            student = (Estudiantes) q.getSingleResult();
        } catch (Exception e) {
            student = new Estudiantes();
        }
        return student;
    }

    public Estudiantes findByName(String nombreEstudiante, EntityManager em) {
        Estudiantes student;
        Query q = em.createQuery("SELECT t FROM Estudiantes t WHERE t.nombre LIKE :nombre").
                //setParameter("nombre", nombreEstudiante);
                setParameter("nombre", nombreEstudiante);
        try {
            student = (Estudiantes) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            student = (Estudiantes) q.getResultList().get(0);
        } catch (NoResultException e) {
            student = null;
        }
        return student;
    }

    public Estudiantes findById(Integer estudianteId, EntityManager em) {
        Estudiantes student;
        Query q = em.createQuery("SELECT t FROM Estudiantes t WHERE t.id LIKE :id").
                //setParameter("nombre", nombreEstudiante);
                setParameter("id", estudianteId+"");
        try {
            student = (Estudiantes) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            student = (Estudiantes) q.getResultList().get(0);
        } catch (NoResultException e) {
            student = null;
        }
        return student;
    }
}
