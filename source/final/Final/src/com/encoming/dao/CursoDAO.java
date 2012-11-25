/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.dao;

import com.encoming.entity.Cursos;
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
public class CursoDAO implements IDAO<Cursos> {

    private static CursoDAO instance;

    private CursoDAO() {
    }

    public static synchronized CursoDAO getInstance() {
        if (instance == null) {
            instance = new CursoDAO();
        }
        return instance;
    }

    @Override
    public void persist(Cursos entity, EntityManager em) {
        em.persist(entity);
    }

    @Override
    public Cursos find(Object id, EntityManager em) {
        Query q = em.createNamedQuery("Cursos.findById").setParameter("id", id);
        return (Cursos)q.getSingleResult();
    }

    @Override
    public void update(Cursos entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        
        Cursos curso = find(id, em);
        em.remove(curso);
    }

    @Override
    public List<Cursos> getList(EntityManager em) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cursos.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    public Cursos findByName(String nombreMateria, EntityManager em) {
        Cursos curso;
        Query q = em.createQuery("SELECT c FROM Cursos c WHERE c.nombre LIKE :nombre").
                setParameter("nombre", nombreMateria);

        try {
            curso = (Cursos) q.getSingleResult();
        } catch (Exception e) {
            curso = new Cursos();
        }
        return curso;
    }

    public Cursos findById(Integer cursoId, EntityManager em) {
        Cursos curso;
        Query q = em.createQuery("SELECT c FROM Cursos c WHERE c.id LIKE :id").
                //setParameter("nombre", nombreEstudiante);
                setParameter("id", cursoId+"");
        try {
            curso = (Cursos) q.getSingleResult();
            System.out.println("student = "+curso);
        } catch (NonUniqueResultException e) {
            curso = (Cursos) q.getResultList().get(0);
        } catch (NoResultException e) {
            curso = null;
        }
        return curso;
    }
}
