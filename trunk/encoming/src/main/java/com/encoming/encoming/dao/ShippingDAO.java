/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Shipping;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Andrezz
 */
public class ShippingDAO implements IDAO<Shipping> {

    private static ShippingDAO instance;

    public static synchronized ShippingDAO getInstance() {
        if (instance == null) {
            instance = new ShippingDAO();
        }
        return instance;
    }

    @Override
    public void persist(Shipping entity, EntityManager em) {
        try {
            em.persist(entity);
        } catch (Exception e) {
        }
    }

    @Override
    public Shipping find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        javax.persistence.Query query = em.createQuery("SELECT shi FROM Shipping shi "
                + "WHERE shi.idShipping =:idShipping")
                .setParameter("idShipping", id);
        return (Shipping) query.getSingleResult();
    }
    
    public Integer finMaxIdShipping(EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT Max(s.idShipping) FROM Shipping s");
        return (Integer)query.getSingleResult();
    }

    @Override
    public void update(Shipping entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Shipping> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
