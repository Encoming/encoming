/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Encoming;
import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;

/**
 *
 * @author Andrezz
 */
public class EncomingDAO implements IDAO<Encoming>{
    
    private static EncomingDAO instance;
    
    public static synchronized EncomingDAO getInstance() {
        if (instance == null) {
            instance = new EncomingDAO();
        }
        return instance;
    }

    @Override
    public void persist(Encoming entity, EntityManager em) {
        try {
            em.persist(entity);
        } catch (Exception e) {
            
        }
    }

    @Override
    public Encoming find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        javax.persistence.Query query = em.createNamedQuery("Encoming.findByIdPackage")
                .setParameter("idPackage", id);
        return (Encoming)query.getSingleResult();
    }

    public Integer finMaxIdEncoming (EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT Max(e.idEncoming) FROM Encoming e");
        return (Integer)query.getSingleResult();
    }
    
    @Override
    public void update(Encoming entity, EntityManager em) {
        em.merge(entity);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        Encoming encoming = find(id,em);
        em.remove(encoming);
    }

    @Override
    public List<Encoming> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    
}
