/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.dao;

import com.encoming.entity.Estudiantes;
import java.util.List;
import javax.persistence.EntityManager;

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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
