/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.dao;

import com.encoming.entity.Cursos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
        em.persist(em);
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
        Query query = em.createNamedQuery("Cursos.findAll");
        return (List<Cursos>)query.getSingleResult();
    }
}
