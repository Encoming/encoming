/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.dao;

import com.encoming.entity.Cursos;
import java.util.List;
import javax.persistence.EntityManager;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cursos find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Cursos entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Cursos> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
