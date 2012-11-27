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
import javax.persistence.NoResultException;
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
        em.persist(entity);
    }    
    
    @Override
    public Route find(Object id, EntityManager em) {
        Query query = em.createNamedQuery("Route.findByIdRoute")
                .setParameter("idRoute", id);
        return (Route) query.getSingleResult();

    }
    
    public Integer findIdRoute(Object originCity, Object destinationCity, EntityManager em) {
        try {
            javax.persistence.Query query = em.createQuery("SELECT r.idRoute FROM Route r"
                    + " WHERE r.originPoint.idPoint=:originCity AND r.destinationPoint.idPoint=:destinationCity")
                    .setParameter("originCity", originCity).setParameter("destinationCity", destinationCity);
            return (Integer) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Integer findNewIdRoute(EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT Max(r.idRoute) FROM Route r");
        return (Integer)query.getSingleResult();
    }

    @Override
    public void update(Route entity, EntityManager em) {
        em.merge(entity);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Route> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateKm(Integer idRoute, double numberKilometres, EntityManager em) {
        em.createQuery("UPDATE Route r SET r.numberKilometers = :numberKilometres WHERE r.idRoute = :idRoute")
                .setParameter("idRoute", idRoute)
                .setParameter("numberKilometres", numberKilometres)
                .executeUpdate();
    }

    public Double findKm(EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT r.numberKilometers FROM Route r WHERE Route.idRoute=:idRoute");
        return (Double)query.getSingleResult();
    }
}
