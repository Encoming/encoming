/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Administrator;
import com.encoming.encoming.entity.Encoming;
import com.encoming.encoming.entity.Route;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andrezz
 */
public class RouteDAO implements IDAO<Route> {

    private static RouteDAO instance;

    public static synchronized RouteDAO getInstance() {
        if (instance == null) {
            instance = new RouteDAO();
        }
        return instance;
    }

    @Override
    public void persist(Route entity, EntityManager em) {
//        try {
            em.persist(entity);
//        } catch (Exception e) {
//        }
    }

    @Override
    public Route find(Object id, EntityManager em) {
        Query query = em.createNamedQuery("Route.findByIdRoute")
                .setParameter("idRoute", id);
        return (Route) query.getSingleResult();

    }
    
    public Integer findIdRoute(String originCity, String destinationCity, EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT r.idRoute FROM Route r"
                + " WHERE r.originCity=:originCity AND r.destinationCity=:destinationCity")
                .setParameter("originCity", originCity).setParameter("destinationCity", destinationCity);
        return (Integer)query.getSingleResult();
    }

    @Override
    public void update(Route entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Route> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
