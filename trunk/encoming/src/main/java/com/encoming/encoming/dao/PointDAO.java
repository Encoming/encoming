/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Point;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class PointDAO implements IDAO<Point> {

    private static PointDAO instance;

    public static synchronized PointDAO getInstance() {
        if (instance == null) {
            instance = new PointDAO();
        }
        return instance;
    }

    @Override
    public void persist(Point entity, EntityManager em) {
        em.persist(entity);
    }

    @Override
    public Point find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Point entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Point> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
