/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.dao;

import com.encoming.entity.Inscripciones;
import java.util.List;
import javax.persistence.EntityManager;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Inscripciones find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    
}
